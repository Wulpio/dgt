package com.wulpio.dgt.algorithm.db.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "fee", nullable = false)
    private BigDecimal fee;

    public Integer getId() {
        return id;
    }

    public BigDecimal getFee() {
        return fee;
    }
}