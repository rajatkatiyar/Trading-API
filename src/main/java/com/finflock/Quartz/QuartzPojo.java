package com.finflock.Quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class QuartzPojo {
	
	static org.quartz.Scheduler sched;
	JobDetail job;
	
public static org.quartz.Scheduler getSched() {
		return sched;
	}



	public static void setSched(org.quartz.Scheduler sched) {
		System.out.println("*************************************Setting Sched");
		QuartzPojo.sched = sched;
	}



public JobDetail createJob(String symbol, String quantity, String indicator, String value, String action) {
	
	job=JobBuilder.newJob(QuartzJob.class).build();
	job.getJobDataMap().put("symbol", symbol);
	job.getJobDataMap().put("quantity", quantity);
	
	job.getJobDataMap().put("indicator", indicator);
	job.getJobDataMap().put("value", value);
	
	job.getJobDataMap().put("action", action);
	
	
	return job;
}



public Trigger createTrigger(String cornExp) {
	job.getJobDataMap().put("cornExp", cornExp);
		Trigger t1=TriggerBuilder.newTrigger().withIdentity("CronTrigger").withSchedule(
			CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();
	return t1;
}



public void scheduleJob(JobDetail job,Trigger t1,org.quartz.Scheduler sched) {
	try {
		System.out.println("1----"+sched+"-----"+job+"--"+t1+"--");
				sched.scheduleJob(job, t1);
	} catch (SchedulerException e) {
		
		e.printStackTrace();
	}	
}

}
