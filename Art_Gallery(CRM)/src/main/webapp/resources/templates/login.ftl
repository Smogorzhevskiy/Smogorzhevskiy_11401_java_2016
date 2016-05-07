<#--<%@ page contentType="text/html;charset=UTF-8" language="java" %>-->
<#include "main-template.ftl"/>
<!DOCTYPE html>
<#--<#macro m_body>-->
<body>

<section id="main-slider" class="carousel">
    <div class="col-md-5 col-lg-offset-5 text-center">
        <form action="/login/process" method="post" class="form-horizontal text-center">
            <div class="form-group text-center">
                <div class="col-md-5">
                    <input type="text" name="login" class="form-control" placeholder="log">
                </div>
            </div>
            <div class="form-group text-center">
                <div class="col-md-5">
                    <input type="password" name="password" class="form-control" placeholder="pass">
                </div>
            </div>
            <div class="form-group text-center">
                <div class="col-md-5">
                    Remember me <input type="checkbox" id="remember" name="_spring_security_remember_me" value="true">
                </div>
            </div>
            <div class="form-group text-center">
                <div class="col-md-5">
                    <button type="submit" class="btn btn-success">Войти</button>
                </div>
            </div>

            <br/>
        </form>
    </div>

</section>
</body>



