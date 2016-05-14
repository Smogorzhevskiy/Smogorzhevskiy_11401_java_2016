<#include "main-template.ftl"/>
<#macro m_body>
<div class="slide story" id="slide-2" data-slide="2">
    <div class="container">
        <div class="row title-row">
            <div class="col-12 font-thin">Contrary to popular belief, <span class="font-semibold">Lorem Ipsum</span> is not simply random text.</div>
        </div><!-- /row -->
        <#if artist??>
            <p>Name: ${artist.name}</p>
            <p>Email: ${admin.email}</p>
            <p>Login: ${admin.credential.login}</p>
        <#else>
            error
        </#if>
        </div><!-- /row -->
    </div><!-- /container -->
<!-- /slide2 -->
</#macro>
<@main title="Artist"/>
