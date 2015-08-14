package com.church.hmpg.bbs.vo;

import com.church.common.vo.ComDefaultVO;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.Date;

/**
 * Class Name   : com.church.hmpg.bbs.vo
 * Description  :
 * <p/>
 * <p/>
 * Modification Information
 * -----------------------------------------------------------
 * 수정일                 수정자                 수정내용
 * -----------------------------------------------------------
 * <p/>
 * 2015. 8. 2.             ronkzoo             최초생성
 */
public class BbsDataVo extends ComDefaultVO { private static final long serialVersionUID = 1L;

    @NotEmpty(groups = {BbsData.class})
    private Integer dataSid;
    // 게시판 일련번호
    @NotEmpty(groups = {Default.class})
    private Integer boardSid;
    private String boardId;
    private String userId;
    private String userPw;
    private String userNick;
    private String userEmail;
    private String dataTitle;
    private String dataNotice;
    private String dataSecret;
    private String delStatus;
    private String viewCount;
    private Date   modifyDate;
    private Date   registerDate;
    // 카테고리1차
    private String categoryCode1;
    // 카테고리2차
    private String categoryCode2;
    // 카테고리3차
    private String categoryCode3;

    /**
     *  을/를 반환합니다.
     *
     * @return the dataSid
     */
    public Integer getDataSid() {
        return dataSid;
    }
    /**
     *  을/를 설정합니다.
     *
     * @param dataSid the dataSid to set
     */
    public void setDataSid(Integer dataSid) {
        this.dataSid = dataSid;
    }
    /**
     * 게시판 일련번호 을/를 반환합니다.
     *
     * @return the boardSid
     */
    public Integer getBoardSid() {
        return boardSid;
    }
    /**
     * 게시판 일련번호 을/를 설정합니다.
     *
     * @param boardSid the boardSid to set
     */
    public void setBoardSid(Integer boardSid) {
        this.boardSid = boardSid;
    }
    /**
     *  을/를 반환합니다.
     *
     * @return the boardId
     */
    public String getBoardId() {
        return boardId;
    }
    /**
     *  을/를 설정합니다.
     *
     * @param boardId the boardId to set
     */
    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }
    /**
     *  을/를 반환합니다.
     *
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }
    /**
     *  을/를 설정합니다.
     *
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**
     *  을/를 반환합니다.
     *
     * @return the userPw
     */
    public String getUserPw() {
        return userPw;
    }
    /**
     *  을/를 설정합니다.
     *
     * @param userPw the userPw to set
     */
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
    /**
     *  을/를 반환합니다.
     *
     * @return the userNick
     */
    public String getUserNick() {
        return userNick;
    }
    /**
     *  을/를 설정합니다.
     *
     * @param userNick the userNick to set
     */
    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
    /**
     *  을/를 반환합니다.
     *
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }
    /**
     *  을/를 설정합니다.
     *
     * @param userEmail the userEmail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    /**
     *  을/를 반환합니다.
     *
     * @return the dataTitle
     */
    public String getDataTitle() {
        return dataTitle;
    }
    /**
     *  을/를 설정합니다.
     *
     * @param dataTitle the dataTitle to set
     */
    public void setDataTitle(String dataTitle) {
        this.dataTitle = dataTitle;
    }
    /**
     *  을/를 반환합니다.
     *
     * @return the dataNotice
     */
    public String getDataNotice() {
        return dataNotice;
    }
    /**
     *  을/를 설정합니다.
     *
     * @param dataNotice the dataNotice to set
     */
    public void setDataNotice(String dataNotice) {
        this.dataNotice = dataNotice;
    }
    /**
     *  을/를 반환합니다.
     *
     * @return the dataSecret
     */
    public String getDataSecret() {
        return dataSecret;
    }
    /**
     *  을/를 설정합니다.
     *
     * @param dataSecret the dataSecret to set
     */
    public void setDataSecret(String dataSecret) {
        this.dataSecret = dataSecret;
    }
    /**
     *  을/를 반환합니다.
     *
     * @return the delStatus
     */
    public String getDelStatus() {
        return delStatus;
    }
    /**
     *  을/를 설정합니다.
     *
     * @param delStatus the delStatus to set
     */
    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }
    /**
     *  을/를 반환합니다.
     *
     * @return the viewCount
     */
    public String getViewCount() {
        return viewCount;
    }
    /**
     *  을/를 설정합니다.
     *
     * @param viewCount the viewCount to set
     */
    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }
    /**
     *  을/를 반환합니다.
     *
     * @return the modifyDate
     */
    public Date getModifyDate() {
        return modifyDate;
    }
    /**
     *  을/를 설정합니다.
     *
     * @param modifyDate the modifyDate to set
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    /**
     *  을/를 반환합니다.
     *
     * @return the registerDate
     */
    public Date getRegisterDate() {
        return registerDate;
    }
    /**
     *  을/를 설정합니다.
     *
     * @param registerDate the registerDate to set
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    /**
     * 카테고리1차 을/를 반환합니다.
     *
     * @return the categoryCode1
     */
    public String getCategoryCode1() {
        return categoryCode1;
    }
    /**
     * 카테고리1차 을/를 설정합니다.
     *
     * @param categoryCode1 the categoryCode1 to set
     */
    public void setCategoryCode1(String categoryCode1) {
        this.categoryCode1 = categoryCode1;
    }
    /**
     * 카테고리2차 을/를 반환합니다.
     *
     * @return the categoryCode2
     */
    public String getCategoryCode2() {
        return categoryCode2;
    }
    /**
     * 카테고리2차 을/를 설정합니다.
     *
     * @param categoryCode2 the categoryCode2 to set
     */
    public void setCategoryCode2(String categoryCode2) {
        this.categoryCode2 = categoryCode2;
    }
    /**
     * 카테고리3차 을/를 반환합니다.
     *
     * @return the categoryCode3
     */
    public String getCategoryCode3() {
        return categoryCode3;
    }
    /**
     * 카테고리3차 을/를 설정합니다.
     *
     * @param categoryCode3 the categoryCode3 to set
     */
    public void setCategoryCode3(String categoryCode3) {
        this.categoryCode3 = categoryCode3;
    }

    @Override public String toString() {
        return "BbsDataVo{" +
            "dataSid=" + dataSid +
            ", boardSid=" + boardSid +
            ", boardId='" + boardId + '\'' +
            ", userId='" + userId + '\'' +
            ", userPw='" + userPw + '\'' +
            ", userNick='" + userNick + '\'' +
            ", userEmail='" + userEmail + '\'' +
            ", dataTitle='" + dataTitle + '\'' +
            ", dataNotice='" + dataNotice + '\'' +
            ", dataSecret='" + dataSecret + '\'' +
            ", delStatus='" + delStatus + '\'' +
            ", viewCount='" + viewCount + '\'' +
            ", modifyDate=" + modifyDate +
            ", registerDate=" + registerDate +
            ", categoryCode1='" + categoryCode1 + '\'' +
            ", categoryCode2='" + categoryCode2 + '\'' +
            ", categoryCode3='" + categoryCode3 + '\'' +
            '}';
    }
}
