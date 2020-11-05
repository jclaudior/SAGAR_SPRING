package syntaxerror.sagar.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syntaxerror.sagar.model.entity.DisciplinaEntity;


@Repository
public interface DisciplinaRepository extends JpaRepository <DisciplinaEntity, Integer> {
}
