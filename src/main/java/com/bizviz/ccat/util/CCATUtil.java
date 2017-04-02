package com.bizviz.ccat.util;

import javax.servlet.http.HttpServletRequest;

import com.bizviz.ccat.modal.Test;

public class CCATUtil {

	public static String createURL(Test test, HttpServletRequest req){
		
		StringBuilder URL = new StringBuilder();
		String scheme = req.getScheme() + "://";
	    String serverName = req.getServerName();
	    String serverPort = (req.getServerPort() == 80) ? "" : ":" + req.getServerPort();
	    String contextPath = req.getContextPath();
	    
		URL.append(scheme+serverName+serverPort+contextPath);
		URL.append("/begin_test.jsp?uid="+test.getUser().getUid()+"&amptid="+test.getTestId());
		
		return URL.toString();
	}
}
