<%@ page language="java" import="com.mzsds.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>CSDN Spider - 用户</title>

<!-- 提示框 -->
<link rel="stylesheet" href="promptbox/demo/libs/bundled.css">
<link rel="stylesheet" type="text/css"
	href="promptbox/css/jquery-confirm.css" />
<!-- Bootstrap -->
<link href="vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- iCheck -->
<link href="vendors/iCheck/skins/flat/green.css" rel="stylesheet">
<!-- Datatables -->
<link href="vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="build/css/custom.min.css" rel="stylesheet">
</head>

<body>
	<script src="promptbox/demo/libs/bundled.js"></script>
	<script type="text/javascript" src="promptbox/js/jquery-confirm.js"></script>
	<!-- page content -->
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>用户列表</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a href="servlet/UserServlet?method=getUserList"><i
								class="fa fa-refresh"></i></a></li>
						<li><a href="servlet/UserServlet?method=addPage"><i
								class="glyphicon glyphicon-plus"></i> </a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<div class="row">
						<div class="col-sm-12">
							<div class="card-box table-responsive">
								<table id="datatable-keytable"
									class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>编号</th>
											<th>姓名</th>
											<th>性别</th>
											<th>电话</th>
											<th>状态</th>
											<th>添加时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${aclUserBOList }" var="User">
											<tr>
												<td>${User.userID }</td>
												<td>${User.userName }</td>
												<c:if test="${User.userSex ==1}">
													<td><span class="btn btn-round btn-dark btn-xs">男</span></td>
												</c:if>
												<c:if test="${User.userSex ==2 }">
													<td><span class="btn btn-round btn-info btn-xs">女</span></td>
												</c:if>
												<td>${User.userPhoneNumber }</td>
												<c:if test="${User.status ==1}">
													<td><span class="btn btn-primary btn-success btn-xs">正常使用</span></td>
												</c:if>
												<c:if test="${User.status ==2 }">
													<td><span class="btn btn-primary btn-danger btn-xs">禁止使用</span></td>
												</c:if>
												<td><fmt:formatDate value="${User.addTime }"
														pattern="yyyy-MM-dd HH:mm:ss" type="both" /></td>
												<td><a
													href="servlet/UserServlet?method=editUser&userID=${User.userID }"><i
														class="fa fa-pencil"></i> 编辑 </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<a id="${User.userID }" href="javascript:void(0)"
													class="example-the-3"><i class="fa fa-trash-o"> 删除</i>
												</a>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /page content -->

	<!-- jQuery -->
	<!-- <script src="vendors/jquery/dist/jquery.min.js"></script> -->
	<!-- Bootstrap -->
	<script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="vendors/nprogress/nprogress.js"></script>
	<!-- iCheck -->
	<script src="vendors/iCheck/icheck.min.js"></script>
	<!-- Datatables -->
	<script src="vendors/datatables.net/js/jquery.dataTables.min.js"></script>
	<script src="vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script
		src="vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
	<script
		src="vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
	<script src="vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
	<script src="vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
	<script src="vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
	<script
		src="vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
	<script
		src="vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
	<script
		src="vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
	<script
		src="vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
	<script src="vendors/jszip/dist/jszip.min.js"></script>
	<script src="vendors/pdfmake/build/pdfmake.min.js"></script>
	<script src="vendors/pdfmake/build/vfs_fonts.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="build/js/custom.min.js"></script>
	<!-- 提示框 -->
	<script type="text/javascript">
		$('.example-the-3')
				.on(
						'click',
						function() {
							var id = $(this).attr("id");
							$
									.confirm({
										theme : 'material',
										closeIcon : true,
										animation : 'scale',
										type : 'orange',
										content : '确认执行？',
										title : '提示',
										buttons : {
											确认 : {
												action : function() {
													window.location = "servlet/UserServlet?method=removeUser&userID="
															+ id;
												}
											},
											取消 : {
												action : function() {
												}
											}
										}
									});

						});
	</script>

</body>
</html>
