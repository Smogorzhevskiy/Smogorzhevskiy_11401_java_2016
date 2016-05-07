<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!-- Navigation -->
    <div class="navbar navbar-fixed-top" data-activeslide="1" >
        <div class="container">

            <!-- .navbar-toggle is used as the toggle for collapsed navbar content -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>


            <div class="nav-collapse collapse navbar-responsive-collapse">
                <ul class="nav row">

                    <@security.authorize access="isAnonymous()">
                    <li data-slide="1" class="col-12 col-sm-2"><a id="menu-link-1" href="#slide-1" title="Next Section"><span class="icon icon-home"></span> <span class="text">HOME</span></a></li>
                    <li data-slide="2" class="col-12 col-sm-2"><a id="menu-link-2" href="#slide-2" title="Next Section"><span class="icon icon-user"></span> <span class="text">ARTIST</span></a></li>
                    <li data-slide="3" class="col-12 col-sm-2"><a id="menu-link-3" href="#slide-3" title="Next Section"><span class="icon icon-briefcase"></span> <span class="text">GALLERY</span></a></li>
                    <li data-slide="4" class="col-12 col-sm-2"><a id="menu-link-4" href="#slide-4" title="Next Section"><span class="icon icon-gears"></span> <span class="text">PICTURE</span></a></li>
                    <li data-slide="5" class="col-12 col-sm-2"><a id="menu-link-5" href="#slide-5" title="Next Section"><span class="icon icon-heart"></span> <span class="text">REGISTRATION</span></a></li>
                    <li data-slide="6" class="col-12 col-sm-2"><a id="menu-link-6" href="#slide-6" title="Next Section"><span class="icon icon-envelope"></span> <span class="text">LOG IN</span></a></li>
                    </@security.authorize>

                    <#--<li><a href="/medical_clinics">Медицинские клиники</a></li>-->
                <#--<@security.authorize access="!isAnonymous()">-->
                    <#--<li><a href="/default">Профиль</a></li>-->
                <#--</@security.authorize>-->
                <#--<@security.authorize access="hasRole('ROLE_DOCTOR')">-->
                    <#--<li><a href="/doctor/appointments">Приём пациентов</a></li>-->
                <#--</@security.authorize>-->
                <#--<@security.authorize access="isAnonymous()">-->
                    <#--<li><a href="/registration">Зарегистрироваться</a></li>-->
                    <#--<li><a href="/login" id="login">Войти</a></li>-->
                <#--</@security.authorize>-->
                <#--<@security.authorize access="hasRole('ROLE_SYSTEM_ADMIN')">-->
                    <#--<li><a href="/system/medical_clinics/new">Добавить Мед клинику</a></li>-->
                    <#--<li><a href="/system/proposals">Заявки</a></li>-->
                    <#--<li><a href="/system/specializations">Специализации</a></li>-->
                <#--</@security.authorize>-->
                <#--<@security.authorize access="hasRole('ROLE_ADMIN')">-->
                    <#--<li><a href="/admin/doctors/new">Добавить врача</a></li>-->
                    <#--<#if springMacroRequestContext.getRequestUri() == "/admin">-->
                        <#--<li><a href="/medical_clinics/${id}/offices/${officeId}/doctors">Посмотреть своих врачей</a>-->
                        <#--</li>-->
                    <#--</#if>-->
                <#--</@security.authorize>-->
                <#--<@security.authorize access="hasRole('ROLE_PATIENT')">-->
                    <#--<li><a href="/appointment">История посещений</a></li>-->
                    <#--<li><a href="/appointment/new">Записаться на приём</a></li>-->
                <#--</@security.authorize>-->
                <#--<@security.authorize access="!isAnonymous()">-->
                    <#--<li><a href="/logout">Выйти</a></li>-->
                <#--</@security.authorize>-->
                    <#--<li data-slide="1" class="col-12 col-sm-2"><a id="menu-link-1" href="#slide-1" title="Next Section"><span class="icon icon-home"></span> <span class="text">HOME</span></a></li>-->
                    <#--<li data-slide="2" class="col-12 col-sm-2"><a id="menu-link-2" href="#slide-2" title="Next Section"><span class="icon icon-user"></span> <span class="text">ABOUT US</span></a></li>-->
                    <#--<li data-slide="3" class="col-12 col-sm-2"><a id="menu-link-3" href="#slide-3" title="Next Section"><span class="icon icon-briefcase"></span> <span class="text">PORTFOLIO</span></a></li>-->
                    <#--<li data-slide="4" class="col-12 col-sm-2"><a id="menu-link-4" href="#slide-4" title="Next Section"><span class="icon icon-gears"></span> <span class="text">PROCESS</span></a></li>-->
                    <#--<li data-slide="5" class="col-12 col-sm-2"><a id="menu-link-5" href="#slide-5" title="Next Section"><span class="icon icon-heart"></span> <span class="text">CLIENTS</span></a></li>-->
                    <#--<li data-slide="6" class="col-12 col-sm-2"><a id="menu-link-6" href="#slide-6" title="Next Section"><span class="icon icon-envelope"></span> <span class="text">CONTACT</span></a></li>-->
                </ul>
                <div class="row">
                    <div class="col-sm-2 active-menu"></div>
                </div>
            </div><!-- /.nav-collapse -->
        </div><!-- /.container -->
    </div><!-- /.navbar -->
    <!-- /.navbar-collapse -->
