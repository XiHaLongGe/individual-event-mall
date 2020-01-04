<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2019-12-22
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <title>uiduck demo</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="/static/home/uiduck/css/uiduck.css" type="text/css" rel="stylesheet">
    <link href="/static/home/uiduck/css/table.css" type="text/css" rel="stylesheet">
    <script src="/static/home/uiduck/js/jquery.min.js"></script>
    <script src="/static/home/uiduck/js/vue.min.js"></script>

    <style>
        .numColor{
            background-color: #1e9fff;
        }
        .aLive{
            text-decoration:none;
        }
    </style>
</head>
<body>
<input id="customerInfId" hidden value="${customerInfId}" >
    <div id="vueParent">
        <div style="width: 80%;padding: 0 10%;padding-bottom: 200px;">
            <div id="ud-top" style="display: block;">
                <input id="search" ud-keyWord="productName" class="uiduck-input" />
                <button class="uiduck-btn" onClick=setData()>搜索</button>
            </div>
            <div id="table">
                <table id="uiduck_1577158080757" class="uiduck-table">
                    <thead>
                        <tr>
                            <th  style="font-weight: bold">序号</th>
                            <th  style="font-weight:bold">商品名称</th>
                            <th  style="font-weight:bold">商品价格</th>
                            <th  style="width:65px;font-weight:bold">商品图片</th>
                            <th  style="font-weight:bold">下单时间</th>
                            <th  style="font-weight:bold">订单编号</th>
                            <th  style="font-weight:bold">支付方式</th>
                            <th  style="font-weight:bold">订单状态</th>
                            <th  style="width:100px">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(page,index) in pageInfo.list" class="uiduck_tr " style="visibility: visible;">
                            <td>{{index+1}}</td>
                            <td>
                                <a style="font-weight: 900;color:#E6A23C;"></a>{{page.productName}}</td>
                            <td>{{page.productPrice}}</td>

                            <td><img style="width:65px;height:65px" v-bind:src="page.pictureInfUrl"></td>
                            <td>{{page.paymentTime}}</td>
                            <td>{{page.productOrderNumber}}</td>
                            <td v-if="page.payment == 0">未付款</td>
                            <td v-else>支付宝</td>

                            <td  v-if="page.productOrderState == 1">待付款</td>
                            <td  v-else-if="page.productOrderState == 2">待收货</td>
                            <td  v-else>已收货</td>
                            <td class="style='width:100px'">
                                <div ud-index="dataIndex">
                                    <button v-if="page.productOrderState == 1" class="uiduck-btn" proid="1">付款</button>
                                    <button v-else-if="page.productOrderState == 2"  class="uiduck-btn" proid="1">收货</button>
                                    <button v-else style="cursor:no-drop; background-color: gray"  class="uiduck-btn">已收货</button>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <br>
                <div class="uiduck-page noselect">
                    <a href="javascript:;" @click="pageNum=1" class="aLive">首页</a>
                    <a href="javascript:;" @click="pageNum=pageInfo.prePage" class="aLive">上一页</a>
                    <span @click="pageNum=num" v-for="num in pageInfo.navigatepageNums" :class="{'uiduck-page-its':pageNum == num}">
                        <em class="uiduck-page-em"></em>
                        <em>{{num}}</em>
                    </span>
                    <a href="javascript:;" @click="pageNum=pageInfo.nextPage" class="aLive">下一页</a>
                    <a href="javascript:;" @click="pageNum=pageInfo.pages" class="aLive">尾页</a>
                    <span>共 {{pageInfo.pages}} 条</span>
                    <span class="uiduck-page-limits">
                        <select id="ud-page-select" @change="pageSize=this.value">
                            <option value="5" selected="">5 条/页</option>
                            <option value="10">10 条/页</option>
                            <option value="15">15 条/页</option>
                            <option value="20">20 条/页</option>
                            <option value="25">25 条/页</option>
                            <option value="30">30 条/页</option>
                        </select>
                    </span>
                    <span class="uiduck-page-skip">前往
                        <input id="skipPageNum" type="text" min="1" value="1" class="uiduck-page-input">页
                        <button type="button" class="uiduck-page-btn" @click="pageNum=getParentVal()">确定</button>
                    </span>
                </div>
                <img id="ud-loading" style="position: absolute; left: 674.297px; top: 309.313px; width: 21.32px; height: 21.32px; z-index: 1003; display: none;" src="/static/home/uiduck/assets/uiduck-loading-6.gif">
            </div>
        </div>
    </div>
</body>
<script src="/static/home/uiduck/js/order_load.js?v=<%= System.currentTimeMillis()%>"> </script>
<script language="Javascript" src="/static/home/uiduck/js/json2.js"></script>
<script language="Javascript" src="/static/home/uiduck/js/uiduck.js"></script>
</html>
