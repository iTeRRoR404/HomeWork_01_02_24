import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class NewWindowTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testNewWindow() {

        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        String actualText = driver.findElement(By.tagName("h3")).getText();
        String expectedText = "New Window";
        Assert.assertEquals(actualText, expectedText);
    }
}