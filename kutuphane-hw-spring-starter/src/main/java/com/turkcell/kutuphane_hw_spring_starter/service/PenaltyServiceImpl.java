package com.turkcell.kutuphane_hw_spring_starter.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.turkcell.kutuphane_hw_spring_starter.Repository.PenaltyRepository;
import com.turkcell.kutuphane_hw_spring_starter.dto.ListPenaltyResponse;

@Service
public class PenaltyServiceImpl {
    private final PenaltyRepository penaltyRepository;

    public PenaltyServiceImpl(PenaltyRepository penaltyRepository) {
        this.penaltyRepository = penaltyRepository;
    }

    public List<ListPenaltyResponse> getAll() {
        return this.penaltyRepository.findAll().stream().map(penalty -> {
            ListPenaltyResponse response = new ListPenaltyResponse();
            response.setId(penalty.getId());
            response.setStudentName(penalty.getReturnRecord().getBorrow().getStudent().getFirstName() + " " + 
                                    penalty.getReturnRecord().getBorrow().getStudent().getLastName());
            response.setBookName(penalty.getReturnRecord().getBorrow().getBook().getName());
            response.setAmount(penalty.getAmount());
            return response;
        }).toList();
    }

    public void delete(UUID id) {
        this.penaltyRepository.deleteById(id);
    }
}