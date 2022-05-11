package com.sio.livecricket.controller;


import com.sio.livecricket.service.LiveCricketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LiveScoreRestController {
    LiveCricketService cricketService;

    public LiveScoreRestController(LiveCricketService cricketService) {
        this.cricketService = cricketService;
    }

    @GetMapping("/channel/")
    public ResponseEntity<?> score() {
        return ResponseEntity.ok(cricketService.getDataset());
    }
}
