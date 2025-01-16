package selenide_style.pages;

import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

@Getter
@Accessors(fluent = true)
public class SimpleListPage {

    protected ElementsCollection inputTextFields = $$x("//input[contains(@class, 'form-control')]")
            .as("Input fields");
    protected ElementsCollection listBirdNameButtons = $$(".mt-5 .btn-primary").as("Buttons bird names");
}
