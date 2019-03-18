package Test2;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;


public class DataSourceSqlServer2 {
private static SQLServerDataSource ds;
	
static {
	try {
		
		    ds = new SQLServerDataSource(); //new SQLServerDataSource();
	        ds.setUser("system.services");
	        ds.setPassword("Finflock123!");
	        ds.setServerName("www.finflock.com");
	        ds.setPortNumber(49172);
	        ds.setDatabaseName("IBBROKERSERVICE");
	        ds.setTrustServerCertificate(false);
	      
	        //       String connectionUrl = "jdbc:sqlserver://www.finflock.com:49172;databaseName=MARKETDATA;user=system.services;password=Finflock123!";

	   
			
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

public static DataSource getDataSource() {
//	System.out.println("connectiom------DataSource---------"+ds);
	return ds;
	
}

public static void main(String[] args) {
		System.out.println();
}
}
