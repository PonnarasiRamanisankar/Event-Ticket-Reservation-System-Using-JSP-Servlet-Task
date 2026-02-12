package com.wipro.event.service;

import com.wipro.event.bean.EventReservationBean;
import com.wipro.event.dao.EventReservationDAO;
import com.wipro.event.util.InvalidInputException;

import java.util.Date;
import java.util.List;

public class Administrator {
    private EventReservationDAO dao = new EventReservationDAO();

    public String addRecord(EventReservationBean eventBean) {
        try {
            if (eventBean == null || eventBean.getCustomerName() == null || eventBean.getEventDate() == null) {
                throw new InvalidInputException();
            }
            if (eventBean.getCustomerName().length() < 2) {
                return "INVALID CUSTOMER NAME";
            }
            if (eventBean.getEventDate() == null) {
                return "INVALID DATE";
            }
            if (dao.recordExists(eventBean.getCustomerName(), eventBean.getEventDate())) {
                return "ALREADY EXISTS";
            }

            String recordId = dao.generateRecordID(eventBean.getCustomerName(), eventBean.getEventDate());
            eventBean.setRecordId(recordId);
            return dao.createRecord(eventBean);
        } catch (InvalidInputException e) {
            return e.toString();
        }
    }

    public EventReservationBean viewRecord(String customerName, Date eventDate) {
        return dao.fetchRecord(customerName, eventDate);
    }

    public List<EventReservationBean> viewAllRecords() {
        return dao.fetchAllRecords();
    }
}
