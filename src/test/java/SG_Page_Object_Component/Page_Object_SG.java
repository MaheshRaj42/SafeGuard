package SG_Page_Object_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Page_Object_SG {
	
	public AndroidDriver driver;
	
	public Page_Object_SG(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@resource-id='android:id/summary'][@text='Off']")
	public WebElement Activation_Off;
	
	@FindBy(xpath="//*[@resource-id='android:id/summary'][@text='On']")
	public WebElement Activation_On;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Activation']")
	public WebElement Activation_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/message'][@text='Input PIN']")
	public WebElement Input_PIN_Screen;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Applications']")
	public WebElement Applications_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Features']")
	public WebElement Features_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Change PIN']")
	public WebElement Change_PIN_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Help']")
	public WebElement Help_option;
	
	@FindBy(xpath="//*[contains(@text, 'Settings')]")
	public WebElement settings_option;
	
	@FindBy(xpath="//*[contains(@text, 'Security')]")
	public WebElement security_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Safe Guard']")
	public WebElement Safe_Guard_option;
	

}
