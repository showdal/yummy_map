package com.yummymap.mmy.controller.txt;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.databind.Module.SetupContext;
import com.yummymap.mmy.dao.TxtDAO;
import com.yummymap.mmy.vo.txt.TxtVO;

@Controller
@RequestMapping("/txt")
public class Txt {
	@Autowired
	TxtDAO tDAO;

	@RequestMapping("/list.mmy")
	public ModelAndView list(ModelAndView mv) {
		String view = "txt/list";
		ArrayList<TxtVO> list = (ArrayList) this.tDAO.getList();
		mv.addObject("LIST", list);
		mv.setViewName(view);
		return mv;
	}

	@RequestMapping(value = "/write.mmy", method = RequestMethod.GET)
	public String write() {
		String view = "txt/write";
		return view;
	}

	@RequestMapping(value = "/write.mmy", method = RequestMethod.POST, params = { "mid", "catno", "title", "mtxt" })
	public ModelAndView writeProc(String mid, int catno, String title, String mtxt, ModelAndView mv, TxtVO tVO,
			HttpSession session) {
		String view = "txt/list";
		tVO.setMid(mid);
		tVO.setCatno(catno);
		tVO.setTitle(title);
		tVO.setMtxt(mtxt);
		tDAO.write(tVO);
		System.out.println(tVO.getMid());
		if (mtxt != null) {
			RedirectView rv = new RedirectView("/yummymap/txt/list.mmy");
			mv.setView(rv);
		}
		return mv;
	}

	@RequestMapping(value = "/detail.mmy", method = RequestMethod.POST, params = { "txtno" })
	public ModelAndView detail(String mid, int txtno, ModelAndView mv, TxtVO tVO, HttpSession session) {
		String view = "txt/detail";
		TxtVO vo = tDAO.detail(txtno);
		tDAO.count(txtno);
		vo.setTxtno(txtno);
		mv.addObject("DATA", vo);
		return mv;
	}

	@RequestMapping(value = "/delete.mmy", method = RequestMethod.POST, params = { "txtno"})
	public ModelAndView delete(int txtno, TxtVO tVO, ModelAndView mv) {
		String view = "txt/list";
		tVO.setTxtno(txtno);
		int cnt = tDAO.delete(txtno);
//		if (cnt == 1) {
			RedirectView rv = new RedirectView("/yummymap/txt/list.mmy");
			mv.setView(rv);
//		}
		return mv;
	}

	@RequestMapping(value = "/edit.mmy", method = RequestMethod.POST, params = { "txtno", "title", "mtxt" })
	public ModelAndView edit(int txtno, String title, String mtxt, TxtVO tVO, ModelAndView mv, HttpSession session) {
		String view = "txt/edit";
		TxtVO vo = tDAO.edit(tVO);
		mv.addObject("DATA", vo);
		return mv;
	}

	@RequestMapping(value = "/editProc.mmy", method = RequestMethod.POST, params = { "txtno", "title", "mtxt","catno" })
	public ModelAndView editProc(int txtno, String title, String mtxt, int catno, TxtVO tVO, ModelAndView mv,HttpSession session) {
		String view = "txt/edit";
		tDAO.edit(tVO);
		RedirectView rv = new RedirectView("/yummymap/txt/detail.mmy?txtno=" + tVO.getTxtno());
		mv.setView(rv);
		return mv; 
	}
	@RequestMapping(value="/rList.mmy")
	@ResponseBody
	public List<TxtVO> rList(int txtno, String mtxt, TxtVO tVO, HttpServletRequest req) { 
		ArrayList<TxtVO> rList = (ArrayList<TxtVO>)tDAO.rList(txtno); 
		tVO.setUpno(txtno);
		req.setAttribute("LIST", rList);
		return rList;
	 }
	@RequestMapping(value="/rWrite.mmy", method = RequestMethod.POST, params = {"mtxt","txtno","mid"})
	@ResponseBody
	public TxtVO rWrite(TxtVO tVO, ModelAndView mv, int upno, HttpSession session, String mid, String mtxt, int txtno) {
		String veiw = "txt/detail";
		tVO.setUpno(upno);
//		tVO.setTxtno(txtno);
		
		System.out.println("upno : " + tVO.getUpno());
		System.out.println("txtno : " + tVO.getTxtno());
		TxtVO vo= tDAO.rWrite(tVO);
		return vo;
	}
	@RequestMapping(value="/rDelete.mmy", method=RequestMethod.POST, params= {"txtno","upno"})
	@ResponseBody
	public TxtVO rDelete(int txtno, int upno, TxtVO tVO, HttpSession session) {
		tVO.setUpno(upno);
		tDAO.rDelete(tVO);
		System.out.println("upno : " + tVO.getUpno());
		System.out.println("txtno : " + tVO.getTxtno());
		return tVO;
	}
	
	
	@RequestMapping(value = "/like.mmy", method=RequestMethod.POST, params= {"txtno","rnum"})
	@ResponseBody
	public TxtVO like(int txtno, TxtVO tVO, int rnum, String mid, HttpSession session, ModelAndView mv) {
		int cnt = tDAO.checkLike(tVO);
		rnum = tDAO.likeCnt(txtno);
		tVO.setRnum(rnum);
		mv.addObject("DATA",tVO);
		
		if(cnt == 0) {
			tDAO.addLike(tVO);
			rnum += 1;
		} else {
			tDAO.editLike(tVO);
			rnum = rnum-1;
		}
		System.out.println(tVO.getRnum());
		return tVO;
	}
}