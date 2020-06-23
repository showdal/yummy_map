/**
 @author 유태희
 @since 2020.06.12
 	이 클래스는 차트에 관련된 서비스 클래스 입니다 
*/
package com.yummymap.mmy.Service.chart;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummymap.mmy.dao.ChartDAO;
import com.yummymap.mmy.vo.admin.ChartCntVO;
import com.yummymap.mmy.vo.admin.ResCntVO;

@Service
public class ChartServiceImpl implements ChartService {
	@Autowired
	ChartDAO chartDao;

	public ChartCntVO infoChart() {
		ChartCntVO cvo =  chartDao.maindata();
		return cvo;
	}

	@Override
	public ArrayList<ResCntVO> resChart() {
		ArrayList<ResCntVO> list = (ArrayList<ResCntVO>) chartDao.category();
		return list;
	}

	
	
}
