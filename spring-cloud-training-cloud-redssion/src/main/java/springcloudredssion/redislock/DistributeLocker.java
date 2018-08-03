package springcloudredssion.redislock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

public interface DistributeLocker {
    RLock lock(String lockKey);
    RLock lock(String lockKey,int timeout);
    RLock lock(String lockKey, TimeUnit timeUnit,int timeout);
    boolean tryLock(String lockKey,TimeUnit timeUnit,int waitTime,int leaseTime);
    void unlock(String lockKey);
    void unlock(RLock lock);
}
