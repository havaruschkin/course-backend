package by.home.courseback.repository.specification;

import by.home.courseback.model.Chapter;
import by.home.courseback.model.Chapter_;
import by.home.courseback.model.Comment;
import by.home.courseback.model.Comment_;
import by.home.courseback.model.Composition;
import by.home.courseback.model.Composition_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class CompositionSpecification implements Specification<Composition> {

    private final SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<Composition> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        String value = criteria.getValue().toLowerCase();
        Join<Composition, Chapter> chapters = root.join(Composition_.chapters, JoinType.INNER);
        Join<Composition, Comment> comments = root.join(Composition_.comments, JoinType.INNER);
        return criteriaBuilder.or(
                criteriaBuilder.like(criteriaBuilder.lower(chapters.get(Chapter_.chapterName)), value),
                criteriaBuilder.like(criteriaBuilder.lower(chapters.get(Chapter_.text)), value),
                criteriaBuilder.like(criteriaBuilder.lower(comments.get(Comment_.text)), value),
                criteriaBuilder.like(criteriaBuilder.lower(root.get(Composition_.compositionName)), value),
                criteriaBuilder.like(criteriaBuilder.lower(root.get(Composition_.description)), value)
        );
    }
}
