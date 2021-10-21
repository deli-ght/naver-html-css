<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/main.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;300&family=Roboto:ital,wght@0,700;1,400&display=swap" rel="stylesheet">
        <title>TodoList</title>
    </head>
    <body>
        <div class="header">
            <div class="title">what i have to do</div>
			<div class="btns">
           	 	<button class="btn addTodoBtn" onclick = "location.href='./todoForm'"> 새로운 TODO 등록 </button>
				<button class="btn removeall" onclick="removeAll()">remove all</button>
			</div>
        </div>
        <section id="todoList">
        	<c:forEach var="type" items= "${todotype}">
        		<section class="todoContainer" id="${type}">
        			<div class = "todoTitle">${type}</div>
        			<c:forEach var="list" items="${todolist}">
        				<c:if test = "${list.type eq type}">
	        				<div class="todoBlock">
	        					<h1 class="todoContext">${list.title}</h1>
	        					<div class="todoDetails">
	        						<div class="todoDetail">
	        						등록날짜: ${list.regDate}, ${list.name}, 우선순위 : ${list.sequence}
	        						</div>
	        						<c:if test = "${list.type ne 'DONE' }">
	        							<button class= "moveState" onclick="changeButtonClick(${list.id},this)">→</button>
	        						</c:if>
	        					</div>
	        				</div>
        				</c:if>
        			</c:forEach>
        		</section>
        	</c:forEach>
        </section>

	<script src="./js/main.js" type="text/javascript"></script>

    </body>
    </html>