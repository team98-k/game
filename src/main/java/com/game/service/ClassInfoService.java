package com.game.service;

import java.util.List;

import com.game.vo.ClassInfoVO;

public interface ClassInfoService {
	List<ClassInfoVO> selectClassInfoList(ClassInfoVO ci);
}
