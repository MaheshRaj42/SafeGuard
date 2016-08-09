package SG_Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import SG_Generic_Component.SG_BaseClass;
import SG_Page_Object_Component.Page_Object_SG;
import io.appium.java_client.android.AndroidKeyCode;


@Test
public class Scenario_SG extends SG_BaseClass {
	
	static Logger log = Logger.getLogger(Scenario_SG.class);
	SoftAssert sAssert = new SoftAssert();

	public void testSafeguard1() throws IOException, InterruptedException {
		try {
			log.info("Executing the TestCase 1");
			Start_Server();
			Init_app();
			
			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			
			//TC_ID-SG_01 - R-3.1.1
			driver.sendKeyEvent(AndroidKeyCode.HOME);
			Explicit_Wait(SG_POB.settings_option, 25);
			SG_POB.settings_option.click();
			
			 for (int i=1; i<=11; i++){ 
				 DPADdownKeys();						
			 }
			 
			 SG_POB.security_option.click();
			 
			if(SG_POB.Safe_Guard_option.isDisplayed())
			{
				SG_POB.Safe_Guard_option.click();
				System.out.println("Safe Guard option is available under Device Security Settings");
			}
			Stop_Server();
				 
		}catch(IOException e){
			e.printStackTrace();
		}catch(InterruptedException f){
		     f.printStackTrace();
		   }
	}
	
	public void testSafeguard2() throws IOException, InterruptedException {
		try {
			log.info("Executing the TestCase 2");
			Start_Server();
			Init_app();
			
			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			
			//TC_ID-SG_02 - R-3.1.2	
			
			if(SG_POB.Activation_Off.isDisplayed())
			{
				 SG_POB.Activation_Off.click();
				 SG_POB.Input_PIN_Screen.sendKeys("1234");
				 DPADdownKeys();
				 DPADCenterKeys();
			}	 
			 System.out.println("Menu under Safe Guard are: "+SG_POB.Activation_option.getText() +" "+SG_POB.Applications_option.getText() +" "+SG_POB.Features_option.getText() +" "+SG_POB.Change_PIN_option.getText() +" "+SG_POB.Help_option.getText() ); 
			
			 Stop_Server();
			 
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch(IOException f){
			f.printStackTrace();
		}
	}
			 
	public void testSafeguard3() throws IOException, InterruptedException {
		try {
			log.info("Executing the TestCase 3");
			Start_Server();
			Init_app();
			
			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			
			//TC_ID-SG_03 - R-3.1.3	
			String Activation_status1 = SG_POB.Activation_On.getText();
			if(SG_POB.Activation_On.isDisplayed())
			{
				 SG_POB.Activation_On.click();
				 SG_POB.Input_PIN_Screen.sendKeys("1234");
				 DPADdownKeys();
				 DPADCenterKeys();
			}
				
				 String Activation_status2 = SG_POB.Activation_Off.getText(); 
			 System.out.println("Activation status is changed from : "+Activation_status1+ "to "+Activation_status2); 
			
			 Stop_Server();
			 
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch(IOException f){
			f.printStackTrace();
		}
	}
	
			 
	
}

