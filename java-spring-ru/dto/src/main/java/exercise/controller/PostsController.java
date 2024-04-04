package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private  CommentRepository commentRepository;
    @GetMapping("")
    public List<Post> index() {
        return postRepository.findAll();
    }
    @GetMapping("/{id}")
    public PostDTO show(@PathVariable long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        var comments = commentRepository.findByPostId(id);
        var postDTO = new PostDTO();
        List<CommentDTO> commentsDTO = new ArrayList<>();
        for (var comment : comments) {
            var commentDTO = new CommentDTO();
            commentDTO.setId(comment.getId());
            commentDTO.setBody(comment.getBody());
            commentsDTO.add(commentDTO);
        }
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setBody(post.getBody());
        postDTO.setComments(commentsDTO);
        return postDTO;
    }
}

// END
