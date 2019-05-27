<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf8">
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/jQuery/jquery.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/bookInfo/bookInfo.js"></script>
		
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/common.css" />
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/bookInfo/bookInfo.css" />
			
		<title>showBookInfos</title>
	</head>
	<body>
		<div class="container">
			<h1>showBookInfos</h1>
		</div>
		
		<div class="div-table">
			<table class="table table-striped">
				<thead>
			        <tr>
			          <th>序号</th>
			          <th>书名</th>
			          <th>作者</th>
			          <th>ISBN</th>
			          <th>价格</th>
			          <th>操作</th>
			        </tr>
	      		</thead>
	      		<tbody>
					<c:forEach items="${bookInfos}" var="bookInfo" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td>${bookInfo.name}</td>
							<td>${bookInfo.author}</td>
							<td>${bookInfo.isbn}</td>
							<td>${bookInfo.price}</td>
							<td>
								<a href="#" onclick="deleteBookInfo('${bookInfo.id}')" class="btn btn-sm btn-danger">
									删除
								</a>
								<button type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#modifyModal" onclick="modifyFun('${bookInfo.id}','${bookInfo.name}','${bookInfo.author}','${bookInfo.isbn}','${bookInfo.price}')">
									修改
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="container div-return">
			<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#createModal">
			添加记录
			</button>
		</div>
		
		<!-- 添加记录弹出框 -->
		<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="createModalLabel">
			 <div class="modal-dialog" role="document">
			 	<div class="modal-content">
			 		<form action="createBookInfo" method="post" class="form-horizontal">
				 		<div class="modal-header">
				 			<h4 class="modal-title" id="createModalLabel">添加记录</h4>
				 		</div>
				 		
				 		<div class="modal-body">
				        	<div class="form-group">
							    <label for="name" class="col-sm-2 control-label">书名</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="name" name="name" placeholder="书名">
							    </div>
						  	</div>
						  	<div class="form-group">
							    <label for="author" class="col-sm-2 control-label">作者</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="author" name="author" placeholder="作者">
							    </div>
						  	</div>
						  	<div class="form-group">
							    <label for="isbn" class="col-sm-2 control-label">ISBN</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="isbn" name="isbn" placeholder="xxx-x-xxxx-xxxx-x">
							    </div>
						  	</div>
						  	<div class="form-group">
							    <label for="price" class="col-sm-2 control-label">价格</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="price" name="price" placeholder="0.00">
							    </div>
						  	</div>
				      	</div>
				      	
				      	<div class="modal-footer">
				        	<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
				        	<button type="submit" class="btn btn-primary">提交</button>
				      	</div>
			      	</form>
			 	</div><!-- modal-content -->
			 </div><!-- modal-dialog -->
		</div><!-- modal -->
		
		<div hidden="hidden">
			<form id="deleteForm" name="deleteForm" method="post" action="destroyBookInfo">
				<input type="text" id="id" name="id" />
			</form>
		</div>
		
		<!-- 修改记录弹出框 -->
		<div class="modal fade" id="modifyModal" tabindex="-1" role="dialog" aria-labelledby="modifyModalLabel">
			 <div class="modal-dialog" role="document">
			 	<div class="modal-content">
			 		<form id="modifyForm" name="modifyForm" action="modifyBookInfo" method="post" class="form-horizontal">
				 		<div class="modal-header">
				 			<h4 class="modal-title" id="modifyModalLabel">修改记录</h4>
				 		</div>
				 		
				 		<div class="modal-body">
				        	<div class="form-group">
							    <label for="name" class="col-sm-2 control-label">书名</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="name" name="name" placeholder="书名">
							    </div>
						  	</div>
						  	<div class="form-group">
							    <label for="author" class="col-sm-2 control-label">作者</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="author" name="author" placeholder="作者">
							    </div>
						  	</div>
						  	<div class="form-group">
							    <label for="isbn" class="col-sm-2 control-label">ISBN</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="isbn" name="isbn" placeholder="xxx-x-xxxx-xxxx-x">
							    </div>
						  	</div>
						  	<div class="form-group">
							    <label for="price" class="col-sm-2 control-label">价格</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="price" name="price" placeholder="0.00">
							    </div>
						  	</div>
						  	<input type="hidden" id="id" name="id">
				      	</div>
				      	
				      	<div class="modal-footer">
				        	<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
				        	<button type="submit" class="btn btn-primary">提交</button>
				      	</div>
			      	</form>
			 	</div><!-- modal-content -->
			 </div><!-- modal-dialog -->
		</div><!-- modal -->
		
		<div class="container div-return">
			<a class="btn btn-lg btn-primary btn-block" href="${pageContext.request.contextPath}">返回</a>
		</div>
	</body>
</html>