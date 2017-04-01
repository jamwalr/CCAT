package com.bizviz.ccat.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bizviz.ccat.modal.Test;

public class DataLayer {

	public static boolean createTest(Test test) {
		String checkUser = "select uid from user where name " + test.getUid().getName() + " and email"
				+ test.getUid().getEmail();
		String inserTest = null;
		int userId = 0;
		try {
			ResultSet rs = DBConnection.getInstance().query(checkUser);
			if (rs.next()) {
				userId = rs.getInt(1);
			}
			test.getUid().setUid(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(userId > 0){
			inserTest = "insert into test values(0,"+test.getUid().getUid()+",'"+test.getBeginDate()+"','"+test.getEndDate()+"')";
			
			try {
				Statement stat = DBConnection.getInstance().getConnection().createStatement();
				stat.execute(inserTest, Statement.RETURN_GENERATED_KEYS);
				
				ResultSet rs = stat.getGeneratedKeys();
				int textId = 0;
				if(rs.next()){
					textId = rs.getInt(1);
				}
				test.setTestId(textId);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}
}
