package utils;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static utils.PropertyLoader.loadSystemPropertyOrDefault;

@Slf4j
public class CustomDriverProvider implements WebDriverProvider {
    public final static String MOBILE_DRIVER = "chrome_mobile";
    public final static String BROWSER = "browserName";
    public final static String REMOTE_URL = "remoteUrl";
    public final static String HEADLESS = "headless";
    public final static String WINDOW_WIDTH = "width";
    public final static String WINDOW_HEIGHT = "height";
    public final static String VERSION_LATEST = "latest";
    public final static String SELENOID = "selenoid";
    public final static Boolean ENABLE_VIDEO = false;
    private final static String SELENOID_SESSION_NAME = "selenoidSessionName";
    public final static int DEFAULT_WIDTH = 1920;
    public final static int DEFAULT_HEIGHT = 1080;

    private String[] options = loadSystemPropertyOrDefault("options", "").split(" ");


    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        Configuration.browserSize = String.format("%sx%s", loadSystemPropertyOrDefault(WINDOW_WIDTH, DEFAULT_WIDTH),
                loadSystemPropertyOrDefault(WINDOW_HEIGHT, DEFAULT_HEIGHT));
        String expectedBrowser = loadSystemPropertyOrDefault(BROWSER, Browsers.CHROME);
        String remoteUrl = loadSystemPropertyOrDefault(REMOTE_URL, "");
        Boolean isSelenoidRun = loadSystemPropertyOrDefault(SELENOID, false);


        log.info("remoteUrl=" + remoteUrl + " expectedBrowser= " + expectedBrowser + " BROWSER_VERSION=" + System.getProperty(CapabilityType.BROWSER_VERSION));

