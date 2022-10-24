package com.springmvc.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

import org.apache.log4j.Logger;
public class MD5 {
	final static Logger logger = Logger.getLogger(MD5.class);
	public static String getMD5File(File file) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			FileInputStream fis = new FileInputStream(file);
			byte[] dataBytes = new byte[1024];
			int nread = 0;
			while ((nread = fis.read(dataBytes)) != -1) {
				md.update(dataBytes, 0, nread);
			}
			byte[] byteData = md.digest();
			fis.close();
			return convertByteToHex(byteData);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new RuntimeException(e);
		}
	}
	public static String convertByteToHex(byte[] data)  throws Exception{
		StringBuffer sb = new StringBuffer();
		try {
			for (int i = 0; i < data.length; i++) {
				sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return sb.toString();
	}
}
