package com.study.onlinemarket.adapter.web.controller;


import com.study.onlinemarket.adapter.web.annotation.ApiV1;
import com.study.onlinemarket.common.annotation.LogExecutionTime;
import com.study.onlinemarket.domain.dto.request.CreateAccountRequest;
import com.study.onlinemarket.domain.dto.response.AccountResponse;
import com.study.onlinemarket.service.AccountService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static lombok.AccessLevel.PRIVATE;

@ApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AccountController {

    AccountService accountService;

    @PostMapping("/register")
    @Timed(value = "register_time")
    @LogExecutionTime
    public ResponseEntity<AccountResponse> register(@RequestBody CreateAccountRequest accountRequest) {
        return new ResponseEntity<>(accountService.createNewAccount(accountRequest), HttpStatus.OK);
    }
}
