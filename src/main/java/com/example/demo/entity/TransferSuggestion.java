package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class TransferSuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Store sourceStore;

    @ManyToOne
    private Store targetStore;

    @ManyToOne
    private Product product;

    private Integer quantity;
    private String priority;
    private Timestamp suggestedAt;
    private String status = "PENDING";

    @PrePersist
    public void setTime() {
        suggestedAt = new Timestamp(System.currentTimeMillis());
    }

    
}
