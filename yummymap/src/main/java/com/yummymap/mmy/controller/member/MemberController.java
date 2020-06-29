package com.yummymap.mmy.controller.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.yummymap.mmy.Service.Member.MemberService;
import com.yummymap.mmy.dao.*;
import com.yummymap.mmy.util.*;
import com.yummymap.mmy.vo.*;
import com.yummymap.mmy.vo.admin.ChartCntVO;

@RequestMapping("/member")
@Controller
public class MemberController {
	@Autowired
	MemberDAO mDao;
	@Autowired
	TextDAO tDao;
	@Autowired
	MailUtil YummyMap;
	@Autowired
	MemberService mSrvc;
	@Autowired
	ChartDAO cDAO;
	
	@RequestMapping("/login.mmy")
	public String loginView() {
		
		return "member/Login";
	}
	//로그인 컨트롤러
	@RequestMapping("/loginProc.mmy")
	public ModelAndView loginck(MemberVO mVO, ModelAndView mv, HttpSession session) {
		int cnt = mDao.loginck(mVO);
		System.out.println("cnt : " + cnt);
		RedirectView rv = null;
		if(cnt == 1) {
			 session.setAttribute("SID", mVO.getMid());
			 rv = new RedirectView("/yummymap/main.mmy");
		}else {
			 rv = new RedirectView("/yummymap/member/login.mmy");
		}
		mv.setView(rv);
		return mv;
	}
	//로그아웃 컨트롤러
	@RequestMapping("/logoutProc.mmy")
	public ModelAndView logout(HttpSession session, ModelAndView mv) {
	String view = "/yummymap/member/login.mmy";
	RedirectView rv = null;
	session.removeAttribute("SID");
	if(session.getAttribute("SID") != null) {
		view = "/yummymap/main.mmy";
	}
	rv = new RedirectView(view);
	mv.setView(rv);
	return mv;
}
	//내 정보 불러오기 컨트롤러
	@RequestMapping("member.mmy")
	public ModelAndView getUserInfo(ModelAndView mv, MemberVO mVO, HttpSession session ) {
		mSrvc.getUserInfo(mv, mVO, session);
		return mv;
	}
	//비밀번호 창 불러오기
	@RequestMapping("pwchange.mmy")
	public ModelAndView Pwchange(ModelAndView mv) {
		String view = "member/pwchange";
		
		mv.setViewName(view);
		return mv;
	}
	//비밀번호 변경
	@RequestMapping("pwEdit.mmy")
	public ModelAndView text(ModelAndView mv, MemberVO mVO, HttpSession session) {
	String view = "";
	mVO.setMid((String) session.getAttribute("SID"));
	int cnt = mDao.pwchange(mVO);
	RedirectView rv = new RedirectView(view);
	mv.setView(rv);
	
	return mv;
	}
	//회원 탈퇴 컨트롤러
	@RequestMapping("memberDel.mmy")
	public ModelAndView memberDel(ModelAndView mv, MemberVO mVO, HttpSession session) {
		String view ="";
		mVO.setMid((String) session.getAttribute("SID"));
		int cnt = mDao.memberDel(mVO);
		if(cnt == 0) {
			System.out.println("삭제 실패");
		} else {
			session.removeAttribute("SID");
			 view = "/yummymap/main.mmy";
		}
		RedirectView rv = new RedirectView(view);
		mv.setView(rv);
		return mv;
	}
	//아디찾기 컨트롤러
	@RequestMapping("idfind.mmy")
	@ResponseBody
	public  HashMap<String, String> idfind(String memail,String mid, MemberVO mVO) {
		return mSrvc.idfind(memail, mid, mVO);
	}

	//비밀번호 찾기 컨트롤러
	@RequestMapping("pwfind.mmy")
	@ResponseBody
	public HashMap<String, String> pwfind(String memail,String mid, MemberVO mVO){
		return mSrvc.pwfind(memail, mid, mVO);
	}
	//이메일 변경 창 불러오기
	@RequestMapping("emailChangeView.mmy")
	public ModelAndView emailchange(ModelAndView mv) {
		String view ="member/emailchange";
		mv.setViewName(view);
		return mv;
	}
	//이메일 보내기 컨트롤러
	@RequestMapping("mailformProc.mmy")
	public @ResponseBody String mailformProc(String email) {
		String from = email;
		//인증번호 생성
		Random ran = new Random();
		StringBuffer tmp = new StringBuffer();
		for(int i=0; i<6; i++) {
			tmp.append(ran.nextInt(10));
		}
		//이메일 보내기
		String inck = tmp.toString();
		String title = "이메일 변경 인증 메일 입니다";
		StringBuffer mtxt = new StringBuffer();
		mtxt.append("<h2>반갑습니다. <b>YummyMap</b> 입니다.</h2> ");
		mtxt.append("<br> ");
		mtxt.append("<h3>요청 주신 인증 번호는 <b style=\"color: blue;\">"+inck+"</b> 입니다.</h3> ");
		mtxt.append("<br> ");
		mtxt.append("<h3>인증 번호 입력 란에 입력해주시고 인증 확인후 진행 부탁드립니다</h3> ");
		mtxt.append("<h3>감사합니다.</h3> ");
		
			YummyMap.getSend(from, title, mtxt.toString());
			
			String inmail = inck;
				
		return inmail;
		
	}
	//이메일 변경 컨트롤러 
	@RequestMapping("emailChangeProc.mmy")
	public ModelAndView emailChange(ModelAndView mv, HttpSession session, MemberVO mVO) {
		String view = "member/member";
		mVO.setMid((String) session.getAttribute("SID"));
		int cnt = mDao.emailchange(mVO);
		RedirectView rv = new RedirectView(view);
		mv.setView(rv);
		return mv;
	}
	//내가쓴글 불러오기
	@RequestMapping("text.mmy")
	public ModelAndView text(ModelAndView mv, TextVO tVO, HttpSession session , PageUtil page) {
		String view = "member/text";
		tVO.setMid((String) session.getAttribute("SID"));
		int cnt = tDao.txtCnt(tVO);	

		page.setTotalCount(cnt);
		page.setPageRow(1);
		page.setPageGroup(1);
		page.totalfun();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("TVO" , tVO);
		map.put("page" , page);
		
		ArrayList<TextVO> list = (ArrayList<TextVO>) tDao.getList(map);
		 mv.addObject("LIST", list);
		 mv.addObject("PAGE", page);
		 mv.setViewName(view);
		return mv;
	}
	//선택 게시글 삭제
	@RequestMapping("/boardDel.mmy")
	public ModelAndView boardDel(int[] txtno , ModelAndView mv) {
		String view = "/yummymap/member/text.mmy";
		
		RedirectView rv = new RedirectView(view);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<txtno.length; i++) {
			list.add(txtno[i]);
		}

		int cnt = tDao.textDel(list);
		mv.setView(rv);
		
		return mv;
	}
	//활동 내역 컨트롤러
	@RequestMapping("/activity.mmy")
	public ModelAndView activity(ModelAndView mv, HttpSession session, ChartCntVO acvo) {
		String view ="member/activity";
		acvo.setMid((String) session.getAttribute("SID"));
		acvo = cDAO.activity(acvo);
		
		mv.addObject("CNT", acvo);
		mv.setViewName(view);
		return mv;
	}
}
