package com.yummymap.mmy.Service.main;

import java.util.List;

import com.yummymap.mmy.util.PageUtil;
import com.yummymap.mmy.vo.*;

public interface UpsoService {

	public UpsoVO getUpsoDetailInfo(int upso_id, String user_id);
	
	public boolean isShowUpso(int upso_id);

	public int insertUpso(UpsoVO upsoVo,  SearchInfoVO searchInfoVo);
	
	public List<UpsoVO> getUpsoList(SearchInfoVO searchInfoVo, PageUtil pageUtil);
	
	public RatingUpsoVO getRatingInfo(int upso_id);
	
	public List<ReviewVO> getReviewList(int upso_id);
	
	public List<ImageFileVO> getReviewImgList(int rev_no);
	
	public boolean insertReview(ReviewVO reviewVo);
	
	public List<UpsoVO> showWeeklyUpso();
	
	public List<UpsoVO> showMyUpso(SearchInfoVO searchInfoVo);

}
