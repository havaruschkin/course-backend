package by.home.courseback.repository;

import by.home.courseback.model.Composition;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompositionRepository extends JpaRepository<Composition, Long> {

    List<Composition> findByUserId (Long userId);

}
