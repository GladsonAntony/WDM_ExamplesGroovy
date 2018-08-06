/**
 * @Author Gladson Antony
 * @Date 30-Sep-2017 
 * @Time 12:10:17 AM
 */
package webDriverManagerExamples

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.Test

import io.github.bonigarcia.wdm.ChromeDriverManager

class WDM_ChromeHeadless 
{
	WebDriver driver
	
	@Test
	public void test_ChromeHeadless() throws Exception
	{
		ChromeDriverManager.getInstance().setup()
		ChromeOptions chromeOptions = new ChromeOptions()
		chromeOptions.addArguments('--headless')
		chromeOptions.addArguments('--disable-gpu')
		driver = new ChromeDriver(chromeOptions)
		driver.get('https://www.google.co.in/')
		Assert.assertEquals(driver.getTitle(), 'Google')
		
	}
	
	@AfterTest(alwaysRun=true)
	void after()
	{
		driver.close()
		driver.quit()
	}


}
