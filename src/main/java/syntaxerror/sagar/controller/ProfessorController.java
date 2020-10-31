package syntaxerror.sagar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syntaxerror.sagar.model.entity.ProfessorEntity;
import syntaxerror.sagar.service.ProfessorService;

@RestController
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @GetMapping("/professor/{matricula}")
    public ResponseEntity buscarProfessorPorMatricula(@PathVariable("matricula") Integer matricula){
        return professorService.buscarProfessorPorMatricula(matricula);
    }

    @PostMapping("/professor")
    public ResponseEntity inserirProfessor(@RequestBody ProfessorEntity professor){
        return professorService.inserirProfessor(professor);
    }

    @PutMapping("/professor")
    public ResponseEntity alterarProfessor (@RequestBody ProfessorEntity professor){
        return professorService.alterarProfessor(professor);
    }


}
