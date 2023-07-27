package com.game.service.impl;

import java.util.List;
import java.util.Map;

import com.game.dao.BoardInfoDAO;
import com.game.dao.impl.BoardInfoDAOImpl;
import com.game.service.BoardInfoService;

public class BoardInfoServiceImpl implements BoardInfoService {
	private BoardInfoDAO boardInfoDAO = new BoardInfoDAOImpl();

	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> board) {
		return boardInfoDAO.selectBoardInfoList(board);
	}

	@Override
	public Map<String, String> selectBoardInfo(String biNum) {
		return boardInfoDAO.selectBoardInfo(biNum);
	}

	@Override
	public int insertBoardInfo(Map<String, String> board) {
		return boardInfoDAO.insertBoardInfo(board);
	}

	@Override
	public int updateBoardInfo(Map<String, String> board) {
		return boardInfoDAO.updateBoardInfo(board);
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		return boardInfoDAO.deleteBoardInfo(biNum);
	}

	public static void main(String[] args) {
		BoardInfoService bi = new BoardInfoServiceImpl();
		System.out.println(bi.selectBoardInfoList(null));
	}
}
