 package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.UserBean;

import com.util.Dbconnection;

public class UserDao {

	public UserBean login(String email, String password) {
		UserBean user = null;
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstms = con.prepareStatement("select * from users  where email=? and password=?");) {

			pstms.setString(1, email);
			pstms.setString(2, password);
			ResultSet rs = pstms.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setUserid(rs.getInt("userid"));
				user.setEmail(rs.getString("email"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setContact_number(rs.getString("contact_number"));
				user.setGender(rs.getString("gender"));
				user.setActive(rs.getString("active"));
				user.setRole(rs.getString("role"));

			}
		} catch (SQLException e) {

			System.out.println("SMW in loginUser()");
			e.printStackTrace();
		}
		return user;

	}

	public int adduser(UserBean userBean) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"insert into users (firstname,lastname,email,password,gender,contact_number) values(?,?,?,?,?,?)");) {

			pstmt.setString(1, userBean.getFirstname());
			pstmt.setString(2, userBean.getLastname());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setString(4, userBean.getPassword());
			pstmt.setString(5, userBean.getGender());
			pstmt.setString(6, userBean.getContact_number());
			int record = pstmt.executeUpdate();

			return record;
		} catch (SQLException e) {
			System.out.println("smw in adduser()");
			e.printStackTrace();
		}
		return 0;
	}

	public boolean duplicate(String email) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstms = con.prepareStatement("select * from users  where email=?");) {
			System.out.println("email" + email);
			pstms.setString(1, email);
			ResultSet rs = pstms.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("SMW in duplicate()");
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<UserBean> listuser() {
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		// TODO Auto-generated method stub
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement ptsmt = con.prepareStatement("select * from users");) {
			ResultSet rs = ptsmt.executeQuery();
			while (rs.next()) {

				UserBean user = new UserBean();
				user.setUserid(rs.getInt("userid"));
				user.setEmail(rs.getString("email"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setContact_number(rs.getString("contact_number"));
				user.setGender(rs.getString("gender"));
				user.setActive(rs.getString("active"));
				user.setRole(rs.getString("role"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public boolean updateactive(int userid, String status) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update users set active=? where userid=?");) {
			pstmt.setString(1, status);
			pstmt.setInt(2, userid);
			int record = pstmt.executeUpdate();
			if(record==1) {
				return true;				
			}
		} catch (SQLException e) {
			System.out.println("smw in update active");
			e.printStackTrace();
		}
		return false;
	}

}
