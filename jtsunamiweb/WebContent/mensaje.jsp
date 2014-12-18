<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	String[] dias = {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
	String month = "";
	String day = "";	
	month = meses[Calendar.getInstance().get(Calendar.MONTH)];
	day = dias[Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1];	
	//String username = request.getRemoteUser();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!-- saved from url=(0058)http://192.168.35.47:8080/MEGConsole/do/secure/sendMessage -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
		<script type="text/javascript" src="./porta/functions.js"></script>
		<link rel="stylesheet" href="./porta/style.css" type="text/css"/>
		<title>MEG Servicios SMS</title>
		<script type="text/javascript">
	
			function checarLogin(){
			   
				<%
					
					String userName = null;
					String informacion = null;
					if(request.getSession().getAttribute("usuario")==null){				
						response.sendRedirect(request.getContextPath());
					}else{
						
						response.setHeader("Cache-Control","no-cache");
		  				response.setHeader("Cache-Control","no-store");
		  				response.setHeader("Pragma","no-cache");
		  				response.setDateHeader ("Expires", 0);
					
						
						Cookie[] cookies = request.getCookies();
						if(cookies !=null){
						    	for(int c =0; c< cookies.length; c++ ){
						    		Cookie cookie = cookies[c];
						    		if(cookie.getName().equals("user")) userName = cookie.getValue();
						    	}
						
						}
						if(userName == null){
						
							response.sendRedirect(request.getContextPath());
						} 
					}
					
	
				%>
				
			}
			
			function  validarMensaje(){
			
			  	var element = document.getElementsByName("msisdnSelected")[0];
			  	
			  	//sobreescribir el elemento null que se da al eliminar un elemento
			  	document.forms["sendMessageForm"]["msisdnSelected"].innerHTML=element.innerHTML;
			  	 
			  	 
									
				if(element.options.length == 0){
				    alert("Ingrese en la lista los Celulares Receptores por favor");
					return false;
				}
							
			    var texto = document.getElementById("inputText").value;
			   
				if(texto==""){
				    alert("Ingrese su mensaje por favor");
					return false;
				}
				return true;
			}
			

			
		</script>
		
	</head>
	<body>
		<div class="content">
			<div class="header">
				<!--script type="text/javascript">
					window.onbeforeunload = function () {
						if(window.event.clientY < 0 && (window.event.clientX > (document.documentElement.clientWidth - 50) || window.event.clientX < 40)) { 
				  			window.location = "LogoutServlet";
						}
					}
				</script-->

				<div class="top_info">
				
					<div class="top_info_right">
						<p><b>Bienvenido <%=userName %><br /><a  style="font-size: 25pt;" href="LogoutServlet">Salir</a></b> </p>
					</div>	
						
					<div class="top_info_left">					
						<p><b><%=day%> <%=Calendar.getInstance().get(Calendar.DAY_OF_MONTH)%> <%=month%> <%=Calendar.getInstance().get(Calendar.YEAR)%></b><br /></p>					
					</div>
					
				</div>
				
			<div class="bar">
				<ul> 
					<li class="browse_category"></li> 
					<li><a href="./">Principal</a></li>
					<!--li><a href="http://192.168.35.47:8080/MEGConsole/do/secure/go?to=documents">Documentos</a></li!-->
					<!--li><a href="./mensaje.jsp">Enviar mensajes</a></li-->
					<!--li><a href="http://192.168.35.47:8080/MEGConsole/do/secure/go?to=newGroup">Crear Grupo</a></li-->					 
					<!--li><a href="http://192.168.35.47:8080/MEGConsole/do/secure/loadReportList">Reportes</a></li-->
				</ul>
			</div>
			
			<div class="logo">
				<h1></h1>
			</div>
			
		</div> <!-- fin de la header -->
		
		<em id="cargaDeInfo" >Si la lista de numeros aun no ha cargado, Espere por favor</em>
		
			<form name="sendMessageForm" method="post" action="enviar" enctype="multipart/form-data">
				Archivos a subir
				<br/>
				<input type="file" size="50" name="file1">
				<input type="submit" value="Upload">
		</form>
		
  		<div class="footer">  		
    		<!--p><a href="http://www.speedymovil.com/" title="Cual es tu solucion?">Speedy Movil</a> | <a href="mailto:email@email.com">Contacto</a> | <a href="#">Documentos</a> | <a href="#">Productos</a><br /-->
			Copyright 2010 Speedy Movil<br />
		</div>	
		</div> <!-- fin de content -->
	</body>
</html>