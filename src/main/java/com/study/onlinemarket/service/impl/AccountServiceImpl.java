package com.study.onlinemarket.service.impl;

import com.study.onlinemarket.adapter.repository.AccountRepository;
import com.study.onlinemarket.domain.dto.request.CreateAccountRequest;
import com.study.onlinemarket.domain.dto.response.AccountResponse;
import com.study.onlinemarket.domain.entity.Account;
import com.study.onlinemarket.domain.entity.context.AccountContext;
import com.study.onlinemarket.service.AccountService;
import com.study.onlinemarket.service.factory.AccountFactory;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.Instant;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountServiceImpl implements AccountService {

    MeterRegistry meterRegistry;
    AccountFactory accountFactory;
    AccountRepository accountRepository;

    @NonFinal
    Counter customCounter;

    @PostConstruct
    public void init() {
        customCounter = Counter
                .builder("my.custom.metric.counter")
                .register(meterRegistry);
    }

    @Override
    public AccountResponse createNewAccount(CreateAccountRequest accountRequest) {

        AccountContext context = accountFactory.createContextFrom(accountRequest);
        Account account = new Account(context);
        account = accountRepository.save(account);
        customCounter.increment();
        return accountFactory.createResponse(account);
    }

    @Async
    @Scheduled(fixedRate = 1000, initialDelay = 10000)
    @SneakyThrows
    public void increment() {
        log.info("Job started at {}", Instant.now());
        Thread.sleep(4000);
        log.warn("Job end at {}", Instant.now());
    }
}
