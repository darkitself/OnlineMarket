package com.study.onlinemarket.domain.entity;


import com.study.onlinemarket.domain.entity.context.AccountContext;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    Long id;

    String username;

    String password;

    String role;

    Boolean ban;

    public static Account createAccountFrom(AccountContext context) {
        return Account.builder()
                .username(context.getUsername())
                .password(context.getPassword())
                .role(context.getRole())
                //TODO: change column name to enabled
                .ban(true)
                .build();
    }
}
