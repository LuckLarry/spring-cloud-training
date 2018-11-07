服务总线更新（2.0.3.RELEASE）（客户端更新方式）
1，服务端
    1，添加依赖
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
     2，启动类添加注解
     @EnableConfigServer
2，客户端
    1，添加依赖
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-config-client</artifactId>
            </dependency>
            重点，添加actuator依赖，才能暴露actuator/bus-refresh端口 （新版本已经不需要的）
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-actuator</artifactId>
            </dependency>
            消息队列总线
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-bus-amqp</artifactId>
            </dependency>
    2,添加暴露端配置
    spring:
      rabbitmq:
        host: localhost
        port: 5672
        username: guest
        password: guest
    总线暴露端
    management:
      endpoints:
        web:
          exposure:
            include: bus-refresh
    3，在有需要@value()注入的类上，添加该注解（@RefreshScope），
    在客户端 curl -X POST host:port/acturator/bus-refresh时，就会更新该属性
    

服务总线更新（2.0.3.RELEASE）（服务端端更新方式）
    基于客户端更新方式改造
1，添加pom
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-amqp</artifactId>
        </dependency>
2，添加配置
  spring: 
    rabbitmq:
      host: localhost
      port: 5672
      username: guest
      password: guest
  management:
    endpoints:
      web:
        exposure:
          include: bus-refresh
          
          
zuul网关
    默认情况下，Zuul会代理所有注册到Eureka Server的微服务，
    并且Zuul的路由规则如下：http://ZUUL_HOST:ZUUL_PORT/微服务在Eureka上的serviceId/**会被转发到serviceId对应的微服务。