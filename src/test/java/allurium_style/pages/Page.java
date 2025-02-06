package allurium_style.pages;

import allurium.annotations.ListLocator;
import allurium.annotations.Name;
import allurium.lists.ListWC;
import allurium.primitives.Button;
import allurium.primitives.Link;
import lombok.Getter;
import lombok.experimental.Accessors;

import static allurium.primitives.Button.$button;

@Getter
@Accessors(fluent = true)
public class Page {

    @Name("Left bar links")
    @ListLocator(css = ".col-md-4 .nav-link")
    protected ListWC<Link> leftBarLinks = new ListWC<>();

    @Name("Consent")
    protected Button btnConsent = $button(".fc-cta-consent .fc-button-label");
}
