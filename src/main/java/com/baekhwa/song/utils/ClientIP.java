package com.baekhwa.song.utils;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ClientIP {
	public static String getClientIP(HttpServletRequest request) {
		
		String ip = request.getHeader("X-Forwarded-For");
		 
		log.info(">>>> X-FORWARDED-FOR : " + ip);
 
        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
            log.info(">>>> Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
            log.info(">>>> WL-Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            log.info(">>>> HTTP_CLIENT_IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            log.info(">>>> HTTP_X_FORWARDED_FOR : " + ip);
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        
        log.info(">>>> Result : IP Address : "+ip);
 
        return ip;

	}

}
