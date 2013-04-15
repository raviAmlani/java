
package com.code.others;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> JDBCExample.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Sep 20, 2012
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
public class JDBCExample {
 
	public static void main(String[] argv) {
 
		System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");
 
		try {
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Drivers not found...!!!");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.31:5432/OPM", "postgres", "admin");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
 
}

