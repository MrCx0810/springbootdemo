<%--
  Created by IntelliJ IDEA.
  User: 小小小阿曦
  Date: 2018/1/4
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

    <meta charset="utf-8" />

    <title>登录系统</title>

    <meta content="width=device-width, initial-scale=1.0" name="viewport" />

    <meta content="" name="description" />

    <meta content="" name="author" />

    <!-- BEGIN GLOBAL MANDATORY STYLES -->

    <link href="${pageContext.request.contextPath}/static/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <link href="${pageContext.request.contextPath}/static/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

    <link href="${pageContext.request.contextPath}/static/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

    <link href="${pageContext.request.contextPath}/static/media/css/style-metro.css" rel="stylesheet" type="text/css"/>

    <link href="${pageContext.request.contextPath}/static/media/css/style.css" rel="stylesheet" type="text/css"/>

    <link href="${pageContext.request.contextPath}/static/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

    <link href="${pageContext.request.contextPath}/static/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

    <link href="${pageContext.request.contextPath}/static/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

    <!-- END GLOBAL MANDATORY STYLES -->

    <!-- BEGIN PAGE LEVEL STYLES -->

    <link href="${pageContext.request.contextPath}/static/media/css/login-soft.css" rel="stylesheet" type="text/css"/>

    <!-- END PAGE LEVEL STYLES -->

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/media/image/favicon.ico" />

</head>
<body class="login">

<!-- BEGIN LOGO -->

<div class="logo">
    <%-- 登录图标--%>
    <%--<img src="${pageContext.request.contextPath}/static/media/image/logo-big.png" alt="" />--%>
    <h2 class="form-title" style="color: #ffffff">后台管理系统</h2>

</div>
<div class="content">


    <form class="form-vertical login-form" method="post">

        <h3 class="form-title" style="text-align: center">登录你的账号</h3>
        <div class="control-group">

            <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->

            <label class="control-label visible-ie8 visible-ie9">登录名：</label>

            <div class="controls">

                <div class="input-icon left">

                    <i class="icon-user"></i>

                    <input id="user" class="m-wrap placeholder-no-fix" type="text" placeholder="登录名" name="username"/>

                </div>

            </div>

        </div>

        <div class="control-group">

            <label class="control-label visible-ie8 visible-ie9">密码：</label>

            <div class="controls">

                <div class="input-icon left">

                    <i class="icon-lock"></i>

                    <input id="psw" class="m-wrap placeholder-no-fix" type="password" placeholder="密码" name="password"/>

                </div>

            </div>

        </div>

        <div class="form-actions">
            <button id="login" style="width: 100%" type="submit" class="btn blue">
                登录 <i class="m-icon-swapright m-icon-white"></i>
            </button>
        </div>

    </form>
</div>
<script src="${pageContext.request.contextPath}/static/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/media/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/media/js/excanvas.min.js"></script>
<script src="${pageContext.request.contextPath}/static/media/js/respond.min.js"></script>
<script src="${pageContext.request.contextPath}/static/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/media/js/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/media/js/jquery.cookie.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/media/js/jquery.uniform.min.js" type="text/javascript" ></script>
<script src="${pageContext.request.contextPath}/static/media/js/jquery.backstretch.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/media/js/app.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/media/js/login-soft.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<script>

    jQuery(document).ready(function() {

        App.init();

        Login.init();

    });

    $("#login").click(function(){
        var login = $("#user").val();
        var psw = $("#psw").val();
        $.post("../../doAdminlogin",{loginName:login,psw:psw},function(e){
            console.log(e);
            if(e.code=="100"){
                layer.msg('登录成功', {
                    anim: 1,
                    time: 2000 //2秒关闭（如果不配置，默认是3秒）
                }, function(){
                    location.href="../../admin/index";
                });
            }else{
                layer.msg(e.msg, {
                    anim: 2,
                    time: 3000 //2秒关闭（如果不配置，默认是3秒）
                });
            }
        });
        return false;
    });

</script>
</body>
</html>
