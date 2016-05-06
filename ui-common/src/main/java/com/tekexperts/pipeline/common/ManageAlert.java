package com.tekexperts.pipeline.common;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ManageAlert extends PipelineBase{

	public ManageAlert(WebDriver dr,String...plfVersion){
		driver = dr;
	}

	Button button = new Button(driver);

	//ECMS > Symlink
	public final By ELEMENT_ALERT = By.xpath("//*[contains(@class, 'popupTitle') and contains(text(), 'Warning')]");
	public final By ELEMENT_MESSAGE = By.xpath("//*[contains(@class, 'warningIcon')]");
	public final By ELEMENT_INFO = By.xpath("//*[contains(@class, 'infoIcon')]");
	public final By ELEMENT_CONFIRM = By.xpath("//*[contains(@class, 'confirmationIcon')]");

	/**
	 * accept alert
	 */
	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			switchToParentWindow();
		} catch (NoAlertPresentException e) {
		}
		Utils.pause(1000);
	}

	/**
	 * Cancel alert
	 */
	public void cancelAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			switchToParentWindow();
		} catch (NoAlertPresentException e) {
		}
		Utils.pause(1000);
	}

	/**
	 * Get text from alert
	 * @return text from alert
	 */
	public String getTextFromAlert() {
		Utils.pause(1000);
		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			return "";
		}
	}

	/**
	 * wait for confirmation
	 * @param confirmationText
	 * @param wait
	 * 				wait[0]: timeout
	 */
	public void waitForConfirmation(String confirmationText,int...wait) {
		String message = getTextFromAlert();
		System.out.println(message);
		System.out.println(confirmationText);
		int timeOut = wait.length > 0 ? wait[0] : DEFAULT_TIMEOUT;
		if (message.isEmpty()) {
			if (loopCount > timeOut/500) {
				Assert.fail("Message is empty");
			}
			Utils.pause(500);
			loopCount++;
			waitForConfirmation(confirmationText);
			return;
		}

		for (int second = 0;; second++) {
			if (second >= timeOut) {
				Assert.fail("Timeout at waitForConfirmation: " + confirmationText);
			}
			if (message.contains(confirmationText)) {
				break;
			}

			Utils.pause(100);
		}
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Utils.pause(3000);
	}

	/**
	 * Input Alert Text
	 * @param text
	 */
	public void inputAlertText(String text){
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
			alert.accept();
			switchToParentWindow();
		} catch (NoAlertPresentException e) {
		}
		Utils.pause(1000);
	}
}