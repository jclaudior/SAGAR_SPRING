package syntaxerror.sagar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import syntaxerror.sagar.model.dto.ResultData;
import syntaxerror.sagar.model.entity.AulaEntity;
import syntaxerror.sagar.repository.AulaRepository;

import java.util.List;

@Service
public class AulaService {
    @Autowired
    private AulaRepository aulaRepository;

    public ResponseEntity buscarAulaPorCodigo(Integer idAula) {
        ResultData resultdata = null;
        try{
            AulaEntity aulaEntity = aulaRepository.findById(idAula).orElse(null);
            if(aulaEntity == null) {
                resultdata = new ResultData(HttpStatus.NOT_FOUND.value(), "Aula não encontrada!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultdata);
            } else {
                resultdata = new ResultData(HttpStatus.OK.value(),  "Aula consultada com sucesso!", aulaEntity);
                return ResponseEntity.status(HttpStatus.OK).body(resultdata);
            }
        }catch (Exception e){
            resultdata = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(),  "Erro ao consultar Aula! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultdata);
        }
    }

    public ResponseEntity listarAulas (){
        ResultData resultdata = null;
        try{
            List<AulaEntity> aulas = aulaRepository.findAll();
            resultdata = new ResultData(HttpStatus.OK.value(),  "Aula listada com sucesso!", aulas);
            return ResponseEntity.status(HttpStatus.OK).body(resultdata);
        }catch (Exception e){
            resultdata = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(),  "Erro ao listar Aula! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultdata);
        }
    }

    public ResponseEntity inserirAula (AulaEntity aulaEntity) {
        ResultData resultData = null;
        try {
            aulaRepository.save(aulaEntity);
            resultData = new ResultData (HttpStatus.CREATED.value(), "Aula cadastrada com sucesso!", aulaEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
        } catch (Exception e) {
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao cadastrar aula! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }
    }
    public ResponseEntity alterarAula(AulaEntity aula){
        ResultData resultData = null;
        try {
            AulaEntity aulaAlterar = aulaRepository.findById(aula.getIdAula()).orElse(
                    null);
            if (aulaAlterar == null) {
                resultData = new ResultData(HttpStatus.NOT_FOUND.value(), "Aula não encontrada para alteração!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultData);

            }
            aulaAlterar.setProfessor(aula.getProfessor());
            aulaAlterar.setTurma(aula.getTurma());
            aulaAlterar.setDisciplina(aula.getDisciplina());
            aulaAlterar.setLkAula(aula.getLkAula());
            aulaAlterar.setLkGravacao(aula.getLkGravacao());
            aulaAlterar.setQtAluno(aula.getQtAluno());
            aulaAlterar.setDtAula(aula.getDtAula());
            aulaAlterar.setHrInicio(aula.getHrInicio());
            aulaAlterar.setHrTermino(aula.getHrTermino());
            aulaAlterar.setDsAula(aula.getDsAula());

            aulaRepository.save(aulaAlterar);

            resultData = new ResultData(HttpStatus.OK.value(), "Aula alterada com sucesso!", aulaAlterar);
            return ResponseEntity.status(HttpStatus.OK).body(resultData);
        }catch (Exception e) {
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Erro ao alterar aula! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }
    }
}
