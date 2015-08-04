<%--
  Created by IntelliJ IDEA.
  User: ronkzoo
  Date: 2015. 8. 2.
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/pages/include/include_commonTags.jsp"%>

<ol class="breadcrumb">
    <li><a href="#">Home</a></li>
    <li><a href="#">Library</a></li>
    <li class="active">Data</li>
</ol>
<div class="row">
    <div class="col-xs-12 container-fluid">

            <div class="table-responsive">
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
                            <td><ctags:rowNum pageVo="${paginationVo}" index="${status.index}"/></td>
                            <td><a href="/hmpg/board/view/${item.dataSid}" >${item.dataTitle}</a></td>
                            <td>0</td>
                            <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${item.registerDate}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <ctags:pagination pageVo="${paginationVo}" href="/hmpg/board/list"/>
            </div>
    </div>
</div>
<script type="text/javascript" defer="defer" >
    $(function(){
        $("#btn-regist").on("click", function(){
            alert("hello");
        });

    });
</script>
