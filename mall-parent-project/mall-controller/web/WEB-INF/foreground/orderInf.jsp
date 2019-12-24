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
</head>
<body>
    <div style="width: 80%;padding: 0 10%;padding-bottom: 200px;">
        <div id="ud-top" style="display: block;">
            <%--<h3>当前设置为微信字段，通过ud-keyWord属性指定相关列的key</h3>--%>
            <input id="search" ud-keyWord="productName" class="uiduck-input" /><button class="uiduck-btn" onClick=setData()>搜索</button>
        </div>
        <div id="table">
            <table id="uiduck_1577158080757" class="uiduck-table">
                <tbody>
                <tr>
                    <th class="" style="font-weight: bold">序号</th>
                    <th class="" style="font-weight:bold">商品名称</th>
                    <th class="" style="font-weight:bold">商品价格</th>
                    <th class="" style="width:65px;font-weight:bold">商品图片</th>
                    <th class="" style="font-weight:bold">订单编号</th>
                    <th class="" style="font-weight:bold">支付方式</th>
                    <th class="" style="font-weight:bold">订单状态</th>
                    <th class="" style="width:100px">操作</th>
                </tr>
                <tr id="ud-tr-0" ud-tr-num="0" class="uiduck_tr " style="visibility: visible;">
                    <td class="">1</td>
                    <td class="">
                        <a style="font-weight: 900;color:#E6A23C;"></a>远行客登山包双肩男户外背包40L50L徒步旅行包60升</td>
                    <td class="">268</td>
                    <td class=""><img style="width:65px;height:65px" src="/static/home/images/登山包.jpg"></td>
                    <td class="">283948566858674324</td>
                    <td class="">未支付</td>
                    <td class="">待付款</td>
                    <td class="style='width:100px'">
                        <div ud-index="0">
                            <button class="uiduck-btn" proid="1">付款</button>
                        </div>
                    </td>
                </tr>
                <tr id="ud-tr-1" ud-tr-num="1" class="uiduck_tr " style="visibility: visible;">
                    <td class="">2</td>
                    <td class="">
                        <a style="font-weight:1000;color:#E6A23C;"></a>远行客登山包双肩男户外背包40L50L徒步旅行包60升</td>
                    <td class="">268</td>
                    <td class=""><img style="width:65px;height:65px" src="/static/home/images/登山包.jpg"></td>
                    <td class="">349115002091446658</td>
                    <td class="">未支付</td>
                    <td class="">待收货</td>
                    <td class="style='width:100px'">
                        <div ud-index="1">
                            <button class="uiduck-btn" proid="1">付款</button>
                        </div>
                    </td>
                </tr>
                <tr id="ud-tr-2" ud-tr-num="2" class="uiduck_tr " style="visibility: visible;">
                    <td class="">3</td>
                    <td class="">
                        <a style="font-weight:1000;color:#E6A23C;"></a>远行客登山包双肩男户外背包40L50L徒步旅行包60升</td>
                    <td class="">268</td>
                    <td class=""><img style="width:65px;height:65px" src="/static/home/images/登山包.jpg"></td>
                    <td class="">389171090388108452</td>
                    <td class="">未支付</td>
                    <td class="">待收货</td>
                    <td class="style='width:100px'">
                        <div ud-index="2">
                            <button class="uiduck-btn" proid="1">付款</button>
                        </div>
                    </td>
                </tr>
                <tr id="ud-tr-3" ud-tr-num="3" class="uiduck_tr " style="visibility: visible;">
                    <td class="">4</td>
                    <td class="">
                        <a style="font-weight:1000;color:#E6A23C;"></a>远行客登山包双肩男户外背包40L50L徒步旅行包60升</td>
                    <td class="">268</td>
                    <td class=""><img style="width:65px;height:65px" src="/static/home/images/登山包.jpg"></td>
                    <td class="">575212468560357515</td>
                    <td class="">未支付</td>
                    <td class="">待付款</td>
                    <td class="style='width:100px'">
                        <div ud-index="3">
                            <button class="uiduck-btn" proid="1">付款</button>
                        </div>
                    </td>
                </tr>
                <tr id="ud-tr-4" ud-tr-num="4" class="uiduck_tr " style="visibility: visible;">
                    <td class="">5</td>
                    <td class="">
                        <a style="font-weight:1000;color:#E6A23C;"></a>远行客登山包双肩男户外背包40L50L徒步旅行包60升</td>
                    <td class="">268</td>
                    <td class=""><img style="width:65px;height:65px" src="/static/home/images/登山包.jpg"></td>
                    <td class="">025668867302484473</td>
                    <td class="">未支付</td>
                    <td class="">待付款</td>
                    <td class="style='width:100px'">
                        <div ud-index="4">
                            <button class="uiduck-btn" proid="1">付款</button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
            <br>
            <%--<div class="uiduck-page noselect">
                <a class="uiduck-page-disable">首页</a>
                <a class="uiduck-page-disable">上一页</a>
                <span class="uiduck-page-its">
			<em class="uiduck-page-em"></em>
			<em>1</em>
		</span>
                <a onclick="uiduck.skipPage(1)">2</a>
                <a class="layui-laypage-next" onclick="uiduck.nextPage();">下一页</a>
                <a onclick="uiduck.lastPage();">尾页</a>
                <span>共 7 条</span>
                <span class="uiduck-page-limits">
			<select id="ud-page-select" onchange="uiduck.changeLimit(this.value)">
				<option value="5" selected="">5 条/页</option>
				<option value="10">10 条/页</option>
				<option value="15">15 条/页</option>
				<option value="20">20 条/页</option>
				<option value="25">25 条/页</option>
				<option value="30">30 条/页</option>
			</select>
		</span>
                <span class="uiduck-page-skip">前往
			<input id="ud-page-skip-text" type="text" min="1" value="1" class="uiduck-page-input">页
				<button type="button" class="uiduck-page-btn" onclick="uiduck.skipPage()">确定</button>
		</span>
            </div>--%>
            <img id="ud-loading" style="position: absolute; left: 674.297px; top: 309.313px; width: 21.32px; height: 21.32px; z-index: 1003; display: none;" src="/static/home/uiduck/assets/uiduck-loading-6.gif">
        </div>
    </div>
</body>
<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script language="Javascript" src="/static/home/uiduck/js/json2.js"></script>
<script language="Javascript" src="/static/home/uiduck/js/uiduck.js"></script>
</html>
