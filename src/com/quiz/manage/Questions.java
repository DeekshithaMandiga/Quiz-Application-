package com.quiz.manage;

public class Questions {

    private int qid;
    private String qstn;

    public Questions(int qid, String qstn) {


        this.qid = qid;
        this.qstn = qstn;
    }



    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQstn() {
        return qstn;
    }

    public void setQstn(String qstn) {
        this.qstn = qstn;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "qid=" + qid +
                ", qstn='" + qstn + '\'' +
                '}';
    }
}
