<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<base href="http://localhost:8080/SSMProject/">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			return confirm("确定要删除["+$(this).parent().parent().find("td:first").text()+"]数据吗");
			return false;

		});

	});
</script>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<div>
				<a href="listBook?pageNo=1">图书管理</a>
				<a href="order_manager.jsp">订单管理</a>
				<a href="client/index.jsp">返回商城</a>
			</div>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${sessionScope.book}" var="i">
				<tr>
					<td>${i.name}</td>
					<td>${i.price}</td>
					<td>${i.author}</td>
					<td>${i.sales}</td>
					<td>${i.stock}</td>
					<td><a href="showBook?id=${i.id}">修改</a></td>
					<td><a href="deleteBook?id=${i.id}" class="delete">删除</a></td>
				</tr>

			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_add.jsp">添加图书</a></td>
			</tr>	
		</table>
		<div id="page_nav">
			<c:if test="${sessionScope.pageInfoBook.hasPreviousPage}">
				<a href="listBook?pageNo=1">首页</a>
				<a href="listBook?pageNo=${sessionScope.pageInfoBook.pageNum-1}">上一页</a>
			</c:if>
			<input type="hidden" value="${sessionScope.pageInfoBook.total}" id="hiddentotal"/>
			<input type="hidden" value="${sessionScope.pageInfoBook.firstPage}" id="hiddenfirst" />

			<a href="listBook&pageNo=3">3</a>
			【${sessionScope.pageInfoBook.pageNum}】
			<a href="listBook?pageNo=5">5</a>
			<c:if test="${sessionScope.pageInfoBook.hasNextPage}">
				<a href="listBook?pageNo=${sessionScope.pageInfoBook.nextPage}">下一页</a>
				<a href="listBook?pageNo=${sessionScope.pageInfoBook.lastPage}">末页</a>
			</c:if>

			共${sessionScope.pageInfoBook.pages}页，${sessionScope.pageInfoBook.total}条记录 到第<input value="4" name="pn" id="pn_input"/>页
			<input type="button" id="confirm" value="确定">
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			$("#confirm").click(function(){
				var a=$("#pn_input").val();
				location.href="${pageContext.request.contextPath}/listBook?pageNo="+a;
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