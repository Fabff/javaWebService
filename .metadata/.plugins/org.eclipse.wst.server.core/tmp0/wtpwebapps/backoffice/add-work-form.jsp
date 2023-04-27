<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter une oeuvre</title>
</head>
<body>
<h1>Ajouter une oeuvre au catalogue</h1>
<form action="add-work" method="GET">
<fieldset>
<legend>Enregistrement oeuvre</legend>
<label for="titre">Titre :</label>
<input type="text" name="titre" id="titre">
<br>
<label for="annee">Annee :</label>
<input type="text" name="annee" id="annee">
<br>

<label for="genre">Genre :</label>
<input type="text" name="genre" id="genre">
<br>

<label for="resume">Résumé :</label>
<input type="text" name="resume" id="resume">
<br>

<label for="artiste">Artiste principal :</label>
<input type="text" name="artiste" id="artiste">
<br>
<input type="submit" value="enregistrer">
</fieldset>

</form>
 
</body>
</html>