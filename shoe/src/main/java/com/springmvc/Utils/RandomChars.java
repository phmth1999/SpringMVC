package com.springmvc.Utils;

import java.util.Random;

import org.apache.log4j.Logger;
public class RandomChars {
	final static Logger logger = Logger.getLogger(RandomChars.class);
	public static String generateRandomChars() {
		String srcChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234556789";
		int length = 5;
		StringBuilder sb = new StringBuilder();
		try {
			Random random = new Random();
			for (int i = 0; i < length; i++) {
				sb.append(srcChars.charAt(random.nextInt(srcChars.length())));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return sb.toString();
	}
}
