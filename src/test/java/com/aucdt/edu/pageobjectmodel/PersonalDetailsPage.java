package com.aucdt.edu.pageobjectmodel;

import java.io.File;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.aucdt.edu.commonstep.GlobalStepDefinition;
import com.aucdt.edu.util.SeleniumUtil;

public class PersonalDetailsPage {
	private static final Logger LOGGER = LogManager.getLogger(SignupPage.class);
	public static final String PERSONAL_DETAILS_TITLE_XPATH = "//h3[text()='Personal Details']";
    public static final String TITLE_XPATH="//div[label[text()='Title']]//div/span";
    public static final String TITLE_GETTEXT_XPATH="//div[label[text()='Title']]//div/span/span";
    public static final String SURNAME_NAME="surname";
    public static final String FIRSTNAME_NAME="firstName";
    public static final String MIDDLENAME_NAME= "middleName";
    public static final String OTHERNAMES_NAME ="otherNames";
    public static final String GENDER_XPATH="//div[label[text()='Gender']]//div[@class='selected-list']/div/span[1]";
    public static final String GENDER_GETTEXT_XPATH="//div[label[text()='Gender']]//div[@class='selected-list']/div/span/span";
    public static final String DATE_OF_BIRTH_NAME="dob";
    public static final String COUNTRY_OF_BIRTH_XPATH="//div[label[text()='Country of Birth']]//div[@class='c-btn']";
    public static final String COUNTRY_OF_BIRTH_GETTEXT_XPATH="//div[label[text()='Country of Birth']]//div[@class='c-btn']/span/span";
    public static final String PLACE_OF_BIRTH_NAME="placeOfBirth";
    public static final String NATIONALITY_XPATH ="//div[label[text()='Nationality']]//div[@class='c-btn']/span[1]";
    public static final String NATIONALITY_GETTEXT_XPATH ="//div[label[text()='Nationality']]//div[@class='c-btn']/span/span";
    public static final String RELIGION_XPATH="//div[label[text()='Religion']]//div[@class='c-btn']";
    public static final String RELIGION_GETTEXT_XPATH="//div[label[text()='Religion']]//div[@class='c-btn']/span/span";
    public static final String HOME_TOWN_NAME="homeTown";
    public static final String REGION_XPATH="//div[label[text()='Region']]//div[@class='c-btn']";
    public static final String REGION_GETTEXT_XPATH="//div[label[text()='Region']]//div[@class='c-btn']/span/span";
    public static final String SPECIAL_NEED_YES_XPATH="//label[input[@id='specialNeedsRadio1']]";
    public static final String SPECIAL_NEED_NO_XPATH="//label[input[@id='specialNeedsRadio2']]";
    public static final String SPECIAL_NEED_TEXT_NAME="specialNeedsStatusText";
    public static final String NEXT_BUTTON_XPATH="//a[text()='Next']";
    public static final String LOGOUT_XPATH="//div/a[text()='Logout']";
    public static final String SELECT_IMAGE_XPATH="//button[contains(text(),'Select image')]";
    public static final String SEARCH_XPATH="(//input[@placeholder='Search'])[index]";
    public static final String SELECT_LABEL_XPATH="//label[text()='selectText']";
    public static final String NATIONALITY_SELECTED_TEXT_XPATH="//div[label[text()='Nationality']]//div[@class='c-btn']/span[1]";
    public static final String SELECT_LABEL_NATIONALITY_XPATH="//div[label[text()='Nationality']]//label[text()='selectText']";
    public static final String ERROR_MESSAGE_XPATH="//div[@class='error-msg']";
    public static final String CALENDAR_MONTH_XPATH="//select[@title='Select month']";
    public static final String CALENDAR_YEAR_XPATH="//select[@title='Select year']";
    public static final String CALENDAR_DATE_XPATH="(//div[text()='date'])[1]";
    public static final String PASSPORT_PICTURE="//div[@class='thumbnail img-no-padding']/img";
    
