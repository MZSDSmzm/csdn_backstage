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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>CSDN Spider - 登录</title>

<!-- Bootstrap -->
<link href="vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- Animate.css -->
<link href="vendors/animate.css/animate.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="build/css/custom.min.css" rel="stylesheet">
</head>

<body class="login">
	<div>
		<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor"
			id="signin"></a>
		<div class="login_wrapper">
			<div class="animate form login_form">
				<section class="login_content">
					<form action="servlet/Main?method=MZSDS" method="post">
						<div>
							<h1>
								<i class="fa fa-paw"></i> CSDN Spider !
							</h1>
						</div>
						<div>
							<input type="text" name="username" class="form-control"
								placeholder="用户名" required="" />
						</div>
						<div>
							<input type="password" name="password" class="form-control"
								placeholder="密    码" required="" />
						</div>
						<input type="submit" class="btn btn-default submit"
							value="登
							录">&nbsp;&nbsp;&nbsp;<input type="reset"
							class="btn btn-default submit" value="重 置">

						<div class="clearfix"></div>

						<div class="separator">
							<div class="clearfix">
								<c:if test="${status == 0 }">用户不存在,请重新输入！</c:if>
								<c:if test="${status == 2 }">密码错误,请重试！</c:if>
								<c:if test="${status == 3 }">登录异常！</c:if>
								<c:if test="${status == 4 }">用户等待审核中，请在审核后登陆！</c:if>
							</div>
							<br />
						</div>
					</form>
				</section>
			</div>
		</div>
	</div>
</body>
</html>
