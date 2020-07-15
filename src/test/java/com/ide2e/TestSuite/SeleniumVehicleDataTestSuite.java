package com.ide2e.TestSuite;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ide2e.service.VehicleData;
import com.ide2e.service.VehicleService;
import com.ide2e.service.VehicleServiceImpl;

public class SeleniumVehicleDataTestSuite {
	
	Logger log = Logger.getLogger(SeleniumVehicleDataTestSuite.class.getName());
	
	private String applicationUrl;
	private WebDriver driver;
	private ResultCaptureHelper recordResult;
	//change location of driver
	private final String driverLocatio = "/Users/ravisingh/Projects/TestAutomation/chromedriver";
	
	private final String startButton = "//a[@class='gem-c-button gem-c-button--start']";
	private final String registrationSearchElement ="//input[@class='form-control "
			+ "form-control-1-4 input-upper']";
	
	private final String listItemELement = "//li[@class='list-summary-item']";
	private final String ulELement = "//ul[@class='list-summary margin-bottom-2']";
	private final String registrationPageButton = "//button[@class='button']";
	private final String spanRegistrationNo = "//span[@class='reg-mark']";
    private VehicleService vehicleService;
    
	@Before
	public void openBrowser() {
		initWebDriver();
		applicationUrl = "https://www.gov.uk/get-vehicle-information-from-dvla";
		driver.get(applicationUrl);
		log.info("Vehicle Registration web Page found ");
		recordResult = new ResultCaptureHelper();
		vehicleService = new VehicleServiceImpl(null);
	}

	@After
	public void saveTestResultScreen() throws IOException {
		
		//capture screen test
	}

	private void initWebDriver() {
		// configure can be externalised.
		System.setProperty("webdriver.chrome.driver", driverLocatio);
		driver = new ChromeDriver();
	}

	@Test
	public void testExecute() {
		log.info("executing dvla registry match");
		Set<VehicleData> vehicleData = vehicleService.getVehicles();
		
		driver.findElement(By.xpath(startButton)).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		vehicleData.forEach(vehicle -> 
		{
			driver.findElement(By.xpath(registrationSearchElement)).sendKeys(vehicle.getRegistrationNo());
			driver.findElement(By.xpath(registrationPageButton)).click();
			
			String registrationNumber = driver.findElement(By.xpath(spanRegistrationNo)).
					getText();
			assertEquals(vehicle.getRegistrationNo().toLowerCase(), 
					registrationNumber.toLowerCase().replaceAll("\\s",""));
			
			//list-summary-item
			WebElement vehivcleUL= driver.findElement(By.xpath(ulELement));
			List<WebElement> vehicleLi = vehivcleUL.findElements(By.xpath(listItemELement));
			
			//assert Make
			assertEquals(vehicle.getMake().replaceAll("\\s", "").toLowerCase(), 
					vehicleLi.get(1).findElements(
							By.tagName("span")).get(1).getText().replaceAll("\\s", "").toLowerCase());
//			//assert colour
			assertEquals(vehicle.getColor().replaceAll("\\s", "").toLowerCase(), 
					vehicleLi.get(2).findElements(
							By.tagName("span")).get(1).getText().replaceAll("\\s", "").toLowerCase());
			
		});
        //Search for a given registration number
	}
   
	//This can be used for capturing screen
	private class ResultCaptureHelper {
		public void saveScreen(String screenshotFileName) throws IOException {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(screenshotFileName));
		}
	}
}
