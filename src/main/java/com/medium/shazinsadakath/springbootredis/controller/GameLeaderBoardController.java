package com.medium.shazinsadakath.springbootredis.controller;

import com.medium.shazinsadakath.springbootredis.dto.Gamer;
import com.medium.shazinsadakath.springbootredis.service.GameLeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gameleaderboard")
public class GameLeaderBoardController {

    @Autowired
    private GameLeaderBoardService gameLeaderBoardService;

    @PostMapping
    public List<Gamer> add(@RequestBody Gamer gamer) {
        return gameLeaderBoardService.add(gamer);
    }

    @DeleteMapping
    public void deleteAll() {
        gameLeaderBoardService.deleteAll();
    }

}
