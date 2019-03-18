package com.finflock.Quartz;

import java.sql.Connection;
import java.sql.SQLException;

import Test2.DataSourceClass;

public class QuartzDAO {

	public static void StoreData(int id,String symbol, String quantity, String indicator, String value, String action,String CornExp){
	try {
		Connection con=	DataSourceClass.getDataSource().getConnection();
		java.sql.PreparedStatement pstmt = con.prepareStatement(
				"insert into orderQuartz(id,symbol,quantity,indicator,value,Action,CornExp) values (?,?,?,?,?,?,?)"); 
					
					  pstmt.setInt(1, id);
					  pstmt.setString(2, symbol);
			
					  pstmt.setString(3, quantity);
					  pstmt.setString(4, indicator);
					  pstmt.setString(5, value);
					  pstmt.setString(6, action);
					  pstmt.setString(7, CornExp);
					 pstmt.executeUpdate();
					 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
