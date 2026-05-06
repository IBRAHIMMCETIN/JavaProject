package com.turkcell.kutuphane_hw_spring_starter.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

import com.turkcell.kutuphane_hw_spring_starter.dto.ListPenaltyResponse;
import com.turkcell.kutuphane_hw_spring_starter.service.PenaltyServiceImpl;

@RestController
@RequestMapping("api/penalties")
public class PenaltiesController {
    private final PenaltyServiceImpl penaltyServiceImpl;

    public PenaltiesController(PenaltyServiceImpl penaltyServiceImpl) {
        this.penaltyServiceImpl = penaltyServiceImpl;
    }

    @GetMapping
    public List<ListPenaltyResponse> getAll() {
        return this.penaltyServiceImpl.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.penaltyServiceImpl.delete(id);
    }
}