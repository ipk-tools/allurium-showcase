package allurium_style.elements;

import allurium.switchers.AbstractSwitcher;

public class ClassicToggleSwitcher extends AbstractSwitcher {

    public ClassicToggleSwitcher(String selenideLocator) {
        super(selenideLocator);
    }

    @Override
    public boolean getState() {
        return getRoot().$("input").isSelected();
    }

    @Override
    public void toggle() {
        getRoot().click();
    }

    @Override
    public void switchOn() {
        if (!getState()) {
            getRoot().click();
        }
    }

    @Override
    public void switchOff() {
        if (getState()) {
            getRoot().click();
        }
    }
}
