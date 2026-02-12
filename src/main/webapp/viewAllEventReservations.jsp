<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>View All Event Reservations</title>
</head>
<body>
    <h2>View All Event Reservations</h2>
    <form action="MainServlet" method="post">
        <input type="hidden" name="operation" value="viewAllRecords">
        <input type="submit" value="View All Reservations">
    </form>
</body>
</html>
