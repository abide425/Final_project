package pages;

import org.openqa.selenium.By;

public class contactInformationPage {
    public By homeAddressLocator = new By.ByCssSelector("#HomeAddress");
    public By aptLocator = new By.ByCssSelector("#AptNumber");
    public By cityLocator = new By.ByCssSelector("#City");
    public By confirmEmailLocator = new By.ByCssSelector("#ConfirmEmail");
    public By primaryPhoneLocator = new By.ByCssSelector("#PrimaryPhoneNumber");
    public By phoneTypeLocator = new By.ByCssSelector("#PrimaryPhoneType");
    public By carrierLocator = new By.ByCssSelector("#NameOfCarrier");
    public By residentLocator = new By.ByCssSelector("label[for='IsResident2']");
    public By readAndWriteLocator = new By.ByCssSelector("label[for='IsReadOrWriteEnglish2']");
    public By accountabilityLocator = new By.ByCssSelector("label[for='IsCompletedByApplicant2']");
    public By nextLocator = new By.ByCssSelector("button[name='btnContactInfoNext']");

    public By nameLocator = new By.ByCssSelector("body > app-root:nth-child(3) > div:nth-child(2) > section:nth-child(3) > app-review:nth-child(3) > section:nth-child(2) > div:nth-child(3) > div:nth-child(5) > div:nth-child(1) > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)");

    public By DOBLocator = new By.ByCssSelector("body > app-root:nth-child(3) > div:nth-child(2) > section:nth-child(3) > app-review:nth-child(3) > section:nth-child(2) > div:nth-child(3) > div:nth-child(5) > div:nth-child(1) > table:nth-child(3) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2)");

}