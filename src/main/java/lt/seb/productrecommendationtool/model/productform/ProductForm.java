package lt.seb.productrecommendationtool.model.productform;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lt.seb.productrecommendationtool.model.enums.Age;
import lt.seb.productrecommendationtool.model.enums.Income;

@Data
@AllArgsConstructor
@Builder
public class ProductForm {
    private Age age;
    private Income income;
    private boolean isStudent;
}
