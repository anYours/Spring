package com.wl.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class SymmetricEncoder {

	
	/**
	 * ����
	 * @param encodeRules
	 * @param content
	 * @return
	 */
	public static String AESEncode(String encodeRules, String content){
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("AES");
			SecureRandom serRandom = SecureRandom.getInstance("SHA1PRNG");
			serRandom.setSeed(encodeRules.getBytes());
			keyGen.init(128, serRandom);
			SecretKey original_key = keyGen.generateKey();
			byte[] raw = original_key.getEncoded();
			SecretKey key = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] byte_encode = content.getBytes();
			byte[] byte_AES = cipher.doFinal(byte_encode);
			new Base64();
			String AES_encode = new String(Base64.encodeBase64String(byte_AES));
			return AES_encode;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch(NoSuchPaddingException e){
			e.printStackTrace();
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}catch(IllegalBlockSizeException e){
			e.printStackTrace();
		}catch(BadPaddingException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * ����
	 * @param encodeRules	appKey
	 * @param content	����
	 * @return
	 */
	public static String AESDecode(String encodeRules, String content){
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("AES");
			SecureRandom serRandom = SecureRandom.getInstance("SHA1PRNG");
			serRandom.setSeed(encodeRules.getBytes());
			keyGen.init(128, serRandom);
			SecretKey original_key = keyGen.generateKey();
			byte[] raw = original_key.getEncoded();
			SecretKey key = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] byte_content = Base64.decodeBase64(content);
			byte[] byte_decode = cipher.doFinal(byte_content);
			String AES_decode = new String(byte_decode, "UTF-8");
			return AES_decode;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch(NoSuchPaddingException e){
			e.printStackTrace();
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}catch(IllegalBlockSizeException e){
			e.printStackTrace();
		}catch(BadPaddingException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return null;
	}
}
