package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.ClassInfoDAO;

public class ClassInfoDAOImpl implements ClassInfoDAO {

	@Override
	public List<Map<String, String>> selectClassInfoList(Map<String, String> classInfo) {
		List<Map<String, String>> classInfoList = new ArrayList<Map<String, String>>();
		String sql = "SELECT CI_NUM, CI_NAME, CI_DESC, CI_PROF, CI_STUDE FROM CLASS_INFO;";
		try (Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> ci = new HashMap<String, String>();
						ci.put("ciNum", rs.getString("CI_NUM"));
						ci.put("ciName", rs.getString("CI_NAME"));
						ci.put("ciDesc", rs.getString("CI_DESC"));
						ci.put("ciProf", rs.getString("CI_PROF"));
						ci.put("ciStude", rs.getString("CI_STUDE"));
						classInfoList.add(ci);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classInfoList;
	}

	@Override
	public Map<String, String> selectClassInfo(String ciNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertClassInfo(Map<String, String> classInfo) {
		String sql = "INSERT INTO CLASS_INFO(\n"
				+ "	CI_NAME, CI_DESC, CI_PROF, CI_STUDE\n"
				+ ") VALUES(\n"
				+ "	?, ?, ?, ?\n"
				+ ");";
		try (Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> ci = new HashMap<String, String>();
						ci.put("ciNum", rs.getString("CI_NUM"));
						ci.put("ciName", rs.getString("CI_NAME"));
						ci.put("ciDesc", rs.getString("CI_DESC"));
						ci.put("ciProf", rs.getString("CI_PROF"));
						ci.put("ciStude", rs.getString("CI_STUDE"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateClassInfo(Map<String, String> classInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteClassInfo(String ciNum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
