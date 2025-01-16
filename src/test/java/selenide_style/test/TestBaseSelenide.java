package selenide_style.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import dm.tools.UiSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import selenide_style.pages.*;

import java.net.URL;

public class TestBaseSelenide {

    URL resourceUrl = getClass().getResource("/yourFileName.html");
    protected PracticeFormPage practiceFormPage = new PracticeFormPage();
    protected FormPage formPage = new FormPage();
    protected AccordionPage accordionPage = new AccordionPage();
    protected ListsPage listsPage = new ListsPage();
    protected WebTablesPage webTablesPage = new WebTablesPage();
    protected SimpleListPage simpleListPage = new SimpleListPage();
    protected IframePage iframePage = new IframePage();

    protected ListLocatorPage listLocatorPage = new ListLocatorPage();

    @BeforeAll
    protected static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));

        Configuration.browser = "chrome";
        Configuration.pageLoadTimeout = 30000;
        Configuration.timeout = 15000;
        WebDriverManager.chromedriver().setup();
        UiSteps.openBrowser();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    protected void open(String htmlName) {
        UiSteps.loadPage(resourceUrl + htmlName);
    }

    @AfterAll
    protected static void afterAll() {
        WebDriverRunner.closeWebDriver();
    }
}
