package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.common.DBCon;
import com.game.dao.UserInfoDAO;

public class UserInfoDAOImpl implements UserInfoDAO {

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		List<Map<String, String>> userInfoList = new ArrayList<>();
		String sql = "SELECT \n" + "UI_NUM, UI_NAME, UI_ID, UI_PWD,\n"
				+ "UI_IMG_PATH, UI_DESC, UI_BIRTH, CREDAT, CRETIM\n" + " LMODAT, LMOTIM, ACTIVE\n" + " FROM USER_INFO;";
		try (Connection con = DBCon.getCon();) {
			try (PreparedStatement ps = con.prepareStatement(sql);) {
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> ui = new HashMap<>();
						ui.put("uiNum", rs.getString("UI_NUM"));
						ui.put("uiName", rs.getString("UI_NAME"));
						ui.put("uiId", rs.getString("UI_ID"));
						ui.put("uiPwd", rs.getString("UI_PWD"));
						ui.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						ui.put("uiDesc", rs.getString("UI_DESC"));
						ui.put("uiBirth", rs.getString("UI_BIRTH"));
						ui.put("credat", rs.getString("CREDAT"));
						ui.put("cretim", rs.getString("CRETIM"));
						ui.put("lmodat", rs.getString("LMODAT"));
						ui.put("lmotim", rs.getString("LMOTIM"));
						ui.put("active", rs.getString("active"));
						userInfoList.add(ui);
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoList;
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD," + " UI_IMG_PATH, UI_DESC, UI_BIRTH, CREDAT,"
				+ " CRETIM, LMODAT, LMOTIM, ACTIVE " + "FROM USER_INFO WHERE UI_NUM=?;";
		try (Connection con = DBCon.getCon();) {
			try (PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setString(1, uiNum);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						Map<String, String> userInfo = new HashMap<>();
						userInfo.put("uiNum", rs.getString("UI_NUM"));
						userInfo.put("uiName", rs.getString("UI_NAME"));
						userInfo.put("uiId", rs.getString("UI_ID"));
						userInfo.put("uiPwd", rs.getString("UI_PWD"));
						userInfo.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						userInfo.put("uiDesc", rs.getString("UI_DESC"));
						userInfo.put("uiBirth", rs.getString("UI_BIRTH"));
						userInfo.put("credat", rs.getString("CREDAT"));
						userInfo.put("cretim", rs.getString("CRETIM"));
						userInfo.put("lmodat", rs.getString("LMODAT"));
						userInfo.put("lmotim", rs.getString("LMOTIM"));
						userInfo.put("active", rs.getString("active"));
						return userInfo;
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		String sql = "INSERT INTO USER_INFO(\n" + "UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH,\n"
				+ "UI_DESC, UI_BIRTH, CREDAT, CRETIM,\n" + "LMODAT, LMOTIM\n" + ")\n" + "VALUES (\n" + "?, ?, ?, ?,\n"
				+ "?, ?, DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'),\n"
				+ "DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s')\n" + ");";
		try (Connection con = DBCon.getCon();) {
			try (PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiId"));
				ps.setString(3, userInfo.get("uiPwd"));
				ps.setString(4, userInfo.get("uiImgPath"));
				ps.setString(5, userInfo.get("uiDesc"));
				ps.setString(6, userInfo.get("uiBirth"));
				return ps.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		String sql = "UPDATE USER_INFO\r\n" + "SET UI_NAME=?,\r\n" + "UI_PWD=?,\r\n" + "UI_IMG_PATH=?,\r\n"
				+ "UI_DESC=?,\r\n" + "UI_BIRTH=?,\r\n" + "LMODAT=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "LMOTIM=DATE_FORMAT(NOW(),'%H%i%s')\r\n" + "WHERE UI_NUM=?";
		try (Connection con = DBCon.getCon();) {
			try (PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiPwd"));
				ps.setString(3, userInfo.get("uiImgPath"));
				ps.setString(4, userInfo.get("uiDesc"));
				ps.setString(5, userInfo.get("uiBirth"));
				ps.setString(6, userInfo.get("uiNum"));
				return ps.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		String sql = "DELETE FROM USER_INFO WHERE UI_NUM=?;";
		try (Connection con = DBCon.getCon();) {
			try (PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setString(1, uiNum);
				return ps.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
		UserInfoDAO uiRepo = new UserInfoDAOImpl();

		Map<String, String> ui = new HashMap<>();
		ui.put("uiName", "임RKr정");
		ui.put("uiId", "HONG1");
		ui.put("uiPwd", "Hong");
		ui.put("uiDesc", "동에번쩍서에번쩍");
		ui.put("uiBirth", "19880902");
		ui.put("uiNum", "5");

		System.out.println(uiRepo.selectUserInfo("1"));

		System.out.println(uiRepo.deleteUserInfo("5"));

	}

	@Override
	public Map<String, String> selectUserInfoById(String uiId) {
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD," + " UI_IMG_PATH, UI_DESC, UI_BIRTH, CREDAT,"
				+ " CRETIM, LMODAT, LMOTIM, ACTIVE " + "FROM USER_INFO WHERE UI_ID=?;";
		try (Connection con = DBCon.getCon();) {
			try (PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setString(1, uiId);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						Map<String, String> userInfo = new HashMap<>();
						userInfo.put("uiNum", rs.getString("UI_NUM"));
						userInfo.put("uiName", rs.getString("UI_NAME"));
						userInfo.put("uiId", rs.getString("UI_ID"));
						userInfo.put("uiPwd", rs.getString("UI_PWD"));
						userInfo.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						userInfo.put("uiDesc", rs.getString("UI_DESC"));
						userInfo.put("uiBirth", rs.getString("UI_BIRTH"));
						userInfo.put("credat", rs.getString("CREDAT"));
						userInfo.put("cretim", rs.getString("CRETIM"));
						userInfo.put("lmodat", rs.getString("LMODAT"));
						userInfo.put("lmotim", rs.getString("LMOTIM"));
						userInfo.put("active", rs.getString("active"));
						return userInfo;
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
