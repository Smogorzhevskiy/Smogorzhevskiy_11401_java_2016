<#macro main title="Hello!" customScripts=[] customStyles=[]>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
    <#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
    <#assign tg=JspTaglibs["http://www.springframework.org/tags"]>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="../css/sb-admin.css" rel="stylesheet">
    <!-- Morris Charts CSS -->
    <link href="../css/plugins/morris.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <#list customStyles as style>
        <link rel="stylesheet" type="text/css" href="${style}"/>
    </#list>
</head>
<body>
<div id="wrapper">
    <#include "header.ftl"/>
    <div id="page-wrapper">
        <div class="container-fluid">
            <@m_body/>
        </div>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->


<#--<#include "footer.ftl"/>
-->
<!-- jQuery -->
<script src="../js/jquery.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="../js/bootstrap.min.js"></script>
<!-- Morris Charts JavaScript -->
<script src="../js/plugins/morris/raphael.min.js"></script>
<script src="../js/plugins/morris/morris.min.js"></script>
<script src="../js/plugins/morris/morris-data.js"></script>
    <#list customScripts as script>
    <script src="${script}"></script>
    </#list>
</body>
</html>
</#macro>