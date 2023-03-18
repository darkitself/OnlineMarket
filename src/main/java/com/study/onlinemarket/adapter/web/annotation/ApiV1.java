package com.study.onlinemarket.adapter.web.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Аннотация, используемая как alias для {@link RestController} и {@link RequestMapping} с рутом /api/v1 <br><br>
 * Используется для формирования клиентского апи
 */
@Documented
@RestController
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(value = "/api/v1", produces = APPLICATION_JSON_VALUE)
public @interface ApiV1 {
}