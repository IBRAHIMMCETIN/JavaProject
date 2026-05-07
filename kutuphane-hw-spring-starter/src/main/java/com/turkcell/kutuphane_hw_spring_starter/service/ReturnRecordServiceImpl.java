package com.turkcell.kutuphane_hw_spring_starter.service;

import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

import com.turkcell.kutuphane_hw_spring_starter.Repository.BorrowRepository;
import com.turkcell.kutuphane_hw_spring_starter.Repository.ReturnRecordRepository;
import com.turkcell.kutuphane_hw_spring_starter.Repository.PenaltyRepository;
import com.turkcell.kutuphane_hw_spring_starter.dto.*;
import com.turkcell.kutuphane_hw_spring_starter.entity.*;

@Service
public class ReturnRecordServiceImpl {
    private final ReturnRecordRepository returnRecordRepository;
    private final BorrowRepository borrowRepository;
    private final PenaltyRepository penaltyRepository;

    public ReturnRecordServiceImpl(ReturnRecordRepository returnRecordRepository, 
                                   BorrowRepository borrowRepository, 
                                   PenaltyRepository penaltyRepository) {
        this.returnRecordRepository = returnRecordRepository;
        this.borrowRepository = borrowRepository;
        this.penaltyRepository = penaltyRepository;
    }

    public ListReturnResponse create(CreateReturnRequest request) {
        Borrow borrow = this.borrowRepository.findById(request.getBorrowId())
                .orElseThrow(() -> new RuntimeException("Ödünç kaydı bulunamadı"));

        ReturnRecord returnRecord = new ReturnRecord();
        returnRecord.setBorrow(borrow);
        returnRecord.setReturnDate(LocalDate.now());
        
        returnRecord = this.returnRecordRepository.save(returnRecord);

        String penaltyStatus = "Zamanında İade Edildi. Ceza Yok.";
        if (returnRecord.getReturnDate().isAfter(borrow.getDueDate())) {
            // Geciken gün sayısını bul
            long daysLate = ChronoUnit.DAYS.between(borrow.getDueDate(), returnRecord.getReturnDate());
            
            // Günlük 5 TL ceza hesapla
            BigDecimal penaltyAmount = BigDecimal.valueOf(daysLate * 5.0);
            
            Penalty penalty = new Penalty();
            penalty.setReturnRecord(returnRecord);
            penalty.setAmount(penaltyAmount);
            this.penaltyRepository.save(penalty);
            
            penaltyStatus = daysLate + " gün gecikme! " + penaltyAmount + " TL ceza kesildi.";
        }

        return mapToResponse(returnRecord, penaltyStatus);
    }

    public List<ListReturnResponse> getAll() {
        return this.returnRecordRepository.findAll().stream()
                .map(record -> mapToResponse(record, "Durum hesaplanmadı"))
                .toList();
    }

    private ListReturnResponse mapToResponse(ReturnRecord record, String penaltyStatus) {
        ListReturnResponse response = new ListReturnResponse();
        response.setId(record.getId());
        response.setBookName(record.getBorrow().getBook().getName());
        response.setStudentName(record.getBorrow().getStudent().getFirstName() + " " + record.getBorrow().getStudent().getLastName());
        response.setBorrowDueDate(record.getBorrow().getDueDate());
        response.setReturnDate(record.getReturnDate());
        response.setPenaltyStatus(penaltyStatus);
        return response;
    }

}