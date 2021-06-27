<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp" %>


<section class="page-section" id="form">
    <div class="container">

<%--        <table id="list-table">--%>
<%--            <c:forEach items="${speciesList}" var="species" varStatus="status">--%>
<%--                <tr>--%>
<%--                    <td>${species.name}</td>--%>
<%--                    <td><img src="${species.photosImagePathForHTML}" height="200px" width="200px" alt="${species.name}">--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        <table/>--%>



        <div>
            <c:forEach items="${speciesList}" var="species" varStatus="status">
            <div class="species-list">
                ${species.name}<br>
                <img src="${species.photosImagePathForHTML}" height="200px" width="200px" alt="${species.name}">
            </div>
            </c:forEach>

        </div>

    </div>
</section>
<!-- About-->


<%@include file="../footer.jsp" %>


