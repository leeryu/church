package com.church.hmpg.bbs.service.impl;

import com.church.hmpg.bbs.mappers.BbsDataMapper;
import com.church.hmpg.bbs.service.BbsDataService;
import com.church.hmpg.bbs.vo.BbsDataVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.mngr.bbs.service.impl
 */
@Service(value = "bbsDataService")
public class BbsDataServiceImpl implements BbsDataService {

    @Resource(name = "bbsDataMapper") BbsDataMapper bbsDataMapper;

    /**
     * 목록 조회
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    public List<BbsDataVo> selectList(BbsDataVo bbsDataVo) throws Exception {
        return bbsDataMapper.selectList(bbsDataVo);
    }

    /**
     * 목록 갯수 반환
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    public int selectTotalCount(BbsDataVo bbsDataVo) throws Exception {
        return this.bbsDataMapper.selectTotalCount(bbsDataVo);
    }

    /**
     * 상세 글 조회
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    public BbsDataVo select(BbsDataVo bbsDataVo) throws Exception {
        return this.bbsDataMapper.select(bbsDataVo);
    }

    /**
     * 이전 글 조회
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    public BbsDataVo selectPrevView(BbsDataVo bbsDataVo) throws Exception {
        return bbsDataMapper.selectPrevView(bbsDataVo);
    }

    /**
     * 다음 글 조회
     * @param bbsDataVo
     * @return
     * @throws Exception
     */
    public BbsDataVo selectNextView(BbsDataVo bbsDataVo) throws Exception {
        return bbsDataMapper.selectNextView(bbsDataVo);
    }

    /**
     * 글 삭제
     * @param bbsDataVo
     * @throws Exception
     */
    public void delete(BbsDataVo bbsDataVo) throws Exception {
        this.bbsDataMapper.delete(bbsDataVo);
    }

    /**
     * 글 등록
     * @param bbsDataVo
     * @throws Exception
     */
    public void insert(BbsDataVo bbsDataVo) throws Exception {
        this.bbsDataMapper.insert(bbsDataVo);
    }

    /**
     * 글 수정
     * @param bbsDataVo
     * @throws Exception
     */
    public void update(BbsDataVo bbsDataVo) throws Exception {
        this.bbsDataMapper.update(bbsDataVo);
    }

    public void updateViewCount(BbsDataVo bbsDataVo) throws Exception {
        this.bbsDataMapper.updateViewCount(bbsDataVo);
    }
}
