package com.game.dao;

import java.util.List;
import java.util.Map;

public interface ClassInfoDAO {

	List<Map<String, String>> selectClassInfoList(Map<String, String> classInfo);

	Map<String, String> selectClassInfo(String ciNum);

	int insertClassInfo(Map<String, String> classInfo);

	int updateClassInfo(Map<String, String> classInfo);

	int deleteClassInfo(String ciNum);
}
