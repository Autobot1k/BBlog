import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

@Listeners(VideoListener.class)

public class LoginTests extends BaseUI {

    String actualTitle;
    String actualErrorMessage;

    @Video(name = "Login test")
    @Test(dataProvider = "Login", dataProviderClass = DataProviders.class)
    public void testLogin(String email, String password, boolean positiveTest, String errorMessageRule) {

        loginPage.clickSignInLink();
        loginPage.completeLoginPage(email, password);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.clickButtonSignIn();


       //Negative tests
        if (!positiveTest) {


            Assert.assertTrue(driver.findElement(Locators.ERROR_MESSAGE).isDisplayed());
            actualErrorMessage = driver.findElement(Locators.ERROR_MESSAGE).getText();
            System.out.println(actualErrorMessage);
            if (errorMessageRule.contains(Data.invalidPasswordEmailReq)) {
                Assert.assertEquals(actualErrorMessage, Data.expectedErrorMessageInvalid);
            }else if(errorMessageRule.contains(Data.blankEmailReq)){
                Assert.assertEquals(actualErrorMessage, Data.expectedErrorMessageEmailBlank);
                System.out.println(actualErrorMessage);
            }else if(errorMessageRule.contains(Data.blankPasswordReq)){
                Assert.assertEquals(actualErrorMessage, Data.expectedErrorMessagePasswordBlank);
                System.out.println(actualErrorMessage);
            }
        }  else{
            //Positive test - happy path
            actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, Data.expectedMainTitle);
        }
    }
}


