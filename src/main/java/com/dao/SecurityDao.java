package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.SecurityBean;
import com.util.Dbconnection;

public class SecurityDao {

	public int addsecurity(SecurityBean securityBean) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"insert into security (firstname,lastname,contact_number,password) values(?,?,?,?)");) {
		

			pstmt.setString(1, securityBean.getFirstname());
			pstmt.setString(2, securityBean.getLastname());
			pstmt.setString(3, securityBean.getContact_number());
			pstmt.setString(4, securityBean.getPassword());

			int record = pstmt.executeUpdate();

			return record;
		} catch (SQLException e) {
			System.out.println("smw in addsecurity()");
			e.printStackTrace();
		}
		return 0;
	}

	public SecurityBean loginsecurity(String number, String password) {
		SecurityBean security = null;
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstms = con.prepareStatement("select * from security  where contact_number=? and password=?");) {

			pstms.setString(1, number);
			pstms.setString(2, password);
			ResultSet rs = pstms.executeQuery();
			if (rs.next()) {
				security = new SecurityBean();
				
				security.setFirstname(rs.getString("firstname"));
				security.setLastname(rs.getString("lastname"));
				security.setContact_number(rs.getString("contact_number"));
			}
		} catch (SQLException e) {

			System.out.println("SMW in loginsecurity()");
			e.printStackTrace();
		}
		return security;

	}

	public ArrayList<SecurityBean> listsecurity() {
		ArrayList<SecurityBean> securitys = new ArrayList<SecurityBean>();
		// TODO Auto-generated method stub
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement ptsmt = con.prepareStatement("select * from security");) {
			ResultSet rs = ptsmt.executeQuery();
			while (rs.next()) {

				SecurityBean security = new SecurityBean();
				security.setSecurityid(rs.getInt("securityid"));
				security.setFirstname(rs.getString("firstname"));
				security.setContact_number(rs.getString("contact_number"));
				security.setLastname(rs.getString("lastname"));
				securitys.add(security);
			}
		} catch (SQLException e) {
			System.out.println("smw in listsecurity()");
			e.printStackTrace();
		}
		return securitys;
	}
	

}
