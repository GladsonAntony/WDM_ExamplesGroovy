/**
 * @Author Gladson Antony
 * @Date 30-Sep-2017 
 * @Time 12:10:17 AM
 */
package webDriverManagerExamples

import org.openqa.selenium.WebDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.Test

import io.github.bonigarcia.wdm.WebDriverManager

class WDM_PhantomJS 
{
	WebDriver driver

	@Test
	public void test_PhantomJs() throws Exception 
	{
		WebDriverManager.phantomjs().arch64().setup()
		driver = new PhantomJSDriver();
		println 'Phantom JS Driver Setup'
		driver.get('https://www.google.co.in/')
		WebDriverWait wait = new WebDriverWait(driver, 30)
		wait.until(ExpectedConditions.titleIs('Google'))
		println driver.getCurrentUrl()
		println driver.getTitle()
		Assert.assertEquals(driver.getTitle(), 'Google');
	}

	@AfterTest(alwaysRun=true)
	void after() 
	{
		driver.close()
		driver.quit()
	}
}
