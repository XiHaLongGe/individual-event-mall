$(function(){
    /*生成左侧分类名称*/
    $.ajax({
        url:"/foreground/home/category/list",
        type:"GET",
        contentType: "application/json",
        success:function(data){
            var resultVal = "";
            var resultIndex = 1;
            var i = 1;
            $.each(data.data, function(index,element){
                /*
                    想要达到效果：
                                    <li class="cates"  mt-ct="list01">
                                        <p>
                                            <a href="#">家电</a>
                                            <a href="#">数码</a>
                                            <a href="#">手机</a>
                                            <i style="font-family:'宋体';color:#666; line-height:23px; font-size:14px; float:left">></i>
                                        </p>
                                    </li>
                */


                /*判断当分类每生成3个，就创建上一个li标签的结束标签，换下一个li标签，一个li标签存放三个分类名称*/
                if(index % 3 == 0 && index != 0){
                    resultVal += "<i style=\"font-family:'宋体';color:#666; line-height:23px; font-size:14px; float:left\">&gt;</i>"
                    resultVal += "</p>";
                    resultVal += "</li>";
                    resultIndex ++;
                }
                /*当第一次进来直接创建li标签*/
                if(i % 3 == 0 || index == 0){
                    resultVal += "<li class='cates'  mt-ct='list" + resultIndex + "'>";
                    resultVal += "<p>";
                    i = 0;
                }
                i++;
                resultVal += "<a param='"+ element.categoryId +"' href='javascript:;'>" + element.categoryName + "</a>";
                if(index + 1 == data.data.length){
                    resultVal += "<i style=\"font-family:'宋体';color:#666; line-height:23px; font-size:14px; float:left\">&gt;</i>"
                    resultVal += "</p>";
                    resultVal += "</li>";
                }
            })
            $("#categoryUL").empty().append(resultVal);
            categorySpread();
        }
    })
    /*写一个函数的作用是怕ajax的异步操作导致程序出错，现在在上面ajax完成后再调用该函数也就避免了ajax的异步操作带来的漏洞*/
    function categorySpread(){
        /*
            想要达到效果：
                    <div class="import_list b-list1">
                        <dt>与内容无关：</dt>
                        <dd>
                            <a href="#">T恤</a>
                            <a href="#">休闲裤</a>
                            <a href="#">条纹T</a>
                        </dd>
                     </div>
        */
        var resultVal = "";
        var resultIndex = 1;
        $("#categoryUL li").each(function(){
            resultVal += "<div class=\"import_list b-list"+ resultIndex +"\">";
            $(this).children("p").children("a").each(function(){
                /*获取到a标签的param属性*/
                var aParam = $(this).attr("param");
                resultVal += "<dt>" + $(this).text() + "</dt>";
                $.ajax({
                    url:"/foreground/home/category/spread?categoryId=" + aParam,
                    type:"GET",
                    async: false,//设置为同步
                    contentType: "application/json",
                    success:function(data){
                        resultVal += "<dd>";
                        $.each(data.data, function(index,element){
                            resultVal += "<a href=\"javascript:;\">" + element + "</a>";
                        })
                        resultVal += "</dd>";
                    }
                })
            })
            resultVal += "</div>";
            resultIndex ++;
        })
        $("#categorySpreadDIV").empty().append(resultVal);
    }
})

