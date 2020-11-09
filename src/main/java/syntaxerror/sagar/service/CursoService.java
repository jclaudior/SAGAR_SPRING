package syntaxerror.sagar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import syntaxerror.sagar.model.dto.ResultData;
import syntaxerror.sagar.model.entity.CursoEntity;
import syntaxerror.sagar.model.entity.ProfessorEntity;
import syntaxerror.sagar.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepository;

    public ResponseEntity buscarCursoPorCodigo(Integer codigo){
        ResultData resultData = null;
        try {
            CursoEntity cursoEntity = cursoRepository.findById(codigo).orElse(null);
            if(cursoEntity == null) {
                resultData = new ResultData(HttpStatus.NOT_FOUND.value(), "Curso não encontrado!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultData);
            }else{
                resultData = new ResultData(HttpStatus.OK.value(), "Curso consultado com sucesso!",cursoEntity );
                return ResponseEntity.status(HttpStatus.OK).body(resultData);
            }
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao consultar curso! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }
    }

    public ResponseEntity inserirCurso (CursoEntity curso){
        ResultData resultData = null;
        try {
            CursoEntity cursoVerifica = cursoRepository.findById(curso.getCdCurso()).orElse(null);
            if(cursoVerifica != null){
                resultData = new ResultData(HttpStatus.CONFLICT.value(), "Curso com este codigo ja cadastrado na base de dados!", cursoVerifica);
                return ResponseEntity.status(HttpStatus.CONFLICT).body(resultData);
            }
            cursoRepository.save(curso);
            resultData = new ResultData(HttpStatus.CREATED.value(), "Curso cadastrado com sucesso!", curso);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao cadastrar curso! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }
    }

    public ResponseEntity alterarCurso (CursoEntity curso){
        ResultData resultData = null;
        try {
            CursoEntity cursoAlterar = cursoRepository.findById(curso.getCdCurso()).orElse(null);
            if(cursoAlterar == null){
                resultData = new ResultData(HttpStatus.NOT_FOUND.value(), "Curso não encontrado para alteração!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultData);
            }
            cursoAlterar.setNmCurso(curso.getNmCurso());
            cursoAlterar.setCordenadorEntity(curso.getCordenadorEntity());
            cursoAlterar.setDisciplinas(curso.getDisciplinas());

            cursoRepository.save(cursoAlterar);

            resultData = new ResultData(HttpStatus.OK.value(), "Curso alterado com sucesso!", cursoAlterar);
            return ResponseEntity.status(HttpStatus.OK).body(resultData);
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao alterar curso! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }


    }
}
