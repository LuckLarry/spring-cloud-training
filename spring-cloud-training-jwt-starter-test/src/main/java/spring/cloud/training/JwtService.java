package spring.cloud.training;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class JwtService {
    // 需要在自动配置类中注入此bean
    @Autowired
    JwtUtils jwtUtils;

    private String base64Security;

    private String issuer;

    public JwtService(String base64Security, String issuer) {
        this.base64Security = base64Security;
        this.issuer = issuer;
    }

    // 创建 map中放个人信息，可以被他们获取到，第二个是发送给谁，第三参数是过期时间
    public String createPersonToken(Map map, String audience, long TTLMillis) {
        String personToken = jwtUtils.createJWT(map, audience, this.issuer, TTLMillis, this.base64Security);
        return personToken;
    }

    // token
    public Claims parsePersonJWT(String personToken) {
        Claims claims = jwtUtils.parseJWT(personToken, this.base64Security);
        return claims;
    }
}