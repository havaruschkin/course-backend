package by.home.courseback.repository;

import by.home.courseback.model.LikeChapter;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeChapter, Long> {

   Optional<LikeChapter> findByUserIdAndChapterId (Long userId, Long chapterId);

   Long countByChapterId (Long chapterId);
}
