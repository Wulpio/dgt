package com.wulpio.dgt.algorithm.constant.service;

import com.wulpio.dtg.gtw.FeesCalculator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("constantFeeCalculator")
public class ConstantFeeCalculator implements FeesCalculator {

    @Override
    public BigDecimal calculate(Long id) {

        return BigDecimal.valueOf(id * 10);
    }

}
