<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.11.0/jquery-ui.js" integrity="sha256-z8sq+fwXy6xX1HLBJZ5doyrWmFBhQ9lG3p/AKoipKKs=" crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        *{
            margin: 0;
            padding: 0;
           
        }
        a{
            text-decoration: none;
            color: white;
        }
        .disabled{
            width: 0;
            overflow: none;
            height: 0;
        }
        a:hover{
            color: wheat;
        }
        .wallpaper{
            position: absolute;
            
            top: 0;
            background-image: url("./Image/mainWallpaper.jpg");
            z-index: 5;
            }
        
        body,html,.wallpaper,.main,.mainContainer{
            width: 100%;
            height: 100%;
               
        }
        .mainContainer{
            position: relative;
           z-index: 10; 
        }
        .main{
            display: table;
        }
        .main > .input{
            display:table-cell;
            vertical-align: middle;
        }
        .input > form{
            width: 30%;
            margin: 0 auto;
        }
        .input h1{

            text-align: center;
            margin: 0 auto;
            color: beige;
            font-size: 50px;
            margin-bottom: 100px;
        }
        .input input{
            
            
            display: block;
            margin : 0 auto;
            height: 50px;
            width: 100%;
            border-radius: 10px;
            padding: 3px;
        }
        aside{
            position: absolute;
            right: 0;
            top: 0;
            
            width: 10%;
            height: 100%;
        }
        aside > div{
            height: 100%;
        }
        aside ul{
            height: 100%;
            overflow: hidden;
        }
        aside li{
            display: block;
            height: 15%;
            color: white;
            text-align: center;
            padding: 30px;    
        }
        .openContainer{
            float:right;

        }
        .open >  img{
            width: 20px;
            height: 20px;
        }
        .openContainer{
            background-color: #191c20;
        }
        
        

      
            
            

    </style>
</head>
<body>
    <div class="mainContainer">
        <div class="main">
            <div class="input">
                <form action="" class="serchSummoner">
                    <h1>LKTotalSerch</h1>
                    <input type="text" placeholder="Surmmoner Serch...">
                </form>
            </div>

        </div>
        
        <aside>
            
                <button class="open"><img src="./Image/menu_icon.png" alt="menu icon"></button>
            
            <div class="openContainer">
                
                <ul>
                <li><a href="#">Exem1</a></li>
                <li><a href="#">Exem2</a></li>
                <li><a href="#">Exem3</a></li>
                <li><a href="#">Exem4</a></li>
                <li><a href="#">Exem5</a></li>
                </ul>
             </div>
        </aside>
    </div>
    <div class="wallpaper">
            

    </div>
       
    
</body>
<script>
$(function(){
    $('.open').click(function(){
        $('.openContainer').toggle(500);
    });
    

})


</script>
</html>

</body>
</html>