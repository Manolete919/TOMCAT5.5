package servlet.session;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}
	
	private static class TempFilePopulator {

		private File tf = null;

		public TempFilePopulator(File folder) throws IOException {

			tf = File.createTempFile("numeros", ".txt", folder);
		}

		public void populate(String line) throws IOException {
			FileWriter fw = new FileWriter(tf, true);
			fw.write(line /* + "\n" */);
			fw.close();
		}

		public List<String> getContent() throws IOException {
			List<String> lines = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(tf)));
			String line;
			while (null != (line = br.readLine())) {
				lines.add(line);
			}
			br.close();
			return lines;
		}

		public boolean deleteTempFile() {
			return tf.delete();
		}

		public String toString() {
			return tf.getAbsolutePath();
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");



		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			return;
		}
		

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fields = upload.parseRequest(request);
			

			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {
				return;
			}
			
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					
							System.out.println(" FORM FIELD " +
									fileItem.getString());
					
				} else {
			
					System.out.println(" NO FORM FIELD " +
							fileItem.getString()
							);
					
				}
			}
			

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	} 
	
	
	
/*	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("Hello<br/>");

		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			out.println("You are not trying to upload<br/>");
			return;
		}
		out.println("You are trying to upload<br/>");

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fields = upload.parseRequest(request);
			out.println("Number of fields: " + fields.size() + "<br/><br/>");
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {
				out.println("No fields found");
				return;
			}
			out.println("<table border=\"1\">");
			while (it.hasNext()) {
				out.println("<tr>");
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				
				
				
				if (isFormField) {
					out.println("<td>regular form field</td><td>FIELD NAME: " + fileItem.getFieldName() + 
							"<br/>STRING: " + fileItem.getString()
							);
					out.println("</td>");
				} else {
					out.println("<td>file form field</td><td>FIELD NAME: " + fileItem.getFieldName() +
							"<br/>STRING: " + fileItem.getString() +
							"<br/>NAME: " + fileItem.getName() +
							"<br/>CONTENT TYPE: " + fileItem.getContentType() +
							"<br/>SIZE (BYTES): " + fileItem.getSize() +
							"<br/>TO STRING: " + fileItem.toString()
							);
					out.println("</td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	} 
	
	*/
	
	
	
	
	
	
	
	
}