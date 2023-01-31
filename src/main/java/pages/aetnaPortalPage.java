package pages;
import org.openqa.selenium.By;

public class aetnaPortalPage {

    public String quoteUrl = "https://www.aetna.com/insurance-producer/working-with-aetna/get-a-quote.html";
    public By individualDentalLocator = new By.ByCssSelector("#link_root_accordion_copy_copy_5");
    public By loginLocator = new By.ByCssSelector(".link__text[data-analytics-name='Log in to get a quote'][href='https://dentaldirect.aetna.com/#/']");
    public By zipCodeLocator = new By.ByCssSelector("#zipInput");
    public By emailLocator = new By.ByCssSelector("#Email");
    public By actualTextLocator = new By.ByCssSelector("h2[class='mb-3']");
    public By findAPlanLocator = new By.ByCssSelector("#next1");

}

