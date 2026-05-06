package com.turkcell.kutuphane_hw_spring_starter.service;

import java.util.List;
import java.util.UUID;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

import com.turkcell.kutuphane_hw_spring_starter.Repository.*;
import com.turkcell.kutuphane_hw_spring_starter.dto.*;
import com.turkcell.kutuphane_hw_spring_starter.entity.*;

@Service
public class BorrowServiceImpl {
    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;
    private final StaffRepository staffRepository;

    public BorrowServiceImpl(BorrowRepository borrowRepository, BookRepository bookRepository, 
                             StudentRepository studentRepository, StaffRepository staffRepository) {
        this.borrowRepository = borrowRepository;
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
        this.staffRepository = staffRepository;
    }

    public ListBorrowResponse create(CreateBorrowRequest request) {
        Book book = this.bookRepository.findById(request.getBookId()).orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));
        Student student = this.studentRepository.findById(request.getStudentId()).orElseThrow(() -> new RuntimeException("Öğrenci bulunamadı"));
        Staff staff = this.staffRepository.findById(request.getStaffId()).orElseThrow(() -> new RuntimeException("Görevli bulunamadı"));

        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setStudent(student);
        borrow.setStaff(staff);
        borrow.setBorrowDate(LocalDate.now()); // Ödünç alma tarihi sistemden otomatik alınır
        borrow.setDueDate(request.getDueDate());

        borrow = this.borrowRepository.save(borrow);
        return mapToResponse(borrow);
    }

    public List<ListBorrowResponse> getAll() {
        return this.borrowRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    private ListBorrowResponse mapToResponse(Borrow borrow) {
        ListBorrowResponse response = new ListBorrowResponse();
        response.setId(borrow.getId());
        response.setBookName(borrow.getBook().getName());
        response.setStudentName(borrow.getStudent().getFirstName() + " " + borrow.getStudent().getLastName());
        response.setStaffName(borrow.getStaff().getFirstName() + " " + borrow.getStaff().getLastName());
        response.setBorrowDate(borrow.getBorrowDate());
        response.setDueDate(borrow.getDueDate());
        return response;
    }
}