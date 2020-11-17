package syntaxerror.sagar.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import syntaxerror.sagar.model.dto.ResultData;
import syntaxerror.sagar.model.entity.CordenadorEntity;
import syntaxerror.sagar.model.entity.ProfessorEntity;
import syntaxerror.sagar.repository.CordenadorRepository;
import syntaxerror.sagar.repository.ProfessorRepository;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    CordenadorRepository cordenadorRepository;


    public ResponseEntity loginProfessor(ProfessorEntity professor){
        ResultData resultData = null;
        try {
            List<ProfessorEntity> professorLogin = professorRepository.findByCdMatriculaAndPwAcesso(professor.getCdMatricula(), professor.getPwAcesso());
            if(professorLogin.size() <= 0) {
                resultData = new ResultData(HttpStatus.NOT_FOUND.value(), "Matricula ou Senha Incorretos!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultData);
            }else{
                resultData = new ResultData(HttpStatus.OK.value(), "Professor logado com sucesso!", professorLogin.get(0));
                return ResponseEntity.status(HttpStatus.OK).body(resultData);
            }
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao realizar login do professor! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }
    }

    public ResponseEntity loginCordenador (CordenadorEntity cordenador){
        ResultData resultData = null;
        try {
            List<CordenadorEntity> cordenadorLogin = cordenadorRepository.findByCdMatriculaAndPwAcesso(cordenador.getCdMatricula(), cordenador.getPwAcesso());
            if(cordenadorLogin.size() <= 0) {
                resultData = new ResultData(HttpStatus.NOT_FOUND.value(), "Matricula ou Senha Incorretos!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultData);
            }else{
                resultData = new ResultData(HttpStatus.OK.value(), "Cordenador logado com sucesso!", cordenadorLogin.get(0));
                return ResponseEntity.status(HttpStatus.OK).body(resultData);
            }
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao realizar login do cordenador! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }
    }
}
