package allurium_style.pages;

import com.codeborne.selenide.SelenideElement;
import dm.tools.AbstractWidget;
import dm.tools.annotations.*;
import dm.tools.lists.ListWC;
import dm.tools.primitives.*;
import lombok.Getter;
import lombok.experimental.Accessors;
import selenide_style.pages.Page;

@PageObject
@Getter
@Accessors(fluent = true)
public class AccordionPage extends Page {

    @Name("Accordion categories")
    @ListLocator(css = "#accordion .card")
    protected ListWC<AccordionSection> accordionSections = new ListWC<>();

    @Widget
    @Getter
    @Accessors(fluent = true)
    public static class AccordionSection extends AbstractWidget {

        @Name("Chapter name")
        @LocatorChain(css = "h5 button")
        protected Title title;

        @Name("Chapter story")
        @LocatorChain(css = ".collapse")
        protected Text textContent;

        public AccordionSection(SelenideElement root) {
            super(root);
        }

        @Override
        public String getId() {
            return title.text();
        }
    }
}
