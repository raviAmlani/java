package com.code.others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import com.itextpdf.text.log.SysoLogger;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;


public class Temp {

	
	static Integer a; 
	public static void main(String[] args) {
		
		//parseXML();
		
		/*EDRS edrs = new EDRS();
		ArrayList<EDR> listEDR = edrs.getListOfEDR();
		EDR edr = listEDR.get(0);
		AffectedData aData = edr.getAffectedData();
		ArrayList<String> aDataValues = aData.getaDataValues();*/
		
		
	try {
		
		/*********************************************/
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("Ravi", "Amlani"));
		list.add(new User("Ronaldo", "Football"));
		list.add(new User("Yusuf", "Cricket"));
		
		System.out.println(list.size());
		User userDelete = null;
		for(User user:list){
			System.out.println(user.getFname());
			if(user.getFname().equalsIgnoreCase("Ronaldo")){
				userDelete = user;
			}
		}
		list.remove(userDelete);
		System.out.println(list.size());
		for(User user:list){
			System.out.println(user.getFname());
		}
		/*********************************************/
		
		System.out.println("***************************************\n");
		String tokens[] = {"", "", ""};
		String str = "_6_789";
    	if(str != null && !str.equals("")){
    		StringTokenizer st = new StringTokenizer(str, "_");
    		int i = 0;
    		while(st.hasMoreElements()){
        		tokens[i] = st.nextElement()+"";
        		System.out.println(tokens[i]+" - "+i);
        		i++;
        	}
    	}
		
    	/***********************************************/
    	
    	System.out.println("***************************************\n");
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    	
    	// Some date conversion examples and comparison demos...
    	
    	String desde = sdf.format(new Date("02/02/2012 15:43:48"));
    	//String hasta = sdf.format(new Date());
    	//String hasta = sdf.format(new Date("02/02/2012 15:43:48"));
    	String hasta = sdf.format(new Date("02/02/2012 15:43:47"));
    	
    	Date dateDesde = sdf.parse(desde);
        Date dateHasta = sdf.parse(hasta);
        
        System.out.println(desde+ " :: "+hasta);
        System.out.println(dateDesde.before(dateHasta));
        System.out.println(dateDesde.compareTo(dateHasta));
        
    	/***********************************************************/
        
        System.out.println("***************************************\n");
        String withComma = "11,_22, 033_, 45 6, "; 
        //withComma = "-1,123,,,456";
        //withComma = "1_2_3,1_2,1_2,1_2";
        String[] results = withComma.split( ",\\s*" ); // this will trim the whiteSpace also.
        for(String op : results){
        	System.out.println("-->"+op);
        }
        System.out.println("--------------------");
        results = withComma.split(",");
        for(String op : results){
        	System.out.println("-->"+op);
        }
        results = "2000_2012_55".split("_\\s*");
        
        System.out.println("--------------------");
        String withPipe = "123|abc";
        results = withPipe.split( "\\|\\s*" ); // this will trim the whiteSpace also.
        for(String op : results){
        	System.out.println("-->"+op);
        }
        
        
        /***********************************************************/
        //Change the date format.
        System.out.println("***************************************\n");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date d1  = sdf.parse(desde);
        sdf2.applyPattern("yyyyMMddHHmmss");
        String mydt = sdf2.format(d1);
        System.out.println(mydt);
        	
        /***********************************************************/
        
        System.out.println("***************************************\n");
        System.out.println("200020120015".compareTo("200020120018"));
        
        /***********************************************************/
        
        System.out.println("***************************************\n");
        String urlFromDb = "https://integracion.redabogacia.org/plataformafirma/printRecuperarPDF.do?ID_CLIENTE={0}&ID_VALIDACION={1}";
        System.out.println(urlFromDb.contains("{0}"));
        if(urlFromDb.contains("{0}")){
        	urlFromDb = urlFromDb.replace("{0}", "ABCD");
        }
        System.out.println(urlFromDb);
        
        /***********************************************************/
        
        System.out.println("***************************************\n");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("3");
        list2.add("4");
        String []arr = new String[list2.size()];
        int i = 0;
        boolean b = true;
        Set<String> set = new HashSet<String>();
        
        for(String str2 : list2){
        	b = true;
        	
        	// 1. Copying to Array by detecting duplicates.
        	if((arr[0] != null)){
        		for(int j = 0; j <= i; j++){
        			if(arr[j] != null){
        				if(arr[j].equals(str2)){
                			b = false;
                			System.out.println("Broke here : "+str2);
                		}	
        			}
            	}
        	}
        	
        	if(b){
        		arr[i] = str2;
        		i++;
        	}
        	
        }
        
        for(i = 0; i < arr.length; i++){
        	System.out.println("At "+i+" : "+arr[i]);
        }
        
        // 2. Copying to Set and then to Array
        
        set.addAll(list2);
        System.out.println("set size : "+set.size());
        String []arr2 = set.toArray(new String[0]);
        System.out.println("arr2 size : "+arr2.length);
        for(i = 0; i < arr2.length; i++){
        	System.out.println("At "+i+" : "+arr2[i]);
        }
        set.clear();
        
        /***********************************************************/
        
        System.out.println("***************************************\n");
        
        String b64Checking = "MIIFxTCCA62gAwIBAgIQODRqumVrBLlEBX80NHvprjANBgkqhkiG9w0BAQUFADBdMQswCQYDVQQGEwJFUzEoMCYGA1UECgwfRElSRUNDSU9OIEdFTkVSQUwgREUgTEEgUE9MSUNJQTENMAsGA1UECwwERE5JRTEVMBMGA1UEAwwMQUMgUkFJWiBETklFMB4XDTA2MDMwMTExMDIxMloXDTIxMDIyNjIyNTk1OVowXDELMAkGA1UEBhMCRVMxKDAmBgNVBAoMH0RJUkVDQ0lPTiBHRU5FUkFMIERFIExBIFBPTElDSUExDTALBgNVBAsMBEROSUUxFDASBgNVBAMMC0FDIEROSUUgMDAyMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtZU2lsKC6YpkuA8D14IWZiNB5g9LeUOPDeAB6bLTQJiE42Ee37AXYMGBnev/A8DOhFNiwuakz1bacCOyugn80jkdjXrI/wlsyibhff3oNnOwHTVkuMGwP507e8nkOVMH+8Cr+eGYFdYG8tjwOAcHSBUiDFosHVtybZFnoevJkkpFWc2VWOp0crvts8h6iwxCLnhfK4fiTDxtMJOPp2ardC87fdYOorNYapiTgMtoVqOnJse9rUGg3p9s5IBSu6e5d5/QWj+HQe/RoEJLCvPY701OxjuV8pT+J8x05r5PvGReo9U5K9IMASSoiIt+ZgxhWtGoH8WdcioQa5x+gCjJkwIDAQABo4IBgDCCAXwwEgYDVR0TAQH/BAgwBgEB/wIBADAdBgNVHQ4EFgQUOqaJ7BXoJGRx4CV+ybFiMQfpBqIwHwYDVR0jBBgwFoAUjkX0n3PF/y8bBdsBR2AbA4qBt7owDgYDVR0PAQH/BAQDAgEGMDcGA1UdIAQwMC4wLAYEVR0gADAkMCIGCCsGAQUFBwIBFhZodHRwOi8vd3d3LmRuaWUuZXMvZHBjMIHcBgNVHR8EgdQwgdEwgc6ggcuggciGIGh0dHA6Ly9jcmxzLmRuaWUuZXMvY3Jscy9BUkwuY3JshoGjbGRhcDovL2xkYXAuZG5pZS5lcy9DTj1DUkwsQ049QUMlMjBSQUlaJTIwRE5JRSxPVT1ETklFLE89RElSRUNDSU9OJTIwR0VORVJBTCUyMERFJTIwTEElMjBQT0xJQ0lBLEM9RVM/YXV0aG9yaXR5UmV2b2NhdGlvbkxpc3Q/YmFzZT9vYmplY3RjbGFzcz1jUkxEaXN0cmlidXRpb25Qb2ludDANBgkqhkiG9w0BAQUFAAOCAgEAdEyWbiWbqVUdqQDKXQVmZBYAweWMMYRrEQSsorp125Y/f7lfQMihNKeSTfJilIKgs/Bvph1VxBjK6aj7EZy4MQS10ScyecSokgfznUjPoZAS7yR7QSX0GTUj/mtJWfQv13s4jFdZo+zE8O0PGf/LgMIdqprsj1DRCDZMBu2vBV2pwSK6UdFUJMPcSYfRgQWthHRDPsp3uVlkuhfcfJ09/eocXDSIpmWfACkeO+kydc/3wZdfoRWCciPkJDRKkjmhn3qwTDyQbZC/DbRftF26UfTSMgU0FJtXgI/7UqbpALXHkCoEszz3htmnz2ETbH8F6SnR8q4E254EJyNOi0KhJa43eJ7G/RPLgD+EjuW/DyN1lZRw2cTE0l3JBTJ2NMZe4+EB8CMttFAfItp1J6S65FSc1T8yRfnphteJshRqbJ/L2VN8kdEFdeuvPPnh5aaIs/Ud2zFSWpqDaXjXdINJXEnicMqlasrvITE32GaiQtLpifh1jai6YWK7TZPQKPI6Ijql9oNsIpd/yy6XxJYoW8xSbtniYypnajrpm48Lwb1NcWPhIdeJlKJii4Lw4F+7u0EGU2t6PdkoFGIcf46aNN3mPzMBmihskrKw+NqhU1LDoZdwyvhweV6LV0dypWN+/EeSHsZv7zkKAVN7HIcNI71Bkn1W8PVFhJWUc62n7ZA=";
        	/*"0‚Ò0‚º 0"+
				"	*†H†÷"+
				"";*/
//        	"MIIFxTCCA62gAwIBAgIQODRqumVrBLlEBX80NHvprjANBgkqhkiG9w0BAQUFADBdMQswCQYDVQQGEwJFUzEoMCYGA1UECgwfRElSRUNDSU9OIEdFTkVSQUwgREUgTEEgUE9MSUNJQTENMAsGA1UECwwERE5JRTEVMBMGA1UEAwwMQUMgUkFJWiBETklFMB4XDTA2MDMwMTExMDIxMloXDTIxMDIyNjIyNTk1OVowXDELMAkGA1UEBhMCRVMxKDAmBgNVBAoMH0RJUkVDQ0lPTiBHRU5FUkFMIERFIExBIFBPTElDSUExDTALBgNVBAsMBEROSUUxFDASBgNVBAMMC0FDIEROSUUgMDAyMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtZU2lsKC6YpkuA8D14IWZiNB5g9LeUOPDeAB6bLTQJiE42Ee37AXYMGBnev/A8DOhFNiwuakz1bacCOyugn80jkdjXrI/wlsyibhff3oNnOwHTVkuMGwP507e8nkOVMH+8Cr+eGYFdYG8tjwOAcHSBUiDFosHVtybZFnoevJkkpFWc2VWOp0crvts8h6iwxCLnhfK4fiTDxtMJOPp2ardC87fdYOorNYapiTgMtoVqOnJse9rUGg3p9s5IBSu6e5d5/QWj+HQe/RoEJLCvPY701OxjuV8pT+J8x05r5PvGReo9U5K9IMASSoiIt+ZgxhWtGoH8WdcioQa5x+gCjJkwIDAQABo4IBgDCCAXwwEgYDVR0TAQH/BAgwBgEB/wIBADAdBgNVHQ4EFgQUOqaJ7BXoJGRx4CV+ybFiMQfpBqIwHwYDVR0jBBgwFoAUjkX0n3PF/y8bBdsBR2AbA4qBt7owDgYDVR0PAQH/BAQDAgEGMDcGA1UdIAQwMC4wLAYEVR0gADAkMCIGCCsGAQUFBwIBFhZodHRwOi8vd3d3LmRuaWUuZXMvZHBjMIHcBgNVHR8EgdQwgdEwgc6ggcuggciGIGh0dHA6Ly9jcmxzLmRuaWUuZXMvY3Jscy9BUkwuY3JshoGjbGRhcDovL2xkYXAuZG5pZS5lcy9DTj1DUkwsQ049QUMlMjBSQUlaJTIwRE5JRSxPVT1ETklFLE89RElSRUNDSU9OJTIwR0VORVJBTCUyMERFJTIwTEElMjBQT0xJQ0lBLEM9RVM/YXV0aG9yaXR5UmV2b2NhdGlvbkxpc3Q/YmFzZT9vYmplY3RjbGFzcz1jUkxEaXN0cmlidXRpb25Qb2ludDANBgkqhkiG9w0BAQUFAAOCAgEAdEyWbiWbqVUdqQDKXQVmZBYAweWMMYRrEQSsorp125Y/f7lfQMihNKeSTfJilIKgs/Bvph1VxBjK6aj7EZy4MQS10ScyecSokgfznUjPoZAS7yR7QSX0GTUj/mtJWfQv13s4jFdZo+zE8O0PGf/LgMIdqprsj1DRCDZMBu2vBV2pwSK6UdFUJMPcSYfRgQWthHRDPsp3uVlkuhfcfJ09/eocXDSIpmWfACkeO+kydc/3wZdfoRWCciPkJDRKkjmhn3qwTDyQbZC/DbRftF26UfTSMgU0FJtXgI/7UqbpALXHkCoEszz3htmnz2ETbH8F6SnR8q4E254EJyNOi0KhJa43eJ7G/RPLgD+EjuW/DyN1lZRw2cTE0l3JBTJ2NMZe4+EB8CMttFAfItp1J6S65FSc1T8yRfnphteJshRqbJ/L2VN8kdEFdeuvPPnh5aaIs/Ud2zFSWpqDaXjXdINJXEnicMqlasrvITE32GaiQtLpifh1jai6YWK7TZPQKPI6Ijql9oNsIpd/yy6XxJYoW8xSbtniYypnajrpm48Lwb1NcWPhIdeJlKJii4Lw4F+7u0EGU2t6PdkoFGIcf46aNN3mPzMBmihskrKw+NqhU1LDoZdwyvhweV6LV0dypWN+/EeSHsZv7zkKAVN7HIcNI71Bkn1W8PVFhJWUc62n7ZA="; 
//        	"MIID0jCCArqgAwIBAgIBATANBgkqhkiG9w0BAQUFADCBgDELMAkGA1UEBhMCRVMxNjA0BgNVBAoTLUNvbnNlam8gR2VuZXJhbCBkZSBsYSBBYm9nYWNpYSBOSUY6US0yODYzMDA2STE5MDcGA1UEAxMwQXV0b3JpZGFkIGRlIENlcnRpZmljYWNpb24gZGUgbGEgQWJvZ2FjaWEgLSBEZW1vMB4XDTA1MDUxNzIyMDAwMFoXDTMwMDUxNzIyMDAwMFowgYAxCzAJBgNVBAYTAkVTMTYwNAYDVQQKEy1Db25zZWpvIEdlbmVyYWwgZGUgbGEgQWJvZ2FjaWEgTklGOlEtMjg2MzAwNkkxOTA3BgNVBAMTMEF1dG9yaWRhZCBkZSBDZXJ0aWZpY2FjaW9uIGRlIGxhIEFib2dhY2lhIC0gRGVtbzCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAN73pFbi7SCYfXeYljzOQbEydF1TGZhg3Vy9pJWgoM2yOipzu/xvQtBTS0qiqalcH5OuQGqvvd/mqih8IWrA5MRDrYzWtcDZCa1qFg3d7Tte0/ApodkCQQg7TtrbLjnNKsutlDqr2QaWRioTO427gX3FYKUVA2lgGISdhoviALpHPUpdQ4MPzmsGG7AXwhWY7spuXqIGPQtohVY0obnUCpI46E8UTVQjbxjDnvw8hyIHWYdXkBxsCC7bt7ZY8JtuUJeYnmZdoJFV9M3rbHppiQs9zlC/7BRvzWndZm+nnTT/CbiHj/LKw5x5GIA79bzPieZmsTwWxlGC09DPtrThXr0CAwEAAaNVMFMwDwYDVR0TAQH/BAUwAwEB/zAOBgNVHQ8BAf8EBAMCAQYwEQYJYIZIAYb4QgEBBAQDAgAHMB0GA1UdDgQWBBSy28xcWSFWiQs8jLcKarRf0GkqqDANBgkqhkiG9w0BAQUFAAOCAQEAo6j0EGY8w54T5sNrD7BD2IsONu3HlzeMbe5VhEqXQytVcudC3yQjAzspFj3jFQsQu6qjmW4By6TnKVbjhoMX7BnU2nO3nuZYLu1YgvWNLCH2B7h3cay953B3YeMjae8FSrZ3iGlysXP9d80eqrk8623v+rODuJ/KmdDesL7NXEIs8jXAcG2gNJt/Szd4D1aj6SNi9HXLmgH7Ph1InS8jeSsxagSoUBBJ/ELjMKKaZat9H/GhfUxJ1Itb/S80+JhEeEmUWxWs6C0+1sSttQ4D1WTcydpZF6DM2vWzkS0f22PJ5a5BO9iVaIAmochfNpwVVOcuZAB/RoJtaVOm+NCiig=="; 
//        	"MIIEvDCCA6SgAwIBAgIQAJCLMk/BkBrOtMM4Cc3P5DANBgkqhkiG9w0BAQUFADB5MQswCQYDVQQGEwJFUzE2MDQGA1UEChMtQ29uc2VqbyBHZW5lcmFsIGRlIGxhIEFib2dhY2lhIE5JRjpRLTI4NjMwMDZJMTIwMAYDVQQDEylBdXRvcmlkYWQgZGUgQ2VydGlmaWNhY2lvbiBkZSBsYSBBYm9nYWNpYTAeFw0wNTA2MTMyMjAwMDBaFw0zMDA2MTMyMjAwMDBaMHkxCzAJBgNVBAYTAkVTMTYwNAYDVQQKEy1Db25zZWpvIEdlbmVyYWwgZGUgbGEgQWJvZ2FjaWEgTklGOlEtMjg2MzAwNkkxMjAwBgNVBAMTKUF1dG9yaWRhZCBkZSBDZXJ0aWZpY2FjaW9uIGRlIGxhIEFib2dhY2lhMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtLJX7oXwI+gN+7KAhPEQZ6uy+UnfXN5b5I8pGVPJ1egcUGthAoyH8I88wUWSC6yZocYahdY9rX4mph24PbKzPorFCjLTS5HvSXV+Vvf+oAhiRivO6vJRn2DeMsjtGqfPdVzrPcC9mkilhpTOWFAU6mrhmvSMZZXhYBUllRL2uniLssDt5myXJFod5HRDyjjENZRYjvWKsGg8KCxElgm/CVtyCudnPJC5VDh0VLttLWpDyLzvCawfI+hSVl41F18ru17NZVKlFHw7sqrp3Se1NyM7Bg0se4262m9mF4anttceB10ebBmXyOUjc3jRrvkeuqGuSSLtZXEff/dadESNQwIDAQABo4IBPjCCATowNwYDVR0RBDAwLoERYWNAYWNhYm9nYWNpYS5vcmeGGWh0dHA6Ly93d3cuYWNhYm9nYWNpYS5vcmcwDwYDVR0TAQH/BAUwAwEB/zAOBgNVHQ8BAf8EBAMCAQYwEQYJYIZIAYb4QgEBBAQDAgAHMB0GA1UdDgQWBBT8iEyObQShIJDT+Byas2cEX3mAxjCBqwYDVR0gBIGjMIGgMIGdBgsrBgEEAYGBFQoBATCBjTApBggrBgEFBQcCARYdaHR0cDovL3d3dy5hY2Fib2dhY2lhLm9yZy9kb2MwYAYIKwYBBQUHAgIwVBpSQ29uc3VsdGUgbGEgZGVjbGFyYWNpb24gZGUgcHJhY3RpY2FzIGRlIGNlcnRpZmljYWNpb24gZW4gaHR0cDovL3d3dy5hY2Fib2dhY2lhLm9yZzANBgkqhkiG9w0BAQUFAAOCAQEAmKf6ObVzESZ/vIk/tGslMzEKhjhryR4VlxTg0kwthfQ8dJuNKBH7zA4muYCDFtH5Rpi2RgeOZoVtcMC6TIDzpPDVN1Qrr2aEcnP5SC8JzuGFAcqP4IfeoJfQlLQNtU0OZyzIYMQylMBBgQeNur+p6AxAmkJ4BV2B62Ic5E8UCj0LPh/p9M197kW7vN5d85iXJnvGEyn4K38a1Or6sm4gntoX6qGSvTfpDru7kdUl9mBdhSFQW/9UXfVLO7TDKRFYAvYl5OGCgruijeeRJF5AkZ5HB4wzV9RiMVF2dYVDbwmrEaUlKbnY/1+l9z/rZTsd74blFiLVHsoyaX1+BdcwJw=="; 
//        	"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"; 
//        	"MIIHSzCCBjOgAwIBAgIQOWVw69ifKCBOwqBrmEgxDTANBgkqhkiG9w0BAQUFADCB5TELMAkGA1UEBhMCRVMxIDAeBgkqhkiG9w0BCQEWEWFjQGFjYWJvZ2FjaWEub3JnMSUwIwYDVQQHExxQYXNlbyBkZSBSZWNvbGV0b3MgMTMgTWFkcmlkMSswKQYDVQQLEyJDb25zdWx0ZSBodHRwOi8vd3d3LmFjYWJvZ2FjaWEub3JnMTYwNAYDVQQKEy1Db25zZWpvIEdlbmVyYWwgZGUgbGEgQWJvZ2FjaWEgTklGOlEtMjg2MzAwNkkxKDAmBgNVBAMTH0FDQSAtIENlcnRpZmljYWRvcyBDb3Jwb3JhdGl2b3MwHhcNMTExMTE1MTY1NjIxWhcNMTQxMTE1MTY1NjIxWjCCATYxFzAVBgorBgEEAYGBFR4BEwdBQk9HQURPMRAwDgYDVQQEEwdBQk9HQURPMQ8wDQYDVQQqEwZQUlVFQkExEjAQBgNVBAUTCTU2NTY1NjU3RDEQMA4GA1UEDBMHQWJvZ2FkbzEPMA0GA1UECBMGTWFkcmlkMQswCQYDVQQGEwJFUzE+MDwGA1UEChQ1Q29uc2VqbyBHZW5lcmFsIGRlIGxhIEFib2dhY+1hIEVzcGHxb2xhIC8gQ0dBRSAvIDIwMDAxFzAVBgNVBAsTDjI4MDA0IC8gNDU0NTQ1MTYwNAYDVQQDEy1OT01CUkUgQUJPR0FETyBBQk9HQURPIFBSVUVCQSAtIE5JRiA1NjU2NTY1N0QxIzAhBgkqhkiG9w0BCQEWFGFuYS52YXpxdWV6QHBhbmVsLmVzMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDnYRB0BtgBvOwczJICvWqrsSHOx01zNfq7G1x+kORCDOUMYdGfFrorbV9FvdF8LM/OdnP0JyLZcC4oIo+dMVmzVWiRn0XOK6fhTTwMVaFPsbOED3ag/KDRUo0yBrks4PKLfBA2HmsA1eNpPcu3Wg5PV1a52B+PZq3xDZYNSmoIfwIDAQABo4IDJTCCAyEwJAYDVR0SBB0wG4YZaHR0cDovL3d3dy5hY2Fib2dhY2lhLm9yZzAfBgNVHREEGDAWgRRhbmEudmF6cXVlekBwYW5lbC5lczAMBgNVHRMBAf8EAjAAMA4GA1UdDwEB/wQEAwID+DAdBgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwQwEQYJYIZIAYb4QgEBBAQDAgWgMCwGCWCGSAGG+EIBCAQfFh1odHRwOi8vd3d3LmFjYWJvZ2FjaWEub3JnL2RvYzBkBglghkgBhvhCAQ0EVxZVRXN0ZSBlcyB1biBjZXJ0aWZpY2FkbyBwZXJzb25hbCByZWNvbm9jaWRvLiBDb25zdWx0ZSAgaHR0cDovL3d3dy5hY2Fib2dhY2lhLm9yZy9kb2MNCjAdBgNVHQ4EFgQU8uIg8yKL/2BYcHbtEHJxcOTX8KcwHwYDVR0jBBgwFoAUZI2vMCV4cFxwFTRZPnJSxOoX5GcwgawGA1UdIASBpDCBoTCBngYLKwYBBAGBgRUKAgEwgY4wKQYIKwYBBQUHAgEWHWh0dHA6Ly93d3cuYWNhYm9nYWNpYS5vcmcvZG9jMGEGCCsGAQUFBwICMFUaU0VzdGUgZXMgdW4gY2VydGlmaWNhZG8gcGVyc29uYWwgcmVjb25vY2lkby4gQ29uc3VsdGUgIGh0dHA6Ly93d3cuYWNhYm9nYWNpYS5vcmcvZG9jMFYGCCsGAQUFBwEBBEowSDBGBggrBgEFBQcwAoY6aHR0cDovL3d3dy5hY2Fib2dhY2lhLm9yZy9jZXJ0aWZpY2Fkb3MvQUNBY29ycG9yYXRpdm9zLmNydDAvBggrBgEFBQcBAwQjMCEwCAYGBACORgEBMBUGBgQAjkYBAjALEwNFVVICAQYCAQQwfAYDVR0fBHUwczBxoG+gbYY0aHR0cDovL3BpbG90by5hY2Fib2dhY2lhLm9yZy9jcmwvQUNBY29ycG9yYXRpdm9zLmNybIY1aHR0cDovL3BpbG90by5hY2Fib2dhY2lhLm9yZy9jcmwyL0FDQWNvcnBvcmF0aXZvcy5jcmwwDQYJKoZIhvcNAQEFBQADggEBAJpVo+79L/P9u4M41q0gWd7P4YMpgvRguEKxEX9zBsUCwJY7gWyksoY/HwI4o45bAR0pLxpdkl4LA14NlqTGSMCgg7SmvqXiDuhqq4FeTA23YgCMBtzCHV60QzW8tpYMXyf+yuyXa1naNLSIOBs948yOYbxbljZ1AAzXVNH0quXP9pDWfSj2ZSxBk0UmxOE2AkJ1ht4Fl+9dkXEZzr/MbYpawn1VVvMXdgLIpPedg0eUeZUPv4iKzZjveyc7E9t/Ufcs+LzezmVLAzy3ZUNvjtr2jIuLwAOxLK1EwI4m6bBebBZvqVNi1/mlYh6Va9+8hHmes2pXA2nOuskz42NkegE=";
        InputStream is = new ByteArrayInputStream(b64Checking.getBytes("UTF-8"));
        byte []isB64 = bytesDesdeInputStream(is, is.available());
        
        System.out.println("Base64 bytes ----> "+Base64.isArrayByteBase64(isB64));
        System.out.println("base64 String ---> "+Base64.isBase64(b64Checking));
        
        
        /***********************************************************/
        
        System.out.println("***************************************\n");
        
//      long diff = (d4.getTime() - d3.getTime())/(1000 * 60 * 60 * 24);
        
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        Date temp = new Date();
        
//        start.set(2012, 4, 4);  //  YYYY,MM,DD
//        start.set(temp.getYear(), temp.getMonth(), temp.getDate());
//        System.out.println(temp.getYear() +" - "+ temp.getMonth() +" - "+ temp.getDate() +" / "+ temp.getDay());
        end.set(2012, 4, 5);
//        end.setTime(new Date(arg0, arg1, arg2));
        
        Date startDate = start.getTime();
        Date endDate = end.getTime();
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        DateFormat dateFormat = DateFormat.getDateInstance();
        System.out.println("The difference between "+
          dateFormat.format(startDate)+" and "+
          dateFormat.format(endDate)+" is "+
          diffDays+" days.");
        System.out.println((end.getTimeInMillis() - start.getTimeInMillis()) / (1000 * 60 * 60 * 24));
        
        /*int day = cal.get(Calendar.DATE);
        12.
        int month = cal.get(Calendar.MONTH) + 1;
        13.
        int year = cal.get(Calendar.YEAR);*/
        Calendar temp1 = Calendar.getInstance();
        System.out.println(temp1.get(Calendar.DATE)+" "+(temp1.get(Calendar.MONTH) + 1) + " "+temp1.get(Calendar.YEAR));
        Calendar temp2 = Calendar.getInstance();
//        temp2.setTime(d);
        temp2.set(2012, 3, 5);
        System.out.println(temp2.get(Calendar.DATE)+" "+(temp2.get(Calendar.MONTH) + 1) + " "+temp2.get(Calendar.YEAR));
        
        diffDays = (temp2.getTime().getTime() - temp1.getTime().getTime())/(1000 * 60 * 60 * 24);
        System.out.println(diffDays);
        
        
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = sdf.parse("5/7/2012");
        System.out.println(d.getYear() +" - "+ d.getMonth() +" - "+ d.getDate());
        sdf = new SimpleDateFormat("yyyy");
        System.out.println(sdf.format(d));
        temp2.set(Integer.parseInt(sdf.format(d)), d.getMonth(), d.getDate());
        diffDays = (temp2.getTime().getTime() - temp1.getTime().getTime())/(1000 * 60 * 60 * 24);
        System.out.println(diffDays);
        
        
        /***********************************************************/
        
        System.out.println("***********************************************************");
        String texto = "El certificado cuya descripcion es {0} está próximo a expirar, su fecha de caducidad es {1} Por favor , proceda a su renovacion y actualicelo en el sistema.";
        System.out.println(texto.replace("{0}", "ABC"));
        
        System.out.println("***********************************************************");
        
        /***********************************************************/
        
        System.out.println("Hello");

		
		System.out.println("--->"+getA());
		setA(2);
		System.out.println("--->"+getA());
		System.out.println("Hello");
        
		System.out.println("***********************************************************");
        
        /***********************************************************/
		
		String subTest = "/genericos/redabogacia.pfx";
		System.out.println(subTest.substring((subTest.lastIndexOf("/"))+1));
		System.out.println("".getBytes());
		System.out.println("***********************************************************");
        
        /***********************************************************/
      
		System.out.println("JAVA_HOME = "+System.getProperty("java.home"));
		
		System.out.println("***********************************************************");
        
        /***********************************************************/
		
		ArrayList<User> listUser = new ArrayList<User>();
		listUser.add(new User("ZZ", "ZX"));
		listUser.add(new User("YY", "YZ"));
		listUser.add(new User("PP", "PR"));
		listUser.add(new User("DD", "DR"));
		listUser.add(new User("KK", "KR"));
		
		for(User user : listUser){
			System.out.println(" --> "+user.getFname());
		}
		
		System.out.println("\n");
		Collections.sort(listUser, User.fNameComparator);
		
		for(User user : listUser){
			System.out.println(" --> "+user.getFname());
		}
		
		System.out.println("***********************************************************");
        
        /***********************************************************/
		
		/*String withQuotes = "Hello \"world\"...\"how are you\"";
		System.out.println(withQuotes);
		System.out.println(withQuotes.replaceAll("\"", "'"));
		
		BufferedReader br = new BufferedReader(new FileReader(new File("D:\\GeoPC_ES.sql")));
        String line;
        int lineNo = 1; 
        while((line = br.readLine()) != null) {
             System.out.println(line.replaceAll("\"", "'"));
             lineNo++;
             
        }*/

        /***********************************************************/
		
		System.out.println("***********************************************************");
		
		/**
		 * MD5 can be done by 3 methods.
		 */
		
		/**
		 * 1.Integer.toHexString() method
		 */

		String message = "000999000";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			String res = hex (md.digest(message.getBytes("CP1252"))); 
			System.out.println("Using Integer class : "+res);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) { 
			e.printStackTrace();
		} 

		
		/**
		 * 2. using BigInteger class.
		 */
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] md5sum = md.digest(message.getBytes());
			BigInteger number = new BigInteger(1,md5sum);
			String res = number.toString(16);
			System.out.println("Using BigInteger class : "+res);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		/**
		 * 3.using Base64
		 */
		try {
			MessageDigest md  = MessageDigest.getInstance("MD5");
			md.update(message.getBytes("UTF-8"));
			byte rawByte[] = md.digest();
			String res = (new sun.misc.BASE64Encoder() ).encode(rawByte);
			System.out.println("Using Base64Encoder class : "+res);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("No Such Algorithm Exists");
		} catch (UnsupportedEncodingException e) {
			System.out.println("The Encoding Is Not Supported");
		}

        
        /***********************************************************/
		
		System.out.println("***********************************************************");
		
		System.out.println("File avail ? : "+new File("test_cer.txt").isFile());
		
		File f = new File("test_cer.txt");
		BufferedReader br = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		StringBuffer buffer = new StringBuffer();
		try {
			
			// 1. CER TO STRING
			fis = new FileInputStream(f);
			isr = new InputStreamReader(fis, Charset.forName("UTF-8"));  // ISO-8859-1
			br = new BufferedReader(isr);
			
			String line = null;
	        while((line = br.readLine()) != null) {
	        	buffer.append(line+"\n");
	        }
	        
	        br.close();
	        isr.close();
	        
	        String cer = buffer.toString();
	        System.out.println(cer);
	        
	        
	        // 2. STRING TO INPUTSTREAM 
	        InputStream inputStream_cer = new ByteArrayInputStream(cer.getBytes());
	        
	        // 3. CONVERT INPUTSTREAM TO STRING
	        byte[] bytes_cer = bytesDesdeInputStream(inputStream_cer,inputStream_cer.available());
	        System.out.println("-->"+bytes_cer);
	        System.out.println("-->"+cer.getBytes());
	        inputStream_cer.close();

			String string_cer =  new String(bytes_cer);
			System.out.println(string_cer);
			
			// ENCODE IT TO BASE64
			String cer_b64 = Base64.encodeBase64String(bytes_cer);
			System.out.println("---\n"+cer_b64);
			String cer_b64_2 = Base64.encodeBase64String(cer.getBytes());
			System.out.println("---\n"+cer_b64);
			
			// DECODING 
			
			byte[] decoded_bytes_cer = Base64.decodeBase64(cer_b64);
			InputStream inputStream_decoded_bytes_cer = new ByteArrayInputStream(decoded_bytes_cer);
			System.out.println("-->"+inputStream_decoded_bytes_cer);
	        byte[] inputStream_decoded_bytes_cer_function = bytesDesdeInputStream(inputStream_decoded_bytes_cer,inputStream_decoded_bytes_cer.available());
	        System.out.println(inputStream_decoded_bytes_cer_function);
	        inputStream_decoded_bytes_cer.close();
			String decoded_cer =  new String(inputStream_decoded_bytes_cer_function);
			System.out.println(">>>>>"+decoded_cer);
			
			System.out.println("--------->");
			
			// BELOW IS SAME AS ABOVE BLOCK
			String a = new String(decoded_bytes_cer);
			System.out.println(a);
			
			// ...
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        /***********************************************************/

		System.out.println("***********************************************************");
		
		Pattern p = Pattern.compile("a*b");
		Matcher m = p.matcher("aaaba");
		System.out.println(m.matches());
        
        /***********************************************************/
		
		System.out.println("***********************************************************");
		String input = "76292708057987193002565060032465481997";
		String hexStr = null;
		
		hexStr = Hex.encodeHexString(input.getBytes());
		System.out.println("org.apache.commons.codec.binary.Hex : hexStr : "+hexStr);
		
		//hexStr = String.format("%x", new BigInteger(1, input.getBytes(CharEncoding.UTF_8)));
		hexStr = String.format("%x", new BigInteger(input));
		System.out.println("Using BigInteger                    : hexStr : "+hexStr);
		
		hexStr = String.format("%040x", new BigInteger(input.getBytes(CharEncoding.UTF_8)));
		System.out.println("Using BigInteger                    : hexStr : "+hexStr);
		
		hexStr = hex(input.getBytes());
		System.out.println("Using hex()                         : hexStr : "+hexStr);

		//i/p : 56565657D
		//i/p : 76292708057987193002565060032465481997
		//res : 396570ebd89f28204ec2a06b9848310d
		//      396570ebd89f28204ec2a06b9848310d
		//42 ec 35 7a 65 1f 35 19 4f 0f f7 ae 0e ec c1 8c
		
		BigInteger bi=new BigInteger(input);
		hexStr = bi.toString(16); 
	    if (hexStr.length() % 2 != 0) {
		   // Pad with 0
	    	hexStr = "0"+hexStr;
		}
	    System.out.println("Using BigInteger without args       : hexStr : "+hexStr);
		

		String regex = "(\\w)(?=(\\w{2})+$)";
		System.out.println(hexStr.replaceAll(regex, "$1 "));
		
	    
        
        /***********************************************************/
		
		System.out.println("***********************************************************");
		
		String[] asset = {"equity", "stocks", "gold", "foreign exchange","fixed income", "futures", "options"};
		List assetList = Arrays.asList(asset);  

//		assetList.add("Added");
		
		List<String> assetList2 = new ArrayList<String>();
		assetList2.addAll(assetList);
		System.out.println("List : "+assetList2);
		assetList2.add("Added");
		System.out.println("List : "+assetList2);
		
        
        /***********************************************************/
		
		System.out.println("***********************************************************");
		
		System.out.println("10 % 20 = "+(10%20));
        
        /***********************************************************/
		
		ArrayList<Exception> expList = new ArrayList<Exception>();
		expList.add(new NullPointerException("Test"));
		
		Exception e = expList.get(0);
		if(e instanceof NullPointerException){
			System.out.println("e instanceof NullPointerException");			
		}
		if(e instanceof Exception){
			System.out.println("e instanceof Exception");			
		}
		if(e instanceof RuntimeException){
			System.out.println("e instanceof RuntimeException");			
		}
		if(e instanceof ArrayIndexOutOfBoundsException){
			System.out.println("e instanceof ArrayIndexOutOfBoundsException");			
		}
		
		
		System.out.println("***********************************************************");
        
        /***********************************************************/
		
		
		System.out.println("***********************************************************");
        
        /***********************************************************/
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
		
	} // main() ends...
	
	
	public static String hex(byte[] array) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; ++i) {
			sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1,3));
		}
		return sb.toString();
	}

	
	
	public static byte[] bytesDesdeInputStream(java.io.InputStream in, int length)
	{
		java.io.DataInputStream din = new java.io.DataInputStream(in);
		byte[] bytecodes = new byte[length];
		try {
			din.readFully(bytecodes);
			if (din != null) din.close();
		}catch (IOException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		return bytecodes;

	}

	/**
	 * @return the a
	 */
	public static Integer getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public static void setA(Integer a) {
		Temp.a = a;
	}

}