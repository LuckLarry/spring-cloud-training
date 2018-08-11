package spring.cloud.training.main;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;

@Slf4j
public class RedissonTest {
    public static void main(String[] args ){
        Config config = new Config();
        config.setTransportMode(TransportMode.NIO);
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redissonClient = Redisson.create(config);
        RKeys keys = redissonClient.getKeys();
        RBitSet bitSet = redissonClient.getBitSet("test");
        RMap map = redissonClient.getMap("test");
        RList list = redissonClient.getList("list");

        Iterable<String> foundKeys = keys.getKeysByPattern("OrderServiceImpl*");
        for (String key:foundKeys){
            log.error(key);
        }
    }
}
