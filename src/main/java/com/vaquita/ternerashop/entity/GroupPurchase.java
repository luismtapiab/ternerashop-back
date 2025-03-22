package com.vaquita.ternerashop.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "group_purchase")
class GroupPurchase {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product item;
    private Integer finalPrice;
    private Integer minimalGroup;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;
    
}

enum PurchaseStatus {
    WaitingForMore,
    ReadyToBePicked,
    AllItemsGone,
    Cancelled,
} 