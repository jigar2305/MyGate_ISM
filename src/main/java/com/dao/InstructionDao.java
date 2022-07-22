package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.bean.InstructionBean;
import com.util.Dbconnection;

public class InstructionDao {

	public int addinstruction(InstructionBean instructionBean) {

		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"insert into instruction (name,type,description,houseid,exit_time) values(?,?,?,?,?)");) {

			pstmt.setString(1, instructionBean.getName());
			pstmt.setString(2, instructionBean.getType());
			pstmt.setString(3, instructionBean.getDescription());
			pstmt.setInt(4, instructionBean.getHouseid());
			pstmt.setString(5, instructionBean.getExit_time());
			int record = pstmt.executeUpdate();

			return record;
		} catch (SQLException e) {
			System.out.println("smw in addinstruction()");
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<InstructionBean> listinst() {

		ArrayList<InstructionBean> instruction = new ArrayList<InstructionBean>();
		// TODO Auto-generated method stub
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement ptsmt = con.prepareStatement(
						"select * from instruction i,house h where i.houseid=h.houseid and date=?");) {
			ptsmt.setObject(1, LocalDate.now());
			ResultSet rs = ptsmt.executeQuery();
			while (rs.next()) {

				InstructionBean inst = new InstructionBean();
				inst.setInstructionid(rs.getInt("instructionid"));
				inst.setName(rs.getString("name"));
				inst.setDescription(rs.getString("description"));
				if (rs.getString("status").equals("y")) {
					inst.setStatus("allow");
				} else {
					inst.setStatus("Not allow");
				}
				inst.setBlock_name(rs.getString("block_name"));
				inst.setHouse_number(rs.getString("house_number"));
				inst.setType(rs.getString("type"));
				inst.setExit_time(rs.getString("exit_time"));
				instruction.add(inst);

			}
		} catch (SQLException e) {
			System.out.println("smw in listinst()");
			e.printStackTrace();
		}
		return instruction;

	}

	public ArrayList<InstructionBean> listinstbyuserid(int userid) {

		ArrayList<InstructionBean> instruction = new ArrayList<InstructionBean>();
		// TODO Auto-generated method stub
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement ptsmt = con.prepareStatement(
						"select * from instruction i,house h where i.houseid=h.houseid and userid=?");) {
			ptsmt.setInt(1, userid);
			ResultSet rs = ptsmt.executeQuery();
			while (rs.next()) {

				InstructionBean inst = new InstructionBean();
				inst.setInstructionid(rs.getInt("instructionid"));
				inst.setName(rs.getString("name"));
				inst.setDescription(rs.getString("description"));
				if (rs.getString("status").equals("y")) {
					inst.setStatus("allow");

				} else {
					inst.setStatus("Not allow");
				}
				inst.setBlock_name(rs.getString("block_name"));
				inst.setHouse_number(rs.getString("house_number"));
				inst.setType(rs.getString("type"));
				inst.setExit_time(rs.getString("exit_time"));
				instruction.add(inst);

			}
		} catch (SQLException e) {
			System.out.println("smw in listinstbyuserid()");
			e.printStackTrace();
		}
		return instruction;

	}

	public int updatestatus(int instructionid) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("update instruction set status=? where instructionid=?");) {
			pstmt.setString(1, "y");
			pstmt.setInt(2, instructionid);
			int record = pstmt.executeUpdate();

			return record;

		} catch (SQLException e) {
			System.out.println("smw in update status");
			e.printStackTrace();
		}
		return 0;
	}

	public int addinstructionbymember(InstructionBean instructionBean) {
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"insert into instruction (name,type,description,houseid,exit_time,status) values(?,?,?,?,?,?)");) {
			pstmt.setString(1, instructionBean.getName());
			pstmt.setString(2, instructionBean.getType());
			pstmt.setString(3, instructionBean.getDescription());
			pstmt.setInt(4, instructionBean.getHouseid());
			pstmt.setString(5, instructionBean.getExit_time());
			if (instructionBean.getStatus().equals("allow")) {
				pstmt.setString(6, "y");

			} else {
				pstmt.setString(6, "n");
			}
			int record = pstmt.executeUpdate();

			return record;
		} catch (SQLException e) {
			System.out.println("smw in addinstructionbymember()");
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<InstructionBean> listinsttoadmin() {
		ArrayList<InstructionBean> instruction = new ArrayList<InstructionBean>();
		// TODO Auto-generated method stub
		try (Connection con = Dbconnection.getConnection();
				PreparedStatement ptsmt = con
						.prepareStatement("select * from instruction i,house h where i.houseid=h.houseid");) {
			ResultSet rs = ptsmt.executeQuery();
			while (rs.next()) {

				InstructionBean inst = new InstructionBean();
				inst.setInstructionid(rs.getInt("instructionid"));
				inst.setName(rs.getString("name"));
				inst.setDescription(rs.getString("description"));
				if (rs.getString("status").equals("y")) {
					inst.setStatus("allow");
				} else {
					inst.setStatus("Not allow");
				}
				inst.setBlock_name(rs.getString("block_name"));
				inst.setHouse_number(rs.getString("house_number"));
				inst.setType(rs.getString("type"));
				inst.setDate(rs.getString("date"));
				inst.setExit_time(rs.getString("exit_time"));
				instruction.add(inst);

			}
		} catch (SQLException e) {
			System.out.println("smw in listinst()");
			e.printStackTrace();
		}
		return instruction;
	}

	public int exitetime(int instructionid) {
		Connection con = Dbconnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("update instruction set exit_time=? where instructionid=?");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
			   LocalDateTime now = LocalDateTime.now();  
			   System.out.println(dtf.format(now));  
			
			pstmt.setObject(1, dtf.format(now));

			pstmt.setInt(2, instructionid);
			int record = pstmt.executeUpdate();

			return record;

		} catch (SQLException e) {
			System.out.println("smw in exitetime()");
			e.printStackTrace();
		}
		return 0;
	}

}
