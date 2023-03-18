package com.study.onlinemarket.adapter.web.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Аннотация, используемая как alias для {@link RestControllerAdvice} и {@link Order} <br><br>
 * Используется для создания advice'ов для формирования понятного ответа при возникновении исключений <br><br>
 * Advice'ы, помеченные данной аннотацией, применяются к контроллерам из пакета {@link com.study.onlinemarket.adapter.web}
 */
@Documented
@Target(TYPE)
@Retention(RUNTIME)
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice(basePackages = "com.study.onlinemarket.adapter.web")
public @interface ApiAdvice {
}
