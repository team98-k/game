package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.BoardInfoDAO;

public class BoardInfoDAOImpl implements BoardInfoDAO {

	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> board) {
		String sql = "SELECT BI_NUM,BI_TITLE,BI_CONTENT,UI_NUM, CREDAT, CRETIM, LMODAT, LMOTIM\n"
				+ "FROM BOARD_INFO";
		List<Map<String, String>> boardInfoList = new ArrayList<Map<String,String>>();
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> bi = new HashMap<String, String>();
						bi.put("biNum", rs.getString("BI_NUM"));
						bi.put("biTitle", rs.getString("BI_TITLE"));
						bi.put("biContent", rs.getString("BI_CONTENT"));
						bi.put("uiNum", rs.getString("UI_NUM"));
						bi.put("credat", rs.getString("CREDAT"));
						bi.put("cretim", rs.getString("CRETIM"));
						bi.put("lmodat", rs.getString("LMODAT"));
						bi.put("lmotim", rs.getString("LMOTIM"));
						boardInfoList.add(bi);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return boardInfoList;
	}

	@Override
	public Map<String, String> selectBoardInfo(String biNum) {
		String sql = "SELECT BI_NUM,BI_TITLE,BI_CONTENT,UI_NUM, CREDAT, CRETIM, LMODAT, LMOTIM\n"
				+ "FROM BOARD_INFO WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, biNum);
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						Map<String, String> bi = new HashMap<String, String>();
						bi.put("biNum", rs.getString("BI_NUM"));
						bi.put("biTitle", rs.getString("BI_TITLE"));
						bi.put("biContent", rs.getString("BI_CONTENT"));
						bi.put("uiNum", rs.getString("UI_NUM"));
						bi.put("credat", rs.getString("CREDAT"));
						bi.put("cretim", rs.getString("CRETIM"));
						bi.put("lmodat", rs.getString("LMODAT"));
						bi.put("lmotim", rs.getString("LMOTIM"));
						return bi;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertBoardInfo(Map<String, String> board) {
		String sql="INSERT INTO BOARD_INFO(\n"
				+ "	BI_TITLE, BI_CONTENT, UI_NUM, CREDAT,\n"
				+ "    CRETIM, LMODAT, LMOTIM\n"
				+ ")VALUES(?, ?, ?, DATE_FORMAT(NOW(), '%Y%m%d'),\n"
				+ "DATE_FORMAT(NOW(), '%H%i%s'), DATE_FORMAT(NOW(), '%Y%m%d'),\n"
				+ "DATE_FORMAT(NOW(), '%H%i%s')\n"
				+ ")";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, board.get("biTitle"));
				ps.setString(2, board.get("biContent"));
				ps.setString(3, board.get("uiNum"));
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBoardInfo(Map<String, String> board) {
		String sql="UPDATE BOARD_INFO\n"
				+ "SET BI_TITLE = ?,\n"
				+ "BI_CONTENT=?,\n"
				+ "UI_NUM=?,\n"
				+ "LMODAT=DATE_FORMAT(NOW(), '%Y%m%d'),\n"
				+ "LMOTIM=DATE_FORMAT(NOW(), '%H%i%s')\n"
				+ "WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, board.get("biTitle"));
				ps.setString(2, board.get("biContent"));
				ps.setString(3, board.get("uiNum"));
				ps.setString(4, board.get("biNum"));
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		String sql = "DELETE FROM BOARD_INFO WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, biNum);
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		BoardInfoDAO biDAO = new BoardInfoDAOImpl();
//		Map<String, String> biMock = new HashMap<String, String>();
//		biMock.put("biTitle", "test1");
//		biMock.put("biContent", "test1");
//		biMock.put("uiNum", "1");
//		biMock.put("biNum", "5");
//		int result = biDAO.deleteBoardInfo("5");
//		System.out.println(result);
		System.out.println(biDAO.selectBoardInfo("6").get("biTitle"));
//		System.out.println(biDAO.selectBoardInfo("5"));
	}

}
