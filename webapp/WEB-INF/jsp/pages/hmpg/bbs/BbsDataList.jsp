<%--
  Created by IntelliJ IDEA.
  User: ronkzoo
  Date: 2015. 8. 2.
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/pages/include/include_commonTags.jsp"%>

<ctags:breadcrumb/>

<form:form id="form1" method="get" commandName="bbsDataVo">
    <form:hidden path="pageIndex" id="pageIndex"/>

    <div class="row">
        <div class="container-fluid">
            <div class="col-xs-12">
                <div class="table-responsive">
                    <div class="pull-left">
                        <form:select id="searchPageUnit" path="searchPageUnit" cssClass="form-control" >
                            <form:option value="10" id="A" title="" label="10"/>
                            <form:option value="20" id="B" title="" label="20"/>
                        </form:select>
                    </div>
                    <div class="pull-right">
                        <button class="btn btn-default" type="submit" id="btn-regist">등록</button>
                    </div>
                    <table class="table">
                        <colgroup>
                            <col width="5%"/>
                            <col width="auto"/>
                            <col width="10%"/>
                            <col width="20%"/>
                        </colgroup>
                        <thead>
                            <tr>
                               <th>No</th>
                               <th>제목</th>
                               <th>조회수</th>
                               <th>등록일</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${selectList}" varStatus="status">
                            <tr>
                                <td><ctags:rowNum pageVo="${paginationInfoVo}" index="${status.index}"/></td>
                                <td><a href="#" onclick="whenViewPage('${item.dataSid}');return false;">${item.dataTitle}</a></td>
                                <td><span class="badge">${item.viewCount}</span></td>
                                <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${item.registerDate}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <ctags:pagination pageVo="${paginationInfoVo}" function="whenGoPage"/>
                </div>
            </div>
        </div>
    </div>

</form:form>
<script type="text/javascript" defer="defer" >
    $(function(){
        $("#btn-regist").on("click", function(){
            $(form1).prop("action","/hmpg/boards/${bbsDataVo.boardSid}/new")
                    .prop("method","GET").submit();
        });

        $("#searchPageUnit").on("change", function(){
            $(form1).submit();
        });

    });

    function whenGoPage(pageIndex){
        $("#pageIndex").val(pageIndex);
        $(form1).submit();
    }

    function whenViewPage(dataSid){
        $(form1).prop("action","/hmpg/boards/${bbsDataVo.boardSid}/"+dataSid).submit();
    }
</script>
