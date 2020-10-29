package br.com.syntaxerror.syntaxerror.controller;

import br.com.syntaxerror.syntaxerror.model.entity.ProfessorEntity;
import br.com.syntaxerror.syntaxerror.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }


    @GetMapping("/professor/{codigo}")
    public ProfessorEntity buscarProfessorPorMatricula(@PathVariable("codigo") BigInteger matricula){
        return professorService.buscarProfessorMatricula(matricula);
    }

    @PostMapping("/professor")
    public void inserirProfessor(@RequestBody ProfessorEntity professor){
        professorService.inserirProfessor(professor);
    }

}
