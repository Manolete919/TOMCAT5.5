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
		<script type="text/javascript" src="./scripts/jquery.js"></script>
		<link rel="stylesheet" href="./porta/style.css" type="text/css"/>
		<title>MEG Servicios SMS</title>
		<script type="text/javascript">
		
	
	
			$(document).ready(function (){
				alert("hola listo");
			});
		
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
			  	
			  	var cantNumerosTarget = document.getElementsByName("cantNumerosTarget")[0];
			  	
			  	//preguntar si es todos
			  	cantNumerosTarget.value = element.options.length;
			  	
			  	var cantNumerosCargados = <%=request.getSession().getAttribute("cantidadNumeros")%>;
			  	
			  	
			  	if(cantNumerosTarget.value == 0){
				    alert("Ingrese en la lista los Celulares Receptores por favor");
					return false;
				}
							
			    var texto = document.getElementById("inputText").value;
			   
				if(texto==""){
				    alert("Ingrese su mensaje por favor");
					return false;
				}
			  	
			  				  	
			  	if(cantNumerosCargados==cantNumerosTarget.value){
			  		return true;
			  	}
			  	
			  	
			  	for (var i = 0; i < element.options.length; i++) { 
			  	
			  		if(!element.options[i].selected){
			  			element.options[i].selected = true; 
			  		}
		             
		        } 
			  	
		
				return true;
			}
			

			
		</script>
		
	</head>
	<body onload="loadOnStart();">
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
		
		<em id="cargaDeInfo" style="color:blue;" >Si la lista de numeros aun no ha cargado, Espere por favor</em>
		
		<form name="sendMessageForm" method="post" action="enviar">
			<!--div class="search_field">
				<div class="search_form">
						Productos:
						<select name="selected" onchange="javascript:loadSubscribers(&#39;subs&#39;, this);">
							<option value="1180">500035 - agregado por Claro</option>
							<option value="1181">500036 - agregado por Claro</option>
						</select>					
				</div>
				<br />
			</div-->	
			
			
			<div class="left">
				<div class="left_box">				
					<br />
					<!-- input type="hidden" name="corporateId" value="1240" /-->
					
					<input type="hidden" name="cantNumerosTarget" value="0"/>
					
					
					<h3>Buscar:<input type="text" name="search" value="" onkeydown="if (event.keyCode == 13) { return false;}"  onkeyup="javascript:searchSub(this.value);"/></h3>
					<table cellspacing="20">
						<tbody>
							<tr>
								<td colspan="3">Paso 1. Selecciona los celulares a quienes desees enviar el mensaje.</td>
							</tr>
						</tbody>					
					</table>
					
					<div id="subs"></div>					

					<table cellspacing="20">
						<tbody>
							<tr>
								<td colspan="3">Paso 2. Adicionalmente puedes selecciona el grupo o los grupos que requieras se envie el mensaje</td>
							</tr>
							<tr>
								<td colspan="3">
									<span><em style="color:red"><%= ((request.getSession().getAttribute("mensaje"))==null)?"":request.getSession().getAttribute("mensaje")%></em></span>
								</td>
							</tr>
							<tr>
								<td  colspan="3">Mensaje:<br />
									<textarea name="message" cols="40" rows="5" onkeyup="countMessage(&#39;inputText&#39;,&#39;outputText&#39;,&#39;Caracteres disponibles: {CHAR}&#39;,160);" id="inputText"></textarea><br />
									<span id="outputText" class="limitCharacters">Caracteres disponibles: 160</span>
									<br /> <br />
									<input type="submit" onclick="return validarMensaje();" value="Enviar" class="submit" />	
								</td>
							</tr>
						</tbody>					
					</table>
	
					
					
								
				</div><!-- fin de left_box -->			
			</div><!-- fin de left -->	
			
			
			
		</form>		
		
  		<div class="footer">  		
    		<!--p><a href="http://www.speedymovil.com/" title="Cual es tu solucion?">Speedy Movil</a> | <a href="mailto:email@email.com">Contacto</a> | <a href="#">Documentos</a> | <a href="#">Productos</a><br /-->
			Copyright 2010 Speedy Movil<br />
		</div>	
		</div> <!-- fin de content -->
	</body>
</html>