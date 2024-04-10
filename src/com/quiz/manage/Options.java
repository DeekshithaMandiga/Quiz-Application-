package com.quiz.manage;

public class Options {
    private int optnid;
    private int qstnid;
    private String optn;

    public Options( int optnid,int qstnid, String optn) {
        super();
        this.optnid=optnid;

        this.qstnid = qstnid;
        this.optn = optn;
    }
    public Options(int qstnid, String optn)
    {
        this.qstnid = qstnid;
        this.optn = optn;

    }
    public int getOptnid()
    {
        return optnid;
    }
    public void setOptnid(int optnid) {
        this.optnid = optnid;
    }



    public int getQstnid() {
        return qstnid;
    }

    public void setQstnid(int qstnid) {
        this.qstnid = qstnid;
    }

    public String getOptn() {
        return optn;
    }

    public void setOptn(String optn) {
        this.optn = optn;
    }

    @Override
    public String toString() {
        return "Options{" +
                "optnid=" + optnid +
                ", qstnid=" + qstnid +
                ", optn='" + optn + '\'' +
                '}';
    }
}
