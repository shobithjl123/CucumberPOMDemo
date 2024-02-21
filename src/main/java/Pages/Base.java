package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static stepDefinition.SharedSD.getDriver;

public class Base {

    public static WebElement webAction(By locator) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(50)) // max time
                .pollingEvery(Duration.ofSeconds(5)) // every 5 seconds
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ArithmeticException.class)
                .ignoring(NullPointerException.class)
                .ignoring(Exception.class)
                .withMessage(
                        "WebDriver waited for 50 seconds but still " +
                                "could not find the element therefore " +
                                "Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver)
            {
                return driver.findElement(locator);
            }
        });

        return element;
    }

    //to do click operation
    public void clickOn(By locator)
    {
        // getDriver().findElement(locator).click();
   /*  WebElement webElement =  webAction(locator);
        webElement.click();*/
        //webAction(locator)-->driver.findElement(locator);
        webAction(locator).click();
    }

    // to type in to TextBox
    public void setValue(By locator,String value)
    {
        //webAction(locator)-->driver.findElement(locator);
        webAction(locator).sendKeys(value);
    }

    // select from dropdown list
    public void selectFromDropDown(By locator,String value)
    {
        WebElement wb = webAction(locator);
        Select sel = new Select(wb);
        sel.selectByVisibleText(value);
    }

    // get Text from element
    public String getTextValue(By locator)
    {
        return webAction(locator).getText();
    }

    // get Element text list
    public ArrayList<String> getElementTextList(By locator)
    {
        List<WebElement> wblList = getDriver().findElements(locator);
        ArrayList<String> txtList = new ArrayList<>();

        for (WebElement wb :wblList)
        {
            txtList.add(wb.getText());
        }

        return txtList;
    }

}
