/* ----------------------------------------------------------------
 * Nombre de la Clase:  MoueClick.java
 * Version: 1.0
 * Fecha:Jan 21, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> MoueClick.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Jan 21, 2012
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class MoueClick {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Robot robot = new Robot();
			robot.mouseMove(40, 130);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}

}

