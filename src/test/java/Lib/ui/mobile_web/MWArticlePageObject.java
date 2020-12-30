package Lib.ui.mobile_web;

import Lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions li>#ca-watch";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON ="css:#page-actions li>#ca-watch.watched[role='button'][title='Remove this page from your watchlist']";
    }


    public MWArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
