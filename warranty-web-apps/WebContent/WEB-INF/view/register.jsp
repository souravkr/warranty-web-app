<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<style>
.cssError {color: maroon;}
</style>


<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
	
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/javascript/query.js"></script>
	
<title>Warranty App- Product Entry</title>

</head>


<body>


	<header class="header">
		<nav class="navbar navbar-expand-lg fixed-top py-3">
			<div class="container">
				<a href="#" class="navbar-brand text-uppercase font-weight-bold">Warranty
					App</a>
				<button type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation"
					class="navbar-toggler navbar-toggler-right">
					<i class="fa fa-bars"></i>
				</button>

				<div id="navbarSupportedContent" class="collapse navbar-collapse">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active"><a
							href="${pageContext.request.contextPath}/product/productList"
							class="nav-link text-uppercase font-weight-bold">Home <span
								class="sr-only">(current)</span></a></li>
						<li class="nav-item"><a href="#"
							class="nav-link text-uppercase font-weight-bold">About</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>


	<br><br><br><br><br><br>

	<section class="h-100 h-custom">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-8 col-xl-6">
					<div class="card rounded-3">
						<img
							src="${pageContext.request.contextPath}/resources/images/appliance.jpg"
							class="w-100"
							style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
							alt="Sample photo">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Register Your
								Product</h3>



							<form:form action="processForm" modelAttribute="product"
								class="px-md-2" method="POST" enctype="multipart/form-data">
								
								<form:hidden path="id" />
								
								<div class="form-outline mb-4">
									<form:input path="name" class="form-control" />
									<label class="form-label" for="form3Example1q">Name</label>
									<form:errors path="name" class="cssError" />
								</div>

								<div class="row">
								
									<div class="col-md-6 mb-4">
										<div class="form-outline datepicker">
											<form:input type="date" path="purchaseDate"
												class="form-control" value="2022-06-22" />
											<label class="form-label">Purchased date</label>
											<form:errors path="purchaseDate" class="cssError" />
										</div>
									</div>


									<div class="col-md-6 mb-4">
									
										<form:select path="bid" class="form-control">

											<c:forEach var="theUser" items="${brands}">
												<form:option value="${theUser.brandId}"
													label="${theUser.name}"></form:option>
											</c:forEach>
											
										</form:select>
										
										<label class="form-label" for="form3Example1w">Product Brand</label>
									</div>
								</div>



								<div class="row mb-4 pb-2 pb-md-0 mb-md-5">
									<div class="col-md-6">
										<div class="form-outline">
											<form:input path="warrantyInMonth" class="form-control" />
											<label class="form-label" for="form3Example1w">Warranty In Months</label>
											<form:errors path="warrantyInMonth" class="cssError" />
										</div>

									</div>
								</div>
            
                                   Upload Invoice : <input type="file" name="file"
									class="form-control" />
                                    <br><br>

								<input type="submit" class="button-29" value="Add Product" />
								
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/javascript/query.js"></script>


</body>