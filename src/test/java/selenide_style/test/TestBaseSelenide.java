package selenide_style.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import selenide_style.pages.*;
import utils.CustomDriverProvider;

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

        Configuration.pageLoadTimeout = 30000;
        Configuration.timeout = 15000;
        boolean remote = true;

        if (remote) {
            System.setProperty("browserName", "chrome");
            System.setProperty("browserVersion", "latest");
            System.setProperty("remoteUrl", "http://192.168.19.109:8080/wd/hub");
            System.setProperty("width", "1920");
            System.setProperty("height", "1080");
            System.setProperty("headless", "false");
            System.setProperty("selenoid", "true");
            Configuration.browser = CustomDriverProvider.class.getName();
        } else {
            Configuration.browser = "chrome";
            WebDriverManager.chromedriver().setup();
            Configuration.browserSize = "1920x1080";
        }
        Selenide.open();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterAll
    protected static void afterAll() {
        WebDriverRunner.closeWebDriver();
    }
}
