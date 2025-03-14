package allurium_style.tests;

import allurium_style.pages.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import utils.CustomDriverProvider;

public class TestBaseAllurium {

    protected HomePage homePage = new HomePage();
    protected SubscriptionPage subscriptionPage = new SubscriptionPage();
    protected PracticeFormPage practiceFormPage = new PracticeFormPage();
    protected FormPage formPage = new FormPage();
    protected AccordionPage accordionPage = new AccordionPage();
    protected WebTablesPage webTablesPage = new WebTablesPage();
    protected DynamicEmployeesListPage dynamicEmployeesListPage = new DynamicEmployeesListPage();
    protected SimpleListsPage simpleListsPage = new SimpleListsPage();
    protected ListLocatorPage listLocatorPage = new ListLocatorPage();
    protected IframePage iframePage = new IframePage();
    protected CarouselPage carouselPage = new CarouselPage();
    protected SwitcherPage switcherPage = new SwitcherPage();
    protected TabsPage tabsPage = new TabsPage();


    @BeforeAll
    protected static void beforeAll() {
        boolean remote = false;

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
