package allurium_style.pages;

import allurium.annotations.Name;
import allurium.annotations.PageObject;
import allurium_style.elements.ButtonToggle;
import allurium_style.elements.ClassicToggleSwitcher;
import lombok.Getter;
import lombok.experimental.Accessors;

@PageObject
@Getter
@Accessors(fluent = true)
public class SwitcherPage {

    @Name("CTU")
    protected ClassicToggleSwitcher classicToggleSwitcher = new ClassicToggleSwitcher(".switch");

    @Name("SBT")
    protected ButtonToggle buttonToggle = new ButtonToggle("#toggleBtn");

    // @Name("SBT")
    // protected ButtonToggle buttonToggle = new ButtonToggle("#ttoggleBtn");
}
