package com.mw.closet.dao;

import java.util.List;

import com.mw.closet.domain.Closet;
import com.mw.closet.domain.Codi;

public interface ClosetDao {

	// 전체 리스트 출력
	List<Closet> selectAll();
	
    // 코디 메인화면 출력
	List<Codi> getCodiSet();
	
	

}
