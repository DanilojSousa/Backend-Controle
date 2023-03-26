package br.com.controle.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
		
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

	        
}
