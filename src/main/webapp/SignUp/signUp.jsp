<%@page import="com.lk.LKTotalSerch.common.Common"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  trimDirectiveWhitespaces="true"%>
<%
	Common common = new Common();
	String state = common.generatestate();
	session.setAttribute("state",state);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type = "text/javascript" src = "../resource/kakao.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        html,body,.mainContainer{
            width: 100%;
            height: 100%;
        }
        body{
            background: url("../main/Image/mainWallpaper.jpg");
            
        }
        .mainContainer{
            
        }
        .loginCard{
            padding: 7% 3%;
        
            margin: 100px auto;
            width: 30%;

            background-color: white;
            border-radius: 23px;
        }
        form > h1{
            font-size: 45px;
            font-weight: bolder;
            text-align: center;
            margin-bottom: 10px;
        }
        .loginCard{
            padding: 10%;
        }
        .loginInfo > input{
            display: block;
            margin: 15px 0;
            border : none;
            border-bottom: 1px solid black;
            width: 100%;
            height: 40px;
            
        }

    </style>
</head>
<body>
    <div class="mainContainer">
        <div class="loginCard">
            <form action="" method="post">
                <h1>LKTotalSerch</h1>
                <div class="loginInfo">
                    <label for="id">아이디</label>
                    
                      
                    <input type="text" placeholder="아이디" name="userId">
                    <label for="userId">비밀번호</label>
                    <input type="password" placeholder="비밀번호" name = "password">
                    <label for="name">별명</label>
                    <input type="text" name="name" placeholder="별명"/>
                    
                    
                    <a id="kakao-login-btn"></a>
                    <a id="create-kakao-login-btn" href="https://nid.naver.com/oauth2.0/authorize?client_id=otOLtR2LBUbv_AWne1Sz&response_type=code&redirect_uri=http://127.0.0.1:8080/LKTotalSerch/login.lk&state=<%=state%>"
                    >네이버로그인</a>
                    
                </div>
            </form>
            <form action="" id="kakaoHidden">
            	
            </form>
        </div>
    </div>
    
</body>
<script>

	//카카오톡 sdk 초기화
	

	// SDK 초기화 여부를 판단합니다.
    
   
    // input your appkey
    Kakao.init('dda3510bf1a0b55b04b66df8ca8e8273')
    console.log(Kakao.isInitialized());
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function(res) {
        	 alert('성공1');
        	 
        	 $.ajax({
        		 url:'http://127.0.0.1:8080/LKTotalSerch/loginKakao.lk',
        		 data:encodeURI(JSON.stringify(res)),
        		 dataType:"json",
        		 type:'GET',
        		 contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        		 success:function(){
        			 alert("성공");
        		 }
        	 })
        	
          },
          fail: function(error) {
            alert(
              'login success, but failed to request user information: ' +
                JSON.stringify(error)
            )
          },
        })
      },
      fail: function(err) {
        alert('failed to login: ' + JSON.stringify(err))
      },
    })
    


</script>
</html>