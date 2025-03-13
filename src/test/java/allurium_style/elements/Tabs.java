package allurium_style.elements;

import allurium.primitives.Tab;
import allurium.tabs.AbstractTabs;

public class Tabs extends AbstractTabs {

    public Tabs(String selenideLocator) {
        super(selenideLocator);
    }

    @Override
    public String getActiveTabName() {
        return getRoot().text();
    }

    @Override
    public Tab getActive() {
        return null;
    }
}
