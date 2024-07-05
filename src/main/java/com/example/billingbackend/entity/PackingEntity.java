package com.example.billingbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "packing")
public class PackingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String businessID;

    @NotEmpty
    @Column(nullable = false)
    private String packingName;

    @Column(nullable = false)
        private Double packingPrice;

    @JsonProperty("isActive")
    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String createDate;
}
