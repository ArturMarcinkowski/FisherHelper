<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>


<section class="page-section" id="login-form">
    <div class="container">
        <form method="post">
            <div class="row text-center">
            <span class="fa-stack fa-4x">
                <i class="fas fa-circle fa-stack-2x text-primary"></i>
                <i class="fas fa-laptop fa-stack-1x fa-inverse"></i>
            </span>

                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Zaloguj się</h2>
                </div>

                <div></div>

                <div>
                    <input type="text" name="username" placeholder="Nazwa Użytkownika"/>
                </div>
                <div>
                    <input type="password" name="password" placeholder="Hasło"/>

                </div>
                <div class="form-group form-group--buttons">
                    <a href="/register#register-form" class="btn btn-outline-secondary btn-sm text-uppercase ">Załóż
                        konto</a>
                    <button class="btn btn-outline-secondary btn-sm text-uppercase " type="submit" value="Sign In">
                        Zaloguj się
                    </button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </div>
                <div>
                    <a href="password-reminder#password-form" class="btn btn-group-sm reset-password">Zapomniałem
                        hasła</a>
                </div>
            </div>
        </form>
    </div>
</section>
<!-- About-->


<%@include file="footer.jsp" %>