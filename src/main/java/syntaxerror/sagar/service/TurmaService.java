package syntaxerror.sagar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import syntaxerror.sagar.model.dto.ResultData;
import syntaxerror.sagar.model.entity.CursoEntity;
import syntaxerror.sagar.model.entity.TurmaEntity;
import syntaxerror.sagar.repository.TurmaRepository;

import java.util.List;


@Service
public class TurmaService {
    @Autowired
    TurmaRepository turmaRepository;

    public ResponseEntity listarTurma (){
        ResultData resultdata = null;
        try{
            List<TurmaEntity> turmas = turmaRepository.findAll();
            resultdata = new ResultData(HttpStatus.OK.value(),  "Turma listado com sucesso!", turmas);
            return ResponseEntity.status(HttpStatus.OK).body(resultdata);
        }catch (Exception e){
            resultdata = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(),  "Erro ao listar Turma! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultdata);
        }
    }

    public ResponseEntity buscarTurmaPorCodigo(Integer codigo){
        ResultData resultData = null;
        try {
            TurmaEntity turmaEntity = turmaRepository.findById(codigo).orElse(null);
            if(turmaEntity == null) {
                resultData = new ResultData(HttpStatus.NOT_FOUND.value(), "Turma não encontrada!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultData);
            }else{
                resultData = new ResultData(HttpStatus.OK.value(), "Turma consultada com sucesso!", turmaEntity);
                return ResponseEntity.status(HttpStatus.OK).body(resultData);
            }
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao consultar turma! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }
    }

    public ResponseEntity inserirTurma (TurmaEntity turma){
        ResultData resultData = null;
        try {
            turmaRepository.save(turma);
            resultData = new ResultData(HttpStatus.CREATED.value(), "Turma cadastrada com sucesso!", turma);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao cadastrar turma! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }
    }

    public ResponseEntity alterarTurma (TurmaEntity turma){
        ResultData resultData = null;
        try {
            TurmaEntity turmaAlterar = turmaRepository.findById(turma.getCdTurma()).orElse(null);
            if(turmaAlterar == null){
                resultData = new ResultData(HttpStatus.NOT_FOUND.value(), "Turma não encontrado para alteração!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultData);
            }
            turmaAlterar.setNmTurma(turma.getNmTurma());
            turmaAlterar.setDsPeriodo(turma.getDsPeriodo());
            turmaAlterar.setStTurma(turma.getStTurma());

            turmaRepository.save(turmaAlterar);

            resultData = new ResultData(HttpStatus.OK.value(), "Turma alterado com sucesso!", turmaAlterar);
            return ResponseEntity.status(HttpStatus.OK).body(resultData);
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao alterar turma! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }


    }
}
