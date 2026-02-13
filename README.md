# 🎟️ Event Ticket Reservation System Using JSP & Servlet

## 📌 Project Objective

        This project is a simple web application built with **Java Servlets, JSP, and JDBC** to manage event ticket reservations.  
        It demonstrates layered architecture with **Bean → DAO → Service → Servlet → JSP**, ensuring clean separation of concerns and maintainability.

## ✨ Features

        - Add new event ticket reservations (customer info, event name, date, category, ticket number, remarks).
        - View a specific reservation by customer name and event date.
        - View all reservations stored in the database.
        - Input validation and error handling (invalid input, duplicate records, etc.).
        - Simple JSP/HTML pages for user interaction.
  
## 🏗️ Project Structure

            EventTicketReservationSystem/
            ├── src/main/java
            │    ├── com.wipro.event.util
            │    │     ├── DBUtil.java
            │    │     └── InvalidInputException.java
            │    ├── com.wipro.event.bean
            │    │     └── EventReservationBean.java
            │    ├── com.wipro.event.dao
            │    │     └── EventReservationDAO.java
            │    ├── com.wipro.event.service
            │    │     └── Administrator.java
            │    └── com.wipro.event.servlets
            │          └── MainServlet.java
            ├── src/main/webapp
            │    ├── menu.html
            │    ├── addEventReservation.jsp
            │    ├── viewEventReservation.jsp
            │    ├── viewAllEventReservations.jsp
            │    ├── displayEventReservation.jsp
            │    ├── displayAllEventReservations.jsp
            │    ├── success.html
            │    └── error.html
            └── WEB-INF
            ├── web.xml
            └── lib/ (JDBC driver here)
🖥️ Usage
Home Page: menu.html

          Add Event Ticket Reservation → addEventReservation.jsp
          View Event Ticket Reservation → viewEventReservation.jsp
          View All Event Reservations → viewAllEventReservations.jsp
Flow:

          Add record → success.html / error.html
          View record → displayEventReservation.jsp (or “No matching records exists!”)
          View all records → displayAllEventReservations.jsp (or “No records available!”)

🧪 Sample Test Cases

          Add reservation with valid values → ✅ success.html
          Add reservation with invalid customer name (<2 chars) → ❌ error.html
          Add reservation with null values → ❌ error.html
          Add reservation where record already exists → ❌ error.html (“ALREADY EXISTS”)
          View reservation with valid values → ✅ displayEventReservation.jsp
          View reservation with invalid values → ❌ “No matching records exists!”
          View all reservations with data → ✅ list displayed
          View all reservations when DB empty → ❌ “No records available!”

📚 Technologies Used

          Java (Servlets, JSP, JDBC)
          Oracle Database
          Apache Tomcat
          HTML/JSP for UI

<img width="752" height="373" alt="image" src="https://github.com/user-attachments/assets/c58fd8dc-9d52-4d58-95ea-749bf70883d6" />
<img width="1052" height="448" alt="image" src="https://github.com/user-attachments/assets/67606183-619f-41d0-a9c0-74aec9bff63e" />
<img width="832" height="411" alt="image" src="https://github.com/user-attachments/assets/5fc2ade4-4ab8-475a-8bcb-246c4edd62c7" />
<img width="577" height="237" alt="image" src="https://github.com/user-attachments/assets/b5bce852-ee5f-40f0-b846-2e0771177786" />
<img width="784" height="358" alt="image" src="https://github.com/user-attachments/assets/754ab916-1c6b-4d4c-9d76-69f15abbe7c3" />
<img width="861" height="496" alt="image" src="https://github.com/user-attachments/assets/f8cdf0bc-72dd-4b8c-91d0-bd1df7912d91" />
<img width="627" height="284" alt="image" src="https://github.com/user-attachments/assets/280a9fe4-6d58-4b91-b9af-97d17a9286cd" />
<img width="942" height="1019" alt="image" src="https://github.com/user-attachments/assets/2d0fe517-2dac-48e6-bc2a-fe2e8ca01d11" />
<img width="867" height="1017" alt="image" src="https://github.com/user-attachments/assets/9cb33df6-1574-47d6-a705-ff979a4c1be9" />
<img width="1327" height="464" alt="image" src="https://github.com/user-attachments/assets/5e3bdcc2-9423-41db-843d-30734753cf56" />
