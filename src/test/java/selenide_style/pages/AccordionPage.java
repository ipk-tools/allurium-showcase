package selenide_style.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.assertj.core.api.Assertions;

import static com.codeborne.selenide.Selenide.$$;

@Getter
@Accessors(fluent = true)
public class AccordionPage extends Page {

    protected ElementsCollection sections = $$(".card").as("Accordion sections");

    @Step("Click on {chapterName} in accordion widget")
    public SelenideElement clickOnSectionLabel(String chapterName) {
        SelenideElement chapterHead = sections.stream().filter(section -> section.text().contains(chapterName))
                .findFirst().get().$(".card-header button").as("Chapter head");
        chapterHead.click();
        return chapterHead;
    }

    @Step("Assert accordion's chapter {chapterName} has text {text}")
    public void assertTextHas(String chapterName, String text) {
        String targetText = sections.stream().filter(section -> section.text().contains(chapterName))
                .findFirst().get().$(".collapse .card-body").text();
        Assertions.assertThat(targetText).as("chapter content").contains(text);
    }
}
