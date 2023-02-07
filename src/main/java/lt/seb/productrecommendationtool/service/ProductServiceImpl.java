package lt.seb.productrecommendationtool.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import lt.seb.productrecommendationtool.model.newproductdto.NewProductDto;
import lt.seb.productrecommendationtool.model.productform.ProductForm;
import lt.seb.productrecommendationtool.model.productform.ProductFormDto;
import lt.seb.productrecommendationtool.model.suggestion.ProductSuggestionDto;
import lt.seb.productrecommendationtool.service.productmapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@CommonsLog
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final String FILE_NAME = "products.txt";

    @Override
    public List<ProductSuggestionDto> suggestProduct(ProductFormDto productFormDto) {
        ProductForm productForm = ProductFormDto.from(productFormDto);
        List<String> products = new ArrayList<>();

        for (Map.Entry<String, Predicate<ProductForm>> stringPredicateEntry : ProductMapper.productRuleMap.entrySet()) {
            if (stringPredicateEntry.getValue().test(productForm)) {
                products.add(stringPredicateEntry.getKey());
            }
        }

        return products.stream()
                .map(ProductSuggestionDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void newProduct(NewProductDto newProductDto) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true)) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
