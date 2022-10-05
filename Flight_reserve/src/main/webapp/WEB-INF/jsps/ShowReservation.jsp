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
	Flight Number     :${flight.flightNumber}
	Airline           :${flight.operatingAirlines}
	Departure City    :${flight.departureCity}
	Arrival city      :${flight.arrivalCity}
	Date Of Departure :${flight.dateOfDeparture}
	Time			  :${flight.estimatedDepartureTime}
	
	<h2>Enter Passenger Details</h2>
	
	<form action="completeReservation" method="post">
	<pre>
	First Name   :<input type="text" name="firstName"/>
	Last Name    :<input type="text" name="lastName"/>
	Middle Name  :<input type="text" name="middleName"/>
	Email	     :<input type="text" name="email"/>
	Phone        :<input type="text" name="phone"/>
	<input type="text" name="flightId" value="${flight.id}"/>
	Card no      :<input type="Text" name = "cardNo"/>
	Name on card :<input type="Text" name = "nameOnCard"/>
	Expiry Date  :<input type="Text" name = "expiryDate"/>
	CVV          :<input type="Text" name = "CVV"/>
	<input type="submit" value="complete reservation"/>
	</pre>
	</form>
</body>
</html>