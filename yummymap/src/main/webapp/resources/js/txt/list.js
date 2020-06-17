	
// txt list
$(document).ready(function() {
		let userid = '${sid}';
		if (!userid) {
			$('#login').show();
			$('#logout').hide();
			$('#mypage').attr('href', '/yummymap/join/join.mmy');
		} else {
			$('#login').hide();
			$('#logout').show();
			$('#mypage').attr('href', '/yummymap/member/member.mmy');
		}
		//마이리스트 이벤트 처리 입니다.
		$('#myListIcon').click(function(){
			if(!userid) {
				alert('로그인을 진행해주세요');
				return;
			}
			$(location).attr('href', '/yummymap/main/myList.mmy');
		});

		$('#write').click(function() {
			$(location).attr('href', '/yummymap/txt/write.mmy');
		});

		$('.pbtn').click(function() {
			// 할일
			// 1. 어떤 버튼이 클릭이 됐는지 알아낸다.
			var str = $(this).text();
			$('#nowPage').val(str);
			$('#frm').attr('action', '/yummymap/txt/list.mmy');
			$('#frm').submit();
		});

		$('.page-link').click(function() {
			var str = $(this).html();
			if (str == '&laquo;') {
				$('#nowPage').val('${PAGE.startPage-1}');
			} else if (str == '&raquo;') {
				$('#nowPage').val('${PAGE.endPage+1}');
			} else {
				return;
			}
			$('#frm').attr('action', '/yummymap/txt/list.mmy');
			$('#frm').submit();
		});

		// 게시글 상세보기 이벤트 처리
		$('.txt-body').click(function() {
			// 할일
			// 글 번호 알아낸다.
			var sno = $(this).attr('id');
			$('#txtno').val(sno);
			$('#nowPage').val('${PAGE.nowPage}');
			$('#frm').attr('action', '/yummymap/txt/detail.mmy');
			$('#frm').submit();
		});

	});

