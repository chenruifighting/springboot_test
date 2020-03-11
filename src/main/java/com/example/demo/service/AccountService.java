package com.example.demo.service;

import com.example.demo.pojo.Account;

import java.util.List;

/**
 * @author 陈睿
 * @date 2020-03-11 14:40
 */
public interface AccountService {
    List<Account> findAll();
}
