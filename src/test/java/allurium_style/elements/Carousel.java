package allurium_style.elements;

import dm.tools.UiSteps;
import dm.tools.annotations.Widget;
import dm.tools.carousels.AbstractCarousel;

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
