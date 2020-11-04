package syntaxerror.sagar.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TB_TURMA")
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_CODIGO")
    private Integer cdCodigo;

    @Column(name="NM_TURMA")
    private String nmTurma;

    @Column(name = "DS_PERIODO")
    private String dsPeriodo;

    @Column(name="ST_TURMA")
    private Boolean stTurma;

}
