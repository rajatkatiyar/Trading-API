package com.main.rest;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.ws.Response;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.glassfish.jersey.apache.connector.ApacheClientProperties;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.filter.LoggingFilter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CORBA.SystemException;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;

import com.finflock.Quartz.QuartzDAO;
import com.finflock.Quartz.QuartzPojo;
import com.ib.client.Contract;
import com.ib.client.EClientSocket;
import com.ib.client.ExecutionFilter;
import com.ib.client.Order;
import com.mysql.jdbc.Connection;
//import com.sun.jersey.api.client.config.DefaultClientConfig;
//import com.sun.jersey.client.urlconnection.HTTPSProperties;

import Test2.DataSourceClass;
import Test2.JSONArrayExecutionPOJO;
import Test2.JSONArrayPojo;
import Test2.MyEwrapperInterface;
import Test2.OrderId;
import Test2.TwsTest2;

import samples.testbed.contracts.ContractSamples;
import samples.testbed.orders.OrderSamples;

@Path("/Order")
public class HelloWorld {

static	EClientSocket client = null; 
	 //-----------------------------------------------------------market----------------
	 @GET
	 @Path("/buy/{userid}/{symbol}/{quantity}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public static String test5(@PathParam("userid") String userId,@PathParam("symbol") String symbol,@PathParam("quantity") String quantity) {
		  ResultSet rs;int a = 0;double b = 0;String c=null,d=null;
		  
		System.out.println("buy method  -----------------------------------------------------  ");
			if(client==null) {
				 TwsTest2 obj=new TwsTest2();
				client	=   obj.mainMethod();
			
			}
		//	 System.out.println("------------connection object-----"+client);
			 	
			
		 int qnty=Integer.parseInt(quantity);
		
		 //getting next id
		 System.out.println("-calling req Ids-");
		 client.reqIds(-1);
		
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int id=OrderId.getOId();
		
		id=id+1;
	//setting order property
		   Order order = new Order();
	       order.action("BUY");
	       order.orderType("MKT");
	       order.totalQuantity(qnty);
	       order.transmit(true);
	       
		      Contract cnt=new Contract();
		      cnt.currency("USD");
		       cnt.symbol(symbol);
		       cnt.exchange("SMART");
		       cnt.secType("STK");
		  	 System.out.println("------------place order-----"+client);
client.placeOrder(id, cnt, order);




//----------------------
try {
	

java.sql.Connection con=		DataSourceClass.getDataSource().getConnection();
	 
java.sql.PreparedStatement pstmt = con.prepareStatement(
		"insert into orderdes(userId,orderid,symbol,quantity,orderActivity) values (?,?,?,?,?)"); 
			
			  pstmt.setString(1, userId);
			  pstmt.setInt(2, id);
			
			  pstmt.setString(3, symbol);
			  pstmt.setInt(4, qnty);
			  pstmt.setString(5, "sell");
			 pstmt.executeUpdate();

	     

   }
catch(Exception e) {System.out.println("database error from rest class sell--"+e);}


//-----------
//client.reqExecutions(10001, new ExecutionFilter());
	  return "{userId:"+userId+",orderId:"+id+",Quantity:"+quantity+",Symbol:"+symbol+",type:"+"buy"+"}";
	 }
	 
	 
	 
	 
	 
	 @GET
	 @Path("/sell/{userId}/{symbol}/{quantity}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public static String test6(@PathParam("userId") String userId,@PathParam("symbol") String symbol,@PathParam("quantity") String quantity) {
		 ResultSet rs;int a = 0;double b = 0;String c=null,d=null;  int id = 0;
		
System.out.println("sell method-------------------------");
			if(client==null) {
				 TwsTest2 obj=new TwsTest2();
				client	=   obj.mainMethod();
			
			}
			
		 int qnty=Integer.parseInt(quantity);
		 
	 Order order = new Order();
	       order.action("SELL");
	       order.orderType("MKT");
	       order.totalQuantity(qnty);
	       order.transmit(true);
	       
	      Contract cnt=new Contract();
	      cnt.currency("USD");
	       cnt.symbol(symbol);
	       cnt.exchange("SMART");
	       cnt.secType("STK");
	       
	       client.reqIds(-1);
	       try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
	       id=OrderId.getOId();
	       id=id+1;
	 System.out.println("sell  ----order placed---------"+id);
	client.placeOrder(id, cnt, order);
	
	
	 //----------------------
			try {
				
			
	java.sql.Connection con=		DataSourceClass.getDataSource().getConnection();
				 
				  java.sql.PreparedStatement pstmt = con.prepareStatement(
			"insert into orderdes(userId,orderid,symbol,quantity,orderActivity) values (?,?,?,?,?)"); 
				
				  pstmt.setString(1, userId);
				  pstmt.setInt(2, id);
				
				  pstmt.setString(3, symbol);
				  pstmt.setInt(4, qnty);
				  pstmt.setString(5, "sell");
				 pstmt.executeUpdate();

				     
			
			   }
			catch(Exception e) {System.out.println("database error from rest class sell---"+e);}
			
			
			//-----------
//client.reqExecutions(10001, new ExecutionFilter());
	//ExecutionFilter( int p_clientId, String p_acctCode, String p_time,	String p_symbol, String p_secType, String p_exchange, String p_side) {
return "{userId:"+userId+",orderId:"+id+",Quantity:"+quantity+",Symbol:"+symbol+",type:"+"sell"+"}";
			
			
			
			
	 }
	 
	 
		@GET
		 @Path("/orderStatus/{id}")
		 @Produces(MediaType.APPLICATION_JSON)
		 public String test9(@PathParam("id") String id) {
			  JSONArray ja=new JSONArray();
			 JSONArrayPojo.setJa(ja);
			System.out.println("---------------------------------------oprn order method");
			  client.reqOpenOrders();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			  
			 ja= JSONArrayPojo.getJa();
			return ja.toString();
		 }  
	 
