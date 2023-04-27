package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {

    String baseUrl="https://magento.softwaretestingboard.com/";
    @Before
    public void setBaseUrl()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheSortByProductNameFilter()
    {
        mouseHoverOnElement(By.xpath("//span[normalize-space()='Women']"));
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']"));
        mouseHoverAndClickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        List<WebElement> beforeSelectionList = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        List<String> beforeSelectionList1 = new ArrayList<>();
        for (WebElement list :beforeSelectionList)
        {
            beforeSelectionList1.add(String.valueOf(list.getText()));
        }
        selectFromDropDownMenu(By.xpath("//div[2]//div[3]//select[1]"),"Product Name");

        List<WebElement> afterSelectionList = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        List<String> afterSelectionList1 = new ArrayList<>();
        for (WebElement list1:afterSelectionList)
        {
            afterSelectionList1.add(String.valueOf(list1.getText()));
        }
        Collections.sort(beforeSelectionList1);

        verifyElementMethod(beforeSelectionList1.toString(),afterSelectionList1.toString());

    }

    @Test
    public void verifyTheSortByPriceFilter()
    {
        mouseHoverOnElement(By.xpath("//span[normalize-space()='Women']"));
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
        mouseHoverAndClickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        List<WebElement> beforeSelectionList = driver.findElements(By.xpath("//span[@class='price-container price-final_price tax weee']"));
        List<String> beforeSelectionList1 = new ArrayList<>();
        for (WebElement list :beforeSelectionList)
        {
            beforeSelectionList1.add(String.valueOf(list.getText()));
        }
        selectFromDropDownMenu(By.xpath("//div[2]//div[3]//select[1]"),"Price");
        //  clickOnElement(By.xpath("//div[@class='column main']//div[2]//div[3]//a[1]"));

        List<WebElement> afterSelectionList = driver.findElements(By.xpath("//span[@class='price-container price-final_price tax weee']"));
        List<String> afterSelectionList1 = new ArrayList<>();
        for (WebElement list1:afterSelectionList)
        {
            afterSelectionList1.add(String.valueOf(list1.getText()));
        }
        Collections.sort(beforeSelectionList1);
        //   Collections.reverse(beforeSelectionList1);

        verifyElementMethod(beforeSelectionList1.toString(),afterSelectionList1.toString());

    }

    @After
    public void tearDown()
    {
        driver.close();
    }

}
