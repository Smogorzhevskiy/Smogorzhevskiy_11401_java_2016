<#macro main title="Hello!" customScripts=[] customStyles=[]>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
    <#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>Crm(Art_Gallery)</title>
    <meta name="description" content="BlackTie.co - Free Handsome Bootstrap Themes"/>
    <meta name="keywords" content="themes, bootstrap, free, templates, bootstrap 3, freebie,">
    <meta property="og:title" content="">

    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/fancybox/jquery.fancybox-v=2.1.5.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">

    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,600,300,200&subset=latin,latin-ext'
          rel='stylesheet' type='text/css'>


    <link rel="prefetch" href="/resources/images/zoom.png">

    <#list customStyles as style>
        <link rel="stylesheet" type="text/css" href="${style}"/>
    </#list>

    <!-- SCRIPTS -->
    <script src="/resources/js/html5shiv.js"></script>
    <script src="/resources/js/jquery-1.10.2.min.js"></script>
    <script src="/resources/js/jquery-migrate-1.2.1.min.js"></script>
    <#--<script src="/resources/js/bootstrap.min.js"></script>-->
    <script src="/resources/js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="/resources/fancybox/jquery.fancybox.pack-v=2.1.5.js"></script>
    <script src="/resources/js/script.js"></script>


    <!-- fancybox init -->
    <script>
        $(document).ready(function (e) {
            var lis = $('.nav > li');
            menu_focus(lis[0], 1);

            $(".fancybox").fancybox({
                padding: 10,
                helpers: {
                    overlay: {
                        locked: false
                    }
                }
            });

        });
    </script>
    <#list customScripts as script>
        <script src="${script}"></script>
    </#list>
</head>

<body>
    <#include "header.ftl"/>
<!-- === Arrows === -->
<div id="arrows">
    <div id="arrow-up" class="disabled"></div>
    <div id="arrow-down"></div>
    <div id="arrow-left" class="disabled visible-lg"></div>
    <div id="arrow-right" class="disabled visible-lg"></div>
</div><!-- /.arrows -->
<div >
            <@m_body/>
    </div>


<!-- /#wrapper -->


<#--<#include "footer.ftl"/>
-->

</body>
</html>
</#macro>