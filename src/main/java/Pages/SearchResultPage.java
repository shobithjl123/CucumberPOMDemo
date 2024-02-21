package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static stepDefinition.SharedSD.getDriver;

public class SearchResultPage extends Base {

    //div[@id='filter_group_class_:r1q:']//input[@name='class=3']

    public void clickRating(String star) {
        //getDriver().navigate().refresh();
        //By rating = By.xpath("//input[@name='class="+star+"']");
        By rating = By.xpath("//div[@data-testid='filters-group']/div[@data-filters-item='class:class="+star+"']");
        //div[@id='filter_group_class_:r1q:']/div[@data-filters-item='class:class=5']
        //input[@name='class='"+star+"'']
        clickOn(rating);
    }
    By crossButton = By.xpath("//button[contains(@aria-label,'Dismiss')]");
    public void clickCrossButton()
    {
        clickOn(crossButton);
    }

    By rating = By.xpath("//div[contains(@aria-label,'out of 5')]");

    public ArrayList<String>getAllRatings()
    {
        getDriver().navigate().refresh();
        List<WebElement> wbList= getDriver().findElements(rating);
        ArrayList<String> ratingList= new ArrayList<>();

        for (WebElement wb:wbList)
        {
            String attributeValue = wb.getAttribute("aria-label"); // 4 out of 5
            ratingList.add(attributeValue.split(" ")[0]);
        }
        return ratingList;
    }

      By hotelList = By.xpath("//div[@data-testid='title']");

       public ArrayList<String> getHotelList()
        {
            return getElementTextList(hotelList);
        }

        By priceListElement = By.xpath("//span[@data-testid='price-and-discounted-price']");

         public ArrayList<Integer> getPriceList()
        {
            getDriver().navigate().refresh();
            ArrayList<String> priceListStr = getElementTextList(priceListElement);
            System.out.println(priceListStr);
            ArrayList<Integer> priceList= new ArrayList<>();

            for (String priceStr: priceListStr)   //
            {
                String priceWithoutRupeeSymbol = priceStr.split(" ")[1];  //10,755
                String priceWithoutcomma = priceWithoutRupeeSymbol.replace(",",""); //10755
                int price=0;
                try {
                    price = Integer.parseInt(priceWithoutcomma);
                }
                catch (Exception e)
                {

                }
                priceList.add(price);

            }
            return priceList;
        }


}
