package test;
import java.io.IOException;
import java.io.StringReader;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.ResourceBundle;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ServiceException;

import org.apache.axis.message.MessageElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import sre.SreConsultaTransaccionResponseElementResult;
import sre.SreReceptaTransaccionElement;
import sre.SreReceptaTransaccionElementParametros_Transaccion;
import sre.SreReceptaTransaccionResponseElement;
import sre.SreReceptaTransaccionResponseElementResult;
import sre.Sre_PortType;
import sre.Sre_ServiceLocator;
public class TestSRE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Sre_ServiceLocator sl = new Sre_ServiceLocator();
		
		SreReceptaTransaccionElement parameters = new SreReceptaTransaccionElement();
		
		SreReceptaTransaccionElementParametros_Transaccion parametros_Transaccion = new SreReceptaTransaccionElementParametros_Transaccion();
		
		String idInstancia = null;
		String idTipoTransaccion = null;
		String idIntegrador = null;
		String codAlternoDistribuidor = null;
		String sreUsuario = null;
		String sreClave = null;
		String dataSource = null;
		String estado = null;
		
		ResourceBundle parmetros =ResourceBundle.getBundle("parametros.mensajes");
		
		
		idInstancia = parmetros.getString("mensajes.sre.idInstancia");
		idTipoTransaccion= parmetros.getString("mensajes.sre.idTipoTransaccion");
		idIntegrador= parmetros.getString("mensajes.sre.idIntegrador");
		codAlternoDistribuidor= parmetros.getString("mensajes.sre.codAlternoDistribuidor");
		sreUsuario= parmetros.getString("mensajes.sre.usuario");
		sreClave= parmetros.getString("mensajes.sre.clave");
		dataSource= parmetros.getString("mensajes.sre.dataSource");
		estado = parmetros.getString("mensajes.sre.estado");	  
	
		
		/*idInstancia="6000";
		idTipoTransaccion="2000";
		idIntegrador="300";
		codAlternoDistribuidor="6666";
		sreUsuario="WebMeg";
		sreClave="01MegWeb";
		dataSource="jdbc/ideas";
		estado="1";*/
		
		
		
		System.out.println(idInstancia);
		System.out.println(idTipoTransaccion);
		System.out.println(idIntegrador);
		System.out.println(codAlternoDistribuidor);
		System.out.println(sreUsuario);
		System.out.println(sreClave);
		System.out.println(dataSource);
		System.out.println(estado);
		
		
		parameters.setId_Instancia(idInstancia);
		parameters.setId_Tipo_Transaccion(idTipoTransaccion);
		parameters.setId_Integrador(idIntegrador);
		parameters.setCod_Alterno_Distribuidor(codAlternoDistribuidor);
		parameters.setUsuario(sreUsuario);
		parameters.setClave(sreClave);
		parameters.setData_Source(dataSource);
		
		String usuario = "92011950_201211060102",clave="92011950", mensaje = "HOLA MUNDO MANUEL GARCIA";
		
		
		
		System.out.print("estado " + estado);
	
		try {
			
			parametros_Transaccion.set_any(TestSRE.convertXMLStringtoMessageElement(
			        "<parametros>"
			        + "    <MEG_USUARIO>"+usuario+"</MEG_USUARIO>"
			        + "    <MEG_CLAVE>"+clave+"</MEG_CLAVE>"
			        + "    <MEG_ESTADO>"+estado+"</MEG_ESTADO>"
			        + "    <MEG_MENSAJE>"+mensaje+"</MEG_MENSAJE>"+
			        "</parametros>"));
			
			
			
			
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			      
		
		parameters.setParametros_Transaccion(parametros_Transaccion);
		
		try {
			Sre_PortType pt  = sl.getsreSoapHttpPort();
			
			SreReceptaTransaccionResponseElement resser = pt.sreReceptaTransaccion(parameters);
			
			SreReceptaTransaccionResponseElementResult resultado = resser.getResult();
			
			
			
			
			Iterator it = resultado.get_any()[0].getChildElements();
			
			QName error = new QName("WS_ERROR");
			QName respuestas = new QName("PCK_RESPUESTA");
			
			
			
			System.out.println(" SRE " + resultado.get_any()[0].getName() );
			
			
			
			System.out.println(" WS_ERROR " + resultado.get_any()[0].getChildElement(error).getValue());
			
			MessageElement me = resultado.get_any()[0].getChildElement(respuestas);
			
			if(me != null){
				
				MessageElement me0 = me.getChildElement(new QName("ID_CLASE_SERVICIO"));
				MessageElement me1 = me.getChildElement(new QName("COD_RESPUESTA"));
				MessageElement me2 = me.getChildElement(new QName("MENSAJE"));
				MessageElement me3 = me.getChildElement(new QName("ID_TRANSACCION"));
				
				System.out.println(" ID_CLASE_SERVICIO " + ((me0 != null)?me0.getValue():"") );
				System.out.println(" COD_RESPUESTA " + ((me1 != null)?me1.getValue():"") );
				System.out.println(" MENSAJE " + ((me2 != null)?me2.getValue():"") );
				System.out.println(" ID_TRANSACCION " + ((me3 != null)?me3.getValue():"") );
				
				
			
			}
			
			
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static MessageElement[] convertXMLStringtoMessageElement(
			String xmlString) throws SAXException, IOException,
			ParserConfigurationException {
		MessageElement[] m = new MessageElement[1];
		Document XMLDoc = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder()
				.parse(new InputSource(new StringReader(xmlString)));
		Element element = XMLDoc.getDocumentElement();
		m[0] = new MessageElement(element);
		return m;
	}


}
