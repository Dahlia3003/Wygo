package com.rocket.wygo.services;

import com.rocket.wygo.models.Post;
import com.rocket.wygo.models.User;
import com.rocket.wygo.repositories.PostRepository;
import com.rocket.wygo.repositories.UserRepository;
import com.rocket.wygo.response.SearchResultsRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// SearchService.java
@Service
public class SearchService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public SearchResultsRespond search(String query) {
        List<User> users = userRepository.findByNameContainingOrUsernameContaining(query, query);
        List<Post> posts = postRepository.findByContentContaining(query);

        SearchResultsRespond results = new SearchResultsRespond();
        results.setUsers(users);
        results.setPosts(posts);

        return results;
    }
}


