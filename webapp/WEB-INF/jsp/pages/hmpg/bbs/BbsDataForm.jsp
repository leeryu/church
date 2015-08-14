<%--
  Created by IntelliJ IDEA.
  User: ronkzoo
  Date: 2015. 8. 8.
  Time: 오후 6:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/pages/include/include_commonTags.jsp" %>
<c:choose>
    <c:when test="${cmd eq 'Insert'}">
        <c:set var="saveUrl" value="/hmpg/boards/${bbsDataVo.boardSid}"/>
    </c:when>
    <c:otherwise>
        <c:set var="saveUrl" value="/hmpg/boards/${bbsDataVo.boardSid}/${bbsDataVo.dataSid}"/>
    </c:otherwise>
</c:choose>

<ctags:breadcrumb/>
<form:form id="form1" method="get" commandName="resultMap">
    <input type="hidden" name="_method" value="PUT">
    <div class="row">
        <div class="form-group">
            <label for="dataTitle">제목</label>
            <form:input type="text" class="form-control" placeholder="제목" path="dataTitle"/>
        </div>
        <div class="form-group">
            <label for="dataNotice">내용</label>
            <form:textarea class="form-control" rows="3" path="dataNotice" title="내용"/>
        </div>
        <div class="checkbox">
            <label>
                <form:checkbox path="dataSecret" title="비밀글 표시" value="Y"/>비밀글 표시 여부
            </label>
        </div>
        <div class="btn-group">
            <button type="submit" class="btn btn-default" id="btn-list"><spring:message code="btn.list"/></button>
            <button type="submit" class="btn btn-default" id="btn-submit"><spring:message code="btn.save"/></button>
        </div>

    </div>
    <!-- 검색 파라미터 -->
    <input type="hidden" name="pageIndex" value="${bbsDataVo.pageIndex}"/>
</form:form>

<script type="text/javascript">
    $(document).ready(function () {
        $("#btn-list").on("click", function () {
            whenListPage();
            return false;
        });

        $("#btn-submit").on("click", function () {
            whenSave();
            return false;
        });
    });

    function whenListPage() {
        $(form1).prop("method","GET")
                .prop("action", "/hmpg/boards/" +${bbsDataVo.boardSid})
                .submit();
    }

    function whenSave() {
        if(!whenSaveValidation()) return;
        $(form1).prop("method",'${method}')
                .prop("action", "${saveUrl}")
                .submit();
    }
    function whenDelete(){
        $(form1).prop("method",'DELETE')
                .prop("action", "/hmpg/boards/${bbsDataVo.boardSid}/${bbsDataVo.dataSid}/edit")
                .submit();
    }
    function whenSaveValidation(){
        if($("#dataTitle").val() == '' || $("#dataNotice").val() == '') {
            alert("<spring:message code='msg.alert.not_empty'/>");
            return false;
        }
        return true;
    }
</script>
