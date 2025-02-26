package com.wulpio.dgt.algorithm.db.service;

import com.wulpio.dgt.algorithm.db.domain.Transaction;
import com.wulpio.dgt.algorithm.db.repository.TransactionRepository;
import com.wulpio.dtg.gtw.FeesCalculator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("basicTableFeeCalculator")
public class BasicTableFeeCalculator implements FeesCalculator {

    private final TransactionRepository repository;

    public BasicTableFeeCalculator(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public BigDecimal calculate(Long id) {
        Transaction transaction = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id: " + id + " not found"));

        return transaction.getFee();
    }

}
