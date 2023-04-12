package com.study.onlinemarket.domain.dto.request;

import lombok.Value;

@Value
public class CreateAccountRequest {
    String username;

    String password;

    String role;
}
