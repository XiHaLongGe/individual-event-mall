<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2019-12-14
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-L-admin1.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/static/backend/home/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/static/backend/home/css/font.css">
    <link rel="stylesheet" href="/static/backend/home/css/xadmin.css">
    <script src="/static/backend/home/js/jquery.min.js"></script>
    <script type="text/javascript" src="/static/backend/home/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/backend/home/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-body">
    <form id="editFORM" class="layui-form">
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>昵称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_username" name="loginName" required lay-verify="nikename"
                       autocomplete="off" class="layui-input" value="${customerLoginEntity.loginName}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_pass" class="layui-form-label">
                <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_pass" name="loginPassword" required lay-verify="pass"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                6到16个字符
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
                <span class="x-red">*</span>确认密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_repass" name="repass" required lay-verify="repass"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_phone" class="layui-form-label">
                <span class="x-red">*</span>手机号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_phone" name="customerPhone" required lay-verify="phone"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_email" class="layui-form-label">
                <span class="x-red">*</span>邮箱
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_email" name="customerEmail" required lay-verify="email"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="add" lay-submit="">
                添加
            </button>
        </div>
    </form>
</div>
<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;

        //自定义验证规则
        form.verify({
            nikename: function(value){
                if(value.length < 5){
                    return '昵称至少得5个字符';
                }
            }
            ,pass: [/(.+){6,16}$/, '密码必须6到16位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(add)', function(data){
            layer.confirm('确认要添加吗？',function(index){
                var iconNum = 5;
                var alertVal = "失败";
                if(editAjax()){
                    iconNum = 6;
                    alertVal = "成功,请刷新页面^v^ ^v^ ^v^";
                }
                layer.alert("添加" + alertVal, {icon: iconNum},function () {
                    // 获得frame索引
                    var index = parent.layer.getFrameIndex(window.name);
                    //关闭当前frame
                    parent.layer.close(index);
                });
            })
            return false;
        });
    });
    function editAjax(){
        var yn = false;
        $.ajax({
            url:"/foreground/customer/login/register",
            type:"POST",
            data:JSON.stringify(transformJSON("#editFORM")),
            dataType:"json",
            async: false,//设置为同步
            contentType: "application/json",
            success:function(data){
                if(data.code == 200){
                    yn = true;
                }
            }
        })
        return yn;
    }
    //将表单数据转换成json数据
    function transformJSON(formId){
        var $jsonData = {};
        /*下面是将form表单的数据转换成一个json的数据格式*/
        $.each($(formId).serializeArray(), function(i,e){
            $jsonData[e.name] = e.value;
        })
        return $jsonData;
    }
</script>
</body>

</html>
