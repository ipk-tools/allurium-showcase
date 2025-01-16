package selenide_style.widgets;

import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Accessors(fluent = true)
public class LeftSideCategoriesMenu {

    protected FoldingCategoriesBlock blockElements = new FoldingCategoriesBlock($(".element-group:nth-child(1)"));
    protected FoldingCategoriesBlock blockForms = new FoldingCategoriesBlock($(".element-group:nth-child(2)"));
    protected FoldingCategoriesBlock blockWidgets = new FoldingCategoriesBlock($(".element-group:nth-child(3)"));
}
