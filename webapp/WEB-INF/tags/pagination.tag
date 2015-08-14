<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="function"  required="true" %>
<%@ attribute name="pageVo"    required="true" type="com.church.common.vo.PaginationInfoVo" %>
<%@ include file="/WEB-INF/jsp/pages/include/include_commonTags.jsp"  %>
<nav>
    <ul class="pagination">
        <li class="${pageVo.isPreviousBtnView ? '':'disabled'}">
          <a href="#" onclick="${function}('${pageVo.firstPageNoOnPreviousPageList}');return false;" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach begin="${pageVo.firstPageNoOnPageList}" end="${pageVo.lastPageNoOnPageList}" var="item" varStatus="status">
            <li class="${item eq pageVo.currentPageIndex ? 'active':''}">
                <a href="#" onclick="${function}('${status.index}');return false;">${item}</a>
            </li>
        </c:forEach>
        <c:if test="${pageVo.isNextBtnView}">
        <li class="${pageVo.isNextBtnView ? '':'disabled'}">
            <a href="#" onclick="${function}('${pageVo.firstPageNoOnNextPageList}');return false;" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
        </c:if>
    </ul>
</nav>
