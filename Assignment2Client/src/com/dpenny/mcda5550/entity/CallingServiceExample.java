package com.dpenny.mcda5550.entity;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class CallingServiceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TransactionServiceLocator tsLocator = new TransactionServiceLocator();
		try {
			String nameOnCard = tsLocator.getTransaction().getNameOnCard();
			System.out.println("Name On Card is "+nameOnCard);
		} catch (RemoteException | ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
