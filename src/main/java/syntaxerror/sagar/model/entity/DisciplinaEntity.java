package syntaxerror.sagar.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="TB_DISCIPLINA")

public class DisciplinaEntity {

    @Id
    @Column(name = "ID_DISCIPLINA")
    private Integer idDisciplina;

    @Column(name = "NM_DISCIPLINA")
    private String nmDisciplina;

    @Column (name = "QT_HORA")
    private Integer qtHora;

    @Column (name = "ST_DISCIPLINA", nullable = false)
    private Boolean stDisciplina = true;

}
