package com.game.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.dao.UserInfoDAO;
import com.game.dao.impl.UserInfoDAOImpl;
import com.game.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uiDAO = new UserInfoDAOImpl();

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		return uiDAO.selectUserInfoList(userInfo);
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNUm) {
		return uiDAO.selectUserInfo(uiNUm);
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		return uiDAO.insertUserInfo(userInfo);
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		return uiDAO.updateUserInfo(userInfo);
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		return uiDAO.deleteUserInfo(uiNum);
	}

	@Override
	public boolean login(Map<String, String> userinfo, HttpSession session) {
		String uiId = userinfo.get("uiId");
		Map<String, String> tmp = uiDAO.selectUserInfoById(uiId);
		if(tmp != null) {
			String uiPwd = tmp.get("uiPwd");
			if(uiPwd.equals(userinfo.get("uiPwd"))){
				session.setAttribute("user", tmp);
				return true;
			}
		}
		return false;
	}

}
