<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
		<h2>Flight Details</h2>
		Flight Number : ${flight.flightNumber}<br/>
		Operating Airlines : ${flight.operatingAirlines}<br/>
		Departure City : ${flight.departureCity}<br/>
		Arrival City : ${flight.arrivalCity}<br/>
		Date Of Departure : ${flight.dateOfDeparture}<br/>
		
		<h2>Enter passenger Details</h2><br/>
		
		<form action="confirmReservation" method="post">
			<table>
			  <tr>
			    <td>First Name</td>
			    <td><input type="text" name="firstName"/></td>
			  </tr>
			  <tr>
			    <td>Last Name</td>
			    <td><input type="text" name="lastName"/></td>
			  </tr>
			  <tr>
			    <td>Middle Name</td>
			    <td><input type="text" name="middleName"/></td>
			  </tr>
			  <tr>
			    <td>Email</td>
			    <td><input type="text" name="email"/></td>
			  </tr>
			  	<tr>
			    <td>Phone</td>
			    <td><input type="text" name="phone"/></td>
			  </tr>
			  <tr>
			    <td>Card Holder Name</td>
			    <td><input type="text" name="nameOfThecard"/></td>
			  </tr>
			  <tr>
			    <td>Card Number</td>
			    <td><input type="text" name="cardNumber"/></td>
			  </tr>
			  <tr>
			    <td>Cvv</td>
			    <td><input type="text" name="cvv"/></td>
			  </tr>
			  <tr>
			    <td>Expiry Date</td>
			    <td><input type="text" name="expiryDate"/></td>
			  </tr>
			  <tr>
			    <td><input type="hidden" name="flightId" value="${flight.id}"/></td>
			  </tr>
			  <tr>
			    <td><input type="submit" value="complete Reservation"/></td>
			  </tr>
			</table>
		</form>
		
</body>
</html>