package by.home.courseback.repository;

import by.home.courseback.model.Authority;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Optional<Authority> findByName(String name);

    Set<Authority> findByNameIn(Collection<String> names);
}
