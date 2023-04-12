package com.study.onlinemarket.domain.entity.context;


import lombok.Value;

@Value
public class AccountContext {
    String username;

    String password;

    String role;
}

