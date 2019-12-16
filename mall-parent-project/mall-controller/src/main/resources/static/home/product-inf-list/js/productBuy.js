productPictureData();
function productPictureData(){
    /*
        想要达到效果：
                <ol class="Xcontent08" id="productPicOL">
                    <div class="Xcontent07"><img src="/static/home/product-inf-list/images/shangpinxiangqing/X1.png"></div>
                    <div class="Xcontent09"><img src="/static/home/product-inf-list/images/shangpinxiangqing/X7.png"></div>
                    <div class="Xcontent10"><img src="/static/home/product-inf-list/images/shangpinxiangqing/X8.png"></div>
                    <div class="Xcontent11"><img src="/static/home/product-inf-list/images/shangpinxiangqing/X9.png"></div>
                    <div class="Xcontent12"><img src="/static/home/product-inf-list/images/shangpinxiangqing/X10.png"></div>
                </ol>
    */
    $.ajax({
        url:"/foreground/picture/type/main/list?pictureTypeId=5&productId=" + $("#productId").val(),
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json;charset=utf-8",
        success:function(data){
            var resultValue = "";
            var firstPicValue = "";
                $.each(data.data, function (index, element) {
                    if(index == 0){
                        firstPicValue = "<img src=\"" + element.pictureInfUrl + "\">"
                    }
                    resultValue += "<div class=\"Xcontent09\"><img src=\"" + element.pictureInfUrl + "\"></div>";
                })
            $("#firstPicDIV").empty().append(firstPicValue);
            $("#productPicOL").empty().append(resultValue);
        }
    })
}


productBuyData();
function productBuyData(){
    /*
        想要达到效果：
        <ol class="Xcontent13" id="productBuyOL">
                <div class="Xcontent14"><a href="#"><p>新物品</p></a></div>
                <div class="Xcontent15"><img src="/static/home/product-inf-list/images/shangpinxiangqing/X11.png"></div>
                <div class="Xcontent16"><p>充电5分钟，温暖2小时</p></div>
                <div class="Xcontent17">
                    <p class="Xcontent18">售价</p>
                    <p class="Xcontent19">￥<span>69.00</span></p>
                    <div class="Xcontent20">
                        <p class="Xcontent21">促销</p>
                        <img src="/static/home/product-inf-list/images/shangpinxiangqing/X12.png">
                        <p class="Xcontent22">领610元新年礼券，满再赠好礼</p>
                    </div>
                    <div class="Xcontent23">
                        <p class="Xcontent24">服务</p>
                        <p class="Xcontent25">30天无忧退货&nbsp;&nbsp;&nbsp;&nbsp;       48小时快速退款 &nbsp;&nbsp;&nbsp;&nbsp;        满88元免邮</p>
                    </div>
                </div>
                <div class="Xcontent26">
                    <p class="Xcontent27">颜色</p>
                    <div class="Xcontent28"><img  src="/static/home/product-inf-list/images/shangpinxiangqing/X14.png"></div>
                    <div class="Xcontent29"><img  src="/static/home/product-inf-list/images/shangpinxiangqing/X1.png"></div>
                </div>
                <div class="Xcontent30">
                    <p class="Xcontent31">数量</p>
                    <div class="Xcontent32"><img src="/static/home/product-inf-list/images/shangpinxiangqing/X15.png"></div>
                    <form>
                        <input class="input" value="1"></form>
                    <div class="Xcontent33"><img src="/static/home/product-inf-list/images/shangpinxiangqing/16.png"></div>
                </div>
                <div class="Xcontent34"><a href="#"><img src="/static/home/product-inf-list/images/shangpinxiangqing/X17.png"></a></div>
                <div class="Xcontent35"><a href="#"><img src="/static/home/product-inf-list/images/shangpinxiangqing/X18.png"></a></div>
        </ol>
    */
    var $productId = $("#productId").val();
    $.ajax({
        url:"/foreground/product/list?productId=" + $productId,
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json;charset=utf-8",
        success:function(data){
            var resultValue = "";
            var $productName = data.data.productName;
            var $productDescribe = data.data.productDescribe;
            var $productPrice = data.data.productPrice;
            var $productSales = data.data.productSales;
            resultValue +="<div class=\"Xcontent14\"><a href=\"#\"><p>" + $productName + "</p></a></div>";
            //resultValue +="<div class=\"Xcontent15\"><img src=\"" + $pictureInfUrl + "\"></div>";
            resultValue +="<div class=\"Xcontent16\"><p>" + $productDescribe + "</p></div>";
            resultValue +="<div class=\"Xcontent17\">";
            resultValue +="<p class=\"Xcontent18\">售价</p>";
            resultValue +="<p class=\"Xcontent19\">￥<span>" + $productPrice + "</span></p>";
            resultValue +="<div class=\"Xcontent20\">";
            /*促销一栏*/
            resultValue +="<p class=\"Xcontent21\">促销</p>";
            resultValue +="<img src=\"/static/home/product-inf-list/images/shangpinxiangqing/X12.png\">";
            resultValue +="<p class=\"Xcontent22\">领610元新年礼券，满再赠好礼</p>";
            resultValue +="</div>";
            /*服务一栏*/
            /*resultValue +="<div class=\"Xcontent23\">";
            resultValue +="<p class=\"Xcontent24\">服务</p>";
            resultValue +="<p class=\"Xcontent25\">30天无忧退货&nbsp;&nbsp;&nbsp;&nbsp;       48小时快速退款 &nbsp;&nbsp;&nbsp;&nbsp;        满88元免邮</p>";
            resultValue +="</div>";*/
            resultValue +="<div class=\"Xcontent23\">";
            resultValue +="<p class=\"Xcontent24\">销量</p>";
            resultValue +="<p class=\"Xcontent25\">" + $productSales + "</p>";
            resultValue +="</div>";
            resultValue +="</div>";
            /*图片款式一栏*/
            resultValue +="<div class=\"Xcontent26\">";
            resultValue +="<p class=\"Xcontent27\">款式</p>";
            $.ajax({
                url:"/foreground/picture/type/main/list?pictureTypeId=6&productId=" + $productId,
                type:"GET",
                async: false,//设置为同步
                contentType: "application/json;charset=utf-8",
                success:function(data){
                    $.each(data.data, function(index, element){
                        resultValue +="<div class=\"Xcontent28\"><img  src=\"" + element.pictureInfUrl + "\"></div>";
                    })
                }
            })
            resultValue +="</div>";
            /*数量一栏*/
            resultValue +="<div class=\"Xcontent30\">";
            resultValue +="<p class=\"Xcontent31\">数量</p>";
            resultValue +="<div class=\"Xcontent32\"><img src=\"/static/home/product-inf-list/images/shangpinxiangqing/X15.png\"></div>";
            resultValue +="<input class=\"input\" value=\"1\">";
            resultValue +="<div class=\"Xcontent33\"><img src=\"/static/home/product-inf-list/images/shangpinxiangqing/16.png\"></div>";
            resultValue +="</div>";
            /*立即购买  &  加入购物车*/
            resultValue +="<div class=\"Xcontent34\"><a href=\"#\"><img src=\"/static/home/product-inf-list/images/shangpinxiangqing/X17.png\"></a></div>";
            resultValue +="<div class=\"Xcontent35\"><a href=\"#\"><img src=\"/static/home/product-inf-list/images/shangpinxiangqing/X18.png\"></a></div>";


            $("#title").empty().append($productName)
            $("#productBuyOL").empty().append(resultValue)
        }
    })
}