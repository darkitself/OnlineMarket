package com.study.onlinemarket.domain.entity;


import com.study.onlinemarket.domain.entity.context.AccountContext;
import com.study.onlinemarket.domain.event.NewAccountCreated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account extends BaseDomainEntity {

    String username;

    String password;

    String role;

    Boolean ban;

    public Account(AccountContext accountContext) {
        Long a = 2L;
        username = accountContext.getUsername();
        password = accountContext.getPassword();
        role = accountContext.getRole();
        ban = true;
        registerEvent(() -> NewAccountCreated.from(this));
    }
}
