package com.vaquita.ternerashop.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vaquita.ternerashop.entity.Vendor;
import com.vaquita.ternerashop.repository.VendorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendorService {
    private final VendorRepository vendorRepo;

     public List<Vendor> getAllVendors(){
        return vendorRepo.findAll();
    }

    public Vendor getVendorById(Integer id){
        Optional<Vendor> optionalVendor = vendorRepo.findById(id);
        if(optionalVendor.isPresent()){
            return optionalVendor.get();
        }
        log.info("Vendor with id: {} doesn't exist", id);
        return null;
    }

    public Vendor saveVendor (Vendor Vendor){
        Vendor.setCreatedAt(LocalDateTime.now());
        Vendor.setUpdatedAt(LocalDateTime.now());
        Vendor savedVendor = vendorRepo.save(Vendor);

        log.info("Vendor with id: {} saved successfully", Vendor.getId());
        return savedVendor;
    }

    public Vendor updateVendor (Vendor Vendor) {
        Optional<Vendor> existingVendor = vendorRepo.findById(Vendor.getId());
        Vendor.setCreatedAt(existingVendor.get().getCreatedAt());
        Vendor.setUpdatedAt(LocalDateTime.now());

        Vendor updatedVendor = vendorRepo.save(Vendor);

        log.info("Vendor with id: {} updated successfully", Vendor.getId());
        return updatedVendor;
    }

    public void deleteVendorById (Integer id) {
        vendorRepo.deleteById(id);
    }
}
