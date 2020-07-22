package by.home.courseback.repository;

import by.home.courseback.model.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByCompositionId (Long compositionId);
}

