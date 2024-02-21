package stepDefinition;

import Pages.SearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BookingsSD {

    SearchResultPage searchResultPage = new SearchResultPage();

    @Given("^I am on default locations search result screen$")
    public void givenDefaultLocationsSearchResultScreen() {
        try {
            searchResultPage.clickCrossButton();
        }
        catch (Exception e)
        {

        }

    }

    @When("^I select option for stars as (.+)$")
    public void whenSelectOptionForStars(String stars) {
        searchResultPage.clickRating(stars.split(" ")[0]);

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void thenVerifySystemDisplaysOnlyStarsHotels(String stars) {
       ArrayList<String> ratings = searchResultPage.getAllRatings();
       System.out.println(ratings);

       int size= ratings.size();
       int occurence = Collections.frequency(ratings,stars.split(" ")[0]);

       boolean result = (size==occurence);

        Assert.assertTrue(result);


    }

   /* @Then("^I verify (.+) is within the search result$")
    public void iVerifyIsWithinTheSearchResult(String expectedHotel) {
        ArrayList<String> hotelList = searchResultPage.getHotelList();
        boolean flag = false;
        for (String hotelName: hotelList)
        {
            System.out.println(hotelName);
            if (hotelName.contains(expectedHotel))
            {
                flag=true;
            }
        }
        Assert.assertTrue("Given hotel is not present in the Hotel list",flag);
    }*/



    @Then("I verify system displays all hotels within {string} amount")
    public void iVerifySystemDisplaysAllHotelsWithinAmount(String amountStr)
    {
        ArrayList<Integer> priceList = searchResultPage.getPriceList();
        System.out.println(priceList);
        int expectedAmount= Integer.parseInt(amountStr);
        Boolean flag=true;
        ArrayList<Integer> greaterPriceList= new ArrayList<>();
        for (int price:priceList)
        {
            if (price>expectedAmount)
            {
                flag=false;
                greaterPriceList.add(price);
            }
        }
        Assert.assertTrue("some values are greater than,"+expectedAmount+"\n below are the greater values\n"+ greaterPriceList,flag);


    }

    @Then("I verify {string} is within the search result")
    public void iVerifyIsWithinTheSearchResult(String expectedHotel) {
        ArrayList<String> hotelList = searchResultPage.getHotelList();
        boolean flag = false;
        for (String hotelName: hotelList)
        {
            System.out.println(hotelName);
            if (hotelName.contains(expectedHotel))
            {
                flag=true;
            }
        }
        Assert.assertTrue("Given hotel is not present in the Hotel list",flag);
    }



    @Then ("^I verify (.+) is within the search result of bookings$")
    public void hotelNameSearch(String expectedHotel)
    {
        ArrayList<String> hotelList = searchResultPage.getHotelList();
        boolean flag = false;
        for (String hotelName: hotelList)
        {
            //System.out.println(hotelName);
            System.out.println(hotelName);
            if (hotelName.contains(expectedHotel))
            {
                flag=true;
            }
        }
        Assert.assertTrue("Given hotel is not present in the Hotel list",flag);
    }
}