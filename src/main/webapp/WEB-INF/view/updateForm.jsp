<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>ADMIN</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="/Nexus/resources/css/adminStyle.css" />
</head>
<body>

	<nav class="navbar navbar-default navbar-static-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"> Brand </a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-left" method="GET" role="search">
				<div class="form-group">
					<input type="text" name="q" class="form-control"
						placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">
					<i class="glyphicon glyphicon-search"></i>
				</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.html" target="_blank">Visit Site</a></li>
				<li class="dropdown "><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">
						Account <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li class="dropdown-header">Name</li>
						<li class=""><a href="#">Edit Information</a></li>
						<li class="divider"></li>
						<li><a href="#">Logout</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<div class="container-fluid main-container">
		<div class="col-md-2 sidebar">
			<ul class="nav nav-pills nav-stacked">
				<li><a href="/Nexus">Home</a></li>
				<li class="active"><a href="/Nexus/admin/listUsers">Update
						users</a></li>
				<li><a href="/Nexus/admin/addUser">Add new user</a></li>
				<li><a href="#">Link</a></li>
				<li><a href="#">Link</a></li>
			</ul>
		</div>
		<div class="col-md-10 content">
			<div class="panel panel-default">
				<div class="panel-heading">Dashboard</div>
				<div class="panel-body">
					<div class="main-login main-center">
						<form id="updateuserform" class="" method="post" action="#">

							<input type="hidden" name="id" id="updateuserid"
								value="" />


							<div class="form-group">
								<label for="name" class="cols-sm-2 control-label">Your
									Name</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-user fa" aria-hidden="true"></i></span> <input
											type="text" class="form-control" name="updatename" id="updatename"
											placeholder="Enter your Name" value="helloworld" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="email" class="cols-sm-2 control-label">Your
									Email</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
											type="text" class="form-control" name="updateemail" id="updateemail"
											placeholder="Enter your Email" value="" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="username" class="cols-sm-2 control-label">User
									Role</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-users fa" aria-hidden="true"></i></span> <input
											type="text" class="form-control" name="username"
											id="username" placeholder="Enter your Username" value="" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="password" class="cols-sm-2 control-label">Password</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
											type="password" class="form-control" name="updatepassword"
											id="updatepassword" placeholder="Enter your Password"
											 value="password" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="confirm" class="cols-sm-2 control-label">Confirm
									Password</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
											type="password" class="form-control" name="confirm"
											id="confirm" placeholder="Confirm your Password"
											value="" />
									</div>
								</div>
							</div>



							<div class="form-group ">
								<a href="/Nexus/admin/listUsers" id="updateuserbutton"
									class="btn btn-primary btn-lg btn-block login-button">Update
									User</a>
							</div>

						</form>

					</div>
				</div>
			</div>
		</div>
		<footer class="pull-left footer">
		<p class="col-md-12">
		<hr class="divider">
		Copyright &COPY; 2017 <a href="#">SANJEEV KHATRI</a>
		</p>
		</footer>
	</div>

	<!-- jQuery -->
	<script src="/Nexus/resources/js/jquery.min.js"></script>
	<!-- Admin -->
	<script src="/Nexus/resources/js/admin.js"></script>
	<!-- Bootstrap -->
	<script src="/Nexus/resources/js/bootstrap.min.js"></script>
</body>
</html>