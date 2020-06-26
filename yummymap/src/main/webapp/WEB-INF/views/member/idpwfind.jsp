<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>YummyMap</title>
    <link rel="stylesheet" href="/YummyMap/css/main/mainList.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link rel="stylesheet" href="/YummyMap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/YummyMap/css/member/pwchange.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="w3-col m9 w3-padding w3-center">
			<div class="w3-half">
				<input type="radio" id="mgen" name="gen" value="M">
				<label for="mgen">아이디</label>
			</div>
			<div class="w3-half">
				<input type="radio" id="wgen" name="gen" value="F">
				<label for="wgen">비밀번호</label>
			</div>		
		</div>
	</div>
</body>
</html>