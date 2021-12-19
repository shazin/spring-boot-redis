package com.medium.shazinsadakath.springbootredis.controller;

import com.medium.shazinsadakath.springbootredis.dto.Gamer;
import com.medium.shazinsadakath.springbootredis.service.GameLeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/gameleaderboard")
public class GameLeaderBoardController {

    @Autowired
    private GameLeaderBoardService gameLeaderBoardService;

    @PostMapping
    public Set<Gamer> add(@RequestBody Gamer gamer) {
        return gameLeaderBoardService.add(gamer);
    }

}
