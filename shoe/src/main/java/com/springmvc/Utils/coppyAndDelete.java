package com.springmvc.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;
public class coppyAndDelete {
	final static Logger logger = Logger.getLogger(coppyAndDelete.class);
	public static void coppyAndDeleteFile(String from, String to) throws Exception{
		InputStream inStream = null;
		OutputStream outStream = null;

		try {

			File afile = new File(from);
			File bfile = new File(to);

			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {

				outStream.write(buffer, 0, length);

			}
			inStream.close();
			outStream.close();

			// delete the original file
			afile.delete();


		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
}
