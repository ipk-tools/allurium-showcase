package allurium_style.tests;

import allurium_style.pages.AccordionPage;
import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import allurium.AlluriumConfig;
import allurium.UiSteps;
import allurium.browser.BrowserActions;
import allurium.browser.BrowserSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.time.Duration;

@Epic("Allurium style")
public class ITExampleAlluriumTest extends TestBaseAllurium {

    // local pages url
    String homePageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/integration_test_template.html";
    String subFormPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/sub_form.html";
    String formPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/form.html";
    String listsPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/lists.html";
    String accordionPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/accordion.html";
    String listLocatorPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/list_locator_chain.html";
    String tablePageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/table.html";
    String dynamicTablePageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/table_dynamic.html";
    String iframePageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/iframe.html";
    String carouselPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/carousel.html";
    String switcherPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/switcherPage.html";
    String tabsPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/tabs.html";

    // remote pages url
//    String homePageUrl = "file:///home/selenium/Downloads/pages/integration_test_template.html";
//    String subFormPageUrl = "file:///home/selenium/Downloads/pages/sub_form.html";
//    String formPageUrl = "file:///home/selenium/Downloads/pages/form.html";
//    String listsPageUrl = "file:///home/selenium/Downloads/pages/lists.html";
//    String accordionPageUrl = "file:///home/selenium/Downloads/pages/accordion.html";
//    String listLocatorPageUrl = "file:///home/selenium/Downloads/pages/list_locator_chain.html";
//    String tablePageUrl = "file:///home/selenium/Downloads/pages/table.html";
//    String dynamicTablePageUrl = "file:///home/selenium/Downloads/pages/table_dynamic.html";
//    String iframePageUrl = "file:///home/selenium/Downloads/pages/iframe.html";
//    String carouselPageUrl = "file:///home/selenium/Downloads/pages/carousel.html";
//    String switcherPageUrl = "file:///home/selenium/Downloads/pages/switcherPage.html";

    @Test
    @Feature("Quick Start")
    @DisplayName("Subscription form submitting")
    public void quickStartSubForm() {
        UiSteps.openBrowser(subFormPageUrl);
        subscriptionPage.fieldEmail().write("john.doe@email.com");
        subscriptionPage.buttonSubmit().click();
        UiSteps.assertUrlPath("/success");
    }

    @Test
    @Feature("Multilevel top menu")
    @DisplayName("User explores  top multilevel menu")
    public void multiLevelMenuNavigation() {
        UiSteps.openBrowser(formPageUrl);
        formPage.topBar().mainItem4().hover();
        formPage.topBar().level1SubMenu().items().get("Level 1 Item 3").hover();
        formPage.topBar().level1SubMenu().level2SubMenu().items().get("Level 2 Item 3").hover();
        formPage.topBar().level1SubMenu().level2SubMenu().level3SubMenu().items().get("Level 3 Item 3").hover();
        formPage.topBar().level1SubMenu().level2SubMenu().level3SubMenu().level4SubMenu().items().get("Level 4 Item 3").hover();
        formPage.topBar().level1SubMenu().level2SubMenu().level3SubMenu().level4SubMenu().level5SubMenu().items().get("Level 5 Item 3").click();
    }

    @Test
    @Feature("Form")
    @DisplayName("Filling the example form")
    public void fillTheForm() {
        URL imageUrl = this.getClass().getClassLoader().getResource("img/testicon.png");
        UiSteps.openBrowser(formPageUrl);
        formPage.fieldLogin().assertVisible();
        formPage.fieldLogin().write("John");
        formPage.fieldLogin().assertHasCssClass("form-control");
        formPage.fieldLogin().assertCurrentValue("John");
        formPage.fieldEmail().clearAndWrite("john.doe@gmail.com");
        formPage.fieldEmail().assertCurrentValue("john.doe@gmail.com");
        formPage.fieldPassword().write("Password12345!");
        formPage.fieldRank().write("10");
        formPage.fieldDate().clearAndWrite("11.11.2011");
        formPage.fieldTelephone().write("199887688");
        formPage.btnAnnualIncomeIncrement().clickAndHold(5000);
        formPage.uploadAvatar().uploadFile(new File(imageUrl.getFile()));
        formPage.radioBtnMale().click();
        formPage.radioBtnMale().assertEnabled();
        formPage.radioBtnFemale().assertDisabled();
        formPage.ckbMorning().check();
        formPage.ckbMorning().assertChecked();
        formPage.ckbEvening().assertUnchecked();
        formPage.ddExperience().select("2 years");
        formPage.ddExperience().assertCurrentValue("2");
        formPage.selectWorkingDays().select("Monday");
        formPage.selectWorkingDays().select("Friday");
    }

