package Lib.ui.factories;

import Lib.Platform;
import Lib.ui.SearchPageObject;
import Lib.ui.android.AndroidSearchPageObject;
import Lib.ui.ios.iOSSearchPageObject;
import Lib.ui.mobile_web.MWSearchPageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObjectFactory
{
    public static SearchPageObject get (RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidSearchPageObject(driver);
        } else if (Platform.getInstance().isiOS()){
            return new iOSSearchPageObject(driver);
        } else {
            return new MWSearchPageObject(driver);
        }
    }
}
