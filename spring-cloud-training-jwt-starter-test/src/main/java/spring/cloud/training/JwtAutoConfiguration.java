package spring.cloud.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(JwtService.class)
@EnableConfigurationProperties(JwtServiceProperties.class)
public class JwtAutoConfiguration {
    @Autowired
    private JwtServiceProperties jwtServiceProperties;

    // 创建相关bean
    @Bean
    JwtService jwtService() {
        return new JwtService(jwtServiceProperties.getBase64Security(), jwtServiceProperties.getIssuer());
    }

    @Bean
    JwtUtils jwtUtils() {
        return new JwtUtils();
    }
}
