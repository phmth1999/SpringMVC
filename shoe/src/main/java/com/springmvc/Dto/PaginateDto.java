package com.springmvc.Dto;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
public class PaginateDto {
	private int currentPage;
	private int limit;
	private int start;
	private int end;
	private int totalPage;
	
	/**
	 * PaginateDto
	 **/
	public PaginateDto() {
	}

	/**
	 * getCurrentPage
	 * @return int currentPage
	 **/
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * setCurrentPage
	 * @param int currentPage
	 **/
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * getLimit
	 * @return int limit
	 **/
	public int getLimit() {
		return limit;
	}

	/**
	 * setLimit
	 * @param int limit
	 **/
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * getStart
	 * @return int start
	 **/
	public int getStart() {
		return start;
	}

	/**
	 * setStart
	 * @param int start
	 **/
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * getEnd
	 * @return int end
	 **/
	public int getEnd() {
		return end;
	}

	/**
	 * setEnd
	 * @param int end
	 **/
	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * getTotalPage
	 * @return int totalPage
	 **/
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * setTotalPage
	 * @param int totalPage
	 **/
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
