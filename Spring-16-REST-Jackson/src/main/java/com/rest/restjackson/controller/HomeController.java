package com.rest.restjackson.controller;


import com.rest.restjackson.entity.Account;
import com.rest.restjackson.entity.User;
import com.rest.restjackson.repository.AccountRepository;
import com.rest.restjackson.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public HomeController(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/users")
    public List<User> readAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/accounts")
    public List<Account> readAllAccounts() {
        return accountRepository.findAll();
    }
}