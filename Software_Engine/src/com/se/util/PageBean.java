package com.se.util;
import java.util.List;
public class PageBean {
	public int curPage; // 褰撳墠椤电爜
	public int maxPage; // 鎬荤殑椤垫暟
	public int maxRowCount; // 鎬荤殑璁板綍鏁�
	public int rowsPerPage=10; // 姣忛〉璁板綍鏁�
	public List data ;    //姣忛〉闇�瑕佹樉绀虹殑鏁版嵁
	/**
	* @Description: 鏍规嵁璁板綍鏁拌绠楅〉鏁�
	* @param      
	* @return void   
	* @throws
	 */
	public void countMaxPage() { 
		if (this.maxRowCount % this.rowsPerPage == 0) {
			this.maxPage = this.maxRowCount / this.rowsPerPage;
		} else {
			this.maxPage = this.maxRowCount / this.rowsPerPage + 1;
		}
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMaxRowCount() {
		return maxRowCount;
	}
	public void setMaxRowCount(int maxRowCount) {
		this.maxRowCount = maxRowCount;
	}
	public int getRowsPerPage() {
		return rowsPerPage;
	}
	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	
}
