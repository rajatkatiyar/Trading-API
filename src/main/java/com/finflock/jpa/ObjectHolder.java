package com.finflock.jpa;

import java.util.Date;

public class ObjectHolder {
static IbAccountUpdate  obj;
static IbOrderStatusA objOrderStatus;



public static IbOrderStatusA getObjOrderStatus() {
	return objOrderStatus;
}
public static void setObjOrderStatus(IbOrderStatusA objOrderStatus) {
	ObjectHolder.objOrderStatus = objOrderStatus;
}


//we are calling insert method of jpa for reqAccountUpdate froma dummy class
//code

public static void setObj(IbAccountUpdate obj) {
	obj.setIsActive('y');
	//obj.setUpdateUserName("DB_run");
	
//	obj.setLastUpdateDatetime(new Date());
	System.out.println("^^^---"+obj.getNetLiquidationByCurrency());
	ObjectHolder.obj = obj;
	
	
}
public static IbAccountUpdate getObj() {
	obj.setIsActive('n');
	obj.setUpdateUserName("DB_run2");
	
	obj.setLastUpdateDatetime(new Date());
	System.out.println("IsActive  :::::             "+obj.getIsActive());
	System.out.println("IsActive  :::::             "+obj.getRealizedPnL());
	
	return obj;
}
	/*public static void main(String args[]) {
		IbAccountUpdate obj=	new IbAccountUpdate();
		obj.setIsActive('y');
		obj.setUpdateUserName("DB_run");
		
		obj.setLastUpdateDatetime(new Date());
		obj.setRealizedPnL();
				obj.setUnrealizedPnL(unrealizedPnL);
		JPA_DB_Manager.insert(obj);
		//setObj(new IbAccountUpdate());
		
	}
*/
}
