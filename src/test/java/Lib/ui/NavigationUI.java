package Lib.ui;

import Lib.Platform;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject
{
    protected static String
        MY_LISTS_LINK,
        OPEN_NAVIGATION;

    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openNavigation()
    {
        if (Platform.getInstance().isMw()){
            this.waitForElementAndClick(OPEN_NAVIGATION, "Can't find and click open navigation button", 5);
        } else {
            System.out.println("Method openNavigation() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickMyLists()
    {
        if (Platform.getInstance().isMw()){
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "Can't find navigation button to My list",
                    5
            );
        }
        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Can't find navigation button to My list",
                5
        );
    }
}
