package com.study.onlinemarket.service.factory;

import com.study.onlinemarket.domain.dto.request.CreateAccountRequest;
import com.study.onlinemarket.domain.dto.response.AccountResponse;
import com.study.onlinemarket.domain.entity.Account;
import com.study.onlinemarket.domain.entity.context.AccountContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountFactory {

    PasswordEncoder passwordEncoder;

    public AccountResponse createResponse(Account account) {
        return new AccountResponse(
                account.getUsername(),
                account.getRole()
        );
    }

    public AccountContext createContextFrom(CreateAccountRequest createAccountRequest) {
        return new AccountContext(
                createAccountRequest.getUsername(),
                passwordEncoder.encode(createAccountRequest.getPassword()),
                createAccountRequest.getRole()
        );
    }
}
