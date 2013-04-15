/* ----------------------------------------------------------------
 * Nombre de la Clase:  Customer.java
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
 *<br><b>Nombre Fichero:</b> Customer.java
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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Book")
// If you want you can define the order in which the fields are written
// Optional
@XmlType(propOrder = { "name", "author", "publisher", "isbn" })
public class Book {

	private String name;
	private String author;
	private String isbn;
	private String publisher;

	// If you like the variable name, e.g. "name", you can easily change this
	// name for your XML-Output:
	@XmlElement(name = "book-title")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@XmlAttribute
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
 
