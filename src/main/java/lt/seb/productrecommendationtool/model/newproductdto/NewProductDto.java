package lt.seb.productrecommendationtool.model.newproductdto;

import lombok.Data;
import lt.seb.productrecommendationtool.model.enums.Age;
import lt.seb.productrecommendationtool.model.enums.Income;

import java.util.List;

@Data
public class NewProductDto {
    private List<Age> ages;
    private List<Income> incomes;
    private Boolean isStudent;
}
