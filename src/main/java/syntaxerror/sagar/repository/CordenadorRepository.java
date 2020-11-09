package syntaxerror.sagar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syntaxerror.sagar.model.entity.CordenadorEntity;

@Repository
public interface CordenadorRepository extends JpaRepository<CordenadorEntity, Integer> {
}
