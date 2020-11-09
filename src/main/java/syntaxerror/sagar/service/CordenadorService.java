package syntaxerror.sagar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import syntaxerror.sagar.model.dto.ResultData;
import syntaxerror.sagar.model.entity.CordenadorEntity;
import syntaxerror.sagar.repository.CordenadorRepository;

@Service
public class CordenadorService {
    @Autowired
    CordenadorRepository cordenadorRepository;

    public ResponseEntity buscarCordenadorPorMatricula(Integer matricula){
        ResultData resultData = null;
        try {
            CordenadorEntity cordenadorEntity = cordenadorRepository.findById(matricula).orElse(null);
            if(cordenadorEntity == null) {
                resultData = new ResultData(HttpStatus.NOT_FOUND.value(), "Cordenador não encontrado!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultData);
            }else{
                resultData = new ResultData(HttpStatus.OK.value(), "Cordenador consultado com sucesso!", cordenadorEntity);
                return ResponseEntity.status(HttpStatus.OK).body(resultData);
            }
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao consultar cordenador! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }
    }
}
