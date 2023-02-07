package lt.seb.productrecommendationtool.service.productmapper;

import lt.seb.productrecommendationtool.model.enums.Age;
import lt.seb.productrecommendationtool.model.enums.Income;
import lt.seb.productrecommendationtool.model.productform.ProductForm;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class ProductMapper {
    public static final Map<String, Predicate<ProductForm>> productRuleMap = new HashMap<>();

    private static final Predicate<ProductForm> isAdultPredicate = productForm -> productForm.getAge() == Age.ADULT || productForm.getAge() == Age.SENIOR;
    private static final Predicate<ProductForm> isSeniorPredicate = productForm -> productForm.getAge() == Age.SENIOR;
    private static final Predicate<ProductForm> noIncomePredicate = productForm -> productForm.getIncome() == Income.NONE;
    private static final Predicate<ProductForm> lowIncomePredicate = productForm -> productForm.getIncome() == Income.LOW;
    private static final Predicate<ProductForm> mediumIncomePredicate = productForm -> productForm.getIncome() == Income.MEDIUM;
    private static final Predicate<ProductForm> highIncomePredicate = productForm -> productForm.getIncome() == Income.HIGH;
    private static final Predicate<ProductForm> isStudentPredicate = ProductForm::isStudent;

    static {
        productRuleMap.put("Current Account", noIncomePredicate.and(isAdultPredicate));
        productRuleMap.put("Current Account Plus", highIncomePredicate.and(isAdultPredicate));
        productRuleMap.put("Junior Save Account", isAdultPredicate.negate());
        productRuleMap.put("Student Account", isStudentPredicate.and(isAdultPredicate));
        productRuleMap.put("Senior Account", isSeniorPredicate);
        productRuleMap.put("Debit Card", isAdultPredicate.and(noIncomePredicate.or(lowIncomePredicate)));
        productRuleMap.put("Credit Card", isAdultPredicate.and(mediumIncomePredicate.or(highIncomePredicate)));
        productRuleMap.put("Gold Credit Card", isAdultPredicate.and(highIncomePredicate));
    }
}
