/**
 * Sre_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sre;

import java.util.ResourceBundle;

public class Sre_ServiceLocator extends org.apache.axis.client.Service implements sre.Sre_Service {

    public Sre_ServiceLocator() {
    }


    public Sre_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Sre_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }
    
    ResourceBundle parmetros = ResourceBundle.getBundle("parametros.mensajes");

    // Use to get a proxy class for sreSoapHttpPort
    private java.lang.String sreSoapHttpPort_address = parmetros.getString("mensajes.sre.url");

    public java.lang.String getsreSoapHttpPortAddress() {
        return sreSoapHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String sreSoapHttpPortWSDDServiceName = "sreSoapHttpPort";

    public java.lang.String getsreSoapHttpPortWSDDServiceName() {
        return sreSoapHttpPortWSDDServiceName;
    }

    public void setsreSoapHttpPortWSDDServiceName(java.lang.String name) {
        sreSoapHttpPortWSDDServiceName = name;
    }

    public sre.Sre_PortType getsreSoapHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(sreSoapHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getsreSoapHttpPort(endpoint);
    }

    public sre.Sre_PortType getsreSoapHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            sre.SreSoapHttpStub _stub = new sre.SreSoapHttpStub(portAddress, this);
            _stub.setPortName(getsreSoapHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setsreSoapHttpPortEndpointAddress(java.lang.String address) {
        sreSoapHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (sre.Sre_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                sre.SreSoapHttpStub _stub = new sre.SreSoapHttpStub(new java.net.URL(sreSoapHttpPort_address), this);
                _stub.setPortName(getsreSoapHttpPortWSDDServiceName());
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
        if ("sreSoapHttpPort".equals(inputPortName)) {
            return getsreSoapHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicioweb/", "sre");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicioweb/", "sreSoapHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("sreSoapHttpPort".equals(portName)) {
            setsreSoapHttpPortEndpointAddress(address);
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
