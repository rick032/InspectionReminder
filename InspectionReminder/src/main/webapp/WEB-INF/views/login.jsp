<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login</title>	
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body>
	<c:if test="${param.error != null}">
        <h2>Username or password wrong!</h2>
    </c:if>
	<form class="form-signin" method="post" action="j_spring_security_check">
		<h2 class="form-signin-heading">Please sign in</h2>
		<label for="inputUserName" class="sr-only">User Name</label> <input
			type="text" id="userName" name="userName" class="form-control"
			placeholder="User Name" required autofocus> 
		<label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" id="password" name="password" class="form-control"
			placeholder="Password" required>		
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
	</form>
</body>
</html>