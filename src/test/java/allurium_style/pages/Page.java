package allurium_style.pages;

import dm.tools.annotations.ListLocator;
import dm.tools.annotations.Name;
import dm.tools.lists.ListWC;
import dm.tools.primitives.Button;
import dm.tools.primitives.Link;
import lombok.Getter;
import lombok.experimental.Accessors;

import static dm.tools.primitives.Button.$button;

@Getter
@Accessors(fluent = true)
public class Page {

    @Name("Left bar links")
    @ListLocator(css = ".col-md-4 .nav-link")
    protected ListWC<Link> leftBarLinks = new ListWC<>();

    @Name("Consent")
    protected Button btnConsent = $button(".fc-cta-consent .fc-button-label");
}
