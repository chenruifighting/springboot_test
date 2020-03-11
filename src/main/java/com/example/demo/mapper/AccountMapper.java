package com.example.demo.mapper;

import com.example.demo.pojo.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 陈睿
 * @date 2020-03-11 14:36
 */
public interface AccountMapper {
    @Select("select * from account")
    List<Account> findAll();
}
