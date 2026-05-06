package com.turkcell.kutuphane_hw_spring_starter.Repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.kutuphane_hw_spring_starter.entity.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, UUID> {}