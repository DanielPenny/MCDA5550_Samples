/**
 * Transaction.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dpenny.mcda5550.entity;

public interface Transaction extends java.rmi.Remote {
    public void setCardNumber(java.lang.String cardNumber) throws java.rmi.RemoteException;
    public void setNameOnCard(java.lang.String nameOnCard) throws java.rmi.RemoteException;
    public java.lang.String getNameOnCard() throws java.rmi.RemoteException;
    public java.lang.String getCardNumber() throws java.rmi.RemoteException;
}
