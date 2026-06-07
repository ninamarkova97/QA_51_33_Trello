package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AtlassianPage;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

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
    @Test
    public void changeProfilePhotoPositiveTest(){
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1));
        AtlassianPage atlassianPage = new AtlassianPage(getDriver());
        atlassianPage.changePhotoInMyAvatar();
    }
}
