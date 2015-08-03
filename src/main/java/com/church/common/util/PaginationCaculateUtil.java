package com.church.common.util;

import com.church.common.vo.PaginationInfoVo;
import com.church.common.vo.PaginationVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class Name   : com.church.common.util
 * Description  :
 * <p/>
 * <p/>
 * Modification Information
 * -----------------------------------------------------------
 * 수정일                 수정자                 수정내용
 * -----------------------------------------------------------
 * <p/>
 * 2015. 7. 26.             ronkzoo             최초생성
 * 2015. 7. 31.             ronzkoo             수정
 */
public class PaginationCaculateUtil {

    private static Logger logger = LoggerFactory.getLogger(PaginationCaculateUtil.class);

    private PaginationCaculateUtil(){}

    public static void cacualtePagination(PaginationVo vo){
        setFirstPageIndex(vo);
        setRecordCountPerPage(vo);
    }

    /**
     *
     * @param vo
     */
    private static void setFirstPageIndex(PaginationVo vo){
        vo.setFirstIndex(((vo.getPageIndex() - 1) * vo.getPageUnit()));
    }

    private static void setRecordCountPerPage(PaginationVo vo) {
        vo.setRecordCountPerPage(vo.getPageUnit());
    }

    /**
     *
     * @param paginationVo
     * @return
     */
    public static PaginationInfoVo getPaginationVo(PaginationVo paginationVo) {

        PaginationInfoVo paginationInfoVo = new PaginationInfoVo();

        paginationInfoVo.setTotalPageCount(getTotalPageCount(paginationVo));
        paginationInfoVo.setCurrentPageIndex(paginationVo.getPageIndex());
        paginationInfoVo.setFirstPageNoOnPageList(getFirstPageNoOnPageList(paginationVo));
        paginationInfoVo.setLastPageNoOnPageList(getLastPageNoOnPageList(paginationVo));
        paginationInfoVo.setIsNextBtnView(hasNextPageList(paginationVo));
        paginationInfoVo.setIsPreviousBtnView(hasPreviousPageList(paginationVo));
        paginationInfoVo.setFirstPageNoOnNextPageList(getFirstPageNoOnNextPageList(paginationVo));
        paginationInfoVo.setFirstPageNoOnPreviousPageList(getFirstPageNoOnPreviousPageList(paginationVo));

        return paginationInfoVo;
    }

    /**
     *
     * @param vo
     * @return
     */
    private static int getTotalPageCount(PaginationVo vo) {
        return (vo.getTotalRecordCount() / vo.getPageUnit()) + (int)((vo.getTotalRecordCount() % vo.getPageUnit()) * 1);
    }

    /**
     *
     * @param paginationVo
     * @return
     */
    private static int getFirstPageNoOnPageList(PaginationVo paginationVo) {
        return ((paginationVo.getPageIndex() - 1) / paginationVo.getPageSize()) * paginationVo.getPageSize() + 1;
    }

    /**
     *
     * @param paginationVo
     * @return
     */
    private static int getLastPageNoOnPageList(PaginationVo paginationVo) {
        if((paginationVo.getPageIndex() * paginationVo.getPageSize()) > getTotalPageCount(paginationVo)){
            return (getTotalPageCount(paginationVo) * paginationVo.getPageSize()) + (paginationVo.getTotalRecordCount() % getTotalPageCount(paginationVo));
        }
        return (paginationVo.getPageIndex() * paginationVo.getPageSize());
    }

    /**
     *
     * @param paginationVo
     * @return
     */
    private static boolean hasNextPageList(PaginationVo paginationVo){
        if(getTotalPageCount(paginationVo) > (paginationVo.getPageIndex() / paginationVo.getPageUnit())){
           return true;
        }
        return false;
    }

    /**
     *
     * @param paginationVo
     * @return
     */
    private static boolean hasPreviousPageList(PaginationVo paginationVo){
        if(1 < (paginationVo.getPageIndex() / paginationVo.getPageUnit())){
            return true;
        }
        return false;
    }

    /**
     *
     * @param paginationVo
     * @return
     */
    private static int getFirstPageNoOnNextPageList(PaginationVo paginationVo) {
        if(hasNextPageList(paginationVo)){
            return  (paginationVo.getPageIndex() / paginationVo.getPageSize()) * paginationVo.getPageSize() + 1;
        }
        return 0;
    }

    /**
     *
     * @param paginationVo
     * @return
     */
    private static int getFirstPageNoOnPreviousPageList(PaginationVo paginationVo) {
        if(hasPreviousPageList(paginationVo)){
            return  ((paginationVo.getPageIndex() - 2) / paginationVo.getPageSize()) * paginationVo.getPageSize() + 1;
        }
        return 0;
    }


}
