<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>jmztechnologies</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<div class="d-flex" id="wrapper">
		<div class="bg-white" id="sidebar-wrapper">
			<div
				class="
            sidebar-heading
            text-center
            py-3
            px-3
            fs-4
            fw-bold
            text-white text-uppercase
            border-bottom
            designdiv
          ">
				JMZTECH</div>
			<div class="list-group list-group-flush my-3">
				<a href="../hpcode/index.html"
					class="
              list-group-item list-group-item-action
              bg-transparent
              fw-bold
            ">
					<i class="fas fa-stream me-2"></i>Home
				</a> <a href="exam.jsp"
					class="
              list-group-item list-group-item-action
              bg-transparent
              fw-bold
            "><i
					class="fas fa-plus me-2"></i>Add Exam</a> 
					<a href="viewExam.jsp"
					class="
              list-group-item list-group-item-action
              bg-transparent
              fw-bold
            "><i
					class="fas fa-hand-holding-heart me-2"></i>View Exams</a>
					
					
					<a href="Result.jsp"
					class="
              list-group-item list-group-item-action
              bg-transparent
              fw-bold
            "><i
					class="fas fa-hand-holding-heart me-2"></i>Result</a> 
					 
					<a
					href="login.html"
					class="
              list-group-item list-group-item-action
              bg-transparent
              text-danger
              fw-bold
            "><i
					class="fas fa-power-off me-2"></i>Logout</a>
			</div>
		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<nav class="navbar navbar-expand-lg py-3 px-3" id="nav_color">
				<div class="d-flex align-items-center">
					<i class="fas fa-align-left text-white fs-4 me-3" id="menu-toggle"></i>
					<h2 class="fs-4 m-0 text-white">Rajpoot</h2>
				</div>

				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle text-white fw-bold" href="#"
							id="navbarDropdown" role="button" data-bs-toggle="dropdown"
							aria-expanded="false"> <i class="fas fa-user me-2"></i>satyendra
								singh
						</a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="#">AdminProfile</a></li>
								<li><a class="dropdown-item" href="login.html">Logout</a></li>
							</ul></li>
					</ul>
				</div>
			</nav>

			<div class="container-fluid px-3">
				<div class="row g-3 my-4">
					<div class="col-md-12">
						<div
							class="
                  p-5
                  bg-white
                  shadow-sm
                  d-flex
                  justify-content-around
                  align-items-center
                  rounded
                ">
							<h2>welcome to jmz</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="page-footer font-small" id="footermain">
		<div class="footer-copyright text-center text-light py-3">
			rajpoot@gmail.com 2021 Copyright: <a
				class="text-white text-decoration-none" href="#"> Satyendra
				Rajpoot</a>
		</div>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		var el = document.getElementById("wrapper");
		var toggleButton = document.getElementById("menu-toggle");

		toggleButton.onclick = function() {
			el.classList.toggle("toggled");
		};
	</script>
</body>
</html>
