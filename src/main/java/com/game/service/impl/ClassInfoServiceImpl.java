package com.game.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.mapper.ClassInfoMapper;
import com.game.vo.ClassInfoVO;

public class ClassInfoServiceImpl implements com.game.service.ClassInfoService {
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();

	@Override
	public List<ClassInfoVO> selectClassInfoList(ClassInfoVO ci) {
		try(SqlSession session = ssf.openSession()){
			ClassInfoMapper ciMapper = session.getMapper(ClassInfoMapper.class);
			return ciMapper.selectClassInfoList(ci);
		}
	}

}
