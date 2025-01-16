package allurium_style.tests;

import allurium_style.pages.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import dm.tools.UiSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.*;

public class TestBaseAllurium {

    protected HomePage homePage = new HomePage();
    protected PracticeFormPage practiceFormPage = new PracticeFormPage();
    protected FormPage formPage = new FormPage();
    protected AccordionPage accordionPage = new AccordionPage();
    protected WebTablesPage webTablesPage = new WebTablesPage();
    protected DynamicEmployeesListPage dynamicEmployeesListPage = new DynamicEmployeesListPage();
    protected SimpleListsPage simpleListsPage = new SimpleListsPage();
    protected ListLocatorPage listLocatorPage = new ListLocatorPage();
    protected IframePage iframePage = new IframePage();
    protected CarouselPage carouselPage = new CarouselPage();


    @BeforeAll
    protected static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.pageLoadTimeout = 30000;
        Configuration.timeout = 15000;
        WebDriverManager.chromedriver().setup();
        UiSteps.openBrowser();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterAll
    protected static void afterAll() {
        WebDriverRunner.closeWebDriver();
    }



    @BeforeSuite
    protected void beforeTest() {
        Configuration.browser = "chrome";
        Configuration.pageLoadTimeout = 30000;
        Configuration.timeout = 15000;
        WebDriverManager.chromedriver().setup();
        UiSteps.openBrowser();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @BeforeMethod
    @Step("Test case preparation")
    protected void beforeMethod() {}

    @AfterMethod
    @Step("Finishing test case")
    protected void afterMethod() {}

    @BeforeSuite
    protected void afterTest() {
        WebDriverRunner.closeWebDriver();
    }



}
