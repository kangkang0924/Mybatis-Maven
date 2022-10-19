package com.mybatis.pojo03;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/09/26/11:14
 */
public class IdCard {
    private int id;
    private String cno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "id=" + id +
                ", cno='" + cno + '\'' +
                '}';
    }

}
