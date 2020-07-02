package com.lk.LKTotalSerch.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

import java.net.URL;
import java.security.SecureRandom;

import org.json.JSONObject;






public class Common {
	
	public String generatestate() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130,random).toString(32);
	}

	public JSONObject makeJson(String state, String code) throws IOException {
		URL url = new URL("https://nid.naver.com/oauth2.0/token?client_id=otOLtR2LBUbv_AWne1Sz&client_secret=LQo8WlAAIN&grant_type=authorization_code&state="+state+"&code="+code);
		InputStream is = url.openStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		int s = 0;
		StringBuilder sb = new StringBuilder();
		while((s=br.read()) != -1) {
			
			sb.append((char)s);
		}
		JSONObject jsonObject = new JSONObject(sb.toString());
		return jsonObject;
		
		
		
	}
	
	
}
