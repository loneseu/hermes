package cn.edu.seu.lone.cache.redis;

import org.springframework.data.redis.core.RedisTemplate;

public class HermesRedisTemplate {

    public static RedisTemplate<String, Object> getInstance() {

        return new RedisTemplate<>();
    }
}
