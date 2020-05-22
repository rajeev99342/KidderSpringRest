package com.kidder.Common;

import java.io.File;
import java.io.FileInputStream;

import org.apache.tomcat.util.codec.binary.Base64;

public class GetBase64ImageFromFile {
	 public static String encodeFileToBase64Binary(File file) throws Exception{
		//encode image to Base64 String
//			File f = new File("H:/encode/sourceImage.png");		//change path of image according to you
			FileInputStream fis = new FileInputStream(file);
			byte byteArray[] = new byte[(int)file.length()];
			fis.read(byteArray);
			String imageString = "data:image/png;base64,"+ Base64.encodeBase64String(byteArray);
			System.out.println(imageString);
			return imageString;
    }
	 
}
