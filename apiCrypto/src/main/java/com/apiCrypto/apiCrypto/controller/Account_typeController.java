package com.apiCrypto.apiCrypto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Account")
public class Account_typeController {

    @Autowired
    private Account_typeService accS;

}
