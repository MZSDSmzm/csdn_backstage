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

<title>CSDN Spider</title>

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

<!-- bootstrap-progressbar -->
<link
	href="vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet">
<!-- JQVMap -->
<link href="vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet" />
<!-- bootstrap-daterangepicker -->
<link href="vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="servlet/Main?method=HOME" class="site_title" target='cont'><i
							class="fa fa-paw"></i> &nbsp;&nbsp;<span>CSDN Spider!</span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img src="production/images/img.jpg" alt="..."
								class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Welcome,</span>
							<h2>${aclUserBO.userName }</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<!--<h3>Menu Bar</h3>-->
							<ul class="nav side-menu">
								<li><a href="servlet/Main?method=HOME" target='cont'><i
										class="fa fa-laptop"></i> 我的首页 </a></li>
								<li><a href="servlet/UserServlet?method=getUserList"
									target='cont'><i class="fa fa-graduation-cap"></i> 用户列表 </a></li>
								<li><a><i class="fa fa-table"></i> 极客头条<span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_news"
											target='cont'>业界</a></li>
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_language"
											target='cont'>语言</a></li>
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_frontend"
											target='cont'>前端</a></li>
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_cloud"
											target='cont'>云计算</a></li>
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_bigdata"
											target='cont'>大数据</a></li>
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_iot"
											target='cont'>物联网</a></li>
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_database"
											target='cont'>数据库</a></li>
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_ai"
											target='cont'>人工智能</a></li>
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_mobile"
											target='cont'>移动开发</a></li>
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_tools"
											target='cont'>研发工具</a></li>
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_se"
											target='cont'>软件工程</a></li>
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_career"
											target='cont'>程序人生</a></li>
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_osproject"
											target='cont'>开源项目</a></li>
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_game"
											target='cont'>游戏与图像</a></li>
										<li><a
											href="servlet/JkttServlet?method=getModularList&type=jktt_os"
											target='cont'>系统网络安全</a></li>
									</ul></li>
								<li><a><i class="fa fa-table"></i> 主要论坛<span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a
											href="servlet/ForumServlet?method=getModularList&type=forum_java"
											target='cont'>Java</a></li>
										<li><a
											href="servlet/ForumServlet?method=getModularList&type=forum_linux"
											target='cont'>Linux</a></li>
										<li><a
											href="servlet/ForumServlet?method=getModularList&type=forum_enterprise"
											target='cont'>企业IT</a></li>
										<li><a
											href="servlet/ForumServlet?method=getModularList&type=forum_cloudcomputing"
											target='cont'>云计算</a></li>
										<li><a
											href="servlet/ForumServlet?method=getModularList&type=forum_webdevelop"
											target='cont'>Web开发</a></li>
										<li><a
											href="servlet/ForumServlet?method=getModularList&type=forum_dotnet"
											target='cont'>.NET技术</a></li>
										<li><a
											href="servlet/ForumServlet?method=getModularList&type=forum_mobile"
											target='cont'>移动开发</a></li>
										<li><li><a
											href="servlet/ForumServlet?method=getModularList&type=forum_windows"
											target='cont'>Windows专区</a></li>
										<li><a
											href="servlet/ForumServlet?method=getModularList&type=forum_embedded"
											target='cont'>硬件/嵌入开发</a></li>

									</ul></li>
								<li><a><i class="fa fa-bar-chart-o"></i> 头条图表 <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="production/chartjs.jsp" target='cont'>未完待续...</a></li>
									</ul></li>
								<li><a><i class="fa fa-bar-chart-o"></i> 论坛图表 <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="production/chartjs.jsp" target='cont'>未完待续...</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="设置">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="全屏">
							<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="锁定"> <span
							class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="注销"
							href="servlet/LoginServlet?method=loginOut"> <span
							class="glyphicon glyphicon-off" aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i></a>
						</div>
						<ul class="nav navbar-nav navbar-right">
							<li class=""><a class="user-profile dropdown-toggle"
								data-toggle="dropdown" aria-expanded="false"> <img
									src="production/images/img.jpg" alt="">${aclUserBO.userName }
									<span class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a>信息 </a></li>
									<li><a>帮助</a></li>
									<li><a href="servlet/LoginServlet?method=loginOut"><i
											class="fa fa-sign-out pull-right"></i> 退出登陆</a></li>
								</ul></li>

							<li role="presentation" class="dropdown"><a
								class="dropdown-toggle info-number" data-toggle="dropdown"
								aria-expanded="false"> <i class="fa fa-envelope-o"></i> <span
									class="badge bg-green">1</span>
							</a>
								<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
									role="menu">
									<li><a> <span class="image"><img
												src="production/images/img.jpg" alt="Profile Image" /></span> <span>
												<span>${aclUserBO.userName }</span> <span class="time"></span>
										</span> <span class="message"> 看看就好了，想点击那是不可能的... </span>
									</a></li>
									<li>
										<div class="text-center">
											<a> <strong>查看所有</strong> <i class="fa fa-angle-right"></i>
											</a>
										</div>
									</li>
								</ul></li>
						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->
			<div class="right_col" role="main">
				<iframe id="mainFrame" name="cont" scrolling="no" src=""
					frameborder="0" style="padding: 0px; width: 100%; height: 730px;"></iframe>
			</div>
			<!-- footer content -->
			<footer>
				<div class="pull-right">
					总是感觉人要有自己的一些想法。不管怎样，每个人都应该有所奢求，没有欲望的人生无疑是枯燥无味的；追求使得社会进步，不管别人看来这种追求是否可笑。——
					MZSDS</div>
				<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->
		</div>
	</div>

	<!-- jQuery -->
	<script src="vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="vendors/nprogress/nprogress.js"></script>
	<!-- Chart.js -->
	<script src="vendors/Chart.js/dist/Chart.min.js"></script>
	<!-- gauge.js -->
	<script src="vendors/gauge.js/dist/gauge.min.js"></script>
	<!-- bootstrap-progressbar -->
	<script
		src="vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<!-- iCheck -->
	<script src="vendors/iCheck/icheck.min.js"></script>
	<!-- Skycons -->
	<script src="vendors/skycons/skycons.js"></script>
	<!-- Flot -->
	<script src="vendors/Flot/jquery.flot.js"></script>
	<script src="vendors/Flot/jquery.flot.pie.js"></script>
	<script src="vendors/Flot/jquery.flot.time.js"></script>
	<script src="vendors/Flot/jquery.flot.stack.js"></script>
	<script src="vendors/Flot/jquery.flot.resize.js"></script>
	<!-- Flot plugins -->
	<script src="vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
	<script src="vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
	<script src="vendors/flot.curvedlines/curvedLines.js"></script>
	<!-- DateJS -->
	<script src="vendors/DateJS/build/date.js"></script>
	<!-- JQVMap -->
	<script src="vendors/jqvmap/dist/jquery.vmap.js"></script>
	<script src="vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
	<script src="vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
	<!-- bootstrap-daterangepicker -->
	<script src="vendors/moment/min/moment.min.js"></script>
	<script src="vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="build/js/custom.min.js"></script>
	<script type="text/javascript">
		startInit('mainFrame', 73);

		var browserVersion = window.navigator.userAgent.toUpperCase();
		var isOpera = browserVersion.indexOf("OPERA") > -1 ? true : false;
		var isFireFox = browserVersion.indexOf("FIREFOX") > -1 ? true : false;
		var isChrome = browserVersion.indexOf("CHROME") > -1 ? true : false;
		var isSafari = browserVersion.indexOf("SAFARI") > -1 ? true : false;
		var isIE = (!!window.ActiveXObject || "ActiveXObject" in window);
		var isIE9More = (!-[ 1, ] == false);
		function reinitIframe(iframeId, minHeight) {
			try {
				var iframe = document.getElementById(iframeId);
				var bHeight = 0;
				if (isChrome == false && isSafari == false)
					bHeight = iframe.contentWindow.document.body.scrollHeight;

				var dHeight = 0;
				if (isFireFox == true)
					dHeight = iframe.contentWindow.document.documentElement.offsetHeight + 2;
				else if (isIE == false && isOpera == false)
					dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
				else if (isIE == true && isIE9More) {//ie9+
					var heightDeviation = bHeight
							- eval("window.IE9MoreRealHeight" + iframeId);
					if (heightDeviation == 0) {
						bHeight += 3;
					} else if (heightDeviation != 3) {
						eval("window.IE9MoreRealHeight" + iframeId + "="
								+ bHeight);
						bHeight += 3;
					}
				} else
					//ie[6-8]、OPERA
					bHeight += 3;
				var height = Math.max(bHeight, dHeight);
				if (height < minHeight)
					height = minHeight;

				iframe.style.height = height - 20 + "px";
			} catch (ex) {
			}
		}
		function startInit(iframeId, minHeight) {
			eval("window.IE9MoreRealHeight" + iframeId + "=0");
			window.setInterval("reinitIframe('" + iframeId + "'," + minHeight
					+ ")", 100);
		}
	</script>
</body>
</html>
