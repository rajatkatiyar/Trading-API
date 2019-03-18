package Quartz2_simpleTrigger;

import org.quartz.SchedulerException;

public class ShutDownScheduler {

	public static void main(String[] args) throws SchedulerException {
		// TODO Auto-generated method stub
/*QuartzMain obj=new QuartzMain();
obj.runQuartz();
System.out.println("closing");
obj.closeQuartz();*/
		QuartzMain.runQuartz();
		try {
			Thread.sleep(70000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	QuartzMain.closeQuartz();
	}

}
