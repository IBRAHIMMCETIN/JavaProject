package com.turkcell.kutuphane_hw_spring_starter.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.turkcell.kutuphane_hw_spring_starter.dto.CreateReturnRequest;
import com.turkcell.kutuphane_hw_spring_starter.dto.ListReturnResponse;
import com.turkcell.kutuphane_hw_spring_starter.service.ReturnRecordServiceImpl;

@RestController
@RequestMapping("api/returns")
public class ReturnRecordsController {
    private final ReturnRecordServiceImpl returnRecordServiceImpl;

    public ReturnRecordsController(ReturnRecordServiceImpl returnRecordServiceImpl) {
        this.returnRecordServiceImpl = returnRecordServiceImpl;
    }

    @PostMapping
    public ListReturnResponse create(@RequestBody CreateReturnRequest request) {
        return this.returnRecordServiceImpl.create(request);
    }

    @GetMapping
    public List<ListReturnResponse> getAll() {
        return this.returnRecordServiceImpl.getAll();
    }
}