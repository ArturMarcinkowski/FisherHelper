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
                <h2 class="section-heading text-uppercase">Dodaj połów</h2>
            </div>
            <form:form method="post" modelAttribute="capture">

                <div>
                    <form:hidden path="id"/>
                    <form:input path="name" placeholder="Nazwij połów"/>
                </div>
                <div>
                    <form:errors path="name"/>
                </div>

                <div>
                    <label>liczba godzin:</label><br>
                    <form:input type="number"  path="hours" placeholder="liczba godzin"/>
                </div>
                <div>
                    <form:errors path="hours"/>
                </div>

                <div>
                    <label>liczba zebranych ryb:</label><br>
                    <form:input type="number"  path="hours" placeholder="liczba godzin"/>
                </div>
                <div>
                    <form:errors path="hours"/>
                </div>

                <div>
                    <label>dzień:</label><br>
                    <form:input type="date"  path="date" placeholder="dzień"/>
                </div>
                <div>
                    <form:errors path="date"/>
                </div>

                <div class="form-group form-group--buttons">
                    <button class="btn btn-outline-secondary btn-sm text-uppercase " type="submit" value="Sumbit">
                        Dodaj połów
                    </button>
                </div>
            </form:form>


        </div>

    </div>
</section>
<!-- About-->


<%@include file="../footer.jsp" %>