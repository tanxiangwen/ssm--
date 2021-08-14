<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
	<base href="http://localhost:8080/SSMProject/">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<c:if test="${empty sessionScope.user}">
					<a href="pages/user/login.jsp">登录</a>
					<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;

				</c:if>

					<a href="pages/cart/cart.jsp">购物车</a>
					<a href="pages/manager/manager.jsp">后台管理</a>

			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="PageByprice" method="get">
					<input type="hidden" name="pageNo" value="1">
					价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
						<input id="max" type="text" name="max" value="${param.max}"> 元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<c:if test="${ not empty sessionScope.cart.totalCount}">
					<span>您的购物车中有${sessionScope.cart.totalCount}件商品</span>
					<div>
						您刚刚将<span style="color: red">${requestScope.bookName}</span>加入到了购物车中
					</div>
				</c:if>


			</div>
			<c:forEach items="${sessionScope.Book}" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="static/img/default.jpg" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.name}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock}</span>
						</div>
						<div class="book_add">
							<button class="add" BookId="${book.id}">加入购物车</button>
						</div>
					</div>
				</div>


			</c:forEach>
			<script type="text/javascript">
				$(function(){
					$(".add").click(function(){
						var id=$(this).attr("BookId");
						location.href="${pageContext.request.contextPath}/additem?id="+id;


					});

				});
			</script>

		</div>
		
		<div id="page_nav">
			<c:if test="${sessionScope.pageInfo.hasPreviousPage}">
				<input type="hidden" value="${sessionScope.pageInfo.total}" id="hiddentotal"/>
				<input type="hidden" value="${sessionScope.pageInfo.firstPage}" id="hiddenfirst" />
				<a href="${requestScope.url}&pageNo=1">首页</a>
				<a href="${requestScope.url}&pageNo=${sessionScope.pageInfo.pageNum-1}">上一页</a>

			</c:if>

		<a href="#">3</a>
		【${sessionScope.pageInfo.pageNum}】
		<a href="#">5</a>
			<c:if test="${sessionScope.pageInfo.hasNextPage}">
				<a href="${requestScope.url}&pageNo=${sessionScope.pageInfo.nextPage}">下一页</a>
				<a href="${requestScope.url}&pageNo=${sessionScope.pageInfo.lastPage}">末页</a>
			</c:if>

		共${sessionScope.pageInfo.pages}页，${sessionScope.pageInfo.total}条记录 到第<input value="4" name="pn" id="pn_input"/>页
		<input type="button" id="confirm" value="确定">
		</div>
	
	</div>
	<script type="text/javascript">
		$(function(){
			$("#confirm").click(function(){
				var a=$("#pn_input").val();
				location.href="${pageContext.request.contextPath}/pagelist?pageNo="+a;
			});
		});


	</script>
	<script type="text/javascript">
		$(function(){
			$("#pn_input").blur(function(){
				var total=$("#hiddentotal").val();
				var first=$("#hiddenfirst").val();
				var a=$("#pn_input").val();

				if(a>total){
					alert("不在数据页数范围内");
				}
				 if (a<first){
					alert("非法值")
				}



			});


		});





	</script>
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>


</body>
</html>