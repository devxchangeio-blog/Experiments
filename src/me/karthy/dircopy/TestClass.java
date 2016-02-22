/**
 * 
 */
package me.karthy.dircopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.MalformedInputException;

public class TestClass {
	public static void main(String[] args) {
		URL url = null;
		URLConnection con = null;
		int i;
		try {
			url = new URL("https://localhost:8080/AppName/FileName.txt");
			con = url.openConnection();
			File file = new File("C:\\Foldername\\Address.txt");
			BufferedInputStream bis = new BufferedInputStream(
					con.getInputStream());
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(file.getName()));
			while ((i = bis.read()) != -1) {
				bos.write(i);
			}
			bos.flush();
			bis.close();
		} catch (MalformedInputException malformedInputException) {
			malformedInputException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}
