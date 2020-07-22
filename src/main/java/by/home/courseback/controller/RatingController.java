package by.home.courseback.controller;

import by.home.courseback.service.RatingService;
import by.home.courseback.service.dto.RatingDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/{compositionId}")
    public Float getRatingComposition(@PathVariable Long compositionId) {
        return ratingService.getRatingComposition(compositionId);
    }

    @GetMapping("/userRating/{compositionId}")
    public Long userRating(@PathVariable Long compositionId) {
        return ratingService.userRatingComposition(compositionId);
    }

    @GetMapping("/isRating/{compositionId}")
    public boolean isRating(@PathVariable Long compositionId) {
        return ratingService.isRating(compositionId);
    }

    @PostMapping
    public void saveRating(@RequestBody RatingDTO ratingDTO) {
        ratingService.saveRating(ratingDTO);
    }
}
