<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

   <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/query.js"></script> 
    <title>Warranty App- Product Entry</title>
  </head>
  
  
  <body>


   <header class="header">
    <nav class="navbar navbar-expand-lg fixed-top py-3">
        <div class="container"><a href="#" class="navbar-brand text-uppercase font-weight-bold">Warranty App</a>
            <button type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler navbar-toggler-right"><i class="fa fa-bars"></i></button>
            
            <div id="navbarSupportedContent" class="collapse navbar-collapse">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active"><a href="#" class="nav-link text-uppercase font-weight-bold">Home <span class="sr-only">(current)</span></a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-uppercase font-weight-bold">About</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-uppercase font-weight-bold">Contact</a></li>
                </ul>
            </div>
        </div>
    </nav>
    </header>
    
    
    <br><br><br><br><br><br>

<section class="h-100 h-custom" ">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-8 col-xl-6">
        <div class="card rounded-3">
          <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
            class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
            alt="Sample photo">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Register Your Product</h3>



 <%--            <form:form action="processForm2" modelAttribute="product" class="px-md-2" >

              <div class="form-outline mb-4">
                <form:input path ="name"  class="form-control"/>
                <label class="form-label" for="form3Example1q">Name</label>
              </div>

              <div class="row">
                <div class="col-md-6 mb-4">
                   <div class="form-outline datepicker">
                     <label for="birthday" class="form-label" >Purchased date</label>
                     <form:input type="date" path="purchaseDate"/>
                    </div>
                </div>
                     
                     
                <div class="col-md-6 mb-4">

                  <form:select path="productBrand" class="select">
                     <form:options  items="${brands}"/>                 
                  </form:select>

                </div>
              </div>

          

              <div class="row mb-4 pb-2 pb-md-0 mb-md-5">
                <div class="col-md-6">

                  <div class="form-outline">
                     <form:input path="warrantyInMonth" class="form-control" />
                     <label class="form-label" for="form3Example1w">Warranty Provided (In Months)</label>
                  </div>

                </div>
              </div>

             <input type="submit" value="Add Product"/>

           </form:form> --%>
           
           
           <form:form action="processForm" modelAttribute="product" method="GET">
             <form:hidden path="id"/>
       First Name <form:input path="name"/><br/>
Date <form:input type="date" path="purchaseDate"/><br/>
Month <form:input path="warrantyInMonth"/><br/>

<input type="submit" value="Add Custmomer"/>

</form:form>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/query.js"></script> 



</body>



<%-- <% response.sendRedirect("customer/list"); %> --%>