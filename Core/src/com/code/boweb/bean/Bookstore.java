/* ----------------------------------------------------------------
 * Nombre de la Clase:  Bookstore.java
 * Version: 1.0
 * Fecha:Apr 10, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.boweb.bean;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> Bookstore.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Apr 10, 2012
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//This statement means that class "Bookstore.java" is the root-element of our example
//(namespace = "de.vogella.xml.jaxb.model")
@XmlRootElement
@XmlType(propOrder = { "name", "location", "bookList" })
public class Bookstore {

	// XmLElementWrapper generates a wrapper element around XML representation
//	@XmlElementWrapper(name = "bookList")
	// XmlElement sets the name of the entities
	@XmlElement(name = "Book")
	private ArrayList<Book> bookList;
	private String name;
	private String location;

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	public ArrayList<Book> getBooksList() {
		return bookList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}

