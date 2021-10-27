<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF">
<title>Counter</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>


	<div class="container text-center">
		<div>
			<h1 class="mt-5">Counter</h1>
		</div>

		<div>
			<h2>
				<span id="nTimes"><c:out value="${contador }"></c:out></span><span
					id="tTimes"> <c:out value="${texto }"></c:out></span>
			</h2>
		</div>
		<div>
			<form action="/ByTwo" method="POST">

				<button type="submit"
					class="btn btn-success mt-2 mx-2 increaseByTwo">Add two
					visits!</button>
			</form>

			<form action="/destroy_session" method="POST">
				<button type="submit" class="btn btn-danger mt-2 mx-2 btnReset">Reset</button>
			</form>

		</div>

	</div>

	<div class="prefCounter d-flex flex-row justify-content-center mt-5">
		
		<form action="/prefCounterFrm" method="POST">
			<label for="increaseNumber">Increase by:</label> <input type="number"
				id="increaseNumber" name="increaseNumber">
			<button type="submit" class="btn btn-primary btn-sm btnIncrease">Increase!</button>
		</form>
	</div>


</body>
</html>