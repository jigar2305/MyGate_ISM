package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.MemberBean;
import com.util.Dbconnection;

public class MemberDao {

	public int addmember(MemberBean memberBean) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"insert into member (firstname,age,userid,gender,contact_number,houseid) values(?,?,?,?,?,?)");) {
			System.out.println(memberBean.getUserid());

			pstmt.setString(1, memberBean.getFirstname());
			pstmt.setInt(2, memberBean.getAge());
			pstmt.setInt(3, memberBean.getUserid());
			pstmt.setString(4, memberBean.getGender());
			pstmt.setString(5, memberBean.getContact_number());
			pstmt.setInt(6, memberBean.getUserid());
			int record = pstmt.executeUpdate();

			return record;
		} catch (SQLException e) {
			System.out.println("smw in addmember()");
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<MemberBean> listmember(int userid) {
		ArrayList<MemberBean> members = new ArrayList<MemberBean>();
		// TODO Auto-generated method stub
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement ptsmt = con.prepareStatement("select * from member where userid=?");) {
			ptsmt.setInt(1, userid);
			ResultSet rs = ptsmt.executeQuery();
			while (rs.next()) {

				MemberBean user = new MemberBean();
				user.setUserid(rs.getInt("userid"));
				user.setFirstname(rs.getString("firstname"));
				user.setContact_number(rs.getString("contact_number"));
				user.setGender(rs.getString("gender"));
				user.setHouseid(rs.getInt("houseid"));
				user.setAge(Integer.parseInt(rs.getString("age")));
				members.add(user);
			}
		} catch (SQLException e) {
			System.out.println("smw in listmember()");
			e.printStackTrace();
		}
		return members;
	}

}
