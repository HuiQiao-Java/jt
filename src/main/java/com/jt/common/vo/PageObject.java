package com.jt.common.vo;

import java.io.Serializable;
import java.util.List;

public class PageObject<T> implements Serializable {

	private static final long serialVersionUID = 6780580291247550747L;
	/**当前页面页码值*/
	private Integer pageCurrent=1;
	/**
	 * 当前页面大小
	 */
	private Integer pageSize=3;
	/**
	 * 查询记录的总行数（查询得到）
	 */
	private Integer rowCount=0;
	/**
	 * 查询记录的总页数（计算得到）
	 */
	private Integer pageCount=0;
	/**
	 * 当前页的记录
	 */
	private List<T> records;
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	
	
	public Integer getPageCount() {
		pageCount = rowCount/pageSize;
		if(rowCount%pageSize!=0) {
			pageCount++;
		}
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
}
