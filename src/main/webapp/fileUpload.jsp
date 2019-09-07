<%@ page isELIgnored="false"   language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <title>Dictionary App</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="#">DictionaryApp</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <%--<div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
        </ul>
    </div>--%>
</nav>
<br>

<div class="container ">



<div class=" mb-4 bg-white rounded ">

    <form  class="form-inline " action="uploadFile" method="post" enctype="multipart/form-data">

        <div class="form-group">
            <label for="file"><h4>Select File:</h4>&nbsp;&nbsp;&nbsp;</label>
            <input type="file" class="form-control" id="file" name="file">
        </div>
        &nbsp;&nbsp;&nbsp;
        <button type="submit" class="btn btn-danger">Upload</button>

    </form>

</div><br>

<h3 style="color:red">  ${message}</h3>

    <br><br><br>


    <div class="p-4 mb-4 bg-white rounded ">

        <form  class="form-inline " action="searchWord" method="get" >

            <div class="form-group">
                <label for="word"><h4>Search A Word :</h4>&nbsp;&nbsp;&nbsp;</label>
                <input type="text" placeholder="Enter a word" class="form-control" id="word" name="word">
            </div>
            &nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-success">Search</button>

        </form>

    </div><br>
   <c:if test="${msg ne null}">
       <h3 style="color:green">${msg} </h3>
   </c:if>
    <c:if test="${errMsg ne null}">
        <h3 style="color:red">${errMsg} </h3>
    </c:if>
</div>





</body>
</html>
