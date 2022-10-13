package com.megagiganto.ypTrackerSpringBoot.test.web;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTestYarn {

	public WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}

	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
	}

	// Actual tests

	// Opening app and clicking link
	@Test(priority = 1)
	public void openAppClickLink() {
		driver.get("http://localhost:4200/");
		driver.findElement(By.id("yarnLink")).click();
	}

	// fail to submit yarn
	@Test(priority = 2)
	public void yarnInsertUnsuccessfully() {
		driver.findElement(By.id("ysize")).sendKeys("4");
		driver.findElement(By.id("ylength")).sendKeys("1.5");
		driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
		List<WebElement> yarnColor = driver.findElements(By.id("addedYarnColor"));
		Assert.assertEquals(yarnColor.size(), 0);
	}

	@Test(priority = 3)
	public void checkClearButton() {
		driver.findElement(By.id("ycolor")).sendKeys("red");
		driver.findElement(By.id("clear")).sendKeys(Keys.ENTER);

		WebElement yarnColor = driver.findElement(By.id("ycolor"));
		Assert.assertEquals(yarnColor.getText(), "");
	}

	// successfully submit yarn
	@Test(priority = 3)
	public void yarnInsertSuccessfully() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait until the submit button is ready
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		driver.findElement(By.id("ycolor")).sendKeys("red");
		driver.findElement(By.id("ysize")).sendKeys("4");
		driver.findElement(By.id("ylength")).sendKeys("1.5");
		driver.findElement(By.id("location")).sendKeys("basement shelves");
		driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);

		WebElement yarnColor = driver.findElement(By.id("addedYarnColor"));
		Assert.assertEquals(yarnColor.getText(), "red");
	}

	// edit yarn
	@Test(priority = 4)
	public void yarnUpdateSuccessfully() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// wait until the edit button is ready
		wait.until(ExpectedConditions.elementToBeClickable(By.id("editButton")));

		driver.findElement(By.id("editButton")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("ycolor")).sendKeys("orange");
		driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);

		// wait until the object is listed (the deleteButton is ready)
		wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteButton")));

		// assert that addedYarnColor has been changed to redorange
		WebElement yarnColor = driver.findElement(By.id("addedYarnColor"));
		Assert.assertEquals(yarnColor.getText(), "redorange");

	}

	// delete yarn
	@Test(priority = 5)
	public void yarnDelete() {
		// wait for "remove" to be clickable then click.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteButton")));
		removeButton.sendKeys(Keys.ENTER);
		// wait until submit is clickable then check the value of addedYarnColor, which
		// shouldn't exist
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		List<WebElement> yarnColor = driver.findElements(By.id("addedYarnColor"));
		Assert.assertEquals(yarnColor.size(), 0);

	}

}
