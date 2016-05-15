<#include "main-template.ftl"/>
<#macro m_body>
<div class="slide story" id="slide-2" data-slide="2">
    <div class="container">
        <div class="row title-row">
            <#if error??>
                <strong>Oh snap!</strong> Change a few things up and try submitting again.
            </#if>
            <form action="/artist/add_contract"  method="post" name="contract_form" role="form">
                <div >
                    <label>Artist</label>
                    <input  placeholder="Enter artist" type="text" name="artist" id="artist"/>
                </div>
                <div>
                    <label>Gallery</label>
                    <input  placeholder="Enter gallery" type="text" name="gallery" id="gallery"/>
                </div>
                <button type="submit" value="Register">Add</button>
            </form>

        </div>
    </div>
</div>
</#macro>
<@main title="Add_contract"/>