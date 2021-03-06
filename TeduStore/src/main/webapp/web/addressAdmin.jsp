<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="stylesheet"/>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
</head>
<body>
<!-- 页面顶部-->
<%@ include file="head.jsp" %>
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
   <%@ include file="left.jsp" %>
   <!-- 右边栏-->
    <div class="rightsidebar_box rt">	
        <!--标题栏-->
        <div class="rs_header">
            <span class="address_title">收获地址管理</span>
        </div>
        <!--收货人信息填写栏-->
        <div class="rs_content">
        	<form id="add_form" method="post" action="">
        		<input type="hidden" name="id" id="id" >
	            <!--收货人姓名-->
	            <div class="recipients">
	                <span class="red">*</span><span class="kuan">收货人：</span><input type="text" name="receiverName" id="receiverName"/>
	            </div>
	            <!--收货人所在城市等信息-->
	            <div  class="address_content">
					 <span class="red">*</span><span class="kuan">省&nbsp;&nbsp;份：</span><select data-province="---- 选择省 ----" name="receiverState" id="receiverState"></select>
					  城市：<select data-city="---- 选择市 ----" name="receiverCity" id="receiverCity"></select>
					  区/县：<select data-district="---- 选择区 ----" name="receiverDistrict" id="receiverDistrict"></select>
				</div> 
	            
	            
	            <!--收货人详细地址-->
	            <div class="address_particular">
	                <span class="red">*</span><span class="kuan">详细地址：</span><textarea name="receiverAddress" id="receiverAddress" cols="60" rows="3" placeholder="建议您如实填写详细收货地址"></textarea>
	            </div>
	            <!--收货人地址-->
	            <div class="address_tel">
	                <span class="red">*</span><span class="kuan">手机号码：</span><input type="tel" id="receiverMobile" name="receiverMobile"/>固定电话：<input type="text" name="receiverPhone" id="receiverPhone"/>
	            </div>
	            <!--邮政编码-->
	            <div class="address_postcode">
	                <span class="red">&nbsp;</span class="kuan"><span>邮政编码：</span>&nbsp;<input type="text" name="receiverZip" id="receiverZip"/>
	            </div>
	            <!--地址名称-->
	            <div class="address_name">
	                <span class="red">&nbsp;</span class="kuan"><span>地址名称：</span>&nbsp;<input type="text" id="addressName" name="addressName"/>如：<span class="sp">家</span><span class="sp">公司</span><span class="sp">宿舍</span>
	            </div>
	            <!--保存收货人信息-->
	            <div class="save_recipient" >
	                保存收货人信息
	            </div>
	
    		</form>
            <!--已有地址栏-->
            <div class="address_information_manage">
                
            </div>
        </div>
    </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
             <p class="footer1"><img src="../images/footer/logo.png" alt="" class=" footLogo"/></p>
             <p class="footer2"><img src="../images/footer/footerFont.png" alt=""/></p>
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../images/footer/wechat.png" alt=""/>
                    <img src="../images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="../images/footer/ios.png" class="lf">
            <img src="../images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../images/footer/erweima.png">
        </div>
		<!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
<script type="text/javascript" src="../js/distpicker.data.js"></script>
<script type="text/javascript" src="../js/distpicker.js"></script>
<script type="text/javascript" src="../js/personal.js"></script>
<script type="text/javascript">
	$(".lxdh_normal").each(function(i,e) {
		var phone = $(e).html();
		$(e).html(changePhone(phone));
	});
