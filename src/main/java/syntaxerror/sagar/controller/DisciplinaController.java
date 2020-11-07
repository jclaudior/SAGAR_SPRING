package syntaxerror.sagar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syntaxerror.sagar.model.entity.DisciplinaEntity;
import syntaxerror.sagar.service.DisciplinaService;

@RestController
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @GetMapping("/disciplina/{codigo}")
    public ResponseEntity buscarDisciplinaPorCurso(@PathVariable("codigo") Integer codigo){
        return disciplinaService.buscarDisciplinaPorCodigo(codigo);
    }

    @PostMapping("/disciplina")
    public ResponseEntity inserirDisciplina(@RequestBody DisciplinaEntity disciplina){
        return disciplinaService.inserirDisciplina(disciplina);
    }

    @PutMapping("/disciplina")
    public ResponseEntity alterarDisciplina (@RequestBody DisciplinaEntity disciplina){
        return disciplinaService.alterarDisciplina(disciplina);
    }
}
