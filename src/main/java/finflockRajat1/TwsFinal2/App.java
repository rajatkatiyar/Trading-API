package finflockRajat1.TwsFinal2;

/**
 * Hello world!
 *
 */
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;

import com.finflock.Quartz.Quartzservlet;
import com.finflock.config.CorsFilter;
import com.main.rest.HelloWorld;

public class App {
 public static void main(String[] args) throws Exception {
  ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
  context.setContextPath("/");

  Server jettyServer = new Server(8081);
  jettyServer.setHandler(context);

  ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
  ServletHolder jerseyServlet1 =context.addServlet(Quartzservlet.class,"/q/*");
  
  
  jerseyServlet.setInitOrder(0);
  jerseyServlet1.setInitOrder(1);
  
  //enabling cors 
  ResourceConfig webapiResourceConfig = new ResourceConfig();
  webapiResourceConfig.register(CorsFilter.class);

  jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", HelloWorld.class.getCanonicalName());
  //jerseyServlet.setInitParameter(param, value);
  jettyServer.addBean(jerseyServlet1, true);
 
  try {
   jettyServer.start();
   jettyServer.join();
  } catch (Exception e) {
   e.printStackTrace();
  } finally{
   jettyServer.destroy();
  }
 }
}