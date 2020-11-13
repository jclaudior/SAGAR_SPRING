package syntaxerror.sagar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import syntaxerror.sagar.model.dto.DashboardDTO;
import syntaxerror.sagar.model.entity.AulaEntity;
import syntaxerror.sagar.service.DashboardService;

import java.util.Date;
import java.util.List;

@RestController
public class DashboardController {
    @Autowired
    DashboardService dashboardService;

    @GetMapping("/dashboard/aula/top/{dtInicial}/{dtFinal}")
    public DashboardDTO topAcessoAula(@PathVariable("dtInicial") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtInicial, @PathVariable("dtFinal") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtFinal){
        return dashboardService.topAcessoAula(dtInicial,dtFinal);
    }

    @GetMapping("/dashboard/aula/low/{dtInicial}/{dtFinal}")
    public DashboardDTO lowAcessoAula(@PathVariable("dtInicial") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtInicial, @PathVariable("dtFinal") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtFinal){
        return dashboardService.lowAcessoAula(dtInicial,dtFinal);
    }
}
