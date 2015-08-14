<%--
  Created by IntelliJ IDEA.
  User: ronkzoo
  Date: 2015. 8. 8.
  Time: 오후 6:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/pages/include/include_commonTags.jsp" %>
<ctags:breadcrumb/>
<form:form id="form1" method="get" commandName="bbsDataVo">

    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                ${resultMap.dataTitle}
            </div>
            <div class="panel-body">
                ${resultMap.dataNotice}
            </div>
            <div class="panel">
                <div class="panel-body">
                    <!-- comment list -->
                    <ul class="list-group">
                        <li class="list-group-item">Cras justo odio</li>
                        <li class="list-group-item">Dapibus ac facilisis in</li>
                    </ul>
                </div>
            </div>
        </div>

        <!--btn-->
        <div class="btn-group" role="group" aria-label="...">
            <button type="button" id="btn-list" class="btn btn-default">
                <spring:message code="btn.list"/>
            </button>
            <button type="button" id="btn-update" class="btn btn-default">
                <spring:message code="btn.update"/>
            </button>
        </div>

        <!-- 이전 글, 다음 글 목록 -->
        <ul class="list-group">
            <c:if test="${not empty resultPrevMap}">
                <li class="list-group-item">
                    이전글 <a href="#" onclick="whenSelectView('${resultPrevMap.dataSid}');return false;">${resultPrevMap.dataTitle}</a>
                </li>
            </c:if>
            <c:if test="${not empty resultNextMap}">
                <li class="list-group-item">
                    다음글 <a href="#" onclick="whenSelectView('${resultNextMap.dataSid}');return false;">${resultNextMap.dataTitle}</a>
                </li>
            </c:if>
        </ul>
    </div>
    <!-- 검색 파라미터 -->
    <form:hidden path="pageIndex" id="pageIndex"/>
</form:form>

<script type="text/javascript">
    $(document).ready(function(){
        $("#btn-list").on("click", function(){
            whenListPage();
        });

        $("#btn-update").on("click", function(){
            whenUpdatePage();
        });
    });

    function whenListPage(){
        $(form1).prop("action","/hmpg/boards/"+${bbsDataVo.boardSid}).submit();
    }

    function whenSelectView(dataSid){
        $(form1).prop("action","/hmpg/boards/${bbsDataVo.boardSid}/"+dataSid).submit();
    }

    function whenUpdatePage(){
        $(form1).prop("action","/hmpg/boards/${bbsDataVo.boardSid}/${bbsDataVo.dataSid}/edit").submit();
    }

</script>
