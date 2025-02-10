package com.wulpio.dgt.core.basic.repository;

import com.wulpio.dgt.core.basic.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
