package syntaxerror.sagar.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TB_CURSO")
public class CursoEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_CURSO")
    private Integer cdCurso;

    @Column(name="NM_CURSO")
    private String nmCurso;

    @ManyToOne
    @JoinColumn(name = "CD_CORDENADOR")
    private CordenadorEntity cordenadorEntity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_CURSO_DISCIPLINA",
            joinColumns = @JoinColumn(name = "CD_CURSO"),
            inverseJoinColumns = @JoinColumn(name = "CD_DISCIPLINA")
    )
    private List<DisciplinaEntity> disciplinas;

    @Column(name="ST_CURSO", nullable = false)
    private Boolean stCurso = true;

}
