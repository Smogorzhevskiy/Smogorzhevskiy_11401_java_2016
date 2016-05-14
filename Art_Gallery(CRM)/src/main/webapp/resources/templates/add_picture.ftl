<#include "main-template.ftl"/>
<#macro m_body>
<div class="slide story" id="slide-2" data-slide="2">
    <div class="container">
        <div class="row title-row">
        <#if error??>
            <strong>Oh snap!</strong> Change a few things up and try submitting again.
        </#if>
            <form action="/artist/add_picture" enctype="multipart/form-data" method="post" name="picture_form" role="form">
                <div>
                    <label>Name</label>
                    <input placeholder="Enter Name" type="text" path="name" id="name"/>
                </div>
                <div >
                    <label>Artist</label>
                    <input  placeholder="Enter email" type="text" path="artist" id="artist"/>
                </div>
                <div>
                    <label>Gallery</label>
                    <input  placeholder="Enter gallery" type="text" path="gallery" id="gallery"/>
                </div>
                <p>Загрузите ваши фотографии на сервер</p>
                <p><input type="file" name="photo">
                <input type="submit" value="Register"/>
                </form>

        </div>
    </div>
</div>
</#macro>
<@main title="Add_picture"/>