    /*
    @Test
    @DisplayName("Practice form filling")
    public void fillPracticeForm() {
        URL imageUrl = this.getClass().getClassLoader().getResource("img/testicon.png");

        UiSteps.loadPage("https://demoqa.com/automation-practice-form");
        practiceFormPage.firstNameField().write("Traver");
        practiceFormPage.lastNameField().write("Gor");
        practiceFormPage.emailField().write("qa-main-email@wtf.com");
        practiceFormPage.maleRadioButton().click();
        practiceFormPage.mobileField().write("3575566999");
        practiceFormPage.hobbiesMusic().check();
        practiceFormPage.currentAddress().write("Far Far Away");
        practiceFormPage.pictureUploadField().uploadFile(new File(imageUrl.getFile()));
        practiceFormPage.submitButton().click();
    }
     */

    @Test
    @Feature("Simple elements list")
    @DisplayName("Walk through the lists of simple elements")
    public void fillListOfSimpleInputElements() {
        UiSteps.openBrowser(listsPageUrl);
        simpleListsPage.inputTextFields().get(0).write("Eagle");
        simpleListsPage.inputTextFields().get(1).write("Sparrow");
        simpleListsPage.inputTextFields().get(2).write("Parrot");
        simpleListsPage.inputTextFields().get(3).write("Penguin");
        simpleListsPage.inputTextFields().get(4).write("Owl");
        simpleListsPage.inputTextFields().get(5).write("Flamingo");
        simpleListsPage.inputTextFields().get(6).write("Peacock");
        simpleListsPage.inputTextFields().get(7).write("Hummingbird");
        simpleListsPage.inputTextFields().get(8).write("Woodpecker");
        simpleListsPage.inputTextFields().get(9).write("Crow");
        simpleListsPage.inputTextFields().get(5).assertCurrentValue("Flamingo");
        simpleListsPage.inputTextFields().get(7).assertCurrentValue("Hummingbird");
        simpleListsPage.listBirdNameButtons().get("Eagle").click();
        simpleListsPage.listBirdNameButtons().get("Sparrow").click();
        simpleListsPage.listBirdNameButtons().get("Parrot").click();
        simpleListsPage.listBirdNameButtons().get("Penguin").click();
        simpleListsPage.listBirdNameButtons().get("Owl").click();
        simpleListsPage.listBirdNameButtons().get("Flamingo").click();
        simpleListsPage.listBirdNameButtons().get("Peacock").click();
        simpleListsPage.listBirdNameButtons().get("Hummingbird").click();
        simpleListsPage.listBirdNameButtons().get("Woodpecker").click();
        simpleListsPage.listBirdNameButtons().get("Crow").click();
        simpleListsPage.listBirdNameButtons().filter(Condition.text("Sparrow")).first().click();
        simpleListsPage.listBirdNameButtons().assertHasItemsWithText("Eagle");
    }

    @Test
    @Feature("List of widgets")
    @DisplayName("Walk through accordion widget, asserting text patterns. All passed.")
    public void accordionPassedTest() {
        UiSteps.openBrowser(accordionPageUrl);
        accordionPage.accordionSections().get("Chapter 2").title().click();
        accordionPage.accordionSections().get("Chapter 3").title().click();
        accordionPage.accordionSections().get("Chapter 4").title().click();
        accordionPage.accordionSections().get("Chapter 5").title().click();
        accordionPage.accordionSections().get("Chapter 1").title().click();
        accordionPage.accordionSections().get("Chapter 1").textContent().assertHasText("Once upon a time");
        accordionPage.accordionSections().get("Chapter 2").title().click();
        accordionPage.accordionSections().get("Chapter 2").textContent().assertHasText("resided in the structured");
        accordionPage.accordionSections().get("Chapter 3").title().click();
        accordionPage.accordionSections().get("Chapter 3").textContent().assertHasText("As Ajax traveled");
        accordionPage.accordionSections().get("Chapter 4").title().click();
        accordionPage.accordionSections().get("Chapter 4").textContent().assertHasText("the art of dynamic typing");
        accordionPage.accordionSections().get("Chapter 5").title().click();
        accordionPage.accordionSections().get("Chapter 5").textContent().assertHasText("As Ajax returned to the City");
    }

