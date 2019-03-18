package com.finflock.Quartz;

import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.eclipse.jetty.util.thread.Scheduler;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class Quartzservlet extends HttpServlet{
		org.quartz.Scheduler sched;
		
	public void init() throws ServletException {
		try {
			Properties prop=new Properties();
			prop.put("org.quartz.dataSource.quartzDataSource.driver","com.mysql.jdbc.Driver");
			
					prop.put("org.quartz.dataSource.quartzDataSource.URL","jdbc:mysql://localhost:3306/quartz");
			prop.put("org.quartz.dataSource.quartzDataSource.user", "root");
			prop.put("org.quartz.dataSource.quartzDataSource.password", "root");
			prop.put("org.quartz.dataSource.quartzDataSource.maxConnections", "2");
			prop.put("org.quartz.threadPool.threadCount","5");
		SchedulerFactory schedFact = new
				 org.quartz.impl.StdSchedulerFactory(prop);
		sched = schedFact.getScheduler();
				sched.start();
				QuartzPojo.setSched(sched);
					
		}
		catch(Exception e) {
			System.out.println("exception  ---"+e);
		}
	}
	public void destroy() {
		   // Finalization code...
		try {
			System.out.println("close0----------------------------");
			sched.shutdown();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
