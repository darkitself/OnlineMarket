package com.study.onlinemarket.service;

import com.study.onlinemarket.domain.dto.request.CreateAccountRequest;
import com.study.onlinemarket.domain.dto.response.AccountResponse;

public interface AccountService {
    AccountResponse createNewAccount(CreateAccountRequest accountRequest);
}
