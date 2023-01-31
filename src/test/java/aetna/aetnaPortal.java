package aetna;

import Utils.DriverUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.aetnaPortalPage;
import pages.aboutYouPage;
import pages.pickYourPlanPage;
import pages.contactInformationPage;
import com.github.javafaker.Faker;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class aetnaPortal {
    WebDriver driver;
    JavascriptExecutor js;
    aetnaPortalPage aetnaPage;
    aboutYouPage aboutPage;
    pickYourPlanPage pickPlanPage;
    contactInformationPage contactPage;
    public String absolutePath = "/Users/abide/IdeaProjects/Final project/TestData/MOCK_DATA.csv";
    public CSVReader csvReader = new CSVReader( new FileReader( absolutePath ) );
    public String[] cells = csvReader.readNext();
    public aetnaPortal() throws IOException,CsvValidationException {}
    public Faker faker = new Faker();


    @BeforeClass
    void SetUp() {
        driver = DriverUtil.getWebDriver();
        aetnaPage = new aetnaPortalPage();
        aboutPage = new aboutYouPage();
        pickPlanPage = new pickYourPlanPage();
        contactPage = new contactInformationPage();
        driver.get(aetnaPage.quoteUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }

    @Test(priority = 1)
    void navigateToLoginPage() throws InterruptedException {


        driver.findElement(aetnaPage.individualDentalLocator).click();
        driver.findElement(aetnaPage.loginLocator).click();
        driver.findElement(aetnaPage.zipCodeLocator).sendKeys("14211");
        driver.findElement(aetnaPage.emailLocator).sendKeys("abdr@gmail.com");

        //Assertion
        DriverUtil.scrollDown();
        Thread.sleep(4000);
        String actualText = driver.findElement(aetnaPage.actualTextLocator).getText();
        System.out.println(actualText);
        Assert.assertTrue(actualText.contains("Why choose Aetna"));
        driver.findElement(aetnaPage.findAPlanLocator).click();
    }

    @Test(priority = 2)
    void aboutYou() throws InterruptedException {

        driver.findElement(aboutPage.firstNameLocator).sendKeys( cells[0].split(" ")[0] );
        driver.findElement(aboutPage.MILocator).sendKeys("M");
        driver.findElement(aboutPage.lastNameLocator).sendKeys(cells[0].split(" ")[1] );
        Thread.sleep(2000);
        driver.findElement(aboutPage.genderLocator).sendKeys( cells[2] );
        driver.findElement(aboutPage.DOBLocator).sendKeys( cells[3] );
        driver.findElement(aboutPage.optionLocator).sendKeys("I had");
        DriverUtil.waitAndClick(aboutPage.nextButtonLocator);
    }

    @Test(priority = 3)
    void pickYourPlan() throws InterruptedException {

        DriverUtil.clickUsingJS(pickPlanPage.plansLocator);
        DriverUtil.clickUsingJS(pickPlanPage.plansNextLocator);

    }

    @Test(priority = 4)
    void contact() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(contactPage.homeAddressLocator).sendKeys("553 Walden Ave");
        driver.findElement(contactPage.aptLocator).sendKeys("#2");
        driver.findElement(contactPage.cityLocator).sendKeys("Buffalo");
        driver.findElement(contactPage.confirmEmailLocator).sendKeys("abdr@gmail.com");

        String phoneNumber = faker.numerify("##########");
        driver.findElement(contactPage.primaryPhoneLocator).sendKeys(phoneNumber);
        DriverUtil.selectByValue(contactPage.phoneTypeLocator, "M");
        driver.findElement(contactPage.carrierLocator).sendKeys("Metro Plus");
        driver.findElement(contactPage.residentLocator).click();
        driver.findElement(contactPage.readAndWriteLocator).click();
        DriverUtil.clickUsingJS(contactPage.accountabilityLocator);
        DriverUtil.waitAndClick(contactPage.nextLocator);

        //Assertion
        String name = driver.findElement(contactPage.nameLocator).getText();
        System.out.println(name);
        Assert.assertEquals(name, cells[0]);

        String DOB = driver.findElement(contactPage.DOBLocator).getText();
        System.out.println(DOB);
        Assert.assertEquals(DOB, cells[3]);
    }


    @AfterClass
    void wrapUp() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

