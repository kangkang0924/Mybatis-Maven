package com.mybatis.pojo03;

import java.util.List;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/10/03/11:07
 */
public class Type {
    private int id;
    private String name;
    /**
     * 多对一映射
     */
    private List<ProductInfo> pis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductInfo> getPis() {
        return pis;
    }

    public void setPis(List<ProductInfo> pis) {
        this.pis = pis;
    }

    @Override
    public String toString() {
        return "type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pis=" + pis +
                '}';
    }
}
