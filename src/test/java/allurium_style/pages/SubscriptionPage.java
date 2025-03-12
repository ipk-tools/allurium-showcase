package allurium_style.pages;

import allurium.annotations.Locator;
import allurium.annotations.Name;
import allurium.annotations.PageObject;
import allurium.inputs.TextField;
import allurium.primitives.Button;
import lombok.Getter;
import lombok.experimental.Accessors;

@PageObject
@Getter
@Accessors(fluent = true)
public class SubscriptionPage {

    @Name("Email")
    @Locator(css = "#email")
    private TextField fieldEmail;

    @Name("Submit")
    @Locator(xpath = "//button")
    private Button buttonSubmit;
}
