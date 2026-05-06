package com.turkcell.kutuphane_hw_spring_starter.Repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.kutuphane_hw_spring_starter.entity.ReturnRecord;

public interface ReturnRecordRepository extends JpaRepository<ReturnRecord, UUID> {}