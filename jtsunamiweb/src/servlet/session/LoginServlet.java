package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ResourceBundle;

import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import eis.EipConsumeServicioElement;
import eis.EipConsumeServicioResponseElement;
import eis.EipConsumeServicio_Out;
import eis.Eis_PortType;
import eis.Eis_ServiceLocator;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get request parameters for userID and password
		String user = request.getParameter("j_username");
		String pwd = request.getParameter("j_password");
		EipConsumeServicio_Out cs = new EipConsumeServicio_Out();
		
		ResourceBundle parmetros =ResourceBundle.getBundle("parametros.mensajes");
		
		String dsId = null;			
		BigDecimal pnIdServicioInformacion = null;
		
		String dsId2 = null;			
		BigDecimal pnIdServicioInformacion2 = null;
		String separadorInfo = null;
		
		
		dsId = parmetros.getString("mensajes.eis.login.dsId").trim();
		pnIdServicioInformacion = new BigDecimal(parmetros.getString("mensajes.eis.login.pnIdServicioInformacion").trim());
		
	
		dsId2 = parmetros.getString("mensajes.eis.info.dsId").trim();
		pnIdServicioInformacion2 = new BigDecimal(parmetros.getString("mensajes.eis.info.pnIdServicioInformacion").trim());
		separadorInfo =  parmetros.getString("mensajes.eis.info.separadorInfo").trim();
		
		
		/*dsId = "jdbc/ideasdesa";			
		pnIdServicioInformacion = new BigDecimal("4");*/
		
		ServicioInformacion si = new ServicioInformacion();
		ServicioInformacion si2 = new ServicioInformacion();
		
		cs = si.ejecutaServicioInformacion(dsId, 
									  pnIdServicioInformacion, 
									  user, 
									  pwd, 
									  "?", 
									  "?", 
									  "?");
		
		
		if(cs.getPvresultadoOut() == null){
			response.sendRedirect(request.getContextPath());
			return;
		}


		
		if((cs.getPvresultadoOut().equals("1"))){
			
			Cookie loginCookie = new Cookie("user",user);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);	
			request.getSession().setAttribute("usuario", user);
			request.getSession().setAttribute("password", pwd);
			
			cs = si2.ejecutaServicioInformacion(dsId2, 
					  pnIdServicioInformacion2, 
					  user, 
					  "?", 
					  "?", 
					  "?", 
					  "?");
			
			
			String[] infoAdicional = cs.getPvresultadoOut().split("\\"+separadorInfo);
			
			if(infoAdicional.length == 1){
				request.getSession().setAttribute("idCorporate", infoAdicional[0]);
				
			}else if (infoAdicional.length >= 2){
				request.getSession().setAttribute("idCorporate", infoAdicional[0]);
				request.getSession().setAttribute("idShortCode", infoAdicional[1]);
			}else{
				request.getSession().setAttribute("idCorporate", null);
				request.getSession().setAttribute("idShortCode", null);
			}
		
			response.sendRedirect("enviar.htm");
			return;
			
	}else{
			
			response.sendRedirect("loginFallido.htm");
			return;
			//RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginFallido.htm");			
			//rd.include(request, response);
			
			
		}

	}

}
