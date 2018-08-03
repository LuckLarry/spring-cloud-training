package springcloudredssion.config;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springcloudredssion.redislock.DistributeLocker;
import springcloudredssion.redislock.impl.RedissonDistributeLoker;
import springcloudredssion.utils.RedissLockUtil;

@Configuration
@ConditionalOnClass(Config.class)
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonAutoConfiguration {
    @Autowired
    private RedissonProperties redissonProperties;

    /**
     * 哨兵模式
     * @return
     */
    @Bean
    @ConditionalOnProperty(name = "redisson.master-name")
    public RedissonClient redissonSentinel(){
        Config config = new Config();
        SentinelServersConfig serversConfig = config.useSentinelServers().addSentinelAddress(redissonProperties.getSentinelAddresses())
                .setMasterName(redissonProperties.getMasterName())
                .setTimeout(redissonProperties.getTimeout())
                .setMasterConnectionPoolSize(redissonProperties.getMasterConnectionPoolSize())
                .setSlaveConnectionPoolSize(redissonProperties.getSlaveConnectionPoolSize());
        if(StringUtils.isNotBlank(redissonProperties.getPassword())){
            serversConfig.setPassword(redissonProperties.getPassword());
        }
        return Redisson.create(config);
    }
    @Bean
    @ConditionalOnProperty(name = "redisson.address")
    public RedissonClient redissonSingle(){
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(redissonProperties.getAddress())
                .setTimeout(redissonProperties.getTimeout())
                .setConnectionPoolSize(redissonProperties.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(redissonProperties.getConnectionMinimumIdleSize());
        if (StringUtils.isNotBlank(redissonProperties.getPassword())){
            serverConfig.setPassword(redissonProperties.getPassword());
        }
        return Redisson.create(config);
    }

    @Bean
    DistributeLocker distributeLocker(RedissonClient redissonClient){
        RedissonDistributeLoker locker = new RedissonDistributeLoker();
        locker.setRedissonClient(redissonClient);
        RedissLockUtil.setLocker(locker);
        return locker;
    }

}
