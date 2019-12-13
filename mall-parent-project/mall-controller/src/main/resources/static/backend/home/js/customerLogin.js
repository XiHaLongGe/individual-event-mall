/*下面是查询用户登录信息以分页的形式展现*/
function customerCount(data){
    $("#countSPAN").empty().text("共有数据：" + data.total + " 条");
}
customerList(1);
function customerList(pageNum){
    $.ajax({
        url:"/backend/customer/login/page/list?pageNum=" + pageNum,
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            customerPageList(data);
            pageData(data, pageNum);
        }
    })
}
function customerPageList(data){
    var resultValue = "";
    $.each(data.data.list,function(index, element){
        resultValue += "<tr>";
        resultValue += "<td>";
        resultValue += "<div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='2'><i class=\"layui-icon\">&#xe605;</i></div>";
        resultValue += "</td>";
        resultValue += "<td>" + element.customerId + "</td>";
        resultValue += "<td>" + element.loginAccount + "</td>";
        resultValue += "<td>" + element.loginName + "</td>";
        resultValue += "<td>" + element.activateCode + "</td>";
        resultValue += "<td>" + element.creationTime + "</td>";
        resultValue += "<td class=\"td-status\">";
        var userStats = "";
        var layuiIco = "";
        if(element.userStats != 0){
            resultValue += "<span class=\"layui-btn layui-btn-normal layui-btn-sm\">已激活</span></td>";
            userStats = "禁用";
            layuiIco = "&#xe601;";
        }else{
            resultValue += "<span class=\"layui-btn layui-btn-normal layui-btn-sm layui-btn-disabled\">未激活</span>";
            userStats = "激活";
            layuiIco = "&#xe62f;";
        }
        resultValue += "<td class=\"td-manage\">";
        resultValue += "<a onclick=\"member_stop(this,'10001')\" href=\"javascript:;\"  title=\"" + userStats + "\">";
        resultValue += "<i class=\"layui-icon\">" + layuiIco + "</i>";
        resultValue += "</a>";
        resultValue += "<a title=\"编辑\"  onclick=\"x_admin_show('编辑','member-edit.html',600,400)\" href=\"javascript:;\">";
        resultValue += "<i class=\"layui-icon\">&#xe642;</i>";
        resultValue += "</a>";
        resultValue += "<a title=\"删除\" onclick=\"member_del(this,'要删除的id')\" href=\"javascript:;\">";
        resultValue += "<i class=\"layui-icon\">&#xe640;</i>";
        resultValue += "</a>";
        resultValue += "</td>";
    })
    $("#customerTBODY").empty().append(resultValue);
}
function pageData(data, pageNum){
    customerCount(data.data);
    var resultVal = "";
    resultVal += "<a name='prevNextA' class=\"prev\" href=\"javascript:;\" num='1'>&lt;&lt;</a>";
    resultVal += "<a name='prevNextA' class=\"prev\" href=\"javascript:;\" num='" + (data.data.prePage == 0 ? 1 : data.data.prePage)  + "'>&lt;</a>";
    for(var i = 0; i < data.data.navigatepageNums.length; i ++){
        if(data.data.navigatepageNums[i] == pageNum){
            resultVal += "<span id='pageSPAN' class=\"current\" href=\"javascript:;\" num='" + data.data.navigatepageNums[i] + "'>" + data.data.navigatepageNums[i] + "</span>";
        }else{
            resultVal += "<a name='pageA' class=\"num\" href=\"javascript:;\" num='" + data.data.navigatepageNums[i] + "'>" + data.data.navigatepageNums[i] + "</a>";
        }
    }
    resultVal += "<a name='prevNextA' class=\"next\" href=\"javascript:;\" num='" + (data.data.nextPage == 0 ? data.data.pages : data.data.nextPage) + "'>&gt;</a>";
    resultVal += "<a name='prevNextA' class=\"next\" href=\"javascript:;\" num='" + data.data.pages + "'>&gt;&gt;</a>";
    $("#pageDIV").empty().append(resultVal);
    clickLoader();
}

/*下面是处理对用户登录信息进行条件查询的操作*/
function pageSearch(pageNum){
    $.ajax({
        url:"/backend/customer/login/page/search?pageNum=" + pageNum,
        type:"POST",
        data:JSON.stringify(transformJSON("#searchFORM")),
        dataType:"json",
        contentType: "application/json",
        success:function (data) {
            customerPageList(data);
            pageData(data, pageNum);
        }
    })
}


function clickLoader(){
    $("a[name='pageA'],a[name='prevNextA']").click(function(){
        var pageNum = "";
        var yn = false;
        pageNum = $("#pageSPAN").attr("num");
        $("#pageSPAN").replaceWith("<a name='pageA' class=\"num\" href=\"javascript:;\" num='" + pageNum + "'>" + pageNum + "</a>");
        pageNum = $(this).attr("num");
        $(this).replaceWith("<span id='pageSPAN' class=\"current\" href=\"javascript:;\" num='" + pageNum + "'>" + pageNum + "</span>");
        yn = $("#searchFORM").children("input").eq(2).val() != "" || $("#searchFORM").children("input").eq(0).val() != "";
        yn ? pageSearch(pageNum) : customerList(pageNum);
        clickLoader();
    })
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

$(function(){
    $("#searchBTN").click(function(){
        pageSearch(1);
    })
    clickLoader();
})