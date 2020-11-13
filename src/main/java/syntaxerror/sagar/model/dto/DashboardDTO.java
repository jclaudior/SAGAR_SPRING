package syntaxerror.sagar.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DashboardDTO {
    private List<String> colors;
    private List<Integer> values;
    private List<String> labels;
    private String labe;


}
