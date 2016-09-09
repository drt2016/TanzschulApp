package server;

import java.util.logging.Logger;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
/**
 * 
 * @author Simon Stolz
 * Sources: http://www.pabst-software.de/doku.php?id=programmieren:java:android:httpclient:start
 * @attribute This is my Server Class it contains Jetty server that is hosted on  192.168.1.104
 */
public class TServer {
	/**
	 * 
	 */
	 Server server;
	 ServerConnector http;
	 private volatile boolean running = true;
	public TServer(){
			
		 
		/**
		 * Instanziert einen Jetty-Webserver, der sp�ter auf Port 8080 horchen soll
		 */
		  server = new Server();
//	        // HTTP connector
	        http = new ServerConnector(server);

	        http.setPort(8080);
	        http.setIdleTimeout(30000);
	        
//		 	/**
//		 	 * Bei jedem Request wird vom Webserver die handle-Methode der Handler-Klasse MyHandler aufgerufen. 
//		 	 * For every incoming Request the handle-method of the THandler Class gets called.
//		 	 */
		    
	    
	}
	
	public boolean stopServer(){
		try {
	    	/**
	    	 * 
	    	 * This stops the Server
	    	 */
			server.stop();
			return true;
				
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}
	public String startServer(String host){
		 try {
		    	/**
		    	 * Starten des Webservers
		    	 * This starts the Server
		    	 */
			
			 http.setHost(host);
			 server.setHandler(new THandler());
			 server.addConnector(http);
			 System.out.println(server.getURI());
				server.start();
				server.join();
				 return null;
			        
					
			} catch (Exception e) {
				e.printStackTrace();
				return e.getMessage().toString();
			}
	}
	

	
 
}

