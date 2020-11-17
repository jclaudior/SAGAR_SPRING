package syntaxerror.sagar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syntaxerror.sagar.model.entity.ProfessorEntity;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository <ProfessorEntity, Integer> {
    List<ProfessorEntity> findByCdMatriculaAndPwAcesso (Integer matricula, String senha);
}


