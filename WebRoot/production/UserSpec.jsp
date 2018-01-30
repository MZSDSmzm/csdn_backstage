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
<!-- bootstrap-wysiwyg -->
<link href="vendors/google-code-prettify/bin/prettify.min.css"
	rel="stylesheet">
<!-- Select2 -->
<link href="vendors/select2/dist/css/select2.min.css" rel="stylesheet">
<!-- Switchery -->
<link href="vendors/switchery/dist/switchery.min.css" rel="stylesheet">
<!-- starrr -->
<link href="vendors/starrr/dist/starrr.css" rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link href="vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="build/css/custom.min.css" rel="stylesheet">
</head>

<body>
	<script src="promptbox/demo/libs/bundled.js"></script>
	<script type="text/javascript" src="promptbox/js/jquery-confirm.js"></script>
	<!-- jQuery -->
	<!-- <script src="vendors/jquery/dist/jquery.min.js"></script> -->
	<!-- Bootstrap -->
	<script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="vendors/nprogress/nprogress.js"></script>
	<!-- bootstrap-progressbar -->
	<script
		src="vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<!-- iCheck -->
	<script src="vendors/iCheck/icheck.min.js"></script>
	<!-- bootstrap-daterangepicker -->
	<script src="vendors/moment/min/moment.min.js"></script>
	<script src="vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
	<!-- bootstrap-wysiwyg -->
	<script src="vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
	<script src="vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
	<script src="vendors/google-code-prettify/src/prettify.js"></script>
	<!-- jQuery Tags Input -->
	<script src="vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
	<!-- Switchery -->
	<script src="vendors/switchery/dist/switchery.min.js"></script>
	<!-- Select2 -->
	<script src="vendors/select2/dist/js/select2.full.min.js"></script>
	<!-- Parsley -->
	<script src="vendors/parsleyjs/dist/parsley.min.js"></script>
	<!-- Autosize -->
	<script src="vendors/autosize/dist/autosize.min.js"></script>
	<!-- jQuery autocomplete -->
	<script
		src="vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
	<!-- starrr -->
	<script src="vendors/starrr/dist/starrr.js"></script>
	<!-- Custom Theme Scripts -->
	<script src="build/js/custom.min.js"></script>
	<!-- page content -->
	<div class="container body">
		<div class="right_col" role="main">
			<div class="">
				<div class="clearfix"></div>
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>用户列表</h2>
								<ul class="nav navbar-right panel_toolbox">
									<li><a id="function-quite" class="example-the-3"><i
											class="glyphicon glyphicon-chevron-left"></i> </a></li>
								</ul>

								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<br />
								<form  id="demo-form2"  action="servlet/UserServlet?method=addUser" method="post"
									class="form-horizontal form-label-left" novalidate>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12"
											for="id">编&nbsp;&nbsp;&nbsp;号 <span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<input id="id" readonly="readonly"
												class="form-control col-md-7 col-xs-12"
												data-validate-length-range="6" data-validate-words="2"
												name="userID" value="${aclUserBO.userID }"
												 type="text">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12"
											for="name">姓&nbsp;&nbsp;&nbsp;名 <span
											class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<input id="userName" class="form-control col-md-7 col-xs-12"
												data-validate-length-range="6" data-validate-words="2"
												name="userName" value="${aclUserBO.userName }"
												required="required" type="text">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12"
											for="password">密&nbsp;&nbsp;&nbsp;码 <span
											class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<input type="text" id="name" name="userPassword"
												value="${aclUserBO.userPassword }" required="required"
												class="form-control col-md-7 col-xs-12">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12"
											for="telephone">电&nbsp;&nbsp;&nbsp;话 <span
											class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<input type="tel" id="phoneNumber" name="userPhoneNumber"
												value="${aclUserBO.userPhoneNumber }" required="required"
												data-validate-length-range="8,20"
												class="form-control col-md-7 col-xs-12">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12"
											for="sex">性&nbsp;&nbsp;&nbsp;别 <span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12" >
											<select class="form-control col-md-7 col-xs-12" 
												name="userSex">
												<option value=1 
													<c:if test="${aclUserBO.userSex ==1}">selected='selected'</c:if>>男</option>
												<option value=2
													<c:if test="${aclUserBO.userSex ==2}">selected='selected'</c:if>>女</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12"
											for="sex">状&nbsp;&nbsp;&nbsp;态 <span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<select class="form-control col-md-7 col-xs-12" name="status">
												<option value=2
													<c:if test="${aclUserBO.status ==2}">selected='selected'</c:if>>等待审核</option>
												<option value=1
													<c:if test="${aclUserBO.status ==1}">selected='selected'</c:if>>通过审核</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12"
											for="time">时&nbsp;&nbsp;&nbsp;间 <span
											class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12" style="width:58%">
											<fmt:formatDate var="nowDate" value="${aclUserBO.addTime }"
												pattern="yyyy-MM-dd HH:mm:ss" type="both" />
											<input id="addTime" value="${nowDate}" name="addTime"
												class="control-label col-md-3 col-sm-3 col-xs-12"
												data-date-format="yyyy-mm-dd HH:mm:ss">
											<div class="col-md-6 col-md-offset-3">
												<button type="reset" class="btn btn-primary">重置</button>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<button id="function-save" type="submit"
													class="btn btn-success">提交</button>
											</div>
										</div>

									</div>
									<div class="ln_solid"></div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /page content -->
	<script type="text/javascript">
		function sumbit_sure() {
			var gnl = confirm("确定要提交?");
			if (gnl == true) {
				return true;
			} else {
				return false;
			}
		}
	</script>

	<script src="vendors/laydate/laydate.js"></script>
	<!-- 日期插件，改成你的路径 -->
	<script>
		//执行一个laydate实例
		laydate.render({
			elem : '#addTime',
			type : 'datetime',
		});
	</script>
	<!-- 提示框 -->
	<script type="text/javascript">
		$('.example-the-3')
				.on(
						'click',
						function() {
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
													window.location = "servlet/UserServlet?method=getUserList";
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
