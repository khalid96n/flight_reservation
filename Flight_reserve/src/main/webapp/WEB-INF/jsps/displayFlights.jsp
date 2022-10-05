<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dispaly Flights</title>
</head>
<body>
<h2>flight search result</h2>
<h2>List of Searched Flights</h2>
<table border="2">
<tr>
<th>Airlines</th>
<th>Departure City</th>
<th>Arrival City</th>
<th>Departure Time</th>
<th>Select Flight</th>
</tr>

<c:forEach items="${findFlight}" var="findFlight">
<tr>
	<td>${findFlight.operatingAirlines}</td>
	<td>${findFlight.departureCity}</td>
	<td>${findFlight.arrivalCity}</td>
	<td>${findFlight.estimatedDepartureTime}</td>
	<td><a href="ShowCompleteReservation?flightId=${findFlight.id}">Select flight</a></td>
</tr>
</c:forEach>

</table>

</body>
</html>