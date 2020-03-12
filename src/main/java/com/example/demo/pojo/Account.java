package com.example.demo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 陈睿
 * @date 2020-03-11 14:33
 */
@Data
public class Account implements Serializable {
    private Integer id;
    private String name;
    private String money;
}
