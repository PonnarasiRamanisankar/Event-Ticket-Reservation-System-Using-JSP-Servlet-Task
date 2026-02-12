package com.wipro.event.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.wipro.event.bean.EventReservationBean;
import com.wipro.event.service.Administrator;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Administrator admin = new Administrator();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 
 
		   
		    public String addRecord(HttpServletRequest request) {
		        try {
		            EventReservationBean bean = new EventReservationBean();
		            bean.setCustomerName(request.getParameter("customerName"));
		            bean.setEventName(request.getParameter("eventName"));
		            bean.setCategory(request.getParameter("category"));
		            bean.setTicketNo(request.getParameter("ticketNo"));
		            bean.setRemarks(request.getParameter("remarks"));

		            String dateStr = request.getParameter("eventDate");
		            if (dateStr != null && !dateStr.isEmpty()) {
		                Date eventDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		                bean.setEventDate(eventDate);
		            }

		            return admin.addRecord(bean);
		        } catch (Exception e) {
		            e.printStackTrace();
		            return "FAIL";
		        }
		    }

		  
		    public EventReservationBean viewRecord(HttpServletRequest request) {
		        try {
		            String customerName = request.getParameter("customerName");
		            String dateStr = request.getParameter("eventDate");
		            Date eventDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);

		            return admin.viewRecord(customerName, eventDate);
		        } catch (Exception e) {
		            e.printStackTrace();
		            return null;
		        }
		    }

		 
		    public List<EventReservationBean> viewAllRecords(HttpServletRequest request) {
		        return admin.viewAllRecords();
		    }

		  
		    @Override
		    protected void doPost(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {

		        String operation = request.getParameter("operation");
		        RequestDispatcher rd;

		        try {
		            if ("newRecord".equals(operation)) {
		                String result = addRecord(request);
		                if ("FAIL".equals(result) || "INVALID INPUT".equals(result) ||
		                    "INVALID CUSTOMER NAME".equals(result) || "INVALID DATE".equals(result) ||
		                    "ALREADY EXISTS".equals(result)) {
		                    rd = request.getRequestDispatcher("error.html");
		                } else {
		                    rd = request.getRequestDispatcher("success.html");
		                }
		                rd.forward(request, response);

		            } else if ("viewRecord".equals(operation)) {
		                EventReservationBean bean = viewRecord(request);
		                if (bean == null) {
		                    request.setAttribute("message", "No matching records exists! Please try again!");
		                } else {
		                    request.setAttribute("reservation", bean);
		                }
		                rd = request.getRequestDispatcher("displayEventReservation.jsp");
		                rd.forward(request, response);

		            } else if ("viewAllRecords".equals(operation)) {
		                List<EventReservationBean> list = viewAllRecords(request);
		                if (list.isEmpty()) {
		                    request.setAttribute("message", "No records available!");
		                } else {
		                    request.setAttribute("reservations", list);
		                }
		                rd = request.getRequestDispatcher("displayAllEventReservations.jsp");
		                rd.forward(request, response);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		            rd = request.getRequestDispatcher("error.html");
		            rd.forward(request, response);
		        }
		    }
		

	}


