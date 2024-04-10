package com.quiz.manage;

public class useranswers {
    private int useransid;
    private int userans;
    private int qstnid;

    public useranswers(int qstnid,int useransid, int userans) {
        super();
        this.qstnid=qstnid;
        this.useransid = useransid;
        this.userans = userans;
    }
    public useranswers(int qstnid,int userans) {
        super();
        this.qstnid=qstnid;

        this.userans = userans;
    }
    public useranswers()
    {
        super();
    }

    public int getQstnid() {
        return qstnid;
    }

    public void setQstnid(int qstnid) {
        this.qstnid = qstnid;
    }

    public int getUseransid() {
        return useransid;
    }

    public void setUseransid(int useransid) {
        this.useransid = useransid;
    }

    public int getUserans() {
        return userans;
    }

    public void setUserans(int userans) {
        this.userans = userans;
    }

    @Override
    public String toString() {
        return "useranswers{" +
                "useransid=" + useransid +
                ", userans='" + userans + '\'' +
                ", qstnid=" + qstnid +
                '}';
    }
}
