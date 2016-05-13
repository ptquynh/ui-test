 package com.tekexperts.pipeline.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.tekexperts.pipeline.common.readData.UserDatabase;

import static com.tekexperts.pipeline.common.TestLogger.*;


public class PipelineBase extends Configuration{
	
	
	public static String USER_ROOT = "6666";
	public static String USER_PASS = "Test@123456";
	public static String password="Test@123456";
	public static String USER_ROOT_FULLNAME =null;
	public static String USER_RANDOM_PASSWORD=null;
	public static String EMAIL_TEST="qatekexperts@gmail.com";
	public static String EMAIL_TEST_PASS="Test@123456";
	
	
	/**
	 * Get element
	 * @param locator
	 * @param opParams
	 * @return an element
	 */
	public WebElement getElement(Object locator, Object... opParams) {
		By by = locator instanceof By ? (By)locator : By.xpath(locator.toString());
		WebDriver wDriver;
		if(isDriver)
			wDriver = (WebDriver) (opParams.length > 0 ? opParams[0]: driver);
		else
			wDriver = (WebDriver) (opParams.length > 0 ? opParams[0]: newDriver);
		WebElement elem = null;
		try {
			elem = wDriver.findElement(by);
		} catch (NoSuchElementException e) {

		}
		return elem;
	}
	
	/**
	 * get an element
	 * @param locator
	 * @param opParams
	 * @return null
	 */
	public WebElement getDisplayedElement(Object locator, Object... opParams) {
		By by = locator instanceof By ? (By)locator : By.xpath(locator.toString());
		WebDriver wDriver;
		if(isDriver)
			wDriver = (WebDriver) (opParams.length > 0 ? opParams[0]: driver);
		else
			wDriver = (WebDriver) (opParams.length > 0 ? opParams[0]: newDriver);
		WebElement e = null;
		try {
			if(by != null)
				e = wDriver.findElement(by);
			if (e != null){
				if (isDisplay(by)) return e;
			}
		} catch (NoSuchElementException ex) {
		}catch(StaleElementReferenceException ex)
		{
			checkCycling(ex, 10);
			Utils.pause(WAIT_INTERVAL);
			getDisplayedElement(locator);
		}
		finally{
			loopCount=0;
		}
		return null;
	}

	/**
	 * verify element exists or not
	 * @param locator
	 * @return true if element exists
	 * 			false if element doesn't exist
	 */
	public boolean isElementPresent(Object locator) {
		return getElement(locator) != null;
	}

	/**
	 * verify element exists or not
	 * @param locator
	 * @return true if element doesn't exists
	 * 			false if element exist
	 */
	public boolean isElementNotPresent(Object locator) {
		return !isElementPresent(locator);
	}

	/**
	 * Get element
	 * @param locator
	 * 					locator of element
	 * @param opParams
	 * 					opPram[0]: timeout
	 * 					opPram[1]: 0,1
	 * 					0: No Assert
	 * 					1: Assert
	 * @return an element
	 */
	public WebElement waitForAndGetElement(Object locator, Object... opParams) {
		WebElement elem = null;
		int timeout = (Integer) (opParams.length>0 ? opParams[0] : DEFAULT_TIMEOUT);
		int isAssert = (Integer) (opParams.length > 1 ? opParams[1]: 1);
		int notDisplayE = (Integer) (opParams.length > 2 ? opParams[2]: 0);
		WebDriver wDriver;
		if(isDriver)
			wDriver = (WebDriver) (opParams.length > 3 ? opParams[3]: driver);
		else
			wDriver = (WebDriver) (opParams.length > 3 ? opParams[3]: newDriver);
		for (int tick = 0; tick < timeout/WAIT_INTERVAL; tick++) {
			if (notDisplayE == 2){
				elem = getElement(locator,wDriver);
			}else{
				elem = getDisplayedElement(locator,wDriver);
			}
			if (null != elem) return elem;
			Utils.pause(WAIT_INTERVAL);
		}
		if (isAssert == 1)
			assert false: ("Timeout after " + timeout + "ms waiting for element present: " + locator);
		info("cannot find element after " + timeout/1000 + "s.");
		return null;
	}

