package com.wipro.event.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getDBConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String user = "PONNARASI";  
        String password = "ponnarasi.rjk@007"; 
        return DriverManager.getConnection(url, user, password);
    }
}
