<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp" %>


<section class="page-section" id="login-form">
    <div class="container">


        <div class="row text-center">
            <span class="fa-stack fa-4x">
                <i class="fas fa-circle fa-stack-2x text-primary"></i>
                <i class="fas fa-laptop fa-stack-1x fa-inverse"></i>
            </span>

            <div class="text-center">
                <h2 class="section-heading text-uppercase">Dodaj gatunek</h2>
            </div>
            <form th:action="@{/species/add}" th:object="${species}" method="post" enctype="multipart/form-data">
                <div>
                    <input type="text" name="name" placeholder="Nazwa" value="${species.name}"/>
                </div>
                <div>
                    <label>Photos: </label>
                    <input type="file" name="image" accept="image/png, image/jpeg" />
                </div>
                <div class="form-group form-group--buttons">
                    <button class="btn btn-outline-secondary btn-sm text-uppercase " type="submit" value="Sumbit">
                        Dodaj gatunek
                    </button>
                </div>
            </form>


        </div>

    </div>
</section>
<!-- About-->


<%@include file="../footer.jsp" %>