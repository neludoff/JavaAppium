package Lib.ui.factories;

import Lib.Platform;
import Lib.ui.ArticlePageObject;
import Lib.ui.android.AndroidArticlePageObject;
import Lib.ui.ios.iOSArticlePageObject;
import Lib.ui.mobile_web.MWArticlePageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObjectFactory
{
    public static ArticlePageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidArticlePageObject(driver);
        } else if (Platform.getInstance().isiOS()){
            return new iOSArticlePageObject(driver);
        } else {
            return new MWArticlePageObject(driver);
        }
    }
}
