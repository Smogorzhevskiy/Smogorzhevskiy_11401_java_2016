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
                <#if user??>${user.login}<#else>Anonymous</#if>
                    <@security.authorize access="permitAll()">
                    <li data-slide="1" class="col-12 col-sm-2"><a id="menu-link-1" href="#slide-1" title="Next Section"><span class="icon icon-home"></span> <span class="text">HOME</span></a></li>
                    <li data-slide="2" class="col-12 col-sm-2"><a id="menu-link-2" href="#slide-2" title="Next Section"><span class="icon icon-user"></span> <span class="text">ARTIST</span></a></li>
                    <li data-slide="3" class="col-12 col-sm-2"><a id="menu-link-3" href="#slide-3" title="Next Section"><span class="icon icon-briefcase"></span> <span class="text">GALLERY</span></a></li>
                    <li data-slide="4" class="col-12 col-sm-2"><a id="menu-link-4" href="#slide-4" title="Next Section"><span class="icon icon-pencil"></span> <span class="text">PICTURE</span></a></li>
                    <li data-slide="5" class="col-12 col-sm-2"><a id="menu-link-5" href="#slide-5" title="Next Section"><span class="icon icon-heart"></span> <span class="text">REGISTRATION</span></a></li>
                    <li data-slide="6" class="col-12 col-sm-2"><a id="menu-link-6" href="#slide-6" title="Next Section"><span class="icon icon-envelope"></span> <span class="text">LOG IN</span></a></li>
                    </@security.authorize>

                    <#--<li><a href="/medical_clinics">Медицинские клиники</a></li>-->
                <#--<@security.authorize access="!isAnonymous()">-->
                    <#--<li><a href="/default">Profile</a></li>-->
                <#--</@security.authorize>-->
                <#--&lt;#&ndash;<@security.authorize access="hasRole('ROLE_DOCTOR')">&ndash;&gt;-->
                    <#--&lt;#&ndash;<li><a href="/doctor/appointments">Приём пациентов</a></li>&ndash;&gt;-->
                <#--&lt;#&ndash;</@security.authorize>&ndash;&gt;-->
                <#--<@security.authorize access="isAnonymous()">-->
                    <#--<li><a href="/registration/">Зарегистрироваться</a></li>-->
                    <#--<li><a href="/login" id="login">Войти</a></li>-->
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