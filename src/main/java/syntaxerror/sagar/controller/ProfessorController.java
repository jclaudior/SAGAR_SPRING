package syntaxerror.sagar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import syntaxerror.sagar.model.entity.ProfessorEntity;
import syntaxerror.sagar.service.ProfessorService;

@RestController
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @GetMapping("/professor/{matricula}")
    public ProfessorEntity buscarProfessorPorMatricula(@PathVariable("matricula") Integer matricula){
        return professorService.buscarProfessorPorMatricula(matricula);
    }

    @PostMapping("/professor")
    public void inserirProfessor(@RequestBody ProfessorEntity professor){
        professorService.inserirProfessor(professor);
    }

    @PutMapping("/professor")
    public void alterarProfessor (@RequestBody ProfessorEntity professor){
        professorService.alterarProfessor(professor);
    }


}
