package com.example.laboratorio_2.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "productName")
    private String name;

    @Column(name = "grade")
    private String grade;

    @Column(name = "cursedTechnique")
    private String cursedTechnique;

    @Column(name = "school")
    private String school;

    @Column(name = "cursedEnergy")
    private Double cursedEnergy;

    @Column(name = "isActive")
    private Boolean isActive;

}