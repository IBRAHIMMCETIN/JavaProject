package com.turkcell.kutuphane_hw_spring_starter.entity;

import java.util.UUID;
import java.math.BigDecimal;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.*;

@Entity
@Table(name = "cezalar")
public class Penalty {
    @Id
    @UuidGenerator
    @Column(name="ceza_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "iade_id", nullable = false)
    private ReturnRecord returnRecord;

    @Column(name="ceza_tutari", nullable = false)
    private BigDecimal amount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ReturnRecord getReturnRecord() {
        return returnRecord;
    }

    public void setReturnRecord(ReturnRecord returnRecord) {
        this.returnRecord = returnRecord;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}