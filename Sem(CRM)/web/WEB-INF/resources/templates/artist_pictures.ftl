<#include "main-template.ftl"/>
<#macro m_body>
        <h2>Pictures</h2>
<table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Author</th>
                </tr>
                </thead>
                <tbody>
                    <#list books as b>
                    <tr>
                        <td>${b.name}</td>
                        <td>${b.author}</td>
                    </tr>
                    </#list>
                </tbody>
            </table>
</#macro>
<@main title="Added books"/>