var http = null;
var subs = null;

function createRequestObject() {
	var xmlHttp;
	try {
		xmlHttp=new XMLHttpRequest();
    } catch (e){
		try{
      		xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
      	} catch (e){
			try{
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        	} catch (e){
				alert("Su navegador no soporta AJAX.");
        		return false;
        	}
		}
	}
	return xmlHttp;
}

function searchSub(val) {

	if (val.length < 4)
		return;
	var element = document.getElementsByName('msisdn');
	var children = element[0];
	var i;
	if (subs == null) {
		subs = document.createElement('select');
		for (i = children.length - 1; i >= 0; i--) {
			var opt = document.createElement('option');
		  	opt.text = children[i].text;
		  	opt.value = children[i].value;
			try {
		    	subs.add(opt);
		  	} catch(ex) {
				subs.add(opt);
		  	}
		}
	}
	for (i = children.length - 1; i >= 0; i--) {
		children.remove(i);
	}
	for (i = subs.length - 1; i >= 0; i--) {
		if (subs[i].text.indexOf(val) != -1) {
			var elOptNew = document.createElement('option');
  			elOptNew.text = subs[i].text;
  			elOptNew.value = subs[i].value;
			try {
    			children.add(elOptNew);
  			} catch(ex) {
				children.add(elOptNew);
  			}
		}
	}
	if (children.length == 0) {
		var elOptNew = document.createElement('option');
  		elOptNew.text = "No hay resultados para tu busqueda";
  		elOptNew.value = "";
		try {
    		children.add(elOptNew);
  		} catch(ex) {
			children.add(elOptNew);
  		}
	}
}


function searchSubSubscribe(val) {
	
	if (val.length < 4)
		return;
	var element = document.getElementsByName('selectedNumbers');
	var children = element[0];
	var i;
	if (subs == null) {
		subs = document.createElement('select');
		for (i = children.length - 1; i >= 0; i--) {
			var opt = document.createElement('option');
		  	opt.text = children[i].text;
		  	opt.value = children[i].value;
			try {
		    	subs.add(opt);
		  	} catch(ex) {
				subs.add(opt);
		  	}
		}
	}
	for (i = children.length - 1; i >= 0; i--) {
		children.remove(i);
	}
	for (i = subs.length - 1; i >= 0; i--) {
		if (subs[i].text.indexOf(val) != -1) {
			var elOptNew = document.createElement('option');
  			elOptNew.text = subs[i].text;
  			elOptNew.value = subs[i].value;
			try {
    			children.add(elOptNew);
  			} catch(ex) {
				children.add(elOptNew);
  			}
		}
	}
	if (children.length == 0) {
		var elOptNew = document.createElement('option');
  		elOptNew.text = "No hay resultados para tu busqueda";
  		elOptNew.value = "";
		try {
    		children.add(elOptNew);
  		} catch(ex) {
			children.add(elOptNew);
  		}
	}
}

function loadOnStart(){
	//loadSubscribers('subs',document.getElementsByName("selected")[0]);
	loadSubscribers('subs','1');

}

function loadSubscribers(target, element) {
	/*var opt = element.options[element.selectedIndex];
	var id = opt.value;*/
	
	var id = 1;
	
	var children = document.getElementById(target);
	var wrappingDiv = null;
	var parentElement = null;
	
	if(children.innerHTML !== "") {		
		try {
			children.innerHTML = "";
		} catch (e) {
			wrappingDiv = document.createElement('div');
			wrappingDiv.innerHTML = "";
			children.appendChild(wrappingDiv);
		}
	}
	
	var uri = "loadSubscription?id=" + id;
	if(http === null || !http) {
	   	http = createRequestObject();
	}
	    
	if(http.readyState !== 0) {
		return false;
	}
	http.open("POST", uri, true);
	http.onreadystatechange = function() {
	    if (http.readyState == 4)  {
	    	if (http.status == 200) {
	    		parentElement = document.getElementById(target);
	    		
	    		try {
	    			parentElement.innerHTML = "";
				  	parentElement.innerHTML = http.responseText;
				  	
				} catch (e) {
					wrappingDiv = document.createElement('div');
					wrappingDiv.innerHTML = http.responseText;
					parentElement.appendChild(wrappingDiv);
				}
				var i;
				var element = document.getElementsByName('msisdn');
				subs = null;
				subs = document.createElement('select');
				if (element.length > 0) {
					var child = element[0];
					for (i = child.length - 1; i >= 0; i--) {
						var opt = document.createElement('option');
						opt.text = child[i].text;
						opt.value = child[i].value;
						try {
							subs.add(opt);
						} catch(ex) {
							subs.add(opt);
						}
					}
				}
	            http = null;
	        }
	    } else {
			parentElement = document.getElementById(target);
			try {
				parentElement.innerHTML = "";
				parentElement.innerHTML = '<p style="margin-left:20px;color:green">Cargando subscriptores y grupos...</p>';
			} catch (e) {
				wrappingDiv = document.createElement('div');
				wrappingDiv.innerHTML = "<p left-margin:20px;>Cargando subscriptores y grupos...</p>";
				parentElement.appendChild(wrappingDiv);
			}
		}
	}
	if(http.readyState == 0) {
		http.abort();
   		http = null;
   	}
    http.send(null);
}

