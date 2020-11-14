package syntaxerror.sagar.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import syntaxerror.sagar.model.entity.AulaEntity;


import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface DashboardRepository extends PagingAndSortingRepository<AulaEntity, Integer> {
        //List<AulaEntity> findByDtAulaBetweenOrderByQtAlunoDesc(Date dtInico, Date dtFim, Pageable pageable);

        @Query(
                value = "SELECT TB_DISCIPLINA.NM_DISCIPLINA, SUM(TB_AULA.QT_ALUNO) AS 'TOTAL' FROM TB_AULA\n" +
                        "JOIN TB_DISCIPLINA ON TB_AULA.CD_DISCIPLINA = TB_DISCIPLINA.ID_DISCIPLINA\n" +
                        "WHERE DT_AULA BETWEEN :dtInicio AND :dtFim \n" +
                        "GROUP BY(TB_DISCIPLINA.NM_DISCIPLINA) ORDER BY TOTAL DESC\n" +
                        "LIMIT 5;",
                nativeQuery = true)
        Collection<Object[]> findAllTopAcessoAula(@Param("dtInicio") String dtInicial, @Param("dtFim") String dtFim);

        @Query(
                value = "SELECT TB_DISCIPLINA.NM_DISCIPLINA, SUM(TB_AULA.QT_ALUNO) AS 'TOTAL' FROM TB_AULA\n" +
                        "JOIN TB_DISCIPLINA ON TB_AULA.CD_DISCIPLINA = TB_DISCIPLINA.ID_DISCIPLINA\n" +
                        "WHERE DT_AULA BETWEEN :dtInicio AND :dtFim \n" +
                        "GROUP BY(TB_DISCIPLINA.NM_DISCIPLINA) ORDER BY TOTAL\n" +
                        "LIMIT 5;",
                nativeQuery = true)
        Collection<Object[]> findAllLowAcessoAula(@Param("dtInicio") String dtInicial, @Param("dtFim") String dtFim);

        @Query(
                value = "SELECT TB_AULA.QT_ALUNO, TB_DISCIPLINA.NM_DISCIPLINA, TB_AULA.DT_AULA FROM TB_AULA\n" +
                        "JOIN TB_DISCIPLINA ON TB_AULA.CD_DISCIPLINA = TB_DISCIPLINA.ID_DISCIPLINA\n" +
                        "WHERE DT_AULA BETWEEN :dtInicio AND :dtFim AND TB_DISCIPLINA.NM_DISCIPLINA = :nmDisciplina\n" +
                        "ORDER BY TB_AULA.DT_AULA;", nativeQuery = true)
        Collection<Object []> findAccessOfDisciplinaInEachClass
                (@Param("dtInicio") String dtInicio,
                 @Param("dtFim") String dtFim,
                 @Param("nmDisciplina") String disciplina);
}