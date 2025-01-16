package selenide_style.widgets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dm.tools.AbstractWidget;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
@Accessors(fluent = true)
public class TopBar {

    protected SelenideElement mainItem1 = $x("//ul[@class='menu']/li[1]").as("Main Item 1");
    protected SelenideElement mainItem2 = $x("//ul[@class='menu']/li[2]").as("Main Item 2");
    protected SelenideElement mainItem3 = $x("//ul[@class='menu']/li[3]").as("Main Item 3");
    protected SelenideElement mainItem4 = $x("//ul[@class='menu']/li[4]").as("Main Item 4");
    protected Level1SubMenu level1SubMenu = new Level1SubMenu();

    @Getter
    @Accessors(fluent = true)
    public static class Level1SubMenu {
        ElementsCollection items = $$x("//ul[@class='menu']/li[4]/ul/li")
                .as("Level 1 sub menu items");
        Level2SubMenu level2SubMenu = new Level2SubMenu();
    }

    @Getter
    @Accessors(fluent = true)
    public static class Level2SubMenu {
        ElementsCollection items = $$x("//ul[@class='menu']/li[4]/ul/li[3]/ul/li")
                .as("Level 2 sub menu items");
        Level3SubMenu level3SubMenu = new Level3SubMenu();
    }

    @Getter
    @Accessors(fluent = true)
    public static class Level3SubMenu {
        ElementsCollection items = $$x("//ul[@class='menu']/li[4]/ul/li[3]/ul/li[3]/ul/li")
                .as("Level 3 sub menu items");
        Level4SubMenu level4SubMenu = new Level4SubMenu();
    }

    @Getter
    @Accessors(fluent = true)
    public static class Level4SubMenu {
        ElementsCollection items = $$x("//ul[@class='menu']/li[4]/ul/li[3]/ul/li[3]/ul/li[3]/ul/li")
                .as("Level 4 sub menu items");
        Level5SubMenu level5SubMenu = new Level5SubMenu();
    }

    @Getter
    @Accessors(fluent = true)
    public static class Level5SubMenu {
        ElementsCollection items = $$x("//ul[@class='menu']/li[4]/ul/li[3]/ul/li[3]/ul/li[3]/ul/li[3]/ul/li")
                .as("Level 5 sub menu items");
    }
}
