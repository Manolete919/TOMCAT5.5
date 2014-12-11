/**
 * Eis_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package eis;

import java.util.ResourceBundle;

public class Eis_ServiceLocator extends org.apache.axis.client.Service implements eis.Eis_Service {

    public Eis_ServiceLocator() {
    }


    public Eis_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Eis_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }
    
    ResourceBundle parmetros = ResourceBundle.getBundle("parametros.mensajes");


    // Use to get a proxy class for eisSoapHttpPort
    private java.lang.String eisSoapHttpPort_address = parmetros.getString("mensajes.eis.url");

    public java.lang.String geteisSoapHttpPortAddress() {
        return eisSoapHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String eisSoapHttpPortWSDDServiceName = "eisSoapHttpPort";

    public java.lang.String geteisSoapHttpPortWSDDServiceName() {
        return eisSoapHttpPortWSDDServiceName;
    }

    public void seteisSoapHttpPortWSDDServiceName(java.lang.String name) {
        eisSoapHttpPortWSDDServiceName = name;
    }

    public eis.Eis_PortType geteisSoapHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(eisSoapHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return geteisSoapHttpPort(endpoint);
    }

    public eis.Eis_PortType geteisSoapHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            eis.EisSoapHttpStub _stub = new eis.EisSoapHttpStub(portAddress, this);
            _stub.setPortName(geteisSoapHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void seteisSoapHttpPortEndpointAddress(java.lang.String address) {
        eisSoapHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (eis.Eis_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                eis.EisSoapHttpStub _stub = new eis.EisSoapHttpStub(new java.net.URL(eisSoapHttpPort_address), this);
                _stub.setPortName(geteisSoapHttpPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("eisSoapHttpPort".equals(inputPortName)) {
            return geteisSoapHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", "eis");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", "eisSoapHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("eisSoapHttpPort".equals(portName)) {
            seteisSoapHttpPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
