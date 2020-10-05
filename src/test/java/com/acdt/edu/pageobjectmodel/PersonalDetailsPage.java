package com.acdt.edu.pageobjectmodel;

import java.io.File;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.acdt.edu.util.SeleniumUtil;


public class PersonalDetailsPage {
	
	
	private static final Logger LOGGER = LogManager.getLogger(SignupPage.class);
	public static final String PERSONAL_DETAILS_TITLE_XPATH = "//h3[text()='Personal Details']";
    public static final String TITLE_XPATH="//span[text()='Select title']";
    public static final String SURNAME_NAME="surname";
    public static final String FIRSTNAME_NAME="firstName";
    public static final String MIDDLENAME_NAME= "middleName";
    public static final String OTHERNAMES_NAME ="otherNames";
    public static final String GENDER_XPATH="//div[label[text()='Gender']]//div[@class='c-btn']/span/span";
    public static final String DATE_OF_BIRTH_NAME="dob";
    public static final String COUNTRY_OF_BIRTH_XPATH="//div[label[text()='Country of Birth']]//div[@class='c-btn']";
    public static final String PLACE_OF_BIRTH_NAME="placeOfBirth";
    public static final String NATIONALITY_XPATH="//div[label[text()='Nationality']]//div[@class='c-btn']/span/span";
    public static final String RELIGION_XPATH="//div[label[text()='Religion']]//div[@class='c-btn']";
    public static final String HOME_TOWN_NAME="homeTown";
    public static final String REGION_XPATH="//div[label[text()='Region']]//div[@class='c-btn']";
    public static final String SPECIAL_NEED_YES_ID="exampleRadios1";
    public static final String SPECIAL_NEED_NO_ID="exampleRadios2";
    public static final String SPECIAL_NEED_TEXT_NAME="specialNeedsStatusText";
    public static final String NEXT_BUTTON_XPATH="//a[text()='Next']";
    public static final String LOGOUT_XPATH="//a[text()='Logout']";
    public static final String SELECT_IMAGE_XPATH="//button[contains(text(),'Select image')]";
    public static final String SEARCH_XPATH="(//input[@placeholder='Search'])[index]";
    public static final String SELECT_LABEL_XPATH="//label[text()='selectText']";
    public static final String NATIONALITY_SELECTED_TEXT_XPATH="//div[label[text()='Nationality']]//div/span/span";
    public static final String SELECT_LABEL_NATIONALITY_XPATH="//div[label[text()='Nationality']]//label[text()='selectText']";
    public static final String ERROR_MESSAGE_XPATH="//div[@class='error-msg']";
    public static final String CALENDAR_MONTH_XPATH="//select[@title='Select month']";
    public static final String CALENDAR_YEAR_XPATH="//select[@title='Select year']";
    public static final String CALENDAR_DATE_XPATH="//div[@class='btn-light' and text()='date']";
    
