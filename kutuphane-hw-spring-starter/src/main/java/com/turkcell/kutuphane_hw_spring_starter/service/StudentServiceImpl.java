package com.turkcell.kutuphane_hw_spring_starter.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.turkcell.kutuphane_hw_spring_starter.Repository.StudentRepository;
import com.turkcell.kutuphane_hw_spring_starter.dto.CreateStudentRequest;
import com.turkcell.kutuphane_hw_spring_starter.dto.ListStudentResponse;
import com.turkcell.kutuphane_hw_spring_starter.entity.Student;

@Service
public class StudentServiceImpl {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ListStudentResponse create(CreateStudentRequest request) {
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setDepartment(request.getDepartment());
        student.setPhone(request.getPhone());
        student.setEmail(request.getEmail());
        
        student = this.studentRepository.save(student);
        return mapToResponse(student);
    }

    public List<ListStudentResponse> getAll() {
        return this.studentRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    public ListStudentResponse getById(UUID id) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Öğrenci bulunamadı"));
        return mapToResponse(student);
    }

    public ListStudentResponse update(UUID id, CreateStudentRequest request) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Öğrenci bulunamadı"));
        
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setDepartment(request.getDepartment());
        student.setPhone(request.getPhone());
        student.setEmail(request.getEmail());
        
        student = this.studentRepository.save(student);
        return mapToResponse(student);
    }

    public void delete(UUID id) {
        this.studentRepository.deleteById(id);
    }

    private ListStudentResponse mapToResponse(Student student) {
        ListStudentResponse response = new ListStudentResponse();
        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setDepartment(student.getDepartment());
        response.setPhone(student.getPhone());
        response.setEmail(student.getEmail());
        return response;
    }
}