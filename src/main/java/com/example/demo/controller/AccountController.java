package com.example.demo.controller;

import com.example.demo.pojo.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 陈睿
 * @date 2020-03-09 15:24
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("findAll")
    public String findAll(Model model){
        List<Account> accounts=accountService.findAll();
        model.addAttribute("accounts",accounts);
        return "Account";
    }
}
