package syntaxerror.sagar.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import syntaxerror.sagar.model.entity.AulaEntity;


import java.util.Date;
import java.util.List;

@Repository
public interface DashboardRepository extends PagingAndSortingRepository<AulaEntity, Integer> {
        List<AulaEntity> findByDtAulaBetweenOrderByQtAlunoDesc(Date dtInico, Date dtFim, Pageable pageable);
}