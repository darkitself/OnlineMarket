package com.study.onlinemarket.adapter.web.advice;

import com.study.onlinemarket.adapter.web.annotation.ApiAdvice;
import com.study.onlinemarket.common.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

@ApiAdvice
@RequiredArgsConstructor
public class NotFoundAdvice {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> notFound(Exception e) {

        return status(NOT_FOUND)
                .body(e.getMessage());
    }
}