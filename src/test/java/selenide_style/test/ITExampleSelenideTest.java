package selenide_style.test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;

@Epic("Selenide style")
public class ITExampleSelenideTest extends TestBaseSelenide {

    String formPageUrl = System.getProperty("user.dir")+"/src/test/resources/html/form.html";
    String listsPageUrl = System.getProperty("user.dir")+"/src/test/resources/html/lists.html";
    String accordionPageUrl = System.getProperty("user.dir")+"/src/test/resources/html/accordion.html";
    String listLocatorPageUrl = System.getProperty("user.dir")+"/src/test/resources/html/list_locator_chain.html";
    String tablePageUrl = System.getProperty("user.dir")+"/src/test/resources/html/table.html";
    String iframePageUrl = System.getProperty("user.dir")+"/src/test/resources/html/iframe.html";

    @Test
    @Feature("Multilevel top menu")
    @DisplayName("User explores  top multilevel menu")
    public void multiLevelMenuNavigation() {
        Selenide.open(formPageUrl);
        formPage.topBar().mainItem4().hover();
        formPage.topBar().level1SubMenu().items().filter(Condition.text("Level 1 Item 3")).first().hover();
        formPage.topBar().level1SubMenu().level2SubMenu().items().filter(Condition.text("Level 2 Item 3")).first().hover();
        formPage.topBar()
                .level1SubMenu()
                .level2SubMenu()
                .level3SubMenu()
                .items().filter(Condition.text("Level 3 Item 3")).first().hover();
        formPage.topBar()
                .level1SubMenu()
                .level2SubMenu()
                .level3SubMenu()
                .level4SubMenu()
                .items().filter(Condition.text("Level 4 Item 3")).first().hover();
        formPage.topBar()
                .level1SubMenu()
                .level2SubMenu()
                .level3SubMenu()
                .level4SubMenu()
                .level5SubMenu()
                .items().filter(Condition.text("Level 5 Item 3")).first().hover();
    }

    @Test
    @Feature("Form")
    @DisplayName("Filling the example form")
    protected void fillTheForm() {
        URL imageUrl = this.getClass().getClassLoader().getResource("img/testicon.png");

        Selenide.open(formPageUrl);
        formPage.fieldLogin().shouldBe(Condition.visible);
        formPage.fieldLogin().sendKeys("John");
        formPage.fieldLogin().shouldHave(Condition.cssClass("form-control"));
        formPage.fieldLogin().shouldHave(Condition.value("John"));
        formPage.fieldEmail().sendKeys("john.doe@gmail.com");
        formPage.fieldEmail().shouldHave(Condition.value("john.doe@gmail.com"));
        formPage.fieldPassword().sendKeys("Password12345!");
        formPage.fieldRank().sendKeys("10");
        formPage.fieldDate().sendKeys("11.11.2011");
        formPage.fieldTelephone().sendKeys("199887688");
        formPage.uploadAvatar().uploadFile(new File(imageUrl.getFile()));
        formPage.radioBtnMale().click();
        formPage.radioBtnMale().shouldBe(Condition.enabled);
        formPage.radioBtnFemale().shouldBe(Condition.disabled);
        formPage.ckbMorning().click();
        formPage.ckbMorning().shouldBe(Condition.checked);
        formPage.ckbEvening().shouldNotBe(Condition.checked);
        formPage.ddExperience().selectOption("2 years");
        formPage.selectWorkingDays().selectOption("Monday", "Friday");
        formPage.btnSubmit().click();
    }

    @Test
    @DisplayName("Practice form filling")
    public void fillPracticeForm() {
        URL imageUrl = this.getClass().getClassLoader().getResource("img/testicon.png");

        Selenide.open("https://demoqa.com/automation-practice-form");
        practiceFormPage.btnConsent().click();
        practiceFormPage.firstNameField().sendKeys("Traver");
        practiceFormPage.lastNameField().sendKeys("Gor");
        practiceFormPage.emailField().sendKeys("qa-main-email@wtf.com");
        practiceFormPage.maleRadioButton().click();
        practiceFormPage.mobileField().sendKeys("3575566999");
        practiceFormPage.hobbiesMusic().click();
        practiceFormPage.currentAddress().sendKeys("Far Far Away");
        practiceFormPage.pictureUploadField().sendKeys(new File(imageUrl.getFile()).getAbsolutePath());
        practiceFormPage.submitButton().click();
    }

