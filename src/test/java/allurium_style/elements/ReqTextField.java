package allurium_style.elements;

import allurium.inputs.AbstractRequiredTextField;
import org.assertj.core.api.Assertions;

public class ReqTextField extends AbstractRequiredTextField {

    public ReqTextField() {
        super();
    }

    public ReqTextField(String selenideLocator) {
        super(selenideLocator);
    }

    @Override
    public boolean isMarked() {
        return getRoot().parent().$(".error-message").isDisplayed();
    }
}
