package syntaxerror.sagar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import syntaxerror.sagar.model.dto.ResultData;
import syntaxerror.sagar.model.entity.ProfessorEntity;
import syntaxerror.sagar.repository.ProfessorRepository;


@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    public ResponseEntity buscarProfessorPorMatricula(Integer matricula){
        ResultData resultData = null;
        try {
            ProfessorEntity professorEntity = professorRepository.getOne(matricula);
            if(professorEntity == null) {
                resultData = new ResultData(HttpStatus.NOT_FOUND.value(), "Professor não encontrado!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultData);
            }else{
                resultData = new ResultData(HttpStatus.FOUND.value(), "Professor consultado com sucesso!", professorEntity);
                return ResponseEntity.status(HttpStatus.FOUND).body(resultData);
            }
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao consultar professor! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }
    }

    public ResponseEntity inserirProfessor (ProfessorEntity professor){
        ResultData resultData = null;
        try {
            professorRepository.save(professor);
            resultData = new ResultData(HttpStatus.CREATED.value(), "Professor cadastrado com sucesso!", professor);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao cadastrar professor! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }
    }

    public ResponseEntity alterarProfessor (ProfessorEntity professor){
        ResultData resultData = null;
        try {
            ProfessorEntity professorAlterar = professorRepository.getOne(professor.getCdMatricula());
            if(professorAlterar == null){
                resultData = new ResultData(HttpStatus.NOT_FOUND.value(), "Professor não encontrado para alteração!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultData);
            }
            professorAlterar.setNmProfessor(professor.getNmProfessor());
            professorAlterar.setDsEmail(professor.getDsEmail());
            professorAlterar.setDsCelular(professor.getDsCelular());
            professorAlterar.setPwAcesso(professor.getPwAcesso());
            professorAlterar.setStProfessor(professor.getStProfessor());

            professorRepository.save(professorAlterar);

            resultData = new ResultData(HttpStatus.OK.value(), "Professor alterado com sucesso!", professorAlterar);
            return ResponseEntity.status(HttpStatus.OK).body(resultData);

        }catch (Exception e){
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao alterar professor! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }


    }
}
