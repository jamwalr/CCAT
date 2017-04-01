package com.bizviz.ccat.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bizviz.ccat.modal.Test;

public class DataLayer {

	public static boolean createTest(Test test) {
		String checkUser = "select uid from user where name " + test.getUid().getName() + " and email"
				+ test.getUid().getEmail();
		int userId = 0;
		try {
			ResultSet rs = DBConnection.createInstance().query(checkUser);
			if (rs.next()) {
				userId = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(userId > 0){
			
		}

		return false;
	}
}
