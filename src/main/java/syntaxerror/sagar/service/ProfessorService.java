package syntaxerror.sagar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import syntaxerror.sagar.model.dto.ResultData;
import syntaxerror.sagar.model.entity.ProfessorEntity;
import syntaxerror.sagar.repository.ProfessorRepository;


@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    private JavaMailSender mailSender;

    public ResponseEntity buscarProfessorPorMatricula(Integer matricula){
        ResultData resultData = null;
        try {
            ProfessorEntity professorEntity = professorRepository.findById(matricula).orElse(null);
            if(professorEntity == null) {
                resultData = new ResultData(HttpStatus.NOT_FOUND.value(), "Professor não encontrado!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultData);
            }else{
                resultData = new ResultData(HttpStatus.OK.value(), "Professor consultado com sucesso!", professorEntity);
                return ResponseEntity.status(HttpStatus.OK).body(resultData);
            }
        }catch (Exception e){
            resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao consultar professor! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
        }
    }

    public ResponseEntity inserirProfessor (ProfessorEntity professor){
        ResultData resultData = null;
        try {
            ProfessorEntity professorVerifica = professorRepository.findById(professor.getCdMatricula()).orElse(null);
            if(professorVerifica != null){
                resultData = new ResultData(HttpStatus.CONFLICT.value(), "Professor com esta matricula ja cadastrado na base de dados!",professorVerifica);
                return ResponseEntity.status(HttpStatus.CONFLICT).body(resultData);
            }
            professor.setPwAcesso(gerarSenha());
            professorRepository.save(professor);
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(professor.getDsEmail());
            email.setSubject("Senha e Matricula de Acesso SAGAR");
            email.setText("Matricula: "+professor.getCdMatricula() +" Senha: "+professor.getPwAcesso());
            mailSender.send(email);
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
            ProfessorEntity professorAlterar = professorRepository.findById(professor.getCdMatricula()).orElse(null);
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

    private static String gerarSenha(){
        int qtdeMaximaCaracteres = 8;
        String[] caracteres = { "0", "1", "b", "2", "4", "5", "6", "7", "8",
                "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
                "x", "y", "z"};

        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < qtdeMaximaCaracteres; i++) {
            int posicao = (int) (Math.random() * caracteres.length);
            senha.append(caracteres[posicao]);
        }
        return senha.toString();

    }
}
