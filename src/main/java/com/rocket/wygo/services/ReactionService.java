package com.rocket.wygo.services;

import com.rocket.wygo.models.Post;
import com.rocket.wygo.models.Reaction;
import com.rocket.wygo.models.User;
import com.rocket.wygo.repositories.PostRepository;
import com.rocket.wygo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ReactionService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @Transactional
    public void react(String author, int postid) throws Exception
    {
        Optional<Post> optionalPost = postRepository.findById(postid);
        User authorUser = userRepository.findByUsername(author);
        if (author == null) {
            throw new Exception("Người dùng " + author + " không tồn tại");
        }
        if (optionalPost.isEmpty()) {
            throw new Exception("Post không tồn tại");
        }
        Post post = optionalPost.get();
        Reaction r = new Reaction();
        r.setAuthor(authorUser);
        post.getReactions().add(r);
        postRepository.save(post);
    }
}
