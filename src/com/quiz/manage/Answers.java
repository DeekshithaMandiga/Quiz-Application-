package com.quiz.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Answers {
    private int ansid;
    private int qstnid;
    private int optnno;

    public Answers(int ansid, int qstnid, int optnno) {
        super();
        this.ansid = ansid;
        this.qstnid = qstnid;
        this.optnno = optnno;
    }
    public Answers(int qstnid,int optnno)
    {
        super();
        this.qstnid=qstnid;
        this.optnno=optnno;
    }
    public Answers()
    {
        super();
    }



    public int getQstnid() {
        return qstnid;
    }

    public void setQstnid(int qstnid) {
        this.qstnid = qstnid;
    }

    public int getOptnno() {
        return optnno;
    }

    public void setOptnno(int optnno) {
        this.optnno = optnno;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "ansid=" + ansid +
                ", qstnid=" + qstnid +
                ", optnno=" + optnno +
                '}';
    }
}
