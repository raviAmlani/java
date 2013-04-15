/* ----------------------------------------------------------------
 * Nombre de la Clase:  SecurityCerts.java
 * Version: 1.0
 * Fecha:May 29, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.Security;
import java.text.SimpleDateFormat;

import iaik.pkcs.PKCSException;
import iaik.pkcs.PKCSParsingException;
import iaik.pkcs.pkcs12.CertificateBag;
import iaik.pkcs.pkcs12.PKCS12;
import iaik.security.provider.IAIK;
import iaik.x509.X509Certificate;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> SecurityCerts.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>May 29, 2012
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class SecurityCerts {

	
	public static void main(String []args){
		
		PKCS12 pkcs12 = null;
		String keystore = "D:\\redabogacia.pfx";
//		"Sello3.p12";
//		"Copia de pruebas_catastro.pfx";
//		redabogacia.pfx
		try {
			IAIK iaik = new IAIK();
			Security.addProvider(iaik);
			pkcs12 = new PKCS12 (new FileInputStream(keystore));
			System.out.println("File avail? : "+new File(keystore).isFile());
//			System.out.println("pass valid ? - "+pkcs12.verify(this.getPwdPFX().toCharArray()));
//			pkcs12.decrypt("Teto2010".toCharArray());
			pkcs12.decrypt("2222".toCharArray());
			
			PrivateKey privateKey = pkcs12.getKeyBag().getPrivateKey();
			String priKeyAlgo = privateKey.getAlgorithm();

			CertificateBag []certificateBags = pkcs12.getCertificateBags();
			
			X509Certificate []certificates = CertificateBag.getCertificates(certificateBags);
			
			X509Certificate cert = certificates[0];
			/*String fechaDesde = utilidades.dateToString("dd/MM/yyyy HH:mm:ss",cert.getNotBefore());
			System.out.println("fechaDesde : "+fechaDesde);
            String fechaHasta = utilidades.dateToString("dd/MM/yyyy HH:mm:ss",cert.getNotAfter());
            System.out.println("fechaHasta : "+fechaHasta);*/
            
            String subject = cert.getSubjectDN().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            System.out.println("cert.getNotBefore() "+sdf.format(cert.getNotBefore()));
            System.out.println("Subject : "+subject);
            
		} catch (PKCSParsingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PKCSException e) {
			e.printStackTrace();
		}
	}
}

