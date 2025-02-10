package com.wulpio.dgt.repository;

import com.wulpio.dgt.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
