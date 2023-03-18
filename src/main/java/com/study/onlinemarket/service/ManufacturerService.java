package com.study.onlinemarket.service;

import com.study.onlinemarket.domain.dto.request.CreateManufacturerRequest;
import com.study.onlinemarket.domain.dto.response.ManufacturerResponse;

import java.util.List;

public interface ManufacturerService {

    List<ManufacturerResponse> getManufacturers();

    ManufacturerResponse addNewManufacturer(CreateManufacturerRequest request);
}
