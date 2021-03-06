package tests;

import Lib.CoreTestCase;
import Lib.ui.MainPageObject;
import Lib.ui.SearchPageObject;
import Lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchTests extends CoreTestCase {

    // Get rid of MainPageObject from this class
    private Lib.ui.MainPageObject MainPageObject;

    protected void setUp() throws Exception{
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    };

    @Test
    public void testSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("bject-oriented programming language");
    }

    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDissappear();
    }

    @Test
    public void testCompareElementText(){
        MainPageObject.assertElementHasText(
                "xpath://*[contains(@text,'Search Wikipedia')]",
                "Search Wikipedia",
                "We see unexpected element text"
        );
    }

    // Ex3
    @Test
    public void testFindSeveralArticlesAndCancelSearch(){

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Cyberpunk");

        int articles_amount_before_search_cancel = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "Can't find any searched topic",
                articles_amount_before_search_cancel > 2
        );

        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();

        int articles_amount_after_search_cancel = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "Some searched articles presented on a page",
                articles_amount_after_search_cancel == 0
        );
    }

    @Test
    public void testCheckWordsInSearchResult(){
        MainPageObject.waitForElementAndClick(
                "id:org.wikipedia:id/search_container",
                "Cannot find search element 'Input'",
                5
        );

        MainPageObject.waitForElementAndSendKeys(
                "id:search_src_text",
                "Java",
                "Can't find field 'Input'",
                5
        );

        List<WebElement> elements = MainPageObject.waitForElementsPresent(
                "xpath://*[contains(@text,'Java')]",
                "Cannot find any 'Java' topic",
                5
        );

        for(WebElement object: elements){
            assertTrue(
                    "Can't find any topic which contains 'Java'",
                    object.getAttribute("text").contains("Java"));
        }
    }

    @Test
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin park discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "Can't find any results",
                amount_of_search_results > 0
        );
    }

    @Test
    public void testAmountOfEmptySearch(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "qweqddwqw11";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }
}
