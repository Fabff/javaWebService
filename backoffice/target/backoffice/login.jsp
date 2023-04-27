<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Authentification</h1>
<form action="login" method="POST">
<fieldset>
<legend>Authentification Administrateur</legend>
<label for="login">login :</label>
<input type="text" name="login" id="login">
<br>
<label for="password">mot de passe :</label>
<input type="text" name="password" id="password">
<br/>
<input type="submit" value="envoyer">
</fieldset>

</form>
</body>
</html>