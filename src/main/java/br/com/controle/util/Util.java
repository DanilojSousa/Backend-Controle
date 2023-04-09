package br.com.controle.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Util {
	
	   private static final String SECRET_KEY = "BR_COM_CONTROLES"; 
	
	//encriptar
	   public static String encrypt(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-512");
	            byte[] hash = md.digest(password.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (byte b : hash) {
	                sb.append(String.format("%02x", b));
	            }
	            return sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException("Erro ao criptografar senha", e);
	        }
	    }
	    
	    public static String encode(String text) throws Exception {
	    	SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");
	    	Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	    	cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
	    	byte[] encryptedBytes = cipher.doFinal(text.getBytes("UTF-8"));
	    	String base64 = Base64.getEncoder().encodeToString(encryptedBytes);
	    	return base64;
	    }

	    public static String decode(String encodedText) throws Exception {
	        byte[] decodedBytes = Base64.getDecoder().decode(encodedText);
	        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
	        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
	        return new String(decryptedBytes);
	    }
	    
	        
}
