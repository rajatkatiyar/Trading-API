package Quartz2_simpleTrigger;

import java.util.Properties;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerUtils;

public class QuartzMain {
	static JobDetail job;
	static Trigger t1;
	static Scheduler sched;
	
	
	public static void runQuartz() {
		Properties prop=new Properties();
    	prop.put("org.quartz.threadPool.threadCount","5");

		// TODO Auto-generated method stub
    	try {
		SchedulerFactory schedFact = new
				 org.quartz.impl.StdSchedulerFactory(prop);
		sched = schedFact.getScheduler();
				sched.start();
			job=JobBuilder.newJob(HelloJob.class).build();
			 t1=TriggerBuilder.newTrigger().withIdentity("CronTrigger").withSchedule(
						CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();
				System.out.println("----"+sched);
				sched.scheduleJob(job, t1);
				System.out.println("--=========--"+sched);
    	}
    	catch(Exception e) {  	System.out.println(e);}
  
			//	sched.shutdown();
	}
    	public  static void closeQuartz() {
    		try {
    			System.out.println("----"+sched);
    			sched.shutdown();
    		} catch (SchedulerException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
	

}
