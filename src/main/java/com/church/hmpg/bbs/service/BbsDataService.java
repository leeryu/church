package com.church.hmpg.bbs.service;

import com.church.hmpg.bbs.vo.BbsDataVo;

import java.util.List;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.mngr.bbs.service
 */
public interface BbsDataService {

    /**
     * 게시판 목록 조회
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    List<BbsDataVo> selectList(BbsDataVo bbsDataVo) throws Exception;

    /**
     * 상세 글 조회
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    BbsDataVo select(BbsDataVo bbsDataVo) throws Exception;

    /**
     * 이전 글
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    BbsDataVo selectPrevView(BbsDataVo bbsDataVo) throws Exception;

    /**
     * 다음 글
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    BbsDataVo selectNextView(BbsDataVo bbsDataVo) throws Exception;
    /**
     * 전체 목록 갯수
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    int selectTotalCount(BbsDataVo bbsDataVo) throws Exception;
    /**
     * 삭제
     * @param bbsDataVo
     * @throws Exception
     */
    void delete(BbsDataVo bbsDataVo) throws Exception;

    /**
     * 등록
     * @param bbsDataVo
     * @throws Exception
     */
    void insert(BbsDataVo bbsDataVo) throws Exception;

    /**
     * 수정
     * @param bbsDataVo
     * @throws Exception
     */
    void update(BbsDataVo bbsDataVo) throws Exception;

    /**
     * 조회 수 증가
     * @param bbsDataVo
     * @throws Exception
     */
    void updateViewCount(BbsDataVo bbsDataVo) throws Exception;

}
