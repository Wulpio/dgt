package com.wulpio.dgt.algorithm.db.repository;

import com.wulpio.dgt.algorithm.db.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
