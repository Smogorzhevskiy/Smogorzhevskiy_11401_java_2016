<#include "main-template.ftl"/>
<#macro m_body>
<div class="slide story" id="slide-2" data-slide="2">
    <div class="container">
        <div class="row title-row">
            <#if error??>
                <strong>Oh snap!</strong> Change a few things up and try submitting again.
            </#if>
            <form action="/registration/artist" method="post" name="artist_form" role="form">
                <div>
                    <label>Login</label>
                    <input placeholder="Enter login" type="text" name="login" id="login"/>
                </div>
                <div>
                    <label>Name</label>
                    <input placeholder="Enter Name" type="text" name="name" id="name"/>
                </div>
                <div>
                    <label>Surname</label>
                    <input placeholder="Enter surname" type="text" name="surname" id="surname"/>
                </div>
                <div >
                    <label>Password</label>
                    <input  placeholder="Enter password" type="password" name="password" id="password"/>
                </div>
                <div >
                    <label>Reenter password</label>
                    <input  placeholder="Reenter password" type="password" name="repassword" id="repassword"/>
                </div>
                <div >
                    <label>Email</label>
                    <input  placeholder="Enter email" type="email" name="email" id="email"/>
                </div>
                <div>
                <label>Direction</label>
                    <input  placeholder="Enter direction" type="text" name="direction" id="direction"/>
                </div>
                <div>
                    <label>Gallery</label>
                    <input  placeholder="Enter gallery" type="text" name="gallery" id="gallery"/>
                </div>

                <button type="submit" value="Register">Reg</button>
               </form>
        </div>
    </div>
</div>
</#macro>
<@main title="Artist_reg"/>