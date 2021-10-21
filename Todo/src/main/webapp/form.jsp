<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/form.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;300&family=Roboto:ital,wght@0,700;1,400&display=swap" rel="stylesheet">
</head>
<body>
	<section id="formContainer">
        <h2>할 일 등록</h2>
        <form action="todoAdd" method="get">
            <div id="what">
                <label class="whatLabel">어떤 일 인가요?</label>
                <input id='title' class= "inputList" name="title" placeholder="swift 공부하기 (24자까지)" type="text">
            </div>
            <div id="who">
                <label class="whatLabel">누가 할 일인가요?</label>
                <input class= "inputList" name="name" placeholder="홍길동" type="text">
            </div>
            <div id="priority">
                <label class="whatLabel">우선 순위를 선택하세요</label>
                <label class="plabel"><input class= "inputBtn" type="radio" name="sequence" value=1 checked>1순위</label>
                <label class="plabel"><input class= "inputBtn" type="radio" name="sequence" value=2 >2순위</label>
                <label class="plabel"><input class= "inputBtn" type="radio" name="sequence" value=3 >3순위</label>
            </div>
            <div class="btnContainer">
                <button id="previous" type="button" onclick= "location.href='./MainServlet'"> < 이전 </button>
                <div class="blueBtns">
                    <input type="submit" id = "submit" value="제출" class="blueBtn">
                    <input type="reset" id="clear" value = "내용 지우기" class="blueBtn">
                 </div>
            </div>
            
        </form>
    </section>

</body>
</html>