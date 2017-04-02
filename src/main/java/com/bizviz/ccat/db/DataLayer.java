package com.bizviz.ccat.db;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bizviz.ccat.modal.Test;
import com.bizviz.ccat.modal.User;

public class DataLayer {

	public static boolean createTest(Test test) {
		String checkUser = "select userid from users where name ='" + test.getUser().getName() + "' and email ='"
				+ test.getUser().getEmail()+"'";
		String inserTest = null;
		int userId = 0;
		try {
			ResultSet rs = DBConnection.getInstance().query(checkUser);
			if (rs.next()) {
				userId = rs.getInt(1);
			}
			test.getUser().setUid(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!(userId > 0)) {
			String insertUser = "insert into users values(0,'"+test.getUser().getEmail()+"','"+test.getUser().getName()+"')";

			try {
				Statement stat = DBConnection.getInstance().getConnection().createStatement();
				stat.execute(insertUser, Statement.RETURN_GENERATED_KEYS);

				ResultSet rs = stat.getGeneratedKeys();
				if (rs.next()) {
					userId = rs.getInt(1);
				}
				test.getUser().setUid(userId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			inserTest = "insert into exam (start,endDAte,uid) values('" + new Date(test.getBeginDate().getTime()) + "','"
					+ new Date(test.getEndDate().getTime()) + "'," + test.getUser().getUid() + ")";

			try {
				Statement stat = DBConnection.getInstance().getConnection().createStatement();
				stat.execute(inserTest, Statement.RETURN_GENERATED_KEYS);

				ResultSet rs = stat.getGeneratedKeys();
				int textId = 0;
				if (rs.next()) {
					textId = rs.getInt(1);
				}
				test.setTestId(textId);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		return false;
	}
	
	static public User getUser(String uid){
		String query = "select * from users where userid = "+uid;
		User user = null;
		ResultSet rs = null;
		try {
			rs = DBConnection.getInstance().query(query);
			if(rs.next()){
				int userId = rs.getInt(1);
				String email = rs.getString(2);
				String name = rs.getString(3);
				user = new User(userId,email,name);
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//static public Test
}
