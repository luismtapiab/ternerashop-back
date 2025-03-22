package com.vaquita.ternerashop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaquita.ternerashop.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor,Integer> {
}
