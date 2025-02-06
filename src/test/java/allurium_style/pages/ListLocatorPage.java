package allurium_style.pages;

import com.codeborne.selenide.SelenideElement;
import allurium.AbstractWidget;
import allurium.annotations.*;
import allurium.lists.ListWC;
import allurium.primitives.Button;
import allurium.primitives.Link;
import allurium.primitives.Title;
import lombok.Getter;
import lombok.experimental.Accessors;

@PageObject
@Getter
@Accessors(fluent = true)
public class ListLocatorPage {

    @Name("Sections")
    @ListLocator(css = "#accordion .card")
    protected ListWC<Section> sections = new ListWC<>();


    @Widget
    @Getter
    @Accessors(fluent = true)
    public static class Section extends AbstractWidget {

        @LocatorChain(css = ".card-header button")
        protected Title sectionTitle;

        @Name("Options")
        @ListLocatorChain(css = ".card-body .btn") // @ListLocatorChain(xpath="//div[@class='card-body']/button")
        protected ListWC<Button> listOptions = new ListWC<>();

        public Section(SelenideElement root) {
            super(root);
        }

        @Override
        public String getId() {
            return sectionTitle.text();
        }
    }
}
