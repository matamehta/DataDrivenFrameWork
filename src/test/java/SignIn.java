import helpers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class SignIn {

    private LoginPage login;
    private List<WebDriver> drivers;

    @DataProvider(name = "myTest")
    public Object[][] createData1() {
//        ReadData readXls = new ReadExcel();
        List<Login> logins = new ReadJsonData().getData();
        Object [][] result = new Object[logins.size()][];
        for(int i = 0; i < result.length ; i ++ ) {
            result[i] = new Object[]{ logins.get(i) };
        }
        return result;
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/sakodali/Sandbox/chromedriver");
        login = new LoginPage();
        drivers = new ArrayList<WebDriver>();
        //WebDriver fireFoxDriver = new FirefoxDriver();
        drivers.add(new FirefoxDriver());
        //drivers.add(new ChromeDriver());
    }

    @Test(dataProvider = "myTest")
    public void signIn(Login loginParameter) throws Exception {
        for (WebDriver driver : drivers) {
            login.testSignIn(loginParameter.getLoginEmail(), loginParameter.getPassword(), driver);
        }
    }
}