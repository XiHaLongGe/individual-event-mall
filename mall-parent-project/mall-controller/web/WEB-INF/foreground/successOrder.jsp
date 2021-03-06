<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2019-12-22
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>锡货超市</title>
    <link href="/static/home/submit-order/css/public.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/static/home/submit-order/css/base.css"/>
    <script type="text/javascript" src="/static/home/submit-order/js/jquery_cart.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/home/submit-order/css/buyConfirm.css" />
    <script src="/static/home/submit-order/js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="/static/home/submit-order/js/unslider.min.js" type="text/javascript"></script>
    <script src="/static/home/submit-order/js/index.js" type="text/javascript"></script>
    <script type="text/javascript">

        window.onload = function(){
            new tab('test4-input-input_tab1-input_tab2', '-');
        }
        function tab(o, s, cb, ev){ //tab换类
            var $ = function(o){return document.getElementById(o)};
            var css = o.split((s||'_'));
            if(css.length!=4)return;
            this.event = ev || 'onclick';
            o = $(o);
            if(o){
                this.ITEM = [];
                o.id = css[0];
                var item = o.getElementsByTagName(css[1]);
                var j=1;
                for(var i=0;i<item.length;i++){
                    if(item[i].className.indexOf(css[2])>=0 || item[i].className.indexOf(css[3])>=0){
                        if(item[i].className == css[2])o['cur'] = item[i];
                        item[i].callBack = cb||function(){};
                        item[i]['css'] = css;
                        item[i]['link'] = o;
                        this.ITEM[j] = item[i];
                        item[i]['Index'] = j++;
                        item[i][this.event] = this.ACTIVE;
                    }
                }
                return o;
            }
        }
        tab.prototype = {
            ACTIVE:function(){
                var $ = function(o){return document.getElementById(o)};
                this['link']['cur'].className = this['css'][3];
                this.className = this['css'][2];
                try{
                    $(this['link']['id']+'_'+this['link']['cur']['Index']).style.display = 'none';
                    $(this['link']['id']+'_'+this['Index']).style.display = 'block';
                }catch(e){}
                this.callBack.call(this);
                this['link']['cur'] = this;
            }
        }
    </script>
</head>

<body>
<input type="hidden" name="productOrderNumber" value="${productOrderNumber}">
<!--订单提交body部分开始-->
<div class="border_top_cart">
    <div class="container payment-con">
        <form action="/alipay" id="pay-form" method="post">
            <div class="order-info">
                <div class="msg">
                    <h3>您的订单已提交成功！付款咯～</h3>
                    <p></p>
                    <p class="post-date">成功付款后，7天内发货</p>
                </div>
                <div id="orderDIV" class="info">
                    <p>
                        金额：<span class="pay-total">49.00元</span>
                    </p>
                    <p>
                        订单：1150505740045173                    </p>
                    <p>
                        配送：潘骏杰                                    <span class="line">/</span>
                        159****6437                                    <span class="line">/</span>
                        江苏,无锡市,北塘区 民丰西苑82号202室                                                                <span class="line">/</span>
                        不限送货时间                                    <span class="line">/</span>
                        个人电子发票                                                    </p>
                </div>
                <div class="icon-box">
                    <i class="iconfont"><img src="/static/home/submit-order/images/yes_ok.png"></i>
                </div>
            </div>
            <script src="/static/home/submit-order/js/successSubmit.js?v=<%= System.currentTimeMillis()%>"></script>
            <div class="xm-plain-box">
                <!-- 选择支付方式 -->
                <div class="box-hd bank-title clearfix">
                    <div id="titleWrap" class="title-wrap">
                        <h2 class="title">选择支付方式</h2>
                        <h2 class="title hide " >你还需要继续支付 <em>49.00</em> 元</h2>
                        <span class="tip-tag"></span>
                    </div>
                </div>
                <div class="box-bd" id="bankList">
                    <div class="payment-bd">
                        <form name="ck">
                            <dl class="clearfix payment-box" >
                                <dt>
                                    <strong>支付平台</strong>
                                    <p>手机等大额支付推荐使用支付宝快捷支付</p>
                                </dt>
                                <dd>
                                    <fieldset id="test4-input-input_tab1-input_tab2" style=" border:none;">
                                        <ul class="payment-list clearfix" >
                                            <li> <input class="input_tab1" name="" id="r1" type="radio" checked="checked"/><label for="r1" ><img src="/static/home/submit-order/images/zfb.png" alt=""/></label></li>
                                            <%--<li><input class="input_tab2" name="myradio" id="r2" type="radio" /><label for="r2" ></label><img src="/static/home/submit-order/images/xhw.png" alt=""/></li>
                                            <li> <input class="input_tab2" name="myradio" id="r2" type="radio" /><label for="r2" ><img src="/static/home/submit-order/images/yck.png" alt=""/></label></li>
                                            <li>  <input class="input_tab2" name="myradio" id="r2" type="radio" /><label for="r2" ><img src="/static/home/submit-order/images/zxzf.png" alt=""/></label></li>--%>
                                        </ul>
                                        <%--<div >
                                            <div id="test4_1">
                                                <ul class="payment-list clearfix"  style="background-color:#f3f3f3;   ">
                                                    <div class="xhw">
                                                        <div class="whx_banner">
                                                            <div style="clear:both"><p class="p1">请选择锡货卡：</p><p class="p2">对不起，没有可用的锡货卡！</p><a class="a3" href="#">立即去充值</a></div>
                                                            <div style="clear:both"><p class="p1">已绑定手机号：</p><p class="a3">15961726437</p></div>
                                                            <div style="clear:both"> <p class="p1">短信效验码</p><input id="mobileCode" name="mobileCode" type="text" value=""><input id="send" type="button" style="cursor:hand" value="点击获取手机验证码" onclick="sendMobileCode()"></div>
                                                        </div>
                                                    </div>
                                                </ul>
                                            </div>
                                            <div  id="test4_2" style="display:none;">
                                            </div>
                                            <div  id="test4_3" style="display:none;">
                                            </div>
                                            <div  id="test4_4" style="display:none;">
                                            </div>
                                        </div>--%>
                                    </fieldset>
                                </dd>
                            </dl>
                        </form>
                    </div>
                </div>
                <div class="box-ft clearfix">
                    <input type="submit" class="btn btn-primary" value="付款" id="">
                    <%--self.location=document.referrer;--%>
                    <%-- onclick="window.close()"--%>
                    <a href="/foreground/home/" class="btn btn-lineDakeLight">取消</a>
                    <span class="tip"></span>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="/static/home/submit-order/js/base.min.js"></script>
<script type="text/javascript" src="/static/home/submit-order/js/buyConfirm.js"></script>
</div>
</body>
</html>
