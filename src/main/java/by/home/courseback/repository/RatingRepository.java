package by.home.courseback.repository;

import by.home.courseback.model.RatingComposition;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RatingRepository extends JpaRepository<RatingComposition, Long> {

    Optional<RatingComposition> findByUserIdAndCompositionId (Long userId, Long compositionId);

    @Query("select avg(r.rating) from RatingComposition r where r.compositionId=:compositionId")
    Float getCompositionRating(Long compositionId);

    @Query("select r.rating from RatingComposition r where r.compositionId=:compositionId and r.userId=:userId")
    Long getUserRating(Long userId, Long compositionId);
}
