<%@ page language="java" %>
<%@ page import="com.wipro.event.bean.EventReservationBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display Event Reservation</title>
</head>
<body>
    <h2>Event Reservation Details</h2>
    <%
        String message = (String) request.getAttribute("message");
        EventReservationBean bean = (EventReservationBean) request.getAttribute("reservation");

        if (message != null) {
    %>
        <p><%= message %></p>
    <%
        } else if (bean != null) {
    %>
        <p>Record ID: <%= bean.getRecordId() %></p>
        <p>Customer Name: <%= bean.getCustomerName() %></p>
        <p>Event Name: <%= bean.getEventName() %></p>
        <p>Event Date: <%= bean.getEventDate() %></p>
        <p>Category: <%= bean.getCategory() %></p>
        <p>Ticket No: <%= bean.getTicketNo() %></p>
        <p>Remarks: <%= bean.getRemarks() %></p>
    <%
        }
    %>
</body>
</html>
