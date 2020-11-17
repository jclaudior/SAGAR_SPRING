package syntaxerror.sagar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import syntaxerror.sagar.model.entity.CordenadorEntity;
import syntaxerror.sagar.model.entity.ProfessorEntity;
import syntaxerror.sagar.service.LoginService;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login/professor")
    public ResponseEntity inserirProfessor(@RequestBody ProfessorEntity professor){
        return loginService.loginProfessor(professor);
    }

    @PostMapping("/login/cordenador")
    public ResponseEntity inserirProfessor(@RequestBody CordenadorEntity cordenador){
        return loginService.loginCordenador(cordenador);
    }
}
