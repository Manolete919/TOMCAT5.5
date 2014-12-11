package test;
import java.math.BigDecimal;
import java.util.ResourceBundle;

import eis.*;;

public class TestEis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
		Eis_ServiceLocator sl = new Eis_ServiceLocator();
		
		Eis_PortType pt = sl.geteisSoapHttpPort();
		
		EipConsumeServicioElement parameters = new EipConsumeServicioElement();
		
		ResourceBundle parmetros =ResourceBundle.getBundle("parametros.mensajes");
		
		String dsId = null;			
		BigDecimal pnIdServicioInformacion = null;
		
		
		dsId = parmetros.getString("mensajes.eis.login.dsId");
		pnIdServicioInformacion = new BigDecimal(parmetros.getString("mensajes.eis.login.pnIdServicioInformacion"));
		
	
		/*dsId = "jdbc/ideasdesa";			
		pnIdServicioInformacion = new BigDecimal("4");*/
		
		
		parameters.setDsId(dsId);
		parameters.setPnIdServicioInformacion(pnIdServicioInformacion);
		parameters.setPvParametroBind1("92011950");
		parameters.setPvParametroBind2("19871124");
		EipConsumeServicioResponseElement  response = pt.eipConsumeServicio(parameters);
		
		EipConsumeServicio_Out cs = response.getResult();
		
		System.out.print(cs.getPvresultadoOut());
		
	
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	}

}
