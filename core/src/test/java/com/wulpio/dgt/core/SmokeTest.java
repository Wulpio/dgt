package com.wulpio.dgt.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SmokeTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void GIVEN_id_one_and_basicTableFeeCalculator_algorithm_WHEN_get_request_THEN_1_dot_1_is_returned() {

        String url = UriComponentsBuilder
                .fromUriString("http://localhost:{port}/api/compute")
                .queryParam("id", 1)
                .queryParam("algorithm", "basicTableFeeCalculator")
                .build(port)
                .toString();

        BigDecimal response = restTemplate.getForObject(url, BigDecimal.class);

        assertThat(response)
                .isNotNull()
                .isEqualByComparingTo("1.1");
    }

    @Test
    void GIVEN_id_one_and_constantFeeCalculator_algorithm_WHEN_get_request_THEN_10_is_returned() {

        String url = UriComponentsBuilder
                .fromUriString("http://localhost:{port}/api/compute")
                .queryParam("id", 1)
                .queryParam("algorithm", "constantFeeCalculator")
                .build(port)
                .toString();

        BigDecimal response = restTemplate.getForObject(url, BigDecimal.class);

        assertThat(response)
                .isNotNull()
                .isEqualByComparingTo("10");
    }

    @Test
    void GIVEN_id_one_and_incorrect_algorithm_WHEN_get_request_THEN_500_is_returned() {
        String url = UriComponentsBuilder
                .fromUriString("/api/compute")
                .queryParam("id", 1)
                .queryParam("algorithm", "dummy")
                .toUriString();

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}