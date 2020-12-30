package Lib.ui.mobile_web;

import Lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {

    static {
        ARTICLE_BY_TITLE_TPL = "xpath://a/h3[contains(text(),'{TITLE}')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://li[@title='{SUBSTRING}']/a[contains(@class, 'watched')]";
        MY_LIST_ELEMENT = "xpath://*[@content-desc='My lists']";
        IMAGE_ELEMENT = "xpath://XCUIElementTypeImage//..//XCUIElementTypeStaticText";
        SEARCH_BUTTON ="id:Search";
    }

    public MWMyListsPageObject(RemoteWebDriver driver){
        super(driver);
    }
}
