package com.turkcell.spring_starter.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.spring_starter.dto.CreateTagRequest;
import com.turkcell.spring_starter.dto.CreatedTagResponse;
import com.turkcell.spring_starter.dto.ListTagResponse;
import com.turkcell.spring_starter.service.TagServiceImpl;

@RestController
@RequestMapping("api/tags")
public class TagsController {
    private final TagServiceImpl tagServiceImpl;

    public TagsController(TagServiceImpl tagServiceImpl) {
        this.tagServiceImpl = tagServiceImpl;
    }

    @PostMapping
    public CreatedTagResponse create(@RequestBody CreateTagRequest createTagRequest) {
        return this.tagServiceImpl.create(createTagRequest);
    }

    @GetMapping
    public List<ListTagResponse> getAll() {
        return this.tagServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public ListTagResponse getById(@PathVariable UUID id) {
        return this.tagServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public ListTagResponse update(@PathVariable UUID id, @RequestBody CreateTagRequest updateTagRequest) {
        return this.tagServiceImpl.update(id, updateTagRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.tagServiceImpl.delete(id);
    }
}