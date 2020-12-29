package Lib.ui;

import io.appium.java_client.AppiumDriver;
import Lib.Platform;
import org.openqa.selenium.WebElement;

import java.util.List;

abstract public class MyListsPageObject extends MainPageObject{

    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL,
            MY_LIST_ELEMENT,
            SYNC_YOUR_SAVED_ARTICLES,
            IMAGE_ELEMENT,
            SEARCH_BUTTON;

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Can't find folder by name " + name_of_folder,
                10
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(
                article_xpath,
                "Can't find saved article by title '" + article_title + "'",
                15
        );
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(
                article_xpath,
                "Saved article still present with title '" + article_title + "'",
                15
        );
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.swipeElementToLeft(
                article_xpath,
                "Can't find saved article"
        );

        if (Platform.getInstance().isiOS())
        {
            this.clickElementToTheRightUpperCorner(article_xpath, "Can't find saved article ");
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void openMyLists()
    {
        this.waitForElementAndClick(
                MY_LIST_ELEMENT,
                "Can't find 'My List' button",
                5);
    }

    public void closeSyncSavedArticlesPopUp()
        {
        this.waitForElementAndClick(
                SYNC_YOUR_SAVED_ARTICLES,
                "Can't find 'Close' button for 'Sync your saved articles popup'",
                10
        );
    }

    public List<WebElement> getElementsIdByImage() {
        return this.waitForElementsPresent(
                IMAGE_ELEMENT,
                "Can't find image element",
                5
        );
    }

    public void clickSearchButton ()
    {
        this.waitForElementAndClick(
                SEARCH_BUTTON,
                "Can't find search button",
                5
        );
    }
}