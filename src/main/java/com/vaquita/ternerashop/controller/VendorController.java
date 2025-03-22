package com.vaquita.ternerashop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaquita.ternerashop.entity.Vendor;
import com.vaquita.ternerashop.service.VendorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/vendor")
@RequiredArgsConstructor
@Validated
public class VendorController {

    private final VendorService vendorService;

    @GetMapping("/")
    public ResponseEntity<List<Vendor>> getAllVendors() {
        return ResponseEntity.ok().body(vendorService.getAllVendors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Integer id) {
            return ResponseEntity.ok().body(vendorService.getVendorById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Vendor> saveVendor(@RequestBody Vendor vendor) {
        return ResponseEntity.ok(vendorService.saveVendor(vendor));
    }

    @PutMapping("/")
    public ResponseEntity<Vendor> updateVendor(@RequestBody Vendor vendor) {
        return ResponseEntity.ok(vendorService.updateVendor(vendor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVendorById(@PathVariable Integer id) {
        vendorService.deleteVendorById(id);   
        return ResponseEntity.ok().body("Deleted vendor data succesfully");
    }

}