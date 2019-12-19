receivingInfData();
/*加载收货信息*/
function receivingInfData(){
    /*
        想要达到效果：
                <div class="xm-box">
                    <div class="box-hd ">
                        <h2 class="title">收货地址</h2>
                        <!---->
                    </div>
                    <div class="box-bd">
                        <div class="clearfix xm-address-list" id="checkoutAddrList">
                            <dl class="item" >
                                <dt>
                                    <strong class="itemConsignee">潘骏杰</strong>
                                    <span class="itemTag tag">家</span>
                                </dt>
                                <dd>
                                    <p class="tel itemTel">15961726437</p>
                                    <p class="itemRegion">江苏 无锡市 北塘区</p>
                                    <p class="itemStreet">民丰西苑82号202室(214045)</p>
                                    <span class="edit-btn J_editAddr">编辑</span>
                                </dd>
                                <dd style="display:none">
                                    <input type="radio" name="Checkout[address]" class="addressId"  value="10140916720030323">
                                </dd>
                            </dl>
                            <div class="item use-new-addr"  id="J_useNewAddr" data-state="off">
                                <span class="iconfont icon-add"><img src="/static/home/submit-order/images/add_cart.png" /></span>
                                使用新地址
                            </div>
                        </div>
                        <input type="hidden" name="newAddress[type]" id="newType" value="common">
                        <input type="hidden" name="newAddress[consignee]" id="newConsignee">
                        <input type="hidden" name="newAddress[province]" id="newProvince">
                        <input type="hidden" name="newAddress[city]" id="newCity">
                        <input type="hidden" name="newAddress[district]" id="newCounty">
                        <input type="hidden" name="newAddress[address]" id="newStreet">
                        <input type="hidden" name="newAddress[zipcode]" id="newZipcode">
                        <input type="hidden" name="newAddress[tel]" id="newTel">
                        <input type="hidden" name="newAddress[tag_name]" id="newTag">
                        <!--点击弹出新增/收货地址界面start-->
                        <div class="xm-edit-addr-box" id="J_editAddrBox">
                            <div class="bd">
                                <div class="item">
                                    <label>收货人姓名<span>*</span></label>
                                    <input type="text" name="userAddress[consignee]" id="Consignee" class="input" placeholder="收货人姓名" maxlength="15" autocomplete='off'>
                                    <p class="tip-msg tipMsg"></p>
                                </div>
                                <div class="item">
                                    <label>联系电话<span>*</span></label>
                                    <input type="text" name="userAddress[tel]" class="input" id="Telephone" placeholder="11位手机号" autocomplete='off'>
                                    <p class="tel-modify-tip" id="telModifyTip"></p>
                                    <p class="tip-msg tipMsg"></p>
                                </div>
                                <div class="item">
                                    <label>地址<span>*</span></label>
                                    <select name="userAddress[province]" id="Provinces" class="select-1">
                                        <option>省份/自治区</option>
                                    </select>
                                    <select name="userAddress[city]"  id="Citys" class="select-2" disabled>
                                        <option>城市/地区/自治州</option>
                                    </select>
                                    <select name="userAddress[county]"  id="Countys" class="select-3" disabled>
                                        <option>区/县</option>
                                    </select>
                                    <textarea   name="userAddress[street]" class="input-area" id="Street" placeholder="路名或街道地址，门牌号"></textarea>
                                    <p class="tip-msg tipMsg"></p>
                                </div>
                                <div class="item">
                                    <label>邮政编码<span>*</span></label>
                                    <input type="text" name="userAddress[zipcode]" id="Zipcode" class="input" placeholder="邮政编码"  autocomplete='off'>
                                    <p class="zipcode-tip" id="zipcodeTip"></p>
                                    <p class="tip-msg tipMsg"></p>
                                </div>
                                <div class="item">
                                    <label>地址标签<span>*</span></label>
                                    <input type="text" name="userAddress[tag]" id="Tag" class="input" placeholder='地址标签：如"家"、"公司"。限5个字内'  >
                                    <p class="tip-msg tipMsg"></p>
                                </div>
                            </div>
                            <div class="ft clearfix">
                                <button  type="button"  class="btn btn-lineDake btn-small " id="J_editAddrCancel">取消</button>
                                <button type="button" class="btn btn-primary  btn-small " id="J_editAddrOk">保存</button>
                            </div>
                        </div>
                        <!--点击弹出新增/收货地址界面end-->
                        <div class="xm-edit-addr-backdrop" id="J_editAddrBackdrop"></div>
                    </div>
                </div>
    */
    var resultValue = "";
    var resultIndex = 0;
    $.ajax({
        url:"/foreground/receivingInf/customerInfId/list?customerInfId=1",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json;charset=utf-8",
        success:function(data){
            $.each(data.data, function(index, element){
                resultIndex ++;
                resultValue += "<dl class=\"item " + (index == 0 ? "selected" : "") + "\"style=\"display: line;\">";
                resultValue += "<dt>";
                resultValue += "<strong class=\"itemConsignee\">" + element.receivingInfName + "</strong>";
                var labelInfName = element.labelInfName;
                resultValue += labelInfName == null ? "" : "<span class=\"itemTag tag\">" + labelInfName + "</span>";
                resultValue += "</dt>";
                resultValue += "<dd>";
                resultValue += "<p class=\"tel itemTel\">" + element.receivingInfPhone + "</p>";
                resultValue += "<p class=\"itemRegion\">" + element.receivingInfProvince + " " + element.receivingInfCity + " " + element.receivingInfDistrict + "</p>";
                resultValue += "<p class=\"itemStreet\">" + element.receivingInfAddress + "</p>";
                resultValue += "<span receivingInfId='" + element.receivingInfId + "' class=\"edit-btn J_editAddr editCLZ\">编辑</span>";
                resultValue += "<span receivingInfId='" + element.receivingInfId + "' class=\"edit-btn  delCLZ\">删除</span>";
                resultValue += "</dd>";
                resultValue += "<dd style=\"display:none\">";
                //resultValue += "<input type=\"radio\" name=\"Checkout[address]\" class=\"addressId\"  value=\"10140916720030323\">";
                resultValue += "</dd>";
                resultValue += "</dl>";
            })
        }
    })
    /*限制用户只能拥有3个收货地址，当用户已存在3个收货地址就不加载添加收获地址的选项*/
    if(resultIndex < 3){
        resultValue += "<div class=\"item use-new-addr\"  id=\"J_useNewAddr\" data-state=\"off\">";
        resultValue += "<span class=\"iconfont icon-add\"><img src=\"/static/home/submit-order/images/add_cart.png\" /></span>";
        resultValue += "新增地址";
        resultValue += "</div>";
    }
    $("#checkoutAddrList").empty().append(resultValue)
    labelInfData();
    eventsRefresh();
}
/*加载收货信息的标签*/
function labelInfData(){
    var resultValue = ""
    resultValue += "<option value='0'>选择一个标签</option>";
    $.ajax({
        url:"/foreground/labelInf/customerInfId/list?customerInfId=1",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json;charset=utf-8",
        success:function(data){
            $.each(data.data,function (index,element) {
                resultValue += "<option value='" + element.labelInfId + "'>" + element.labelInfName + "</option>";
            })
        }
    })
    $("#labelSELECT").empty().append(resultValue);
}