	/**
	 * Get element
	 * @param locator
	 * 					locator of element
	 * @param opParams
	 * 					opPram[0]: timeout
	 * 					opPram[1]: 0,1
	 * 					0: No Assert
	 * 					1: Assert
	 * @return	an element
	 */
	public WebElement waitForElementNotPresent(Object locator, int... opParams) {
		WebElement elem = null;
		int timeout = opParams.length > 0 ? opParams[0] : DEFAULT_TIMEOUT;
		int isAssert = opParams.length > 1 ? opParams[1]: 1;
		int notDisplayE = opParams.length > 2 ? opParams[2]: 0;

		for (int tick = 0; tick < timeout/WAIT_INTERVAL; tick++) {
			if (notDisplayE == 2){
				elem = getElement(locator);
				//elem = getDisplayedElement(locator);
			}else{
				elem = getDisplayedElement(locator);
			}
			if (null == elem) return null;
			Utils.pause(WAIT_INTERVAL);
		}

		if (isAssert == 1)
			assert false: ("Timeout after " + timeout + "ms waiting for element not present: " + locator);
		info("Element doesn't disappear after " + timeout/1000 + "s.");
		return elem;
	}

	/**
	 * 
	 * @param text
	 * @param opts
	 * @return 	true if text exist
	 * 			false if test is not exist
	 */
	public boolean isTextPresent(String text, int...opts) {
		int display = opts.length > 0 ? opts[0] : 1;
		Utils.pause(500);
		String allVisibleTexts = getText(By.xpath("//body"),display);
		return allVisibleTexts.contains(text);
	}

	/**
	 * get text of element
	 * @param locator
	 * @param opts
	 * @return text of element
	 */
	public String getText(Object locator,int...opts) {
		WebElement element = null;
		int display = opts.length > 0 ? opts[0] : 1;
		try {
			element = waitForAndGetElement(locator,DEFAULT_TIMEOUT,1,display);
			return element.getText();
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			return getText(locator);
		} finally {
			loopCount = 0;
		}
	}

	/**
	 * get list of element
	 * @param xpath
	 * @return list of elements
	 */
	public List<WebElement> getElements(String xpath) {
		try {
			return driver.findElements(By.xpath(xpath));
		} catch (StaleElementReferenceException e) {
			checkCycling(e, 5);
			Utils.pause(1000);
			return getElements(xpath);
		} finally {
			loopCount = 0;
		}
	}

	/**
	 * verify text exists or noet
	 * @param text
	 * @return true if text exists
	 * 			false if text doesn't exits
	 */
	public boolean isTextNotPresent(String text) {
		return !isTextPresent(text);
	}

