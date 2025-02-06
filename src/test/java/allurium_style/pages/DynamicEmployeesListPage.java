package allurium_style.pages;

import com.codeborne.selenide.SelenideElement;
import allurium.AbstractWidget;
import allurium.annotations.*;
import allurium.lists.ListWC;
import allurium.primitives.Button;
import allurium.primitives.Value;
import lombok.Getter;
import lombok.experimental.Accessors;

@PageObject
@Getter
@Accessors(fluent = true)
public class DynamicEmployeesListPage extends Page {

    @Name("Add Employee")
    @Locator(css = "#addEmployeeButton")
    protected Button btnAddEmployee;

    @Name("Clear the table")
    @Locator(id = "removeAllButton")
    protected Button btnClearTable;

    @Name("Employees")
    @ListLocator(css = "#employeeTableBody tr")
    protected ListWC<EmployeeRecord> employees = new ListWC<>();


    @Widget
    @Getter
    @Accessors(fluent = true)
    public static class EmployeeRecord extends AbstractWidget {

        @Name("First name")
        @LocatorChain(xpath = "td[1]")
        protected Value firstName;

        @Name("Last name")
        @LocatorChain(xpath = "td[2]")
        protected Value lastName;

        @Name("Age")
        @LocatorChain(xpath = "td[3]")
        protected Value age;

        @Name("Email")
        @LocatorChain(xpath = "td[4]")
        protected Value email;

        @Name("Salary")
        @LocatorChain(xpath = "td[5]")
        protected Value salary;

        @Name("Department")
        @LocatorChain(xpath = "td[6]")
        protected Value department;

        @Name("Delete")
        @LocatorChain(xpath = "td[7]")
        protected Button btnDelete;

        public EmployeeRecord(SelenideElement rootElement) {
            super(rootElement);
        }

        @Override
        public String getId() {
            return email.text();
        }
    }

}
