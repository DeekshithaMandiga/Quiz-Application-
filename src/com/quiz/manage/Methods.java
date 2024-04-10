package com.quiz.manage;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import java.io.*;


public class Methods {
    public static boolean insertQuestions(Questions q) {
        boolean f = false;
        //jdbc code
        try {
            Connection con = QuizConnections.createC();
            String qry = "insert into questions(qstnid,qstn) values(?,?)";
            PreparedStatement pst = con.prepareStatement(qry);

            pst.setInt(1, q.getQid());
            pst.setString(2, q.getQstn());
            pst.executeUpdate();
            f = true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return f;

    }

    public static boolean addOptions(Options op) {
        boolean f1 = false;
        try {
            Connection con = QuizConnections.createC();
            String qry = "insert into options(optid,qstnid,optn) values(?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1,op.getOptnid());
            pst.setInt(2, op.getQstnid());
            pst.setString(3, op.getOptn());
            pst.executeUpdate();
            f1 = true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return f1;
    }

    public static boolean addAnswer(Answers ans) {
        boolean f2 = false;
        try {
            Connection con = QuizConnections.createC();
            String qry = "insert into answers(qstnid,optnno) values(?,?)";
            PreparedStatement pst = con.prepareStatement(qry);

            pst.setInt(1, ans.getQstnid());
            pst.setInt(2, ans.getOptnno());
            pst.executeUpdate();
            f2 = true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return f2;

    }

    public static boolean deletequestion(int qu) {
        boolean f = false;
        //jdbc code
        try {
            Connection con = QuizConnections.createC();
            String q = "delete from questions where qstnid=? ";

            String q2 = "delete from options where qstnid=?";
            String q3 = "delete from answers where qstnid=?";
            PreparedStatement pst = con.prepareStatement(q);
            PreparedStatement pst2 = con.prepareStatement(q2);
            PreparedStatement pst3 = con.prepareStatement(q3);

            pst.setInt(1, qu);

            pst.executeUpdate();
            pst2.setInt(1, qu);
            pst2.executeUpdate();
            pst3.setInt(1, qu);
            pst3.executeUpdate();
            f = true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }

    public static boolean modifyquestion(int qu, String q) {
        boolean f = false;
        try {
            Connection con = QuizConnections.createC();
            String query = "update questions set qstn=? where qstnid=?";
            PreparedStatement pstat = con.prepareStatement(query);

            pstat.setString(1, q);
            pstat.setInt(2, qu);

            pstat.executeUpdate();
            f = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;


    }

    public static boolean modifyoptn(int qt, String q) {
        boolean f = false;
        try {
            Connection con = QuizConnections.createC();
            String query = "update options set optn=? where optid=?";
            PreparedStatement pstat = con.prepareStatement(query);

            pstat.setString(1, q);
            pstat.setInt(2, qt);

            pstat.executeUpdate();
            f = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;

    }

    public static boolean modifyans(int qt, String q) {
        boolean f = false;
        try {
            Connection con = QuizConnections.createC();
            String query = "update answers set optnno=? where qstnid=?";
            PreparedStatement pstat = con.prepareStatement(query);
            pstat.setInt(2, qt);
            pstat.setString(1, q);

            pstat.executeUpdate();
            f = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;

    }


    public static void showAll() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean f = false;
        try {
            Connection con = QuizConnections.createC();
            String q = "select * from questions;";
            Statement st = con.createStatement();
            ResultSet set = st.executeQuery(q);
            while (set.next()) {
                int qid = set.getInt("qstnid");
                String qstn = set.getString("qstn");
                System.out.println("Question no :" + qid);
                System.out.println("Question:" + qstn);

                String a = "select * from options";
                Statement st1 = con.createStatement();
                ResultSet set1 = st1.executeQuery(a);
                while (set1.next()) {
                    int qid2 = set1.getInt(2);


                    if (qid2 == qid) {
                        int optid = set1.getInt("optid");
                        String optn = set1.getString("optn");
                        System.out.println(optid + " optn:" + optn);
                    }}
                    System.out.println("Enter your answer:");
                    int  ans =Integer.parseInt(br.readLine());
                    useranswers um = new useranswers(qid, ans);
                    boolean f1 = usermethods.adduserans(um);
                    if (f1) {
                        System.out.println("answer saved successfully");
                        System.out.println("------------------------------------");
                    } else {
                        System.out.println("something went wrong");
                    }





            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static int calculatemarks()
    {
        int marks=0;
        try {
            Connection con = QuizConnections.createC();
            String q = "select * from answers;";
            Statement st = con.createStatement();
            ResultSet set = st.executeQuery(q);



            String q2 = "select * from useranswers";
            Statement st1 = con.createStatement();
            ResultSet set1 = st1.executeQuery(q2);

            while(set.next() && set1.next())
            {
                int ans=set.getInt("optnno");
                int userans=set1.getInt("userans");



                    if(ans==userans)
                    {
                        marks++;
                    }




            }




        }
        catch(Exception e)
        {
            System.out.println(e);
        }return marks;
    }
    public static void deleteresult()
    {
        try{
            Connection con = QuizConnections.createC();
            String q="truncate useranswers";
            PreparedStatement st = con.prepareStatement(q);
            st.executeUpdate();



        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static boolean modifyanswer(int a,String q)
    {
        boolean f = false;
        try {
            Connection con = QuizConnections.createC();
            String query = "update useranswers set userans=? where qstnid=?";
            PreparedStatement pstat = con.prepareStatement(query);
            pstat.setInt(2, a);
            pstat.setString(1, q);

            pstat.executeUpdate();
            f = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;

    }

}










