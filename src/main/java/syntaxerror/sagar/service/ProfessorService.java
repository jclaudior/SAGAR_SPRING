package syntaxerror.sagar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import syntaxerror.sagar.model.entity.ProfessorEntity;
import syntaxerror.sagar.repository.ProfessorRepository;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    public ProfessorEntity buscarProfessorPorMatricula(Integer matricula){
        return professorRepository.getOne(matricula);
    }

    public void inserirProfessor (ProfessorEntity professor){
        professorRepository.save(professor);
    }

    public void alterarProfessor (ProfessorEntity professor){
        ProfessorEntity professorAlterar = professorRepository.getOne(professor.getCdMatricula());
        professorAlterar.setNmProfessor(professor.getNmProfessor());
        professorAlterar.setDsEmail(professor.getDsEmail());
        professorAlterar.setDsCelular(professor.getDsCelular());
        professorAlterar.setPwAcesso(professor.getPwAcesso());
        professorAlterar.setStProfessor(professor.getStProfessor());

        professorRepository.save(professorAlterar);
    }
}
