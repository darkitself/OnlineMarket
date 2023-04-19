package com.study.onlinemarket.domain.event;

import com.study.onlinemarket.domain.entity.Account;
import lombok.Value;

@Value
public class NewAccountCreated {
    Long id;
    String username;

    public static NewAccountCreated from(Account account) {
        return new NewAccountCreated(account.getId(), account.getUsername());
    }
}
