package com.aucdt.edu.util;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtil {
	private static final Logger LOGGER = LogManager.getLogger(SeleniumUtil.class);
	public static boolean driverStatus = false;
	private static SeleniumUtil web;
	private static WebDriver driver = null;
	private static Properties configProperties;
	private static final String configFile = System.getProperty("user.dir")
			+ "//src//test//resources//config//Config.properties";
	private static String screenShotFolder = System.getProperty("user.dir") + "//src//test//resources//ExtendReportSnap//";
	public static int waitBrowserSync;
	public static int waitWebElementSync;

	static {
		LOGGER.info("Inside static block");
		configProperties = new Properties();
		try {
			FileInputStream fisConfig = new FileInputStream(configFile);
			configProperties.load(fisConfig);
			waitBrowserSync = Integer.parseInt(configProperties.getProperty("BrowserSync"));
			waitWebElementSync = Integer.parseInt(configProperties.getProperty("WebElementSync"));
			if (System.getProperty("Browser") == null) {
				System.setProperty("Browser", configProperties.getProperty("Browser"));
			}

		} catch (Exception e) {
			LOGGER.info("!!!!!!!!!!!!!!!!!!!!Inside catch block" + e.getMessage());

		}
	}

	private SeleniumUtil() {
	}

	public static SeleniumUtil getInstance() {
		if (web == null) {
			web = new SeleniumUtil();
		}
		return web;
	}

	public static WebDriver getDriver() {
		if (driver == null) {

			if ("firefox".equalsIgnoreCase(System.getProperty("Browser"))) {
				LOGGER.info("Inside Firefox browser initialization");
			    WebDriverManager.firefoxdriver().setup();
			    
				driver = new FirefoxDriver();
				driverStatus = true;
				LOGGER.debug("FireFox Browser launched successfully");
			}else if ("IE".equalsIgnoreCase(System.getProperty("Browser"))) {
				LOGGER.info("Inside IE browser initialization");
				WebDriverManager.iedriver().setup();

				driver = new InternetExplorerDriver();
				driverStatus = true;
				LOGGER.debug("IE Browser launched successfully");
			}else if ("Chrome".equalsIgnoreCase(System.getProperty("Browser"))) {
				if("docker".equalsIgnoreCase(System.getProperty("Remote"))) {
					//System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
					WebDriverManager.chromedriver().setup();
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("headless");  
					//chromeOptions.addArguments("--proxy-server='direct://'");
					//chromeOptions.addArguments("--proxy-bypass-list=*");
					//driver = new ChromeDriver(chromeOptions);
					
					
					  try { driver = new RemoteWebDriver(new
					  java.net.URL("http://localhost:4444/wd/hub"),chromeOptions); } catch
					  (MalformedURLException e) { // TODO Auto-generated catch block
					  e.printStackTrace(); }
					 
					 
					driverStatus = true;
				}else {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					driverStatus = true;
				}
				
			}else if ("Edge".equalsIgnoreCase(System.getProperty("Browser"))){
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driverStatus = true;
			}

		}
		return driver;
	}

	/**
	 * method is used for...... return type is void
	 * 
	 * @param setDriver
	 */
	public static void setDriver(WebDriver setDriver) {
		LOGGER.info("Inside setDriver Method");
		driver = setDriver;
		driverStatus = false;
	}

	public static void maximizeBrowser() {
		LOGGER.info("Inside maximizeBrowser Method");
		driver.manage().window().maximize();

	}

	public static void launchApplication() {
		LOGGER.info("Inside launchApplication Method");
		driver.get(SeleniumUtil.getConfigProperties().getProperty("IntroductionPageUrl"));
	}

	public static void launchApplication(String url) {
		LOGGER.info("Inside launchApplication with url Method");
		driver.get(url);
	}

	public static Properties getConfigProperties() {
		LOGGER.info("Inside getConfigProperties Method");
		return configProperties;
	}

	public static WebElement getWebElement(By by) {
		LOGGER.debug("inside getWebElement");
		
		WebElement webElement = driver.findElement(by);
		return webElement;
	}

	public static List<WebElement> getWebElements(By by) {
		LOGGER.debug("inside getWebElement by method");
		List<WebElement> webElements = driver.findElements(by);
		return webElements;
	}

	public static void takeScreenShot() throws IOException {
		LOGGER.debug("inside takeScreenShot method");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-sss");
		String strDate = formatter.format(date);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scrFile, new File(screenShotFolder + "//ScreenShot" + strDate));
	}

	public static String getSimpleDateFormate(Date date, String formate) {
		LOGGER.debug("inside getSimpleDateFormate method");
		SimpleDateFormat formatter = new SimpleDateFormat(formate);
		String strDate = formatter.format(date);
		return strDate;
	}

	public static String getTitle() {
		return driver.getTitle();
	}

	public static void closeBrowser() {
		LOGGER.info("############################# Inside CloseBrowser #############################");
		driver.close();
		driver.quit();
		LOGGER.debug("###################   Closed Browser #############################");
	}

	public static void quitBrowser() {
		LOGGER.info("inside quitBrowser method");
		driver.quit();
	}

	public static void ImplicitWait() {

		LOGGER.info(" print the sysc time " + waitBrowserSync);
		driver.manage().timeouts().implicitlyWait(waitBrowserSync, TimeUnit.SECONDS);

	}

	public static void switchFrameExplicitWait(String frame, int wait) {
		LOGGER.info("inside switchFrame method");
		objExplicitWait(wait)
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath(frame))));

	}
	public static void switchFrame(WebElement frame) {
		LOGGER.info("inside switchFrame method");
		driver.switchTo().frame(frame);

	}

	public static void switchToDefaultContent() {
		LOGGER.info("inside switchToDefaultContent method");
		driver.switchTo().defaultContent();
	}

	public static void cleanFolder(String folder) {
		LOGGER.info("delete log from logs folder");
		File file = new File(System.getProperty("user.dir") + "//" + folder + "//");
		for (File file1 : file.listFiles()) {

			file1.delete();
			LOGGER.debug("Logs deleted");
		}

	}

	public static WebDriverWait objExplicitWait(int wait) {
		LOGGER.info("Inside objExplicitWait method");
		WebDriverWait explicitWait = new WebDriverWait(driver, wait);
		return explicitWait;
	}

	public static void validateWebElementPresence(By by, int wait) {
		LOGGER.info("Inside ValidateWebElementPresence method");
		objExplicitWait(wait).until(ExpectedConditions.presenceOfElementLocated(by));

	}

	public static void validateWebElementVisible(By by, int wait) {
		LOGGER.info("Inside ValidateWebElementPresence method");
		objExplicitWait(wait).until(ExpectedConditions.visibilityOfElementLocated(by));

	}
	
	public static void validateWebElementNotVisible(By by, int wait) {
		LOGGER.info("Inside ValidateWebElementPresence method");
		objExplicitWait(wait).until(ExpectedConditions.invisibilityOfElementLocated(by));
		

	}

	public static void waitWebElementClickable(By by, int wait) {
		LOGGER.info("Inside ValidateWebElementPresence method");
		objExplicitWait(wait).until(ExpectedConditions.elementToBeClickable(by));

	}

	public static void selectWebList(By by, String val, String selectBy) {
		LOGGER.info("Inside selectWebList");
		WebElement wb = driver.findElement(by);
		Select sel = new Select(wb);

		switch (selectBy) {
		case "selectByVisibleText":
			sel.selectByVisibleText(val);
			LOGGER.debug("Selected by-" + selectBy);
			break;
		case "selectbyIndex":
			sel.selectByIndex(Integer.parseInt(val));
			LOGGER.debug("Selected by-" + selectBy);
			break;

		case "SelectByvalue":// or 2+3
			sel.selectByValue(val);
			LOGGER.debug("Selected by-" + selectBy);
			break;

		default:
			LOGGER.info("Proper Value not selected");

		}

	}

	public static void robotSendKeys(int keyCode) throws Throwable {
		LOGGER.info("Inside robotSendKeys Method");
		Robot robot = new Robot();
		robot.keyPress(keyCode);
		robot.keyRelease(keyCode);

	}

	public static void selectItemWebTable(By by, int columnfirst, int columnSecond, String firstvalue,
			String secondvalue, String selectValue) {
		LOGGER.info("inside selectItemWebTable method");
		WebElement table = driver.findElement(by);
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement eachRow : rows) {
			List<WebElement> columns = eachRow.findElements(By.tagName("td"));

			if ((columns.get(columnfirst).findElement(By.tagName("a")).getText()).contains(firstvalue)
					&& (columns.get(columnSecond).findElement(By.tagName("a")).getText()).contains(secondvalue)) {

				WebElement wb = columns.get(6).findElement(By.tagName("select"));
				Select sel = new Select(wb);
				sel.selectByVisibleText(selectValue);
				break;

			}
		}

	}

	public static void robotUploadFile(String filePath) throws Throwable {
		LOGGER.info("inside robotUploadFile method");
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		 Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void clickWebElement(By by, int wait) {
		LOGGER.info("inside clickWebElement method");
		validateWebElementVisible(by, wait);
		waitWebElementClickable(by, wait);
		getWebElement(by).click();

	}
    
	public static void clearWebElement(By by, int wait) {
		LOGGER.info("inside clickWebElement method");
		validateWebElementVisible(by, wait);
		waitWebElementClickable(by, wait);
		getWebElement(by).clear();

	}
	public static void scrollToWebElement(By by) {
		LOGGER.info("inside scrollToWebElement method");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));

	}
	
	public static void scrollUp(){
		LOGGER.info("inside scrollUp method");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	public static void scrollToWebElement(WebElement element) {
		LOGGER.info("inside scrollToWebElement method");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}
	public static void setValue(By by, int wait, String value) {
		LOGGER.info("inside setValue method");
		validateWebElementPresence(by, wait);
		if (value != null)
			getWebElement(by).sendKeys(value);

	}

	public static boolean validateWebElementDisplay(By by) {
		LOGGER.info("inside validateWebElementDisplay method");
		boolean isDisplayed = false;
		try {
			isDisplayed = getWebElement(by).isDisplayed();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return isDisplayed;

	}

	public static int validateWebElementCount(By by) {
		LOGGER.info("inside validateWebElementCount method");
		return getWebElements(by).size();

	}

	public static void wait(int time) {
		LOGGER.info("inside wait method");
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public static String takeScreenShotReturnPath() throws IOException{
		LOGGER.info("inside takeScreenShotReturnPath method");
		Date date= new Date();
		Long time=date.getTime();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imagePath=screenShotFolder  + time+".png";
		Files.copy(scrFile, new File(imagePath));
		return imagePath;
	}
	
	public static void EmbedScreenShot(Scenario scenario){
		LOGGER.info("inside EmbedScreenShot method");
		final byte[] screenshot =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png"); // stick it in the report
		
	}
	
	
	public static void PassTestStep(WebDriver driver,ExtentTest test,String passMessage) {
		LOGGER.info("inside PassTestStep method");
		try{
		String imagePath=takeScreenShotReturnPath(); 
		String snapPath=test.addScreenCapture(imagePath);
		test.log(LogStatus.PASS, passMessage,snapPath);
	   }catch(Exception e){
			
		}
				
				
				
	}
	public static  void failTestStep(WebDriver driver,ExtentTest test,String failureMessage) {
		LOGGER.info("inside failTestStep method");
		try{
		String imagePath=takeScreenShotReturnPath();
		String snapPath=test.addScreenCapture(imagePath);
		test.log(LogStatus.FAIL, failureMessage,snapPath);
		}catch(Exception e){
			
		}
		
	}
	
	public static void refreshPage(){
		LOGGER.info("inside refreshPage method");
		driver.navigate().refresh();
		
		
	}
	public static Logs getBrowserConsoleLogs()
    {
   Logs log= driver.manage().logs();
    
    return log;
    }

	public static void doubleClick(By locator){
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(locator);
		actions.doubleClick(elementLocator).perform();
		
	}
	
	public static void javascriptClickElement(By locator){
		WebElement element=SeleniumUtil.getWebElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor)SeleniumUtil.getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public static void javaScriptSendKey(String name,String value) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementByName(name).setAttribute('value', value)");
		
		
	}
}
