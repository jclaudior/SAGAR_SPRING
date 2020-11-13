package syntaxerror.sagar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import syntaxerror.sagar.model.dto.DashboardDTO;
import syntaxerror.sagar.model.entity.AulaEntity;
import syntaxerror.sagar.repository.AulaRepository;
import syntaxerror.sagar.repository.DashboardRepository;


import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DashboardService {
    @Autowired
    DashboardRepository dashboardRepository;

    List<String> colorsList = new ArrayList<>(Arrays.asList(
            "#ff4000",
            "#ff8000",
            "#ffbf00",
            "#ffff00",
            "#bfff00",
            "#80ff00",
            "#40ff00",
            "#00ff00",
            "#00ff40",
            "#00ff80",
            "#00ffbf",
            "#00ffff",
            "#00bfff",
            "#0080ff",
            "#0040ff",
            "#0000ff",
            "#4000ff",
            "#8000ff",
            "#bf00ff",
            "#ff00ff",
            "#ff00bf",
            "#ff0080",
            "#ff0040",
            "#ff0000"));

    public DashboardDTO topAcessoAula(Date dtInicial, Date dtFinal){

        List<String> colors = new ArrayList<>();;
        List<Integer> values = new ArrayList<>();
        List<String> labels = new ArrayList<>();;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Object[]> listEntity = (List<Object[]>) dashboardRepository.findAllTopAcessoAula(dateFormat.format(dtInicial), dateFormat.format(dtFinal));

        for (Object[] dash: listEntity) {
            labels.add((String) dash[0]);
            values.add(Integer.parseInt(dash[1].toString()));
            Random rand = new Random();
            colors.add(colorsList.get(rand.nextInt(colorsList.size())));
        }

        DashboardDTO dashboardDTO = new DashboardDTO(colors, values, labels, "Quantidade de Alunos Conectados");
        return dashboardDTO;
    }


    public DashboardDTO lowAcessoAula(Date dtInicial, Date dtFinal){

        List<String> colors = new ArrayList<>();;
        List<Integer> values = new ArrayList<>();
        List<String> labels = new ArrayList<>();;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Object[]> listEntity = (List<Object[]>) dashboardRepository.findAllLowAcessoAula(dateFormat.format(dtInicial), dateFormat.format(dtFinal));

        for (Object[] dash: listEntity) {
            labels.add((String) dash[0]);
            values.add(Integer.parseInt(dash[1].toString()));
            Random rand = new Random();
            colors.add(colorsList.get(rand.nextInt(colorsList.size())));
        }

        DashboardDTO dashboardDTO = new DashboardDTO(colors, values, labels, "Quantidade de Alunos Conectados");
        return dashboardDTO;
    }



}
