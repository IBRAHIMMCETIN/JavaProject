package com.turkcell.spring_starter.Repository;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.turkcell.spring_starter.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query("Select c from Category c Where c.name LIKE :query")
    Set<Category> search(String query);

}
