package com.mw.closet.dao;

import java.util.List;

import com.mw.closet.domain.Closet;

public interface ClosetDao {

	
	
	// 전체 리스트 출력
	List<Closet> selectAll();
	

}
