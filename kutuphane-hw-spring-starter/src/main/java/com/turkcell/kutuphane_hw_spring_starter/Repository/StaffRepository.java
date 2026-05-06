package com.turkcell.kutuphane_hw_spring_starter.Repository;
import java.util.UUID;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.kutuphane_hw_spring_starter.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, UUID> {
    Optional<Staff> findByEmail(String email); // Login işlemi için gerekli
}