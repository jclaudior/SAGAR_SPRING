package br.com.syntaxerror.syntaxerror.service;

import br.com.syntaxerror.syntaxerror.model.entity.ProfessorEntity;
import br.com.syntaxerror.syntaxerror.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;


    public ProfessorEntity buscarProfessorMatricula(BigInteger matricula){
        return professorRepository.getOne(matricula);
    }

    public void inserirProfessor(ProfessorEntity professor){
        professorRepository.save(professor);
    }
}
