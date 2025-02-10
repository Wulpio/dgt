package com.wulpio.dgt.core.controller;

import com.wulpio.dtg.gtw.FeesCalculator;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/api/compute")
public class TransactionController {

    private final FeesCalculator basicDbCalculator;
    private final FeesCalculator constantCalculator;

    public TransactionController(@Qualifier("basicTableFeeCalculator") FeesCalculator basicDbCalculator,
                                 @Qualifier("constantFeeCalculator") FeesCalculator constantCalculator) {
        this.basicDbCalculator = basicDbCalculator;
        this.constantCalculator = constantCalculator;
    }

    @GetMapping()
    public BigDecimal compute(@Valid @RequestParam Long id,
                              @Valid @RequestParam String algorithm) {
        log.info("action=compute, algorithm={}, id={}", algorithm, id);

        return switch (algorithm) {
            case ("basicTableFeeCalculator") -> basicDbCalculator.calculate(id);
            case ("constantFeeCalculator") -> constantCalculator.calculate(id);
            default -> throw new RuntimeException("algorithm not set");
        };
    }
}