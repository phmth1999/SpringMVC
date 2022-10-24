package com.springmvc.Utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.apache.log4j.Logger;
public class VerSign {
	final static Logger logger = Logger.getLogger(VerSign.class);
	private static PublicKey readPublicKey(String key) throws Exception {
		PublicKey pubKey = null;
		try {
			byte[] b = Base64.getDecoder().decode(key);

			X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
			KeyFactory factory = KeyFactory.getInstance("RSA");
			pubKey = factory.generatePublic(spec);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return pubKey;
	}
	public static boolean VerSignByHash(String sign, String data, String PublicKey) throws Exception {
		boolean verfile = false;
		try {
			PublicKey pubKey = readPublicKey(PublicKey);

			byte[] signToVer = Base64.getDecoder().decode(sign);

			Signature rsa = Signature.getInstance("SHA256withRSA");
			rsa.initVerify(pubKey);

			byte[] input = data.getBytes();
				rsa.update(input);

			verfile = rsa.verify(signToVer);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return verfile;
	}
	public static boolean VerSignByFile(String sign, String data, String PublicKey) throws Exception {
		boolean verfile = false;
		try {
			PublicKey pubKey = readPublicKey(PublicKey);
			
			byte[] signToVer = Base64.getDecoder().decode(sign);
			
			Signature rsa = Signature.getInstance("SHA256withRSA");
			rsa.initVerify(pubKey);
			
			FileInputStream datafis = new FileInputStream(new File(data));
			BufferedInputStream bis = new BufferedInputStream(datafis);
			byte[] input = new byte[1024];
			int len;
			while ((len = bis.read(input)) != -1) {
				rsa.update(input, 0, len);
			};
			bis.close();
			
			verfile = rsa.verify(signToVer);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return verfile;
	}
}
