package com.wulpio.dgt.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
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
    void GIVEN_correct_request_WHEN_get_THEN_correct_response_is_returned() {

        String url = UriComponentsBuilder
                .fromUriString("http://localhost:{port}/api/compute")
                .queryParam("id", 1)
                .build(port)
                .toString();

        BigDecimal response = restTemplate.getForObject(url, BigDecimal.class);

        assertThat(response).isNotNull();
        assertThat(response).isEqualByComparingTo("1.1");
    }


}