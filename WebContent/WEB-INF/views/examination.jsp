<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp"/>
<body>
	
	<form action="${action}" method="post">
		<div class="container">
			<jsp:include page="header.jsp"/>
			
			<!-- Main Content -->
			<div class="row">
				<div class="col-md-12">
					
					<h1>${question.getQuestions()}</h1>
					<input type="hidden" name="id" value="${question.getId()}"/>
					<h4>1. <input type="radio" name="questionoption" value="1"/>${question.getOption1()}</h4>
					<h4>2. <input type="radio" name="questionoption" value="2"/>${question.getOption2()}</h4>
					<h4>3. <input type="radio" name="questionoption" value="3"/>${question.getOption3()}</h4>
					<h4>4. <input type="radio" name="questionoption" value="4"/>${question.getOption4()}</h4>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<input type="submit" class="btn btn-info" value="${buttonValue}"/>  
					<input type="reset" class="btn btn-warning" value="RESET"/>  
				</div>
			</div>	
			
			<jsp:include page="footer.jsp"/>
		</div>
	</form>
</body>
</html>