package com.study.onlinemarket.adapter.web.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


/**
 * Аннотация, используемая как alias для {@link RestController} и {@link RequestMapping} с рутом /admin/v1 <br><br>
 * Используется для формирования админского апи
 */
@Documented
@RestController
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(value = "/admin/v1", produces = APPLICATION_JSON_VALUE)
public @interface AdminApiV1 {
}
