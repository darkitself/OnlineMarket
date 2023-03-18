package com.study.onlinemarket.adapter.web.controller;

import com.study.onlinemarket.adapter.web.annotation.ApiV1;
import com.study.onlinemarket.domain.dto.response.ManufacturerResponse;
import com.study.onlinemarket.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@ApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ManufacturerController {

    ManufacturerService manufacturerService;

    @GetMapping("/manufacturers/list")
    public ResponseEntity<List<ManufacturerResponse>> getProducts() {
        return new ResponseEntity<>(manufacturerService.getManufacturers(), HttpStatus.OK);
    }
}
