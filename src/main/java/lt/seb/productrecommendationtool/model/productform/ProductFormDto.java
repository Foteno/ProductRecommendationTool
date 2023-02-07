package lt.seb.productrecommendationtool.model.productform;

import lombok.Data;
import lt.seb.productrecommendationtool.model.enums.Age;
import lt.seb.productrecommendationtool.model.enums.Income;

@Data
public class ProductFormDto {
    private Age age;
    private Income income;
    private Boolean isStudent;

    public static ProductForm from(ProductFormDto productFormDto) {
        return ProductForm.builder()
                .age(productFormDto.getAge())
                .income(productFormDto.getIncome())
                .isStudent(productFormDto.getIsStudent())
                .build();
    }
}
