package com.turkcell.kutuphane_hw_spring_starter.Repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.kutuphane_hw_spring_starter.entity.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {}