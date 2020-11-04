package syntaxerror.sagar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syntaxerror.sagar.model.entity.TurmaEntity;
import syntaxerror.sagar.service.TurmaService;

@RestController
public class TurmaController {

    @Autowired
    TurmaService turmaService;

    @GetMapping("/turma/{codigo}")
    public ResponseEntity buscarTurmaPorCodigo(@PathVariable("codigo") Integer codigo){
        return turmaService.buscarTurmaPorCodigo(codigo);
    }

    @PostMapping("/turma")
    public ResponseEntity inserirTurma(@RequestBody TurmaEntity turma){
        return turmaService.inserirTurma(turma);
    }

    @PutMapping("/turma")
    public ResponseEntity alterarTurma (@RequestBody TurmaEntity turma){
        return turmaService.alterarTurma(turma);
    }


}