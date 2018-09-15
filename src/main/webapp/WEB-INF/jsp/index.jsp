<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todo App</title>
<meta name="viewport" content="width=device-width">
	
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.css"><base>
	
	<link rel="stylesheet" type="text/css" href="static/css/style.css">
	<script type="text/javascript" src="webjars/jquery/3.3.1/jquery.js"></script>
	
	
</head>
<body onload="countDown()">
	
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand" id="im1">Todo Application</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-task">Create Task</a></li>
					<li><a href="all-tasks">All Tasks</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
				<div class="container" id="homeDiv">
					<div class="jumbotron">
						<h1>Welcome to Task Manager</h1>
					</div>
				</div>
		</c:when>
		
		<c:when test="${mode == 'MODE_TASKS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>My Tasks</h3>
				<hr>
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Description</th>
								<th>Date Created</th>
								<th>Finished</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
							
						<tbody >
							<c:forEach var="task" items="${tasks}" >
								<tr>
									<td>${task.id}</td>
									<td>${task.name}</td>
									<td>${task.description}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${task.dateCreated}"/></td>
									<td>${task.finished}</td>
									<td><a href="/update-task?id=${task.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="/delete-task?id=${task.id}"><span class="glyphicon glyphicon-trash" onclick="return confirm('Are you sure you want to delete?')"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
			</div>
		</c:when>
		
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Task</h3>
				<hr>
				
				<form class="form-horizontal" method="post" action="save-task">
					<input type="hidden" name="id" value="${task.id}"/>
					<div class="form-group">
						<label class="control-lable col-md-3">Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name" value="${task.name}">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-lable col-md-3">Description</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="description" value="${task.description}">
						</div>
		 			</div>
					
					<div class="form-group">
						<label class="control-lable col-md-3">Finished</label>
						<div class="col-md-7">
							<input type="radio" class="col-sm-1" name="finished" value="true">
							<div class="col-sm-1">Yes</div>
							<input type="radio" class="col-sm-1" name="finished" value="false" checked>
							<div class="col-sm-1">No</div>
						</div>
					</div>
					
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save">
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>
	
</body>
</html>