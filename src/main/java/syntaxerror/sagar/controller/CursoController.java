package syntaxerror.sagar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syntaxerror.sagar.model.entity.CursoEntity;
import syntaxerror.sagar.model.entity.DisciplinaEntity;
import syntaxerror.sagar.service.CursoService;

@RestController
public class CursoController {
    @Autowired
    CursoService cursoService;

    @GetMapping("/curso/{codigo}")
    public ResponseEntity buscarCursoPorCodigo(@PathVariable("codigo") Integer codigo){
        return cursoService.buscarCursoPorCodigo(codigo);
    }

    @GetMapping("/curso")
    public ResponseEntity listarCurso(){
        return cursoService.listarCursos();
    }

    @PostMapping("/curso")
    public ResponseEntity inserirDisciplina(@RequestBody CursoEntity curso){
        return cursoService.inserirCurso(curso);
    }

    @PutMapping("/curso")
    public ResponseEntity alterarCurso (@RequestBody CursoEntity curso){
        return cursoService.alterarCurso(curso);
    }
}
