package com.wulpio.dgt.algorithm.constant.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ConstantFeeCalculatorTest {

    private final ConstantFeeCalculator calculator = new ConstantFeeCalculator();

    @Test
    void GIVEN_transaction_with_id_1_WHEN_isEqualByComparingTo_THEN_10_is_returned() {
        BigDecimal calculate = calculator.calculate(1L);

        assertThat(calculate).isEqualByComparingTo(BigDecimal.TEN);
    }
}