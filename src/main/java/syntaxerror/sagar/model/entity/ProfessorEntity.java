package syntaxerror.sagar.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TB_PROFESSOR")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_MATRICULA")
    private Integer cdMatricula;

    @Column(name="NM_PROFESSOR")
    private String nmProfessor;

    @Column(name = "DS_EMAIL")
    private String dsEmail;

    @Column(name = "DS_CELULAR")
    private String dsCelular;

    @Column(name = "PW_ACESSO")
    private String pwAcesso;

    @Column(name="ST_PROFESSOR")
    private Boolean stProfessor;

}
