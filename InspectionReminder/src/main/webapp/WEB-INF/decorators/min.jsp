<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <head>
 <meta charset="utf-8">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge" />
 <title><sitemesh:write property='title'/></title>
 <sitemesh:write property='head'/>
 	<!-- Bootstrap core CSS -->
 	<link href="resources/css/bootstrap/bootstrap.min.css" rel="stylesheet"> 	
     <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="resources/js/requirejs/2.1.17/require.min.js"></script>
	<script src="resources/js/main.js"></script>
 </head>
 
 <body>
 <sitemesh:write property='body'/>	
 </body>
</html>