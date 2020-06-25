	
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
			let mid = $('#mid').val();
//			alert(mid);
			$('#nowPage').val('${PAGE.nowPage}');
			$('#frm').attr('action', '/yummymap/txt/detail.mmy');
			/*$('#frm').attr('action', '/yummymap/txt/rList.mmy');*/
			$('#frm').submit();
		});	
});
		/*	var txtno = $(this).attr('id');
			$.ajax({ 
				url: "/yummymap/txt/rList.mmy",
				type: 'post',
				dataType: 'json',
				data: {
					'txtno' : txtno
				},
					success: function(result){
						alert("통신성공 얄루");
						var len = result.length;
//						console.log(result);
//						var output = "<table>";
						
						for(var i=0; i<len; i++){
//							let upno = $('#upno').val();
//							alert(upno);
							let mid = $('#mid').val();
							alert(mid);
							let txtno = $('#txtno').val();
							alert(txtno);
							alert($('.wow').attr('class'));
							$('#rlist').append(
									"123"
//									'<div class="reply-body mt-4 rply-box">'+
//									'<div class="d-flex reply-txt-1 mt-3">'+
//									'<p id="">'+result[i].mid+'</p>' +
//									'<p id="" class="pl-2">'+ result[i].cdate +'</p>'+
//								'</div>'+
//								'<div class="reply-txt-2 ">'+
//									'<p id="listReply" style="display:inline-block; width: 680px;">'+result[i].mtxt+'</p>'+
//								'</div>'+
//								'<div class="b-w border-bottom ml-5 mt-4" style="height: 0px;">'+'</div>'+
//							'</div>'
								
							)
						}
					},
					error: function(){
							alert("통신에러 ㅜㅡㅜ");
					}
			});
		});*/
//	});
/*
$(function rList() {
	
	$('.txt-body').click(function(){
		

	
});
});

					
		*/			
					
//				output += "<tr>";
//				output += "<td>"+result[i].mid;
//				output += "<br>"+result[i].sdate+"<br>";
//				output += result[i].mtxt+"</td>";
//				output += "</tr>";
//			}
//			output += "</table>" ;
//			$("#rList").html(result);
//