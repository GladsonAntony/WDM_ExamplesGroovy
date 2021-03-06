/**
 * @Author Gladson Antony
 * @Date 30-Sep-2017 
 * @Time 12:10:17 AM
 */
package webDriverManagerExamples

import org.openqa.selenium.WebDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.Test

import io.github.bonigarcia.wdm.WebDriverManager


class WDM_InternetExplorer 
{
	WebDriver driver
	
	@Test
	public void test_InternetExplorer() throws Exception
	{
		WebDriverManager.iedriver().arch64().setup()
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true)
		driver = new InternetExplorerDriver(ieCapabilities)
		driver.get('https://www.google.co.in/')
		driver.manage().window().maximize()
		WebDriverWait wait = new WebDriverWait(driver, 30)
		wait.until(ExpectedConditions.titleIs('Google'))
		Assert.assertEquals(driver.getTitle(), 'Google')
		
	}
	
	@AfterMethod(alwaysRun=true)
	void after()
	{
		driver.close()
		driver.quit()
	}
}
