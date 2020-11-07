package syntaxerror.sagar.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import syntaxerror.sagar.model.dto.ResultData;
import syntaxerror.sagar.model.entity.DisciplinaEntity;
import syntaxerror.sagar.repository.DisciplinaRepository;

import javax.xml.transform.Result;

@Service
public class DisciplinaService {
    @Autowired
    DisciplinaRepository disciplinaRepository;

    public ResponseEntity buscarDisciplinaPorCodigo(Integer disciplina) {
        ResultData resultdata = null;
        try{
           DisciplinaEntity disciplinaEntity = disciplinaRepository.findById(disciplina).orElse(null);
            if(disciplinaEntity == null) {
                resultdata = new ResultData(HttpStatus.NOT_FOUND.value(), "Disciplina não encontrada!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultdata);
            } else {
                resultdata = new ResultData(HttpStatus.OK.value(),  "Disciplina consultada com sucesso!", disciplinaEntity);
                return ResponseEntity.status(HttpStatus.OK).body(resultdata);
            }
        }catch (Exception e){
            resultdata = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(),  "Erro ao consultar Disciplina! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultdata);
        }
    }

    public ResponseEntity inserirDisciplina (DisciplinaEntity disciplina) {
        ResultData resultData = null;
        try {
            disciplinaRepository.save(disciplina);
            resultData = new ResultData (HttpStatus.CREATED.value(), "Disciplina cadastrada com sucesso!", disciplina);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
        } catch (Exception e) {
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao cadastrar disciplina! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }
    }
    public ResponseEntity alterarDisciplina(DisciplinaEntity disciplina){
        ResultData resultData = null;
        try {
            DisciplinaEntity disciplinaAlterar = disciplinaRepository.findById(disciplina.getIdDisciplina()).orElse(
            null);
            if (disciplinaAlterar == null) {
                resultData = new ResultData(HttpStatus.NOT_FOUND.value(), "Disciplina não encontrada para alteração!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultData);

            }
            disciplinaAlterar.setIdDisciplina(disciplina.getIdDisciplina());
            disciplinaAlterar.setNmDisciplina(disciplina.getNmDisciplina());
            disciplinaAlterar.setQtHora(disciplina.getQtHora());
            disciplinaAlterar.setStDisciplina(disciplina.getStDisciplina());

            disciplinaRepository.save(disciplinaAlterar);

            resultData = new ResultData(HttpStatus.OK.value(), "Disciplina alterada com sucesso!", disciplinaAlterar);
            return ResponseEntity.status(HttpStatus.OK).body(resultData);
        }catch (Exception e) {
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Erro ao alterar disciplina! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }
    }
}
