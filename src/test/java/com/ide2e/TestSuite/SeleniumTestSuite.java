package com.ide2e.TestSuite;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestSuite {
	private String applicationUrl;
	private WebDriver driver;
	private ResultCaptureHelper recordResult;
	private final String geokoDriverLocation = "/Users/ravisingh/Projects/TestAutomation/chromedriver";
	private final String startButton = "//a[@class='pub-c-button pub-c-button--start']";

	@Before
	public void openBrowser() {
		initWebDriver();
		applicationUrl = "https://www.gov.uk/get-vehicle-information-from-dvla";
		driver.get(applicationUrl);
		recordResult = new ResultCaptureHelper();
	}

	@After
	public void saveTestResultScreen() throws IOException {
	}

	private void initWebDriver() {
		// configure can be externalised.
		System.setProperty("webdriver.chrome.driver", geokoDriverLocation);
		driver = new ChromeDriver();
	}

	@Test
	public void testExecute() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(startButton)).click();
	}

	private class ResultCaptureHelper {
		public void saveScreen(String screenshotFileName) throws IOException {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(screenshotFileName));
		}
	}
}
