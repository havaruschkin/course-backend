package by.home.courseback.controller;

import by.home.courseback.exeption.CreatedEntityIdException;
import by.home.courseback.service.CommentService;
import by.home.courseback.service.dto.CommentDTO;
import by.home.courseback.service.mapper.CommentMapper;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    public CommentController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @GetMapping
    public List<CommentDTO> allComments() {
        return commentMapper.toCommentDTOs(commentService.findAllComments());
    }

    @GetMapping("/{id}")
    public List<CommentDTO> getComments(@PathVariable Long id) {
        return commentMapper.toCommentDTOs(commentService.findComments(id));
    }

    @PostMapping("/{id}")
    public void saveComment(@RequestBody CommentDTO commentDTO, @PathVariable Long id) {
        if (commentDTO.getId() != null) {
            throw new CreatedEntityIdException();
        }
        commentService.saveComment(commentMapper.toComment(commentDTO), id);
    }
}