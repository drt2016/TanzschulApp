package task;
/**
 * @author Simon Stolz
 * Soruces: http://www.pabst-software.de/doku.php?id=programmieren:java:android:httpclient:start
 * 			Abi Quiz-App by Tim M�schel
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.HyphenStyle;
import org.simpleframework.xml.stream.Style;

import protocol.Command;
import protocol.Properties;
import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

/**
 * 
 * @author Simon Stolz
 */
public class BaseHttpRequestTask extends AsyncTask<String, Void, String> {
	
	protected Activity activity;
	//http://stackoverflow.com/questions/32553297/verify-android-internet-connection-and-error // missplaced
	/**
	 * Instantiates a new base http request task.
	 *
	 * @param activity the activity
	 */
	protected BaseHttpRequestTask(Activity activity) {
		super();
		this.activity = activity;
	}

	@Override
	protected String doInBackground(String... params) {
		String result = "Error";
	
		
		try {
			URL url = new URL(Properties.SERVERURL + "?&do=" + params[0]);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type",
					"application/xml; charset=UTF-8");
			byte[] outputInBytes = params[1].getBytes("UTF-8");
			try{
			OutputStream os = conn.getOutputStream();
			os.write(outputInBytes);
			os.close();
			
			}catch(IOException e){
				
				Log.e("couldn�t write output in Bytes", e.toString());
				}
			InputStream instream = new BufferedInputStream(
					conn.getInputStream());
			BufferedReader r = new BufferedReader(new InputStreamReader(
					instream, "UTF-8"));
			StringBuilder total = new StringBuilder();
			String line;
			while ((line = r.readLine()) != null) {
				total.append(line);
			}
			instream.close();
			result = total.toString();
		} catch (Exception e) {
			Log.e("Response-Exception", e.toString());
		}

		return result;
	}

	/**
	 * Builds an Object to XML
	 *
	 * @param object an Object
	 * @return the XML string
	 * @throws Exception
	 */
	protected String buildXML(Object object) throws Exception {
		Style style = new HyphenStyle();
		Format format = new Format(style);
		Serializer serializer = new Persister(format);
		StringWriter writer = new StringWriter();
		serializer.write(object, writer);
		return writer.getBuffer().toString();
	}

	
	protected Object parseXML(String xml, Class myClass) throws Exception {
		Serializer serializer = new Persister();

		try {
			Object object = serializer.read(myClass, xml);
			return object;
		} catch (Exception e) {
			Log.e("ParsingString", e.toString());
		}
		return null; // TODO: Error-Handling
	}

	/**
	 * Calls the Super method execute, which executes the Task with given parameters
	 * @param command	The identifier of the Request
	 * @param postBody	The http Body of the Request
	 */
	protected void execute(Command command, String postBody) {
		super.execute(command.toString(), postBody);
	}
}