    @Test
    @Feature("List of widgets")
    @DisplayName("Walk through accordion widget, asserting text patterns. Last one is failed.")
    public void accordionFailedTest() {
        String pageUrl = System.getProperty("user.dir")+"/src/test/resources/html/accordion.html";

        UiSteps.openBrowser(pageUrl);
        accordionPage.accordionSections().get("Chapter 2").title().click();
        accordionPage.accordionSections().get("Chapter 3").title().click();
        accordionPage.accordionSections().get("Chapter 4").title().click();
        accordionPage.accordionSections().get("Chapter 5").title().click();
        accordionPage.accordionSections().get("Chapter 1").title().click();
        accordionPage.accordionSections().get("Chapter 1").textContent().assertHasText("Once upon a time");
        accordionPage.accordionSections().get("Chapter 2").title().click();
        accordionPage.accordionSections().get("Chapter 2").textContent().assertHasText("resided in the structured");
        accordionPage.accordionSections().get("Chapter 3").title().click();
        accordionPage.accordionSections().get("Chapter 3").textContent().assertHasText("As Ajax traveled");
        accordionPage.accordionSections().get("Chapter 4").title().click();
        accordionPage.accordionSections().get("Chapter 4").textContent().assertHasText("the art of dynamic typing");
        accordionPage.accordionSections().get("Chapter 5").title().click();
        accordionPage.accordionSections().get("Chapter 5").textContent().assertHasText("As {Ajax} returned to the City");
    }

    @Test
    @DisplayName("Playing with categories folding menu")
    public void composeComponentListsWithChainedLocators() {
        UiSteps.openBrowser("https://demoqa.com/automation-practice-form");
        practiceFormPage.leftSideCategoriesMenu().blockElements().iconArrow().click();
        practiceFormPage.leftSideCategoriesMenu().blockElements().subcategories().get("Links").click();
        practiceFormPage.leftSideCategoriesMenu().blockElements().subcategories().get("Text Box").click();
        practiceFormPage.leftSideCategoriesMenu().blockForms().iconArrow().click();
        practiceFormPage.leftSideCategoriesMenu().blockForms().subcategories().get("Practice Form");
        practiceFormPage.leftSideCategoriesMenu().blockWidgets().iconArrow().click();
        practiceFormPage.leftSideCategoriesMenu().blockWidgets().subcategories().get("Slider").click();
        practiceFormPage.leftSideCategoriesMenu().blockWidgets().subcategories().get("Tabs").click();
    }

    @Test
    @DisplayName("Switching accordion sections and interacting with button lists")
    public void sectionsWithListsOfElements() {
        UiSteps.openBrowser(listLocatorPageUrl);
        formPage.leftBarLinks().get("List locator chain").click();
        listLocatorPage.sections().get("Section 2").sectionTitle().click();
        listLocatorPage.sections().get("Section 2").listOptions().get("3").click();
        listLocatorPage.sections().get("Section 3").sectionTitle().click();
        listLocatorPage.sections().get("Section 3").listOptions().get("Option 4").click();
        listLocatorPage.sections().get("Section 3").listOptions().get("Option 5").click();
        listLocatorPage.sections().get("Section 1").sectionTitle().click();
        listLocatorPage.sections().get("Section 1").listOptions().get("Option 1").click();
        listLocatorPage.sections().get("Section 1").listOptions().get("Option 2").click();
        listLocatorPage.sections().get("Section 1").listOptions().get("Option 5").contextClick();
        listLocatorPage.sections().get("Section 1").listOptions().get("Option 5").click();
        listLocatorPage.sections().get("Section 1").listOptions().get("Option 4").click();
    }

