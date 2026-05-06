package com.turkcell.kutuphane_hw_spring_starter.controller;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;
import com.turkcell.kutuphane_hw_spring_starter.dto.*;
import com.turkcell.kutuphane_hw_spring_starter.service.StudentServiceImpl;

@RestController
@RequestMapping("api/students")
public class StudentsController {
    private final StudentServiceImpl studentServiceImpl;

    public StudentsController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @PostMapping
    public ListStudentResponse create(@RequestBody CreateStudentRequest request) {
        return this.studentServiceImpl.create(request);
    }

    @GetMapping
    public List<ListStudentResponse> getAll() {
        return this.studentServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public ListStudentResponse getById(@PathVariable UUID id) {
        return this.studentServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public ListStudentResponse update(@PathVariable UUID id, @RequestBody CreateStudentRequest request) {
        return this.studentServiceImpl.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.studentServiceImpl.delete(id);
    }
}