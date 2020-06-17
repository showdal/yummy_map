	$(document).ready(function() {
			let userid = 'show';
			if (!userid) {
				$('#login').show();
				$('#logout').hide();
				$('#mypage').attr('href', '/yummymap/join/join.mmy');
			} else {
				$('#login').hide();
				$('#logout').show();
				$('#mypage').attr('href', '/yummymap/member/mypage.mmy');
			}
		$('#update').click(function() {
			// 데이터 유효성 체크
			$('#frm').attr('action', '/yummymap/txt/edit.mmy');
			$('#frm').submit();
		});
		$('#delete').click(function() {
			var txtno = $('#txtno').val();
			$('#frm').attr('action', '/yummymap/txt/delete.mmy');
			$('#frm').submit();
		});
	});