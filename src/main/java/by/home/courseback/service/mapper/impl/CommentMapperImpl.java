package by.home.courseback.service.mapper.impl;

import by.home.courseback.model.Comment;
import by.home.courseback.service.CommentService;
import by.home.courseback.service.dto.CommentDTO;
import by.home.courseback.service.mapper.CommentMapper;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CommentMapperImpl implements CommentMapper {

    private final CommentService commentService;

    public CommentMapperImpl(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public List<Comment> toComments(Collection<CommentDTO> commentDTOs) {
        return commentDTOs.stream()
                .map(commentDTO -> commentService.findComment(commentDTO.getId())
                ).collect(Collectors.toList());
    }

    @Override
    public List<CommentDTO> toCommentDTOs(Collection<Comment> comments) {
        return comments.stream()
                .map(this::toCommentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO toCommentDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setText(comment.getText());
        commentDTO.setFullName(comment.getFullName());
        commentDTO.setAuthorUrl(comment.getAuthorUrl());
        commentDTO.setAvatarUrl(comment.getAvatarUrl());
        commentDTO.setCreatedAt(comment.getCreatedAt());
        return commentDTO;
    }

    @Override
    public Comment toComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setText(commentDTO.getText());
        comment.setFullName(commentDTO.getFullName());
        comment.setCreatedAt(commentDTO.getCreatedAt());
        return comment;
    }
}
