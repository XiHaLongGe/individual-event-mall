categorySale();
function categorySale(){
    /*
        想要达到效果：
            <span class="as blessing_package">
                <a href="#" style=" color:#000">
                    <h3 style="float:left">&nbsp;应季商品
                        <img src="/static/home/images/zd.png" style="display:block; float:left; margin-top:5px">
                    </h3>
                </a>
                <div class="detailed_navigation">
                    <ul>
                        <li class="dog d-1-lt01 yadi"  dg-floor="1"  dg-ct="lt01">春季</li>
                        <li class="dog d-1-lt02"  dg-floor="1"  dg-ct="lt02">夏季</li>
                        <li class="dog d-1-lt03"  dg-floor="1"  dg-ct="lt03">秋季</li>
                        <li class="dog d-1-lt04"  dg-floor="1"  dg-ct="lt04">冬季</li>
                    </ul>
                </div>
            </span>
    */
    $.ajax({
        url:"/foreground/home/category/level/list?levelNum=1&parentId=0",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            var resultVal = "";
            var resultIndex = 1;
            $.each(data.data, function(index,element) {
                if(element.categoryName == "热销商品"){
                    hotProductHead();
                }else{
                    var resultDIV = "";
                    resultVal += "<span class=\"as blessing_package\">";
                    resultVal += "<a href=\"#\" style=\" color:#000\">";
                    resultVal += "<h3 style=\"float:left\">&nbsp;" + element.categoryName + "<font>" + element.categoryDescribe + "</font>";
                    resultVal += "<img src=\"/static/home/images/zd.png\" style=\"display:block; float:left; margin-top:5px\">";
                    resultVal += "</h3>";
                    resultVal += "<div class=\"detailed_navigation\">";
                    resultVal += "<ul>";
                    $.ajax({
                        url:"/foreground/home/category/level/list?levelNum=" + (element.categoryLevel + 1) + "&parentId=" + element.categoryId,
                        type:"GET",
                        async: false,//设置为同步
                        contentType: "application/json",
                        success:function(data){
                            $.each(data.data, function(index, element){
                                var checked = index == 0 ? " yadi" : "";
                                resultVal += "<li class=\"dog d-1-lt" + resultIndex + " " + checked + "\"  dg-floor=\"1\"  dg-ct=\"lt" + resultIndex + "\">" + element.categoryName + "</li>";
                                resultDIV += categoryProduct(element.categoryId, resultIndex);
                                resultIndex ++;
                            })
                        }
                    })
                    resultVal += "</ul>";
                    resultVal += "</div>";
                    resultVal += "</a>";
                    resultVal += "</span>";
                    resultVal += "<div>" + resultDIV + "</div>";
                }
            })
            $("#spanProduct").empty().append(resultVal);
        }
    })
}
function categoryProduct(categoryId, resultIndex){
    /*
        想要达到效果：
        <div>
            <div class="currency f-1-lt01">
                <ul>
                    <li>
                        <a href="Blessingpackage.html"><img src="/static/home/images/56da66aeN557ae881.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                        <light1>
                            <img src="/static/home/images/saoguang.png">
                        </light1>
                        <span>￥59</span>
                        <a href="Blessingpackage.html"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                        <em>
                            <a href="#">收藏</a>
                            <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                        </em>
                    </li>
                </ul>
            </div>
        </div>
    */
    var resultDIV = "";
    var styleDIV = resultIndex == 1 ? "" : "style=\"display:none\"";
    resultDIV += "<div class=\"currency f-1-lt" + resultIndex + "\" " + styleDIV + ">";
    resultDIV += "<ul>";
    $.ajax({
        url:"/foreground/home/picTypeId/proCategoryId/product?proCategoryId=" + categoryId,
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            $.each(data.data, function(index, element){
                resultDIV += "<li>";
                resultDIV += "<a href=\"Blessingpackage.html\"><img src=\"" + element.pictureInfUrl + "\" style=\" margin:0 auto; display:block; width:220px; height:220px\"></a>";
                resultDIV += "<light1><img src=\"/static/home/images/saoguang.png\"></light1>";
                resultDIV += "<span>￥" + element.productPrice + "</span>";
                resultDIV += "<a href=\"Blessingpackage.html\"><p>" + element.productName + "</p></a>";
                resultDIV += "<em>";
                resultDIV += "<a href=\"#\">收藏</a>";
                resultDIV += "<a href=\"javascript:void(0)\" class=\"add_scar\">加入购物车</a>";
                resultDIV += "</em>";
                resultDIV += "</li>";
            })
        }
    })
    resultDIV += "</ul>";
    resultDIV += "</div>";
    return resultDIV;
}