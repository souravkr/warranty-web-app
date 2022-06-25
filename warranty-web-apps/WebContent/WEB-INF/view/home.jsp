<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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


 <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>   
 <script src="https://kit.fontawesome.com/a86ed0bb07.js" crossorigin="anonymous"></script>
    <title>Warranty Tracker</title>
  </head>
  
  
  <body>

    <header class="header">
    <nav class="navbar navbar-expand-lg fixed-top py-3">
        <div class="container"><a href="#" class="navbar-brand text-uppercase font-weight-bold">Warranty App</a>
            <button type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler navbar-toggler-right"><i class="fa fa-bars"></i></button>
            
            <div id="navbarSupportedContent" class="collapse navbar-collapse">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active"><a href="${pageContext.request.contextPath}/product/productList" class="nav-link text-uppercase font-weight-bold">Home <span class="sr-only">(current)</span></a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-uppercase font-weight-bold">About</a></li>
                   <!--  <li class="nav-item"><a href="#" class="nav-link text-uppercase font-weight-bold">Contact</a></li> -->
                </ul>
            </div>	
        </div>
    </nav>
    </header>


<br><br><br><br><br><br>

   <section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
             <header>
                <h4>Registered Products</h4>
                 </header>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="table-wrap">
                    <table class="table table-responsive-xl">
                      <thead>
                      
                        <tr>
                            <th>Name & Brand</th>
                            <th>Purchased Date</th>
                            <th>Warranty</th>
                            <th>Expires On</th>
                            <th>Invoice</th>
                            <th>Status</th>
                           <th>&nbsp;</th>
                            
                        </tr>
                        
                      </thead>
                      
                      <tbody>
                      
                      <c:forEach var="tempProduct" items="${products}" varStatus="status">
                      
                        <tr class="alert" role="alert">
                                         
                          <td class="d-flex align-items-center">
                              <div class="img" style="background-image: url(${pageContext.request.contextPath}/resources/images/${imageName[status.index]}.jpg);"></div>
                              <div class="pl-3 email">
                                  <span>${tempProduct.name}</span>
                                  <span>${brand[status.index].name}</span>
                              </div>
                          </td>
                          
                          <td>${tempProduct.purchaseDate}</td>
                          
                          <td>${tempProduct.warrantyInMonth}</td>
                          
                          <td>${expiryDate[status.index]}</td>
                          
                           

<!-- <script>
const time = tempProduct;

if (time === null) {
  greeting = "No Invoice Uploaded ";
} else  {
  greeting = "<td><a href= "${pageContext.request.contextPath}/Invoices/${tempProduct.invoice}" target="_blank">View Invoice/Bill</a></td>";
} 
document.getElementById("demo").innerHTML = greeting;
</script> -->
                          
                          
                        <%--  <td><a href= "${pageContext.request.contextPath}/Invoices/${tempProduct.invoice}" target="_blank">View Invoice/Bill</a></td>       --%>
                   
            <c:choose>
              <c:when test="${empty tempProduct.invoice}">
                  <td>No Invoice</td>
              </c:when>
              <c:otherwise>
                   <td><a href= "${pageContext.request.contextPath}/Invoices/${tempProduct.invoice}" target="_blank">View Invoice/Bill</a></td>
              </c:otherwise>
           </c:choose>
                                   
                                    
                           
                           <c:choose>
                           
                             <c:when test="${expirtyStatus[status.index] > 0}">
                             
                               <td class="status"><span class="active">Active</span></td> 
                             </c:when>
                            <c:otherwise>
                                <td class="status"><span class="waiting">Expired</span></td>    
                            </c:otherwise>
                            
                           </c:choose>
                                                
                       <!--    <td class="status"><span class="active">Active</span></td>     -->   
                       
                       
                       <c:url var="updateURL" value="/product/updateProduct">
                       
                        <c:param name="id" value="${tempProduct.id}"/>
                       
                       </c:url>
                       
                       <c:url var="deleteURL" value="/product/deleteProduct">
                       
                        <c:param name="id" value="${tempProduct.id}"/>
                       
                       </c:url>

                             
                             <td><a href="${updateURL}">Update </a> | <a href="${deleteURL}" onclick="return confirm('Are you sure You want to delete the Product?')">Delete</a></td>
        
     
        
<!--         <div class="header">

  three dot menu
  <div class="dropdown">
    three dots
    <ul class="dropbtn icons btn-right showLeft" onclick="showDropdown()">
      <li></li>
    </ul>
    menu
    <div id="myDropdown" class="dropdown-content">
      <a href="#home">Delete</a>
      <a href="#about">Update	</a>
    </div>
  </div>

</div>
         -->
        
        
        
        
        
                             
        <!--                      <menu>
                 <li><button onclick="copy()">Copy</button></li>
                <li><button onclick="cut()">Cut</button></li>
              <li><button onclick="paste()">Paste</button></li>
                    </menu> -->
                             
                      <!--        <select name="cars" id="cars">
                               <option value="delete" label="Delete"></option>
                                <option value="delete" label="Delete"></option>
                             </select> -->
                          <!--    </td> -->
                             
                         <!--  <td><div class="test"></div></td>  --> 
                                                        
                        
                        </tr>
                        
                        </c:forEach>
                        
                      </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>



<a href="${pageContext.request.contextPath}/product/showForm" class="float">
<i class="fa fa-plus my-float"></i>
</a>




  <footer class="text-center text-lg-start" style="background-color: #edf2f4	;">
    <div class="container d-flex justify-content-center py-5">
  <!--   <a href="https://www.youtube.com">
      <button type="button" class="btn btn-primary btn-lg btn-floating mx-2" style="background-color: #54456b;">
        <i class="fab fa-facebook-f"></i>
      </button>
     </a> -->
      
     <!-- <a href="https://www.youtube.com" target="_blank"> 
      <button type="button" class="btn btn-primary btn-lg btn-floating mx-2" style="background-color: #54456b;">
        <i class="fab fa-youtube"></i>
      </button>
      </a>
       -->
      <a href="https://www.instagram.com/souravkix" target="_blank">
      <button type="button" class="btn btn-primary btn-lg btn-floating mx-2" style="background-color: #54456b;">
        <i class="fab fa-instagram"></i>
      </button>
      </a>
      
      <a href="https://www.twitter.com/souravk229" target="_blank">
      <button type="button" class="btn btn-primary btn-lg btn-floating mx-2" style="background-color: #54456b;">
        <i class="fab fa-twitter"></i>
      </button>
      </a>
      
    </div>

    <!-- Copyright -->
    <div class="text-center text-white p-3" style="background-color: rgba(0, 0, 0, 0.2);">
      © 2022 Copyright:
      <a class="text-white" href="https://trickspy.in/">Trickspy.in</a>
    </div>
    <!-- Copyright -->
  </footer>
  
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/query.js"></script> 
    
    	<script src="${pageContext.request.contextPath}/resources/javascript/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/javascript/popper.js"></script>
  <script src="${pageContext.request.contextPath}/resources/javascript/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/javascript/main.js"></script>
   <script src="${pageContext.request.contextPath}/resources/javascript/menu.js"></script>
    


  </body>
</html>
