<%--
  Created by IntelliJ IDEA.
  User: wzl
  Date: 2019/9/29
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询</title>
    <script src="/jquery-1.8.3-min.js"></script>
    <script src="/vue.js"></script>
    <style>
        .numColor{
            background-color: yellow;
        }
    </style>
</head>
<body>
    <div id="message" ></div>
    <div id="mytable">
        <table border="1px" style="width: 400px;">
            <tr>
                <th>id</th>
                <th>姓名</th>
            </tr>
            <tr v-for="staff in staffs.list">
                <th>{{staff.id}}</th>
                <th>{{staff.name}}</th>
            </tr>
        </table>
<%--        <input type="number"  v-model="pageNum" >--%>
        <input type="button" @click="pageNum=1" value="首页">
        <input type="button" @click="pageNum=staffs.prePage" value="上一页">
        <input type="button" @click="pageNum=num" :value="num" v-for="num in staffs.navigatepageNums" :class="{'numColor':pageNum == num}">
        <input type="button" @click="pageNum=staffs.nextPage" value="下一页">
        <input type="button" @click="pageNum=staffs.pages" value="尾页">
    </div>
    <script>
        var vue = new Vue({
            el:"#mytable",
            data:{
                staffs:[],//用来保存pageInfo
                pageNum:1,
                pageSize:5
            },
            mounted:function () {//初始化时调用
                this.getAll();
            },
            watch: {//监听器
                pageNum: function () {//当pageNum发生改变时，触发此方法
                    this.getAll();
                }
            },
            methods:{
                getAll:function(){
                    var _this = this;
                    $.ajax({
                        url:"pageInfo",
                        type:"post",
                        data:{
                            "pageNum":_this.pageNum,
                            "pageSize":_this.pageSize
                        },
                        dataType:"JSON",
                        beforeSend:function(XMLHttpRequest){
                            $("#message").html("正在获取数据...");
                            $(":input").attr("disabled", true);
                        },
                        complete:function(XMLHttpRequest,textStatus){
                            $("#message").html("员工表：");
                            $(":input").attr("disabled", false);
                        },
                        success:function (data) {
                            _this.staffs=data;
                        }
                    });
                }
            }
        });
    </script>
</body>
</html>
