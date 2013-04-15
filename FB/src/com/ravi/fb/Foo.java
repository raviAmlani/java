package com.ravi.fb;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Foo {

    public static void main(String[] args)
    {
        /*char escape = 0x1b;
        String text = "invalid" + escape + "string";

        text = text.replace("" + escape, "\\u001b");

        System.out.println(text);*/
    	
    	char character = 0x1b;
    	String unicodeValue = "\\\\u001B"; 
    	String text = "invalid " + character + " string";
    	System.out.println(text);
    	text = text.replaceAll("" + character, unicodeValue);
    	System.out.println(text);
    	
    	Foo foo = new Foo();
    	System.out.println("Now static block will be called again ... ?");
    	
    	System.out.println("\n*************************************************\n");
    	
    	Calendar calc = Calendar.getInstance();
    	System.out.println("-- DEC : " + calc.getTime());
    	
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
        calc.set(Calendar.YEAR, calc.get(Calendar.YEAR) - 1);
        calc.set(Calendar.MONTH, Calendar.NOVEMBER);
        System.out.println("---NOV? : "+calc.getTime());
        System.out.println("---NOV? : " + sdf.format(calc.getTime()));

        Calendar calc1 = Calendar.getInstance();
        calc1.set(Calendar.YEAR, calc1.get(Calendar.YEAR) - 1);
        calc1.set(Calendar.MONTH, Calendar.DECEMBER);
        System.out.println("-- DEC : " + sdf.format(calc1.getTime()));
    	
        System.out.println("\n*************************************************\n");
    	
        try {
        	System.out.println("á");
			System.out.println(URLEncoder.encode("á_a", "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        System.out.println("\n*************************************************\n");
    	
    }
    
    static {
		System.out.println("Hi...I'm from static block :) ");
	}
    
    {
    	System.out.println("This is instance initializer...");
    }
}