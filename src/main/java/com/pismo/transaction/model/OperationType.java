package com.pismo.transaction.model;

import jakarta.persistence.*;

@Entity
public class OperationType {

    @Id
    private Long id;

    @Column(nullable = false)
    private String description;

    public OperationType(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public OperationType() {
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}