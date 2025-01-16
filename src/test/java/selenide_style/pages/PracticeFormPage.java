package selenide_style.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.experimental.Accessors;
import selenide_style.widgets.LeftSideCategoriesMenu;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
@Accessors(fluent = true)
public class PracticeFormPage extends Page {

    protected LeftSideCategoriesMenu leftSideCategoriesMenu = new LeftSideCategoriesMenu();
    protected SelenideElement firstNameField = $("#firstName").as("First name field").as("First name");
    protected SelenideElement lastNameField = $("#lastName").as("Last name");
    protected SelenideElement emailField = $("#userEmail").as("Email");
    protected SelenideElement maleRadioButton = $x("//input[@id='gender-radio-1']/..").as("Male radio button");
    protected SelenideElement femaleRadioButton = $x("//input[@id='gender-radio-2']/..").as("Female radio button");
    protected SelenideElement otherButton = $("#gender-radio-3").as("Other radio button");
    protected SelenideElement hobbiesMusic = $x("//input[@id='gender-radio-3']/..").as("Hobbies music checkbox");
    protected SelenideElement mobileField = $("#userNumber").as("Mobile");
    protected SelenideElement pictureUploadField = $("#uploadPicture").as("Upload picture");
    protected SelenideElement currentAddress = $("#currentAddress").as("Current address");
    protected SelenideElement submitButton = $("#submit").as("Submit button");
}
