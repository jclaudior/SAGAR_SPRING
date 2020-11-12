package syntaxerror.sagar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syntaxerror.sagar.model.entity.AulaEntity;
import syntaxerror.sagar.model.entity.DisciplinaEntity;
import syntaxerror.sagar.service.AulaService;
import syntaxerror.sagar.service.DisciplinaService;

@RestController
public class AulaController {
    @Autowired
    AulaService aulaService;

    @GetMapping("/aula/{idAula}")
    public ResponseEntity buscarAulaPorId(@PathVariable("idAula") Integer idAula){
        return aulaService.buscarAulaPorCodigo(idAula);
    }

    @GetMapping("/aula")
    public ResponseEntity listarAula(){
        return aulaService.listarAulas();
    }

    @PostMapping("/aula")
    public ResponseEntity inserirAula(@RequestBody AulaEntity aula){
        return aulaService.inserirAula(aula);
    }

    @PutMapping("/aula")
    public ResponseEntity alterarDisciplina (@RequestBody AulaEntity aula){
        return aulaService.alterarAula(aula);
    }
}
