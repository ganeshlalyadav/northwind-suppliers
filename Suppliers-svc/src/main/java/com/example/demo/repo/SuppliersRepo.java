package com.example.demo.repo;

import com.example.demo.entity.Suppliers;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliersRepo extends JpaRepository<Suppliers,Integer> {
}
