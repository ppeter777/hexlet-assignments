package exercise.controller;

import exercise.model.Post;
import exercise.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentRepository commentRepository;
    
    @GetMapping("")
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Comment show(@PathVariable Long id) {
        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
        return comment;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody Comment commentData) {
        var comment = new Comment();
        comment.setBody(commentData.getBody());
        return commentRepository.save(comment);
    }

    @PutMapping("/{id}")
    public Comment update(@RequestBody Comment commentData, @PathVariable Long id) {
        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
        comment.setBody(commentData.getBody());
        return commentRepository.save(comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commentRepository.deleteById(id);
    }
}
// END
