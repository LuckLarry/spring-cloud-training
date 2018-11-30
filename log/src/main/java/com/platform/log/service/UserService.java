package com.platform.log.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private Logger  log = LoggerFactory.getLogger(UserService.class);

    public void log(){
        log.debug("user service debug log ");
        log.info("user service info log ");
        log.warn("user service warn log ");
        log.error("user service error log ");
    }
}