    @Test
    @DisplayName("Using ListWC to handle a table")
    public void tableExample() {
        UiSteps.openBrowser(tablePageUrl);
        webTablesPage.listEmployee().assertSize(9);
        webTablesPage.listEmployee().get("Vega").firstName().assertText("Cierra");
        webTablesPage.listEmployee().get("Cantrell").email().assertText("alden@example.com");
        webTablesPage.listEmployee().get("Gentry").btnActionHire().click();
        webTablesPage.listEmployee().get("Hogg").assertHasText("hogg@");
        webTablesPage.listEmployee().get("Hogg").btnActionHire().click();
        webTablesPage.listEmployee().get("Watkins").btnActionFire().click();
        webTablesPage.listEmployee().get("Howard").department().assertText("Development");
        webTablesPage.listEmployee().get("Spencer").btnActionHire().click();
    }

    @Test
    @DisplayName("Showcase ListWC interaction methods")
    public void dynamicListActionsShowcase() {
        UiSteps.openBrowser(dynamicTablePageUrl);
        dynamicEmployeesListPage.employees().assertSize(3);
        dynamicEmployeesListPage.btnAddEmployee().click();
        dynamicEmployeesListPage.employees().assertSizeGreaterThan(3);
        dynamicEmployeesListPage.employees().should(CollectionCondition.sizeGreaterThanOrEqual(4));
        dynamicEmployeesListPage.btnAddEmployee().click();
        dynamicEmployeesListPage.employees().assertSize(5);
        dynamicEmployeesListPage.employees().get("john.smith").btnDelete().click();
        dynamicEmployeesListPage.employees().assertSizeLessThan(5);
        dynamicEmployeesListPage.btnClearTable().click();
        dynamicEmployeesListPage.employees().assertEmpty();
        dynamicEmployeesListPage.employees().assertNotVisible();
        UiSteps.refreshCurrentPage();
        dynamicEmployeesListPage.employees().assertVisible();
        dynamicEmployeesListPage.employees().assertHasItem("jane.doe@example.com");
        dynamicEmployeesListPage.employees().assertHasNotItem("ng.doe@example.com");
        dynamicEmployeesListPage.employees().assertHasItemsWithText("Human Resources");
        dynamicEmployeesListPage.employees().assertHasNoItemsWithText("Inhuman Resources");
    }

    @Test
    @DisplayName("Showcase ListWC interaction methods, fails")
    public void dynamicListActionsFailedScenarioShowcase() {
        UiSteps.openBrowser(dynamicTablePageUrl);
        dynamicEmployeesListPage.employees().assertSize(3);
        dynamicEmployeesListPage.btnAddEmployee().click();
        dynamicEmployeesListPage.employees().assertSizeGreaterThan(3);
        dynamicEmployeesListPage.employees().should(CollectionCondition.sizeGreaterThan(5));
        dynamicEmployeesListPage.employees()
                .should(CollectionCondition.containExactTextsCaseSensitive("jane.doe@example.com"));
    }

    @Test
    @DisplayName("Using 'Iframe' class to easily work with iframe elements")
    public void iframeExample() {
        UiSteps.openBrowser(iframePageUrl);
        iframePage.fieldName().write("John");
        iframePage.fieldEmail().write("john.doe@email.com");
        iframePage.fieldPassword().write("hardAndLong");
        iframePage.btnSubmit().click();
        iframePage.iframeLoginForm().switchDriverToIframe();
        iframePage.iframeLoginForm().fieldName().write("framed-John");
        iframePage.iframeLoginForm().fieldEmail().write("framed-doe@email.com");
        iframePage.iframeLoginForm().fieldPassword().write("framed_hardAndLong");
        iframePage.iframeLoginForm().switchDriverBack();
        iframePage.fieldName().clearAndWrite("JDoe");
    }