</script>
<script type="text/javascript">
	//当页面加载完毕,则会运行匿名函数里的代码
	$(function(){
		getProvinceFun(-1,-1,-1);
		getAllAddress();
	});
	//删除收货人的信息
	function removeAddress(id){
		$.ajax({
			url:"${pageContext.request.contextPath}/address/removeAddress.do",
			data:"id="+id,
			type:"get",
			dataType:"json",
			success:function(obj){
				alert(obj.message);
				getAllAddress();
			}
		});
	}
	//显示收货人地址信息
	function goUpdate(id){
		$.ajax({
			url:"${pageContext.request.contextPath}/address/goUpdate.do",
			data:"id="+id,
			type:"get",
			dataType:"json",
			success:function(obj){
				//显示文本框的数据
				$("#receiverName").val(obj.data.recvName);
				$("#receiverAddress").val(obj.data.recvAddress);
				$("#receiverMobile").val(obj.data.recvPhone);
				$("#receiverPhone").val(obj.data.recvTel);
				$("#receiverZip").val(obj.data.recvZip);
				$("#addressName").val(obj.data.recvTag);
				//给隐藏表单域赋值
				$("#id").val(obj.data.id);
				//显示三级联动菜单
				getProvinceFun(obj.data.recvProvince,obj.data.recvCity,obj.data.recvArea);
				//把保存收货人信息改为修改收货人信息
				$(".save_recipient").text("修改收货人信息");
			}
		});
	}
	//显示登录用户的收货地址
	function getAllAddress(){
		$.ajax({
			url:"${pageContext.request.contextPath}/address/getAddress.do",
			data:"",
			type:"get",
			dataType:"json",
			success:function(obj){
				//设置表格的标题
				var header ='<div class="aim_title">'+
                '<span class="dzmc dzmc_title">地址名称</span><span class="dzxm dzxm_title">姓名</span><span class="dzxq dzxq_title">地址详情</span><span class="lxdh lxdh_title">联系电话</span><span class="operation operation_title">操作</span>'+
            	'</div>';
            	$(".address_information_manage").html(header);
				for(var i=0;i<obj.data.length;i++){
					//表示默认地址
					if(obj.data[i].isDefault==1){
						var str1 ='<div class="aim_content_one aim_active">'+
		                 '<span class="dzmc dzmc_active">'+obj.data[i].recvTag+'</span>'+
		                 '<span class="dzxm dzxm_normal">'+obj.data[i].recvName+'</span>'+
		                 '<span class="dzxq dzxq_normal">'+obj.data[i].recvDistrict+obj.data[i].recvAddress+'</span>'+
		                 '<span class="lxdh lxdh_normal">'+obj.data[i].recvPhone+'</span>'+
		                 '<span class="operation operation_normal">'+
		                 '<span class="aco_change" onclick="goUpdate('+obj.data[i].id+')">修改</span>|<span class="aco_delete" onclick="removeAddress('+obj.data[i].id+')">删除</span>'+
		                 '</span>'+
		                 '<span class="swmr swmr_normal" id="'+obj.data[i].id+'"></span>'+
		             	'</div>';
		             	$(".address_information_manage").append(str1);
					}else{
						//表示非默认地址
						var str2='<div class="aim_content_two">'+
		                 '<span class="dzmc dzmc_normal">'+obj.data[i].recvTag+'</span>'+
		                 '<span class="dzxm dzxm_normal">'+obj.data[i].recvName+'</span>'+
		                 '<span class="dzxq dzxq_normal">'+obj.data[i].recvDistrict+obj.data[i].recvAddress+'</span>'+
		                 '<span class="lxdh lxdh_normal">'+obj.data[i].recvPhone+'</span>'+
		                 '<span class="operation operation_normal">'+
		                 '<span class="aco_change" onclick="goUpdate('+obj.data[i].id+')">修改</span>|<span class="aco_delete" onclick="removeAddress('+obj.data[i].id+')">删除</span>'+
		                 '</span>'+
		                 '<span class="swmr swmr_normal" id="'+obj.data[i].id+'">设为默认</span>'+
		             '</div>';
		                 $(".address_information_manage").append(str2);
					}
				}
				//设为默认的点击事件
				$(".swmr_normal").click(function(){
					$.ajax({
						url:"${pageContext.request.contextPath}/address/setDefault.do",
						//获取点击节点id的属性值
						data:"id="+$(this).attr("id"),
						type:"get",
						dataType:"json",
						success:function(obj){
							alert(obj.message);
						}
					});
					setDefault(this);
				});
			}
		});
	}
	//当市选择框发生改变时
	 $("#receiverCity").change(function(){
		getArea($("#receiverCity").val(),-1);
	});
	//异步请求,获取县区信息
	function getArea(cityCode,areaCode){
		$.ajax({
			url:"${pageContext.request.contextPath}/dict/getArea.do",
			data:"cityCode="+cityCode,
			type:"get",
			dataType:"json",
			success:function(obj){
				$("#receiverDistrict").html("<option>--请选择--</option>");
				for(var i=0;i<obj.data.length;i++){
					$("#receiverDistrict").append(new Option(obj.data[i].areaName,obj.data[i].areaCode));
				}
				if(areaCode!=-1){
					$("#receiverDistrict").val(areaCode);
				}
			}
		});
	}
	//当省份选择框发生改变时
	 $("#receiverState").change(function(){
		getCity($("#receiverState").val(),-1,-1);
	}); 
	//异步请求,获取城市信息
	function getCity(provinceCode,cityCode,areaCode){
		$.ajax({
			url:"${pageContext.request.contextPath}/dict/getCity.do",
			data:"provinceCode="+provinceCode,
			type:"get",
			dataType:"json",
			success:function(obj){
				$("#receiverCity").html("<option>--请选择--</option>");
				for(var i=0;i<obj.data.length;i++){
					$("#receiverCity").append(new Option(obj.data[i].cityName,obj.data[i].cityCode));
				}
				if(cityCode!=-1){
					$("#receiverCity").val(cityCode);
				}
				getArea(cityCode,areaCode);
			}
		});
	}
	//异步请求,获取省份信息
	function getProvinceFun(provinceCode,cityCode,areaCode){
		$.ajax({
			url:"${pageContext.request.contextPath}/dict/getProvince.do",
			data:"",
			type:"get",
			dataType:"json",
			success:function(obj){
				$("#receiverState").html("<option>..请选择..</option>");
				for(var i=0;i<obj.data.length;i++){
					$("#receiverState").append(new Option(obj.data[i].provinceName,obj.data[i].provinceCode));
				}
				//表示选择的省处于被选中状态
				if(provinceCode!=-1){
					$("#receiverState").val(provinceCode);
				}
				//显示该省的所有城市
				getCity(provinceCode,cityCode,areaCode);
			}
		});
	}
</script>
<script type="text/javascript">
	//处理侧边栏
	$(function(){
		//表示四个标题的列表项同时隐藏,
		$("#leftsidebar_box dd").hide();
		//地址管理列表项显示
	    $("#leftsidebar_box .address dd").show();
		//表示4个标题的图片都设置为myOrder2.png
        $("#leftsidebar_box dt img").attr("src","../images/myOrder/myOrder2.png");
		//地址管理的图片设置为myOrder1.png
        $("#leftsidebar_box .address").find('img').attr("src","../images/myOrder/myOrder1.png");
	});
</script>
</html>