		@GET
		 @Path("/orderExecution/{id}")
		 @Produces(MediaType.APPLICATION_JSON)
		 public String test10(@PathParam("id") String id) {
			  JSONArray ja=new JSONArray();
			  JSONArrayExecutionPOJO.setJa(ja);
			System.out.println("---------------------------------------oprn order execution method");
			client.reqExecutions(10001, new ExecutionFilter());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			  
			 ja= JSONArrayExecutionPOJO.getJa();
			return ja.toString();
		 }  
	 
	 
	
	 
//to get data from travelo api 

@GET
@Path("/dataAPI4/{id}")
@Produces(MediaType.APPLICATION_JSON)
public String test12(@PathParam("id") String id) {
	javax.ws.rs.core.Response response = null;
	WebTarget webTarget = null ;
	System.out.println("0--------------------------");
	SSLContext sslContext = null;
	Client client = null;
	String result = null;
	/*response.close();
	client.close();*/
	
	try {
		sslContext = SSLContext.getInstance("SSL");
		
		sslContext.init(null,null, null);
		 ClientConfig clientConfig = new ClientConfig();
		 PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		 connectionManager.setMaxTotal(5);;
		 connectionManager.setDefaultMaxPerRoute(20);
		 clientConfig.property(ApacheClientProperties.CONNECTION_MANAGER, connectionManager);

		 clientConfig.connectorProvider(new ApacheConnectorProvider());  
		clientConfig.property(ApacheClientProperties.CONNECTION_MANAGER, connectionManager);
		clientConfig.connectorProvider(new ApacheConnectorProvider());
		//System.setProperty("https.protocols", "TLS");
	
client = ClientBuilder.newBuilder() .withConfig(clientConfig).sslContext(sslContext).build();
	
	webTarget = client.target("https://www.travelolot.com").path("api").path("signalTest").queryParam("name", "INFY");
	System.out.println("--uri---"+webTarget.getUri());

		System.out.println("------------======================----------------***************-----------");
	Invocation.Builder invocationBuilder =  webTarget.request();
	
	response = invocationBuilder.get();
result=response.readEntity(String.class);

response.close();
	client.close();
	System.out.println("*****-----"+result);
	}catch(Exception e) {
		System.out.println("--3--"+e);
		e.printStackTrace();
	}
return result;
    

}

@GET
@Path("/quartzAPI/{id}/{symbol}/{quantity}/{indicator}/{value}/{Action}/{CornExp}")
@Produces(MediaType.APPLICATION_JSON)
public String test13(@PathParam("id") String id,@PathParam("symbol") String symbol,@PathParam("quantity") String quantity,@PathParam("indicator") String indicator
,@PathParam("value") String value,@PathParam("Action") String Action,@PathParam("CornExp") String CornExp		) {
	 javax.ws.rs.core.Response response = null;
	
	 int uid=Integer.parseInt(id);
	 //getting Scheduler
	  org.quartz.Scheduler sched= QuartzPojo.getSched();
	  //creating quartz job and trigger with quartz pojo 
	  QuartzPojo obj=new QuartzPojo();
	  JobDetail job=	  obj.createJob(symbol,quantity,indicator, value,Action);
	  Trigger t1=  obj.createTrigger(CornExp);
	//setting details in database
	QuartzDAO.StoreData(uid, symbol, quantity, indicator, value, Action, CornExp);
//	Scheduling job
	  obj.scheduleJob(job, t1, sched);
System.out.println("0----"+sched+"-----"+job+"--"+t1+"--");
	
	  
    String s="";                                                                                                                                                                                                       
    
return s;
}
	 
}