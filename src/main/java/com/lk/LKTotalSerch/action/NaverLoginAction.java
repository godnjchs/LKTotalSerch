package com.lk.LKTotalSerch.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.lk.LKTotalSerch.common.Common;

public class NaverLoginAction {
	
	
	public JSONObject action(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Common common = new Common();
		String state = request.getParameter("state");
		String code = request.getParameter("code");
		String storedState = (String) request.getSession().getAttribute("state");
		JSONObject jsonObject;
		Gson gson = new Gson();
		BufferedReader br;
		JSONObject result = null;
		
		
		if(state.equals(storedState)) {
			jsonObject = common.makeJson(state,code);
			
			String token = (String) jsonObject.get("access_token");
			
			String header = "Bearer  " + token;
			String apiURL = "https://openapi.naver.com/v1/nid/me";
			URL url = new URL(apiURL);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int ele = 0;
			int responseCode = con.getResponseCode();
			StringBuffer sb = new StringBuffer();
			if(responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				System.out.println("성공");
			}
			else {
				System.out.println("실패");
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			while((ele=br.read()) != -1) {
				sb.append((char)ele);
			}
			result = new JSONObject(sb.toString());
			
		}
		return result;
		
			
				
				
			
			
	}
}
