package eurekaconsumer.rest;

import eurekaconsumer.rest.impl.HelloRemoteImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "eureka-producer",fallback = HelloRemoteImpl.class)
public interface HelloRemote {
    @RequestMapping("/hello")
    public String hello(@RequestParam(name = "name") String name);
}
