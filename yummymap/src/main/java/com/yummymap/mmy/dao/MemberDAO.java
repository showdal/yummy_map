package com.yummymap.mmy.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberDAO {
	@Autowired
	SqlSessionTemplate sqlSession;

	public void testDAO() {
		System.out.println("######### testDAO() ½ÇÇà ############# ");
	}
}