package com.vaquita.ternerashop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
@Validated
public class HealthController {

    @GetMapping("/")
    public ResponseEntity<String> getAllProducts() {
        return ResponseEntity.ok().body("TerneraShop server is alive!");
    }

}