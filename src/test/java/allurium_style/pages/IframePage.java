package allurium_style.pages;

import allurium.annotations.Name;
import allurium.annotations.PageObject;
import allurium.annotations.Widget;
import allurium.inputs.TextField;
import allurium.primitives.Button;
import allurium.windows.Iframe;
import lombok.Getter;
import lombok.experimental.Accessors;

import static allurium.inputs.TextField.$textField;
import static allurium.primitives.Button.$button;

@PageObject
@Getter
@Accessors(fluent = true)
public class IframePage extends Page {

    @Name("Name")
    protected TextField fieldName = $textField("#name");

    @Name("Email")
    protected TextField fieldEmail = $textField("#email");

    @Name("Password")
    protected TextField fieldPassword = $textField("#password");

    @Name("Submit")
    protected Button btnSubmit = $button("#submit-main");

    @Name("Iframe Login Form")
    protected IframeLoginForm iframeLoginForm = new IframeLoginForm("#iframe_root");


    @Widget
    @Getter
    @Accessors(fluent = true)
    public static class IframeLoginForm extends Iframe {
        public IframeLoginForm(String selenideLocator) {
            super(selenideLocator);
        }

        @Name("Name")
        protected TextField fieldName = $textField("#name_iframe");

        @Name("Email")
        protected TextField fieldEmail = $textField("#email_iframe");

        @Name("Password")
        protected TextField fieldPassword = $textField("#password_iframe");

        @Name("Submit")
        protected Button btnSubmit = $button("#submit-iframe");
    }
}
