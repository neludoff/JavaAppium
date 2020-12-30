package Lib.ui.factories;

import Lib.Platform;
import Lib.ui.MyListsPageObject;
import Lib.ui.android.AndroidMyListsPageObject;
import Lib.ui.ios.iOSMyListsPageObject;
import Lib.ui.mobile_web.MWMyListsPageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListsPageObjectFactory
{
    public static MyListsPageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidMyListsPageObject(driver);
        } else if (Platform.getInstance().isiOS()){
            return new iOSMyListsPageObject(driver);
        } else {
            return new MWMyListsPageObject(driver);
        }
    }
}
