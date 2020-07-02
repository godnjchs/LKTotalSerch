package com.lk.LKTotalSerch.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.lk.LKTotalSerch.action.NaverLoginAction;
import com.lk.LKTotalSerch.common.Common;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request,response);
	}


	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		String path  = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
		if(path.equals("login")) {
			NaverLoginAction nl = new NaverLoginAction();
			response.setCharacterEncoding("urf-8");
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().write(nl.action(request, response).toString());
		}
		else if(path.equals("loginKakao")) {
			String apiURL = "https://127.0.0.1:8080/LKTotalSerch/SignUp/signUp.jsp";
			URL url = new URL(apiURL);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			BufferedReader br;
			
			StringBuffer sb = new StringBuffer();
			
			int ele = 0;
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			System.out.println("성공");
			while((ele=br.read())!=-1){
				sb.append((char)ele);
			}
			System.out.println(sb);
		}
		
		
		
	}

}
