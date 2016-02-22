/**
 * 
 */
package me.karthy.dircopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.activation.URLDataSource;

/**
 * @author karthy
 * 
 */
public class DirCopyTest {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//File sourceLocation = new File("libs");
		//File targetLocation = new File("lib");
		
		String sample = "me.karthy";
		
		String result = sample.replaceAll("\\.", "/");

		System.out.println(result);
		//copyDirectory(sourceLocation, targetLocation);

	}

	public static void copyDirectory(File sourceLocation, File targetLocation)
			throws IOException {

		if (sourceLocation.isDirectory()) {
			if (!targetLocation.exists()) {
				targetLocation.mkdir();
			}
			
			String[] children = sourceLocation.list();
			for (int i = 0; i < children.length; i++) {
				copyDirectory(new File(sourceLocation, children[i]), new File(
						targetLocation, children[i]));
			}
		} else {
			
			//URL uri = new URL("http://karthy.me/Slim.zip");
			//URLConnection urlConnection = uri.openConnection();

			//InputStream in = urlConnection.getInputStream();
			InputStream in = new FileInputStream(sourceLocation);
			OutputStream out = new FileOutputStream(targetLocation);

			// Copy the bits from instream to outstream
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		}
	}

}
