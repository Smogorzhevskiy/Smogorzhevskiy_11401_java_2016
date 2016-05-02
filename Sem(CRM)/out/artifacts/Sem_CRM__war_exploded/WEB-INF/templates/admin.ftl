<#include "main-template.ftl"/>
<#macro m_body>
    <h3>Profile</h3>
    <#if admin??>
    ${admin}
    <#else >
    error
    </#if>
</#macro>
<@main title="Admin profile"/>