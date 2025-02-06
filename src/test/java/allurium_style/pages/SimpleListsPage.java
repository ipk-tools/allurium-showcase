package allurium_style.pages;

import allurium.annotations.ListLocator;
import allurium.annotations.Name;
import allurium.annotations.PageObject;
import allurium.inputs.TextField;
import allurium.lists.ListWC;
import allurium.primitives.Button;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;

@PageObject
@Getter
@Accessors(fluent = true)
public class SimpleListsPage extends Page {

    @Name("Input fields")
    protected ListWC<TextField> inputTextFields = new ListWC<>(By.xpath("//input[contains(@class, 'form-control')]"));

    @Name("Buttons bird names")
//    @ListLocator(css = ".mt-5 .btn-primary")
    protected ListWC<Button> listBirdNameButtons = new ListWC<>(By.cssSelector(".mt-5 .btn-primary"));
}
