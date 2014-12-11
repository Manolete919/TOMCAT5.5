package eis;

public class EisProxy implements eis.Eis_PortType {
  private String _endpoint = null;
  private eis.Eis_PortType eis_PortType = null;
  
  public EisProxy() {
    _initEisProxy();
  }
  
  public EisProxy(String endpoint) {
    _endpoint = endpoint;
    _initEisProxy();
  }
  
  private void _initEisProxy() {
    try {
      eis_PortType = (new eis.Eis_ServiceLocator()).geteisSoapHttpPort();
      if (eis_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)eis_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)eis_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (eis_PortType != null)
      ((javax.xml.rpc.Stub)eis_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public eis.Eis_PortType getEis_PortType() {
    if (eis_PortType == null)
      _initEisProxy();
    return eis_PortType;
  }
  
  public eis.EipConsumeServicioResponseElement eipConsumeServicio(eis.EipConsumeServicioElement parameters) throws java.rmi.RemoteException{
    if (eis_PortType == null)
      _initEisProxy();
    return eis_PortType.eipConsumeServicio(parameters);
  }
  
  public eis.TestConnectionResponseElement testConnection(eis.TestConnectionElement parameters) throws java.rmi.RemoteException{
    if (eis_PortType == null)
      _initEisProxy();
    return eis_PortType.testConnection(parameters);
  }
  
  
}