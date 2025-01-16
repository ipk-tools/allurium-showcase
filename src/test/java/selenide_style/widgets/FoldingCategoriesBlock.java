package selenide_style.widgets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class FoldingCategoriesBlock {

    private SelenideElement root;
    private SelenideElement iconArrow;
    private ElementsCollection subcategories;

    public FoldingCategoriesBlock(SelenideElement rootElement) {
        this.root = rootElement;
        iconArrow = rootElement.$(".header-right svg");
        subcategories = rootElement.$$(".menu-list .btn");
    }
}
