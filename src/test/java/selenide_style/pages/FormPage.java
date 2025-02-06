package selenide_style.pages;

import com.codeborne.selenide.SelenideElement;
import allurium.annotations.PageObject;
import lombok.Getter;
import lombok.experimental.Accessors;
import selenide_style.widgets.TopBar;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@PageObject
@Getter
@Accessors(fluent = true)
public class FormPage extends Page {

    protected TopBar topBar = new TopBar();
    protected SelenideElement fieldLogin = $("#login").as("Textfield Login");
    protected SelenideElement fieldEmail = $("#email").as("Textfield Email");
    protected SelenideElement fieldPassword = $("#password").as("Textfield Password");
    protected SelenideElement fieldRank = $("#rank").as("Textfield rank");
    protected SelenideElement fieldDate = $x("//input[@id='date']").as("Textfield Date");
    protected SelenideElement fieldTelephone = $("#tel").as("Textfield Telephone");
    protected SelenideElement uploadAvatar = $("#file").as("File input Avatar");
    protected SelenideElement radioBtnMale = $("#male").as("Radiobutton Gender Male");
    protected SelenideElement radioBtnFemale = $("#female").as("Radiobutton Gender Female");
    protected SelenideElement ckbMorning = $("#checkbox1").as("Checkbox Preferable time - Morning");
    protected SelenideElement ckbEvening = $("#checkbox2").as("Checkbox Preferable time - Evening");
    protected SelenideElement ddExperience = $("#experience").as("Dropdown list Experience");
    protected SelenideElement selectWorkingDays = $("#multiple-select").as("Select Working Days");
    protected SelenideElement btnReset = $(".btn-secondary").as("Button Reset");
    protected SelenideElement btnSubmit = $(".btn-primary").as("Button Submit");
}
