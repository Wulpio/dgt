package com.wulpio.dgt.core.listener;

import com.wulpio.dgt.core.listener.model.TransactionMessage;
import com.wulpio.dtg.gtw.FeesCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class RabbitMQListener {

    private final FeesCalculator basicTableFeeCalculator;
    private final FeesCalculator constantFeeCalculator;

    public RabbitMQListener(@Qualifier("basicTableFeeCalculator") FeesCalculator basicTableFeeCalculator,
                            @Qualifier("constantFeeCalculator") FeesCalculator constantFeeCalculator) {
        this.basicTableFeeCalculator = basicTableFeeCalculator;
        this.constantFeeCalculator = constantFeeCalculator;
    }

    @RabbitListener(queues = "QUEUE_DEMO_02")
    public void compute(TransactionMessage message) {
        log.info("Received message: algorithm={}, id={}", message.algorithm(), message.id());

        BigDecimal result = switch (message.algorithm()) {
            case "basicTableFeeCalculator" -> basicTableFeeCalculator.calculate(message.id());
            case "constantFeeCalculator" -> constantFeeCalculator.calculate(message.id());
            default -> throw new RuntimeException("Algorithm not set");
        };

        log.info("Computed fee: {}", result);
    }
}
