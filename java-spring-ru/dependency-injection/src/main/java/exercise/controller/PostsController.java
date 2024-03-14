package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post show(@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        return post;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post postData) {
        var post = new Post();
        post.setTitle(postData.getTitle());
        post.setBody(postData.getBody());
        return postRepository.save(post);
    }

    @PutMapping("/{id}")
    public Post update(@RequestBody Post postData, @PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        post.setTitle(postData.getTitle());
        post.setBody(postData.getBody());
        return postRepository.save(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commentRepository.deleteByPostId(id);
        postRepository.deleteById(id);
    }
}
// END
