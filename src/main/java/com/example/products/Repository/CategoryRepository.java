package com.example.products.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.products.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {


    
}
