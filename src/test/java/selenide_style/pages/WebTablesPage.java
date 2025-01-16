package selenide_style.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.assertj.core.api.Assertions;
import org.testng.asserts.Assertion;

import static com.codeborne.selenide.Selenide.$$;

@Getter
@Accessors(fluent = true)
public class WebTablesPage {

    protected ElementsCollection workersTable = $$(".table tbody tr");

    @Step("Assert that the table contains {surname} with the name {name}")
    public void assertEmployeeWithSurnameHasCertainName(String surname, String name) {
        String targetName = workersTable.filter(Condition.text(surname)).first().$x("td[1]").text();
        Assertions.assertThat(targetName).as("Employee name").isEqualTo(name);
    }

    @Step("Assert that table contains {surname} with the email {email}")
    public void assertEmailOfEmployeeWithCertainSurname(String surname, String email) {
        String targetEmail = workersTable.filter(Condition.text(surname)).first().$x("td[4]").text();
        Assertions.assertThat(targetEmail).as("Employee email").isEqualTo(email);
    }

    @Step("Hire the employee with with the surname {surname}")
    public void hireBySurname(String surname) {
        workersTable.filter(Condition.text(surname)).first().$x("td[7]/button[1]").click();
    }

    @Step("Fire the employee with with the surname {surname}")
    public void fireBySurname(String surname) {
        workersTable.filter(Condition.text(surname)).first().$x("td[7]/button[2]").click();
    }

    @Step("Assert that the employer {surname} has email with text '{textPattern}'")
    public void assertEmployeeHasEmailWithText(String surname, String textPattern) {
        String targetEmail = workersTable.filter(Condition.text(surname)).first().$x("td[4]").text();
        Assertions.assertThat(targetEmail).as(surname + "email").contains(textPattern);
    }

    @Step("Assert that employee {surname} is from {department} department")
    public void assertDepartmentOfEmployee(String surname, String department) {
        String targetDepartment = workersTable.filter(Condition.text(surname)).first().$x("td[6]").text();
        Assertions.assertThat(targetDepartment).as(surname + "department").contains(department);
    }
}
