package allurium_style.elements;

import allurium.inputs.TextField;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

public class RequiredTextField extends TextField {

    protected By errorMessageLocator;

    public RequiredTextField() {
        super();
        // if you don't apply a custom type name, 'input text field' will be used, since it's inherited from TextField
        setUiElementType("required input text field");
    }

    public RequiredTextField(By rootLocator) {
        super(rootLocator);
        setUiElementType("required input text field");
    }

    public boolean isErrorMessageShown() {
        return getRoot().parent().$(".error-message").isDisplayed();
    }

    @Step("Assert that, the warning message {message} shown")
    public void assertWarningIsShown(String message) {
        Allure.step(
                String.format("Assert that, the warning message [%s] of the %s %s shown",
                        message, getUiElementType(), wrappedName())
        );
        Assertions.assertThat(isErrorMessageShown()).as("Requited field message").isTrue();
        Assertions.assertThat(getRoot().parent().$(".error-message").text()).as("Error Message")
                .isEqualTo(message);
    }
}
