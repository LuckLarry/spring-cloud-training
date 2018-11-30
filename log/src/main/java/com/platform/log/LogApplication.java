package com.platform.log;

import com.platform.log.dao.UserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LogApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(LogApplication.class, args);
        context.getBean(UserDao.class).log();
    }
}
