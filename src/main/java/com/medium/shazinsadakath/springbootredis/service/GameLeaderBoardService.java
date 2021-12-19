package com.medium.shazinsadakath.springbootredis.service;

import com.medium.shazinsadakath.springbootredis.dto.Gamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameLeaderBoardService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource(name = "redisTemplate")
    private ZSetOperations<String, String> zSetOperations;

    public Set<Gamer> add(Gamer gamer) {
        zSetOperations.add("leaderboard", gamer.getName(), gamer.getRank());

        return zSetOperations.rangeWithScores("leaderboard" ,0,10)
                .stream().map(e -> new Gamer(e.getValue(), e.getScore()))
                .collect(Collectors.toSet());
    }
}
