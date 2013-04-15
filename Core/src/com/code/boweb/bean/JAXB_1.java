/* ----------------------------------------------------------------
 * Nombre de la Clase:  JAXB_1.java
 * Version: 1.0
 * Fecha:Apr 10, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.boweb.bean;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> JAXB_1.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Apr 10, 2012
 *<br>
 *<br><b>@author </b> Ravi Amlani
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class JAXB_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*try {

			File file = new File("D:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}*/
		
		// create bookstore, assigning book
		Bookstore bookstore = new Bookstore();
		bookstore.setName("Fraport Bookstore");
		bookstore.setLocation("Frankfurt Airport");
		ArrayList<Book> bookList = new ArrayList<Book>();

		// create books
		Book book1 = new Book();
		book1.setIsbn("978-0060554736");
		book1.setName("The Game");
		book1.setAuthor("Neil Strauss");
		book1.setPublisher("Harpercollins");
		bookList.add(book1);

		Book book2 = new Book();
		book2.setIsbn("978-3832180577");
		book2.setName("Feuchtgebiete");
		book2.setAuthor("Charlotte Roche");
		book2.setPublisher("Dumont Buchverlag");
		bookList.add(book2);

		bookstore.setBookList(bookList);

		// create JAXB context and instantiate marshaller
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Bookstore.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(bookstore, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	} // main() ends...

}

