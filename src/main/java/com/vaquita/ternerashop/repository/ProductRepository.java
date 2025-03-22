package com.vaquita.ternerashop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaquita.ternerashop.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
