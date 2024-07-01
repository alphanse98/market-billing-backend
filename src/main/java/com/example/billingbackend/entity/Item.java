package com.example.billingbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
//import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "items", indexes = {
        @Index(name = "idx_business_id", columnList = "businessID")
})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String businessID;

    @NotEmpty
//    @Size(max = 15, message = "item name should have atmost 15 characters")
    @Column(nullable = false)
    private String itemName;

    @NotEmpty
    @Column(nullable = false)
    private String itemImg;


    @Column(nullable = false)
    private Double itemPrice;


    private boolean isActive;

//    @NotEmpty
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(nullable = true) // Setting nullable to true makes the column optional

//   @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSZ", shape = JsonFormat.Shape.STRING)

   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createDate;

}