    @Test
    @DisplayName("Create custom 'Required' text field")
    public void makeNewElementRequitedField() {
        UiSteps.openBrowser(formPageUrl);
        formPage.fieldEmail().write("john.doe@gmail.com");
        formPage.fieldPassword().write("Password12345!");
        formPage.fieldRank().write("10");
        formPage.fieldDate().clearAndWrite("11.11.2011");
        formPage.fieldTelephone().write("199887688");
        formPage.radioBtnMale().click();
        formPage.radioBtnMale().assertEnabled();
        formPage.radioBtnFemale().assertDisabled();
        formPage.ddExperience().select("2 years");
        formPage.btnSubmit().click();
        formPage.fieldLogin().assertMarkedAsRequired();
        formPage.fieldLogin().write("John");
        formPage.btnSubmit().click();
    }

    @Test
    @DisplayName("Simple carousel example")
    public void carouselExample() {
        UiSteps.openBrowser(carouselPageUrl);
        carouselPage.carousel().scrollForward();
        carouselPage.carousel().scrollBackward();
        carouselPage.carousel().scrollForward();
        carouselPage.carousel().scrollForward();
        carouselPage.carousel().scrollBackward();
    }

    @Test
    @DisplayName("Switcher (Toggle) example")
    public void switcherExample() {
        UiSteps.openBrowser(switcherPageUrl);
        switcherPage.classicToggleSwitcher().switchOn();
        switcherPage.classicToggleSwitcher().switchOff();
        switcherPage.classicToggleSwitcher().toggle();
        switcherPage.classicToggleSwitcher().switchOff();
        switcherPage.buttonToggle().switchOn();
        switcherPage.buttonToggle().switchOff();
        switcherPage.buttonToggle().toggle();
        switcherPage.buttonToggle().switchOff();
    }

    @Test
    @DisplayName("UiSteps showcase")
    public void uiSteps() {
        UiSteps.openBrowser(carouselPageUrl);
        UiSteps.loadPage(homePageUrl);
        UiSteps.loadPageAndWaitCompleteState(formPageUrl);
        UiSteps.assertUrlContains("/src/test");
        UiSteps.assertUrlPath("/src/test/resources/html/form.html");
        UiSteps.goBack();
        UiSteps.refreshCurrentPage();
        UiSteps.waiting(3, "few seconds until the page refreshed");
        UiSteps.goForward();
        UiSteps.pressEnter();
        UiSteps.pressEsc();
        UiSteps.scrollBottom();
        UiSteps.scrollTop();
        UiSteps.goBack();
        UiSteps.openNewBlankTab();
        UiSteps.switchToTab(0);
        UiSteps.switchToTab(1);
        UiSteps.openNewTabWithUrl("https://www.google.com/");
        UiSteps.pressArrowUp();
        UiSteps.pressArrowDown();
        UiSteps.pressArrowLeft();
        UiSteps.pressArrowRight();
        UiSteps.pressTab();
        UiSteps.assertUrl("https://www.google.com/");
        UiSteps.assertPageTitle("Google");
        UiSteps.assertPageTitleContains("Goog");
        UiSteps.switchToTab("The Topic");
        UiSteps.switchToTab("Google");
        UiSteps.setWindowSize(500, 500);
        UiSteps.maximize();
    }

    @Test
    @DisplayName("Browser steps showcase")
    public void browserSteps() {
        UiSteps.openBrowser("https://www.google.com/");
        // manage cookies
        BrowserSteps.addCookie("session", "9999999");
        BrowserSteps.addCookie("user", "444888");
        BrowserSteps.assertCookiePresent("session");
        BrowserSteps.assertCookieValue("user", "444888");
        BrowserSteps.deleteCookie("user");
        BrowserSteps.assertCookieAbsent("user");
        BrowserSteps.deleteAllCookies();
        BrowserSteps.assertCookieAbsent("session");
        // manage local storage
        BrowserSteps.addValueToLocalStorage("mode", "dev");
        BrowserSteps.assertLocalStorageValue("mode", "dev");
        BrowserSteps.updateValueInLocalStorage("mode", "prod");
        BrowserSteps.assertLocalStorageValue("mode", "prod");
        BrowserSteps.deleteValueFromLocalStorage("mode");
        BrowserSteps.assertLocalStorageValueAbsent("mode");
        BrowserSteps.addValueToLocalStorage("key1", "1");
        BrowserSteps.addValueToLocalStorage("key2", "2");
        BrowserSteps.addValueToLocalStorage("key3", "3");
        BrowserSteps.clearLocalStorage();
        BrowserSteps.assertLocalStorageIsBlank();
        // Manipulations with DOM
        UiSteps.loadPage(homePageUrl);
        homePage.searchBlock().fieldSearchQuery().assertVisible();
        BrowserActions.removeElement(homePage.searchBlock().fieldSearchQuery());
        homePage.searchBlock().fieldSearchQuery().assertNotVisible();
    }

