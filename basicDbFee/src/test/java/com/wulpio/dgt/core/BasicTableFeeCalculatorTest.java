package com.wulpio.dgt.core;

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
    void GIVEN_correct_request_WHEN_calculate_THEN_correct_response_is_returned() {

        BigDecimal calculate = feesCalculator.calculate(1L);

        assertThat(calculate).isNotNull();
        assertThat(calculate).isEqualByComparingTo("1.1");
    }

}