function eventsRefresh(){
$(".item").on("click",function(){
    $(".item").each(function(){
        $(this).removeClass('selected');
    })
    $(this).addClass('selected');
})

$("#J_useNewAddr").on("click",function(){
    /*var show = $('#J_editAddrBox').css('display');
    $("#J_editAddrBox").css('display',show == 'block' ? 'none' : show);
    $("#J_editAddrBackdrop").css('display',show == 'block' ? 'none' : show);*/
    $("#J_editAddrBox").css('display', 'block');
    $("#J_editAddrBackdrop").css('display', 'block');
})
/*当三级联动选项数据完全后，将数据加入隐藏域中方便操作*/
    $("#Countys").on("change",function(){
        /*$("#provincesINPUT").val($("#Provinces option:selected").text())
        $("#countyINPUT").val($("#Countys option:selected").text())
        $("#citysINPUT").val($("#Citys option:selected").text())*/
        $("input[name = 'receivingInfProvince']").val($("#Provinces option:selected").text())
        $("input[name = 'receivingInfCity']").val($("#Citys option:selected").text())
        $("input[name = 'receivingInfDistrict']").val($("#Countys option:selected").text())
    })

/*添加操作的点击事件*/
    $("#J_editAddrOk").on("click",function(){
        if(inputIsEmpty()){
            $.ajax({
                url:"/foreground/receivingInf/insert",
                type:"POST",
                data:JSON.stringify(transformJSON("checkoutForm")),
                // async: false,//设置为同步
                contentType: "application/json;charset=utf-8",
                success:function(data){
                    if(data.data){
                        /*刷新收货信息*/
                        receivingInfData();
                    }
                }
            })
        }
    })
    /*添加的数据验证是否为空*/
    function inputIsEmpty(){
        var yn = true;
        var Consignee = $("#Consignee").val();
        var Telephone = $("#Telephone").val();
        var Provinces = $("#Provinces option:selected").text();
        var Citys = $("#Citys option:selected").text();
        var Countys = $("#Countys option:selected").text();
        var Street = $("#Street").val();
        if(Consignee == null || Consignee == ""){yn = false; alert("姓名不可为空")}
        if(Telephone == null || Telephone == ""){yn = false;alert("联系电话不可为空")}
        if(Provinces == null || Provinces == ""){yn = false;alert("省份不可为空")}
        if(Citys == null || Citys == ""){yn = false;alert("城市不可为空")}
        if(Countys == null || Countys == ""){yn = false;alert("县城不可为空")}
        if(Street == null || Street == ""){yn = false;alert("详细地址不可为空")}
        return yn;
    }

/*删除操作的点击事件*/
$(".delCLZ").on("click",function(){
    if(confirm("确定删除吗？")){
        $.ajax({
            url:"/foreground/receivingInf/delete",
            type:"POST",
            data:JSON.stringify({"receivingInfId" : $(this).attr("receivingInfId")}),
            // async: false,//设置为同步
            contentType: "application/json;charset=utf-8",
            success:function(data){
                if(data.data){
                    /*刷新收货信息*/
                    receivingInfData();
                }
            }
        })
    }
})


//将表单数据转换成json数据
    function transformJSON(formID){
        var $jsonData = {};
        /*下面是将form表单的数据转换成一个json的数据格式*/
        $.each($("#"+ formID).serializeArray(), function(i,e){
            $jsonData[e.name] = e.value;
        })
        return $jsonData;
    }
}

