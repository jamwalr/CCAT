package com.bizviz.ccat.util;

import javax.servlet.http.HttpServletRequest;

import com.bizviz.ccat.modal.Test;

public class CCATUtil {

	public static String createURL(Test test, HttpServletRequest req){
		
		StringBuilder URL = new StringBuilder();
		URL.append(req.getRequestURI().toString());
		URL.append("begin_test.jsp?uid="+test.getUser().getUid()+"&tid="+test.getTestId());
		
		return URL.toString();
	}
}
