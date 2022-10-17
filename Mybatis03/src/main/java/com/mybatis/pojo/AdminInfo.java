package com.mybatis.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/10/12/8:39
 */
@Data
public class AdminInfo {

    private int id;
    private String name;
    private List<Functions> fs;

}
