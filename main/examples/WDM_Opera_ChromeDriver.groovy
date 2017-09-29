/**
 * @Author Gladson Antony
 * @Date 30-Sep-2017 
 * @Time 12:10:17 AM
 */

package examples

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.Test

import io.github.bonigarcia.wdm.ChromeDriverManager

class WDM_Opera_ChromeDriver
{
	WebDriver driver
	DesiredCapabilities capabilities

	@Test
	public void test_Opera() throws Exception
	{		
		ChromeDriverManager.getInstance().setup()
		capabilities = DesiredCapabilities.opera()
		ChromeOptions optionsOpera = new ChromeOptions()
		optionsOpera.setBinary('C:/Program Files/Opera/launcher.exe')
		capabilities.setCapability(ChromeOptions.CAPABILITY, optionsOpera)
		driver = new ChromeDriver(capabilities)
		driver.get('https://www.google.co.in/')
		driver.manage().window().maximize()
		WebDriverWait wait = new WebDriverWait(driver, 30)
		wait.until(ExpectedConditions.titleIs('Google'))		
		Assert.assertEquals(driver.getTitle(), 'Google')
	}

	@AfterTest(alwaysRun=true)
	void after()
	{
		driver.quit()
	}
}
