package by.home.courseback.service.mapper;

import by.home.courseback.model.Comment;
import by.home.courseback.service.dto.CommentDTO;
import java.util.Collection;
import java.util.List;

public interface CommentMapper {

    List<Comment> toComments(Collection<CommentDTO> comments);

    List<CommentDTO> toCommentDTOs(Collection<Comment> comments);

    CommentDTO toCommentDTO(Comment comment);

    Comment toComment(CommentDTO commentDTO);
}
