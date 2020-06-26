package com.yummymap.mmy.Service.Member;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.yummymap.mmy.dao.MemberDAO;
import com.yummymap.mmy.util.MailUtil;
import com.yummymap.mmy.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	MemberDAO mDao;
	@Autowired
	MailUtil YummyMap;
	
	// 임시 비밀번호 발급 처리 함수
	public String  setPassword(int length) {
		int index = 0;
		char[] charArr = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' ,'!','@','-','_','$','*'};
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < length; i++) {
			index = (int) (charArr.length * Math.random());
			sb.append(charArr[index]);
		}
		
		return sb.toString();
	}
	//회원정보 가져오는 함수
	public void getUserInfo(ModelAndView mv, MemberVO mVO, HttpSession session ) {
		String view ="member/member";
		mVO.setMid((String) session.getAttribute("SID"));
		mVO = mDao.getUserInfo(mVO);
		mv.addObject("UserInfo", mVO);
		mv.setViewName(view);
	}
	//아이디 찾기 이메일 보내는 함수
	public  HashMap<String, String> idfind(String memail,String mid, MemberVO mVO){
		String from = memail;
		mid = mDao.idFind(mVO);
		HashMap<String, String> map = new HashMap<String, String>();
		if(mid == null) {
			map.put("result", "no");
		} else {
			map.put("result", "ok");
		
		String title = "아이디 찾기 메일 입니다";
		StringBuffer mtxt = new StringBuffer();
		mtxt.append("<h2>반갑습니다. <b>YummyMap</b> 입니다.</h2> ");
		mtxt.append("<br> ");
		mtxt.append("<h3>요청 주신 ID는 <b style=\"color: blue;\">"+mid+"</b> 입니다.</h3> ");
		mtxt.append("<br> ");
		mtxt.append("<h3>감사합니다.</h3> ");
			YummyMap.getSend(from, title, mtxt.toString());
		}
		return map;
	}
	//임시비밀번호 이메일 보내기 함수
	public HashMap<String, String> pwfind(String memail,String mid, MemberVO mVO){
		String from = memail;
		mVO.setMid(mid);
		mid = mVO.getMid();
		//임시패스워드 생성
		String mpw = setPassword(8);
		//임시패스워드 db저장
		mVO.setMpw(mpw);
		mDao.pwchange(mVO);
		
		int cnt = 0;
		
		HashMap<String, String> map = new HashMap<String, String>();
		cnt = mDao.pwFind(mVO);
		
		if(cnt == 0) {
			map.put("result", "no");
		} else {
			map.put("result", "ok");
			System.out.println(cnt + "아이디 이메일 있을경우!!!!");
			String title = "고객님의 계정 임시 패스워드 발송 안내 입니다.";
			StringBuffer mtxt = new StringBuffer();
			mtxt.append("<h2>반갑습니다. <b>YummyMap</b> 입니다.</h2> ");
			mtxt.append("<br> ");
			mtxt.append("<h3>고객님의 임시 비밀번호는 : <b style=\"color: blue;\">"+mpw+"</b> 입니다.</h3> ");
			mtxt.append("<br> ");
			mtxt.append("<h3>로그인후 반드시 패스워드 변경 부탁드립니다. </h3> ");
			mtxt.append("<h3>감사합니다.</h3> ");
			
			YummyMap.getSend(from, title, mtxt.toString());
		}
			
		return map;
		}
}
