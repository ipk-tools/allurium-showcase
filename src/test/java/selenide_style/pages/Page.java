package selenide_style.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dm.tools.inputs.Select;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
@Accessors(fluent = true)
public class Page {

    protected ElementsCollection leftBarLinks = $$(".col-md-4 .nav-link").as("Left bar links");

    protected SelenideElement btnConsent = $(".fc-cta-consent .fc-button-label").as("Consent button");
}
