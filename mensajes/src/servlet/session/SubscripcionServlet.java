package servlet.session;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eis.EipConsumeServicio_Out;

/**
 * Servlet implementation class SubscripcionServlet
 */
public class SubscripcionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscripcionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mensaje = (String)request.getSession().getAttribute("mensaje");
		if(mensaje==null){
			mensaje="";
		}
		//LLAMAR AL WEBSERVICE QUE DEVUELVE TODOS LOS NUMEROS
		String usuario = (String) request.getSession().getAttribute("usuario");
		String clave = (String) request.getSession().getAttribute("password");
		
		EipConsumeServicio_Out cs = new EipConsumeServicio_Out();
		
		ResourceBundle parmetros =ResourceBundle.getBundle("parametros.mensajes");
		
		String dsId = null;			
		BigDecimal pnIdServicioInformacion = null;
		String pvParametroBind3 = null;
		String separadorTelefonos = null;
		String cargaTelefonoError = null;
		
		
		dsId = parmetros.getString("mensajes.eis.telefonos.dsId").trim();
		pnIdServicioInformacion = new BigDecimal(parmetros.getString("mensajes.eis.telefonos.pnIdServicioInformacion").trim());
		pvParametroBind3 = parmetros.getString("mensajes.eis.telefonos.pvParametroBind3").trim();
		separadorTelefonos = parmetros.getString("mensajes.eis.telefonos.separador").trim(); 
		cargaTelefonoError = parmetros.getString("mensajes.eis.telefonos.carga");
	
		/*dsId = "jdbc/ideasdesa";			
		pnIdServicioInformacion = new BigDecimal("3");*/
		
		ServicioInformacion si = new ServicioInformacion();
		
		cs = si.ejecutaServicioInformacion(dsId, 
									  pnIdServicioInformacion, 
									  usuario, 
									  clave, 
									  pvParametroBind3, 
									  "?", 
									  "?");
		
		
		

		
		
		//System.out.println("Usuario: " + usuario + " Password: " + clave);
		
		
		
		response.setContentType("text/html");  		
		/*response.getWriter().write("<h3>Buscar:<input type=\"text\" name=\"search\" value=\"\" onkeyup=\"javascript:searchSub(this.value);\"/></h3>"); 
		*/response.getWriter().write("<table cellspacing=\"20\">");
			response.getWriter().write("<tbody>");	
				response.getWriter().write("<tr>");	
					response.getWriter().write("<td width=\"30%\">");	
						response.getWriter().write("Celulares de la Cuenta:<br />");							
						response.getWriter().write("<select id=\"msisdn\"  name=\"msisdn\" multiple=\"multiple\" size=\"10\">");	
						
							
						if(cs.getPverrorOut() != null){
							System.out.println("ERROR EIS-->" + cs.getPverrorOut() );
							
							if(cargaTelefonoError != null){
								if(cargaTelefonoError.equals("")){
									mensaje = cs.getPverrorOut();
								}else{
									mensaje = cargaTelefonoError;
								}
							}
							
							
							
						}
							
							
							
						if(cs.getPvresultadoOut() != null ){
									
									String[] numeros = cs.getPvresultadoOut().split("\\"+separadorTelefonos);
						
						
						
									request.getSession().setAttribute("cantidadNumeros", numeros.length);
									
									System.out.println("CANTIDAD DE NUMEROS " + numeros.length);
									
									for (int i = 0; i < numeros.length; i++) {
										if(!numeros[i].equals("")){
											response.getWriter().write("<option value=\""+numeros[i]+"\">"+numeros[i]+"</option>");
										}
									}
								}
						
							

							
						response.getWriter().write("</select>");	
					response.getWriter().write("</td>");	
					response.getWriter().write("<td align=\"center\">");	
						response.getWriter().write("<input type=\"button\" value=\"&gt;&gt;\" onclick=\"addMsisdn('msisdn', 'msisdnSelected');\"/><br/>");	
						response.getWriter().write("<input type=\"button\" value=\"&lt;&lt;\" onclick=\"addMsisdn('msisdnSelected', 'msisdn');\"/><br/>");	
						response.getWriter().write("<input type=\"button\" value=\"TODOS\" onclick=\"addAllMsisdn('msisdn', 'msisdnSelected');\"/>");	
					response.getWriter().write("</td>");	
					response.getWriter().write("<td>");	
						response.getWriter().write("Celulares Receptores:<br />");	
						response.getWriter().write("<select id=\"msisdnSelected\" name=\"msisdnSelected\" multiple=\"multiple\" size=\"10\"></select>");	
					response.getWriter().write("</td>");					
					response.getWriter().write("</tr>");	/*
				
				response.getWriter().write("<tr>");	
					response.getWriter().write("<td colspan=\"3\">Paso 2. Adicionalmente puedes selecciona el grupo o los grupos que requieras se envíe el mensaje.</td>");	
				response.getWriter().write("</tr>");	
			
				response.getWriter().write("<tr>");	
					response.getWriter().write("<td valign=\"top\">");									
						response.getWriter().write("Grupos:");	
						response.getWriter().write("<table>");	
							response.getWriter().write("<tbody>");	
								response.getWriter().write("<tr>");	
									response.getWriter().write("<td>");	
										response.getWriter().write("<select name=\"selectedGroups\" multiple=\"multiple\" size=\"8\">");	
											response.getWriter().write("<option value=\"719gb989e01\">prueba</option>");	
											response.getWriter().write("<option value=\"71a2511b1d1\">prueba_claro</option>");	
										response.getWriter().write("</select>");	
									response.getWriter().write("</td>");	
								response.getWriter().write("</tr>");	
							response.getWriter().write("</tbody>");	
						response.getWriter().write("</table>");												
					response.getWriter().write("</td>");	
				response.getWriter().write("</tr>");	
				*/
			
				
					/*	response.getWriter().write("<tr>");	
					response.getWriter().write("<td colspan=\"3\">Paso 2. Escribe el mensaje que quieras enviar a los celulares de cuenta. El mensaje no puede exceder los 160 caracteres.</td>");	
				response.getWriter().write("</tr>");	

				response.getWriter().write("<tr>");	
					response.getWriter().write("<td colspan=\"3\">");			    
			    		response.getWriter().write("<span><em  style=\"color:red\">"+mensaje+"</em></span>");	
					response.getWriter().write("</td>");	
				response.getWriter().write("</tr>");	
				response.getWriter().write("<tr>");	
					response.getWriter().write("<td colspan=\"3\">");	
						response.getWriter().write("Mensaje:<br />");	
						response.getWriter().write("<textarea name=\"message\" cols=\"40\" rows=\"5\" onkeyup=\"countMessage(&#39;inputText&#39;,&#39;outputText&#39;,&#39;Caracteres disponibles: {CHAR}&#39;,160);\" id=\"inputText\"></textarea><br />");	
						response.getWriter().write("<span id=\"outputText\" class=\"limitCharacters\">Caracteres disponibles: 160</span>");	
						response.getWriter().write("<br /><br />");	
						response.getWriter().write("<input type=\"submit\" onclick=\"return validarMensaje();\" value=\"Enviar\" class=\"submit\"/>");	
					response.getWriter().write("</td>");	
				response.getWriter().write("</tr>");	*/
			response.getWriter().write("</tbody>");	
		response.getWriter().write("</table>");	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); 
	}

}
