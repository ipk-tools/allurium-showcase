package selenide_style.pages;

import allurium.annotations.Name;
import allurium.annotations.PageObject;
import allurium.lists.ListWC;
import allurium.primitives.ListItem;
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
