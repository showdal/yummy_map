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
<link rel="stylesheet" href="/yummymap/css/txt/detail.css">
<link rel="stylesheet" href="/yummymap/css/nav.css">
<script type="text/javascript" src="/yummymap/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/yummymap/js/txt/detail.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">

/* function rList(){
	$.ajax({
		url: "/yummymap/txt/rList.mmy?txtno=${LIST.txtno}",
		type: 'get',
		dataType: 'json',
		data: {
			'txtno' : txtno
		},
			success: function(result){
				console.log(result);
				var output = "<table>";
				for(var i in result);
				output += "<tr>";
				output += "<td>"+result[i].mid;
				output += "<br>"+result[i].sdate+"<br>";
				output += result[i].mtxt+"</td>";
				output += "</tr>";
			};
			output += "</table>" ;
			$("#listReply").html(result);
			}
	});'
} */

</script>
</head>
<body>
		<!-- nav 영역입니다-->
	<div class="bg-white border-bottom fixed-top nav-body">
		<div class=" mt-2 nav-btn">
			<div class="member_nav text-right mt-3">
				<div class="ctQZg">
					<div class="_47KiJ">
						<div class="XrOey">
							<a class="_0ZPOP kIKUG _4700r " id="myListIcon" href="#"><svg
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
					<a href="/YummyMap/join/login.mmy"
						class="badge badge-light nav-item" id="login">LOGIN</a> <a
						href="/YummyMap/join/logoutProc.mmy"
						class="badge badge-light nav-item" id="logout">LOGOUT</a>
				</div>
			</div>
		</div>
		<a class="navbar-brand tcolor logo" href="/YummyMap/main.mmy" id="">
			YUMMY MAP </a>
		<div class="b-subtitle text-left">
			<p class="pt-3">커뮤니티</p>
		</div>
		<div class=" nav-item-1 d-flex justify-content-end">
			<a class="navbar-brand nav-item-size" href="/YummyMap/game/game.mmy"
				id="game"> <i class="fas fa-gamepad"></i>
			</a> <a class="navbar-brand nav-item-size"
				href="/yummymap/txt/list.mmy"> <i
				class="far fa-clipboard"></i>
			</a>
		</div>
	</div>
	<!-- nav 마지막 입니다-->

	<!-- body 시작 입니다-->
	<form class="d-none" method="post" action="" id="frm">
		<input type="hidden" name="txtno" id="txtno" value="${DATA.txtno}"> 
		<%-- <input type="hidden" name="reno" id="reno" value="${DATA.reno}">  --%>
		<%-- <input type="hidden" name="upno" id="upno" value="${DATA.upno}"> --%> 
		<input type="hidden" name="title" id="title" value="${DATA.title}"> 
		<input type="hidden" name="mtxt" id="mtxt" value="${DATA.mtxt}">
		<input type="hidden" id="mid" name="mid" value="${DATA.mid}">
		<input type="hidden" id="catno" name="catno" value="${DATA.catno}">
		<input	type="hidden" name="nowPage" id="nowPage" value="${nowPage}">
	</form>
	<form class="rec" method="post" action="" id="frm2">
		<input type="hidden" name="isrec" id="isrec">
		<input type="hidden" name="mid" id="mid">
		<input type="hidden" name="txtno" id="txtno">
	</form>
	<div class="main-body">
		<!--게시글 영역 입니다-->
		<div class="txt-line shadow-sm border mb-4">
			<div class="btns d-flex justify-content-end pr-4 mt-2">
			<%-- <c:if test="${sid == DATA.mid}"> --%>
				<a class="btn btn-sm btn-outline-light mr-1 text-grey" id="update">수정</a> 
				<a class="btn btn-sm btn-outline-light text-grey" id="delete">삭제</a>
			<%-- </c:if> --%>
			</div>
			<div class="b-w border-bottom ml-5 mt-4"></div>
			<div class="d-flex title">
				<div class="txt-title pt-4" id="title">${DATA.title}</div>
				<div class="pt-4 d-flex">
					<form id="like" method="post" action="">
						<div class="list-item-like">
							<span class="heart"><i  class="far fa-heart like-size mt-1" aria-hidden="true" onclick="return like()"></i></span>
							<span class="pl-3 pt-1 like-rnum" id="rnum">${DATA.rnum}</span>
						</div>
							<input type="hidden" id="txtno" name="txtno" value="${DATA.txtno}">	
							<input type="hidden" id="mid" name="mid" value="${DATA.mid}">	
					</form>
				</div>
				
				
				
				    <%-- <c:if test="${sid == null}">
					<div class="list-item-like like-size">
						<span class="heart"><i  class="far fa-heart " aria-hidden="true"></i> </span>
					</div>
	                </c:if> 
	                <<c:if test="${sid != null && DATA.isrec == 'N'}">
	                <<c:if test="${DATA.isrec == 'N'}">
					<div class="list-item-like like-size">
						<span class="heart"><i id="dislike" class="far fa-heart " aria-hidden="true"></i> </span>
					</div>
	               </c:if>
	               <c:if test="${DATA.isrec == 'Y'}">
	                <c:if test="${sid != null && DATA.isrec == 'Y'}">
					<div class="list-item-like like-size">
						<span class="heart"><i id="like" class="fas fa-heart " aria-hidden="true"></i> </span>
					</div>
	                </c:if>
					<div class="pl-3 pt-1" id="rnum">${DATA.rnum}</div> --%>
					
					
			</div>
			<div class="b-w border-bottom ml-5 mt-4"></div>
			<div class="txt-body pt-4" id="mtxt" >${DATA.mtxt}</div>
		</div>

		<!--게시글 영역 마지막 입니다-->
		<!--댓글 영역 시작 입니다-->
		<div class="reply-line shadow-sm border mb-4">
			<div class="d-flex re-title border pt-2">
				<p class="re-title-1 pl-4 pr-3 pt-1">댓글</p>
				<div class="pt-1 d-flex reply-info">
					<p class="pr-1">총</p>
					<p class="tcolor pl-1" id="re-count"></p>
					<p>개</p>
				</div>
				
				<div class="d-flex justify-content-end reply-btn mt-1">
				<c:if test="${empty sid}">
				<%-- <c:if test="${not empty sid}"> --%>
					<button type="button" class="btn btn-sm btn-outline-dark myd-none" id="reply-btn">작성</button>
				</c:if>
				</div>
			</div>
			<!--댓글 input태그 시작 영역 입니다-->
			<div class="re-input d-flex">
				<p class="pt-3 pl-4" id="rid" value="show">sshow</p>
				<form action="" method="POST" id="re-frm">
					<!-- <input type="hidden" name="rno" > -->
					<input type="hidden" name="reno" id=reno value="${DATA.upno}">
					<input type="hidden" name="txtno" id=upno value="${DATA.txtno}">
					<input type="hidden" name="mid" id=mid value="${data.mid}">
					<textarea class="form-control re-text-area ml-4" rows="2" name="reply" id="rtxt" placeholder="댓글을 입력하세요.">${data.mtxt}</textarea>
				</form>
			</div>
			<div class="reply-body mt-4 rply-box" id="rList"></div>
			<%-- <!--댓글 input태그 마지막 영역 입니다-->
			<!--댓글 내용 시작 영역 입니다-->
			<c:forEach var="data" items="${LIST}">
			<div class="reply-body mt-4 rply-box">
				<div class="d-flex reply-txt-1 mt-3">s
					<p id="">${data.mid}</p>
					<p id="" class="pl-2">${data.cdate}</p>
				</div>
				<div class="reply-txt-2 ">
					<p id="listReply" style="display:inline-block; width: 680px;">${data.mtxt}</p>
				<c:if test="${data.mid eq sid}">
					<a href="/yummymap/txt/replyRemveProc.mmy?tno=${data.upno}&rno=${data.rno}" class="badge badge-danger">댓글삭제</a>
				</c:if>
				</div>
				<div class="b-w border-bottom ml-5 mt-4" style="height: 0px;"></div>
			</div>
			</c:forEach>
			<!--댓글 내용 마지막 영역 입니다--> --%>
		</div>
	</div>
		<!-- body 마지막 입니다-->
</body>
<script type="text/javascript">
</script>
</html>