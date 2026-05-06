package com.turkcell.kutuphane_hw_spring_starter.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.turkcell.kutuphane_hw_spring_starter.dto.*;
import com.turkcell.kutuphane_hw_spring_starter.service.BorrowServiceImpl;

@RestController
@RequestMapping("api/borrows")
public class BorrowsController {
    private final BorrowServiceImpl borrowServiceImpl;

    public BorrowsController(BorrowServiceImpl borrowServiceImpl) {
        this.borrowServiceImpl = borrowServiceImpl;
    }

    @PostMapping
    public ListBorrowResponse create(@RequestBody CreateBorrowRequest request) {
        return this.borrowServiceImpl.create(request);
    }

    @GetMapping
    public List<ListBorrowResponse> getAll() {
        return this.borrowServiceImpl.getAll();
    }
}