	/**
	 * Click by using javascript
	 * @param locator
	 * @param opParams
	 */
	public void clickByJavascript(Object locator, Object... opParams){
		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0]: 0);	
		WebElement e = null;
		if(locator instanceof WebElement){
			e=(WebElement) locator;
		}
		else{
			info("wait and get element");
			e = waitForAndGetElement(locator,DEFAULT_TIMEOUT, 1, notDisplay);
		}
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", e);
	}
	/**
	 * Type by java script
	 * @param locatorById
	 * @param value
	 * @param opParams
	 */
	public void typeByJavascript(Object locatorById, String value,Object... opParams){
		Utils.pause(3000);
		((JavascriptExecutor)driver).executeScript("document.getElementById('"+locatorById+"').value='"+value+"'");
	}
	
	

	/**
	 * click action
	 * @param locator
	 * @param opParams
	 */
	public void click(Object locator, Object... opParams) {
		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0]: 0);	
		WebElement element = null;
		Actions actions = new Actions(driver);
		try {
			if(browser.contains("iexplorer")||browser.contains("chrome")){
				info("use javasript to click");
				clickByJavascript(locator, notDisplay);
			}
			else{
				if (!locator.getClass().getName().contains("WebElement")) {
					info("wait and get elements");
					element = waitForAndGetElement(locator, DEFAULT_TIMEOUT, 1, notDisplay);
				}
				else{
					element=(WebElement) locator;
				}
				if (browser.contains("chrome")) {
					scrollToElement(element, driver);
				}
				if(element.isEnabled()){
					info("click element");
					actions.click(element).perform();
				}
				else {
					info("Element is not enabled");
					info("click element by javascript");
					clickByJavascript(locator, notDisplay);
				}
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			info("click element by javascript");
			clickByJavascript(locator, notDisplay);
		} catch (ElementNotVisibleException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			info("click element by javascript");
			clickByJavascript(locator, notDisplay);
		} finally {
			loopCount = 0;
		}
		Utils.pause(1000);
	}


	/**
	 * clear cache
	 */
	public void clearCache(){
		Actions actionObject = new Actions(driver);
		try{
			actionObject.sendKeys(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
		} catch(WebDriverException e){	
			debug("Retrying clear cache...");
			actionObject.sendKeys(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
		}
	}

	/**
	 * Use this function to verify if a check-box is checked (using when creating a portal/publicMode)
	 * @param locator
	 * @param opParams
	 */
	public void check(Object locator, int... opParams) {
		int notDisplayE = opParams.length > 0 ? opParams[0]: 0;
		Actions actions = new Actions(driver);
		try {
			WebElement element = waitForAndGetElement(locator, DEFAULT_TIMEOUT, 1, notDisplayE);
			if (browser.contains("chrome")) {
				scrollToElement(element, driver);
			}
			if (!element.isSelected()) {
				actions.click(element).perform();
				if(waitForAndGetElement(locator, DEFAULT_TIMEOUT, 1, notDisplayE).getAttribute("type")!=null && waitForAndGetElement(locator, DEFAULT_TIMEOUT, 1, notDisplayE).getAttribute("type")!="checkbox"){
					info("Checkbox is not checked");
					if (!element.isSelected()) {
						info("check by javascript");
						waitForAndGetElement(locator, DEFAULT_TIMEOUT, 1, notDisplayE);
						//mouseOver(locator, true);
						clickByJavascript(locator, notDisplayE);
					}
				}
			} else {
				info("Element " + locator + " is already checked.");
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			check(locator, opParams);
		} finally {
			loopCount = 0;
		}
		Utils.pause(2000);
	}

	/**
	 * get value attribute
	 * @param locator
	 * @return value of element
	 */
	public String getValue(Object locator) {
		try {
			return waitForAndGetElement(locator).getAttribute("value");
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);			
			Utils.pause(WAIT_INTERVAL);
			return getValue(locator);
		} finally {
			loopCount = 0;
		}
	}

	/**
	 * Mouse hover by Javascript
	 * @param locator
	 * @param opParams
	 */
	public void mouseHoverByJavaScript(Object locator, Object...opParams)
	{
		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0]: 0);
		WebElement targetElement;
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		targetElement = waitForAndGetElement(locator,5000, 1, notDisplay);
		((JavascriptExecutor)driver).executeScript(mouseOverScript, targetElement);
	}

	/**
	 * mouse over action
	 * @param locator
	 * @param safeToSERE
	 * @param opParams
	 */
	public void mouseOver(Object locator, boolean safeToSERE, Object...opParams) {
		WebElement element;
		Actions actions = new Actions(driver);
		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0]: 0);
		try {
			if (safeToSERE) {
				for (int i = 1; i < ACTION_REPEAT; i++){
					if (!locator.getClass().getName().contains("WebElement")) {
						element = waitForAndGetElement(locator, 5000, 0, notDisplay);
					}
					else{
						element=(WebElement) locator;
					}
					if (element == null){
						Utils.pause(WAIT_INTERVAL);
					} else {
						actions.moveToElement(element).perform();
						break;
					}
				}
			} else {
				if (!locator.getClass().getName().contains("WebElement")) {
					element = waitForAndGetElement(locator);
				}
				else{
					element=(WebElement) locator;
				}
				actions.moveToElement(element).perform();
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			mouseOver(locator, safeToSERE);
		} finally {
			loopCount = 0;
		}
	}

	/**
	 * mouse over and clic
	 * @param locator
	 */
	public void mouseOverAndClick(Object locator) {
		WebElement element;
		Actions actions = new Actions(driver);
		if (ieFlag) {
			element = getDisplayedElement(locator);
		} else {
			element = waitForAndGetElement(locator);
		}
		actions.moveToElement(element).click(element).build().perform();
	}

	/**
	 * wait for text present
	 * @param text
	 * @param opts
	 */
	public void waitForTextPresent(String text, int...opts) {
		int waitTime = opts.length > 0 ? opts[0] : DEFAULT_TIMEOUT;
		int display = opts.length > 1 ? opts[1] : 1;
		for (int second = 0;; second++) {
			if (second >= waitTime/WAIT_INTERVAL) {
				Assert.fail("Timeout at waitForTextPresent: " + text);
			}
			if (isTextPresent(text,display)) {
				break;
			}
			Utils.pause(WAIT_INTERVAL);
		}
	}

	/**
	 * wait for text not present
	 * @param text
	 * @param wait
	 */
	public void waitForTextNotPresent(String text,int...wait) {
		int waitTime = wait.length > 0 ? wait[0] : DEFAULT_TIMEOUT;
		for (int second = 0;; second++) {
			if (second >= waitTime/WAIT_INTERVAL) {
				Assert.fail("Timeout at waitForTextNotPresent: " + text);
			}
			if (isTextNotPresent(text)) {
				break;
			}
			Utils.pause(WAIT_INTERVAL);
		}
	}

	/**
	 * wait for msg
	 * @param message
	 * @param wait
	 */
	public void waitForMessage(String message,int...wait) {
		int waitTime = wait.length > 0 ? wait[0] : DEFAULT_TIMEOUT;
		Utils.pause(500);
		waitForAndGetElement("//*[contains(text(),'"+message+"')]",waitTime);
	}

	/**
	 * type to textbox
	 * @param locator
	 * @param value
	 * @param validate
	 * @param opParams
	 */
	public void type(Object locator, String value, boolean validate, Object...opParams) {	
		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0]: 0);
		try {
			for (int loop = 1;; loop++) {
				if (loop >= ACTION_REPEAT) {
					Assert.fail("Timeout at type: " + value + " into " + locator);
				}
				WebElement element = waitForAndGetElement(locator, DEFAULT_TIMEOUT, 1, notDisplay);		
				if (element != null){
					if (validate) element.clear();
					element.click();
					element.sendKeys(value);
					if (!validate || value.equals(getValue(locator))) {
						break;
					}
				}
				info("Repeat action..." + loop + "time(s)");
				Utils.pause(WAIT_INTERVAL);
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			type(locator, value, validate, opParams);
		} catch (ElementNotVisibleException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			type(locator, value, validate, opParams);
		} finally {
			loopCount = 0;
		}
	}

	/**
	 * Select option from combo box
	 * @param locator
	 * @param option
	 * @param display
	 */
	public void select(Object locator, String option, int...display) {
		int isDisplay = display.length > 0 ? display[0] : 1;
		try {
			for (int second = 0;; second++) {
				if (second >= DEFAULT_TIMEOUT/WAIT_INTERVAL) {
					Assert.fail("Timeout at select: " + option + " into " + locator);
				}
				Select select = new Select(waitForAndGetElement(locator,DEFAULT_TIMEOUT,1,isDisplay));
				select.selectByVisibleText(option);
				if (option.equals(select.getFirstSelectedOption().getText())) {
					break;
				}
				Utils.pause(WAIT_INTERVAL);
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			selectNotByOption(locator, option);
		} finally {
			loopCount = 0;
		}
		Utils.pause(500);
	}
	/**
	 * Select an element has [span] droplist type
	 * @param locatorField
	 * @param locatorItem
	 * @param option
	 */
	public void selectNotByOption(Object locatorField,Object locatorItem) {
		try {
			for (int second = 0;; second++) {
				if (second >= DEFAULT_TIMEOUT/WAIT_INTERVAL) {
					Assert.fail("Timeout at select: " + locatorItem);
				}
				WebElement field=waitForAndGetElement(locatorField,DEFAULT_TIMEOUT,1);
				field.click();
				WebElement el =waitForAndGetElement(locatorItem,DEFAULT_TIMEOUT,1);
                el.click();
				 if (field.getText().equals(el.getText())|| field.getText().contains(el.getText())) {
						break;
					}
				Utils.pause(WAIT_INTERVAL);
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			selectNotByOption(locatorField,locatorItem);
		} finally {
			loopCount = 0;
		}
		Utils.pause(500);
	}

	/**
	 * un-check a checked-box
	 * @param locator
	 * @param opParams
	 */
	public void uncheck(Object locator, int... opParams) {
		int notDisplayE = opParams.length > 0 ? opParams[0]: 0;
		Actions actions = new Actions(driver);
		try {
			WebElement element = waitForAndGetElement(locator, DEFAULT_TIMEOUT, 1, notDisplayE);

			if (element.isSelected()) {
				actions.click(element).perform();
				if (element.isSelected()) {
					info("uncheck by javascript");
					waitForAndGetElement(locator, DEFAULT_TIMEOUT, 1, notDisplayE);
					clickByJavascript(locator, notDisplayE);
				}
			} else {
				info("Element " + locator + " is already unchecked.");
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, 5);
			Utils.pause(1000);
			uncheck(locator, opParams);
		} finally {
			loopCount = 0;
		}
		Utils.pause(2000);
	}

	/**
	 * rightClickOnElement
	 * @param locator
	 * @param opParams
	 */
	public void rightClickOnElement(Object locator, int...opParams) {
		int display = opParams.length > 0 ? opParams[0]: 0;
		Actions actions = new Actions(driver);
		Utils.pause(500);
		try {
			WebElement element = waitForAndGetElement(locator,DEFAULT_TIMEOUT,1,display);
			actions.contextClick(element).perform();
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			rightClickOnElement(locator);
		} catch (ElementNotVisibleException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			click(locator);
		} finally {
			loopCount = 0;
		}
	}

	/**
	 * doubleClickOnElement
	 * @param locator
	 */
	public void doubleClickOnElement(Object locator) {
		Actions actions = new Actions(driver);
		WebElement element;
		try {
			if (!locator.getClass().getName().contains("WebElement")) {
				element = waitForAndGetElement(locator);
			}
			else{
				element=(WebElement) locator;
			}
			actions.doubleClick(element).perform();
		} catch (StaleElementReferenceException e) {
			checkCycling(e, 5);
			Utils.pause(1000);
			doubleClickOnElement(locator);
		} finally {
			loopCount = 0;
		}
	}

	/**
	 * checkCycling
	 * @param e
	 * @param loopCountAllowed
	 */
	public void checkCycling(Exception e, int loopCountAllowed) {
		info("Exception:" + e.getClass().getName());
		if (loopCount > loopCountAllowed) {
			Assert.fail("Cycled: " + e.getMessage());
		}
		info("Repeat... " + loopCount + "time(s)");
		loopCount++;
	}

	/**
	 * function to switch to parent windows
	 */
	public void switchToParentWindow (){
		try
		{
			Set<String> availableWindows = driver.getWindowHandles();
			String WindowIdParent= null;
			int counter = 1;
			for (String windowId : availableWindows) {
				if (counter == 1){
					WindowIdParent = windowId;
				}
				counter++;
			}
			driver.switchTo().window(WindowIdParent);
			Utils.pause(1000);
		}
		catch (WebDriverException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * check element displays or net
	 * @param locator
	 * @return true if element displays
	 * 			false if element doesn't display
	 */
	public boolean isDisplay(Object locator) {
		boolean bool = false;
		WebElement e = getElement(locator);
		try{
			if (e!=null)
				bool = e.isDisplayed();
		}catch(StaleElementReferenceException ex)
		{
			checkCycling(ex, 10);
			Utils.pause(WAIT_INTERVAL);
			isDisplay(locator);
		}
		finally{
			loopCount=0;
		}
		return bool;
	}

	/**
	 * function set driver to auto open new window when click link
	 */
	public void getDriverAutoOpenWindow(){
		FirefoxProfile fp = new FirefoxProfile();		
		fp.setPreference("browser.link.open_newwindow.restriction", 2);
		driver = new FirefoxDriver(fp);
		baseUrl = System.getProperty("baseUrl");
		if (baseUrl==null) baseUrl = DEFAULT_BASEURL;
		action = new Actions(driver);
	}

	/**
	 * function: check a file existed in folder
	 * @param file file name (eg: export.zip)
	 * @return true -> file exist
	 * false-> file is not exist
	 */
	public boolean checkFileExisted(String file){
		String pathFile = System.getProperty("user.dir") + "/src/main/resources/TestData/" + file;
		boolean found = false;

		if (new File(pathFile).isFile()){
			found = true;
		}
		info("File exists: " + file + " is " + found);
		return found;
	}

	/**
	 * function get current Date of system follow a format
	 * @param format
	 * @return current Date of system
	 */
	public String getCurrentDate(String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return (dateFormat.format(date)); 
	}
	/**
	 * Get current date with time zone
	 * @param format
	 * @param local
	 * @return current Date with correct time zone
	 */
	public String getCurrentDate(String format,String local){
		DateFormat df = new SimpleDateFormat(format);
		Date date = new Date();
		df.setTimeZone(TimeZone.getTimeZone(local));
		System.out.println("Date and time in"+local+": " + df.format(date));
		return df.format(date);
	}

	/**
	 * Add 1 minute to current date time
	 * @param min
	 * @param format
	 * @return (dateFormat.format(cal.getTime()))
	 */
	public String addMinuteToCurrentDateTime(int min, String...format){
		DateFormat dateFormat = format.length > 0 ? new SimpleDateFormat(format[0]) : new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, min);
		return (dateFormat.format(cal.getTime()));	
	}

	/**
	 * Get date in format "dd"
	 * @param gap
	 * @param format
	 * @return (dateFormat.format(cal.getTime()))
	 */
	public String getDate(int gap, String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, gap);
		info(dateFormat.format(cal.getTime()));
		return (dateFormat.format(cal.getTime()));	
	}
	/**
	 * Get date from firstDayOf Week
	 * @param gap
	 * @param format
	 * @return getDateFromFirstDayOfWeek
	 */
	public String getDateFromFirstDayOfWeek(int gap, String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, 2);
		calendar.add(Calendar.DAY_OF_MONTH, gap);
		String getDateFromFirstDayOfWeek = dateFormat.format(calendar.getTime());
		info("getDateFromFirstDayOfWeek:"+getDateFromFirstDayOfWeek);
		return getDateFromFirstDayOfWeek;
	}

	/**
	 * Get day of week
	 * @param gap
	 * @return cal.get(Calendar.DAY_OF_WEEK)
	 */
	public int getDayOfWeek(int gap){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, gap);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * Get day of the next month
	 * @param format
	 * @param dayNum
	 * @param weekNum
	 * @return dayOfNextMonth
	 */
	public String getDayOfNextMonth(String format,int dayNum,int weekNum){
	   DateFormat dateFormat = new SimpleDateFormat(format);
	   Calendar calendar = Calendar.getInstance();
	   
	   Calendar nextMonth = Calendar.getInstance();
	   nextMonth.setTime(calendar.getTime());
	   nextMonth.add(Calendar.DAY_OF_WEEK_IN_MONTH,weekNum);
	   nextMonth.add(Calendar.DAY_OF_MONTH,dayNum);
	   String dayOfNextMonth= dateFormat.format( nextMonth.getTime());
	   System.out.println("dayOfNextMonth:"+dayOfNextMonth);
	   return dayOfNextMonth;
	 
	}
	/**
	 * Get the day of next year
	 * @param format
	 * @param year
	 * @return dayOfYear
	 */
	public String getDayOfNextYear(String format,int year){
	   DateFormat dateFormat = new SimpleDateFormat(format);
	   Calendar calendar = Calendar.getInstance();
	   
	   Calendar nextYear = Calendar.getInstance();
	   nextYear.setTime(calendar.getTime());
	   nextYear.add(Calendar.YEAR,year);
	   nextYear.add(Calendar.MONTH,12);
	   String dayOfYear= dateFormat.format(nextYear.getTime());
	   System.out.println("dayOfYear:"+dayOfYear);
	   return dayOfYear;
	}
	/**
	 * Get the day of next week
	 * @param format
	 * @return dayOfNextWeek
	 */
	public String getDayOfNextWeek(String format){
	   DateFormat dateFormat = new SimpleDateFormat(format);
	   Calendar calendar = Calendar.getInstance();
	   String dayOfNextMonth1= dateFormat.format(  calendar.getTime());
	   System.out.println("dayOfNextMonth1:"+dayOfNextMonth1);
	   
	   Calendar nextWeek = Calendar.getInstance();
	   nextWeek.setTime(calendar.getTime());
	   nextWeek.add(Calendar.DATE,7);
	   String dayOfNextWeek= dateFormat.format(nextWeek.getTime());
	   return dayOfNextWeek;
		 
		}
	/**
	 * Get the number of current week
	 * @return weekNum
	 */
	public int getWeekNumber(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * Get the day of a week
	 * @return day
	 */
	public int getDayNumber(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.DATE);
	}
	/**
	 * Get current month/day/year
	 * @param format as MMM for month, dd for day, or yyyy for year
	 * @return dateFormat.format(now.getTime())
	 */
	public String getCurrentMonthDayYear(String format){
		DateFormat dateFormat = new SimpleDateFormat (format);
		Calendar now = Calendar.getInstance();
		return dateFormat.format(now.getTime());
	}
	/**
	 * Get minute in format "mm" from current date
	 * @return minute
	 * 
	 */
	public int getMinute(){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date); 
		int minute = cal.get(Calendar.MINUTE);
		return (minute); 
	}

	/**
	 * get random string
	 * @return random string
	 */
	public String getRandomString(){
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * get a list of random numbers
	 * @return random numbers
	 */
	public String getRandomNumber() {
		char[] chars = "0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}


	/**
	 * Get minute in format "HH" from current date
	 * @return minute
	 * 
	 */
	public int getHours(){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date); 
		int minute = cal.get(Calendar.HOUR);
		return (minute); 
	}

	/**
	 * @param object
	 * @return = true: if there is not scroll bar on element
	 *         = false: if there is scroll bar on element
	 */
	public boolean checkExitScrollBar(By object){
		WebElement element = waitForAndGetElement(object);
		String scrollHeight = String.valueOf(((JavascriptExecutor)driver).executeScript("return arguments[0].scrollHeight;", element));
		String offsetHeight = String.valueOf(((JavascriptExecutor)driver).executeScript("return arguments[0].offsetHeight;", element));
		info("scrollHeight: " + scrollHeight);
		info("offsetHeight: " + offsetHeight);
		int scroll = Integer.parseInt(scrollHeight);
		int offset = Integer.parseInt(offsetHeight);
		return scroll == offset;
	}

	/**
	 * function get an element from link text when cannot get by text in xpath
	 * @param text
	 * @return an element from link text
	 */
	public WebElement getElementFromTextByJquery(String text){

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Utils.pause(2000);
		try{
			WebElement web = (WebElement) js.executeScript("return $(\"a:contains('" + text + "')\").get(0);");
			return web;
		}catch(org.openqa.selenium.WebDriverException e){
			WebElement web = (WebElement) js.executeScript("return $(\"a:contains('" + text + "')\").get(0);");
			return web;
		}
	}

	/**
	 * scrollBarToGetElement
	 * @param object
	 * @param opParams
	 */
	public void scrollBarToGetElement(By object, int...opParams) {
		int display = opParams.length > 0 ? opParams[0]: 0;
		WebElement element = waitForAndGetElement(object,5000,1,display);
		JavascriptExecutor jse;
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * This function returns a absolute path from a relative path
	 * @param relativeFilePath
	 */
	public String getAbsoluteFilePath(String relativeFilePath){
		String fs = File.separator;
		String curDir = System.getProperty("user.dir");
		String absolutePath = curDir + "/src/main/resources/" + relativeFilePath;
		absolutePath=absolutePath.replace("/", fs).replace("\\", fs);;
		return absolutePath;
	}


	/**
	 * Download file using Robot class
	 * @param element
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void downloadFileUsingRobot(WebElement element) throws AWTException, InterruptedException {
		info("Upload file using Robot");
		Robot robot = new Robot();

		// Get the focus on the element..don't use click since it stalls the driver         
		element.sendKeys("");

		//simulate pressing enter           
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Wait for the download manager to open           
		Utils.pause(2000);
		// Switch to download manager tray via Alt+N
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_ALT);

		// Press S key to save           
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		Thread.sleep(2000);

		// Switch back to download manager tray via Alt+N
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_ALT);

		// Tab to X exit key
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		// Press Enter to close the Download Manager
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * Download file using Robot class via URL download link
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void downloadFileUsingRobotViaURL() throws AWTException, InterruptedException {
		info("Upload file using Robot");
		Robot robot = new Robot();

		//simulate pressing enter           
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Wait for the download manager to open           
		Utils.pause(2000);
		// Switch to download manager tray via Alt+N
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_ALT);

		// Press S key to save           
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		Thread.sleep(2000);

		// Switch back to download manager tray via Alt+N
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_ALT);

		// Tab to X exit key
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		// Press Enter to close the Download Manager
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}


	/**
	 * setClipboardData
	 * @param string
	 */
	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	/**
	 * uploadFileUsingRobot
	 * @param fileLocation
	 */
	public void uploadFileUsingRobot(String fileLocation) {
		Utils.pause(3000);
		info("Upload file using Robot");
		String fs = File.separator;
		String path=getAbsoluteFilePath(fileLocation.replace("/", fs));
		info("path in uploadRobot:"+path);
		try {
			Robot robot = new Robot();
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_X);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_X);
			//Setting clipboard with file location
			setClipboardData(path);
			//native key strokes for CTRL, V and ENTER keys

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Utils.pause(1000);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
	
	/**
	 *  This function returns a absolute path from a relative path that get from excel file
	 * @param relativeFilePath
	 * @return absolutePath
	 */
	public static String getAbsoluteFilePathFromFile(String relativeFilePath) {
		String curDir = System.getProperty("user.home");
		String absolutePath = curDir + relativeFilePath;
		info("absolutePath:" + absolutePath);
		return absolutePath;
	}
	
	/**
	 * uploadFileUsingRobot using for Document preview
	 * @param fileLocation
	 */
	public void uploadFileUsingRobotDocumentPreview(String fileLocation) {
		Utils.pause(3000);
		info("Upload file using Robot");
		String fs = File.separator;
		//String path=getAbsoluteFilePath(fileLocation.replace("/", fs));
		String path=getAbsoluteFilePathFromFile(fileLocation.replace("/", fs));
		info("path in uploadRobot:"+path);
		try {
			Robot robot = new Robot();
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_X);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_X);
			//Setting clipboard with file location
			setClipboardData(path);
			//native key strokes for CTRL, V and ENTER keys

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Utils.pause(1000);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
	/**
	 * Get date by text format
	 * ex. Saturday, Febuary 16, 2015
	 * @param format
	 */
	public String getDateByTextFormat(String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		info(date);
		return date;
	}
	/**
	 * Get first day of week
	 * @param format
	 * @return firstDayOfWeek
	 */
	public String getFirstDayOfWeek(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, 2);
		String firstDayOfWeek = dateFormat.format(calendar.getTime());
		info("firstDayOfWeek:"+firstDayOfWeek);
		return firstDayOfWeek;
	}

	/**
	 * Get last day of week
	 * @param format
	 * @return lastDayOfWeek
	 */
	public String getLastDayOfWeek(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar currentDate = Calendar.getInstance();
		int firstDayOfWeek = currentDate.getFirstDayOfWeek();

		Calendar startDate = Calendar.getInstance();
		startDate.setTime(currentDate.getTime());
		int days = (startDate.get(Calendar.DAY_OF_WEEK) + 7 - firstDayOfWeek) % 7;
		startDate.add(Calendar.DATE, -days);

		Calendar endDate = Calendar.getInstance();
		endDate.setTime(startDate.getTime());
		endDate.add(Calendar.DATE, 5);
		String lastDayOfWeek = dateFormat.format(endDate.getTime());
		info("lastDayOfWeek:"+lastDayOfWeek);
		return lastDayOfWeek;
	}
	/**
	 * Scroll to a element on the website
	 * @param element
	 * @param driver
	 */
	public static void scrollToElement(WebElement element, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	/**
	 * Scroll to bottom of the page of website
	 * @param driver
	 */
	public static void scrollToBottomPage(WebDriver driver){
		info("Scroll to the bottom of the page");
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight," +
        "document.body.scrollHeight,document.documentElement.clientHeight));");
	}

	/**
	 *This function will try to get an element. if after timeout, the element is not found.
	 *The function will refresh the page and find the element again.
	 * @param element
	 * @param isClicked
	 */
	public void waitElementAndTryGetElement(Object element,Boolean... isClicked){
		info("-- Starting finding element --");
		Utils.pause(500);
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				if(waitForAndGetElement(element,3000,0)!=null);
				break;
			}
			if (waitForAndGetElement(element, 5000, 0) != null){
				info("Element "+element+" is displayed");
				if(isClicked.length>0 && isClicked[0]==true)
					click(element);
				break;
			}
			info("Retry...[" + repeat + "]");
			this.driver.navigate().refresh();
		}
		Utils.pause(2000);
		info("The elemnt is shown successfully");
	}
	
	/**
	 * Check if a checkbox is checked or not
	 * @param checkedElement
	 * @return true
	 */
	public boolean checkCheckBoxAttribute(String checkedElement){
		info("Check checkbox attribute");
		WebElement checkBox= waitForAndGetElement(checkedElement,2000,2,1);
		if (checkBox != null && !checkBox.isSelected()) {
			info("Checkbox is NOT selected");
			return false;
		} else if (checkBox != null && checkBox.isSelected()){
			info("Checkbox IS SELECTED");
			return true;
		}
		
		return false;
	}
	/**
	 * Get username and password
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public static void getDefaultUserPass(String userDataFile, String userSheet, Object... opParams) throws Exception{
		info("Get deault user pass from data driven");
		UserDatabase userData = new UserDatabase();
		userData.setUserData(userDataFile,userSheet,opParams);
        USER_ROOT=userData.hpid.get(0);
        USER_PASS=userData.password.get(0);
        USER_ROOT_FULLNAME = userData.fullname.get(0);
	}	
}
