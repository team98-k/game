package com.game.mapper;

import java.util.List;

import com.game.vo.ClassInfoVO;

public interface ClassInfoMapper {
	List<ClassInfoVO> selectClassInfoList(ClassInfoVO ci);
}
