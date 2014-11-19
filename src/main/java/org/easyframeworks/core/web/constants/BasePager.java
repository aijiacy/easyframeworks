package org.easyframeworks.core.web.constants;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BasePager<T> {
	private int number;
	private int size;
	private int totalPages;
	private int numberOfElements;
	private long totalElements;
	private boolean hasPreviousPage;
	private boolean firstPage;
	private boolean hasNextPage;
	private boolean lastPage;
	private boolean hasContent;
	
	/*附加页面表格字段*/
	private int start;
	private int offset;
	private int limit;
	private int total;
	private List<T> rows;
	
	public BasePager() {
		this.start = 0;
		this.limit = 10;
	}

	public BasePager(Page<T> page, Pageable pageReq) {
		if (page != null) {
			this.number = page.getNumber();
			this.size = page.getSize();
			this.totalPages = page.getTotalPages();
			this.numberOfElements = page.getNumberOfElements();
			this.totalElements = page.getTotalElements();
			this.hasPreviousPage = page.hasPreviousPage();
			this.firstPage = page.isFirstPage();
			this.hasNextPage = page.hasNextPage();
			this.lastPage = page.isLastPage();
			this.hasContent = page.hasContent();
			/*附加页面表格字段*/
			this.start = pageReq.getPageNumber();
			this.offset = pageReq.getPageNumber() > 0 ? (pageReq.getPageNumber() - 1) * pageReq.getPageSize() : pageReq.getPageNumber() * pageReq.getPageSize();
			this.limit = pageReq.getPageSize();
			this.total = new Long(page.getTotalElements()).intValue();
			this.setRows(page.getContent());
		}
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages
	 *            the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return the numberOfElements
	 */
	public int getNumberOfElements() {
		return numberOfElements;
	}

	/**
	 * @param numberOfElements
	 *            the numberOfElements to set
	 */
	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	/**
	 * @return the totalElements
	 */
	public long getTotalElements() {
		return totalElements;
	}

	/**
	 * @param totalElements
	 *            the totalElements to set
	 */
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	/**
	 * @return the hasPreviousPage
	 */
	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	/**
	 * @param hasPreviousPage
	 *            the hasPreviousPage to set
	 */
	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	/**
	 * @return the isFirstPage
	 */
	public boolean isFirstPage() {
		return firstPage;
	}

	/**
	 * @param isFirstPage
	 *            the isFirstPage to set
	 */
	public void setFirstPage(boolean isFirstPage) {
		this.firstPage = isFirstPage;
	}

	/**
	 * @return the hasNextPage
	 */
	public boolean isHasNextPage() {
		return hasNextPage;
	}

	/**
	 * @param hasNextPage
	 *            the hasNextPage to set
	 */
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	/**
	 * @return the isLastPage
	 */
	public boolean isLastPage() {
		return lastPage;
	}

	/**
	 * @param isLastPage
	 *            the isLastPage to set
	 */
	public void setLastPage(boolean isLastPage) {
		this.lastPage = isLastPage;
	}

	/**
	 * @return the hasContent
	 */
	public boolean isHasContent() {
		return hasContent;
	}

	/**
	 * @param hasContent
	 *            the hasContent to set
	 */
	public void setHasContent(boolean hasContent) {
		this.hasContent = hasContent;
	}

	/**
	 * @return the rows
	 */
	public List<T> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @param offset the offset to set
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
}
