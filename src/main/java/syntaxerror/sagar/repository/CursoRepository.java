package syntaxerror.sagar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syntaxerror.sagar.model.entity.CursoEntity;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Integer> {
}
