<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="userProfile" value="${pageContext.request.session.getAttribute('userProfile')}"/>
<header class="header">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/commons.css" rel="stylesheet">
 <article class="container">
     <div class="header-left">
           <div>
             <img class="mb-4" src="${contextPath}/resources/assets/images/4jugal.png" alt="" width="95" height="80">
                         <div class="float-right">
                            <h2 >Jugal Rural Municipality</h2>
                             <h4>Recruitment Management System</h4>
                         </div>
           </div>
           <p class="header-title">
                       <a href="">Welcome ${userProfile.username}</a>
            </p>
           </div>
           <div class="float-right">
                    <ul class="header-ul">
                       <li><i class="fa fa-envelope"></i> <a href="#" onclick="document.forms['logoutForm'].submit()">Logout</a></li>
                    </ul>
           </div>
  </article>

</header>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

