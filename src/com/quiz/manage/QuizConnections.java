package com.quiz.manage;

import java.sql.Connection;
import java.sql.DriverManager;



    public class QuizConnections {
        static Connection con;
        public static Connection createC(){

            try {
                //load driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                //create the connection
                String user="root";
                String password="Deekshitha0805";
                String url="jdbc:mysql://localhost:3306/quiz_app";
                con= DriverManager.getConnection(url,user,password);


            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            return con;

        }
    }



