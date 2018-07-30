package eurekaconsumer.controller;

import eurekaconsumer.rest.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloRemote helloRemote;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return helloRemote.hello(name);
    }
}
