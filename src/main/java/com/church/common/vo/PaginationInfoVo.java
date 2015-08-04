package com.church.common.vo;

/**
 * Class Name   : com.church.common.vo
 * Description  :
 * <p/>
 * <p/>
 * Modification Information
 * -----------------------------------------------------------
 * 수정일                 수정자                 수정내용
 * -----------------------------------------------------------
 * <p/>
 * 2015. 7. 29.             ronkzoo             최초생성
 */
public class PaginationInfoVo {

    /** 전체 게시물 page 갯수 **/
    int totalPageCount;
    /** 현재 pageIndex **/
    int currentPageIndex;
    /** 현재 해당 page 첫번째 page No **/
    int firstPageNoOnPageList;
    /** 현재 해당 page 마지막 page No **/
    int lastPageNoOnPageList;
    /** 다음 페이지 리스트에서의 첫번째 page No **/
    int firstPageNoOnNextPageList;
    /** 이전 페이지 리스트에서의 첫번째 page No **/
    int firstPageNoOnPreviousPageList;
    /** 다음 페이지 버튼 활성화 유무 **/
    boolean isNextBtnView;
    /** 이전 페이지 버튼 활성화 유무 **/
    boolean isPreviousBtnView;
    /** 전체 게시물 행 수 **/
    int totalRowCount;
    /** 페이지 게시물 갯수 **/
    int recordCountPerPage;

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getLastPageNoOnPageList() {
        return lastPageNoOnPageList;
    }

    public void setLastPageNoOnPageList(int lastPageNoOnPageList) {
        this.lastPageNoOnPageList = lastPageNoOnPageList;
    }

    public int getFirstPageNoOnPageList() {
        return firstPageNoOnPageList;
    }

    public void setFirstPageNoOnPageList(int firstPageNoOnPageList) {
        this.firstPageNoOnPageList = firstPageNoOnPageList;
    }

    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(int currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public void setIsNextBtnView(boolean isNextBtnView) {
        this.isNextBtnView = isNextBtnView;
    }

    public void setIsPreviousBtnView(boolean isPreviousBtnView) {
        this.isPreviousBtnView = isPreviousBtnView;
    }

    public boolean getIsNextBtnView() {
        return isNextBtnView;
    }

    public boolean getIsPreviousBtnView() {
        return isPreviousBtnView;
    }

    public int getFirstPageNoOnNextPageList() {
        return firstPageNoOnNextPageList;
    }

    public void setFirstPageNoOnNextPageList(int firstPageNoOnNextPageList) {
        this.firstPageNoOnNextPageList = firstPageNoOnNextPageList;
    }

    /**
     *
     * @return
     */
    public int getFirstPageNoOnPreviousPageList() {
        return firstPageNoOnPreviousPageList;
    }

    public void setFirstPageNoOnPreviousPageList(int firstPageNoOnPreviousPageList) {
        this.firstPageNoOnPreviousPageList = firstPageNoOnPreviousPageList;
    }

    public int getTotalRowCount() {
        return totalRowCount;
    }

    public void setTotalRowCount(int totalRowCount) {
        this.totalRowCount = totalRowCount;
    }

    public int getRecordCountPerPage() {
        return recordCountPerPage;
    }

    public void setRecordCountPerPage(int recordCountPerPage) {
        this.recordCountPerPage = recordCountPerPage;
    }

    @Override public String toString() {
        return "PaginationInfoVo{" +
            "totalPageCount=" + totalPageCount +
            ", currentPageIndex=" + currentPageIndex +
            ", firstPageNoOnPageList=" + firstPageNoOnPageList +
            ", lastPageNoOnPageList=" + lastPageNoOnPageList +
            ", firstPageNoOnNextPageList=" + firstPageNoOnNextPageList +
            ", firstPageNoOnPreviousPageList=" + firstPageNoOnPreviousPageList +
            ", isNextBtnView=" + isNextBtnView +
            ", isPreviousBtnView=" + isPreviousBtnView +
            ", totalRowCount=" + totalRowCount +
            ", recordCountPerPage=" + recordCountPerPage +
            '}';
    }
}
