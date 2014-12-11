package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	Cookie loginCookie = null;
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    		
    	
    	for(int c =0; c< cookies.length; c++ ){
    		Cookie cookie = cookies[c];
    		if(cookie.getName().equals("user")){
    			loginCookie = cookie;
    			break;
    		}
    	}
    
    	}
    	if(loginCookie != null){
    		loginCookie.setMaxAge(0);
        	response.addCookie(loginCookie);
    	}
    	
    	request.getSession().invalidate();
    	request.getSession().removeAttribute("usuario");
    	request.getSession().removeAttribute("password");
    	request.getSession().removeAttribute("mensaje");
    	request.getSession().removeAttribute("cantidadNumeros");
    	request.getSession().removeAttribute("idCorporate");
    	request.getSession().removeAttribute("idShortCode");
		
    	
    	
    	response.sendRedirect(request.getContextPath());
    }

}
