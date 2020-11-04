package syntaxerror.sagar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syntaxerror.sagar.model.entity.TurmaEntity;

@Repository
public interface TurmaRepository extends JpaRepository <TurmaEntity, Integer> {
}


