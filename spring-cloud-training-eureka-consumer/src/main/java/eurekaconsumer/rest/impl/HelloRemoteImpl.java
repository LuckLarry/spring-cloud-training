package eurekaconsumer.rest.impl;

import eurekaconsumer.rest.HelloRemote;
import org.springframework.stereotype.Component;

@Component
public class HelloRemoteImpl implements HelloRemote {
    @Override
    public String hello(String name) {
        return "hello " + name + ",this is cache message";
    }
}
