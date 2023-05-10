package com.study.onlinemarket.common.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Endpoint(id = "datetime")
public class CustomActuator {

    @ReadOperation
    public Instant dateTime() {
        return Instant.now();
    }
}
