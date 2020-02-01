/**
 * TransactionServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dpenny.mcda5550.entity;

public class TransactionServiceLocator extends org.apache.axis.client.Service implements com.dpenny.mcda5550.entity.TransactionService {

    public TransactionServiceLocator() {
    }


    public TransactionServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TransactionServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Transaction
    private java.lang.String Transaction_address = "http://localhost:8080/Assignment2/services/Transaction";

    public java.lang.String getTransactionAddress() {
        return Transaction_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TransactionWSDDServiceName = "Transaction";

    public java.lang.String getTransactionWSDDServiceName() {
        return TransactionWSDDServiceName;
    }

    public void setTransactionWSDDServiceName(java.lang.String name) {
        TransactionWSDDServiceName = name;
    }

    public com.dpenny.mcda5550.entity.Transaction getTransaction() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Transaction_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTransaction(endpoint);
    }

    public com.dpenny.mcda5550.entity.Transaction getTransaction(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.dpenny.mcda5550.entity.TransactionSoapBindingStub _stub = new com.dpenny.mcda5550.entity.TransactionSoapBindingStub(portAddress, this);
            _stub.setPortName(getTransactionWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTransactionEndpointAddress(java.lang.String address) {
        Transaction_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.dpenny.mcda5550.entity.Transaction.class.isAssignableFrom(serviceEndpointInterface)) {
                com.dpenny.mcda5550.entity.TransactionSoapBindingStub _stub = new com.dpenny.mcda5550.entity.TransactionSoapBindingStub(new java.net.URL(Transaction_address), this);
                _stub.setPortName(getTransactionWSDDServiceName());
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
        if ("Transaction".equals(inputPortName)) {
            return getTransaction();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://entity.mcda5550.dpenny.com", "TransactionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://entity.mcda5550.dpenny.com", "Transaction"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Transaction".equals(portName)) {
            setTransactionEndpointAddress(address);
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
