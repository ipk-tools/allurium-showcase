package allurium_style.pages;

import allurium_style.elements.ReqTextField;
import allurium_style.widgets.TopBar;
import allurium.annotations.Locator;
import allurium.annotations.Name;
import allurium.annotations.PageObject;
import allurium.inputs.*;
import allurium.primitives.Button;
import lombok.Getter;
import lombok.experimental.Accessors;

import static allurium.inputs.TextField.$textField;
import static allurium.inputs.TextField._$textField;

@PageObject
@Getter
@Accessors(fluent = true)
public class FormPage extends Page {

    @Name("Top Bar")
    protected TopBar topBar = new TopBar();

    @Name("Login")
    protected ReqTextField fieldLogin = new ReqTextField("#login");

//    @Name("Login")
//    protected TextField fieldLogin = new TextField("#login");

    @Name("Email")
    @Locator(css = "#email")
    protected TextField fieldEmail;

    @Name("Password")
    @Locator(css = "#password")
    protected TextField fieldPassword;

    @Name("Rank")
    protected TextField fieldRank = $textField("#rank");

    @Name("Date")
    protected TextField fieldDate = _$textField("//input[@id='date']");

    @Name("Telephone")
    @Locator(css = "#tel")
    protected TextField fieldTelephone;

    @Name("Annual income increment")
    @Locator(css = "#increment-button")
    protected Button btnAnnualIncomeIncrement;

    @Name("Avatar")
    @Locator(css = "#file")
    protected UploadField uploadAvatar;

    @Name("Gender Male")
    @Locator(css = "#male")
    protected RadioButton radioBtnMale;

    @Name("Gender Female")
    @Locator(css = "#female")
    protected RadioButton radioBtnFemale;

    @Name("Preferable time - Morning")
    @Locator(css = "#checkbox1")
    protected CheckBox ckbMorning;

    @Name("Preferable time - Evening")
    @Locator(css = "#checkbox2")
    protected CheckBox ckbEvening;

    @Name("Experience")
    @Locator(css = "#experience")
    protected DropdownSelect ddExperience;

    @Name("Working Days")
//    @Locator(css = "#multiple-select")
    protected Select selectWorkingDays = Select.$select("#multiple-select");

    @Name("Reset")
    @Locator(css = ".btn-secondary")
    protected Button btnReset;

    @Name("Submit")
    @Locator(css = ".btn-primary")
    protected Button btnSubmit;
}
