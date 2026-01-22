package com.example.liveeventhub.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate stringRedisTemplate;

    public void join(Long eventId, String user){
        stringRedisTemplate.opsForSet().add("event :"+eventId,user);
    }

    public Long count(Long eventId){
        return stringRedisTemplate.opsForSet().size("event :"+eventId);
    }









}
