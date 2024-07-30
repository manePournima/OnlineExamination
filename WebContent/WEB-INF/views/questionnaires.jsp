<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp" />
<body>
	<form action="${action}" method="post">
		<div class="container">
			<!-- Header -->
			<jsp:include page="header.jsp" />
			<jsp:include page="navbar.jsp" />

			<!-- Main Content -->
			<div class="row">
				<div class="col-md-12">
					<div class="row px-5 pt-3">
						<div class="col-md-6">
							<label>Question Title</label>
						</div>
						<div class="col-md-6">
							<input type="text" name="question" id="questionId"
								value="${questionValue}" class="form-control" />
						</div>
					</div>

					<div class="row px-5 pt-3">
						<div class="col-md-6">
							<label>Option 1</label>
						</div>
						<div class="col-md-6">
							<input type="text" name="option1" id="option1Id"
								value="${option1Value}" class="form-control" />
						</div>
					</div>

					<div class="row px-5 pt-3">
						<div class="col-md-6">
							<label>Option 2</label>
						</div>
						<div class="col-md-6">
							<input type="text" name="option2" id="option2Id"
								value="${option2Value}" class="form-control" />
						</div>
					</div>

					<div class="row px-5 pt-3">
						<div class="col-md-6">
							<label>Option 3</label>
						</div>
						<div class="col-md-6">
							<input type="text" name="option3" id="option3Id"
								value="${option3Value}" class="form-control" />
						</div>
					</div>

					<div class="row px-5 pt-3">
						<div class="col-md-6">
							<label>Option 4</label>
						</div>
						<div class="col-md-6">
							<input type="text" name="option4" id="option4Id"
								value="${option4Value}" class="form-control" />
						</div>
					</div>

					<div class="row px-5 pt-3">
						<div class="col-md-6">
							<label>Correct Answer</label>
						</div>
						<div class="col-md-6">
							<input type="radio" name="answer" id="answerId" value="1" />
							Answer 1 <input type="radio" name="answer" id="answerId"
								value="2" /> Answer 2 <input type="radio" name="answer"
								id="answerId" value="3" /> Answer 3 <input type="radio"
								name="answer" id="answerId" value="4" /> Answer 4
						</div>

						<div class="row px-5 pt-5 text-center">
							<div class="col-md-12">
								<input type="submit" class="btn btn-info" value="${buttonValue}" />
								<input type="reset" class="btn btn-info" value="RESET" />
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
				</div>
			
				<div class="row">
					<div class="col-md-12">
						<table class="table">
		  					<thead>
		  						<tr>
							      <th>Sr No.</th>
							      <th>Question</th>
							      <th>Option1</th>
							      <th>Option2</th>
							      <th>Option3</th>
							      <th>Option4</th>
							      <th>Correct Answer</th>
							      <th>Action</th>
							    </tr>
		  					</thead>
		  					<tbody>
		  						<c:if test="${not empty questionsList}">
									<c:forEach var="question" items="${questionsList}" varStatus="count">
										<tr>
											<td>${count.count}</td>
											<td>${question.getQuestions()}</td>
											<td>${question.getOption1()}</td>
											<td>${question.getOption2()}</td>
											<td>${question.getOption3()}</td>
											<td>${question.getOption4()}</td>
											<td> ${question.getAnswer()==1 ? question.getOption1() : question.getAnswer()==2 ? question.getOption2() : question.getAnswer()==3 ? question.getOption3() : question.getAnswer()==4 ? question.getOption4() : ""}</td>
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
			
			

			<!-- Header -->
			<jsp:include page="footer.jsp" />
		</div>
	</form>
</body>
</html>