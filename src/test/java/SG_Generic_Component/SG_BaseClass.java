package SG_Generic_Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class SG_BaseClass {

	public static Process process;
	public static AndroidDriver driver;
	
	static SG_UtilityClass c1 = new SG_UtilityClass();
	
	public static void Start_Server() throws InterruptedException, IOException 
	{
		
		String start_server = "E:\\Appium\\workspace\\node.exe E:\\Appium\\workspace\\node_modules\\appium\\bin\\appium.js";
		process = Runtime.getRuntime().exec(start_server);
		Thread.sleep(10000);
		
		if(process!=null)
		{
			System.out.println("Server is started");
		}
		else {
			System.out.println("Server is not started");
		}
		
		Thread.sleep(12000);
	}
	
	
	
	public static void Init_app() throws IOException 
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", c1.Reading_Properties("Device_Name"));
		capabilities.setCapability("platformName", c1.Reading_Properties("Platform_Name"));
		capabilities.setCapability("platformVersion", c1.Reading_Properties("Platform_Version"));
		
		
		capabilities.setCapability("appPackage", c1.Reading_Properties("Package_Name"));
		capabilities.setCapability("appActivity", c1.Reading_Properties("Activity_Name"));
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
	}
	
	
	public static void Explicit_Wait(WebElement ele, long T1) 
	{
		WebDriverWait wait = new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public static void Snapshotscreen() throws IOException 
	{
		Date date = new Date();
		SimpleDateFormat d_format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		File file = new File(d_format.format(date)+".png");
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File ScreenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(ScreenshotAs, new File("C:\\workspace\\Eclipse\\Projects\\Safe_Guard\\Screenshots\\"+file));
				
	}
	
	
	public static void Stop_Server() throws InterruptedException 
	{
		
		if(process!=null)
		{
			process.destroy();
			Thread.sleep(10000);
			System.out.println("Server is stopped");
		}
	}
	
	public static void SG_password() throws IOException, InterruptedException 
	{
		String command = "adb shell input text 1234";
	    Process process8 = Runtime.getRuntime().exec(command);
	    process8.waitFor();
	}
	
	public static void rebootdevice() throws IOException, InterruptedException
	{
		//String command = "adb reboot";
		Process process2 = Runtime.getRuntime().exec("adb reboot");
		process2.waitFor();
		
	}
	
	public static void DPADdownKeys() throws IOException, InterruptedException 
	{
		String command = "adb shell input keyevent KEYCODE_DPAD_DOWN";
	    Process process3 = Runtime.getRuntime().exec(command);
	    process3.waitFor();
	}
	
	public static void DPADCenterKeys() throws IOException, InterruptedException 
	{
		String command = "adb shell input keyevent KEYCODE_DPAD_CENTER";
	    Process process4 = Runtime.getRuntime().exec(command);
	    process4.waitFor();
	}
	
	public static void DPADLeftKeys() throws IOException, InterruptedException 
	{
		String command = "adb shell input keyevent KEYCODE_DPAD_LEFT";
	    Process process5 = Runtime.getRuntime().exec(command);
	    process5.waitFor();
	}
	
	public static void DPADRightrKeys() throws IOException, InterruptedException 
	{
		String command = "adb shell input keyevent KEYCODE_DPAD_RIGHT";
	    Process process6 = Runtime.getRuntime().exec(command);
	    process6.waitFor();
	}
	
	public static void DPADUpKeys() throws IOException, InterruptedException 
	{
		String command = "adb shell input keyevent KEYCODE_DPAD_UP";
	    Process process7 = Runtime.getRuntime().exec(command);
	    process7.waitFor();
	}
	
}