    public static void validatePersonalDetailsTitle() {
		LOGGER.info("Inside validateHomePageTitle Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(PERSONAL_DETAILS_TITLE_XPATH), SeleniumUtil.waitWebElementSync);
	}
    
    
    public static void validatePrefilledFieldsFromSignUpPage(String firstName,String surname,String gender,String country){
    	LOGGER.info("Inside validatePrefilledFieldsFromSignUpPage method");
    	
    	SeleniumUtil.validateWebElementVisible(By.name(FIRSTNAME_NAME), SeleniumUtil.waitWebElementSync);
    	SeleniumUtil.wait(2000);
    	Assert.assertEquals("The first name prefilled data is not matching", firstName, SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).getAttribute("value"));
    	Assert.assertEquals("The surname prefilled data is not matching", surname, SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).getAttribute("value"));
    	Assert.assertEquals("The gender prefilled data is not matching", gender, SeleniumUtil.getWebElement(By.xpath(GENDER_XPATH)).getText().trim());
    	Assert.assertEquals("The country name prefilled data is not matching", country, SeleniumUtil.getWebElement(By.xpath(NATIONALITY_XPATH)).getText().trim());
    }
    
    public static void PersonalDetailFilling(String image,String title,String firstName,String middleName,String lastName,
			String otherName,String gender,String dob,String countryOfBirth ,String cityOfBirth,String nationality ,String religion,String homeTown ,String region ,String specialNeed,String comment) throws Throwable{
    	
    	if(!("".equals(image))){
    		System.out.println("Inside image selection");
			SeleniumUtil.getWebElement(By.xpath(SELECT_IMAGE_XPATH)).click();
			File file = new File("src/test/resources/Upload/"+image);
			String path = file.getAbsolutePath();
			
			System.out.println("path of file "+path);
			Thread.sleep(2000);
			SeleniumUtil.robotUploadFile(path);
		
		}
    	if(!("".equals(title))){	
			SeleniumUtil.getWebElement(By.xpath(TITLE_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).sendKeys(title);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", title))).click();
			Thread.sleep(3000);
		  
    	}
		if(!("".equals(firstName))){
			SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).sendKeys(firstName);	
		}else{
			SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).clear();
		}
		if(!("".equals(middleName))){
			SeleniumUtil.getWebElement(By.name(MIDDLENAME_NAME)).sendKeys(middleName);	
		}
		if(!("".equals(lastName))){
			SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).sendKeys(lastName);	
		}else{
			SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).clear();
		}
		if(!("".equals(otherName))){
			SeleniumUtil.getWebElement(By.name(OTHERNAMES_NAME)).click();
			
			
		}
		
		if(!("".equals(gender))){
			 if(!gender.equals(SeleniumUtil.getWebElement(By.xpath(GENDER_XPATH)).getText().trim())){
			SeleniumUtil.getWebElement(By.xpath(GENDER_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", gender))).click();
			 }
			 
			 
		}
		
		if(!("".equals(dob))){
			 String[] dobsplit=dob.split("/");
		    SeleniumUtil.getWebElement(By.name(DATE_OF_BIRTH_NAME)).click();
		    Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_YEAR_XPATH), dobsplit[2], "selectByVisibleText");
			Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_MONTH_XPATH), dobsplit[1], "SelectByvalue");
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(CALENDAR_DATE_XPATH.replace("date", dobsplit[0]))).click();
			Thread.sleep(2000);
			
			
		}
		
		if(!("".equals(countryOfBirth))){
			SeleniumUtil.getWebElement(By.xpath(COUNTRY_OF_BIRTH_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "3"))).sendKeys(countryOfBirth);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", countryOfBirth))).click();
				
		}
		
		if(!("".equals(cityOfBirth))){
			
			SeleniumUtil.getWebElement(By.name(PLACE_OF_BIRTH_NAME)).sendKeys(cityOfBirth);	
		}
		
		if(!("".equals(nationality))){
		    if(!nationality.equals(SeleniumUtil.getWebElement(By.xpath(NATIONALITY_SELECTED_TEXT_XPATH)).getText().trim())){
			SeleniumUtil.getWebElement(By.xpath(NATIONALITY_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "4"))).sendKeys(nationality);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_NATIONALITY_XPATH.replace("selectText", nationality))).click();
		    }
		}
		
		if(!("".equals(religion))){
			SeleniumUtil.getWebElement(By.xpath(RELIGION_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "5"))).sendKeys(religion);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", religion))).click();	
		}
		if(!("".equals(homeTown))){
			SeleniumUtil.getWebElement(By.name(HOME_TOWN_NAME)).sendKeys(homeTown);
		}
		if(!("".equals(region))){
			SeleniumUtil.getWebElement(By.xpath(REGION_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "6"))).sendKeys(region);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", region))).click();	
		}
		if("yes".equals(specialNeed )){
			SeleniumUtil.getWebElement(By.id(SPECIAL_NEED_YES_ID)).click();		
		}
		if("yes".equals(comment)){
			SeleniumUtil.getWebElement(By.name(SPECIAL_NEED_TEXT_NAME)).sendKeys(comment);	
		}
		
		SeleniumUtil.getWebElement(By.xpath(NEXT_BUTTON_XPATH)).click();
		
		System.out.println("print log"+SeleniumUtil.getBrowserConsoleLogs().toString());
		
		
	}
    
    public static String getErrorMessage(){
		SeleniumUtil.wait(2000);
		 return SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText().trim();
		//Assert.assertEquals("The personal Details Error message is not matching", message, SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText().trim());
	}

	
}
