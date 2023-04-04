package com.crudjdbc;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Student> studentsList = new ArrayList<>();

            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thedynamicdoersdb", System.getenv("USER_NAME"), System.getenv("USER_PASS"));
            Statement statement = dbConnection.createStatement();
            statement.execute("select * from students;");

            ResultSet rs = statement.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                studentsList.add(new Student(id, name, email));
            }

            for (Student student: studentsList) {
                System.out.println("Student ID: " + student.id + ", student name: " + student.name +
                        ", student email: " + student.email);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        System.getenv();

    }
}