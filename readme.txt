1-package --> com.finflock.config
    class- >   CorsFilter 
                                         this class have cors code to allow cross origion access
2-package--> com.finflock.jpa
   class->
           Ib_Account_Update  --entity class 
           Ib_ExecutionDetails--- entity class
          Ib_Order_Status_A-- entity class
           JPA_DB_Manager -- jpa  class to put entity object in to database

3-package com.finflock.Quartz
class->
 QuartzDAO-      set data in to database when quartz request is made
QuartzDATA-     get data from nikhil sir https enabled api
QuartzJob-        quartz job that check the parameter and place order
QuartzPoJo-     this class has methods to schedule job,create trigger and job
QuartzServlet-   this servlet has init() and destroy() method and it is configured in jetty                                            server so that when jetty starts quartz also starts

4-package com.main.rest;
class-
HelloWorld - this class has rest method to buy ,sell, and get execution details,open order as a json .

5-package finflockRajat1.TwsFinal2;
App.java--- this class starts jetty server

6-package Test2;
class-
 DataSourceSqlServer- 
 this class create datasource for sql server
JSONArrayExecutionPOJO-- 
 we have created a Json Array Object in this class.when we call reqExecution its call back gives Exwcution Detais of various id, so we created json Object for each record and we put it in this json Array Object in this class
JSONArrayPojo- 
perform same functionality as above class for open order details

note-- we can reduce these pojo class to one 
MyEwrapperInterface-
          this is implementaion of EwrapperInterface 
OrderId- 
             this class update the last used order id to database and retrives from database whenever required
TwsTest2-  this class contains method to create and close coneection from database

rest package are default of tws api-

            


