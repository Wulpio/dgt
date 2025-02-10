package com.wulpio.dgt.core.controller;

import com.wulpio.dtg.gtw.FeesCalculator;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/api/compute")
public class TransactionController {

    private final FeesCalculator calculator;

    public TransactionController(@Qualifier("constantFeeCalculator") FeesCalculator calculator) {
//    public TransactionController(@Qualifier("basicTableFeeCalculator") FeesCalculator calculator) {
        this.calculator = calculator;
    }
    @GetMapping()
    public BigDecimal compute(@Valid @RequestParam Long id) {
        log.info("action=compute, id=" + id);

        return calculator.calculate(id);
    }

}