package com.finflock.Quartz;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.net.ssl.SSLContext;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.glassfish.jersey.apache.connector.ApacheClientProperties;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;

public class QuartzData {

	public static Client getClient() {
		
				
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
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("-error from getClient method of QuartzData");
				}
				return client;
				
	}
	public static String APIData() {
	
		javax.ws.rs.core.Response response = null;
			WebTarget webTarget = null ;
			System.out.println("0--------------------------");
			SSLContext sslContext = null;
			Client client = null;
			String result = null;
			
			/*		
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
			
		client = ClientBuilder.newBuilder() .withConfig(clientConfig).sslContext(sslContext).build();*/
			try {
		 client	=	QuartzData.getClient();
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

}