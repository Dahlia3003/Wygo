package com.rocket.wygo.controllers;

import com.rocket.wygo.models.Post;
import com.rocket.wygo.response.PostResponse;
import com.rocket.wygo.response.RecommendUser;
import com.rocket.wygo.services.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homepage")
@CrossOrigin
public class HomePageController {
    @Autowired
    HomePageService homePageService;

    @GetMapping("/recommend-user/{username}")
    public ResponseEntity<List<RecommendUser>> getFavorUserList(@PathVariable String username){
        return ResponseEntity.ok(homePageService.getRecommendUser(username));
    }

    @GetMapping("/recommend-post/{username}")
    public ResponseEntity<List<PostResponse>> getFavorPostList(@PathVariable String username){
        return ResponseEntity.ok(homePageService.getRecommendPost(username));
    }
}
