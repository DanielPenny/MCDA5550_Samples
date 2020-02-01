package com.dpenny.mcda5550.entity;

public class TransactionProxy implements com.dpenny.mcda5550.entity.Transaction {
  private String _endpoint = null;
  private com.dpenny.mcda5550.entity.Transaction transaction = null;
  
  public TransactionProxy() {
    _initTransactionProxy();
  }
  
  public TransactionProxy(String endpoint) {
    _endpoint = endpoint;
    _initTransactionProxy();
  }
  
  private void _initTransactionProxy() {
    try {
      transaction = (new com.dpenny.mcda5550.entity.TransactionServiceLocator()).getTransaction();
      if (transaction != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)transaction)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)transaction)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (transaction != null)
      ((javax.xml.rpc.Stub)transaction)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.dpenny.mcda5550.entity.Transaction getTransaction() {
    if (transaction == null)
      _initTransactionProxy();
    return transaction;
  }
  
  public void setCardNumber(java.lang.String cardNumber) throws java.rmi.RemoteException{
    if (transaction == null)
      _initTransactionProxy();
    transaction.setCardNumber(cardNumber);
  }
  
  public void setNameOnCard(java.lang.String nameOnCard) throws java.rmi.RemoteException{
    if (transaction == null)
      _initTransactionProxy();
    transaction.setNameOnCard(nameOnCard);
  }
  
  public java.lang.String getNameOnCard() throws java.rmi.RemoteException{
    if (transaction == null)
      _initTransactionProxy();
    return transaction.getNameOnCard();
  }
  
  public java.lang.String getCardNumber() throws java.rmi.RemoteException{
    if (transaction == null)
      _initTransactionProxy();
    return transaction.getCardNumber();
  }
  
  
}