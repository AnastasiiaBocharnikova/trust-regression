package com.trust.cucumber.util;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.sql.*;

public class ConnectToDB {
    private Connection con = null;

    private Statement connectDB(String url, String username, String password) throws SQLException {
        Statement stmt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, username, password);

            stmt = con.createStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    private void closeDBConnection() {
        if (con != null)
        {
            try { con.close(); }
            catch (SQLException e) { Log.info(e.getMessage()); }
        }
    }

    private String sqlRequest1(Statement st, int monitor, String column) throws SQLException {
        String result = null;

        ResultSet rs = st.executeQuery("select * from DASHVIEW.monitor where service_id="+monitor);
        while (rs.next()) {
            result=rs.getString(column);
        }
        return result;
    }

    public void verifyBlackoutValueForMonitor(String value, int monitor, String column, String url, String username, String password) throws SQLException {
        Statement st = connectDB(url,username,password);
        String valueDB = sqlRequest1(st,monitor,column);
        closeDBConnection();
        Log.info(valueDB);
        Assert.assertEquals(value, valueDB);
    }

    public void verifyBlackoutValueNotNullForMonitor(int monitor, String column, String url, String username, String password) throws SQLException{
        Statement st = connectDB(url,username,password);
        String valueDB = sqlRequest1(st,monitor,column);
        closeDBConnection();
        Log.info(valueDB);
        Assert.assertFalse(valueDB == null);
    }

    public void verifyBlackoutValueNullForMonitor(int monitor, String column, String url, String username, String password) throws SQLException{
        Statement st = connectDB(url,username,password);
        String valueDB = sqlRequest1(st,monitor,column);
        closeDBConnection();
        Log.info(valueDB);
        Assert.assertTrue(valueDB == null);
    }
}

