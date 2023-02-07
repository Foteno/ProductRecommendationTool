package lt.seb.productrecommendationtool.service;

import lt.seb.productrecommendationtool.model.newproductdto.NewProductDto;
import lt.seb.productrecommendationtool.model.productform.ProductFormDto;
import lt.seb.productrecommendationtool.model.suggestion.ProductSuggestionDto;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface ProductService {
    List<ProductSuggestionDto> suggestProduct(ProductFormDto productFormDto);
    void newProduct(NewProductDto newProductDto);
}
