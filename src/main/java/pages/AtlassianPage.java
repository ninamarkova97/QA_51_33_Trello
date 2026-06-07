package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AtlassianPage extends BasePage{
    public AtlassianPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }
    @FindBy(xpath = "//button=[@data-testid='profile-avatar-dropdown-trigger']")
    WebElement btnAvatar;
    @FindBy(xpath = "//div[@data-test-selector='profile-hover-info']")
    WebElement divProfilePhoto;

    public void changePhotoInMyAvatar(){
       // clickWait(btnAvatar);
        Actions actions = new Actions(driver);
        actions.moveToElement(divProfilePhoto).pause(1000).click().perform();
    }
}
