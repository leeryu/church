package com.church.hmpg.bbs.mappers;

import com.church.hmpg.bbs.vo.BbsDataVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by LeeRyu on 2015-07-26.
 * com.church.mngr.bbs.mappers
 */
@Component(value = "bbsDataMapper")
public interface BbsDataMapper {
    List<BbsDataVo> selectList(BbsDataVo bbsDataVo) throws Exception;
    int selectTotalCount(BbsDataVo bbsDataVo) throws Exception;
    BbsDataVo select(BbsDataVo bbsDataVo) throws Exception;
    BbsDataVo selectPrevView(BbsDataVo bbsDataVo) throws Exception;
    BbsDataVo selectNextView(BbsDataVo bbsDataVo) throws Exception;
    void delete(BbsDataVo bbsDataVo) throws Exception;
    void insert(BbsDataVo bbsDataVo) throws Exception;
    void update(BbsDataVo bbsDataVo) throws Exception;
    void updateViewCount(BbsDataVo bbsDataVo) throws Exception;
}
