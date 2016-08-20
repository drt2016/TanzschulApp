package server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class TServer {
	public TServer(){
		 
		/**
		 * Instanziert einen Jetty-Webserver, der sp�ter auf Port 8080 horchen soll
		 */
		 Server server = new Server();
		 
		

	        // HTTP connector
	        ServerConnector http = new ServerConnector(server);
	        http.setHost("192.168.1.108");
	        http.setPort(8080);
	        http.setIdleTimeout(30000);

	        // Set the connector
	        server.addConnector(http);

	   
	       
	    
		 	/**
		 	 * Bei jedem Request wird vom Webserver die handle-Methode der Handler-Klasse MyHandler aufgerufen. 
		 	 */
		    server.setHandler(new THandler());
		    System.out.println(server.getURI());
 
		    try {
		    	/**
		    	 * Starten des Webservers
		    	 */
				server.start();;
				server.join();;	
					
			} catch (Exception e) {
 
				e.printStackTrace();
			}
	}
 
}
