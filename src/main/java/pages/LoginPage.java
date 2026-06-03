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
    @FindBy(id = "resetPassword")
    WebElement resetPasswordAlert;
   @FindBy(id = "username-uid1-error")
   WebElement emailError;
   @FindBy(id = "password-error")
   WebElement passwordError;


    public void login(User user){
        inputEmail.sendKeys(user.getEmail());
        btnContinue.click();
        //pause(4000);
        clickWait(inputPassword);
        inputPassword.sendKeys(user.getPassword());
        btnSubmit.click();
    }
    public void isWrongEmail(User user){
        inputEmail.sendKeys(user.getEmail());
        btnContinue.click();

    }
    public boolean isBtnSigUpDisplayed(){
       return  btnSigUp.isDisplayed();

    }

    public void isWrongPassword(User user) {
        inputEmail.sendKeys(user.getEmail());
        btnContinue.click();
        clickWait(inputPassword);
        inputPassword.sendKeys(user.getPassword());
        btnSubmit.click();
    }
    public boolean resetPasswordAlert(){
        return resetPasswordAlert.isDisplayed();
    }
    public boolean isEmailEmpty(){
        return emailError.isDisplayed();
    }
    public boolean isPasswordEmpty(){
        return passwordError.isDisplayed();
    }
}
