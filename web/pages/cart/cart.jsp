<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<base href="http://localhost:8080/SSMProject/">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<div>
				<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
				<a href="pages/order/order.jsp">我的订单</a>
				<a href="loginOut">注销</a>&nbsp;&nbsp;
				<a href="index.jsp">返回</a>
			</div>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${sessionScope.cart.item}" var="cart1">
				<tr>
					<td>${cart1.value.name}
					</td>
					<td>

						<button type="button" class="btn btn-primary btn-sm "
								onclick="insc()">+</button>
						<button type="button" <%--class="btn btn-sm"--%> <%--id="ps"--%>
								class="count" Ids="${cart1.value.id}">${cart1.value.count}</button>
						<button type="button" class="btn btn-primary btn-sm "
								onclick="dec()">-</button>
					</td>
					<td>${cart1.value.price}</td>
					<td>${cart1.value.priceTotal}</td>
					<td><a href="${pageContext.request.contextPath}/delete?id=${cart1.value.id}">删除</a></td>
				</tr>
			</c:forEach>

		</table>
		<script type="text/javascript">
			function insc() {
				var id=$(".count").attr("Ids")
				var count=document.getElementsByClassName("count")[0].innerHTML;
				//var count=$(".count").val();
				//alert(count);
				//document.getElementsByClassName("count").innerHTML=parseInt(count)+1;
				$(".count").val(parseInt(count)+1);
				//var newcount=document.getElementsByClassName("count").innerHTML;
				var newcount=$(".count").val();
				//var id=document.getElementById("ps").getAttribute("Id");
				location.href="${pageContext.request.contextPath}/update?id="+id+"&count="+newcount;

			}
			function dec() {
				//var count=document.getElementsByClassName("count").innerHTML;
				var id=$(".count").attr("Ids")
				var count=document.getElementsByClassName("count")[0].innerHTML;
				if(parseInt(count)>0){
					//document.getElementsByClassName("count").innerHTML=parseInt(count)-1;
					$(".count").val(parseInt(count)-1);
					var newcount=$(".count").val();
				//	var newcount=document.getElementsByClassName("count").innerHTML;
					//var id=document.getElementsByClassName("count").getAttribute("Ids");
					//var id=document.getElementById("ps").getAttribute("Id");
					location.href="${pageContext.request.contextPath}/update?id="+id+"&count="+newcount;
				};

			}
		</script>
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a href="clear">清空购物车</a></span>
			<span class="cart_span"><a href="order">去结账</a></span>
		</div>
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
<script type="text/javascript">
</script>
</body>
</html>