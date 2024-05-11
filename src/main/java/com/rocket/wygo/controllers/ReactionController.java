package com.rocket.wygo.controllers;


import com.rocket.wygo.requests.ReactionRequest;
import com.rocket.wygo.services.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reactions")
@CrossOrigin

public class ReactionController {
    @Autowired
    ReactionService reactionService;

    @PostMapping("/react")
    public ResponseEntity<String> reactionRequest(@RequestBody ReactionRequest reactionRequest)
    {
        try {
            reactionService.react(reactionRequest.getAuthor(), reactionRequest.getPost());
            return ResponseEntity.ok("React Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
