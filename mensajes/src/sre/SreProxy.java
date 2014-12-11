package sre;

public class SreProxy implements sre.Sre_PortType {
  private String _endpoint = null;
  private sre.Sre_PortType sre_PortType = null;
  
  public SreProxy() {
    _initSreProxy();
  }
  
  public SreProxy(String endpoint) {
    _endpoint = endpoint;
    _initSreProxy();
  }
  
  private void _initSreProxy() {
    try {
      sre_PortType = (new sre.Sre_ServiceLocator()).getsreSoapHttpPort();
      if (sre_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sre_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sre_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sre_PortType != null)
      ((javax.xml.rpc.Stub)sre_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public sre.Sre_PortType getSre_PortType() {
    if (sre_PortType == null)
      _initSreProxy();
    return sre_PortType;
  }
  
  public sre.SreConsultaTransaccionResponseElement sreConsultaTransaccion(sre.SreConsultaTransaccionElement parameters) throws java.rmi.RemoteException{
    if (sre_PortType == null)
      _initSreProxy();
    return sre_PortType.sreConsultaTransaccion(parameters);
  }
  
  public sre.SreReceptaTransaccionResponseElement sreReceptaTransaccion(sre.SreReceptaTransaccionElement parameters) throws java.rmi.RemoteException{
    if (sre_PortType == null)
      _initSreProxy();
    return sre_PortType.sreReceptaTransaccion(parameters);
  }
  
  
}