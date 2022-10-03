package com.test.po;

/**
 * @author º«µÂ¿µ~
 * @version 1.0
 * @time 2022/09/21/8:23
 */
public class Category {
    private int cid;
    private String cname;
    private String describe;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
