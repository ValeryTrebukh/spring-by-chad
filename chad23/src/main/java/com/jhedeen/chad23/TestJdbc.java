package com.jhedeen.chad23;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "valery";
        String pass = "Trebukh";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection successful");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
