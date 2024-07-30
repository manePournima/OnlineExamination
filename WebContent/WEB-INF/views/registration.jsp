<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp"/>
<body>
	<form action="${action}" method="post">
		<div class="container">
			<!-- Header -->
			<jsp:include page="header.jsp"/>
			
			<jsp:include page="navbar.jsp"/>
			
			<!-- Main Content -->
			<div class="row">
				<div class="col-md-12">
				
					<div class="row px-5 pt-5">
						<div class="col-md-6">
							<label>Enter Name</label>
						</div>
						<div class="col-md-6">
							<input type="text" name="name" id="nameId" class="form-control" value="${nameValue}"/> 
						</div>
					</div>
					
					<div class="row px-5 pt-5 ">
						<div class="col-md-6">
							<label>Enter Email</label>
						</div>
						<div class="col-md-6">
							<input type="email" name="email" id="emailId" class="form-control" value="${emailValue}"/> 
						</div>
					</div>
					
					<div class="row px-5 pt-5 ">
						<div class="col-md-6">
							<label>Enter Username</label>
						</div>
						<div class="col-md-6">
							<input type="text" name="username" id="usernameId" class="form-control" value="${usernameValue}"/> 
						</div>
					</div>
					
					<div class="row px-5 pt-5 ">
						<div class="col-md-6">
							<label>Enter Phone</label>
						</div>
						<div class="col-md-6">
							<input type="text" name="phone" id="phoneId" class="form-control" value="${phoneValue}"/> 
						</div>
					</div>
					
					<div class="row px-5 pt-5 text-center">
								<div class="col-md-12">
									<input type="submit" class="btn btn-info" value="${buttonValue}"/>  
									<input type="reset" class="btn btn-info" value="RESET"/>  
								</div>
							</div>
							<div class="row px-5 py-5 text-danger">
								<div class="col-md-12">
									<h3>${error}</h3>
								</div>
								<div class="col-md-12">
									<h3>${success}</h3>
								</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-12">
						<table class="table">
		  					<thead>
		  						<tr>
							      <th>Sr No.</th>
							      <th>Name</th>
							      <th>Email</th>
							      <th>Username</th>
							      <th>Password</th>
							      <th>Phone</th>
							    </tr>
		  					</thead>
		  					<tbody>
		  						<c:if test="${not empty studentList}">
									<c:forEach var="std" items="${studentList}" varStatus="count">
										<tr>
											<td>${count.count}</td>
											<td>${std.getName()}</td>
											<td>${std.getEmail()}</td>
											<td>${std.getUsername()}</td>
											<td>${std.getPassword()}</td>
											<td>${std.getPhone()}</td>
											<td>
												<a href="#">Edit</a> | <a href="#">Delete</a>
											</td>
										</tr>
									</c:forEach>
								</c:if>
											
		  					</tbody>
	  					</table>
					</div>
				</div>
					
				
			</div>
			
			<!-- Footer -->
			<jsp:include page="footer.jsp"/>
		</div>
	</form>
</body>
</html>