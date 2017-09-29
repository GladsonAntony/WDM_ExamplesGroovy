/**
 * @Author Gladson Antony
 * @Date 29-Sep-2017 
 * @Time 11:51:13 PM
 */
package examples

import org.openqa.selenium.WebDriver
import org.openqa.selenium.edge.EdgeDriver
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.Test

import io.github.bonigarcia.wdm.EdgeDriverManager

class WDM_Edge 
{
	WebDriver driver
	
	@Test
	public void test_Edge() throws Exception
	{
		EdgeDriverManager.getInstance().setup()
		driver = new EdgeDriver()
		driver.get('https://www.google.co.in/')
		driver.manage().window().maximize()
		Assert.assertEquals(driver.getTitle(), 'Google')
		
	}
	
	@AfterTest(alwaysRun=true)
	void after()
	{
		driver.close()
	}
}
