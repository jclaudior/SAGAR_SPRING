package syntaxerror.sagar.model.entity;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Data
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

    @Column (name = "ST_DISCIPLINA")
    private Integer stDisciplina;

}
