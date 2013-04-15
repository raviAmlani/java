/* ----------------------------------------------------------------
 * Nombre de la Clase:  AffineTransformTest.java
 * Version: 1.0
 * Fecha:Dec 14, 2011
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> AffineTransformTest.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Dec 14, 2011
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class AffineTransformTest {
	public static void main(String[] args) {
	    JFrame jf = new JFrame("Demo");
	    Container cp = jf.getContentPane();
	    MyCanvas tl = new MyCanvas();
	    cp.add(tl);
	    jf.setSize(300, 200);
	    jf.setVisible(true);
	  }
	}

	class MyCanvas extends JComponent {

	  public void paint(Graphics g) {
	    Shape shape = new Rectangle2D.Float(60, 100, 100, 20);
	    
	    Graphics2D g2 = (Graphics2D) g;


	    AffineTransform at = AffineTransform.getRotateInstance(Math.PI/2,100,100);    
	   
	    g2.setTransform(at);
	    g2.draw(shape);
	    
	  }
}

