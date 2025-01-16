package allurium_style.pages;

import com.codeborne.selenide.SelenideElement;
import dm.tools.AbstractWidget;
import dm.tools.annotations.*;
import dm.tools.lists.ListWC;
import dm.tools.primitives.Button;
import dm.tools.primitives.Value;
import lombok.Getter;
import lombok.experimental.Accessors;

@PageObject
@Getter
@Accessors(fluent = true)
public class WebTablesPage {

    @Name("Employee")
    @ListLocator(css = ".table tbody tr")
    protected ListWC<EmployeeListItem> listEmployee = new ListWC<>();


    @Widget
    @Getter
    @Accessors(fluent = true)
    public static class EmployeeListItem extends AbstractWidget {

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

        @Name("Hire")
        @LocatorChain(xpath = "td[7]/button[1]")
        protected Button btnActionHire;

        @Name("Fire")
        @LocatorChain(xpath = "td[7]/button[2]")
        protected Button btnActionFire;

        public EmployeeListItem(SelenideElement rootElement) {
            super(rootElement);
        }

        @Override
        public String getId() {
            return lastName.text();
        }
    }

}
