package tsu;
 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
 
/**
 * This program demonstrates a usage of the MultipartUtility class.
 * @author www.codejava.net
 *
 */
public class MultipartFileUploader {
 
	public String uploadFile(String path,String contentType,  String usuario, String clave_desencrip, String pvAsunto, String pvMensaje, String idShortCode){
			
        String charset = "UTF-8";
        String mensajeError = null;
        String mensajeEnviado = null;
        String destinatarios = null;
        String tipoTransaccion = null;
        String sistemaOrigen = null;
        String subsistema = null;
        String perfilOrigen = null;
        String urlServer = null;
        String pathFilePost = null;
        
        String formatoFecha=null;
        int expiracionAnios = 0 ;
        int expiracionMeses = 0;
        int expiracionDias = 0;
        int expiracionHoras = 0;
        int expiracionMinutos = 0;
        int expiracionSegundos = 0;	
        
        int entregaAnios = 0; 	
        int entregaMeses = 0;
        int entregaDias = 0;
        int entregaHoras = 0;
        int entregaMinutos = 0;
        int entregaSegundos = 0;
        
        ResponseRest responseRest = new ResponseRest();
        
        File file = new File(path);
        
        ResourceBundle parmetros =ResourceBundle.getBundle("parametros.mensajes");
        tipoTransaccion = parmetros.getString("mensajes.jtsu.tipoTransaccion").trim();
        sistemaOrigen = parmetros.getString("mensajes.jtsu.sistemaOrigen").trim();
        subsistema = parmetros.getString("mensajes.jtsu.subsistema").trim();
        perfilOrigen = parmetros.getString("mensajes.jtsu.perfilOrigen").trim();
        urlServer = parmetros.getString("mensajes.jtsu.urlServer").trim();
        pathFilePost = parmetros.getString("mensajes.jtsu.pathFilePost").trim();
        mensajeError = parmetros.getString("mensajes.mensajeError");
        mensajeEnviado = parmetros.getString("mensajes.mensajeEnviado");
        destinatarios = parmetros.getString("mensajes.destinatarios");
        
        formatoFecha = parmetros.getString("mensajes.jtsu.formatoFecha").trim();
        expiracionAnios = Integer.parseInt(parmetros.getString("mensajes.jtsu.expiracionAnios").trim());
        expiracionMeses = Integer.parseInt(parmetros.getString("mensajes.jtsu.expiracionMeses").trim());
        expiracionDias = Integer.parseInt(parmetros.getString("mensajes.jtsu.expiracionDias").trim());
        expiracionHoras = Integer.parseInt(parmetros.getString("mensajes.jtsu.expiracionHoras").trim());
        expiracionMinutos = Integer.parseInt(parmetros.getString("mensajes.jtsu.expiracionMinutos").trim());
        expiracionSegundos = Integer.parseInt(parmetros.getString("mensajes.jtsu.expiracionSegundos").trim());	
        
        entregaAnios = Integer.parseInt(parmetros.getString("mensajes.jtsu.entregaAnios").trim());	
        entregaMeses = Integer.parseInt(parmetros.getString("mensajes.jtsu.entregaMeses").trim());	
        entregaDias = Integer.parseInt(parmetros.getString("mensajes.jtsu.entregaDias").trim());
        entregaHoras = Integer.parseInt(parmetros.getString("mensajes.jtsu.entregaHoras").trim());
        entregaMinutos = Integer.parseInt(parmetros.getString("mensajes.jtsu.entregaMinutos").trim());
        entregaSegundos = Integer.parseInt(parmetros.getString("mensajes.jtsu.entregaSegundos").trim());
        
        
       
        
        String requestURL = urlServer + pathFilePost;
 
        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);
             
