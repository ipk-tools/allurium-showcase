package selenide_style.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Accessors(fluent = true)
public class IframePage {

    protected SelenideElement fieldName = $("#name").as("Name field");
    protected SelenideElement fieldEmail = $("#email").as("Email field");
    protected SelenideElement fieldPassword = $("#password").as("Password field");
    protected SelenideElement btnSubmit = $("#submit-main").as("Submit button");

    protected IframeLoginForm iframeLoginForm = new IframeLoginForm();

    @Getter
    @Accessors(fluent = true)
    public static class IframeLoginForm {

        protected SelenideElement fieldName = $("#name_iframe").as("Name field");
        protected SelenideElement fieldEmail = $("#email_iframe").as("Email field");
        protected SelenideElement fieldPassword = $("#password_iframe").as("Password field");
        protected SelenideElement btnSubmit = $("#submit-iframe").as("Submit button");
    }
}
