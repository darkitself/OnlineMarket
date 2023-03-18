package com.study.onlinemarket.adapter.web.controller;

import com.study.onlinemarket.adapter.web.annotation.AdminApiV1;
import com.study.onlinemarket.domain.dto.request.CreateManufacturerRequest;
import com.study.onlinemarket.domain.dto.response.ManufacturerResponse;
import com.study.onlinemarket.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static lombok.AccessLevel.PRIVATE;

@AdminApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AdminManufacturerController {

    ManufacturerService manufacturerService;

    @PostMapping("/manufacturers/add")
    public ResponseEntity<ManufacturerResponse> createManufacturer(@RequestBody CreateManufacturerRequest manufacturerRequest) {
        return new ResponseEntity<>(manufacturerService.addNewManufacturer(manufacturerRequest), HttpStatus.OK);
    }
}
