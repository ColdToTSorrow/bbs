package org.base.entity;

import java.util.List;

/**
 * 分页对象
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class Page<T> {
	private int currentPage; // 当前页码,页面传递
	private int totalPage; // 总页数,计算
	private int totalRecord; // 总记录数,查数据库
	private int pageSize; // 每页记录数,页面传递或配置
	private int begin; // 开始页,计算
	private int end; // 结束页,计算
	private List<T> content; // 本页数据,查数据库

	private Page() {
	}

	public Page(int currentPage, int totalRecord, int pageSize, List<T> content) {
		super();
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.pageSize = pageSize;
		this.content = content;
		totalPage = (totalRecord + pageSize - 1) / pageSize;
		if (currentPage < 0) {
			this.currentPage = 1;
		}
		if (currentPage > totalRecord) {
			this.currentPage = totalPage;
		}
		// 计算start,end
		// 总页少于10全部显示
		if (totalPage <= 10) {
			begin = 1;
			end = totalPage;
		} else {
			// 页数多于10页显示附近10页
			begin = currentPage - 4;
			end = currentPage + 5;
			if (begin < 1) {
				begin = 1;
				end = 10;
			}
			if (end > totalPage) {
				end = totalPage;
				begin = totalPage - 9;
			}

		}

	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

}
