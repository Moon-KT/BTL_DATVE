package com.example.SB_Week9.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentID;
    private String paymentType;
    private String transactionDate;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ticket> ticketList;

}
