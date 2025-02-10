package com.wulpio.dgt.algorithm.db.core;

import com.wulpio.dtg.gtw.FeesCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BasicTableFeeCalculatorTest {

    @Autowired
    private FeesCalculator feesCalculator;

    @Test
    void GIVEN_request_with_id_1_WHEN_calculate_THEN_1_dot_1_is_returned() {

        BigDecimal calculate = feesCalculator.calculate(1L);

        assertThat(calculate)
                .isNotNull()
                .isEqualByComparingTo("1.1");
    }

}