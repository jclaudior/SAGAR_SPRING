package br.com.syntaxerror.syntaxerror.repository;

import br.com.syntaxerror.syntaxerror.model.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {
}
