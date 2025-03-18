package selenide_style.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$$;

@Getter
@Accessors(fluent = true)
public class ListLocatorPage {

    protected ElementsCollection sections = $$("#accordion .card").as("Sections");

    @Step("Select section {sectionTitle}")
    public void clickSection(String sectionTitle) {
        SelenideElement target = null;
        for (SelenideElement section : sections) {
            if (section.find(".card-header button").text().equals(sectionTitle))
                section.find(".card-header button").click();
        }
    }

    @Step("Select {option} in the section {sectionTitle}")
    public void selectOption(String sectionTitle, String option) {
        sections.filter(Condition.text(sectionTitle)).first()
                .findAll(".card-body .btn")
                .filter(Condition.text(option)).first().click();
    }

    @Step("Open context menu {option} in the section {sectionTitle}")
    public void contextClickOption(String sectionTitle, String option) {
        sections.filter(Condition.text(sectionTitle)).first()
                .findAll(".card-body .btn")
                .filter(Condition.text(option)).first().contextClick();
    }
}
