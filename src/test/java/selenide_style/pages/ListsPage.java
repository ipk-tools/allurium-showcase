package selenide_style.pages;

import dm.tools.annotations.Name;
import dm.tools.annotations.PageObject;
import dm.tools.lists.ListWC;
import dm.tools.primitives.ListItem;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;

@PageObject
@Getter
@Accessors(fluent = true)
public class ListsPage {

    @Name("Inputs")
    protected ListWC<ListItem> inputs = new ListWC<>(By.cssSelector(".form-group input"));

}
