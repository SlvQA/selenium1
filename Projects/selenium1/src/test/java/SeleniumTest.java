import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://google.com/"); // navigate to the website

        WebElement searchBox = driver.findElement(By.name("q")); // finding the searchBox by name (may be by unique ID)
        String searchTerm = "chatGPT";
        searchBox.sendKeys(searchTerm, Keys.ENTER); // typing the search term and hitting ENTER

        String currentTitle = driver.getTitle(); // returns the Title of the page

        if (currentTitle.contains(searchTerm)){
            System.out.println("TEST PASSED. The current title is \"" + currentTitle + "\". The expected title is \"" + searchTerm + "\".");
        }else{
            System.out.println("TEST FAILED. The current title is \"" + currentTitle + "\". The expected title is \"" + searchTerm + "\".");
        }
    }
}
