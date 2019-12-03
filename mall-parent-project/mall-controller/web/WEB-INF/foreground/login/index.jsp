<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2019-12-02
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/css/form-elements.css">
    <link rel="stylesheet" href="/assets/css/style.css?v=<%= System.currentTimeMillis()%>">
    <link rel="shortcut icon" href="/assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/assets/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
<!-- Top content -->
<div class="top-content" style="width:100%;">
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2 text">
                <h1>
                    <span class="show-login-form active">登录</span>
                    <span class="show-forms-divider">/</span>
                    <span class="show-register-form">注册</span>
                </h1>
                <div class="description">
                </div>
            </div>
        </div>
        <div class="row login-form">
            <div class="col-sm-4 col-sm-offset-4">
                <form id="loginForm" role="form" action="" method="post" class="l-form">
                    <div class="form-group">
                        <%--<label class="sr-only" for="l  -form-username">Username</label>--%>
                        <input type="text" name="loginAccount" placeholder="账号" class="l-form-username form-control" id="accountID">
                    </div>
                    <div class="form-group">
                        <%--<label class="sr-only" for="l-form-password">Password</label>--%>
                        <input type="password" name="loginPassword" placeholder="密码" class="l-form-password form-control" id="passwordID">
                    </div>
                    <button id="loginBtn" type="button" class="btn">登录</button>
                </form>
            </div>
        </div>
        <div class="row register-form">
            <div class="col-sm-4 col-sm-offset-4">
                <form role="form" action="" method="post" class="r-form">
                    <div class="form-group">
                        <%--<label class="sr-only" for="for-name">用户昵称</label>--%>
                        <input type="text" name="r-form-first-name" placeholder="用户昵称" class="r-form-first-name form-control" id="for-name">
                    </div>
                    <div class="form-group">
                        <%--<label class="sr-only" for="for-pwd">登录密码</label>--%>
                        <input type="text" name="r-form-last-name" placeholder="登录密码" class="r-form-last-name form-control" id="for-pwd">
                    </div>
                    <div class="form-group">
                        <%--<label class="sr-only" for="for-confirm-pwd">确认密码</label>--%>
                        <input type="text" name="r-form-last-name" placeholder="确认密码" class="r-form-last-name form-control" id="for-confirm-pwd">
                    </div>
                    <div class="form-group">
                        <%--<label class="sr-only" for="for-phone">手机号</label>--%>
                        <input type="text" name="phone" placeholder="手机号" class="r-form-email form-control" id="for-phone">
                    </div>
                    <div class="form-group">
                        <%--<label class="sr-only" for="for-email">邮箱</label>--%>
                        <input type="text" name="r-form-email" placeholder="邮箱" class="r-form-email form-control" id="for-email">
                    </div>
                    <button type="submit" class="btn">注册</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%--<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    登录提示
                </h4>
            </div>
            <div class="modal-body">
                登录失败，你输入的账号或密码可能存在问题！
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    确定
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>--%>
<script src="/static/js/jquery/jquery-3.3.1.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/js/loginAJAX.js"></script>
<script src="/assets/js/jquery.backstretch.min.js"></script>
<script src="/assets/js/scripts.js?v=<%= System.currentTimeMillis()%>"></script>
</body>
</html>
