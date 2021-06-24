<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>


<section class="page-section" id="login-form">
    <div class="container">


            <div class="row text-center">
            <span class="fa-stack fa-4x">
                <i class="fas fa-circle fa-stack-2x text-primary"></i>
                <i class="fas fa-laptop fa-stack-1x fa-inverse"></i>
            </span>

                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Zaloguj się</h2>
                </div>
                <form:form method="post" modelAttribute="user">
                <div>
                    <form:input path="email" placeholder="email" type="email"/>
                </div>
                    <div>
                    <form:errors path="email"/>
                    </div>
                    <div>
                    <form:hidden path="id"/>
                    <form:input path="username" placeholder="Nazwa użytkownika"/>
                    </div>
                    <div>
                    <form:errors path="username"/>
                    </div>
                    <div class="form-group">
                    <form:input path="password" placeholder="hasło" type="password"/>
                    </div>
                    <div>
                    <form:errors path="password"/>
                    </div>

                <div class="form-group form-group--buttons">
                    <button class="btn btn-outline-secondary btn-sm text-uppercase " type="submit" value="Register">
                        Zarejestruj się
                    </button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </div>
                </form:form>
            </div>

    </div>
</section>
<!-- About-->


<%@include file="footer.jsp" %>