    public static void validatePersonalDetailsTitle() {
		LOGGER.info("Inside validateHomePageTitle Method");
		SeleniumUtil.wait(5000);
		SeleniumUtil.validateWebElementVisible(By.xpath(PERSONAL_DETAILS_TITLE_XPATH), SeleniumUtil.waitWebElementSync);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), "Personal details page loaded successfully");
    }
    
    
    public static void validatePrefilledFieldsFromSignUpPage(String firstName,String surname,String gender,String country){
    	LOGGER.info("Inside validatePrefilledFieldsFromSignUpPage method");
    	
    	SeleniumUtil.validateWebElementVisible(By.name(FIRSTNAME_NAME), SeleniumUtil.waitWebElementSync);
    	SeleniumUtil.wait(2000);
    	Assert.assertEquals("The first name prefilled data is not matching", firstName, SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).getAttribute("value"));
    	Assert.assertEquals("The surname prefilled data is not matching", surname, SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).getAttribute("value"));
    	Assert.assertEquals("The gender prefilled data is not matching", gender, SeleniumUtil.getWebElement(By.xpath(GENDER_XPATH)).getText().trim());
    	Assert.assertEquals("The country name prefilled data is not matching", country.toUpperCase(), SeleniumUtil.getWebElement(By.xpath(NATIONALITY_XPATH)).getText().trim());
    	SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), " Prefilled data from Signup page loaded successfully");
    }
    
    public static void personalDetailFilling(String image,String title,String firstName,String middleName,String lastName,
			String otherName,String gender,String dob,String countryOfBirth ,String cityOfBirth,String nationality ,String religion,String homeTown ,String region ,String specialNeed,String comment) throws Throwable{
    	
    	if(!("".equals(image))){
    		SeleniumUtil.wait(5000);
    		System.out.println("Inside image selection");
			SeleniumUtil.getWebElement(By.xpath(SELECT_IMAGE_XPATH)).click();
			
			File file = new File("src/test/resources/Upload/"+image);
			String path = file.getAbsolutePath();
			
			System.out.println("path of file "+path);
			Thread.sleep(2000);
			SeleniumUtil.robotUploadFile(path);
		
		}
    	if(!("".equals(title))){
    		Thread.sleep(3000);
    		SeleniumUtil.scrollToWebElement(By.xpath(TITLE_XPATH));
    		if("Select title".equalsIgnoreCase(SeleniumUtil.getWebElement(By.xpath(TITLE_XPATH)).getText().trim())){
			SeleniumUtil.getWebElement(By.xpath(TITLE_XPATH)).click();
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).sendKeys(title);
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).click();
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", title))).click();
    		}
		  
    	}
		if(!("".equals(firstName))){
			SeleniumUtil.scrollToWebElement(By.name(FIRSTNAME_NAME));
			SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).sendKeys(firstName);	
		}else{
			SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).clear();
		}
		if(!("".equals(middleName))){
			SeleniumUtil.scrollToWebElement(By.name(MIDDLENAME_NAME));
			SeleniumUtil.getWebElement(By.name(MIDDLENAME_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(MIDDLENAME_NAME)).sendKeys(middleName);	
		}
		if(!("".equals(lastName))){
			SeleniumUtil.scrollToWebElement(By.name(SURNAME_NAME));
			SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).sendKeys(lastName);	
		}else{
			Thread.sleep(2000);
			SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).sendKeys("");
			SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).clear();
			Thread.sleep(1000);
			
		}
		if(!("".equals(otherName))){
			SeleniumUtil.scrollToWebElement(By.name(OTHERNAMES_NAME));
			SeleniumUtil.getWebElement(By.name(OTHERNAMES_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(OTHERNAMES_NAME)).sendKeys(otherName);
			
			
		}
		
		if(!("".equals(gender))){
			SeleniumUtil.scrollToWebElement(By.xpath(GENDER_XPATH));
			 if("Select gender".equalsIgnoreCase(SeleniumUtil.getWebElement(By.xpath(GENDER_XPATH)).getText().trim())){
			SeleniumUtil.getWebElement(By.xpath(GENDER_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", gender))).click();
			 }
			 
			 
		}else{
			 if(!("Select gender".equalsIgnoreCase(SeleniumUtil.getWebElement(By.xpath(GENDER_XPATH)).getText().trim()))){
					SeleniumUtil.getWebElement(By.xpath(GENDER_XPATH)).click();
					SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", "M"))).click();
					 }
		}
		
		if(!("".equals(dob))){
			SeleniumUtil.scrollToWebElement(By.name(DATE_OF_BIRTH_NAME));
			 String[] dobsplit=dob.split("/");
		    SeleniumUtil.getWebElement(By.name(DATE_OF_BIRTH_NAME)).click();
		    Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_YEAR_XPATH), dobsplit[2], "selectByVisibleText");
			Thread.sleep(1000);
			SeleniumUtil.selectWebList(By.xpath(CALENDAR_MONTH_XPATH), dobsplit[1], "SelectByvalue");
			Thread.sleep(3000);
			SeleniumUtil.getWebElement(By.xpath(CALENDAR_DATE_XPATH.replace("date", dobsplit[0]))).click();
			Thread.sleep(2000);
			
			
		}
		
		if(!("".equals(countryOfBirth))){
			SeleniumUtil.scrollToWebElement(By.xpath(COUNTRY_OF_BIRTH_XPATH));
			 if("SELECT COUNTRY".equalsIgnoreCase(SeleniumUtil.getWebElement(By.xpath(COUNTRY_OF_BIRTH_XPATH)).getText().trim())){
			SeleniumUtil.getWebElement(By.xpath(COUNTRY_OF_BIRTH_XPATH)).click();
			SeleniumUtil.wait(2000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "3"))).sendKeys(countryOfBirth);
			SeleniumUtil.wait(1000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "3"))).click();
			SeleniumUtil.wait(1000);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", countryOfBirth))).click();
			 }	
		}
		
		if(!("".equals(cityOfBirth))){
			SeleniumUtil.scrollToWebElement(By.name(PLACE_OF_BIRTH_NAME));
			SeleniumUtil.getWebElement(By.name(PLACE_OF_BIRTH_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(PLACE_OF_BIRTH_NAME)).sendKeys(cityOfBirth);	
		}
		
		if(!("".equals(nationality))){
			SeleniumUtil.scrollToWebElement(By.xpath(NATIONALITY_SELECTED_TEXT_XPATH));
		    if(!("SELECT NATIONALITY".equalsIgnoreCase(SeleniumUtil.getWebElement(By.xpath(NATIONALITY_SELECTED_TEXT_XPATH)).getText().trim())) && !(nationality.equalsIgnoreCase(SeleniumUtil.getWebElement(By.xpath(NATIONALITY_SELECTED_TEXT_XPATH)).getText().trim()))){
			
		    SeleniumUtil.getWebElement(By.xpath(NATIONALITY_XPATH)).click();
		    SeleniumUtil.wait(2000);
		    SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "4"))).sendKeys(nationality);
		    SeleniumUtil.wait(1000);
		    SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "4"))).click();
		    SeleniumUtil.wait(1000);
		    SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_NATIONALITY_XPATH.replace("selectText", nationality))).click();
			
		    }
		}
		
		if(!("".equals(religion))){
			SeleniumUtil.scrollToWebElement(By.xpath(RELIGION_XPATH));
			if("Select religion".equalsIgnoreCase(SeleniumUtil.getWebElement(By.xpath(RELIGION_XPATH)).getText().trim())){
			SeleniumUtil.getWebElement(By.xpath(RELIGION_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "5"))).sendKeys(religion);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", religion))).click();	
			}
		}
		if(!("".equals(homeTown))){
			SeleniumUtil.scrollToWebElement(By.name(HOME_TOWN_NAME));
			SeleniumUtil.getWebElement(By.name(HOME_TOWN_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(HOME_TOWN_NAME)).sendKeys(homeTown);
		}
		if(!("".equals(region))){
			SeleniumUtil.scrollToWebElement(By.xpath(REGION_XPATH));
			if("Select region".equalsIgnoreCase(SeleniumUtil.getWebElement(By.xpath(REGION_XPATH)).getText().trim())){
			SeleniumUtil.getWebElement(By.xpath(REGION_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "6"))).sendKeys(region);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", region))).click();	
			}
		}
		if("yes".equalsIgnoreCase(specialNeed )){
			if(!("".equals(comment))){
			SeleniumUtil.getWebElement(By.xpath(SPECIAL_NEED_YES_XPATH)).click();
			SeleniumUtil.getWebElement(By.name(SPECIAL_NEED_TEXT_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(SPECIAL_NEED_TEXT_NAME)).sendKeys(comment);
			}else{
				SeleniumUtil.getWebElement(By.xpath(SPECIAL_NEED_YES_XPATH)).click();
				SeleniumUtil.getWebElement(By.name(SPECIAL_NEED_TEXT_NAME)).clear();
			}
		}
				
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), "Personal details fill form successfully");
		
	}
    
    public static void personalDetailClear(String image,String title,String firstName,String middleName,String lastName,
			String otherName,String gender,String dob,String countryOfBirth ,String cityOfBirth,String nationality ,String religion,String homeTown ,String region ,String specialNeed,String comment) throws Throwable{
    	
			
		
			SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).clear();

		
			SeleniumUtil.getWebElement(By.name(MIDDLENAME_NAME)).clear();
		
		
			SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).clear();
			
	
			SeleniumUtil.getWebElement(By.name(OTHERNAMES_NAME)).clear();
		
		
		
			
			
	
		
		
		    SeleniumUtil.getWebElement(By.name(DATE_OF_BIRTH_NAME)).clear();
	
		
			
		
			SeleniumUtil.getWebElement(By.name(PLACE_OF_BIRTH_NAME)).clear();
		
			SeleniumUtil.getWebElement(By.xpath(RELIGION_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "5"))).sendKeys(religion);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", religion))).click();	
	
		
			SeleniumUtil.getWebElement(By.name(HOME_TOWN_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(HOME_TOWN_NAME)).sendKeys(homeTown);
	
			SeleniumUtil.getWebElement(By.name(SPECIAL_NEED_TEXT_NAME)).clear();
		
				
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), "Personal details clear form successfully");
		
	}
   
    
    public static String getErrorMessage(){
		SeleniumUtil.wait(2000);
		SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), "Personal details error loaded successfully");
		 return SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText().trim();
		
	}
    
    public static void ClickLogoutInPersonalDetailPage(){
    	SeleniumUtil.getWebElement(By.xpath(LOGOUT_XPATH)).click();
    	SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), "ClickLogoutInPersonalDetailPage successfully");
    }
    
    public static void clickNextButton(){
    	SeleniumUtil.scrollToWebElement(By.xpath(NEXT_BUTTON_XPATH));
    	SeleniumUtil.getWebElement(By.xpath(NEXT_BUTTON_XPATH)).click();
    	SeleniumUtil.PassTestStep(SeleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), "clickNextButton successfully");
    }
    
    public static String getFilledTitleText(){
    	
    	return SeleniumUtil.getWebElement(By.xpath(TITLE_XPATH)).getText();
    }
   public static String validateuploadedPassportPhoto(){
    	
    	return SeleniumUtil.getWebElement(By.xpath(PASSPORT_PICTURE)).getAttribute("src");
    }
    
    
    public static String getFilledSurNameText(){
   	 return SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).getAttribute("value");
   }
   
    public static String getFilledFirstNameText(){
    	SeleniumUtil.scrollToWebElement(By.name(FIRSTNAME_NAME));
      	 return SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).getAttribute("value");
      }

    public static String getFilledMiddleNameText(){
     	 return SeleniumUtil.getWebElement(By.name(MIDDLENAME_NAME)).getAttribute("value");
     }

    public static String getFilledOtherNameText(){
    	SeleniumUtil.scrollToWebElement(By.name(OTHERNAMES_NAME));
    	 return SeleniumUtil.getWebElement(By.name(OTHERNAMES_NAME)).getAttribute("value");
    }
    
    public static String getFilledGenderText(){
    	SeleniumUtil.scrollToWebElement(By.xpath(GENDER_GETTEXT_XPATH));
   	 return SeleniumUtil.getWebElement(By.xpath(GENDER_GETTEXT_XPATH)).getText();
   }
    
    public static String getFilledDOBText(){
    	
      	 return SeleniumUtil.getWebElement(By.name(DATE_OF_BIRTH_NAME)).getAttribute("value");
      }
    
    public static String getFilledCountryOfBirthText(){
    	SeleniumUtil.scrollToWebElement(By.xpath(COUNTRY_OF_BIRTH_GETTEXT_XPATH));
     	 return SeleniumUtil.getWebElement(By.xpath(COUNTRY_OF_BIRTH_GETTEXT_XPATH)).getText();
     }
    
    public static String getFilledPlaceOfBirthText(){
    	SeleniumUtil.scrollToWebElement(By.name(PLACE_OF_BIRTH_NAME));
    	 return SeleniumUtil.getWebElement(By.name(PLACE_OF_BIRTH_NAME)).getAttribute("value");
    }
    public static String getFilledNationalityText(){
    	SeleniumUtil.scrollToWebElement(By.xpath(NATIONALITY_GETTEXT_XPATH));
   	 return SeleniumUtil.getWebElement(By.xpath(NATIONALITY_GETTEXT_XPATH)).getText();
   }
    public static String getFilledReligionText(){
      	 return SeleniumUtil.getWebElement(By.xpath(RELIGION_GETTEXT_XPATH)).getText();
      }
    public static String getFilledHomeTownText(){
     	 return SeleniumUtil.getWebElement(By.name(HOME_TOWN_NAME)).getAttribute("value");
     }
    public static String getFilledRegionText(){
      	 return SeleniumUtil.getWebElement(By.xpath(REGION_GETTEXT_XPATH)).getText();
      }
    
    public static String getFilledSpecialNeedYesText(){
    	 return SeleniumUtil.getWebElement(By.xpath(SPECIAL_NEED_YES_XPATH)).getText();
    }
    
    public static String getFilledSpecialNeedNoText(){
   	 return SeleniumUtil.getWebElement(By.xpath(SPECIAL_NEED_NO_XPATH)).getText();
   }
   
    public static String getFilledSpecialNeedCommentText(){
    	SeleniumUtil.scrollToWebElement(By.name(SPECIAL_NEED_TEXT_NAME));
      	 return SeleniumUtil.getWebElement(By.name(SPECIAL_NEED_TEXT_NAME)).getAttribute("value");
      }
      
}
