package com.study.onlinemarket.adapter.listener;

import com.study.onlinemarket.domain.event.NewAccountCreated;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.Instant;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NewAccountCreatedListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleNewAccountCreatedEvent(NewAccountCreated event) {
        System.out.println(Instant.now().toString() + " TransactionalEventListener handler start");
        System.out.printf("New user with username '%s' registered!\n", event.getUsername());
        System.out.println(Instant.now().toString() + " TransactionalEventListener handler end");
    }
}
