package allurium_style.tests;

import allurium.UiSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Pms;

import java.io.File;
import java.net.URL;

@Epic("Allurium style")
public class ITAlluriumProfiling extends TestBaseAllurium {

    // local pages url
//    String homePageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/integration_test_template.html";
//    String subFormPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/sub_form.html";
//    String formPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/form.html";
//    String listsPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/lists.html";
//    String accordionPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/accordion.html";
//    String listLocatorPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/list_locator_chain.html";
//    String tablePageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/table.html";
//    String dynamicTablePageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/table_dynamic.html";
//    String iframePageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/iframe.html";
//    String carouselPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/carousel.html";
//    String switcherPageUrl = "file:///"+System.getProperty("user.dir")+"/src/test/resources/html/switcherPage.html";

    // remote pages url
    String homePageUrl = "file:///home/selenium/Downloads/pages/integration_test_template.html";
    String subFormPageUrl = "file:///home/selenium/Downloads/pages/sub_form.html";
    String formPageUrl = "file:///home/selenium/Downloads/pages/form.html";
    String listsPageUrl = "file:///home/selenium/Downloads/pages/lists.html";
    String accordionPageUrl = "file:///home/selenium/Downloads/pages/accordion.html";
    String listLocatorPageUrl = "file:///home/selenium/Downloads/pages/list_locator_chain.html";
    String tablePageUrl = "file:///home/selenium/Downloads/pages/table.html";
    String dynamicTablePageUrl = "file:///home/selenium/Downloads/pages/table_dynamic.html";
    String iframePageUrl = "file:///home/selenium/Downloads/pages/iframe.html";
    String carouselPageUrl = "file:///home/selenium/Downloads/pages/carousel.html";
    String switcherPageUrl = "file:///home/selenium/Downloads/pages/switcherPage.html";

    @Test
    @Feature("Form")
    @DisplayName("Filling the example form")
    public void fillTheFormWithProfiling() {
        URL imageUrl = this.getClass().getClassLoader().getResource("img/testicon.png");
        long startTime = System.nanoTime();

        Pms.measureExecutionTime("Open Browser", () -> UiSteps.openBrowser(formPageUrl));

        Pms.measureExecutionTime("Login Field Visibility Check", () ->
                formPage.fieldLogin().assertVisible()
        );

        Pms.measureExecutionTime("Enter Login", () ->
                formPage.fieldLogin().write("John")
        );

        Pms.measureExecutionTime("Login Field CSS Class Check", () ->
                formPage.fieldLogin().assertHasCssClass("form-control")
        );

        Pms.measureExecutionTime("Login Field Value Check", () ->
                formPage.fieldLogin().assertCurrentValue("John")
        );

        Pms.measureExecutionTime("Enter Email", () ->
                formPage.fieldEmail().clearAndWrite("john.doe@gmail.com")
        );

        Pms.measureExecutionTime("Email Value Check", () ->
                formPage.fieldEmail().assertCurrentValue("john.doe@gmail.com")
        );

        Pms.measureExecutionTime("Enter Password", () ->
                formPage.fieldPassword().write("Password12345!")
        );

        Pms.measureExecutionTime("Enter Rank", () ->
                formPage.fieldRank().write("10")
        );

        Pms.measureExecutionTime("Enter Date", () ->
                formPage.fieldDate().clearAndWrite("11.11.2011")
        );

        Pms.measureExecutionTime("Enter Telephone", () ->
                formPage.fieldTelephone().write("199887688")
        );

        Pms.measureExecutionTime("Upload Avatar", () ->
                formPage.uploadAvatar().uploadFile(new File(imageUrl.getFile()))
        );

        Pms.measureExecutionTime("Select Male Radio Button", () -> {
            formPage.radioBtnMale().click();
        });

        Pms.measureExecutionTime("Male Radio Button -  assert enabled", () -> {
            formPage.radioBtnMale().assertEnabled();
        });

        Pms.measureExecutionTime("Female Radio Button -  assert disabled", () -> {
            formPage.radioBtnFemale().assertDisabled();
        });

        Pms.measureExecutionTime("Check Morning Checkbox", () -> {
            formPage.ckbMorning().check();
        });

        Pms.measureExecutionTime("Morning Checkbox - assert checked", () -> {
            formPage.ckbMorning().assertChecked();
        });

        Pms.measureExecutionTime("Evening Checkbox - assert unchecked", () -> {
            formPage.ckbEvening().assertUnchecked();
        });

        Pms.measureExecutionTime("Select Experience", () ->
                formPage.ddExperience().select("2 years")
        );

        Pms.measureExecutionTime("Select Experience assert current value", () ->
                formPage.ddExperience().assertCurrentValue("2")
        );

        Pms.measureExecutionTime("Select Working Days", () -> {
            formPage.selectWorkingDays().select("Monday");
        });

        Pms.measureExecutionTime("Select Working Days", () -> {
            formPage.selectWorkingDays().select("Friday");
        });

        long endTime = System.nanoTime();
        long durationInMillis = (endTime - startTime) / 1_000_000;
        System.out.println("Form filling execution time: " + durationInMillis + " ms");
    }

    @Test
    @DisplayName("Using ListWC to handle a table")
    public void tableExampleWithProfiling() {
        long startTime = System.nanoTime();

        Pms.measureExecutionTime("Open Browser", () -> UiSteps.openBrowser(tablePageUrl));

        Pms.measureExecutionTime("Assert Employee List Size", () ->
                webTablesPage.listEmployee().assertSize(9)
        );

        Pms.measureExecutionTime("Assert Vega's First Name is 'Cierra'", () ->
                webTablesPage.listEmployee().get("Vega").firstName().assertText("Cierra")
        );

        Pms.measureExecutionTime("Assert Cantrell's Email is 'alden@example.com'", () ->
                webTablesPage.listEmployee().get("Cantrell").email().assertText("alden@example.com")
        );

        Pms.measureExecutionTime("Click Hire for Gentry", () ->
                webTablesPage.listEmployee().get("Gentry").btnActionHire().click()
        );

        Pms.measureExecutionTime("Assert Hogg contains 'hogg@'", () ->
                webTablesPage.listEmployee().get("Hogg").assertHasText("hogg@")
        );

        Pms.measureExecutionTime("Click Hire for Hogg", () ->
                webTablesPage.listEmployee().get("Hogg").btnActionHire().click()
        );

        Pms.measureExecutionTime("Click Fire for Watkins", () ->
                webTablesPage.listEmployee().get("Watkins").btnActionFire().click()
        );

        Pms.measureExecutionTime("Assert Howard's Department is 'Development'", () ->
                webTablesPage.listEmployee().get("Howard").department().assertText("Development")
        );

        Pms.measureExecutionTime("Click Hire for Spencer", () ->
                webTablesPage.listEmployee().get("Spencer").btnActionHire().click()
        );

        long endTime = System.nanoTime();
        long durationInMillis = (endTime - startTime) / 1_000_000;
        System.out.println("Form filling execution time: " + durationInMillis + " ms");
    }

}
