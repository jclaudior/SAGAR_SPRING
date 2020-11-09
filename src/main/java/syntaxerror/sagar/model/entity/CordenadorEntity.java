package syntaxerror.sagar.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TB_CORDENADOR")
public class CordenadorEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_MATRICULA")
    private Integer cdMatricula;

    @Column(name="NM_CORDENADOR")
    private String nmCordenador;

    @Column(name = "PW_ACESSO")
    private String pwAcesso;

    @Column(name="ST_CORDENADOR", nullable = false)
    private Boolean stCordenador = true;
}
