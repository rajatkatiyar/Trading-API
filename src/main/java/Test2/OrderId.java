package Test2;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class OrderId {
static int OId;

static java.sql.Connection con = null;

public static void setOId(int currentOrderId) throws ClassNotFoundException {
	
	try {
	java.sql.Connection con=DataSourceClass.getDataSource().getConnection();
		
		//System.out.println("setting order id------------------------------------currentOrderId-----------"+currentOrderId);
			 java.sql.PreparedStatement preparedStmt = null;
		    	  preparedStmt = con.prepareStatement("UPDATE orderIdTWS SET oid=? where clientId=?");
			preparedStmt.setLong (1, currentOrderId);
			preparedStmt.setLong (2,1);
							preparedStmt.executeUpdate();
		
				// con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("database error from orderid  method SET id-------------------"+e);			
			}
		      
     
		
}
public static int getOId() {
int  tempId = 0;
try {
	java.sql.Connection con=DataSourceClass.getDataSource().getConnection();
java.sql.PreparedStatement preparedStmt;
	  preparedStmt = con.prepareStatement("select * from  orderIdTWS where clientId=?");
preparedStmt.setLong (1, 1);
	ResultSet rs=preparedStmt.executeQuery();
	rs.next();
	tempId=	rs.getInt(1);
	//System.out.println("getting order id-----------order id class--------------completed----------------------"+tempId);
	
}
catch(Exception e) {System.out.println("database error from orderid  method get id"+e);}

return tempId;
}

}