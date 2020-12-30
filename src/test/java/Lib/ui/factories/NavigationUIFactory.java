package Lib.ui.factories;

import Lib.Platform;
import Lib.ui.NavigationUI;
import Lib.ui.android.AndroidNavigationUI;
import Lib.ui.ios.iOSNavigationUI;
import Lib.ui.mobile_web.MWNavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIFactory
{
    public static NavigationUI get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidNavigationUI(driver);
        } else if (Platform.getInstance().isiOS()){
            return new iOSNavigationUI(driver);
        } else {
            return new MWNavigationUI(driver);
        }
    }
}
