package com.gejianwei_1510121154.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class UserUtil{
	
	public static String md5(String message){
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(message.getBytes("utf-8"));
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
}
