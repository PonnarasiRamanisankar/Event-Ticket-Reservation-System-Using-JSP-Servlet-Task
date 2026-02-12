<%@ page language="java" %>
<%@ page import="java.util.List, com.wipro.event.bean.EventReservationBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Event Reservations</title>
</head>
<body>
    <h2>All Event Reservations</h2>
    <%
        String message = (String) request.getAttribute("message");
        List<EventReservationBean> list = (List<EventReservationBean>) request.getAttribute("reservations");

        if (message != null) {
    %>
        <p><%= message %></p>
    <%
        } else if (list != null) {
            for (EventReservationBean bean : list) {
    %>
        <hr>
        <p>Record ID: <%= bean.getRecordId() %></p>
        <p>Customer Name: <%= bean.getCustomerName() %></p>
        <p>Event Name: <%= bean.getEventName() %></p>
        <p>Event Date: <%= bean.getEventDate() %></p>
        <p>Category: <%= bean.getCategory() %></p>
        <p>Ticket No: <%= bean.getTicketNo() %></p>
        <p>Remarks: <%= bean.getRemarks() %></p>
    <%
            }
        }
    %>
</body>
</html>
