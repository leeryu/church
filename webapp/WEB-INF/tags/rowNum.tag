<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="pageVo"   required="true" type="com.church.common.vo.PaginationInfoVo" %>
<%@ attribute name="index"   required="true" type="java.lang.Integer" %>
<%System.out.println(index);%>
<%@ include file="/WEB-INF/jsp/pages/include/include_commonTags.jsp"  %>
<c:out value='${pageVo.totalRowCount - (((pageVo.currentPageIndex - 1) * pageVo.recordCountPerPage) + index)}'/>
