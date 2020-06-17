package com.yummymap.mmy.controller.txt;

import com.yummymap.mmy.dao.TxtDAO;
import com.yummymap.mmy.vo.TxtVO;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping({"/txt"})
public class Txt {
	@Autowired
	TxtDAO tDAO;

	@RequestMapping({"/list.mmy"})
	public ModelAndView list(ModelAndView mv) {
		String view = "txt/list";
		ArrayList<TxtVO> list = (ArrayList) this.tDAO.getList();
		mv.addObject("LIST", list);
		mv.setViewName(view);
		return mv;
	}

	@RequestMapping(value = {"/write.mmy"}, method = {RequestMethod.GET})
	public String write() {
		String view = "txt/write";
		return view;
	}

	@RequestMapping(value = {"/write.mmy"}, method = {RequestMethod.POST}, params = {"mid", "catno", "title", "mtxt"})
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

	@RequestMapping({"/detail.mmy"})
	public ModelAndView detail(String mid, int txtno, ModelAndView mv, TxtVO tVO, HttpSession session) {
		String view = "txt/detail";
		TxtVO vo = this.tDAO.detail(txtno);
		tDAO.count(txtno);
		vo.setTxtno(txtno);
		mv.addObject("DATA", vo);
		return mv;
	}

	@RequestMapping(value = {"/delete.mmy"}, method = {RequestMethod.POST}, params = {"txtno"})
	public ModelAndView delete(int txtno, TxtVO tVO, ModelAndView mv) {
		String view = "txt/list";
		tVO.setTxtno(txtno);
		int cnt = this.tDAO.delete(txtno);
		if (cnt == 1) {
			RedirectView rv = new RedirectView("/yummymap/txt/list.mmy");
			mv.setView(rv);
		}

		return mv;
	}

	@RequestMapping(value = {"/edit.mmy"}, method = {RequestMethod.POST}, params = {"txtno", "title", "mtxt"})
	public ModelAndView edit(int txtno, String title, String mtxt, TxtVO tVO, ModelAndView mv, HttpSession session) {
		String view = "txt/edit";
		TxtVO vo = this.tDAO.edit(tVO);
		mv.addObject("DATA", vo);
		return mv;
	}

	@RequestMapping(value = {"/editProc.mmy"}, method = {RequestMethod.POST}, params = {"txtno", "title", "mtxt",
			"catno"})
	public ModelAndView editProc(int txtno, String title, String mtxt, int catno, TxtVO tVO, ModelAndView mv,
			HttpSession session) {
		String view = "txt/edit";
		tDAO.edit(tVO);
		RedirectView rv = new RedirectView("/yummymap/txt/detail.mmy?txtno=" + tVO.getTxtno());
		mv.setView(rv);
		return mv;
	}

	@RequestMapping(value = {"/recommend.mmy"}, method = {RequestMethod.POST}, params = {"mid", "txtno"})
	public ModelAndView recommend(int rnum, int txtno, String mid, String isrec, ModelAndView mv, TxtVO tVO) {
		tDAO.recommend(tVO);
		if (isrec.equals("Y")) {
			tDAO.recY(tVO);
			tDAO.up(txtno);
		} else {
			tDAO.recN(tVO);
			tDAO.down(txtno);
		}

		return mv;
	}
}