function addMsisdn(targetO, targetD) {
	document.getElementsByName('search')[0].value = "";
	var origen = document.getElementsByName(targetO)[0];
	var destino = document.getElementsByName(targetD)[0];
	if (destino.length === 1) {
		if (destino[0].text.indexOf("No hay resultados para tu busqueda") != -1) {
			destino.remove(0);
		}
	}
	for (i = origen.length - 1; i >= 0; i--) {
		if (origen[i].selected) {
			var opt = document.createElement('option');
			var opt1 = document.createElement('option');
			if (targetD.indexOf("msisdnSelected") != -1) {
				opt.setAttribute("selected","selected");
			}
			opt.text = origen[i].text;
			opt.value = origen[i].value;
			opt1.text = origen[i].text;
			opt1.value = origen[i].value;
			try {
			   	destino.add(opt);
			   	if (subs !== null) {
			   		if (targetO.indexOf("msisdnSelected") != -1) {
				   		if (!contains(opt1.text)) {
				   			try {
				   				subs.add(opt1);
				   			} catch (ex1) {
				   				subs.add(opt1);
				   			}
				   		}
			   		} else {
			   			removeSubs(opt1.text);
			   		}
			   	}
			} catch(ex) {
				destino.add(opt);
				if (subs !== null) {
					if (targetO.indexOf("msisdnSelected") != -1) {
				   		if (!contains(opt1.text)) {
				   			try {
				   				subs.add(opt1);
				   			} catch (ex1) {
				   				subs.add(opt1);
				   			}
				   		}
			   		} else {
			   			removeSubs(opt1.text);
			   		}
				}
			}
			origen.remove(i);
		}
	}
}

function addAllMsisdn(targetO, targetD) {
	document.getElementsByName('search')[0].value = "";
	var origen = document.getElementsByName(targetO)[0];
	var destino = document.getElementsByName(targetD)[0];
	if (destino.length === 1) {
		if (destino[0].text.indexOf("No hay resultados para tu busqueda") != -1) {
			destino.remove(0);
		}
	}
	
	
	
	for (var i = origen.length - 1; i >= 0; i--) {
//		if (origen[i].selected) {
			var opt = document.createElement('option');
			var opt1 = document.createElement('option');
			if (targetD.indexOf("msisdnSelected") != -1) {
				opt.setAttribute("selected","selected");
			}
			opt.text = origen[i].text;
			opt.value = origen[i].value;
			opt1.text = origen[i].text;
			opt1.value = origen[i].value;
			
			//alert(destino.outerHTML);
			
//			try {
			   	destino.add(opt);
			   	if (subs !== null) {
/*			   		if (targetO.indexOf("msisdnSelected") != -1) {
				   		if (!contains(opt1.text)) {
				   			try {
				   				subs.add(opt1, null);
				   			} catch (ex1) {
				   				subs.add(opt1);
				   			}
				   		}
			   		} else {*/
			   			//removeSubs(opt1.text); //causaba el error
//			   		}
			   	}
/*			} catch(ex) {
				destino.add(opt);
				if (subs !== null) {
					if (targetO.indexOf("msisdnSelected") != -1) {
				   		if (!contains(opt1.text)) {
				   			try {
				   				subs.add(opt1, null);
				   			} catch (ex1) {
				   				subs.add(opt1);
				   			}
				   		}
			   		} else {
			   			removeSubs(opt1.text);
			   		}
				}
			}*/
			origen.remove(i);
//		}
	}
}

function contains(val) {
	var i;
	for (i = subs.length - 1; i >= 0; i--) {
		if (subs[i].text.indexOf(val) != -1) {
			return true;
		}
	}
	return false;
}

function removeSubs(val) {
	var i;
	for (i = subs.length - 1; i >= 0; i--) {
		if (subs[i].text.indexOf(val) != -1) {
			subs.remove(i);
			break;
		}
	}
}


// Added for count characters in sendMessaje
function getObject(obj) {
  if(document.all) {
    if(typeof obj=="string") {
      return document.all(obj);
    } else {
      return obj.style;
    }
  }
  if(document.getElementById) {
    if(typeof obj=="string") {
      return document.getElementById(obj);
    } else {
      return obj.style;
    }
  }
  return null;
}

function countMessage(inputText,outputText,text,maxLength) {
  var inputObject=getObject(inputText);
  var outputObject=getObject(outputText);
  var length=maxLength - inputObject.value.length;
  if(length <= 0) {
    length=0;
    text='<span class="disableTextArea"> '+text+' </span>';
    inputObject.value=inputObject.value.substr(0,maxLength);
  }
  outputObject.innerHTML = text.replace("{CHAR}",length);
}

tday  =new Array("Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado");
tmonth=new Array("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");

function GetClock(){
	d = new Date();
	nday   = d.getDay();
	nmonth = d.getMonth();
	ndate  = d.getDate();
	nyear = d.getYear();
	if(nyear<1000) 
		nyear=nyear+1900;
	document.getElementById('clockbox').innerHTML=" "+tday[nday]+" "+ndate+" "+tmonth[nmonth]+" "+nyear+"";
	setTimeout("GetClock()", 1000);
	
}	