    @Test
    @Feature("Simple elements list")
    @DisplayName("Walk through the lists of simple elements")
    public void fillListOfSimpleInputElements() {
        Selenide.open(listsPageUrl);
        simpleListPage.inputTextFields().get(0).sendKeys("Eagle");
        simpleListPage.inputTextFields().get(1).sendKeys("Sparrow");
        simpleListPage.inputTextFields().get(2).sendKeys("Parrot");
        simpleListPage.inputTextFields().get(3).sendKeys("Penguin");
        simpleListPage.inputTextFields().get(4).sendKeys("Owl");
        simpleListPage.inputTextFields().get(5).sendKeys("Flamingo");
        simpleListPage.inputTextFields().get(6).sendKeys("Peacock");
        simpleListPage.inputTextFields().get(7).sendKeys("Hummingbird");
        simpleListPage.inputTextFields().get(8).sendKeys("Woodpecker");
        simpleListPage.inputTextFields().get(9).sendKeys("Crow");
        Assertions.assertThat(simpleListPage.inputTextFields().get(5).getAttribute("value"))
                .as("Input 5 value").isEqualTo("Flamingo");
        Assertions.assertThat(simpleListPage.inputTextFields().get(7).getAttribute("value"))
                .as("Input 7 value").isEqualTo("Hummingbird");
        simpleListPage.listBirdNameButtons().filter(Condition.text("Eagle")).first().click();
        simpleListPage.listBirdNameButtons().filter(Condition.text("Sparrow")).first().click();
        simpleListPage.listBirdNameButtons().filter(Condition.text("Parrot")).first().click();
        simpleListPage.listBirdNameButtons().filter(Condition.text("Penguin")).first().click();
        simpleListPage.listBirdNameButtons().filter(Condition.text("Owl")).first().click();
        simpleListPage.listBirdNameButtons().filter(Condition.text("Flamingo")).first().click();
        simpleListPage.listBirdNameButtons().filter(Condition.text("Peacock")).first().click();
        simpleListPage.listBirdNameButtons().filter(Condition.text("Hummingbird")).first().click();
        simpleListPage.listBirdNameButtons().filter(Condition.text("Woodpecker")).first().click();
        simpleListPage.listBirdNameButtons().filter(Condition.text("Crow")).first().click();
        simpleListPage.listBirdNameButtons().filter(Condition.text("Eagle")).shouldBe(CollectionCondition.sizeGreaterThan(0));
        simpleListPage.listBirdNameButtons().shouldHave(CollectionCondition.itemWithText("Eagle"));
    }

    @Test
    @Feature("List of widgets")
    @DisplayName("Walk through accordion widget, asserting text patterns. All passed.")
    public void accordionPassedTest() {
        Selenide.open(accordionPageUrl);
        accordionPage.clickOnSectionLabel("Chapter 2");
        accordionPage.clickOnSectionLabel("Chapter 3");
        accordionPage.clickOnSectionLabel("Chapter 4");
        accordionPage.clickOnSectionLabel("Chapter 5");
        accordionPage.clickOnSectionLabel("Chapter 1");
        accordionPage.assertTextHas("Chapter 1", "Once upon a time");
        accordionPage.clickOnSectionLabel("Chapter 2");
        accordionPage.assertTextHas("Chapter 2", "resided in the structured");
        accordionPage.clickOnSectionLabel("Chapter 3");
        accordionPage.assertTextHas("Chapter 3", "As Ajax traveled");
        accordionPage.clickOnSectionLabel("Chapter 4");
        accordionPage.assertTextHas("Chapter 4", "the art of dynamic typing");
        accordionPage.clickOnSectionLabel("Chapter 5");
        accordionPage.assertTextHas("Chapter 5", "As Ajax returned to the City");
        accordionPage.clickOnSectionLabel("Chapter 1");
    }

