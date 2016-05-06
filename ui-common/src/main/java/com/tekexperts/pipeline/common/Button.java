package com.tekexperts.pipeline.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class provides simple way to manage all type of buttons
 *
 */
public class Button extends PipelineBase{

	public Button(WebDriver dr,String...plfVersion) {
		this.driver = dr;
	}
	/**
	 * Click on action button as(yes, no, cancel, save...)
	 * @param action_button
	 */
	public void action(By action_button) {
		waitForAndGetElement(action_button);
		click(action_button);
		Utils.pause(500);
	}
}
