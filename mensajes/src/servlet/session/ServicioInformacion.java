package servlet.session;

import java.math.BigDecimal;

import eis.EipConsumeServicioElement;
import eis.EipConsumeServicioResponseElement;
import eis.EipConsumeServicio_Out;
import eis.Eis_PortType;
import eis.Eis_ServiceLocator;

public class ServicioInformacion {
	
	EipConsumeServicio_Out ejecutaServicioInformacion(String dsId, 
									  BigDecimal pnIdServicioInformacion, 
									  String pvParametroBind1, 
									  String pvParametroBind2,
									  String pvParametroBind3,
									  String pvParametroBind4,
									  String pvParametroBind5){
		
		EipConsumeServicio_Out cs = new EipConsumeServicio_Out();
		
		try {
			
			Eis_ServiceLocator sl = new Eis_ServiceLocator();
			
			Eis_PortType pt = sl.geteisSoapHttpPort();
			
			EipConsumeServicioElement parameters = new EipConsumeServicioElement();
			parameters.setDsId(dsId);
			parameters.setPnIdServicioInformacion(pnIdServicioInformacion);
			parameters.setPvParametroBind1(pvParametroBind1);
			parameters.setPvParametroBind2(pvParametroBind2);
			parameters.setPvParametroBind3(pvParametroBind3);
			parameters.setPvParametroBind4(pvParametroBind4);
			parameters.setPvParametroBind5(pvParametroBind5);
			EipConsumeServicioResponseElement  res = pt.eipConsumeServicio(parameters);
			
			cs = res.getResult();
		
			
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		return cs;		
	}

}
