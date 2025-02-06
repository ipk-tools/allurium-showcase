package allurium_style.elements;

import allurium.UiSteps;
import allurium.annotations.Widget;
import allurium.carousels.AbstractCarousel;

@Widget
public class Carousel extends AbstractCarousel {

    public Carousel(String selenideLocator) {
        super(selenideLocator);
    }

    @Override
    public void scrollForward() {
        getRoot().$(".carousel-control-next-icon").click();
        UiSteps.waiting(1, "observing the slide");
    }

    @Override
    public void scrollBackward() {
        getRoot().$(".carousel-control-prev-icon").click();
        UiSteps.waiting(1, "observing the slide");
    }
}
