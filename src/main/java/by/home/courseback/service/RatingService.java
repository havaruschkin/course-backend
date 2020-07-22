package by.home.courseback.service;

import by.home.courseback.model.RatingComposition;
import by.home.courseback.repository.RatingRepository;
import by.home.courseback.service.dto.RatingDTO;
import java.util.Optional;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RatingService {

    private final PrincipalService principalService;
    private final RatingRepository ratingRepository;

    public RatingService(PrincipalService principalService, RatingRepository ratingRepository) {
        this.principalService = principalService;
        this.ratingRepository = ratingRepository;
    }

    public boolean isRating(Long compositionId) {
        Long userId = principalService.getPrincipal().getId();
        Optional<RatingComposition> rating = ratingRepository.findByUserIdAndCompositionId(userId, compositionId);
        return rating.isPresent();
    }

    public Long userRatingComposition(Long compositionId) {
        Long userId = principalService.getPrincipal().getId();
        return ratingRepository.getUserRating(userId, compositionId);
    }

    public Float getRatingComposition(Long compositionId) {
        Float compositionRating = ratingRepository.getCompositionRating(compositionId);
        if (compositionRating == null) return 0.0f;
        return Precision.round(compositionRating, 2);
    }

    public void saveRating(RatingDTO ratingDTO) {
        Long userId = principalService.getPrincipal().getId();
        RatingComposition newRating = new RatingComposition();
        newRating.setUserId(userId);
        newRating.setCompositionId(ratingDTO.getCompositionId());
        newRating.setRating(ratingDTO.getRating());
        ratingRepository.save(newRating);
    }
}