        switch (expectedBrowser.toLowerCase()) {
            case (Browsers.FIREFOX):
                return isSelenoidRun ? getRemoteDriver(getFirefoxDriverOptions(capabilities), remoteUrl) : createFirefoxDriver(capabilities);
            case (MOBILE_DRIVER):
                return isSelenoidRun ? getRemoteDriver(getMobileChromeOptions(capabilities), remoteUrl) : createChromeDriver(capabilities);
//            case (Browsers.OPERA):
//                return isSelenoidRun ? getRemoteDriver(getOperaRemoteDriverOptions(capabilities), remoteUrl) : createOperaDriver(capabilities);
            case (Browsers.SAFARI):
                return isSelenoidRun ? getRemoteDriver(getSafariDriverOptions(capabilities), remoteUrl) : createSafariDriver(capabilities);
            case (Browsers.IE):
                return isSelenoidRun ? getRemoteDriver(getIEDriverOptions(capabilities), remoteUrl) : createIEDriver(capabilities);
            case (Browsers.EDGE):
                return isSelenoidRun ? getRemoteDriver(getEdgeDriverOptions(capabilities), remoteUrl) : createEdgeDriver(capabilities);
            default:
                return isSelenoidRun ? getRemoteDriver(getChromeDriverOptions(capabilities), remoteUrl) : createChromeDriver(capabilities);
        }
    }

    /**
     * Задает capabilities для запуска Remote драйвера для Selenoid
     *
     * @param capabilities - capabilities для установленного браузера
     * @param remoteUrl    - url для запуска тестов, например http://remoteIP:4444/wd/hub
     * @return WebDriver
     */
    @SneakyThrows
    private WebDriver getRemoteDriver(MutableCapabilities capabilities, String remoteUrl) {
        log.info("---------------run Remote Driver---------------------");
        // @DEPRECATED LOGIC
        //capabilities.setCapability("enableVNC", true);
        //capabilities.setCapability("enableVideo", loadSystemPropertyOrDefault("enableVideo", ENABLE_VIDEO));
        //capabilities.setCapability("screenResolution", String.format("%sx%s", loadSystemPropertyOrDefault(WINDOW_WIDTH, DEFAULT_WIDTH),
        //        loadSystemPropertyOrDefault(WINDOW_HEIGHT, DEFAULT_HEIGHT)));

        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("screenResolution", String
                .format("%sx%s",
                        loadSystemPropertyOrDefault(WINDOW_WIDTH, DEFAULT_WIDTH),
                        loadSystemPropertyOrDefault(WINDOW_HEIGHT, WINDOW_HEIGHT))
        );
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", loadSystemPropertyOrDefault("enableVideo", ENABLE_VIDEO));

        capabilities.setCapability("selenoid:options", selenoidOptions);

        //capabilities.setCapability("name", GlobalVariable.threadTestName.get());
        String sessionName = loadSystemPropertyOrDefault(SELENOID_SESSION_NAME, "");
        if (!sessionName.isEmpty()) {
            capabilities.setCapability("name", String.format("%s %s", sessionName));
        }
        try {
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(
                    URI.create(remoteUrl).toURL(),
                    capabilities
            );
            remoteWebDriver.setFileDetector(new LocalFileDetector());
            return remoteWebDriver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Устанавливает ChromeOptions для запуска google chrome эмулирующего работу мобильного устройства (по умолчанию nexus 5)
     * Название мобильного устройства (device) может быть задано через системные переменные
     *
     * @return ChromeOptions
     */
    private ChromeOptions getMobileChromeOptions(Capabilities capabilities) {
        log.info("---------------run CustomMobileDriver---------------------");
        String mobileDeviceName = loadSystemPropertyOrDefault("device", "Nexus 5");
        ChromeOptions chromeOptions = new ChromeOptions().addArguments("disable-extensions",
                "test-type", "no-default-browser-check", "ignore-certificate-errors");

        Map<String, String> mobileEmulation = new HashMap<>();
//        chromeOptions.setHeadless(getHeadless());
        mobileEmulation.put("deviceName", mobileDeviceName);
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        return chromeOptions.merge(capabilities);
    }

    /**
     * Задает options для запуска Chrome драйвера
     * options можно передавать, как системную переменную, например -Doptions=--load-extension=my-custom-extension
     *
     * @return ChromeOptions
     */
    private ChromeOptions getChromeDriverOptions(Capabilities capabilities) {
        log.info("---------------Chrome Driver---------------------");
        ChromeOptions chromeOptions = !options[0].equals("")
                ? new ChromeOptions().addArguments(options)
                : new ChromeOptions();
        //chromeOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--disable-notifications");
        chromeOptions.setCapability(CapabilityType.BROWSER_VERSION, loadSystemPropertyOrDefault(CapabilityType.BROWSER_VERSION, VERSION_LATEST));
        if (getHeadless()) {
            chromeOptions.addArguments("--headless");
        }
        chromeOptions.addArguments("--disable-notifications");
        return chromeOptions.merge(capabilities);
    }

    private FirefoxOptions getFirefoxDriverOptions(Capabilities capabilities) {
        log.info("---------------Firefox Driver---------------------");
        FirefoxOptions firefoxOptions = !options[0].equals("") ? new FirefoxOptions().addArguments(options) : new FirefoxOptions();
        firefoxOptions.setCapability(CapabilityType.BROWSER_VERSION, loadSystemPropertyOrDefault(CapabilityType.BROWSER_VERSION, VERSION_LATEST));
//        firefoxOptions.setHeadless(getHeadless());
        return firefoxOptions.merge(capabilities);
    }


    private InternetExplorerOptions getIEDriverOptions(Capabilities capabilities) {
        log.info("---------------IE Driver---------------------");
        InternetExplorerOptions internetExplorerOptions = !options[0].equals("") ? new InternetExplorerOptions().addCommandSwitches(options) : new InternetExplorerOptions();
        internetExplorerOptions.setCapability(CapabilityType.BROWSER_VERSION, loadSystemPropertyOrDefault(CapabilityType.BROWSER_VERSION, VERSION_LATEST));
        internetExplorerOptions.setCapability("ie.usePerProcessProxy", "true");
        internetExplorerOptions.setCapability("requireWindowFocus", "false");
        internetExplorerOptions.setCapability("ie.browserCommandLineSwitches", "-private");
        internetExplorerOptions.setCapability("ie.ensureCleanSession", "true");
        internetExplorerOptions.merge(capabilities);
        return internetExplorerOptions;
    }

    private EdgeOptions getEdgeDriverOptions(Capabilities capabilities) {
        log.info("---------------Edge Driver---------------------");
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability(CapabilityType.BROWSER_VERSION, loadSystemPropertyOrDefault(CapabilityType.BROWSER_VERSION, VERSION_LATEST));
        return edgeOptions.merge(capabilities);
    }

    private SafariOptions getSafariDriverOptions(Capabilities capabilities) {
        log.info("---------------Safari Driver---------------------");
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setCapability(CapabilityType.BROWSER_VERSION, loadSystemPropertyOrDefault(CapabilityType.BROWSER_VERSION, VERSION_LATEST));
        return safariOptions.merge(capabilities);
    }

    private WebDriver createChromeDriver(Capabilities capabilities) {
        if (loadSystemPropertyOrDefault(BROWSER, Browsers.CHROME).equals(MOBILE_DRIVER))
            return WebDriverManager.chromedriver().capabilities(getMobileChromeOptions(capabilities)).create();
        return WebDriverManager.chromedriver().capabilities(getChromeDriverOptions(capabilities)).create();
    }

    private WebDriver createFirefoxDriver(Capabilities capabilities) {
        return WebDriverManager.firefoxdriver().capabilities(getFirefoxDriverOptions(capabilities)).create();
    }

    private WebDriver createIEDriver(Capabilities capabilities) {
        return WebDriverManager.iedriver().capabilities(getIEDriverOptions(capabilities)).create();
    }

    private WebDriver createEdgeDriver(Capabilities capabilities) {
        return WebDriverManager.edgedriver().capabilities(getEdgeDriverOptions(capabilities)).create();
    }

    private WebDriver createSafariDriver(Capabilities capabilities) {
        return WebDriverManager.safaridriver().capabilities(getSafariDriverOptions(capabilities)).create();
    }

    private Boolean getHeadless() {
        Boolean isHeadlessApp = loadSystemPropertyOrDefault(HEADLESS, false);
        Boolean isHeadlessSys = Boolean.parseBoolean(System.getProperty("selenide." + HEADLESS, "false"));
        return isHeadlessApp || isHeadlessSys;
    }


}