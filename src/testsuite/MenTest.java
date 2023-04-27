package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class MenTest extends Utility {

    String baseUrl="https://magento.softwaretestingboard.com/";
    @Before
    public void setBaseUrl()
    {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart()
    {
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-5']"));
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        mouseHoverAndClickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverAndClickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverAndClickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverAndClickOnElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));
        String expectedMessage = "You added Cronus Yoga Pant to your shopping cart.";
        WebElement actualMessage =driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        String actualMessageText = actualMessage.getText();
        verifyElementMethod(expectedMessage,actualMessageText);
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"))
        String expectedTextShoppingCart = "Shopping Cart";
        WebElement actualMessage1 = driver.findElement(By.xpath("//span[@class='base']"));
        String actualTextShoppingCart = actualMessage1.getText();
        verifyElementMethod(expectedTextShoppingCart,actualTextShoppingCart);

        String expectedTextCoronus = "Cronus Yoga Pant";
        WebElement actualMessage2 =  driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        String actualTextCoronus = actualMessage2.getText();
        verifyElementMethod(expectedTextCoronus,actualTextCoronus);

        String expectedTextSize = "32";
        WebElement actualMessage3 =  driver.findElement(By.xpath("//dd[contains(text(),'32')]"));
        String actualTextSize = actualMessage3.getText();
        verifyElementMethod(expectedTextSize,actualTextSize);

        String expectedTextColor = "Black";
        WebElement actualMessage4 =  driver.findElement(By.xpath("//dd[contains(text(),'Black')]"));
        String actualTextColor = actualMessage4.getText();
        verifyElementMethod(expectedTextColor,actualTextColor);


    }

    @After
    public void tearDown()
    {
        driver.close();
    }
}
