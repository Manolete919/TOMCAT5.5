package servlet.session;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.axis.message.MessageElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import sre.SreReceptaTransaccionElement;
import sre.SreReceptaTransaccionElementParametros_Transaccion;
import sre.SreReceptaTransaccionResponseElement;
import sre.SreReceptaTransaccionResponseElementResult;
import sre.Sre_PortType;
import sre.Sre_ServiceLocator;
import test.TestSRE;
import tsu.MultipartFileUploader;

/**
 * Servlet implementation class AccionServlet
 */
public class AccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccionServlet() {
		super();
		// TODO Auto-generated constructor stub
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public String enviaATodos(String usuario, String clave, String mensaje) {

		String idInstancia = null;
		String idTipoTransaccion = null;
		String idIntegrador = null;
		String codAlternoDistribuidor = null;
		String sreUsuario = null;
		String sreClave = null;
		String dataSource = null;
		String estado = null;
		String mensajeExito = null;
		String mensajeError = null;

		ResourceBundle parmetros = ResourceBundle
				.getBundle("parametros.mensajes");

		idInstancia = parmetros.getString("mensajes.sre.idInstancia").trim();
		idTipoTransaccion = parmetros
				.getString("mensajes.sre.idTipoTransaccion").trim();
		idIntegrador = parmetros.getString("mensajes.sre.idIntegrador").trim();
		codAlternoDistribuidor = parmetros
				.getString("mensajes.sre.codAlternoDistribuidor").trim();
		sreUsuario = parmetros.getString("mensajes.sre.usuario").trim();
		sreClave = parmetros.getString("mensajes.sre.clave").trim();
		dataSource = parmetros.getString("mensajes.sre.dataSource").trim();
		estado = parmetros.getString("mensajes.sre.estado").trim();
		mensajeExito = parmetros.getString("mensajes.mensajeExito").trim();
		mensajeError = parmetros.getString("mensajes.mensajeError").trim();

		/*
		 * idInstancia="6000"; idTipoTransaccion="2000"; idIntegrador="300";
		 * codAlternoDistribuidor="6666"; sreUsuario="WebMeg";
		 * sreClave="01MegWeb"; dataSource="jdbc/ideas"; estado="1";
		 */

		System.out.println(idInstancia);
		System.out.println(idTipoTransaccion);
		System.out.println(idIntegrador);
		System.out.println(codAlternoDistribuidor);
		// System.out.println(sreUsuario);
		// System.out.println(sreClave);
		System.out.println(dataSource);
		System.out.println(estado);

		try {

			Sre_ServiceLocator sl = new Sre_ServiceLocator();

			SreReceptaTransaccionElement parameters = new SreReceptaTransaccionElement();

			SreReceptaTransaccionElementParametros_Transaccion parametros_Transaccion = new SreReceptaTransaccionElementParametros_Transaccion();

			parameters.setId_Instancia(idInstancia);
			parameters.setId_Tipo_Transaccion(idTipoTransaccion);
			parameters.setId_Integrador(idIntegrador);
			parameters.setCod_Alterno_Distribuidor(codAlternoDistribuidor);
			parameters.setUsuario(sreUsuario);
			parameters.setClave(sreClave);
			parameters.setData_Source(dataSource);

			parametros_Transaccion
					.set_any(convertXMLStringtoMessageElement("<parametros>"
							+ "    <MEG_USUARIO>" + usuario + "</MEG_USUARIO>"
							+ "    <MEG_CLAVE>" + clave + "</MEG_CLAVE>"
							+ "    <MEG_ESTADO>" + estado + "</MEG_ESTADO>"
							+ "    <MEG_MENSAJE>" + mensaje + "</MEG_MENSAJE>"
							+ "</parametros>"));

			parameters.setParametros_Transaccion(parametros_Transaccion);

			Sre_PortType pt = sl.getsreSoapHttpPort();

			SreReceptaTransaccionResponseElement resser = pt
					.sreReceptaTransaccion(parameters);

			SreReceptaTransaccionResponseElementResult resultado = resser
					.getResult();

			QName error = new QName("WS_ERROR");

			QName respuestas = new QName("PCK_RESPUESTA");

			System.out.println(" SRE " + resultado.get_any()[0].getName());

			System.out.println(" WS_ERROR "
					+ resultado.get_any()[0].getChildElement(error).getValue());

			MessageElement me = resultado.get_any()[0]
					.getChildElement(respuestas);

			if (me != null) {

				MessageElement me0 = me.getChildElement(new QName("ID_CLASE_SERVICIO"));
				MessageElement me1 = me.getChildElement(new QName(
						"COD_RESPUESTA"));
				MessageElement me2 = me.getChildElement(new QName("MENSAJE"));
				MessageElement me3 = me.getChildElement(new QName(
						"ID_TRANSACCION"));

				String mensajeSRE = ((me2 != null) ? ((me2.getValue() == null) ? mensajeExito
						: me2.getValue())
						: mensajeError);

				System.out.println(" ID_CLASE_SERVICIO "
						+ ((me0 != null) ? me0.getValue() : ""));
				System.out.println(" COD_RESPUESTA "
						+ ((me1 != null) ? me1.getValue() : ""));
				System.out.println(" ID_TRANSACCION "
						+ ((me3 != null) ? me3.getValue() : ""));

				return mensajeSRE;

			}

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		return mensajeError;

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String usuario = (String) request.getSession().getAttribute("usuario");
		String clave = (String) request.getSession().getAttribute("password");
		String idCorporate = (String) request.getSession().getAttribute("idCorporate");
		String idShortCode = (String) request.getSession().getAttribute("idShortCode");
		int cantNumeros = (Integer) request.getSession().getAttribute("cantidadNumeros");

		String mensaje = request.getParameter("message");
		
		System.out.println(" INFO ADICIONAL "  + idCorporate +  " SHORT CODE " + idShortCode);
		
		
		int cantidadNumerosReceptores = Integer.parseInt(request.getParameter("cantNumerosTarget"));
		
		
		System.out.println("CANTIDAD DE NUMEROS RECEPTORES " + cantidadNumerosReceptores);

		String[] telefonosReceptores = request
				.getParameterValues("msisdnSelected");

		String idUsuario = null;
		String claveTjsu = null;
		
		String folderPath = null;
		String eliminarArchivoTemportal;

		ResourceBundle parmetros = ResourceBundle.getBundle("parametros.mensajes");
		idUsuario = parmetros.getString("mensajes.jtsu.idUsuario").trim();
		claveTjsu = parmetros.getString("mensajes.jtsu.clave").trim();
		
		folderPath = parmetros.getString("mensajes.jtsu.folderPath").trim();
		eliminarArchivoTemportal = parmetros.getString("mensajes.jtsu.eliminarArchivoTemportal").trim();
		

		if (cantidadNumerosReceptores == cantNumeros) {

			System.out.println("Enviar por SRE a todos---> "
					+ telefonosReceptores.length + "  telefonos");
			String mensajeSRE = enviaATodos(usuario, clave, mensaje);

			request.getSession().setAttribute("mensaje", mensajeSRE);

			// RequestDispatcher rd =
			// request.getRequestDispatcher("LoginSuccess.jsp");
			// rd.forward(request, response);

		} else {
			
			System.out.println("Enviar por Rest--->"
					+ telefonosReceptores.length + " telefonos");


			// CREAR EL ARCHIVO

			File folder = new File(folderPath);

			if (!folder.exists()) {
				folder = new File(request.getSession().getServletContext().getRealPath("/"));
			}

			TempFilePopulator tfp = new TempFilePopulator(folder);

			log("Temp file '" + tfp + "' created.");

			for (int i = 0; i < telefonosReceptores.length; i++) {

				String linea = telefonosReceptores[i];
				if (i < telefonosReceptores.length - 1) {
					linea = linea + "\r\n";
				}
				tfp.populate(linea);
			}

			MultipartFileUploader mf = new MultipartFileUploader();

			String mensajeREST = mf.uploadFile(tfp.toString(), idUsuario, claveTjsu, idCorporate , mensaje, idShortCode );

			//CONTENIDO DEL ARCHIVO
			/*List<String> lines = tfp.getContent();
			for (String line : lines) {

				System.out.println(line);

			}*/

			// ELIMINAR EL ARCHIVO

			if (eliminarArchivoTemportal == null) {
				eliminarArchivoTemportal = "SI";
			}

			if (eliminarArchivoTemportal.toUpperCase().equals("SI")) {
				if (tfp != null) {
					if (tfp.deleteTempFile()) {
						log("Archivo temporal '" + tfp + "' borrado.");
					} else {
						log("No se ha podido eliminar el archivo temporal '" + tfp + "'");
					}
				}
			}
			
			request.getSession().setAttribute("mensaje", mensajeREST);

			// FIN DE LA CREACION DE ARCHIVO
			
		}

		response.sendRedirect("mensaje.jsp");
	}

	private MessageElement[] convertXMLStringtoMessageElement(String xmlString)
			throws SAXException, IOException, ParserConfigurationException {
		MessageElement[] m = new MessageElement[1];
		Document XMLDoc = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder()
				.parse(new InputSource(new StringReader(xmlString)));
		Element element = XMLDoc.getDocumentElement();
		m[0] = new MessageElement(element);
		return m;
	}

}
