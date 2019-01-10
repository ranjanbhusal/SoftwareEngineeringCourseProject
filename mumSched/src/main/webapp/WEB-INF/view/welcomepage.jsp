<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>MUM_SCHED | home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

	<%
		if (session.getAttribute("username") == null) {
			response.sendRedirect("login");
		}
	%>
	<div class = "container-fluid">
	<div class = "row">
	<div role="navigation">
		<div class="navbar navbar-dark bg-primary" style="color: white">
			<div class="col-md-9">
				<a href="/welcome" class="navbar-brand" style="color: whitesmoke">MUMSCHED</a>
			</div>

			<div class="col-md-2">
				<h4>
					<span>Welcome </span><span>${username}</span>
				</h4>
			</div>

			<div class="col-md-1" style= "vertical-align: center">
				<a href="/logout"> <input type="submit" class="btn btn-info"
					value="Logout"></a>
			</div>
		</div>
	</div>
</div>
</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 list-group" role = "tablist">

				<ul class="nav nav-pills nav-stacked">
					<li><a href="/show-users" class = "list-group-item list-group-item-action list-group-item-info">View Users</a></li>
					<li><a href="/view-entry" class = "list-group-item list-group-item-action">View Entry</a></li>
					<li><a href="/view-block" class = "list-group-item list-group-item-action">View Block</a></li>
					<li><a href="/view-course" class = "list-group-item list-group-item-action">View Course</a></li>
					<li><a href="/add-schedule?username=${username}" class = "list-group-item list-group-item-action">Add
							Schedule</a></li>
					<li><a href="/add-courseOnBlock" class = "list-group-item list-group-item-action">Add
							Course on Block</a></li>
					<li><a href="/add-studentEntry" class = "list-group-item list-group-item-action">Add
							Student Entry</a></li>						
				</ul>
			</div>

			<div class="col-md-10">
				<c:choose>
					<c:when test="${mode=='MODE_HOME' }">
						<div class="container" id="homediv">
							
							<c:forEach var="blocktable" items="${blocktables}">
							
							<div class="table-responsive">
								<h3>${blocktable.blockMonth}</h3>
								<table class="table table-striped table-bordered text-center">
									<thead>
										<tr>
											<th>Course Name</th>
											<th>Course Code</th>
											<th>Professor Name</th>
											<th>Seat Capacity</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="courseTable" items="${blocktable.courseTable}">
											<tr>
												<td>${courseTable.courseTitle}</td>
												<td>${courseTable.courseCode}</td>
												<td>${courseTable.professor}</td>
												<td>${courseTable.seatCapacity}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							
							
							</c:forEach>
							
							
						</div>
					</c:when>


					<c:when test="${mode=='MODE_REGISTER' }">
						<div class="container text-center">
							<h3>New Registration</h3>
							<hr>
							<form class="form-horizontal" method="POST" action="save-user">
								<input type="hidden" name="id" value="${user.id }" />

								<div class="form-group">
									<label class="control-label col-md-3">User ID</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="userid"
											value="${user.userid }" />
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-3">Username</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="username"
											value="${user.username }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">First Name</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="firstname"
											value="${user.firstname }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Last Name</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="lastname"
											value="${user.lastname }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Age </label>
									<div class="col-md-3">
										<input type="text" class="form-control" name="age"
											value="${user.age }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Password</label>
									<div class="col-md-7">
										<input type="password" class="form-control" name="password"
											value="${user.password }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">User Roles</label>
									<div class="col-md-7">

										<select class="form-control" name="userroles"
											value="${user.userroles }">
											<option>Admin</option>
											<option>Student</option>
											<option>Faculty</option>
										</select>
									</div>
								</div>
								<div class="form-group ">
									<input type="submit" class="btn btn-primary" value="Register" />
								</div>
							</form>
						</div>
					</c:when>


					<c:when test="${mode=='MODE_USERS' }">
						<div class="container text-center" id="tasksDiv">
							<h3>All Users</h3>
							<hr>
							<div align="right">
							<a href="/register"><input type="submit" class="btn btn-primary" value ="Add User"  /></a>
							</div>
							<hr>
							<div class="table-responsive">
								<table class="table table-striped table-bordered text-center">
									<thead>
										<tr>
											<th>Id</th>
											<th>User ID</th>
											<th>UserName</th>
											<th>First Name</th>
											<th>LastName</th>
											<th>Age</th>
											<th>User Roles</th>
											<th>Delete</th>
											<th>Edit</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="user" items="${users }">
											<tr>
												<td>${user.id}</td>
												<td>${user.userid}</td>
												<td>${user.username}</td>
												<td>${user.firstname}</td>
												<td>${user.lastname}</td>
												<td>${user.age}</td>
												<td>${user.userroles}</td>
												<td><a href="/delete-user?id=${user.id }"><span
														class="glyphicon glyphicon-trash"></span></a></td>
												<td><a href="/edit-user?id=${user.id }"><span
														class="glyphicon glyphicon-pencil"></span></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</c:when>


					<c:when test="${mode=='MODE_UPDATE' }">
						<div class="container text-center">
							<h3>Update User</h3>
							<hr>
							<form class="form-horizontal" method="POST" action="save-user">
								<input type="hidden" name="id" value="${user.id }" />

								<div class="form-group">
									<label class="control-label col-md-3">User ID</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="userid"
											value="${user.userid }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Username</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="username"
											value="${user.username }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">First Name</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="firstname"
											value="${user.firstname }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Last Name</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="lastname"
											value="${user.lastname }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Age </label>
									<div class="col-md-3">
										<input type="text" class="form-control" name="age"
											value="${user.age }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Password</label>
									<div class="col-md-7">
										<input type="password" class="form-control" name="password"
											value="${user.password }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Users Role</label>
									<div class="col-md-7">
										<select class="form-control" name="userroles"
											value="${user.userroles }">
											<option>Admin</option>
											<option>Student</option>
											<option>Faculty</option>
										</select>
									</div>
								</div>

								<div class="form-group ">
									<input type="submit" class="btn btn-primary" value="Update" />
								</div>
							</form>
						</div>
					</c:when>


					<c:when test="${mode == 'ADD_ENTRY' }">
						<div class="container text-center">
							<h3>Add Entry</h3>
							<hr>
							<form class="form-horizontal" method="POST" action="save-entry">
								<input type="hidden" name="id" value="${entry.id }" />

								<div class="form-group">
									<label class="control-label col-md-3">Entry Month</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="entryMonth"
											value="${entry.entryMonth }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Entry Year</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="entryYear"
											value="${entry.entryYear }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Entry Month Value</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="entryMonthValue"
											value="${entry.entryMonthValue }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Order</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="order"
											value="${entry.order }" />
									</div>
								</div>

								<div class="form-group ">
									<input type="submit" class="btn btn-primary" value="Add Entry" />
								</div>
							</form>
						</div>
					</c:when>

					<c:when test="${mode=='VIEW_ENTRY' }">
						<div class="container text-center" id="tasksDiv">
							<h3>View Entry</h3>
							<hr>
							
								<div align="right">
							<a href="/add-entry"><input type="submit" class="btn btn-primary" value ="Add Entry"  /></a>
							</div>
							<hr>
							<div class="table-responsive">
								<table class="table table-striped table-bordered text-center">
									<thead>
										<tr>
											<th>ID</th>
											<th>Entry Month</th>
											<th>Entry Year</th>
											<th>Entry Month Value</th>
											<th>Entry Order</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="entry" items="${entries }">
											<tr>
												<td>${entry.id}</td>
												<td>${entry.entryMonth}</td>
												<td>${entry.entryYear}</td>
												<td>${entry.entryMonthValue}</td>
												<td>${entry.order}</td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</c:when>

					<c:when test="${mode == 'ADD_BLOCK' }">
						<div class="container text-center">
							<h3>Add Block</h3>
							<hr>
							<form class="form-horizontal" method="POST" action="save-block">
								<input type="hidden" name="id" value="${block.id }" />

								<div class="form-group">
									<label class="control-label col-md-3">Block Month</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="blockMonth"
											value="${block.blockMonth }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Number of
										Students</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="numOfStudents"
											value="${block.numOfStudents }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Block Order</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="blockOrder"
											value="${block.blockOrder }" />
									</div>
								</div>

								<div class="form-group ">
									<input type="submit" class="btn btn-primary" value="Add Block" />
								</div>
							</form>
						</div>
					</c:when>


					<c:when test="${mode=='VIEW_BLOCK' }">
						<div class="container text-center" id="tasksDiv">
							<h3>View Block</h3>
							<hr>
							<div align="right">
							<a href="/add-block"><input type="submit" class="btn btn-primary" value ="Add Block"  /></a>
							</div>
							<hr>
							<div class="table-responsive">
								<table class="table table-striped table-bordered text-center">
									<thead>
										<tr>
											<th>Id</th>
											<th>Block Month</th>
											<th>Number of Students</th>
											<th>Block Order</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="block" items="${blocks }">
											<tr>
												<td>${block.id}</td>
												<td>${block.blockMonth}</td>
												<td>${block.numOfStudents}</td>
												<td>${block.blockOrder}</td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</c:when>

					<c:when test="${mode == 'ADD_COURSE' }">
						<div class="container text-center">
							<h3>Add Course</h3>
							<hr>
							<form class="form-horizontal" method="POST" action="save-course">
								<input type="hidden" name="id" value="${course.id }" />

								<div class="form-group">
									<label class="control-label col-md-3">Course Code</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="courseCode"
											value="${course.courseCode }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Course Name</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="courseName"
											value="${course.courseName }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">Course
										Description</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="courseDesc"
											value="${course.courseDesc }" />
									</div>
								</div>

								<div class="form-group ">
									<input type="submit" class="btn btn-primary" value="Add Course" />
								</div>
							</form>
						</div>
					</c:when>


					<c:when test="${mode=='VIEW_COURSE' }">
						<div class="container text-center" id="tasksDiv">
							<h3>View Course</h3>
							<hr>
							<div align="right">
							<a href="/add-course"><input type="submit" class="btn btn-primary" value ="Add Course"  /></a>
							</div>
							<hr>
							<div class="table-responsive">
								<table class="table table-striped table-bordered text-center">
									<thead>
										<tr>
											<th>Id</th>
											<th>Course Code</th>
											<th>Course Name</th>
											<th>Course Description</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="course" items="${courses }">
											<tr>
												<td>${course.id}</td>
												<td>${course.courseCode}</td>
												<td>${course.courseName}</td>
												<td>${course.courseDesc}</td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</c:when>

					
				<c:when test="${mode=='ADD_SCHEDULE' }">
						
					<form class="form-horizontal" method="POST" action="save-schedule">	
						<div class="container text-center">
							<h3>Add Schedule</h3>
							<hr>
							<h5>Select Entry</h5>
							<select class="form-control" name="entry">
								<c:forEach var="entry" items="${entries}">
									<option value = "${entry.id}">${entry.entryMonth}/${entry.entryYear}</option>
								</c:forEach>
							</select>
						<hr>
						</div>
						
						
						
				<div class="container text-center">
					<div class = "form-group">
						<div class= "col-md-4">
							<h5>Select first Block</h5>
							<select class="form-control" name="block1">
								<c:forEach var="block1" items="${blocks}">
									<option value ="${block1.id }">${block1.blockMonth}</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="col-md-4">	
							<h5>Select Second Block</h5>
							<select class="form-control" name="block2">
								<c:forEach var="block2" items="${blocks}">
									<option value = "${block2.id }">${block2.blockMonth}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>	
				
				<div class="container text-center">
					<div class = "form-group">
						<div class= "col-md-4">
							<h5>Select Third Block</h5>
							<select class="form-control" name="block3">
								<c:forEach var="block3" items="${blocks}">
									<option value = "${block3.id }">${block3.blockMonth}</option>
								</c:forEach>
							</select>
						</div>
						
						
						
						<div class="col-md-4">	
							<h5>Select Fourth Block</h5>
							<select class="form-control" name="block4">
								<c:forEach var="block4" items="${blocks}">
									<option value= "${block4.id }">${block4.blockMonth}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<br>
				
			<div class="container text-center">
				<div class="form-group ">
					<div class = "col-md-2">
									<input type="submit" class="btn btn-primary" value="Add Schedule" />
								</div>
						</div>	
				</div>	
			</form>			
					
		</c:when>
		
		
		<c:when test="${mode=='ADD_COURSE_ON_BLOCK' }">
				
			<div class="container text-center">
							<h3>Add Courses on Block</h3>
							<hr>
				<form class="form-horizontal" method="POST" action="save-courseOnBlock">		
					<div class = "form-group">
						<div class= "col-md-3">
							<h5>Course</h5>
						</div>
						<div class = "col-md-7">	
							<select class="form-control" name="course">
								<c:forEach var="course" items="${courses}">
									<option value ="${course.id }">${course.courseName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
						
					<div class = "form-group">
						<div class="col-md-3">	
							<h5>Block</h5>
							</div>
							<div class= "col-md-7">
							<select class="form-control" name="block">
								<c:forEach var="block" items="${blocks}">
									<option value = "${block.id }">${block.blockMonth}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class = "form-group">
					<div class="col-md-3">	
							<h5>Seat Capacity</h5>
							</div>
							<div class="col-md-7">
								<input type="text" class="form-control" name="seatCapacity"
											value="${blockCourse.seatCapacity }" />
						</div>
						</div>
					
					<div class = "form-group">
						<div class= "col-md-3">
							<h5>Professor</h5>
							</div>
							<div class="col-md-7">
								<input type="text" class="form-control" name="professor"
											value="${blockCourse.professor }" />
						</div>
				</div>	
				<br>
				
				<div class="form-group ">
					<div class = "col-md-12">
					<div align="center">
									<input type="submit" class="btn btn-primary" value="Submit" />
						</div>
					</div>
				</div>	
				
		</form>	
		</div>		
		</c:when>
		
		<c:when test="${mode=='ADD_STUDENT_ENTRY' }">
				
			<div class="container text-center">
							<h3>Add Student Entry</h3>
							<hr>
				<form class="form-horizontal" method="POST" action="save-studentEntry">		
					<div class = "form-group">
						<div class= "col-md-3">
							<h5>Student</h5>
						</div>
						<div class = "col-md-7">	
							<select class="form-control" name="user">
								<c:forEach var="student" items="${users}">
									<option value ="${student.id }">${student.firstname} ${student.lastname }</option>
								</c:forEach>
							</select>
						</div>
					</div>
						
					<div class = "form-group">
						<div class="col-md-3">	
							<h5>Entry</h5>
							</div>
							<div class= "col-md-7">
							<select class="form-control" name="entry">
								<c:forEach var="entry" items="${entries}">
									<option value = "${entry.id }">${entry.entryMonth}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="form-group ">
					<div class = "col-md-12">
					<div align="center">
									<input type="submit" class="btn btn-primary" value="Submit" />
						</div>
					</div>
				</div>	
				
		</form>	
		</div>		
		</c:when>

		</c:choose>

			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>