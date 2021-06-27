<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp" %>


<section class="page-section" id="form">
    <div class="container">

        <div>
            <c:forEach items="${fishes}" var="fish" varStatus="status">
                <div class="species-list">
                        ${fish.name}<br>
                    <img src="${fish.photosImagePathForHTML}" height="200px" width="200px" alt="${fish.name}">
                </div>
            </c:forEach>

        </div>

    </div>
</section>
<!-- About-->


<%@include file="../footer.jsp" %>


