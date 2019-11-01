package com.wl.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HmacSHA256Util {
	
	public static final Logger logger = LoggerFactory.getLogger(HmacSHA256Util.class);

	public static String sign(String sid, String rid, String appKey, String rTime) {
		String result = "";
		try {
			Mac hmacSha256 = Mac.getInstance("HmacSHA256");
			byte[] keyBytes = appKey.getBytes("UTF-8");
			hmacSha256.init(new SecretKeySpec(keyBytes, 0, keyBytes.length,
					"HmacSHA256"));
			String inputString = sid + rid + rTime;
			System.out.println("INPUT: " + inputString);
			byte[] hmacSha256Bytes = hmacSha256.doFinal(inputString
					.getBytes("UTF-8"));
			result = new String(Base64.encodeBase64(hmacSha256Bytes), "UTF-8");
			System.out.println("OUTPUT: " + result);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
