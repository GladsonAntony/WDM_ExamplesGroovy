/**
 * @Author Gladson Antony
 * @Date 29-Sep-2017 
 * @Time 10:14:39 PM
 */
package webDriverManagerExamples

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.Test

import io.github.bonigarcia.wdm.WebDriverManager

class WDM_Chrome 
{
	WebDriver driver
	
	@Test
	public void test_Chrome() throws Exception
	{
		WebDriverManager.chromedriver().arch64().setup()
		driver = new ChromeDriver()
		driver.get('https://www.google.co.in/')
		driver.manage().window().maximize()
		Assert.assertEquals(driver.getTitle(), 'Google')
		
	}
	
	@AfterMethod(alwaysRun=true)
	void after()
	{
		driver.close()
		driver.quit()
	}
}
