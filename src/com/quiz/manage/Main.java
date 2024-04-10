package com.quiz.manage;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;

public class Main {
    public static String userName="";
    public static String userId="";



    static class QuizTimerTask extends TimerTask {

        public void run() {
            System.out.println("\nTime's up! Quiz has ended.");
            int mrks=Methods.calculatemarks();

            System.out.println("your SCORE is:"+mrks);
            System.out.println("pdf generated successfully");
            System.out.println("You can view PDF");
            //Methods.deleteresult();
            try {
                Document doc = new Document(PageSize.A4);
                PdfWriter.getInstance(doc, new FileOutputStream("result.pdf"));
                doc.open();

                doc.add(new Paragraph(" Hi USER! You have successfully completed the Quiz\n\n"));
                doc.add(new Paragraph("                                                       SCORE CARD                   \n\n "));
                doc.add(new Paragraph("Name:"+userName));
                doc.add(new Paragraph("\n\n"));
                doc.add(new Paragraph("Id:"+userId));
                doc.add(new Paragraph("\n\n"));

                int a=Methods.calculatemarks();

                doc.add(new Paragraph("SCORE:"+a*10));
                doc.add(new Paragraph("\n\n"));

                doc.add(new Paragraph("Thankyou for visiting,Better Luck Next Time!"));

                Methods.deleteresult();
                doc.close();

            }
            catch(Exception e)
            {
                System.out.println(e);
            }

            System.exit(0); // End the quiz when the timer finishes
        }
    }

    public static void main(String[] args) throws IOException {





        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("-------------------\n");
        System.out.println("Welcome to QUIZ APP\n--------------------");

        System.out.println("Press 1 for ADMIN\nPress 2 for USER\nPress 3 to EXIT");
        int c = Integer.parseInt(br.readLine());


        if (c == 1) {
            //admin details
            System.out.println("Enter admin name:");
            String adminName = br.readLine();
            System.out.println("Enter admin number:");
            String adminId = br.readLine();
            Admin admin = new Admin(adminName, adminId);
        } else if (c == 2) {
            //user data

            System.out.println("Enter your Name :");
            userName = br.readLine();
            System.out.println("Enter your id:");
            userId = br.readLine();
            System.out.println("HI "+userName+" WELCOME!");
            User user = new User(userName, userId);
        }
        while (true) {
            if (c == 1) {
                //navigate to admin class
                System.out.println("Hello ADMIN!");
                System.out.println("Press 1 to ADD question\nPress 2 to DELETE question\nPress 3 to MODIFY question");
                int d=Integer.parseInt(br.readLine());
                if(d==1) {
                    System.out.println("Enter Question id:");
                    int qid = Integer.parseInt(br.readLine());
                    System.out.println("Enter question");
                    String qstn = br.readLine();


                    Questions ques = new Questions(qid, qstn);
                    boolean f = Methods.insertQuestions(ques);
                    if (f) {
                        System.out.println("Question added succesfully");
                    } else {
                        System.out.println("Something went wrong;");
                    }
                    //enter options fr ques
                    int count = 1;
                    while (count <= 4) {
                        System.out.println("Enter optid");
                        int optid=Integer.parseInt(br.readLine());


                        System.out.println("Enter options:");
                        String optn = br.readLine();
                        Options op = new Options(optid,qid, optn);
                        boolean f1 = Methods.addOptions(op);
                        if (f1) {
                            System.out.println("option added successfully");
                        } else {
                            System.out.println("something went wrong");
                        }
                        System.out.println(op);
                        count++;
                        if (count > 4) {
                            System.out.println("All options added succesfully");
                        }

                    }
                    System.out.println("Enter correct option:");
                    int optnno=Integer.parseInt(br.readLine());
                    Answers ans=new Answers(qid,optnno);
                    boolean f2=Methods.addAnswer(ans);
                    if(f2)
                    {
                        System.out.println("answer added successfully");
                    }
                    else {
                        System.out.println("something went wrong");
                    }
                }
                else if(d==2)
                {
                    System.out.println("Enter question to be deleted:");
                    int q=Integer.parseInt(br.readLine());
                    boolean f=Methods.deletequestion(q);
                    if(f)
                    {
                        System.out.println("Deleted question successfully");
                    }
                    else {
                        System.out.println("something went wrong,try again!");
                    }
                }
                else if(d==3)
                {
                    System.out.println("Enter question no to be modified:");
                    int qt=Integer.parseInt(br.readLine());
                    System.out.println("press 1 to MODIFY question\n press 2 to MODIFY options\n press 3 to MODIFY answer");
                    int a=Integer.parseInt(br.readLine());
                    if(a==1)
                    {
                        System.out.println("Enter question");
                        String q=br.readLine();
                        boolean f=Methods.modifyquestion(qt,q);
                        if(f)
                        {
                            System.out.println("question updated succesfully");
                        }
                        else {
                            System.out.println("Error ");
                        }
                    }
                    else if(a==2)
                    {
                        System.out.println("Enter option no to be modified");
                        int opno=Integer.parseInt(br.readLine());
                        System.out.println("Enter options:");
                        String optn=br.readLine();
                        boolean f=Methods.modifyoptn(opno,optn);
                        if(f)
                        {
                            System.out.println("option updated succesfully");
                        }
                        else {
                            System.out.println("Error");
                        }

                    }
                    else if(a==3)
                    {
                        System.out.println("Enter answer to be modified");
                        String ans=br.readLine();
                        boolean f=Methods.modifyans(qt,ans);
                        if(f)
                        {
                            System.out.println("answer updated succesfully");
                        }
                        else {
                            System.out.println("error");
                        }
                    }


                }



            }
            if(c==2)
            {
                System.out.println("------------------------------------");
                System.out.println("1.press 1 to START TEST\n 2.press 2 to EXIT");
                System.out.println("------------------------------------");
                int r=Integer.parseInt(br.readLine());
                if(r==1)
                {
                    System.out.println("--------WELCOME TO IEST YOUR TIME STARTS NOW----------");
                    System.out.println("---QUESTIONS are as follows---");
                    System.out.println("------------------------------------");

                    Timer timer = new Timer();
                    final int QUIZ_TIME_LIMIT_SECONDS = 1000;
                    timer.schedule(new QuizTimerTask(), QUIZ_TIME_LIMIT_SECONDS * 1000);
                    Methods.showAll();
                    System.out.println("You can modify your ANSWERS before time runs out");
                    while(true)
                    {

                        System.out.println("press 1 to MODIFY\npress 2 to EXIT");
                        System.out.println("------------------------------------");
                        int r1=Integer.parseInt(br.readLine());
                        if(r1==1) {
                            System.out.println("Enter question no of answer to modified:");
                            int r2 = Integer.parseInt(br.readLine());
                            System.out.println("Enter new answer:");
                            String q = br.readLine();
                            boolean f = Methods.modifyanswer(r2, q);
                            if (f) {
                                System.out.println("answer modified succesfully");
                                System.out.println("---------------------------");
                            } else {
                                System.out.println("Error ");
                            }
                        }
                        else if(r1==2)
                        {

                            QuizTimerTask qt=new QuizTimerTask();
                            qt.run();
                            break;
                        }


                    }






                        // Wait for the timer to finish
                        //Thread.sleep(QUIZ_TIME_LIMIT_SECONDS * 1000);

                        //timer.cancel();









                }if(r==2)
            {

                System.exit(0);
            }
            }
        }

    }
}
