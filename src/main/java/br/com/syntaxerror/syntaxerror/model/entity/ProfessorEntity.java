package br.com.syntaxerror.syntaxerror.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "TB_PROFESSOR")
public class ProfessorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_MATRICULA")
    private BigInteger cdMatricula;

    @Column(name = "NM_PROFESSOR")
    private String nmProfessor;

    @Column(name = "DS_EMAIL")
    private String dsEmail;

    @Column(name = "DS_CELULAR")
    private String dsCelular;

    @Column(name = "PW_ACESSO")
    private String pwAcesso;
}
