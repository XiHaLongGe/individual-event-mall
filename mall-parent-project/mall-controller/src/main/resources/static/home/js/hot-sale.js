function hotProductHead(){
    /*
        想要达到效果：
	    <h3 id="hotSaleH3">
            热销商品
            <font>热销商品，赶快来抢购</font>
            <a href="#">更多热销商品</a>
	    </h3>
    */
    $.ajax({
        url:"/foreground/home/category/level/list?levelNum=1",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            var resultVal = "";
            $.each(data.data, function(index,element) {
                if(element.categoryName == "热销商品"){
                    resultVal += element.categoryName;
                    resultVal += "<font>" + element.categoryDescribe + "</font>";
                    resultVal += "<a href=\"#\">更多热销商品</a>";
                }
            })
            $("#hotSaleH3").empty().append(resultVal);
            hotProductBody();
        }
    })
}
function hotProductBody(){
    /*
        想要达到效果：
            <li>
                <light>
                    <img src="/static/home/images/saoguang1.png">
                </light>
                <a href="liebiao_page.html"><img src="/static/home/images/1.jpg"></a>
                <span>价值288元</span>
                <a href="#">查看福包</a>
                <em>200人已购买</em>
            </li>
    */
    $.ajax({
        url:"/foreground/home/picTypeId/proCategoryId/product?picTypeId=3&proCategoryId=8",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            var resultVal = "";
            $.each(data.data, function(index,element) {
                resultVal += "<li>";
                resultVal += "<light>";
                resultVal += "<img src=\"/static/home/images/saoguang1.png\">";
                resultVal += "</light>";
                resultVal += "<a href=\"liebiao_page.html\"><img src=\"" + element.pictureInfUrl + "\"></a>";
                resultVal += "<span>价值" + element.productPrice + "元</span>";
                resultVal += "<a href=\"#\">查看商品</a>";
                resultVal += "<em>" + element.productSales + "人已购买</em>";
                resultVal += "</li>";
            })
            $("#hotSaleUL").empty().append(resultVal);
        }
    })
}