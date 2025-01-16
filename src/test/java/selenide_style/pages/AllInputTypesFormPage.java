package selenide_style.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AllInputTypesFormPage {

    // Input elements
    public SelenideElement textInput = $(By.id("text"));
    public SelenideElement emailInput = $(By.id("email"));
    public SelenideElement passwordInput = $(By.id("password"));
    public SelenideElement numberInput = $(By.id("number"));
    public SelenideElement dateInput = $(By.id("date"));
    public SelenideElement datetimeLocalInput = $(By.id("datetime-local"));
    public SelenideElement monthInput = $(By.id("month"));
    public SelenideElement timeInput = $(By.id("time"));
    public SelenideElement weekInput = $(By.id("week"));
    public SelenideElement colorInput = $(By.id("color"));
    public SelenideElement searchInput = $(By.id("search"));
    public SelenideElement telInput = $(By.id("tel"));
    public SelenideElement urlInput = $(By.id("url"));
    public SelenideElement rangeInput = $(By.id("range"));
    public SelenideElement fileInput = $(By.id("file"));

    // Radio buttons
    public SelenideElement radioOption1 = $(By.id("radio1"));
    public SelenideElement radioOption2 = $(By.id("radio2"));

    // Checkboxes
    public SelenideElement checkbox1 = $(By.id("checkbox1"));
    public SelenideElement checkbox2 = $(By.id("checkbox2"));

    // Select elements
    public SelenideElement standardSelect = $(By.id("standard-select"));
    public SelenideElement multipleSelect = $(By.id("multiple-select"));
    public SelenideElement groupedSelect = $(By.id("optgroup-select"));

    // Buttons
    public SelenideElement resetButton = $("button[type='reset']");
    public SelenideElement submitButton = $("button[type='submit']");
}
