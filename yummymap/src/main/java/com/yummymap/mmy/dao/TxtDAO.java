package com.yummymap.mmy.dao;

import com.yummymap.mmy.vo.TxtVO;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class TxtDAO {
	@Autowired
	SqlSessionTemplate sqlSession;

	public List getList() {
		return this.sqlSession.selectList("tSQL.tList");
	}

	public TxtVO write(TxtVO tVO) {
		this.sqlSession.insert("tSQL.tWrite", tVO);
		return tVO;
	}

	public TxtVO detail(int txtno) {
		return (TxtVO) this.sqlSession.selectOne("tSQL.tDetail", txtno);
	}

	public int delete(int txtno) {
		return this.sqlSession.update("tSQL.tDelete", txtno);
	}

	public TxtVO edit(TxtVO tVO) {
		this.sqlSession.update("tSQL.tEdit", tVO);
		return tVO;
	}

	public void count(int txtno) {
		this.sqlSession.update("tSQL.tCount", txtno);
	}

	public void up(int txtno) {
		this.sqlSession.update("tSQL.tUp", txtno);
	}

	public void down(int txtno) {
		this.sqlSession.update("tSQL.tDown", txtno);
	}

	public TxtVO recommend(TxtVO tVO) {
		return (TxtVO) this.sqlSession.selectOne("tSQL.tRecommend", tVO);
	}

	public TxtVO recY(TxtVO tVO) {
		this.sqlSession.insert("tSQL.tRecY", tVO);
		return tVO;
	}

	public TxtVO recN(TxtVO tVO) {
		this.sqlSession.update("tSQL.tRecN", tVO);
		return tVO;
	}
}