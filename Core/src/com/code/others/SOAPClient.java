/* ----------------------------------------------------------------
 * Nombre de la Clase:  SOAPClient.java
 * Version: 1.0
 * Fecha:Nov 21, 2011
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;
import org.xmlpull.v1.XmlPullParserException;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> SOAPClient.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Nov 21, 2011
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class SOAPClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	        
		SOAPClient client = new SOAPClient();
		client.callService3();
	}
	
	/**
	 * NOT WORKING
	 */
	public void callService2(){
		
		 SoapRequestBuilder s = new SoapRequestBuilder();
		    s.Server = "69.10.57.50"; // server ip address or name

		    s.MethodName = "ReturnPdf";
		    s.XmlNamespace = "http://69.10.57.50/";   //"http://tempuri.org/";
		    s.WebServicePath = "http://www.delogico.com/test.asmx/ReturnPdf";    // "/test.asmx/";
		    s.SoapAction = "http://tempuri.org/";    //"http://www.delogico.com/test.asmx/ReturnPdf";
		    //s.AddParameter("one", "David");
		    //s.AddParameter("two", "Hobbs");
		    String response = s.sendRequest();
		    System.out.println(response);
			
	} // callService2() ends...
	
	/**
	 * WORKING FINE... IN CASE TO PRINT WHOLE OUTPUT AND THEN PARSE THE DATA I.e. XML
	 */
	public void callService3(){
		
		try {
			String str = "http://www.delogico.com/test.asmx/Multi100Fun?input=12"; 
						//"http://www.delogico.com/test.asmx/ReturnPdf";
			URL webserviceURL = new URL(str);
			URLConnection webserviceConnection = webserviceURL.openConnection();
			//InputStream inputStream = webserviceConnection.getInputStream();
			//BufferedReader in = new BufferedReader(inputStream);
			BufferedReader in = new BufferedReader(new InputStreamReader(webserviceConnection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null){
				System.out.println(inputLine);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * MAKE A FILE FROM BYTES.. I'VE USED THIS METHOD WHERE BYTES WERE SENT 
	 * FROM .NET WEBSERVICE AND BY DEFAULT IT WAS BASE64 ENCODED
	 * @param strByte
	 * @return
	 */
	 public String makePDF(String strByte){
	    	
	    	
	    	byte[] bytearray = Base64.decodeBase64(strByte.getBytes());
	    	//byte[] bytes = strByte.getBytes();
	    	OutputStream out;
			try {
				
				if(new File("/sdcard/data.pdf").exists())
					new File("/sdcard/data.pdf").delete();
				
				File file = new File("/sdcard/data.pdf");
				out = new FileOutputStream(file);
				//out.write(bytes);
				out.write(bytearray);
				out.close();
				
				//PhoneGap_PDF_Activity launcher = new PhoneGap_PDF_Activity();
				//launcher.openPDF(file);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return "fail";
			} catch (IOException e) {
				e.printStackTrace();
				return "fail";
			}
	    	
	    	return "success";
	  }// makePDF() ends...
	
	/**
	 * WORKING FINE... IN CASE TO WRITE TO A FILE
	 */
	public String callService4(){
    	
    	String fileName = "data.pdf";
    	try{
    		
    		File dir = new File("/sdcard/");
    		/*if(!dir.exists()){
    			Log.d("DownloaderPlugin", "directory /sdcard/"+dirName+" created");
    			dir.mkdirs();
    		}*/
    	 
    		File file = new File("/sdcard/"+fileName);
    	 
    		/*if(overwrite.equals("false") && file.exists()){
    			Log.d("DownloaderPlugin", "File already exist");
    			return new PluginResult(PluginResult.Status.OK, "exist");
    		}*/
    	 
    		URL url = new URL("http://www.delogico.com/test.asmx/ReturnPdf");
    		HttpURLConnection ucon = (HttpURLConnection) url.openConnection();
    		ucon.setRequestMethod("GET");
    		ucon.setDoOutput(true);
    		ucon.connect();
    		
    		InputStream is = ucon.getInputStream();
    		
    		byte[] buffer = new byte[1024];
    		int len1 = 0;
    		FileOutputStream fos = new FileOutputStream(file);
    	 
    		while ( (len1 = is.read(buffer)) > 0 ) {
    			fos.write(buffer,0, len1);
    		}
    	 
    		fos.close();
    		
    		/********************************************************************/
          	/*InputStream inputStream = connection.getInputStream();
        	System.out.println("*******************************************************"+inputStream.read());*/
          	
          	/********************************************************************/
          	/*BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          	String line;      
          	//InputStream in = connection.getInputStream();
          	//int c;
          	while ((line=rd.readLine()) != null) {
    	         System.out.println(line);
          	}
          	rd.close();*/
          	
          	/********************************************************************/
    	 
    	}catch (IOException e) {
    		return "file downloading failed...";
    	 
    	}
        return "file downloaded successfully";
    } // callService4() ends...
	
	
	/**
	 * NOT WORKING
	 */
	public void callService1(){
		System.out.println("1");
        
        final String METHOD_NAME = "ReturnPdf";
        final String NAMESPACE = "http://tempuri.org/";
        final String SOAP_ACTION = NAMESPACE + METHOD_NAME;				//"http://tempuri.org/carsowners";
        final String URL = "http://www.delogico.com/test.asmx/";
        SoapObject result = null;
        SoapPrimitive result3 = null;
        String result2 = null;
        
        System.out.println("SETTING VARIABLES...");
        
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        System.out.println("3");
        PropertyInfo pi = new PropertyInfo();
        pi.setName("CarRegistrationNo");
        pi.setValue(123);
        request.addProperty(pi);
        PropertyInfo pi2 = new PropertyInfo();
        pi2.setName("Content-Length");
        pi2.setValue(String.valueOf("123456".length()));
        //request.addProperty(pi2);
        //request.addProperty("CarRegistrationNo", 123);
        //request.addProperty("Content-Length", String.valueOf("123456".length()));
        
        System.out.println("4");
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.encodingStyle = SoapSerializationEnvelope.XSD;
        envelope.setOutputSoapObject(request);

        System.out.println("5");
        AndroidHttpTransport androidHttpTransport = new AndroidHttpTransport(URL);
        
        System.out.println("6");
        Object temp = null;
        try {
        	//androidHttpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			androidHttpTransport.call(SOAP_ACTION, envelope);
			System.out.println("7");
			result = (SoapObject)envelope.getResponse();
			//temp = (Object) envelope.bodyIn;
			//System.out.println(temp.toString());
			System.out.println("8");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
		
		//result2 = result.toString();
		//result2 = androidHttpTransport.responseDump;
	}  // callService1() ends...

}

