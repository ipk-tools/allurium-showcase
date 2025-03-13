package allurium_style.pages;

import allurium.annotations.Name;
import allurium.annotations.PageObject;
import allurium_style.elements.Tabs;
import lombok.Getter;
import lombok.experimental.Accessors;

@PageObject
@Getter
@Accessors(fluent = true)
public class TabsPage {

    @Name("Custom tabs")
    protected Tabs tabs = new Tabs(".nav-tabs li");
}
