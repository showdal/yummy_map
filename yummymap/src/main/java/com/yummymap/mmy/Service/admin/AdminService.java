package com.yummymap.mmy.Service.admin;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	
	public AdminService() {
    	String path = this.getClass().getResource("/").getPath();
        System.setProperty("SavePath", path);
	}
	
	
	private  Logger logger = LoggerFactory.getLogger(AdminService.class);
	public void PublicKeySrvc(HttpServletRequest req) {
		

		
		String ip = req.getHeader("X-FORWARDED-FOR");
		if(ip == null) {
			ip = req.getRemoteAddr();
		}
		Date time = new Date();
		SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date = form.format(time);
		
		logger.info("{} {} {}",date,ip," - 회원가입");
		System.out.println("서비스~~~~~");
	}
}
