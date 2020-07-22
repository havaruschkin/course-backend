package by.home.courseback.service;

import by.home.courseback.model.LikeChapter;
import by.home.courseback.repository.LikeRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LikeService {

    private final LikeRepository likeRepository;
    private final PrincipalService principalService;

    public LikeService(LikeRepository likeRepository, PrincipalService principalService) {
        this.likeRepository = likeRepository;
        this.principalService = principalService;
    }

    public boolean isLike(Long chapterId) {
        Long userId = principalService.getPrincipal().getId();
        Optional<LikeChapter> like = likeRepository.findByUserIdAndChapterId(userId, chapterId);
        return like.isPresent();
    }

    public Long countLikeByComposition(Long chapterId) {
        return likeRepository.countByChapterId(chapterId);
    }

    public void saveLike(Long chapterId) {
        Long userId = principalService.getPrincipal().getId();
        Optional<LikeChapter> like = likeRepository.findByUserIdAndChapterId(userId, chapterId);
        if (like.isPresent()) {
            likeRepository.delete(like.get());
        } else {
            LikeChapter newLike = new LikeChapter();
            newLike.setUserId(userId);
            newLike.setChapterId(chapterId);
            likeRepository.save(newLike);
        }
    }
}
