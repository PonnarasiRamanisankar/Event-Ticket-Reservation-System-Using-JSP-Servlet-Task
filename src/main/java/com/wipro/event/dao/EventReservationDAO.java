package com.wipro.event.dao;

import com.wipro.event.bean.EventReservationBean;
import com.wipro.event.util.DBUtil;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class EventReservationDAO {

    // Create Record
    public String createRecord(EventReservationBean eventBean) {
        String recordId = generateRecordID(eventBean.getCustomerName(), eventBean.getEventDate());
        String sql = "INSERT INTO EVENTRES_TB (RECORDID, CUSTOMERNAME, EVENTNAME, EVENT_DATE, CATEGORY, TICKETNO, REMARKS) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, recordId);
            ps.setString(2, eventBean.getCustomerName());
            ps.setString(3, eventBean.getEventName());
            ps.setDate(4, new java.sql.Date(eventBean.getEventDate().getTime()));
            ps.setString(5, eventBean.getCategory());
            ps.setString(6, eventBean.getTicketNo());
            ps.setString(7, eventBean.getRemarks());

            int rows = ps.executeUpdate();
            if (rows > 0) return recordId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "FAIL";
    }

    // Fetch Record
    public EventReservationBean fetchRecord(String customerName, Date eventDate) {
        String sql = "SELECT * FROM EVENTRES_TB WHERE CUSTOMERNAME = ? AND EVENT_DATE = ?";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, customerName);
            ps.setDate(2, new java.sql.Date(eventDate.getTime()));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                EventReservationBean bean = new EventReservationBean();
                bean.setRecordId(rs.getString("RECORDID"));
                bean.setCustomerName(rs.getString("CUSTOMERNAME"));
                bean.setEventName(rs.getString("EVENTNAME"));
                bean.setEventDate(rs.getDate("EVENT_DATE"));
                bean.setCategory(rs.getString("CATEGORY"));
                bean.setTicketNo(rs.getString("TICKETNO"));
                bean.setRemarks(rs.getString("REMARKS"));
                return bean;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Generate Record ID
    public String generateRecordID(String customerName, Date eventDate) {
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String datePart = format.format(eventDate);

        String namePart = customerName.length() >= 2
                ? customerName.substring(0, 2).toUpperCase()
                : customerName.toUpperCase();

        int sequence = getNextSequenceNumber(datePart, namePart);
        return datePart + namePart + String.format("%02d", sequence);
    }

    private int getNextSequenceNumber(String datePart, String namePart) {
        String sql = "SELECT COUNT(*) FROM EVENTRES_TB WHERE RECORDID LIKE ?";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, datePart + namePart + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1) + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    // Record Exists
    public boolean recordExists(String customerName, Date eventDate) {
        String sql = "SELECT 1 FROM EVENTRES_TB WHERE CUSTOMERNAME = ? AND EVENT_DATE = ?";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, customerName);
            ps.setDate(2, new java.sql.Date(eventDate.getTime()));

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Fetch All Records
    public List<EventReservationBean> fetchAllRecords() {
        List<EventReservationBean> list = new ArrayList<>();
        String sql = "SELECT * FROM EVENTRES_TB";

        try (Connection con = DBUtil.getDBConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                EventReservationBean bean = new EventReservationBean();
                bean.setRecordId(rs.getString("RECORDID"));
                bean.setCustomerName(rs.getString("CUSTOMERNAME"));
                bean.setEventName(rs.getString("EVENTNAME"));
                bean.setEventDate(rs.getDate("EVENT_DATE"));
                bean.setCategory(rs.getString("CATEGORY"));
                bean.setTicketNo(rs.getString("TICKETNO"));
                bean.setRemarks(rs.getString("REMARKS"));
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
