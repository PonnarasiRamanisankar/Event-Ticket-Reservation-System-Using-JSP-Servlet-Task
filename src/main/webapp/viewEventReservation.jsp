<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Event Reservation</title>
</head>
<body>
    <h2>View Event Ticket Reservation</h2>
    <form action="MainServlet" method="post">
        <input type="hidden" name="operation" value="viewRecord">
        Customer Name: <input type="text" name="customerName"><br>
        Event Date: <input type="date" name="eventDate"><br>
        <input type="submit" value="View Reservation">
    </form>
</body>
</html>
