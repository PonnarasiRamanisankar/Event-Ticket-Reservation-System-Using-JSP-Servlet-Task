<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Event Reservation</title>
</head>
<body>
    <h2>Add Event Ticket Reservation</h2>
    <form action="MainServlet" method="post">
        <input type="hidden" name="operation" value="newRecord">
        Customer Name: <input type="text" name="customerName"><br>
        Event Name: <input type="text" name="eventName"><br>
        Event Date: <input type="date" name="eventDate"><br>
        Category: <input type="text" name="category"><br>
        Ticket No: <input type="text" name="ticketNo"><br>
        Remarks: <input type="text" name="remarks"><br>
        <input type="submit" value="Add Reservation">
    </form>
</body>
</html>