    @Test
    @DisplayName("Steps detailing example")
    public void stepsDetailingExample() {
        System.out.println(AlluriumConfig.stepDetailing() + ">>>>>>>");
        UiSteps.openBrowser(homePageUrl);
        homePage.navBar().linkPhotos().click();
        homePage.searchBlock().selectImageType().select("Sticker");
        homePage.searchBlock().fieldSearchQuery().write("nature");
        homePage.searchBlock().btnSearch().click();
        homePage.galleryBlock().topicName().assertText("The Topic");
        homePage.galleryBlock().listGallery().assertSize(9);
        homePage.galleryBlock().btnNext().click();
        homePage.footer().linkPolicy().click();
        homePage.footer().aboutUs().assertHasText("beautiful nature images");
    }

    @Test
    @DisplayName("Filtration examples")
    public void listFiltering() {
        UiSteps.openBrowser(accordionPageUrl);
        AccordionPage.AccordionSection accordionSection = accordionPage.accordionSections().filter(Condition.text("Chapter 2")).get(0);
        accordionSection.title().click();
        accordionPage.accordionSections().filter(Condition.visible).assertSize(5);
        accordionPage.accordionSections().filter(Condition.cssClass("card")).assertSize(5);
        accordionPage.accordionSections().filter(Condition.name("some")).assertSize(0);
        accordionPage.accordionSections()
                .filter(Condition.visible)
                .filter(Condition.cssClass("card"))
                .filter(Condition.text("Chapter 2"))
                .assertSize(1);
    }

    @Test
    @DisplayName("Specific actions showcase")
    public void specificRareActions() {
        UiSteps.openBrowser(homePageUrl);
        homePage.navBar().linkPhotos().click(ClickOptions.usingJavaScript());
        homePage.navBar().linkPhotos().click(ClickOptions.withOffset(200, 200));
        homePage.navBar().linkPhotos().click(ClickOptions.withTimeout(Duration.ofSeconds(3)));
        homePage.navBar().linkPhotos().click(false);
        homePage.navBar().linkPhotos().click("My CUSTOM click step!");

        homePage.searchBlock().btnSearch().hover();
        homePage.searchBlock().btnSearch().hover(false);
        homePage.searchBlock().btnSearch().hover("My CUSTOM hover step!");

        homePage.galleryBlock().listGallery().get(0).contextClick();
        homePage.galleryBlock().listGallery().get(0).contextClick(false);
        homePage.galleryBlock().listGallery().get(0).contextClick("My CUSTOM context click step!");

        homePage.footer().aboutUs().scrollTo();
        homePage.footer().aboutUs().scrollTo(false);
        homePage.footer().aboutUs().scrollTo("My CUSTOM scroll to step!");
    }

    @Test
    @DisplayName("Tabs widget example")
    public void tabsWidgetExample() {
        UiSteps.openBrowser(tabsPageUrl);
        tabsPage.tabs().select("Contact");
        tabsPage.tabs().select("Profile");
        tabsPage.tabs().select("Home");
        tabsPage.tabs().select("Contact");
        tabsPage.tabs().select("Profile");
        tabsPage.tabs().select("Home");
        tabsPage.tabs().select("Contact");
        tabsPage.tabs().select("Profile");
        tabsPage.tabs().select("Home");
        tabsPage.tabs().select("Contact");
        tabsPage.tabs().select("Profile");
        tabsPage.tabs().select("Home");
        tabsPage.tabs().select("Contact");
        tabsPage.tabs().select("Profile");
        tabsPage.tabs().select("Home");
    }

}
