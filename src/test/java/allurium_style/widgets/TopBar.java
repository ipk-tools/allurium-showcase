package allurium_style.widgets;

import dm.tools.AbstractWidget;
import dm.tools.annotations.ListLocator;
import dm.tools.annotations.Locator;
import dm.tools.annotations.Name;
import dm.tools.annotations.Widget;
import dm.tools.lists.ListWC;
import dm.tools.primitives.MenuItem;
import lombok.Getter;
import lombok.experimental.Accessors;

import static dm.tools.primitives.MenuItem._$menuItem;

@Widget
@Getter
@Accessors(fluent = true)
public class TopBar extends AbstractWidget {

    @Name("Main Item 1")
    @Locator(xpath = "//ul[@class='menu']/li[1]")
    protected MenuItem mainItem1;

    @Name("Main Item 2")
    @Locator(xpath = "//ul[@class='menu']/li[2]")
    protected MenuItem mainItem2;

    @Name("Main Item 3")
    protected MenuItem mainItem3 = MenuItem.$menuItem("//ul[@class='menu']/li[3]");

    @Name("Main Item 4")
    protected MenuItem mainItem4 = _$menuItem("//ul[@class='menu']/li[4]");

    @Name("Level 1 sub menu")
    protected Level1SubMenu level1SubMenu = new Level1SubMenu();


    @Widget
    @Getter
    @Accessors(fluent = true)
    public static class Level1SubMenu extends AbstractWidget {

        @Name("Level 1 sub menu items")
        @ListLocator(xpath = "//ul[@class='menu']/li[4]/ul/li")
        protected ListWC<MenuItem> items = new ListWC<>();

        @Name("Level 2 sub menu")
        protected Level2SubMenu level2SubMenu = new Level2SubMenu();
    }

    @Widget
    @Getter
    @Accessors(fluent = true)
    public static class Level2SubMenu extends AbstractWidget {

        @Name("Level 2 sub menu items")
        @ListLocator(xpath = "//ul[@class='menu']/li[4]/ul/li[3]/ul/li")
        protected ListWC<MenuItem> items = new ListWC<>();

        @Name("Level 3 sub menu")
        protected Level3SubMenu level3SubMenu = new Level3SubMenu();
    }

    @Widget
    @Getter
    @Accessors(fluent = true)
    public static class Level3SubMenu extends AbstractWidget {

        @Name("Level 3 sub menu items")
        @ListLocator(xpath = "//ul[@class='menu']/li[4]/ul/li[3]/ul/li[3]/ul/li")
        protected ListWC<MenuItem> items = new ListWC<>();

        @Name("Level 4 sub menu")
        protected Level4SubMenu level4SubMenu = new Level4SubMenu();
    }

    @Widget
    @Getter
    @Accessors(fluent = true)
    public static class Level4SubMenu extends AbstractWidget {

        @Name("Level 4 sub menu items")
        @ListLocator(xpath = "//ul[@class='menu']/li[4]/ul/li[3]/ul/li[3]/ul/li[3]/ul/li")
        protected ListWC<MenuItem> items = new ListWC<>();

        @Name("Level 5 sub menu")
        protected Level5SubMenu level5SubMenu = new Level5SubMenu();
    }

    @Widget
    @Getter
    @Accessors(fluent = true)
    public static class Level5SubMenu extends AbstractWidget {

        @Name("Level 5 sub menu items")
        @ListLocator(xpath = "//ul[@class='menu']/li[4]/ul/li[3]/ul/li[3]/ul/li[3]/ul/li[3]/ul/li")
        protected ListWC<MenuItem> items = new ListWC<>();
    }
}
