package com.study.onlinemarket.adapter.listener;

import com.study.onlinemarket.domain.event.NewAccountCreated;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NewAccountCreatedAsyncListener {

    @EventListener
    @SneakyThrows
    public void handleNewAccountCreatedEventAsync(NewAccountCreated event) {
        System.out.println(Instant.now().toString() + " Async handler start");
        System.out.printf("New user with username '%s' registered ASYNC!\n", event.getUsername());
        System.out.println(Instant.now().toString() + " Async handler end");
    }
}
