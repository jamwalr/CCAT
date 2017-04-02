package com.bizviz.ccat.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.bizviz.ccat.db.DBConnection;

public class ValidateTest {

	public String checkValidity(String uid, String tid){
		int userId = Integer.parseInt(uid);
		int testId = Integer.parseInt(tid);
		Date today = new Date();
		Date start = null;
		Date expiry = null;
		boolean resultFound = false;
		boolean valid = false;
		String result = "";
		String query = "select e.startdate, e.expirydate from exam e where e.uid = "+uid+" and e.id = "+tid;
		try {
			ResultSet rs = DBConnection.getInstance().query(query);
			if(rs.next()){
				start = rs.getDate(1);
				expiry = rs.getDate(2);
				resultFound = true;
			}else{
				result = "NoRecord";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(resultFound){
			if(start.after(today) && today.before(expiry)){
				result = "BeginExam";
			} else if(start.before(today)){
				result = "Early";
			} else {
				result = "Expired";
			}
			
		}
		
		return result;
	}
}
