package com.mw.closet.domain;

import java.util.List;

public class ClosetPage {

	private int nowPage; // 현재 페이지
	private int totalListCnt; // 전체 게시물 개수
	private int onePageCnt; // 한페이지 게시물 개수
	private List<ClosetListRequest> closetList; // 페이지에 노출할 게시물의 리스트
	private int startRow; // 게시물 시작 범위
	private int endRow; // 게시물 종료 범위(mysql에서는 안쓰지만 연습용)
	private int totalPageCnt; // 전체 페이지 개수
	
	// 페이징할 조건이 담긴 생성자
	public ClosetPage(int nowPage, int totalListCnt, int onePageCnt,List<ClosetListRequest> closetList,
			int startRow, int endRow, int totalPageCnt) {
		this.nowPage = nowPage;
		this.totalListCnt = totalListCnt;
		this.onePageCnt = onePageCnt;
		this.closetList = closetList;
		this.startRow = startRow;
		this.endRow = endRow;
		this.totalPageCnt = totalPageCnt;
	}
	// 총 페이지계수 계산하는 부분
	private void calTotalPageCnt() {
		// 전체 페이지 개수 = 총 게시물 개수 / 한 페이지 게시물 개수
		totalPageCnt = (totalListCnt/onePageCnt);
		// 위 나머지 연산이 0보다 크면 ++
		if(totalListCnt%onePageCnt>0) {
			totalPageCnt++;
		}
	}
	
	// 셋할 값은 없기 때문에 getter만 만든다.
	public int getNowPage() {
		return nowPage;
	}
	public int getTotalListCnt() {
		return totalListCnt;
	}
	public int getOnePageCnt() {
		return onePageCnt;
	}
	public List<ClosetListRequest> getClosetList() {
		return closetList;
	}
	public int getStartRow() {
		return startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public int getTotalPageCnt() {
		return totalPageCnt;
	}
	
	@Override
	public String toString() {
		return "ClosetPage [nowPage=" + nowPage + ", totalListCnt=" + totalListCnt + ", onePageCnt=" + onePageCnt
				+ ", closetList=" + closetList + ", startRow=" + startRow + ", endRow=" + endRow + ", totalPageCnt="
				+ totalPageCnt + "]";
	}
		
}
