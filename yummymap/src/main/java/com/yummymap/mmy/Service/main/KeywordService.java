package com.yummymap.mmy.Service.main;

import com.yummymap.mmy.vo.SearchInfoVO;

public interface KeywordService {
	
	public SearchInfoVO analyzeKeyword(SearchInfoVO searchInfoVo);
	
	public boolean insertKeyword(SearchInfoVO searchInfoVo);
}
