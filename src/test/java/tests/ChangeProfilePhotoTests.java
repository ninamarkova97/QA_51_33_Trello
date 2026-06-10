package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AtlassianPage;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.RetryAnalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static utils.PropertiesReader.getProperty;

public class ChangeProfilePhotoTests extends AppManager {
    BoardsPage boardsPage;

    @BeforeMethod
    public void login() {
        User user = User.builder()
                .email(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());

    }
    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void changeProfilePhotoPositiveTest(){
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1));
        AtlassianPage atlassianPage = new AtlassianPage(getDriver());
        atlassianPage.changePhotoInMyAvatar("src/main/resources/cat1.jpg");

        Assert.assertTrue(atlassianPage.validateMessage("Avatar added"));
    }
    @Test
    public void changeProfilePhotoWrongFileNegativeTest(){
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1));
        AtlassianPage atlassianPage = new AtlassianPage(getDriver());
        atlassianPage.changePhotoInMyAvatar("src/test/resources/boards.csv");

        Assert.assertTrue(atlassianPage.validateWrongMessage("Upload a photo or select from some default options"));
    }
}
