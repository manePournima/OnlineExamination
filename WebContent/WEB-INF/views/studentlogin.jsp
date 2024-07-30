<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp"/>
<body>
	<form action="./validatestudentlogin" method="post">
		<div class="container">
			<jsp:include page="header.jsp"/>
			
			<!-- Main Content -->
			<div class="row m-auto mt-5">
				
				<div class="col-md-5">
					<div class="row">
						<div class="col-md-12">
							<h4>1.Instraction1</h4>
							<h4>1.Instraction2</h4>
							<h4>1.Instraction3</h4>
							<h4>1.Instraction4</h4>
							<h4>1.Instraction5</h4>
						</div>
					</div>
				</div>
				
				<div class="col-md-7">
					<div class="card">
						
						<div class="row p-3 text-center">
							<div class="col-md-12">
								<strong class="text-info">Login Form</strong>
							</div>
						</div>	
					
						<div class="row px-5">
							<div class="col-md-6">
								<strong>Username</strong>
							</div>
							<div class="col-md-6">
								<input type="text" name="username" class="form-control" id="usernameid"/>
							</div>
						</div>
						
						<div class="row px-5 pt-5">
							<div class="col-md-6">
								<strong>Password</strong>
							</div>
							<div class="col-md-6">
								<input type="password" name="password" class="form-control" id="passwordid"/>
							</div>
						</div>
						
						<div class="row px-5 py-5 text-center">
							<div class="col-md-12">
								<input type="submit" class="btn btn-info" value="LOGIN"/>  
								<input type="reset" class="btn btn-warning" value="RESET"/>  
							</div>
						</div>
						<div class="row px-5 py-5 text-danger">
							<div class="col-md-12">
								<h3>${error}</h3>
							</div>
						</div>
						
					</div>
				</div>
			</div>
			
			
			<jsp:include page="footer.jsp"/>
		</div>
	</form>	
</body>
</html>