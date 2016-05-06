<#include "main-template.ftl"/>

<#macro m_body>
    <#if error??>
    <strong>Oh snap!</strong> Change a few things up and try submitting again.
    </#if>
<form role="form" action="/registration/artist" method="post">
    <label>Login</label>
    <input class="form-control" placeholder="Enter login" type="text" name="login" required>
    <label>Password</label>
    <input class="form-control" placeholder="Enter password" type="password" name="password" required>
    <label>Email</label>
    <input class="form-control" placeholder="Enter email" type="email" name="email" required>
    <label>Name</label>
    <input class="form-control" placeholder="Enter name" type="text" name="name" required>
    <label>Phone number</label>
    <input class="form-control" placeholder="Enter phone number" type="number" name="phoneNumber" required>
    <label>Address</label>
    <input class="form-control" placeholder="Enter address" type="text" name="address" required>
    <button type="submit" class="btn btn-default">Register</button>
</form>

</#macro>
<@main title="Registration"/>