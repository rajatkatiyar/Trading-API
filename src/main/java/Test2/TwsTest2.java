package Test2;
import com.ib.client.Contract;
import com.ib.client.EClientSocket;
import com.ib.client.EReader;
import com.ib.client.EReaderSignal;


	import com.ib.client.EClientSocket;
	import com.ib.client.EReader;
	import com.ib.client.EReaderSignal;
	import com.ib.client.Order;
import com.ib.client.TagValue;

import samples.testbed.contracts.ContractSamples;
import samples.testbed.orders.OrderSamples;

	public class TwsTest2{
		
		EClientSocket m_client ;
		
		
		
		
		public  EClientSocket mainMethod(){
		
	MyEwrapperInterface wrapper = new MyEwrapperInterface();
			
			  m_client = (EClientSocket) wrapper.getClient();
			   final EReaderSignal m_signal = wrapper.getSignal();
			
			   m_client.eConnect("127.0.0.1",7497,2);
	           final EReader reader = new EReader(m_client, m_signal);   
			
			   reader.start();
			    //An additional thread is created in this program design to empty the messaging queue
			    new Thread(() -> {
			     while (m_client.isConnected()) {
			      m_signal.waitForSignal();
			      try {
			       reader.processMsgs();
			       } catch (Exception e) {
			        System.out.println("Exception: "+e.getMessage());
			        }
			    }
			  }).start();
			    
		System.out.println("main class----------------------------------------------------------------------------");
				 return m_client;
			 
				 
				 
			       
			
		}//main
		public void closeConnection() {
			 m_client.eDisconnect();
				System.out.println("================connection !!!!!!!closed!!!!==================");
		}
}    