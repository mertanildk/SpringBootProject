package com.deke.testredisdbjpa.api.controllers;


import com.deke.testredisdbjpa.entity.HostelType;
import com.deke.testredisdbjpa.utils.responseApi.RestResponseEntity;
import com.deke.testredisdbjpa.service.HostelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/hostel-type")
public class HostelTypeController {

    private final HostelTypeService hostelTypeService;

    public HostelTypeController(HostelTypeService hostelTypeService) {
        this.hostelTypeService = hostelTypeService;
    }

    @PostMapping("/create-hostel-type")
    public ResponseEntity<RestResponseEntity<HostelType>> createHostelType(@RequestBody List<String> hostelTypeNames){
        return ResponseEntity.ok(RestResponseEntity.response(hostelTypeService.saveAllHostelTypes(hostelTypeNames)));
    }
    @GetMapping("/get-all-hostel-type")
    public ResponseEntity<RestResponseEntity<List<HostelType>>> getAllHostelType(){
        return ResponseEntity.ok(RestResponseEntity.response(hostelTypeService.findAll()));
    }
}