    @Test
    @Feature("List of widgets")
    @DisplayName("Walk through accordion widget, asserting text patterns. Last one is failed.")
    public void accordionFailedTest() {
        Selenide.open(accordionPageUrl);
        accordionPage.clickOnSectionLabel("Chapter 2");
        accordionPage.clickOnSectionLabel("Chapter 3");
        accordionPage.clickOnSectionLabel("Chapter 4");
        accordionPage.clickOnSectionLabel("Chapter 5");
        accordionPage.clickOnSectionLabel("Chapter 1");
        accordionPage.assertTextHas("Chapter 1", "Once upon a time");
        accordionPage.clickOnSectionLabel("Chapter 2");
        accordionPage.assertTextHas("Chapter 2", "resided in the structured");
        accordionPage.clickOnSectionLabel("Chapter 3");
        accordionPage.assertTextHas("Chapter 3", "As Ajax traveled");
        accordionPage.clickOnSectionLabel("Chapter 4");
        accordionPage.assertTextHas("Chapter 4", "the art of dynamic typing");
        accordionPage.clickOnSectionLabel("Chapter 5");
        accordionPage.assertTextHas("Chapter 5", "As {Ajax} returned to the City");
        accordionPage.clickOnSectionLabel("Chapter 1");
    }

    @Test
    @DisplayName("Playing with categories folding menu")
    public void composeComponentListsWithChainedLocators() {}

    @Test
    @DisplayName("Switching accordion sections and ")
    public void sectionsWithListsOfElements() {
        Selenide.open(formPageUrl);
        formPage.leftBarLinks().filter(Condition.text("List locator chain")).first().click();
        listLocatorPage.clickSection("Section 2");
        listLocatorPage.selectOption("Section 2", "Option 3");
        listLocatorPage.clickSection("Section 3");
        listLocatorPage.selectOption("Section 3", "Option 4");
        listLocatorPage.selectOption("Section 3", "Option 5");
        listLocatorPage.clickSection("Section 1");
        listLocatorPage.selectOption("Section 1", "Option 1");
        listLocatorPage.selectOption("Section 1", "Option 2");
        listLocatorPage.contextClickOption("Section 1", "Option 5");
        listLocatorPage.selectOption("Section 1", "Option 4");
    }

    @Test
    @DisplayName("Using ListWC to handle a table")
    public void tableExample() {
        Selenide.open(tablePageUrl);
        webTablesPage.assertEmployeeWithSurnameHasCertainName("Vega", "Cierra");
        webTablesPage.assertEmailOfEmployeeWithCertainSurname("Cantrell", "alden@example.com");
        webTablesPage.hireBySurname("Gentry");
        webTablesPage.assertEmployeeHasEmailWithText("Hogg", "hogg@");
        webTablesPage.hireBySurname("Hogg");
        webTablesPage.fireBySurname("Watkins");
        webTablesPage.assertDepartmentOfEmployee("Howard", "Development");
        webTablesPage.hireBySurname("Spencer");
    }

    @Test
    @DisplayName("Working with elements in an Iframe")
    public void iframeExample() {
        Selenide.open(iframePageUrl);
        iframePage.fieldName().sendKeys("John");
        iframePage.fieldEmail().sendKeys("john.doe@email.com");
        iframePage.fieldPassword().sendKeys("hardAndLong");
        WebDriverRunner.getWebDriver().switchTo().frame($("#iframe_root"));
        iframePage.iframeLoginForm().fieldName().sendKeys("framed-John");
        iframePage.iframeLoginForm().fieldEmail().sendKeys("framed-doe@email.com");
        iframePage.iframeLoginForm().fieldPassword().sendKeys("framed_hardAndLong");
        WebDriverRunner.getWebDriver().switchTo().defaultContent();
        iframePage.fieldName().clear();
        iframePage.fieldName().sendKeys("JDoe");
    }

}
