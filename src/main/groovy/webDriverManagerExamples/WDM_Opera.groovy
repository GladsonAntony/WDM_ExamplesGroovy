/**
 * @Author Gladson Antony
 * @Date 30-Sep-2017 
 * @Time 12:30:03 AM
 */
package webDriverManagerExamples

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.opera.OperaDriver
import org.openqa.selenium.opera.OperaOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.Test

import io.github.bonigarcia.wdm.WebDriverManager

class WDM_Opera
{
	WebDriver driver
	DesiredCapabilities capabilities

	@Test
	public void test_Opera() throws Exception
	{
		WebDriverManager.operadriver().arch64().setup()
		capabilities = DesiredCapabilities.operaBlink()
		OperaOptions optionsOpera = new OperaOptions()
		optionsOpera.setBinary('C:/Program Files/Opera/57.0.3098.106/opera.exe')
		capabilities.setCapability(ChromeOptions.CAPABILITY, optionsOpera)
		driver = new OperaDriver(capabilities)
		driver.get('https://www.google.co.in/')
		driver.manage().window().maximize()
		Assert.assertEquals(driver.getTitle(), 'Google')
	}

	@AfterMethod(alwaysRun=true)
	void after()
	{
		driver.quit()
	}
}
