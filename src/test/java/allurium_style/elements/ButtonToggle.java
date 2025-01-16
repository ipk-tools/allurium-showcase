package allurium_style.elements;

import com.codeborne.selenide.Condition;
import dm.tools.switchers.AbstractSwitcher;

public class ButtonToggle extends AbstractSwitcher {

    public ButtonToggle(String selenideLocator) {
        super(selenideLocator);
    }

    @Override
    public boolean getState() {
        return getRoot().has(Condition.cssClass("off"));
    }

    @Override
    public void toggle() {
        getRoot().click();
    }

    @Override
    public void switchOn() {
        if (getState()) {
            getRoot().click();
        }
    }

    @Override
    public void switchOff() {
        if (!getState()) {
            getRoot().click();
        }
    }
}
