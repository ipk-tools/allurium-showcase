package allurium_style.pages;

import allurium.annotations.Locator;
import allurium.annotations.Name;
import allurium.annotations.PageObject;
import allurium.inputs.*;
import allurium.primitives.Button;
import lombok.Getter;
import lombok.experimental.Accessors;
import allurium_style.widgets.LeftSideCategoriesMenu;

@PageObject
@Getter
@Accessors(fluent = true)
public class PracticeFormPage extends Page {

    @Name("Left Categories menu")
    protected LeftSideCategoriesMenu leftSideCategoriesMenu = new LeftSideCategoriesMenu();

    @Name("First name")
    @Locator(css = "#firstName")
    protected TextField firstNameField;

    @Name("Surname")
    @Locator(css = "#lastName")
    protected TextField lastNameField;

    @Name("Email")
    @Locator(css = "#userEmail")
    protected TextField emailField;

    @Name("Male")
    @Locator(xpath = "//input[@id='gender-radio-1']/..")
    protected RadioButton maleRadioButton;

    @Name("Female")
    @Locator(xpath = "//input[@id='gender-radio-2']/..")
    protected RadioButton femaleRadioButton;

    @Name("Music")
    @Locator(xpath = "//input[@id='gender-radio-3']/..")
    protected CheckBox hobbiesMusic;

    @Name("Other")
    @Locator(css = "#gender-radio-3")
    protected RadioButton otherButton;

    @Name("Mobile")
    @Locator(css = "#userNumber")
    protected TextField mobileField;

    @Name("Picture")
    @Locator(css = "#uploadPicture")
    protected UploadField pictureUploadField;

    @Name("Current Address")
    @Locator(css = "#currentAddress")
    protected TextArea currentAddress;

    @Name("Sumbit")
    @Locator(css = "#submit")
    protected Button submitButton;
}
