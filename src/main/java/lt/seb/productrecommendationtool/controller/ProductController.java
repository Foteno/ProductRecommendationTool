package lt.seb.productrecommendationtool.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import lt.seb.productrecommendationtool.model.newproductdto.NewProductDto;
import lt.seb.productrecommendationtool.model.productform.ProductFormDto;
import lt.seb.productrecommendationtool.model.suggestion.ProductSuggestionDto;
import lt.seb.productrecommendationtool.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
@CommonsLog
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public List<ProductSuggestionDto> getRecommendedProduct(@RequestBody ProductFormDto productFormDto) {
        return productService.suggestProduct(productFormDto);
    }

    @PostMapping("/new")
    public void newProduct(@RequestBody NewProductDto newProductDto) {
        productService.newProduct(newProductDto);
    }
}
