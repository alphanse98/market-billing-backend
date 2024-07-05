package com.example.billingbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="customers")
public class CustomerEntity {

    @Id
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String businessID;

    @NotEmpty
    @Size(max = 45, message = "item name should have atmost 45 characters")
    @Column(nullable = false)
    private String customersName;

//    @Digits(integer = 10, fraction = 0, message = "number should have at least 10 digits")
    @Column(nullable = false)
    private Long mobile;

    @Column(nullable = false)
    private String address;

    @Column(nullable = true)
    private Long secMobile;

    @NotEmpty
    @Email
    @Column(nullable = true)
    private String email;

    @JsonProperty("isActive")
    @Column(nullable = false)
    private boolean isActive;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createDate;
}
