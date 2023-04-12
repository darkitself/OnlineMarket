package com.study.onlinemarket.service.impl;

import com.study.onlinemarket.adapter.repository.AccountRepository;
import com.study.onlinemarket.domain.dto.request.CreateAccountRequest;
import com.study.onlinemarket.domain.dto.response.AccountResponse;
import com.study.onlinemarket.domain.entity.Account;
import com.study.onlinemarket.domain.entity.context.AccountContext;
import com.study.onlinemarket.service.AccountService;
import com.study.onlinemarket.service.factory.AccountFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountServiceImpl implements AccountService {

    AccountFactory accountFactory;
    AccountRepository accountRepository;

    @Override
    public AccountResponse createNewAccount(CreateAccountRequest accountRequest) {
        AccountContext context = accountFactory.createContextFrom(accountRequest);
        Account account = Account.createAccountFrom(context);
        account = accountRepository.save(account);
        return accountFactory.createResponse(account);
    }
}
