package com.game.dao;

import java.util.List;
import java.util.Map;

public interface UserInfoDAO {
	List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo);

	Map<String, String> selectUserInfo(String uiNUm);

	int insertUserInfo(Map<String, String> userInfo);

	int updateUserInfo(Map<String, String> userInfo);

	int deleteUserInfo(String uiNum);
}