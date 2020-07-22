package by.home.courseback.controller;

import by.home.courseback.service.LikeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/like")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/count/{chapterId}")
    public Long allLikes(@PathVariable Long chapterId) {
        return likeService.countLikeByComposition(chapterId);
    }

    @GetMapping("/isLike/{chapterId}")
    public boolean getLike(@PathVariable Long chapterId) {
        return likeService.isLike(chapterId);
    }

    @PostMapping("/{chapterId}")
    public void saveLike(@PathVariable Long chapterId) {
        likeService.saveLike(chapterId);
    }
}
