package allurium_style.pages;

import allurium.AbstractWidget;
import allurium.annotations.*;
import allurium.inputs.DropdownSelect;
import allurium.inputs.TextField;
import allurium.lists.ListWC;
import allurium.primitives.*;
import lombok.Getter;
import lombok.experimental.Accessors;

@PageObject
@Getter
@Accessors(fluent = true)
public class HomePage {

    @Name("Navigation bar")
    protected NavBar navBar = new NavBar();

    @Name("Search block")
    protected SearchBlock searchBlock = new SearchBlock();

    @Name("Gallery block")
    protected GalleryBlock galleryBlock = new GalleryBlock();

    @Name("Footer")
    protected Footer footer = new Footer();

    @Widget
    @Getter
    @Accessors(fluent = true)
    public static class NavBar extends AbstractWidget {
        @Name("Photos")
        @Locator(css = ".navbar-nav .nav-item:nth-child(1)")
        protected Link linkPhotos;

        @Name("Stickers")
        @Locator(css = ".navbar-nav .nav-item:nth-child(2)")
        protected Link linkStickers;

        @Name("Icons")
        @Locator(css = ".navbar-nav .nav-item:nth-child(3)")
        protected Link linkIcons;
    }

    @Widget
    @Getter
    @Accessors(fluent = true)
    public static class SearchBlock extends AbstractWidget {
        @Name("Image type")
        @Locator(css = ".form-group select")
        protected DropdownSelect selectImageType;

        @Name("Search query")
        @Locator(css = ".form-group input")
        protected TextField fieldSearchQuery;

        @Name("Search")
        @Locator(css = ".form-inline button")
        protected Button btnSearch;
    }

    @Widget
    @Getter
    @Accessors(fluent = true)
    public static class GalleryBlock extends AbstractWidget {
        @Name("Topic name")
        @Locator(css = "h2")
        protected Header topicName;

        @Name("Image Gallery")
        @ListLocator(css = ".mb-4 img")
        protected ListWC<Image> listGallery = new ListWC<>();

        @Name("Next")
        @Locator(css = ".pagination  li:nth-child(2) a")
        protected Button btnNext;

        @Name("Previous")
        @Locator(css = ".pagination  li:nth-child(1) a")
        protected Button btnPrevious;
    }

    @Widget
    @Getter
    @Accessors(fluent = true)
    public static class Footer extends AbstractWidget {
        @Name("Policy")
        @Locator(xpath = "(//ul[contains(@class, 'list-unstyled')])[1]/li[1]/a")
        protected Link linkPolicy;

        @Name("Policy")
        @Locator(xpath = "(//ul[contains(@class, 'list-unstyled')])[1]/li[2]/a")
        protected Link linkSitemap;

        @Name("Phone")
        @Locator(xpath = "//*[contains(@class, 'col-lg-3')][2]/p")
        protected TextLine phoneNumber;

        @Name("About Us")
        @Locator(xpath = "//*[contains(@class, 'col-lg-3')][3]/p")
        protected Text aboutUs;
    }
}
