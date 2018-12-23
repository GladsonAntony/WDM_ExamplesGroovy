/**
 * @Author Gladson Antony
 * @Date 29-Sep-2017 
 * @Time 10:25:39 PM
 */
package webDriverManagerExamples

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.Test

import io.github.bonigarcia.wdm.WebDriverManager

class WDM_FirefoxHeadless 
{
	
	WebDriver driver
	
	@Test
	public void test_MozillaFirefox() throws Exception
	{
		FirefoxOptions firefoxOptions = new FirefoxOptions()
		firefoxOptions.addArguments("--headless")
		WebDriverManager.firefoxdriver().arch64().setup()
		driver = new FirefoxDriver(firefoxOptions)
		driver.get('https://www.google.co.in/')
		driver.manage().window().maximize()
		Assert.assertEquals(driver.getTitle(), 'Google')
		
	}
	
	@AfterMethod(alwaysRun=true)
	void after()
	{		
		driver.close()
	}
}
