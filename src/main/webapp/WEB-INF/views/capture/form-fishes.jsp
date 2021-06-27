<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp" %>


<section class="page-section" id="form">
    <div class="container">


        <div class="row text-center">
            <span class="fa-stack fa-4x">
                <i class="fas fa-circle fa-stack-2x text-primary"></i>
                <i class="fas fa-laptop fa-stack-1x fa-inverse"></i>
            </span>

            <div class="text-center">
                <h2 class="section-heading text-uppercase">Dodaj ryby</h2>
            </div>

            <form method="post">

                <c:forEach items="${fishes}" var="fish" varStatus="status">
                    <div class="species-list">
                            ${fish.name}<br>
                        <img src="${fish.photosImagePathForHTML}" height="200px" width="200px" alt="${fish.name}">
                    </div>
                </c:forEach>

                <c:forEach begin="0" end="${missingFishesAmount - 1}" varStatus="loop">
                    <div class="species-list">
                        Index: ${loop.index}<br/>
                    </div>
                </c:forEach>



                <button class="btn btn-outline-secondary btn-sm text-uppercase " type="submit" value="Sumbit">
                    Zapisz ryby
                </button>

            </form>

        </div>

    </div>
</section>
<!-- About-->


<%@include file="../footer.jsp" %>