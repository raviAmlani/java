/* ----------------------------------------------------------------
 * Nombre de la Clase:  SoapRequestBuilder.java
 * Version: 1.0
 * Fecha:Nov 23, 2011
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> SoapRequestBuilder.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Nov 23, 2011
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class SoapRequestBuilder {
	String Server = "";
	  String WebServicePath = "";
	  String SoapAction = "";
	  String MethodName = "";
	  String XmlNamespace = "";
	  private Vector ParamNames = new Vector();
	  private Vector ParamData = new Vector();

	  public void AddParameter(String Name, String Data) {
	    ParamNames.addElement( (Object) Name);
	    ParamData.addElement( (Object) Data);
	  }

	  public String sendRequest() {
	    String retval = "";
	    Socket socket = null;
	    try {
	      socket = new Socket(Server, 80);
	    }
	    catch (Exception ex1) {
	      return ("Error: "+ex1.getMessage());
	    }

	    try {
	      OutputStream os = socket.getOutputStream();
	      boolean autoflush = true;
	      PrintWriter out = new PrintWriter(socket.getOutputStream(), autoflush);
	      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	      int length = 295 + (MethodName.length() * 2) + XmlNamespace.length();
	      for (int t = 0; t < ParamNames.size(); t++) {
	        String name = (String) ParamNames.elementAt(t);
	        String data = (String) ParamData.elementAt(t);
	        System.out.println("NAME --> "+name);
	        System.out.println("DATA --> "+data);
	        length += name.length();
	        length += data.length();
	      }

	      // send an HTTP request to the web service
	      System.out.println("POST " + WebServicePath + " HTTP/1.1");
	      System.out.println("Host: localhost:80");
	      System.out.println("Content-Type: text/xml; charset=utf-8");
	      System.out.println("Content-Length: " + String.valueOf(length));
	      System.out.println("SOAPAction: \"" + SoapAction + "\"");
	      System.out.println("Connection: Close");
	      System.out.println();

	      System.out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	      System.out.println("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
	      System.out.println("<soap:Body>");
	      System.out.println("<" + MethodName + " xmlns=\"" + XmlNamespace + "\">");
	      //Parameters passed to the method are added here
	      for (int t = 0; t < ParamNames.size(); t++) {
	        String name = (String) ParamNames.elementAt(t);
	        String data = (String) ParamData.elementAt(t);
	        System.out.println("<" + name + ">" + data + "</" + name + ">");
	      }
	      System.out.println("</" + MethodName + ">");
	      System.out.println("</soap:Body>");
	      System.out.println("</soap:Envelope>");
	      System.out.println();

	      // Read the response from the server ... times out if the response takes
	      // more than 3 seconds
	      String inputLine;
	      StringBuffer sb = new StringBuffer(1000);

	      int wait_seconds = 3;
	      boolean timeout = false;
	      long m = System.currentTimeMillis();
	      while ( (inputLine = in.readLine()) != null && !timeout) {
	        sb.append(inputLine + "\n");
	        if ( (System.currentTimeMillis() - m) > (1000 * wait_seconds)) timeout = true;
	      }
	      in.close();

	      // The StringBuffer sb now contains the complete result from the
	      // webservice in XML format.  You can parse this XML if you want to
	      // get more complicated results than a single value.

	      if (!timeout) {
	        String returnparam = MethodName + "Result";
	        int start = sb.toString().indexOf("<" + returnparam + ">") +
	            returnparam.length() + 2;
	        int end = sb.toString().indexOf("</" + returnparam + ">");

	        //Extract a singe return parameter
	        retval = sb.toString().substring(start, end);
	      }
	      else {
	        retval="Error: response timed out.";
	      }

	      socket.close();
	    }
	    catch (Exception ex) {
	      return ("Error: cannot communicate.");
	    }

	    return retval;
	  }
}

