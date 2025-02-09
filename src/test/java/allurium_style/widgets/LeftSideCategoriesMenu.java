package allurium_style.widgets;

import allurium.AbstractWidget;
import allurium.annotations.Locator;
import allurium.annotations.Name;
import allurium.annotations.Widget;
import lombok.Getter;
import lombok.experimental.Accessors;

@Widget
@Getter
@Accessors(fluent = true)
public class LeftSideCategoriesMenu extends AbstractWidget {

    @Name("Elements Block")
    @Locator(css = ".element-group:nth-child(1)")
    protected FoldingCategoriesBlock blockElements = new FoldingCategoriesBlock();

    @Name("Forms Block")
    @Locator(css = ".element-group:nth-child(2)")
    protected FoldingCategoriesBlock blockForms = new FoldingCategoriesBlock();

    @Name("Widgets Block")
    @Locator(css = ".element-group:nth-child(4)")
    protected FoldingCategoriesBlock blockWidgets = new FoldingCategoriesBlock();
}
