package syntaxerror.sagar.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TB_AULA")
public class AulaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_AULA")
    private Integer idAula;

    @ManyToOne
    @JoinColumn(name="CD_PROFESSOR")
    private ProfessorEntity professor;

    @ManyToOne
    @JoinColumn(name="CD_TURMA")
    private TurmaEntity turma;

    @ManyToOne
    @JoinColumn(name="CD_DISCIPLINA")
    private DisciplinaEntity disciplina;

    @Column(name="LK_AULA")
    private String lkAula;

    @Column(name="LK_GRAVACAO")
    private String lkGravacao;

    @Column(name="QT_ALUNO")
    private Integer qtAluno;

    @Column(name = "DT_AULA")
    private Date dtAula;

    @Column(name = "HR_INICIO")
    private String hrInicio;

    @Column(name="hrTermino")
    private String hrTermino;

    @Column(name="DS_AULA")
    private String dsAula;

}
