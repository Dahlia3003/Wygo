package com.rocket.wygo.services;

import com.rocket.wygo.models.Post;
import com.rocket.wygo.models.User;
import com.rocket.wygo.repositories.PostRepository;
import com.rocket.wygo.repositories.UserRepository;
import com.rocket.wygo.response.PostResponse;
import com.rocket.wygo.response.UserPostResponse;
import com.rocket.wygo.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewPersonalPageService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    public UserPostResponse viewPersonalPage(String username) throws Exception {
        User user = userRepository.findByUsername(username);
        List<Post> postList = postRepository.findByAuthor_Username(username);
        if (user == null) {
            throw new Exception("Người dùng " + username + " không tồn tại");
        }
        UserResponse userRes = new UserResponse(
                                user.getId(), user.getUsername() ,user.getBirth(), user.getHometown(),
                                user.getAvatar(), user.getGender(), user.getBio(),
                                user.getFavorList().size(), user.getDisfavorList().size(),
                                user.getBefavoredList().size(), user.getBedisfavoredList().size(),
                                user.getNotificationList().size(), user.getAvailable());
        List<PostResponse> postDTOList = new ArrayList<>();
        for (Post post : postList) {
            PostResponse postDTO = new PostResponse(
                                        post.getId(), userRes, post.getPostTime(),
                                        post.getContent(), post.getLocation(), post.getMedia(),
                                        post.getCommentList().size(), post.getReactions().size(), post.getAvailable() );
            postDTOList.add(postDTO);
        }
        UserPostResponse userPostDTO = new UserPostResponse();
        userPostDTO.setUser(userRes);
        userPostDTO.setPosts(postDTOList);
        return userPostDTO;
    }
}
