package by.home.courseback.service;

import by.home.courseback.model.Composition;
import by.home.courseback.repository.CompositionRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompositionService {

    private final PrincipalService principalService;
    private final CompositionRepository compositionRepository;

    public CompositionService(PrincipalService principalService, CompositionRepository compositionRepository) {
        this.principalService = principalService;
        this.compositionRepository = compositionRepository;
    }

    public Composition findComposition(Long id) {
        return compositionRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public List<Composition> findAllCompositions() {
        return compositionRepository.findAll();
    }

    public List<Composition> findAllCompositionUser() {
        return compositionRepository.findByUserId(principalService.getPrincipal().getId());
    }

    public void saveComposition(Composition composition) {
        composition.setUser(principalService.getPrincipal());
        compositionRepository.save(composition);
    }

    public void deleteComposition(Long idComposition) {
        compositionRepository.deleteById(idComposition);
    }
}
