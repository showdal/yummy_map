<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>YUMMY MAP COUMMUNITY</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link rel="stylesheet" href="/yummymap/css/txt/write.css">
<link rel="stylesheet" href="/yummymap/css/nav.css">
<script type="text/javascript" src="/yummymap/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/yummymap/js/txt/write.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript"></script>
<style>
</style>
</head>
<body>

	<!-- nav 영역입니다.-->
	<div class="bg-white border-bottom fixed-top nav-body">
		<div class=" mt-2 nav-btn">
			<div class="member_nav text-right mt-3">
				<div class="ctQZg">
					<div class="_47KiJ">
						<div class="XrOey">
							<a class="_0ZPOP kIKUG _4700r" id="myListIcon" href="#"><svg
									aria-label="활동 피드" class="_8-yf5 " fill="#262626" height="24"
									viewBox="0 0 48 48" width="24">
                              <path
										d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z">
                              </path>
                          </svg></a>
							<div class="_0Sl_t">
								<div class="poA5q" style="margin-left: -423px;"></div>
							</div>
						</div>
						<div class="XrOey">
							<a href="#" id="mypage"><svg aria-label="프로필" class="_8-yf5 "
									fill="#262626" height="24" viewBox="0 0 48 48" width="24">
                              <path
										d="M24 26.7c7.4 0 13.4-6 13.4-13.4S31.4 0 24 0 10.6 6 10.6 13.4s6 13.3 13.4 13.3zM24 3c5.7 0 10.4 4.6 10.4 10.4S29.7 23.7 24 23.7s-10.4-4.6-10.4-10.4S18.3 3 24 3zm9.1 27.1H14.9c-7.4 0-13.4 6-13.4 13.4v3c0 .8.7 1.5 1.5 1.5s1.5-.7 1.5-1.5v-3c0-5.7 4.6-10.4 10.4-10.4h18.3c5.7 0 10.4 4.6 10.4 10.4v3c0 .8.7 1.5 1.5 1.5s1.5-.7 1.5-1.5v-3c-.1-7.4-6.1-13.4-13.5-13.4z">
                              </path>
                          </svg></a>
						</div>
					</div>
					<!-- <a href="#" class="badge badge-light nav-item" id="join">Join</a>-->
					<a href="http://localhost/YummyMap/join/login.mmy"
						class="badge badge-light nav-item" id="login">LOGIN</a> <a
						href="#" class="badge badge-light nav-item" id="logout">LOGOUT</a>
				</div>
			</div>
		</div>
		<a class="navbar-brand tcolor logo" href="/YummyMap/main.mmy" id=""> YUMMY MAP </a>
		<div class="b-subtitle text-left">
			<p class="pt-3">커뮤니티</p>
		</div>
       <div class=" nav-item-1 d-flex justify-content-end">
            <a class="navbar-brand nav-item-size" href="/YummyMap/game/game.mmy" >
                <i class="fas fa-gamepad" id="game"></i>
            </a>
            <a class="navbar-brand nav-item-size" href="/yummymap/txt/list.mmy"">
                <i class="far fa-clipboard"></i>
            </a>
        </div>
	</div>
	<!-- nav 마지막 입니다-->

	<!-- body 시작 입니다-->
	
	<%-- <form method="post" action="/YummyMap/board/boardEditProc.mmy" id="frm">
		 <input
			type="hidden" name="title" id="title" value="${bVO.title}"> <input
			type="hidden" name="mtxt" id="mtxt" value="${bVO.mtxt}"> <input
			type="hidden" name="nowPage" id="nowPage" value="${nowPage}">
	</form> --%>
	<div class="main-body">
		<div class="txt-line mb-4">
			<form action="/yummymap/txt/editProc.mmy" method="POST" id="frm">
		<input type="hidden" name="txtno" id="txtno" value="${DATA.txtno}">
		<input type="hidden" id="mid" name="mid" value="show">
				<div class="form-group d-flex">
				
					<select name="catno" id="catno" value="${DATA.catno}">
						<option value="" selected=selected>카테고리</option>
						<option value="1" id="w3-button cat-item" name="cat">한식</option>
						<option value="2" id="w3-button cat-item" name="cat">중식</option>
						<option value="3" id="w3-button cat-item" name="cat">일식</option>
						<option value="4" id="w3-button cat-item" name="cat">경양식</option>
						<option value="5" id="w3-button cat-item" name="cat">분식</option>
						<option value="6" id="w3-button cat-item" name="cat">태국요리</option>
						<option value="7" id="w3-button cat-item" name="cat">베트남요리</option>
						<option value="8" id="w3-button cat-item" name="cat">인도요리</option>
						<option value="9" id="w3-button cat-item" name="cat">야식</option>
					</select><input type="text" class="form-control ml-1"  id="title" name="title"
						 placeholder="제목" value="${DATA.title}">
				</div>
				<div class="form-group mt-2">
					<textarea class="form-control" rows="15" id="mtxt" name="mtxt"
						style="resize: none;">${DATA.mtxt} </textarea>
				</div>
				<button type="button" class="btn btn-primary btn-sm" id="submitBtn">완료</button>
				<button type="button" class="btn btn-secondary btn-sm" id="exitBtn">취소</button>
			</form>
		</div>
	</div>
	<!-- body 마지막 입니다-->
</body>
<!-- <script type="text/javascript">
// 	$(document).ready(function() {
// 		$("select[value=cat]").val();
// 		alert(cat-item);
// 	}); 
</script>-->
</html>