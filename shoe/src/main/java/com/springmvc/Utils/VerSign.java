package com.springmvc.Utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class VerSign {
	private static PublicKey readPublicKey(String key) throws Exception {
		byte[] b = Base64.getDecoder().decode(key);

		X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PublicKey pubKey = factory.generatePublic(spec);
		return pubKey;
	}

	public static boolean VerSignByHash(String sign, String data, String PublicKey) throws Exception {
		PublicKey pubKey = readPublicKey(PublicKey);

		byte[] signToVer = Base64.getDecoder().decode(sign);

		Signature rsa = Signature.getInstance("SHA256withRSA");
		rsa.initVerify(pubKey);

		byte[] input = data.getBytes();
			rsa.update(input);

		boolean verfile = rsa.verify(signToVer);
		return verfile;
	}
	public static boolean VerSignByFile(String sign, String data, String PublicKey) throws Exception {
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
		
		boolean verfile = rsa.verify(signToVer);
		return verfile;
	}
}
