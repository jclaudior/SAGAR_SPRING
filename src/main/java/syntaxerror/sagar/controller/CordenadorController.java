package syntaxerror.sagar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import syntaxerror.sagar.service.CordenadorService;

@RestController
public class CordenadorController {
    @Autowired
    CordenadorService cordenadorService;

    @GetMapping("/cordenador/{matricula}")
    public ResponseEntity buscarCordenadorPorMatricula(@PathVariable("matricula") Integer matricula){
        return cordenadorService.buscarCordenadorPorMatricula(matricula);
    }
}
