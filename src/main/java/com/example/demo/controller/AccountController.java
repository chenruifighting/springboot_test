package com.example.demo.controller;

import com.example.demo.pojo.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author 陈睿
 * @date 2020-03-09 15:24
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("findAll")
    public String findAll(Model model) {
        List<Account> accounts=redisTemplate.opsForList().range("findAll",0,-1);
        if(accounts.isEmpty()){
            accounts=accountService.findAll();
            redisTemplate.opsForList().rightPushAll("findAll",accounts);
            System.out.println("从数据库中获取");
        }else {
            System.out.println("从缓存中获取");
        }
        model.addAttribute("accounts",accounts);
        return "Account";
    }

    //双检查锁DCL,高并发下防止缓存穿透
    private static volatile List<Account> accounts=null;
    @GetMapping("safeFindAll")
    public String safeFindAll(Model model) {
        accounts=redisTemplate.opsForList().range("safeFindAll",0,-1);
        if(accounts.isEmpty()){
            synchronized (this){
                accounts=redisTemplate.opsForList().range("safeFindAll",0,-1);
                if(accounts.isEmpty()){
                    accounts=accountService.findAll();
                    redisTemplate.opsForList().rightPushAll("safeFindAll",accounts);
                    System.out.println("从数据库中获取");
                }else {
                    System.out.println("从缓存中获取");
                }
            }
        }else {
            System.out.println("从缓存中获取");
        }
        model.addAttribute("accounts",accounts);
        return "Account";
    }
}
