import helpers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SignIn {

    private LoginPage login;

    private WebDriver driver;

    @DataProvider(name = "myTest")
    public Object[][] createData1() {

        return new ReadJsonFile().getData();
    }

    @BeforeMethod
    public void setUp() throws Exception {

        //System.setProperty("webdriver.chrome.driver", "/Users/sakodali/Sandbox/chromedriver");
       // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        login = new LoginPage(driver);
    }

    @Test(dataProvider = "myTest")
    public void signIn(ReadLoginData loginParameter) throws Exception {

            login.testSignIn(loginParameter.getLoginEmail(), loginParameter.getPassword());
        }
    }
//}