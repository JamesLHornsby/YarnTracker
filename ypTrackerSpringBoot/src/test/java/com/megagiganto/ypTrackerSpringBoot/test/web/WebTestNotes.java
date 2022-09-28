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

public class WebTestNotes {

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
		driver.get("http://www.localhost:8080/ypTracker/");
		driver.findElement(By.id("addNoteLink")).click();
	}

	// successfully submit note
	@Test(priority = 2)
	public void yarnInsertSuccessfully() {
		driver.findElement(By.id("note1")).sendKeys("Here is a note!");
		driver.findElement(By.id("submit")).click();
		
		//check the results
		WebElement noteResult = driver.findElement(By.id("noteResult"));
		String expected = "Your note is: Here is a note!";
		Assert.assertEquals(noteResult.getText(), expected);
	}

	//check the results on the view notes page
	@Test(priority=3)
	public void viewResultsOnViewNotesPage() {
		driver.findElement(By.id("viewNoteLink")).click();
		WebElement noteContents = driver.findElement(By.id("noteContents"));
		String expected = "Here is a note!";
		Assert.assertEquals(noteContents.getText(), expected);
	}


}
