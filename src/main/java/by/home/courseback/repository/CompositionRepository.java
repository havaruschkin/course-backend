package by.home.courseback.repository;

import by.home.courseback.model.Composition;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompositionRepository extends JpaRepository<Composition, Long>, JpaSpecificationExecutor<Composition> {

    List<Composition> findByUserId (Long userId);


}
