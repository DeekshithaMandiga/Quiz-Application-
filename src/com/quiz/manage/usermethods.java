package com.quiz.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class usermethods {
    public static boolean adduserans(useranswers ua)
    {
        boolean f = false;
        //jdbc code
        try {
            Connection con = QuizConnections.createC();
            String qry = "insert into useranswers(qstnid,userans) values(?,?)";
            PreparedStatement pst = con.prepareStatement(qry);

            pst.setInt(1, ua.getQstnid());
            pst.setInt(2, ua.getUserans());
            pst.executeUpdate();
            f = true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }

}
