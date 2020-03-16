package com.example.demo;

import com.example.demo.mapper.AccountMapper;
import com.example.demo.pojo.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private AccountMapper accountMapper;
    @Test()
    public void test(){
        List<Account> accounts=accountMapper.findAll();
        System.out.println(accounts);
    }

}
