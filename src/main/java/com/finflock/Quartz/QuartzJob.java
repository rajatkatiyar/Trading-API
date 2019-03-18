package com.finflock.Quartz;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.glassfish.jersey.apache.connector.ApacheClientProperties;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.json.JSONArray;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJob implements Job{
 JSONArray ja=new JSONArray();
	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException {
	//geting API data
		String s=QuartzData.APIData();
	
		// TODO Auto-generated method stub
		System.out.println("Hello -----------  : "+new Date());
		System.out.println("Hello -----------  : "+ctx.getJobDetail());
		System.out.println("Hello ------===-----  : "+ctx.getMergedJobDataMap().getString("symbol"));
		System.out.println("Hello ------===-----  : "+ctx.getMergedJobDataMap().getString("quantity"));
		String symbol=	ctx.getMergedJobDataMap().getString("symbol");
		String qnty=ctx.getMergedJobDataMap().getString("quantity");
		String action=	ctx.getMergedJobDataMap().getString("action");
		
		/*ctx.getMergedJobDataMap().getString("indicator");
		
int value=	Integer.parseInt(ctx.getMergedJobDataMap().getString("value"));
	
	
		*/
	
		
				System.out.println("---------order placing-");
				
		/*		
				
				 ClientConfig clientConfig = new ClientConfig();
				 
				 PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
				 connectionManager.setMaxTotal(5);;
				 connectionManager.setDefaultMaxPerRoute(20);
				 
				 
				 clientConfig.property(ApacheClientProperties.CONNECTION_MANAGER, connectionManager);
				 clientConfig.connectorProvider(new ApacheConnectorProvider());  
				clientConfig.property(ApacheClientProperties.CONNECTION_MANAGER, connectionManager);
				clientConfig.connectorProvider(new ApacheConnectorProvider());
				
			
				Client client_tws	 = ClientBuilder.newBuilder() .withConfig(clientConfig).build();*/
			
				Client client_tws	=	QuartzData.getClient();
				System.out.println("--------client gets ----"+action);
				WebTarget webTarget_tws;
				
				if(action.equals("buy")) {
					System.out.println("buy-----if--------");
			   webTarget_tws = client_tws.target("http://localhost:8081").path("Order").path("buy").path("5").path(symbol).path(qnty);	
				}
			   else {
			  webTarget_tws = client_tws.target("http://localhost:8081").path("Order").path("sell").path("5").path(symbol).path(qnty);
			   System.out.println("---selll---else");
			   }
				
					Invocation.Builder invocationBuilder_tws =  webTarget_tws.request(MediaType.APPLICATION_JSON);
					javax.ws.rs.core.Response response = null;	response = invocationBuilder_tws.get();
					String s_tws=response.readEntity(String.class);
					client_tws.close();
					System.out.println("*-Response from order API--"+s_tws);
				//--------------------
		
		
	}
}
