package allurium_style.pages;

import allurium_style.elements.ButtonToggle;
import allurium_style.elements.Carousel;
import allurium_style.elements.ClassicToggleSwitcher;
import allurium.annotations.Name;
import allurium.annotations.PageObject;
import lombok.Getter;
import lombok.experimental.Accessors;

@PageObject
@Getter
@Accessors(fluent = true)
public class CarouselPage extends Page {

    @Name("Random images")
    protected Carousel carousel = new Carousel("#carouselExampleIndicators");

    @Name("CTU")
    protected ClassicToggleSwitcher classicToggleSwitcher = new ClassicToggleSwitcher(".switch");

    @Name("SBT")
    protected ButtonToggle buttonToggle = new ButtonToggle("#toggleBtn");
}
