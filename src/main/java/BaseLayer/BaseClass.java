package BaseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	private static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return tl.get();
	}

	public void initialization(String browsername) {

		WebDriver driver = null;

		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("headless")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--headless");
			driver = new ChromeDriver(opt);
		} else if (browsername.equalsIgnoreCase("incognito")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--incognito");
			driver = new ChromeDriver(opt);
		} else {
			driver = new EdgeDriver();
		}

		tl.set(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

}
