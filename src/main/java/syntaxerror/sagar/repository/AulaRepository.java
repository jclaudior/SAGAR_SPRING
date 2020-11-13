package syntaxerror.sagar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syntaxerror.sagar.model.entity.AulaEntity;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

@Repository
public interface AulaRepository extends JpaRepository<AulaEntity, Integer> {

}
