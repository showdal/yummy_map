package com.yummymap.mmy.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.yummymap.mmy.vo.admin.ChartCntVO;
import com.yummymap.mmy.vo.admin.ResCntVO;

public class ChartDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	//카테고리 가져오기 전담 함수
	public List<ResCntVO> category() {
		return sqlSession.selectList("chartSQL.category");
	}
	
	public ChartCntVO maindata() {
		return sqlSession.selectOne("chartSQL.mainCnt");
	}
	public ChartCntVO activity(ChartCntVO cVO) {
		return sqlSession.selectOne("chartSQL.ActivityCnt",cVO);
	}
}
