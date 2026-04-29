package com.turkcell.spring_starter.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.Repository.TagRepository;
import com.turkcell.spring_starter.dto.CreateTagRequest;
import com.turkcell.spring_starter.dto.CreatedTagResponse;
import com.turkcell.spring_starter.dto.ListTagResponse;
import com.turkcell.spring_starter.entity.Tag;

@Service
public class TagServiceImpl {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public CreatedTagResponse create(CreateTagRequest createTagRequest) {
        Tag tag = new Tag();
        tag.setName(createTagRequest.getName());

        tag = this.tagRepository.save(tag);

        CreatedTagResponse response = new CreatedTagResponse();
        response.setId(tag.getId());
        response.setName(tag.getName());

        return response;
    }

    public List<ListTagResponse> getAll() {
        List<Tag> tags = this.tagRepository.findAll();

        List<ListTagResponse> responses = tags.stream().map(tag -> {
            ListTagResponse response = new ListTagResponse();
            response.setId(tag.getId());
            response.setName(tag.getName());
            return response;
        }).toList();

        return responses;
    }

    public ListTagResponse getById(UUID id) {
        Tag tag = this.tagRepository.findById(id).orElseThrow(() -> new RuntimeException("Etiket bulunamadı"));
        
        ListTagResponse response = new ListTagResponse();
        response.setId(tag.getId());
        response.setName(tag.getName());
        return response;
    }

    public ListTagResponse update(UUID id, CreateTagRequest updateTagRequest) {
        Tag tag = this.tagRepository.findById(id).orElseThrow(() -> new RuntimeException("Etiket bulunamadı"));
        tag.setName(updateTagRequest.getName());
        
        tag = this.tagRepository.save(tag);

        ListTagResponse response = new ListTagResponse();
        response.setId(tag.getId());
        response.setName(tag.getName());
        return response;
    }

    public void delete(UUID id) {
        this.tagRepository.deleteById(id);
    }
}