package by.home.courseback.service;

import by.home.courseback.model.Comment;
import by.home.courseback.repository.CommentRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final CompositionService compositionService;

    public CommentService(CommentRepository commentRepository, CompositionService compositionService) {
        this.commentRepository = commentRepository;
        this.compositionService = compositionService;
    }

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public Comment saveComment(Comment comment,Long id) {
        comment.setComposition(compositionService.findComposition(id));
        return commentRepository.save(comment);
    }

    public Comment findComment(Long id) {
        return commentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public List<Comment> findComments(Long id) {
        return commentRepository.findByCompositionId(id);
    }
}
