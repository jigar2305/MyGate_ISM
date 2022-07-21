package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.HouseBean;
import com.util.Dbconnection;

public class HouseDao {

	public boolean addhouse(HouseBean houseBean) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into house (userid,house_number,block_name) values(?,?,?)");) {

			pstmt.setInt(1, houseBean.getUserid());
			pstmt.setString(2, houseBean.getHouse_number());
			pstmt.setString(3, houseBean.getblock_name());

			int record = pstmt.executeUpdate();
			if (record == 1) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("smw in adduser()");
			e.printStackTrace();
		}
		return false;
		// TODO Auto-generated method stub

	}

	public ArrayList<HouseBean> listhouse(int userid) {
		ArrayList<HouseBean> houses = new ArrayList<>();
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from house where userid=?");) {
			pstmt.setInt(1, userid);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				HouseBean houseBean = new HouseBean();
				houseBean.setUserid(rs.getInt("userid"));
				houseBean.setblock_name(rs.getString("block_name"));
				houseBean.setHouse_number(rs.getString("house_number"));
				houseBean.setHouseid(rs.getInt("houseid"));
				if(rs.getString("status").equals("y")) {
					houseBean.setStatus("allow");
				}else {
					houseBean.setStatus("Not allow");
				}
				houses.add(houseBean);

			}
		} catch (SQLException e) {
			System.out.println("smw in listhouse");
			e.printStackTrace();
		}
		return houses;
	}

	public ArrayList<HouseBean> listhousetoadmin() {
		ArrayList<HouseBean> houses = new ArrayList<>();
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from house");) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				HouseBean houseBean = new HouseBean();
				houseBean.setUserid(rs.getInt("userid"));
				houseBean.setblock_name(rs.getString("block_name"));
				houseBean.setHouse_number(rs.getString("house_number"));
				houseBean.setHouseid(rs.getInt("houseid"));
				if(rs.getString("status").equals("y")) {
					houseBean.setStatus("allow");
				}else {
					houseBean.setStatus("Not allow");
				}
				houses.add(houseBean);

			}
		} catch (SQLException e) {
			System.out.println("smw in listhousetoadmin()");
			e.printStackTrace();
		}
		return houses;
	}

	public static boolean updatehousestatus(int houseid, String status) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update house set status=? where houseid=?");) {
			pstmt.setString(1, status);
			pstmt.setInt(2, houseid);
			int record = pstmt.executeUpdate();
			if(record==1) {
				return true;				
			}
		} catch (SQLException e) {
			System.out.println("smw in update house status()");
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<HouseBean> listhousetoadminbyid(int userid) {
		ArrayList<HouseBean> houses = new ArrayList<>();
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from house where userid=? and status='y'");) {
			pstmt.setInt(1, userid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				HouseBean houseBean = new HouseBean();
				houseBean.setUserid(rs.getInt("userid"));
				houseBean.setblock_name(rs.getString("block_name"));
				houseBean.setHouse_number(rs.getString("house_number"));
				houseBean.setHouseid(rs.getInt("houseid"));
				houses.add(houseBean);

			}
		} catch (SQLException e) {
			System.out.println("smw in listhousetoadmin()");
			e.printStackTrace();
		}
		return houses;
	}



}
