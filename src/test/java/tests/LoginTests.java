package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

import static utils.PropertiesReader.*;

public class LoginTests extends AppManager {
     SoftAssert softAssert =  new SoftAssert();
    @Test
    public void loginPositiveTest() {
        User user = User.builder()
                //                .email("wrong123@eabf.vkk"))
                .email(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Assert.assertTrue(new BoardsPage(getDriver()).validateUrl("boards"));
    }

    @Test
    public void loginNegativeWrongEmailTest() {
        User user = User.builder()
                .email("wrok89gmail.com")
                .password(getProperty("base.properties", "password"))
                .build();

        new LoginPage(getDriver()).isWrongEmail(user);
        Assert.assertTrue(new LoginPage(getDriver()).isBtnSigUpDisplayed());
    }

    @Test
    public void loginNegativeWrongPasswordTest() {
        User user = User.builder()
                .email(getProperty("base.properties", "email"))
                .password("Laki2341")
                .build();
        LoginPage loginPage = new LoginPage(getDriver());

        //softAssert.assertTrue(loginPage.isPsWrong(user));
      //  softAssert.assertTrue(loginPage.getResetPsAlertTest().contains("Incorrect email and / or password."));
      //  softAssert.assertAll();

    }
}
