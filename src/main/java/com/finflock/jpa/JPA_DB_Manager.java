package com.finflock.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPA_DB_Manager {
	static EntityManagerFactory emf;
	static EntityManager	em;
	static EntityTransaction et;
static{
		// TODO Auto-generated method stub
		emf=Persistence.createEntityManagerFactory("TwsFinal2_3");
	  em=emf.createEntityManager();
	et=em.getTransaction();
	//Test.insert();
	//retrieve();
		//Test.update();
		//Test.delete();//
	//<property name="eclipselink.ddl-generation" value="drop-and-create-tables"/>	
		
	}
	public static void insert(IbAccountUpdate obj){
		et.begin();
		/*IbAccountUpdate obj=new 	IbAccountUpdate();
		obj.setId(6);
		obj.setMessage("Namaste");*/
		System.out.println("JPA---"+obj.getRealizedPnL());
		System.out.println("JPA--didvidend-"+obj.getNetLiquidationByCurrency());
		System.out.println("JPA---"+obj.getRealizedPnL());
		
		em.persist(obj);
		et.commit();
		System.out.println("Transaction done");
		em.close();	
	}
	
	public static void insertIbOrderStatus(IbOrderStatusA obj){
		et.begin();
		/*IbAccountUpdate obj=new 	IbAccountUpdate();
		obj.setId(6);
		obj.setMessage("Namaste");*/
		
	
		em.persist(obj);
		et.commit();
		System.out.println("Transaction done");
		em.close();	
	}
	public static void insertExecutionDetails(IbExecutionDetails obj){
		et.begin();
		/*IbAccountUpdate obj=new 	IbAccountUpdate();
		obj.setId(6);
		obj.setMessage("Namaste");*/
		
	
		em.persist(obj);
		et.commit();
		System.out.println("Transaction done");
		em.close();	
	}
public static void retrieve(){
	et.begin();
	System.out.println("Greeting Detail");
	//Greeting g=em.find(Greeting.class,5);
	IbAccountUpdate obj=em.find(IbAccountUpdate.class, 13);
	System.out.println("Greeting Detail found");

	System.out.println("Greeting Id :  "+obj.getCurrency());
	System.out.println("Greeting Id :  "+obj.getLastUpdateDatetime());
	System.out.println(obj.toString());
	em.close();
}
/*
public static void update(){
	
	et.begin();
	System.out.println("Updating details");
	Greeting g=em.find(Greeting.class,4);
	g.setMessage("messasge updated :"+g.getMessage());
	et.commit();
	em.close();
	System.out.println("Data Updated");
}
public static void delete(){
	
	et.begin();
	System.out.println("deleting details");
	Greeting g=em.find(Greeting.class,4);
	em.remove(g);
	//g.setMessage("messasge updated :"+g.getMessage());
	et.commit();
	em.close();
	System.out.println("Data deleted");
}*/
}
