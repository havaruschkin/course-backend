package by.home.courseback.controller;

import by.home.courseback.model.Message;
import by.home.courseback.service.CommentService;
import by.home.courseback.service.dto.CommentDTO;
import by.home.courseback.service.mapper.CommentMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    public MessageController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @MessageMapping("/comment")
    @SendTo("/topic/commenting")
    public Message commenting(Message message) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setText(message.getText());
        commentDTO.setFullName(message.getUsername());
        commentService.saveComment(commentMapper.toComment(commentDTO), message.getCompositionId());
        return message;
    }
}

