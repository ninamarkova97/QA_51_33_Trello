package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver,10), this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement inputEmail;
    @FindBy(xpath = "//button[@id='login-submit']")
    WebElement btnContinue;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(id = "login-submit")
    WebElement btnSubmit;
    @FindBy(id ="sigup-submit")
    WebElement btnSigUp;
    @FindBy(xpath = "//*[data-testid='form-error--content']")
    WebElement resetPasswordAlert;
    @FindBy(id = "username-u1d1-error")
    WebElement errorEmailAlert;
    @FindBy(id = "password-error")
    WebElement errorPassword;


    public void login(User user){
        inputEmail.sendKeys(user.getEmail());
        btnContinue.click();
        //pause(4000);
        clickWait(inputPassword);
        inputPassword.sendKeys(user.getPassword());
        btnSubmit.click();
    }
    public void isWrongEmail(User user1){
        inputEmail.sendKeys(user1.getEmail());
        btnContinue.click();

    }
    public boolean isBtnSigUpDisplayed(){
       return btnSigUp.isDisplayed();

    }
}