           /* multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
            
            multipart.addFormField("description", "Cool Pictures");
            multipart.addFormField("keywords", "Java,upload,Spring"); */
            
            
          
             
            multipart.addFormField("idUsuario", usuario);
            multipart.addFormField("clave", clave_desencrip);
            multipart.addFormField("tipoTransaccion", tipoTransaccion);
            multipart.addFormField("sistemaOrigen",sistemaOrigen);
            multipart.addFormField("subsistema",subsistema);
            multipart.addFormField("perfilOrigen",perfilOrigen);
            
            
            Date d = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            
            
            
            
            int anio = c.get(Calendar.YEAR);
            int mes = c.get(Calendar.MONTH);
            int dia = c.get(Calendar.DAY_OF_MONTH);
            int horas = c.get(Calendar.HOUR_OF_DAY);
            int minutos = c.get(Calendar.MINUTE);
            int segundos = c.get(Calendar.SECOND);
            

    		Calendar pdFechaEnvio = new GregorianCalendar(anio + entregaAnios,// anio yyyy
    				mes + entregaMeses,// mes 0-12; 0= Enero
    				dia + entregaDias,// dia dd
    				horas + entregaHoras,// hora hh
    				minutos + entregaMinutos,// min mi
    				segundos + entregaSegundos);// Segundos ss
    		
    		
    		
    		
    		
    		SimpleDateFormat formatter = new SimpleDateFormat(formatoFecha);  
    		
    		String fechaEnvio = formatter.format(pdFechaEnvio.getTime());
    		
    		
    		multipart.addFormField("infoAdicional1",fechaEnvio);
    		
    		System.out.print("HORA DE ENVIO DE MENSAJE -->" + fechaEnvio );
    		
    		Calendar pdFechaExpiracion = new GregorianCalendar(anio + expiracionAnios,// anio yyyy
    				mes + expiracionMeses,// mes 0-12; 0= Enero
    				dia + expiracionDias,// dia dd
    				horas + expiracionHoras,// hora hh
    				minutos + expiracionMinutos,// min mi
    				segundos + expiracionSegundos );// Segundos ss
    		
    		
    		String fechaCaducidad =  formatter.format(pdFechaExpiracion.getTime()); 
    		
    		
    		
    		multipart.addFormField("infoAdicional2",fechaCaducidad);  		
            multipart.addFormField("infoAdicional3",pvAsunto);
            multipart.addFormField("infoAdicional4",pvMensaje);
            multipart.addFormField("infoAdicional5",idShortCode);
            
            System.out.print("HORA DE CADUCIDAD DE ENVIO DE MENSAJE -->" + fechaEnvio );
    		
    		// add Objec file
            
            if(file != null){
            	multipart.addFilePart("file", file, contentType);
            }
    		
            
    		responseRest = multipart.finish();
    
           
    		System.out.println("\nRESPUESTA REST");
            System.out.println("id_transaccion: "+responseRest.getId_transaccion());
			System.out.println("tipo_transaccion: "+responseRest.getTipo_transaccion());
			System.out.println("idUsuario: "+responseRest.getIdUsuario());
			System.out.println("sistemaOrigen: "+responseRest.getSistemaOrigen());
			System.out.println("subsistema: "+responseRest.getSubsistema());
			System.out.println("perfilOrigen: "+responseRest.getPerfilOrigen());
			System.out.println("filename: "+responseRest.getFilename());
			System.out.println("registros: "+responseRest.getRegistros());
			System.out.println("Exception: "+responseRest.getException());
			System.out.println("mensajeError: "+responseRest.getMensajeError());
			System.out.println("mensajeTecnico: "+responseRest.getMensajeTecnico());
                   
        } catch (IOException ex) {
            System.err.println(ex);
        }finally{
        	
        	if(mensajeError.equals("")){
        		mensajeError = responseRest.getMensajeError();
        	}
        	
            if(responseRest.getRegistros()==null){
            	
            	return mensajeError;
            	
            }
        }
        
 
        return mensajeEnviado + " "+responseRest.getRegistros() + " " + destinatarios;
    
        
        
    }
}