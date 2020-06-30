package com.lk.LKTotalSerch.common;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

	public static String sha256(String msg){
		try {
			MessageDigest md = MessageDigest.getInstance("sha-256");
			md.update(msg.getBytes());
			return byteToHexString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String byteToHexString(byte[] data) {
		StringBuilder sb = new StringBuilder();
		for(byte b : data) {
			sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));


		}
		return sb.toString();
		
	}
}
