package Test2;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceClass {
private static MysqlDataSource datasource;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
static {
	try {
		//System.out.println("COnnection  driver loading----------------driver loading-------------------------------------------");
	datasource=new MysqlDataSource();
	datasource.setUrl("jdbc:mysql://localhost:3306/bank");
	datasource.setUser("root");
	datasource.setPassword("root");
	}
	catch(Exception e) {
		System.out.println("Datasource class Exception ---"+e);
	}
}
public static DataSource getDataSource() {
//System.out.println("connectiom-----------DataSource---------");
	return datasource;
	
}
}
