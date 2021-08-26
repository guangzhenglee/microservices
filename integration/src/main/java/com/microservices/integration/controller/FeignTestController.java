package com.microservices.integration.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/api/v1/feign-test")
@Slf4j
public class FeignTestController {
    @GetMapping("/read-timeout")
    public boolean testReadTimeout() throws InterruptedException {
        log.info("testReadTimeout");
        Thread.sleep(3000);
        return true;
    }

    @GetMapping("/header-auth")
    public boolean testHeaderAuth(@RequestHeader("token") String token) {
        log.info("testReadTimeout, token:{}", token);
        if (isNotBlank(token)) {
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/exception")
    @ResponseStatus(BAD_REQUEST)
    public boolean testThrowException() throws InterruptedException {
        log.info("testThrowException");
        throw new InterruptedException("bad request, test throw exception");
    }
}
