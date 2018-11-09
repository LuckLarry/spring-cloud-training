package springcloudgateway;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import springcloudgateway.filter.AccessFilter;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Zuul网关
 *
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableSwagger2Doc
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }

    /**
     * 网关配置swagger
     * http://blog.didispace.com/Spring-Cloud-Zuul-use-Swagger-API-doc/
     */
//    说明：@EnableSwagger2Doc上面说过是开启Swagger功能的注解。这里的核心是下面对SwaggerResourcesProvider的接口实现部分，通过SwaggerResource添加了多个文档来源，按上面的配置，网关上Swagger会通过访问/swagger-service-a/v2/api-docs和swagger-service-b/v2/api-docs来加载两个文档内容，同时由于当前应用是Zuul构建的API网关，这两个请求会被转发到swagger-service-a和swagger-service-b服务上的/v2/api-docs接口获得到Swagger的JSON文档，从而实现汇总加载内容。
    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider{

        @Override
        public List<SwaggerResource> get() {
            List resources = new ArrayList<>();
            resources.add(swaggerResource("spring-cloud-swagger1", "/spring-cloud-swagger1/v2/api-docs", "2.0"));
            resources.add(swaggerResource("spring-cloud-swagger2", "/spring-cloud-swagger1/v2/api-docs", "2.0"));
            return resources;
        }
        private SwaggerResource swaggerResource(String name, String location, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }

}
