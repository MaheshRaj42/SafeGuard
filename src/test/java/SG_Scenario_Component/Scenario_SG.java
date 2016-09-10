package SG_Scenario_Component;

import java.io.IOException;

import javax.naming.TimeLimitExceededException;

import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.Watchdog;
import org.apache.log4j.Logger;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import SG_Generic_Component.SG_BaseClass;
import SG_Page_Object_Component.Page_Object_SG;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidKeyCode;
import sun.security.ec.ECPublicKeyImpl;


public class Scenario_SG extends SG_BaseClass {
	
	static Logger log = Logger.getLogger(Scenario_SG.class);
	SoftAssert sAssert = new SoftAssert();
	

	//TC_ID-SG_01 - R-3.1.1
	@Test (priority=1)
	public void testSafeguard1() throws IOException, InterruptedException {
		try {
			log.info("Executing the TestCase 1");
			Start_Server();
			Init_app();
			System.out.println("Capabilities are initiated");
			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			driver.sendKeyEvent(AndroidKeyCode.HOME);
			Explicit_Wait(SG_POB.settings_option, 25);
			
			SG_POB.settings_option.click();
			
			 for (int i=1; i<=11; i++)
			 { 
				 driver.sendKeyEvent(20);						
			 }
			 
			 SG_POB.security_option.click();
			 
			if(SG_POB.Safe_Guard_option.isDisplayed())
			{
				SG_POB.Safe_Guard_option.click();
				System.out.println("Safe Guard option is available under 'Device > Security Settings' ");
			}
			driver.sendKeyEvent(AndroidKeyCode.HOME);
		Stop_Server();
				 
		}catch(IOException e){
			e.printStackTrace();
		}catch(InterruptedException f){
		     f.printStackTrace();
		   }
	}

	
	//TC_ID-SG_02 - R-3.1.3	
	@Test (priority=2)
	public void testSafeguard2() throws IOException, InterruptedException {
		try {
			log.info("Executing the TestCase 2");
			Start_Server();
			Init_app();
			
			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			Explicit_Wait(SG_POB.Activation_status.get(0), 25);
			System.out.println("Capabilities are initiated");
			String Activation_status = SG_POB.Activation_status.get(0).getText();
			
			if(Activation_status == "Off")
			{
				 SG_POB.Activation_Off.click();
				 SG_POB.Input_PIN_Screen.sendKeys("1234");
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
			}	 
			 System.out.println("Menu under Safe Guard are: "+SG_POB.Activation_option.getText() +" "+SG_POB.Applications_option.getText() +" "+SG_POB.Features_option.getText() +" "+SG_POB.Change_PIN_option.getText() +" "+SG_POB.Help_option.getText() ); 		
			 driver.sendKeyEvent(AndroidKeyCode.HOME);
			 
			 Stop_Server();
			 
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
			catch(IOException f){
			f.printStackTrace();
		}
	}


	
	//TC_ID-SG_03 - R-3.2.1
	@Test (priority=3)
	public void testSafeguard3() throws IOException, InterruptedException {
		try {
			log.info("Executing the TestCase 3");
			Start_Server();
			Init_app();
			System.out.println("Capabilities are initiated");
			
			Page_Object_SG SG_POB = new Page_Object_SG(driver);	
			Explicit_Wait(SG_POB.Activation_option, 25);
			String Activation_status1 = SG_POB.Activation_status.get(0).getText();

			SG_POB.Activation_option.click();
			Explicit_Wait(SG_POB.Input_PIN_Screen, 25);
			 SG_POB.Input_PIN_Screen.sendKeys("1234");
			 driver.sendKeyEvent(20);
			 driver.sendKeyEvent(23);
			 Thread.sleep(5000);
			 String Activation_status2 = SG_POB.Activation_status.get(0).getText(); 
			 System.out.println("Activation status is changed from : "+Activation_status1+ " to "+Activation_status2); 
			
			 driver.sendKeyEvent(AndroidKeyCode.HOME);
			 Stop_Server();
			 
		}catch(InterruptedException e){
			e.printStackTrace();
		}
			catch(IOException f){
			f.printStackTrace();
		}
	}

	
	
	
	
	String mActivation_status1;    //For TestCase4
	

	//TC_ID-SG_04 - R-3.2.2
	@Test (priority=4)
	public void testSafeguard4() throws IOException, InterruptedException {
		try {
			log.info("Executing the TestCase 4");
			Start_Server();
			Init_app();
			Page_Object_SG SG_POB = new Page_Object_SG(driver);	
			Explicit_Wait(SG_POB.Activation_option, 25);
				
			mActivation_status1 = SG_POB.Activation_status.get(0).getText();
			System.out.println("Safe Guard activation status is: "+mActivation_status1);
			log.info("Safe Guard activation status is: "+mActivation_status1);
			
			driver.sendKeyEvent(AndroidKeyCode.HOME);
			Stop_Server();
		}
		catch(SessionNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException f){
			f.printStackTrace();
		}
	}
	


	
	//TC_ID-SG_04_1 - R-3.2.2
	@Test (priority=5)
	public void testSafeguard4_1() throws IOException, InterruptedException {
		try {
			log.info("Executing the TestCase 4_1");
			Start_Server();
			Init_app();	
			
			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			
			driver.sendKeyEvent(AndroidKeyCode.HOME);
			Explicit_Wait(SG_POB.settings_option, 25);		
			
			SG_POB.settings_option.click();		
			 for (int i=1; i<=11; i++)
			 { 
				 driver.sendKeyEvent(20);						
			 }
			 
			 SG_POB.security_option.click();
			 
			if(SG_POB.Safe_Guard_option.isDisplayed())
			{
				SG_POB.Safe_Guard_option.click();			
			}
		    Thread.sleep(3000);
			String Activation_status2 = SG_POB.Activation_status.get(0).getText();
			
			if (mActivation_status1.equals(Activation_status2))
			{
				System.out.println("Safe Guard activation status after reboot is: "+Activation_status2);
				log.info("Safe Guard activation status after reboot is: "+Activation_status2);
			}
			
			driver.sendKeyEvent(AndroidKeyCode.HOME);
			Stop_Server();
		}catch(SessionNotCreatedException e){
			e.printStackTrace();
		}
		catch(IOException f){
			f.printStackTrace();
		}
	}

	
    	    //TC_ID-SG_05 - R-3.2.4	
	    @Test (priority=6)
		public void testSafeguard5() throws IOException, InterruptedException {
			try {
				log.info("Executing the TestCase 5");
				Start_Server();
				Init_app();
				System.out.println("Capabilities are Initiated");
				Page_Object_SG SG_POB = new Page_Object_SG(driver);
				Explicit_Wait(SG_POB.Activation_status.get(0), 25);
				String Activation_Status = SG_POB.Activation_status.get(0).getText();
				
				if(Activation_Status.equals("Off"))
				{
					 SG_POB.Activation_Off.click();
					 SG_POB.Input_PIN_Screen.sendKeys("1234");
					 Thread.sleep(10000);
					 driver.sendKeyEvent(20);
					 driver.sendKeyEvent(23);
				}
				Explicit_Wait(SG_POB.Applications_option, 25);		
				SG_POB.Applications_option.click();		
				Explicit_Wait(SG_POB.Input_PIN_Screen, 25);
				SG_POB.Input_PIN_Screen.sendKeys("1234");
				Thread.sleep(5000);
				driver.sendKeyEvent(20);
				driver.sendKeyEvent(23);
				Thread.sleep(5000);
				
				SG_POB.SG_Apps_List_chkbox.get(0).clear();
				Thread.sleep(3000);
				driver.sendKeyEvent(AndroidKeyCode.MENU);
				Thread.sleep(3000);
				driver.sendKeyEvent(23);
				System.out.println("Camera app is disabled to restrict the access");

				Explicit_Wait(SG_POB.Applications_option, 25);		
				SG_POB.Applications_option.click();		
				Explicit_Wait(SG_POB.Input_PIN_Screen, 25);
				SG_POB.Input_PIN_Screen.sendKeys("1234");
				Thread.sleep(5000);
				driver.sendKeyEvent(20);
				driver.sendKeyEvent(23);
				Thread.sleep(5000);
				SG_POB.SG_Cam_option.click();
						Thread.sleep(3000);
						driver.sendKeyEvent(AndroidKeyCode.MENU);
						Thread.sleep(3000);
						driver.sendKeyEvent(23);
					
						System.out.println("Camera app is enabled to restrict the access");
				driver.sendKeyEvent(AndroidKeyCode.HOME);
				Explicit_Wait(SG_POB.Camera_App, 60);
				SG_POB.Camera_App.click();
				Explicit_Wait(SG_POB.Enter_PIN, 60);
				
				if(SG_POB.Enter_PIN.isDisplayed())
				{
					System.out.println("Camera app is restricted to access with out entering the safe guard PIN");
				}
				else
				{
					System.out.println("Failed to restrict to entering camera app with out the safe guard PIN");
				}
				driver.sendKeyEvent(AndroidKeyCode.HOME);
				Stop_Server();
								
			}catch(SessionNotCreatedException e){
				e.printStackTrace();
			}
			catch(IOException f){
				f.printStackTrace();
			}
			catch(InterruptedException g){
				g.printStackTrace();
			}
		}

	
  		//TC_ID-SG_06 - R-3.2.5
		@Test(priority=7)
		public void testSafeguard6() throws InterruptedException, IOException {
			try {
				log.info("Executing the TestCase 6");
				Start_Server();
				Init_app();
				
				Page_Object_SG SG_POB = new Page_Object_SG(driver);
				Explicit_Wait(SG_POB.Applications_option, 25);		
				SG_POB.Applications_option.click();		
				Explicit_Wait(SG_POB.Input_PIN_Screen, 25);
				SG_POB.Input_PIN_Screen.sendKeys("1234");
				Thread.sleep(5000);
				driver.sendKeyEvent(20);
				driver.sendKeyEvent(23);
				Thread.sleep(5000);
				
				SG_POB.SG_Apps_List_chkbox.get(0).clear();
				Thread.sleep(3000);
				driver.sendKeyEvent(AndroidKeyCode.MENU);
				Thread.sleep(3000);
				driver.sendKeyEvent(23);
				System.out.println("Camera app is disabled to restrict the access");

				Explicit_Wait(SG_POB.Applications_option, 25);		
				SG_POB.Applications_option.click();		
				Explicit_Wait(SG_POB.Input_PIN_Screen, 25);
				SG_POB.Input_PIN_Screen.sendKeys("1234");
				Thread.sleep(5000);
				driver.sendKeyEvent(20);
				driver.sendKeyEvent(23);
				Thread.sleep(5000);
				SG_POB.SG_Cam_option.click();
						Thread.sleep(3000);
						driver.sendKeyEvent(AndroidKeyCode.MENU);
						Thread.sleep(3000);
						driver.sendKeyEvent(23);
						
						System.out.println("Camera app is enabled to restrict the access");

				driver.sendKeyEvent(AndroidKeyCode.HOME);
				Explicit_Wait(SG_POB.Camera_App, 60);
				SG_POB.Camera_App.click();
				Explicit_Wait(SG_POB.Enter_PIN, 60);
				SG_POB.Enter_PIN.sendKeys("1234");
				Thread.sleep(4000);
				driver.sendKeyEvent(20);
				driver.sendKeyEvent(23);
				driver.sendKeyEvent(AndroidKeyCode.BACK);
				driver.sendKeyEvent(AndroidKeyCode.HOME);
				SG_POB.Camera_App.click();
				Explicit_Wait(SG_POB.Enter_PIN, 60);
				
				if(SG_POB.Enter_PIN.isDisplayed())
				{
				System.out.println("Camera app is restricted to access, if the PIN is not re-entered after reaching home screen once");
				log.info("Camera app is restricted to access, if the PIN is not re-entered after reaching home screen once");
				}
				else
				{
				System.out.println("Failed to restrict to entering camera app with out the safe guard PIN");
				log.info("Failed to restrict to entering camera app with out the safe guard PIN");
				}
	            driver.sendKeyEvent(AndroidKeyCode.HOME);
				Stop_Server();
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			catch(IOException f){
				f.printStackTrace();
			}
		}
		
		
	
	
	
  		//TC_ID-SG_07 - R-3.2.6
		@Test(priority=8)
		public void testSafeguard7() throws InterruptedException, IOException {
			try {
				log.info("Executing the TestCase 7");
				Start_Server();
				Init_app();
				System.out.println("Capabilities are Initiated");
				Page_Object_SG SG_POB = new Page_Object_SG(driver);
				
				Explicit_Wait(SG_POB.Activation_option, 25);
				SG_POB.Activation_option.click();
				Explicit_Wait(SG_POB.Activation_OK_btn, 60);
				
				if(SG_POB.Activation_OK_btn.isDisplayed()){
					System.out.println("Activation INPUT PIN screen has 'OK' button");	
				}else {
					System.out.println("Activation INPUT PIN screen doesn't have 'OK' button");
				}	
				driver.sendKeyEvent(AndroidKeyCode.HOME);
				Stop_Server();
		}catch(SessionNotCreatedException e){
			e.printStackTrace();
		}
			catch(IOException f){
			f.printStackTrace();
		}
	}
		
		
     	//TC_ID-SG_08 - R-3.2.7
				@Test (priority=9)
				public void testSafeguard8() throws InterruptedException, IOException {
					try {
						log.info("Executing the TestCase 8");
						Start_Server();
						Init_app();
						
						Page_Object_SG SG_POB = new Page_Object_SG(driver);
						Explicit_Wait(SG_POB.Activation_status.get(0), 25);
						String Activation_status1 = SG_POB.Activation_status.get(0).getText();
						SG_POB.Activation_option.click();
						driver.sendKeyEvent(23);
						driver.sendKeyEvent(AndroidKeyCode.BACK);
						Explicit_Wait(SG_POB.Activation_option, 30);
						String Activation_status2 = SG_POB.Activation_status.get(0).getText();
						System.out.println(Activation_status2);
						
						if(Activation_status2.equals(Activation_status1)){
							System.out.println("PIN doesn't change after pressing OK button without PIN entry");
						} 
						else {
							System.out.println("Activation status is changed even without entering PIN and pressing OK button");
						}
						Explicit_Wait(SG_POB.Activation_option, 25);
						SG_POB.Activation_option.click();
						SG_POB.Input_PIN_Screen.sendKeys("4321");
						driver.sendKeyEvent(20);
						SG_POB.Activation_OK_btn.click();
						if(SG_POB.Input_PIN_Screen.isDisplayed())
						{
							driver.sendKeyEvent(AndroidKeyCode.BACK);
							Thread.sleep(2000);
						}
						
						Explicit_Wait(SG_POB.Activation_option, 30);
						String Activation_status3 = SG_POB.Activation_status.get(0).getText();
						if(Activation_status3.equals(Activation_status2)){
							System.out.println("PIN doesn't change after entering Wrong PIN");
						} 
						else {
							System.out.println("Activation status is changed even after entering wrong PIN");
						}
						
						SG_POB.Activation_option.click();
						SG_POB.Input_PIN_Screen.sendKeys("1234");
						driver.sendKeyEvent(20);
						SG_POB.Activation_OK_btn.click();
						String Activation_status4 = SG_POB.Activation_status.get(0).getText();
						if(Activation_status4.equals(Activation_status3)){
							System.out.println("Activation status is not changed even after entering Correct PIN");
						} 
						else {
							System.out.println("Activation status is changed successfully after entering Correct PIN");
						}
						
						driver.sendKeyEvent(AndroidKeyCode.HOME);
						Stop_Server();
					}catch(SessionNotCreatedException e){
						e.printStackTrace();
					}
					catch(IOException f){
						f.printStackTrace();
					}
				}

				
				
	//TC_ID-SG_09 - R-3.2.8
	@Test (priority=10)
	public void testSafeguard9() throws IOException, InterruptedException {
		try {
			log.info("Executing the TestCase 9");
			Start_Server();
			Init_app();
			System.out.println("Capabilities are initiated");
			
			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			Explicit_Wait(SG_POB.Activation_status.get(0), 25);
			String Activation_status1 = SG_POB.Activation_status.get(0).getText();

			SG_POB.Activation_status.get(0).click();
				Explicit_Wait(SG_POB.Input_PIN_Screen, 60);
				
			 SG_POB.Input_PIN_Screen.sendKeys("1234");
			 
			 driver.sendKeyEvent(20);
			 driver.sendKeyEvent(23);
			 Thread.sleep(5000);
			 String Activation_status2 = SG_POB.Activation_status.get(0).getText(); 
			 if(Activation_status2!=Activation_status1){
				 System.out.println("Entered PIN is a Valid PIN");
			 }
			 System.out.println("Activation status is changed from : "+Activation_status1+ " to "+Activation_status2); 
			 driver.sendKeyEvent(AndroidKeyCode.HOME);
			 Stop_Server();
			 
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		catch(IOException f){
			f.printStackTrace();
		}
	}	

	
	//TC_ID-SG_10 - R-3.2.9
		@Test (priority = 11)
		public void testSafeguard10() throws IOException, InterruptedException {
			try {
				log.info("Executing the TestCase 10");
				Start_Server();
				Init_app();
				System.out.println("Capabilities are initiated");
				
				Page_Object_SG SG_POB = new Page_Object_SG(driver);	
				Explicit_Wait(SG_POB.Activation_status.get(0), 25);
				String Activation_status1 = SG_POB.Activation_status.get(0).getText();

				SG_POB.Activation_status.get(0).click();
				Explicit_Wait(SG_POB.Input_PIN_Screen, 60);
					
				 SG_POB.Input_PIN_Screen.sendKeys("1234");
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
				 Thread.sleep(5000);
				 String Activation_status2 = SG_POB.Activation_status.get(0).getText(); 
				 if(Activation_status2!=Activation_status1){
					 System.out.println("Entered PIN is a Valid PIN");
				 } else {
					 System.out.println("Entered PIN is not a Valid PIN");
				 }
				 System.out.println("Activation status is changed from : "+Activation_status1+ " to "+Activation_status2); 
				 driver.sendKeyEvent(AndroidKeyCode.HOME);
				Stop_Server();
				 
			}catch(SessionNotCreatedException e){
				e.printStackTrace();
			}
			catch(IOException f){
				f.printStackTrace();
			
			}
			
		}
	


	
	          //TC_ID-SG_11 - R-3.3.1
				@Test (priority = 12)
				public void testSafeguard11() throws IOException, InterruptedException {
					try {
						log.info("Executing the TestCase 11");
						Start_Server();
						Init_app();
						System.out.println("Capabilities are initiated");
						
						Page_Object_SG SG_POB = new Page_Object_SG(driver);
						
						Explicit_Wait(SG_POB.Activation_status.get(0), 25);
						String Act_status1 = SG_POB.Activation_status.get(0).getText();
						System.out.println(Act_status1);

				  if(Act_status1.equals("Off"))
				  {
					SG_POB.Activation_status.get(0).click();
					Explicit_Wait(SG_POB.Input_PIN_Screen, 30);
					SG_POB.Input_PIN_Screen.sendKeys("1234");
					driver.sendKeyEvent(20);
					driver.sendKeyEvent(23);
				   }
				  
				Explicit_Wait(SG_POB.Applications_option, 25);
				SG_POB.Applications_option.click();
				SG_POB.Input_PIN_Screen.sendKeys("1234");
				driver.sendKeyEvent(20);
				driver.sendKeyEvent(23);
	           	
				System.out.println("Apps present in the list are: \n 1 "+SG_POB.SG_Apps_List.get(0).getText()+ "\n 2 " +SG_POB.SG_Apps_List.get(1).getText()+ "\n 3 " +SG_POB.SG_Apps_List.get(2).getText()+ "\n 4 " +SG_POB.SG_Apps_List.get(3).getText());
				
				for (int i=1; i<8; i++){
					driver.sendKeyEvent(20);
				}
				
				System.out.println(" 5 " +SG_POB.SG_Apps_List.get(0).getText()+ "\n 6 " +SG_POB.SG_Apps_List.get(1).getText()+ "\n 7 " +SG_POB.SG_Apps_List.get(2).getText()+ "\n 8 " +SG_POB.SG_Apps_List.get(3).getText());
				for (int i=1; i<5; i++){
					driver.sendKeyEvent(20);
				}
				System.out.println(" 9 " +SG_POB.SG_Apps_List.get(0).getText()+ "\n 10 " +SG_POB.SG_Apps_List.get(1).getText()+ "\n 11 " +SG_POB.SG_Apps_List.get(2).getText()+ "\n 12 " +SG_POB.SG_Apps_List.get(3).getText());
				driver.sendKeyEvent(20);
				driver.sendKeyEvent(20);
				System.out.println(" 13 " +SG_POB.SG_Apps_List.get(2).getText()+ "\n 14 " +SG_POB.SG_Apps_List.get(3).getText()+ "\n All the 14 apps are available in the apps list");
				
				driver.sendKeyEvent(AndroidKeyCode.HOME);
				Stop_Server();
				
              }catch(InterruptedException e){
            	   e.printStackTrace();
               }
					catch(IOException f){
            	   f.printStackTrace();
               }
					
		}

				
				//TC_ID-SG_12 - R-3.3.2
				@Test (priority = 13)
				public void testSafeguard12() throws IOException, InterruptedException {
					try {
						log.info("Executing the TestCase 12");
						Start_Server();
						Init_app();
						System.out.println("Capabilities are initiated");
						
						Page_Object_SG SG_POB = new Page_Object_SG(driver);	
						String Act_status1 = SG_POB.Activation_status.get(0).getText();
						System.out.println(Act_status1);

				  if(Act_status1.equals("Off"))
				  {
					SG_POB.Activation_status.get(0).click();
					Explicit_Wait(SG_POB.Input_PIN_Screen, 30);
					SG_POB.Input_PIN_Screen.sendKeys("1234");
					driver.sendKeyEvent(20);
					driver.sendKeyEvent(23);
				   }
				 
				Explicit_Wait(SG_POB.Applications_option, 25);
				SG_POB.Applications_option.click();
				if (SG_POB.Input_PIN_Screen.isDisplayed()){
					System.out.println("'Applications' option is restricted with PIN");
				}
				else
				{
					System.out.println("Applications option is not restricted with PIN");
				}
				driver.sendKeyEvent(AndroidKeyCode.HOME);
				Stop_Server();
			}catch(InterruptedException e){
				e.printStackTrace();
			}catch(IOException f){
				f.printStackTrace();
			}
         }
				
  
	
	              //TC_ID-SG_13 - R-3.3.3
			    @Test (priority=14)
				public void testSafeguard13() throws IOException, InterruptedException {
					try {
						log.info("Executing the TestCase 13");
						Start_Server();
						Init_app();

						Page_Object_SG SG_POB = new Page_Object_SG(driver);
						String Activation_Status = SG_POB.Activation_status.get(0).getText();
						
						if(Activation_Status == "Off")
						{
							 SG_POB.Activation_Off.click();
							 SG_POB.Input_PIN_Screen.sendKeys("1234");
							 Thread.sleep(10000);
							 driver.sendKeyEvent(20);
							 driver.sendKeyEvent(23);
						}
						Explicit_Wait(SG_POB.Applications_option, 25);		
						SG_POB.Applications_option.click();
						SG_POB.Input_PIN_Screen.sendKeys("1234");
						Thread.sleep(5000);
						driver.sendKeyEvent(20);
						driver.sendKeyEvent(23);
						Thread.sleep(5000);
						
						SG_POB.SG_Apps_List_chkbox.get(0).clear();
						Thread.sleep(3000);
						driver.sendKeyEvent(AndroidKeyCode.MENU);
						Thread.sleep(3000);
						driver.sendKeyEvent(23);
						System.out.println("Camera app is disabled to restrict the access");
		
						Explicit_Wait(SG_POB.Applications_option, 25);		
						SG_POB.Applications_option.click();		
						Explicit_Wait(SG_POB.Input_PIN_Screen, 25);
						SG_POB.Input_PIN_Screen.sendKeys("1234");
						Thread.sleep(5000);
						driver.sendKeyEvent(20);
						driver.sendKeyEvent(23);
						Thread.sleep(5000);
						SG_POB.SG_Cam_option.click();
								Thread.sleep(3000);
								driver.sendKeyEvent(AndroidKeyCode.MENU);
								Thread.sleep(3000);
								driver.sendKeyEvent(23);
								System.out.println("Camera app is enabled to restrict the access");
					    
					    driver.sendKeyEvent(AndroidKeyCode.HOME);	
						Stop_Server();
					}catch(InterruptedException e){
						e.printStackTrace();
					}catch(IOException f){
						f.printStackTrace();
					}
			    }
				
				
				
			    //TC_ID-SG_14 - R-3.3.4
			    @Test (priority=15)
				public void testSafeguard14() throws IOException, InterruptedException {
					try {
						log.info("Executing the TestCase 14");
						Start_Server();
						Init_app();

						Page_Object_SG SG_POB = new Page_Object_SG(driver);
						String Activation_Status = SG_POB.Activation_status.get(0).getText();
						
						if(Activation_Status.equals("Off"))
						{
							 SG_POB.Activation_Off.click();
							 SG_POB.Input_PIN_Screen.sendKeys("1234");	
							 Thread.sleep(5000);
							 driver.sendKeyEvent(20);
							 driver.sendKeyEvent(23);
						}
						Explicit_Wait(SG_POB.Applications_option, 25);
						SG_POB.Applications_option.click();
						SG_POB.Input_PIN_Screen.sendKeys("4321");
								
						 Thread.sleep(5000);
						 driver.sendKeyEvent(20);
						 driver.sendKeyEvent(23);
						 Snapshotscreen();
					     driver.sendKeyEvent(AndroidKeyCode.BACK);
					     Explicit_Wait(SG_POB.Applications_option, 25);
					if(SG_POB.Applications_option.isDisplayed()){
					  System.out.println("Applications option restricted to access with wrong PIN Entry - PIN Verification screenshot has been captured and saved");
					 }
					driver.sendKeyEvent(AndroidKeyCode.HOME);
					Stop_Server();				 
					}catch(InterruptedException e){
						e.printStackTrace();
					}catch(IOException f){
						f.printStackTrace();
					}
					
			    }
						
			    

 
	             //TC_ID-SG_15 - R-3.3.5
			    @Test (priority=16)
				public void testSafeguard15() throws IOException, InterruptedException {
					try {
						log.info("Executing the TestCase 15");
						Start_Server();
						Init_app();
                        System.out.println("Capabilities are Initiated");
						Page_Object_SG SG_POB = new Page_Object_SG(driver);
						String Activation_Status = SG_POB.Activation_status.get(0).getText();
						
						if(Activation_Status.equals("Off"))
						{
							 SG_POB.Activation_Off.click();
							 SG_POB.Input_PIN_Screen.sendKeys("1234");	
							 Thread.sleep(5000);
							 driver.sendKeyEvent(20);
							 driver.sendKeyEvent(23);
						}	
						Explicit_Wait(SG_POB.Applications_option, 25);
						SG_POB.Applications_option.click();
						SG_POB.Input_PIN_Screen.sendKeys("1234");	
						Thread.sleep(5000);
						driver.sendKeyEvent(20);
						driver.sendKeyEvent(23);		
						driver.sendKeyEvent(AndroidKeyCode.MENU);
						
						if(SG_POB.SG_apps_Save_option.isDisplayed())
						{
							System.out.println("Save option is available in the application Menu : "+SG_POB.SG_apps_Save_option.getText());
						}
						else
						{
							System.out.println("Save option is not available");
						}
						
						if(SG_POB.SG_apps_Cancel_option.isDisplayed()){
							System.out.println("Cancel option is available in the application Menu : "+SG_POB.SG_apps_Cancel_option.getText());
						}
						else
						{
							System.out.println("Cancel option is not available");
						}
						driver.sendKeyEvent(AndroidKeyCode.HOME);
						Stop_Server();
					}catch(InterruptedException e){
					 e.printStackTrace();
					}catch(IOException f){
					 f.printStackTrace();
					}
			    }
			    
			    
			    //TC_ID-SG_16 - R-3.3.6
			    @Test (priority=17)
				public void testSafeguard16() throws IOException, InterruptedException {
					try {
						log.info("Executing the TestCase 16");
						Start_Server();
						Init_app();
                        System.out.println("Capabilities are Initiated");
						Page_Object_SG SG_POB = new Page_Object_SG(driver);
						String Activation_Status = SG_POB.Activation_status.get(0).getText();
						
						if(Activation_Status.equals("Off"))
						{
							 SG_POB.Activation_Off.click();
							 SG_POB.Input_PIN_Screen.sendKeys("1234");	
							 Thread.sleep(5000);
							 driver.sendKeyEvent(20);
							 driver.sendKeyEvent(23);
						}
						Explicit_Wait(SG_POB.Applications_option, 25);
						SG_POB.Applications_option.click();
						Explicit_Wait(SG_POB.Input_PIN_Screen, 25);
						SG_POB.Input_PIN_Screen.sendKeys("1234");	
						 Thread.sleep(5000);
						 driver.sendKeyEvent(20);
						 driver.sendKeyEvent(23);
						 
						 SG_POB.SG_Apps_Camera.click();
						
						driver.sendKeyEvent(AndroidKeyCode.MENU);
						Explicit_Wait(SG_POB.SG_apps_Save_option, 60);
						SG_POB.SG_apps_Save_option.click();
						
						if(SG_POB.Applications_option.isDisplayed()){
							System.out.println("As expected - After the save operation screen is navigated to previous screen");
						}
						else {
							System.out.println("Save operation is not performed (or) screen didn't navigate to previous screen");
						}
						driver.sendKeyEvent(AndroidKeyCode.HOME);
						Stop_Server();
						}catch(InterruptedException e){
						 e.printStackTrace();
						}catch(IOException f){
						 f.printStackTrace();
						}
						
               }
	
	
					    //TC_ID-SG_17 - R-3.3.7
					    @Test (priority=18)
						public void testSafeguard17() throws IOException, InterruptedException {
							try {
								log.info("Executing the TestCase 17");
								Start_Server();
								Init_app();

								Page_Object_SG SG_POB = new Page_Object_SG(driver);
								String Activation_Status = SG_POB.Activation_status.get(0).getText();
								
								if(Activation_Status.equals("Off"))
								{
									 SG_POB.Activation_Off.click();
									 SG_POB.Input_PIN_Screen.sendKeys("1234");	
									 Thread.sleep(5000);
									 driver.sendKeyEvent(20);
									 driver.sendKeyEvent(23);
								}
								Explicit_Wait(SG_POB.Applications_option, 25);
								SG_POB.Applications_option.click();
								SG_POB.Input_PIN_Screen.sendKeys("1234");	
								 Thread.sleep(5000);
								 driver.sendKeyEvent(20);
								 driver.sendKeyEvent(23);
								 
								 SG_POB.SG_Apps_Camera.click();
								
								driver.sendKeyEvent(AndroidKeyCode.MENU);
								Explicit_Wait(SG_POB.SG_apps_Cancel_option, 60);
								SG_POB.SG_apps_Cancel_option.click();
								
								if(SG_POB.Applications_option.isDisplayed()){
									System.out.println("As expected - After the cancel operation screen is navigated to previous screen");
								}
								else {
									System.out.println("Cancel operation is not performed (or) screen didn't navigate to previous screen");
								}
								driver.sendKeyEvent(AndroidKeyCode.HOME);
								Stop_Server();
							}catch(InterruptedException e){
							 e.printStackTrace();
							}catch(IOException f){
							 f.printStackTrace();
							}
	 
					 }
	
					   
				
					    //TC_ID-SG_18 - R-3.3.9
					    @Test (priority=19)
						public void testSafeguard18() throws IOException, InterruptedException {
							try {
								log.info("Executing the TestCase 18");
								Start_Server();
								Init_app();

								Page_Object_SG SG_POB = new Page_Object_SG(driver);
								String Activation_Status = SG_POB.Activation_status.get(0).getText();
								
								if(Activation_Status.equals("Off"))
								{
									 SG_POB.Activation_Off.click();
									 SG_POB.Input_PIN_Screen.sendKeys("1234");	
									 Thread.sleep(5000);
									 driver.sendKeyEvent(20);
									 driver.sendKeyEvent(23);
								}
								
								SG_POB.Applications_option.click();
								Explicit_Wait(SG_POB.Input_PIN_Screen, 25);
								SG_POB.Input_PIN_Screen.sendKeys("1234");	
								 Thread.sleep(5000);
								 driver.sendKeyEvent(20);
								 driver.sendKeyEvent(23);	
								 
								 driver.sendKeyEvent(AndroidKeyCode.MENU);
								 
								if(SG_POB.SG_apps_SelectAll_option.isDisplayed())
								System.out.println(" 'Select All' option is displayed in apps list menu: "+SG_POB.SG_apps_SelectAll_option.getText());
			 
								else
								System.out.println(" 'Select All' option is not displayed in apps list menu");
			
								if(SG_POB.SG_apps_UnselectAll_option.isDisplayed()) 
							    System.out.println(" 'UnSelect All' option is displayed in apps list menu: "+SG_POB.SG_apps_UnselectAll_option.getText());
								
								else 
								System.out.println(" 'UnSelect All' option is not displayed in apps list menu");
								
								driver.sendKeyEvent(AndroidKeyCode.HOME);
								Stop_Server();	 
							}catch(InterruptedException e){
								e.printStackTrace();
							}catch(IOException f){
								f.printStackTrace();
							}
							
					    }
					    
	
	
	
					    //TC_ID-SG_19 - R-3.3.10
					    @Test (priority=20)
						public void testSafeguard19() throws IOException, InterruptedException {
							try {
								log.info("Executing the TestCase 19");
								Start_Server();
								Init_app();

								Page_Object_SG SG_POB = new Page_Object_SG(driver);
								String Activation_Status = SG_POB.Activation_status.get(0).getText();
								
								if(Activation_Status.equals("On"))
								{
									 SG_POB.Activation_On.click();
									 SG_POB.Input_PIN_Screen.sendKeys("1234");	
									 Thread.sleep(5000);
									 driver.sendKeyEvent(20);
									 driver.sendKeyEvent(23);
								}
					            Thread.sleep(4000);
								if(Activation_Status.equals("Off"))
								{
									SG_POB.Applications_option.click();
									Thread.sleep(5000);
									System.out.println(" 'Applications' option is greyed out as 'Activation is Off' ");
								}
								else
								{
									System.out.println(" 'Applications' option is not greyed Out even when Activation is off");
								}
								driver.sendKeyEvent(AndroidKeyCode.HOME);
								Stop_Server();
							}catch(InterruptedException e){
								e.printStackTrace();
							}catch(IOException f){
								f.printStackTrace();
							}
							
					    }
					    
	
	
	
    				    //TC_ID-SG_20 - R-3.4.1
					    @Test (priority=21)
						public void testSafeguard20() throws IOException, InterruptedException {
							try {
							log.info("Executing the TestCase 20");
							Start_Server();
							Init_app();

						Page_Object_SG SG_POB = new Page_Object_SG(driver);
						String Activation_Status = SG_POB.Activation_status.get(0).getText();
								
						 if(Activation_Status.equals("Off"))
							{
						 SG_POB.Activation_Off.click();
						 SG_POB.Input_PIN_Screen.sendKeys("1234");	
						 Thread.sleep(5000);
						 driver.sendKeyEvent(20);
						 driver.sendKeyEvent(23);
							}
					    Explicit_Wait(SG_POB.SG_Features_option, 25);
						SG_POB.SG_Features_option.click();
						Explicit_Wait(SG_POB.Input_PIN_Screen, 25);
						SG_POB.Input_PIN_Screen.sendKeys("1234");	
						Thread.sleep(5000);
						driver.sendKeyEvent(20);
						driver.sendKeyEvent(23);
						Thread.sleep(4000);		 
						System.out.println("Features option present in the list are: \n 1 "+SG_POB.SG_Features_list.get(0).getText()+ "\n 2 " +SG_POB.SG_Features_list.get(1).getText()+"\n 3 " +SG_POB.SG_Features_list.get(2).getText()+"\n 4 " +SG_POB.SG_Features_list.get(3).getText()+"\n 5 " +SG_POB.SG_Features_list.get(4).getText()+ "\n All the 5 restrict features are available in the apps list");
						driver.sendKeyEvent(AndroidKeyCode.HOME);
						Stop_Server();
						}catch(InterruptedException e){
						 e.printStackTrace();
						}catch(IOException f){
						 f.printStackTrace();
					}
				 }
					   
  
	
	
	                      //TC_ID-SG_21 - R-3.4.2
					    @Test (priority=22)
						public void testSafeguard21() throws IOException, InterruptedException {
							try {
							log.info("Executing the TestCase 21");
							Start_Server();
							Init_app();

						Page_Object_SG SG_POB = new Page_Object_SG(driver);
						String Activation_Status = SG_POB.Activation_status.get(0).getText();
								
						 if(Activation_Status.equals("Off"))
							{
						 SG_POB.Activation_Off.click();
						 SG_POB.Input_PIN_Screen.sendKeys("1234");	
						 Thread.sleep(5000);
						 driver.sendKeyEvent(20);
						 driver.sendKeyEvent(23);
							}
					    Explicit_Wait(SG_POB.SG_Features_option, 25);
						SG_POB.SG_Features_option.click();
						Explicit_Wait(SG_POB.Input_PIN_Screen, 25);
						
						if(SG_POB.Input_PIN_Screen.isDisplayed()){
							System.out.println(" 'Features' option is restricted with a PIN");
						} else {
							System.out.println(" 'Features' option is not restricted with a PIN");
						}
						driver.sendKeyEvent(AndroidKeyCode.HOME);
						Stop_Server();
					}catch(InterruptedException e){
						e.printStackTrace();
					}catch(IOException f){
						f.printStackTrace();
					}
			}
	

	
	
	//TC_ID-SG_22 - R-3.4.3
    @Test (priority=23)
	public void testSafeguard22() throws IOException, InterruptedException {
		try {
			log.info("Executing the TestCase 22");
			Start_Server();
			Init_app();

			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			String Activation_Status = SG_POB.Activation_status.get(0).getText();
			
			if(Activation_Status == "Off")
			{
				 SG_POB.Activation_Off.click();
				 SG_POB.Input_PIN_Screen.sendKeys("1234");
				 Thread.sleep(10000);
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
			}
			Explicit_Wait(SG_POB.Features_option, 25);		
			SG_POB.Features_option.click();
			SG_POB.Input_PIN_Screen.sendKeys("1234");
			Thread.sleep(5000);
			driver.sendKeyEvent(20);
			driver.sendKeyEvent(23);
			Thread.sleep(4000);
			
			if(SG_POB.SG_Features_ModifyPhnbk_Chkbox_enabled.isDisplayed()){
				System.out.println(" 'Modify Phonebook' feature is enabled to restrict the access");
			} else {
				System.out.println(" 'Modify Phonebook' feature is disabled to restrict the access");
			}
			SG_POB.SG_Features_list.get(0).click();
			Thread.sleep(4000);
			driver.sendKeyEvent(AndroidKeyCode.MENU);
			Thread.sleep(4000);
			driver.sendKeyEvent(23);
			Explicit_Wait(SG_POB.Features_option, 30);
			SG_POB.Features_option.click();
			SG_POB.Input_PIN_Screen.sendKeys("1234");
			Thread.sleep(5000);
			driver.sendKeyEvent(20);
			driver.sendKeyEvent(23);
			Thread.sleep(4000);
			
			if(SG_POB.SG_Features_ModifyPhnbk_Chkbox_disabled.isDisplayed()){
				System.out.println(" 'Modify Phonebook' feature is disabled to restrict the access");
			}
			else
			{
				System.out.println(" 'Modify Phonebook' feature is enabled to restrict the access");
			}
			driver.sendKeyEvent(AndroidKeyCode.HOME);
			Stop_Server();
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch(IOException f){
			f.printStackTrace();
		}
    }
    
  
	
	//TC_ID-SG_23 - R-3.4.4
    @Test (priority=24)
	public void testSafeguard23() throws IOException, InterruptedException {
		try {
			log.info("Executing the TestCase 23");
			Start_Server();
			Init_app();

			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			String Activation_Status = SG_POB.Activation_status.get(0).getText();
			
			if(Activation_Status.equals("Off"))
			{
				 SG_POB.Activation_Off.click();
				 SG_POB.Input_PIN_Screen.sendKeys("1234");	
				 Thread.sleep(5000);
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
			}
			Explicit_Wait( SG_POB.Features_option, 25);
			 SG_POB.Features_option.click();
			 SG_POB.Input_PIN_Screen.sendKeys("4321");	
			 Thread.sleep(5000);
			 driver.sendKeyEvent(20);
			 driver.sendKeyEvent(23);
			 Snapshotscreen();
		    if(SG_POB.Input_PIN_Screen.isDisplayed()){
		    	System.out.println("ON PIN verification failure application is asked for entering the PIN again");
		    }
		    driver.sendKeyEvent(AndroidKeyCode.HOME); 
		    Stop_Server();
	         }catch(InterruptedException e){
	        	 e.printStackTrace();
	         }catch(IOException f){
	        	 f.printStackTrace();
	         }
		
        }
	
	
	
   //TC_ID-SG_24 - R-3.4.5
    @Test (priority=25)
	public void testSafeguard24() throws IOException, InterruptedException {
		try {
			log.info("Executing the TestCase 24");
			Start_Server();
			Init_app();

			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			String Activation_Status = SG_POB.Activation_status.get(0).getText();
			
			if(Activation_Status.equals("Off"))
			{
				 SG_POB.Activation_Off.click();
				 SG_POB.Input_PIN_Screen.sendKeys("1234");	
				 Thread.sleep(5000);
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
			}
			 Explicit_Wait(SG_POB.Features_option, 25);
			 SG_POB.Features_option.click();
				SG_POB.Input_PIN_Screen.sendKeys("1234");	
				Thread.sleep(5000);
				driver.sendKeyEvent(20);
				driver.sendKeyEvent(23);
				
				driver.sendKeyEvent(AndroidKeyCode.MENU);
				
				if(SG_POB.SG_apps_Save_option.isDisplayed())
				{
					System.out.println("Save option is available in the 'Features' Menu : "+SG_POB.SG_apps_Save_option.getText());
				}
				else
				{
					System.out.println("Save option is not available");
				}
				
				if(SG_POB.SG_apps_Cancel_option.isDisplayed()){
					System.out.println("Cancel option is available in the 'Features' Menu : "+SG_POB.SG_apps_Cancel_option.getText());
				}
				else
				{
					System.out.println("Cancel option is not available");
				}
				driver.sendKeyEvent(AndroidKeyCode.HOME);
				Stop_Server();
			}catch(InterruptedException e){
			 e.printStackTrace();
			}catch(IOException f){
			 f.printStackTrace();
			}
	    }
			
	
	

       //TC_ID-SG_25 - R-3.4.6
    @Test (priority=26)
	public void testSafeguard25() throws IOException, InterruptedException {
		try {
			log.info("Executing the TestCase 25");
			Start_Server();
			Init_app();

			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			String Activation_Status = SG_POB.Activation_status.get(0).getText();
			
			if(Activation_Status.equals("Off"))
			{
				 SG_POB.Activation_Off.click();
				 SG_POB.Input_PIN_Screen.sendKeys("1234");	
				 Thread.sleep(5000);
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
			}
			Explicit_Wait(SG_POB.Features_option, 25);
			SG_POB.Features_option.click();
			SG_POB.Input_PIN_Screen.sendKeys("1234");	
			 Thread.sleep(5000);
			 driver.sendKeyEvent(20);
			 driver.sendKeyEvent(23);
			 
			 SG_POB.SG_Features_list.get(0).click();
			
			driver.sendKeyEvent(AndroidKeyCode.MENU);
			Explicit_Wait(SG_POB.SG_apps_Save_option, 60);
			SG_POB.SG_apps_Save_option.click();
			
			if(SG_POB.Features_option.isDisplayed()){
				System.out.println("As expected - After the save operation screen is navigated to previous screen");
			}
			else {
				System.out.println("Save operation is not performed (or) screen didn't navigate to previous screen");
			}
			driver.sendKeyEvent(AndroidKeyCode.HOME);
			Stop_Server();
			}catch(InterruptedException e){
			 e.printStackTrace();
			}catch(IOException f){
			 f.printStackTrace();
			}
			
   }

	
	
	     //TC_ID-SG_26 - R-3.4.7
		    @Test (priority=27)
			public void testSafeguard26() throws IOException, InterruptedException {
				try {
					log.info("Executing the TestCase 26");
					Start_Server();
					Init_app();

					Page_Object_SG SG_POB = new Page_Object_SG(driver);
					String Activation_Status = SG_POB.Activation_status.get(0).getText();
					
					if(Activation_Status.equals("Off"))
					{
						 SG_POB.Activation_Off.click();
						 SG_POB.Input_PIN_Screen.sendKeys("1234");	
						 Thread.sleep(5000);
						 driver.sendKeyEvent(20);
						 driver.sendKeyEvent(23);
					}
					Explicit_Wait(SG_POB.Features_option, 25);
					SG_POB.Features_option.click();
					SG_POB.Input_PIN_Screen.sendKeys("1234");	
					 Thread.sleep(5000);
					 driver.sendKeyEvent(20);
					 driver.sendKeyEvent(23);
					 
					SG_POB.SG_Features_list.get(0).click();
					
					driver.sendKeyEvent(AndroidKeyCode.MENU);
					Explicit_Wait(SG_POB.SG_apps_Cancel_option, 60);
					SG_POB.SG_apps_Cancel_option.click();
					
					if(SG_POB.Features_option.isDisplayed()){
						System.out.println("As expected - After the cancel operation screen is navigated to previous screen");
					}
					else {
						System.out.println("Cancel operation is not performed (or) screen didn't navigate to previous screen");
					}
					driver.sendKeyEvent(AndroidKeyCode.HOME);
					Stop_Server();
				}catch(InterruptedException e){
				 e.printStackTrace();
				}catch(IOException f){
				 f.printStackTrace();
				}

		 }
	
	
	
		    //TC_ID-SG_27 - R-3.4.9
		    @Test (priority=28)
			public void testSafeguard27() throws IOException, InterruptedException {
				try {
					log.info("Executing the TestCase 27");
					Start_Server();
					Init_app();

					Page_Object_SG SG_POB = new Page_Object_SG(driver);
					String Activation_Status = SG_POB.Activation_status.get(0).getText();
					
					if(Activation_Status.equals("Off"))
					{
						 SG_POB.Activation_Off.click();
						 SG_POB.Input_PIN_Screen.sendKeys("1234");	
						 Thread.sleep(5000);
						 driver.sendKeyEvent(20);
						 driver.sendKeyEvent(23);
					}
					Explicit_Wait(SG_POB.Features_option, 25);
					SG_POB.Features_option.click();
					SG_POB.Input_PIN_Screen.sendKeys("1234");	
					 Thread.sleep(5000);
					 driver.sendKeyEvent(20);
					 driver.sendKeyEvent(23);	
					 
					 driver.sendKeyEvent(AndroidKeyCode.MENU);
					 
					if(SG_POB.SG_apps_SelectAll_option.isDisplayed())
					System.out.println(" 'Select All' option is displayed in 'Features' list menu: "+SG_POB.SG_apps_SelectAll_option.getText());
 
					else
					System.out.println(" 'Select All' option is not displayed in 'Features' list menu");

					if(SG_POB.SG_apps_UnselectAll_option.isDisplayed()) 
				    System.out.println(" 'UnSelect All' option is displayed in 'Features' list menu: "+SG_POB.SG_apps_UnselectAll_option.getText());
					
					else 
					System.out.println(" 'UnSelect All' option is not displayed in 'Features' list menu");
					 
					driver.sendKeyEvent(AndroidKeyCode.HOME);
					Stop_Server();	
				}catch(InterruptedException e){
					e.printStackTrace();
				}catch(IOException f){
					f.printStackTrace();
				}
				
		    }

	
	
	         //TC_ID-SG_28 - R-3.4.10
		    @Test (priority=29)
			public void testSafeguard28() throws IOException, InterruptedException {
				try {
					log.info("Executing the TestCase 28");
					Start_Server();
					Init_app();

					Page_Object_SG SG_POB = new Page_Object_SG(driver);
					String Activation_Status = SG_POB.Activation_status.get(0).getText();
					
					if(Activation_Status.equals("On"))
					{
						 SG_POB.Activation_On.click();
						 SG_POB.Input_PIN_Screen.sendKeys("1234");	
						 Thread.sleep(5000);
						 driver.sendKeyEvent(20);
						 driver.sendKeyEvent(23);
					}
					Thread.sleep(5000);
					
					if(Activation_Status.equals("Off"))
					{					
						SG_POB.Features_option.click();
						Thread.sleep(5000);
	                    System.out.println(" 'Features' option is Greyed out as 'Activation is Off' ");
					}
					else
					{
						System.out.println(" 'Features' option is not Greyed Out even when Activation is off");
					}
					
					driver.sendKeyEvent(AndroidKeyCode.HOME);
					Stop_Server();
				}catch(InterruptedException e){
					e.printStackTrace();
				}catch(IOException f){
					f.printStackTrace();
				}
				
		    }
	
	
    //TC_ID-SG_29 - R-3.5.1
    @Test (priority=30)
	public void testSafeguard29() throws IOException, InterruptedException {
		try {
			log.info("Executing the TestCase 29");
			Start_Server();
			Init_app();

			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			String Activation_Status = SG_POB.Activation_status.get(0).getText();
			
			if(Activation_Status.equals("Off"))
			{
				 SG_POB.Activation_Off.click();
				 SG_POB.Input_PIN_Screen.sendKeys("1234");	
				 Thread.sleep(5000);
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
			}
            Explicit_Wait(SG_POB.Change_PIN_option, 25);
			SG_POB.Change_PIN_option.click();
			if (SG_POB.Input_OldPIN_Screen.isDisplayed())
			{
				System.out.println("On selecting the 'Change PIN' option user is prompted with PIN screen for verification");
			} 
			else
			{
				System.out.println("PIN Screen is not prompted for verification");
			}
			driver.sendKeyEvent(AndroidKeyCode.HOME);
			Stop_Server();
		        }catch(InterruptedException e){
			     e.printStackTrace();
		        }catch(IOException f){
			     f.printStackTrace();
		      }
		
        }

	
	   //TC_ID-SG_31 - R-3.5.2
          @Test (priority=32)
	      public void testSafeguard31() throws IOException, InterruptedException {
		      try {
			   log.info("Executing the TestCase 31");
			   Start_Server();
			   Init_app();

			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			String Activation_Status = SG_POB.Activation_status.get(0).getText();
			
			if(Activation_Status.equals("Off"))
			{
				 SG_POB.Activation_Off.click();
				 SG_POB.Input_PIN_Screen.sendKeys("1234");	
				 Thread.sleep(5000);
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
			}
            Explicit_Wait(SG_POB.Change_PIN_option, 25);
			SG_POB.Change_PIN_option.click();
			Explicit_Wait(SG_POB.Input_OldPIN_Screen, 25);
			SG_POB.Input_OldPIN_Screen.sendKeys("1234");
			Thread.sleep(5000);
			 driver.sendKeyEvent(20);
			 driver.sendKeyEvent(23);
			
			Explicit_Wait(SG_POB.Input_NewPIN_Screen, 25);
			
			if(SG_POB.Input_NewPIN_Screen.isDisplayed()){
				System.out.println("On successful PIN verification application has prompt user with PIN screen to enter new PIN");
				SG_POB.Input_NewPIN_Screen.sendKeys("1111");
				Thread.sleep(5000);
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
			}
				 Explicit_Wait(SG_POB.Input_Again_Screen, 25);
				 SG_POB.Input_Again_Screen.sendKeys("1111");
				 Thread.sleep(5000);
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
				 System.out.println("prompt for 'New PIN' screen to enter new PIN is followed by 'Input again' PIN screen "); 
	             SG_POB.Change_PIN_option.click();
	             SG_POB.Input_OldPIN_Screen.sendKeys("1111");
	             Thread.sleep(5000);
	             driver.sendKeyEvent(20);
	             driver.sendKeyEvent(23);
	
	             Explicit_Wait(SG_POB.Input_NewPIN_Screen, 25);
	
	             if(SG_POB.Input_NewPIN_Screen.isDisplayed()){
		         System.out.println("On successful PIN verification application has prompt user with PIN screen to enter new PIN");
		         SG_POB.Input_NewPIN_Screen.sendKeys("1234");
		         Thread.sleep(5000);
		         driver.sendKeyEvent(20);
		         driver.sendKeyEvent(23);
		 
		         Explicit_Wait(SG_POB.Input_Again_Screen, 25);
		         SG_POB.Input_Again_Screen.sendKeys("1234");
		         Thread.sleep(5000);
		         driver.sendKeyEvent(20);
		         driver.sendKeyEvent(23);

			}
	        driver.sendKeyEvent(AndroidKeyCode.HOME);
			Stop_Server();
		      }catch(InterruptedException e){
		    	  e.printStackTrace();
		      }catch(IOException f){
		    	  f.printStackTrace();
		      }
          }
	
          
          
   	   //TC_ID-SG_32 - R-3.5.3
          @Test (priority=33)
	      public void testSafeguard32() throws IOException, InterruptedException {
		      try {
			   log.info("Executing the TestCase 32");
			   Start_Server();
			   Init_app();

			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			String Activation_Status = SG_POB.Activation_status.get(0).getText();
			
			if(Activation_Status.equals("Off"))
			{
				 SG_POB.Activation_Off.click();
				 SG_POB.Input_PIN_Screen.sendKeys("1234");	
				 Thread.sleep(5000);
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
			}
            Explicit_Wait(SG_POB.Change_PIN_option, 25);
			SG_POB.Change_PIN_option.click();
			Explicit_Wait(SG_POB.Input_OldPIN_Screen, 25);
			SG_POB.Input_OldPIN_Screen.sendKeys("1234");
			 Thread.sleep(5000);
			 driver.sendKeyEvent(20);
			 driver.sendKeyEvent(23);
			Explicit_Wait(SG_POB.Input_NewPIN_Screen, 25);
			
			if(SG_POB.Input_NewPIN_Screen.isDisplayed()){
				System.out.println("On successful PIN verification application has prompt user with PIN screen to enter new PIN");
				SG_POB.Input_NewPIN_Screen.sendKeys("1111");
				Thread.sleep(5000);
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
				 
				 Explicit_Wait(SG_POB.Input_Again_Screen, 25);
				 SG_POB.Input_Again_Screen.sendKeys("1111");
				 Thread.sleep(5000);
				 driver.sendKeyEvent(20);
				 Snapshotscreen();
				 driver.sendKeyEvent(23);
				 Snapshotscreen();
				 
				 System.out.println("prompt for 'New PIN' screen to enter new PIN is followed by 'Input again' PIN screen ");
				 SG_POB.Change_PIN_option.click();
				 SG_POB.Input_OldPIN_Screen.sendKeys("1111");
				 if(SG_POB.Input_OldPIN_Screen.isDisplayed()){
					 System.out.println("PIN changed successfully");
					 Thread.sleep(5000);
		             driver.sendKeyEvent(20);
		             driver.sendKeyEvent(23);
		
		             Explicit_Wait(SG_POB.Input_NewPIN_Screen, 25);
		
		             if(SG_POB.Input_NewPIN_Screen.isDisplayed()){
			         SG_POB.Input_NewPIN_Screen.sendKeys("1234");
			         Thread.sleep(5000);
			         driver.sendKeyEvent(20);
			         driver.sendKeyEvent(23);
		             }
			         Explicit_Wait(SG_POB.Input_Again_Screen, 25);
			         SG_POB.Input_Again_Screen.sendKeys("1234");
			         Thread.sleep(5000);
			         driver.sendKeyEvent(20);
			         driver.sendKeyEvent(23);
				 }		 
			}
			driver.sendKeyEvent(AndroidKeyCode.HOME);
			Stop_Server();
		      }catch(InterruptedException e){
		    	  e.printStackTrace();
		      }catch(IOException f){
		    	  f.printStackTrace();
		      }
          }
          
          
    	   //TC_ID-SG_33 - R-3.5.4
          @Test (priority=34)
	      public void testSafeguard33() throws IOException, InterruptedException {
		      try {
			   log.info("Executing the TestCase 33");
			   Start_Server();
			   Init_app();

			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			String Activation_Status = SG_POB.Activation_status.get(0).getText();
			
			if(Activation_Status.equals("Off"))
			{
				 SG_POB.Activation_Off.click();
				 SG_POB.Input_PIN_Screen.sendKeys("1234");	
				 Thread.sleep(5000);
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
			}
    
			SG_POB.Change_PIN_option.click();
			Explicit_Wait(SG_POB.Input_OldPIN_Screen, 25);
			SG_POB.Input_OldPIN_Screen.sendKeys("1234");
			 Thread.sleep(5000);
			 driver.sendKeyEvent(20);
			 driver.sendKeyEvent(23);
			Explicit_Wait(SG_POB.Input_NewPIN_Screen, 25);
			
			if(SG_POB.Input_NewPIN_Screen.isDisplayed()){
				System.out.println("On successful PIN verification application has prompt user with PIN screen to enter new PIN");
				SG_POB.Input_NewPIN_Screen.sendKeys("1111");
				Thread.sleep(5000);
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
				 
				 Explicit_Wait(SG_POB.Input_Again_Screen, 25);
				 SG_POB.Input_Again_Screen.sendKeys("1234");
				 Thread.sleep(5000);
				 driver.sendKeyEvent(20);
				 Snapshotscreen();
				 driver.sendKeyEvent(23);
				 Snapshotscreen();
				 
				 System.out.println("prompt for 'New PIN' screen to enter new PIN is followed by 'Input again' PIN screen ");
				 if(SG_POB.Input_NewPIN_Screen.isDisplayed()){
					 System.out.println("As the PIN doesn't match the re-entered PIN - PIN didn't changed");
				 }

               }
	        driver.sendKeyEvent(AndroidKeyCode.HOME);
			Stop_Server();
		     }catch(InterruptedException e){
		    	 e.printStackTrace();
		     }catch(IOException f){
		    	 f.printStackTrace();
		     }      
          }
          

            //TC_ID-SG_30 - R-3.5.6
          @Test (priority=31)
	      public void testSafeguard30() throws IOException, InterruptedException {
		      try {
			   log.info("Executing the TestCase 30");
			   Start_Server();
			   Init_app();

			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			String Activation_Status = SG_POB.Activation_status.get(0).getText();
			
			if(Activation_Status.equals("Off"))
			{
				 SG_POB.Activation_Off.click();
				 SG_POB.Input_PIN_Screen.sendKeys("1234");	
				 Thread.sleep(5000);
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
			}
            Explicit_Wait(SG_POB.Change_PIN_option, 25);
			SG_POB.Change_PIN_option.click();
			Explicit_Wait(SG_POB.Input_OldPIN_Screen, 25);
			SG_POB.Input_OldPIN_Screen.sendKeys("1234");
			Thread.sleep(5000);
			driver.sendKeyEvent(20);
			driver.sendKeyEvent(23);
			
			Explicit_Wait(SG_POB.Input_NewPIN_Screen, 25);
			if(SG_POB.Input_NewPIN_Screen.isDisplayed()){
				System.out.println("Default PIN is 1234");
			}
			else {
				System.out.println("Default PIN is not 1234");
			}
			driver.sendKeyEvent(AndroidKeyCode.HOME);
			Stop_Server();
		 }catch(InterruptedException e){
			 e.printStackTrace();
		 }catch(IOException f){
			 f.printStackTrace();
		 }
       }	
          
          
          
    	   //TC_ID-SG_34 - R-3.6.1
          @Test (priority=35)
	      public void testSafeguard34() throws IOException, InterruptedException {
		      try {
		    	 
			   log.info("Executing the TestCase 34");
			   Start_Server();
			   Init_app();

			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			
			SG_POB.Help_option.click();
			System.out.println(" 'Help' option contains the below description : \n"+SG_POB.Help_description.getText());
			
			driver.sendKeyEvent(AndroidKeyCode.HOME);
			Stop_Server();
		   }catch(InterruptedException e){
			   e.printStackTrace();
		   }catch(IOException f){
			   f.printStackTrace();
		   }
          }
          
         
      	   //TC_ID-SG_35 - R-3.8.1
          @Test (priority=36)
	      public void testSafeguard35() throws IOException, InterruptedException {
		      try {
		    	 
			   log.info("Executing the TestCase 35");
			   Start_Server();
			   Init_app();

			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			String Activation_status = SG_POB.Activation_status.get(0).getText();
			
			if(Activation_status == "Off")
			{
				 SG_POB.Activation_Off.click();
				 SG_POB.Input_PIN_Screen.sendKeys("1234");
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
			}	 
			 System.out.println("Menu under Safe Guard are: "+SG_POB.Activation_option.getText() +" "+SG_POB.Applications_option.getText() +" "+SG_POB.Features_option.getText() +" "+SG_POB.Change_PIN_option.getText() +" "+SG_POB.Help_option.getText() ); 
			 driver.sendKeyEvent(AndroidKeyCode.HOME);
			 Explicit_Wait(SG_POB.settings_option, 25);
			 SG_POB.settings_option.click();
			 
			 for(int i=1; i<=13; i++){
				 driver.sendKeyEvent(20);
			 }
			 SG_POB.Settings_LanguageNinput_option.click();
			 Explicit_Wait(SG_POB.Settings_Language_option, 25);
			 SG_POB.Settings_Language_option.click();
			 driver.sendKeyEvent(20);
			 driver.sendKeyEvent(23);
			 driver.sendKeyEvent(AndroidKeyCode.HOME);
		     driver.startActivity("com.sonim.safeguard", "com.sonim.safeguard.SGSettingsPreferenceActivity");
			 String Activation_status_spanish = SG_POB.Activation_status.get(0).getText();
				
				if(Activation_status_spanish == "Apagar")
				{
					 SG_POB.Activation_Off_spanish.click();
					 SG_POB.Input_PIN_Screen_spanish.sendKeys("1234");
					 driver.sendKeyEvent(20);
					 driver.sendKeyEvent(23);
				}	 
		     System.out.println("Menu under Safe Guard are: "+SG_POB.Activation_option_spanish.getText() +" "+SG_POB.Applications_option_spanish.getText() +" "+SG_POB.Features_option_spanish.getText() +" "+SG_POB.Change_PIN_option_spanish.getText() +" "+SG_POB.Help_option_spanish.getText() ); 
			 
		     driver.sendKeyEvent(AndroidKeyCode.HOME);
			 Stop_Server();
			 
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch(IOException f){
			f.printStackTrace();
		}
	}
          
          //TC_ID-SG_36 - R-3.8.2
          @Test (priority=37)
	      public void testSafeguard36() throws IOException, InterruptedException {
		      try {
		    	 
			   log.info("Executing the TestCase 36");
			   Start_Server();
			   Init_app();

			Page_Object_SG SG_POB = new Page_Object_SG(driver);
			 String Activation_status_spanish = SG_POB.Activation_status.get(0).getText();
			
			if(Activation_status_spanish == "Apagar")
			{
				SG_POB.Activation_Off_spanish.click();
				 SG_POB.Input_PIN_Screen_spanish.sendKeys("1234");
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
			}	 
			 System.out.println("Menu under Safe Guard are: "+SG_POB.Activation_option_spanish.getText() +" "+SG_POB.Applications_option_spanish.getText() +" "+SG_POB.Features_option_spanish.getText() +" "+SG_POB.Change_PIN_option_spanish.getText() +" "+SG_POB.Help_option_spanish.getText() ); 
		     driver.sendKeyEvent(AndroidKeyCode.HOME);
	     driver.sendKeyEvent(AndroidKeyCode.HOME);
		 Explicit_Wait(SG_POB.settings_option_Spanish, 25);
		 SG_POB.settings_option_Spanish.click();
		 
		 for(int i=1; i<=13; i++){
			 driver.sendKeyEvent(20);
		 }
		 SG_POB.Settings_LanguageNinput_option_Spanish.click();
		 Explicit_Wait(SG_POB.Settings_Language_option_Spanish, 25);
		 SG_POB.Settings_Language_option_Spanish.click();
		 driver.sendKeyEvent(23);  //Language changed to English
		 
		 driver.sendKeyEvent(AndroidKeyCode.HOME);
		 Stop_Server();
			 
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch(IOException f){
			f.printStackTrace();
		}
	}
          
          
          //TC_ID-SG_37 - R-3.11.1
          @Test (priority=38)
	      public void testSafeguard37() throws IOException, InterruptedException {
		      try {
		    	 
			   log.info("Executing the TestCase 37");
			   Start_Server();
			   Init_app();
			 
				Page_Object_SG SG_POB = new Page_Object_SG(driver);
				String Activation_Status = SG_POB.Activation_status.get(0).getText();
				
				if(Activation_Status.equals("Off"))
				{
					 SG_POB.Activation_Off.click();
					 SG_POB.Input_PIN_Screen.sendKeys("1234");	
					 Thread.sleep(5000);
					 driver.sendKeyEvent(20);
					 driver.sendKeyEvent(23);
				}
				
				Explicit_Wait(SG_POB.Applications_option, 25);		
				SG_POB.Applications_option.click();		
				Explicit_Wait(SG_POB.Input_PIN_Screen, 25);
				SG_POB.Input_PIN_Screen.sendKeys("1234");
				Thread.sleep(5000);
				driver.sendKeyEvent(20);
				driver.sendKeyEvent(23);
				Thread.sleep(5000);
				
				SG_POB.SG_Apps_List_chkbox.get(0).clear();
				Thread.sleep(3000);
				driver.sendKeyEvent(AndroidKeyCode.MENU);
				Thread.sleep(3000);
				driver.sendKeyEvent(23);
				System.out.println("Camera app is disabled to restrict the access");
                
				if(!SG_POB.Applications_option.isDisplayed())
				{
					driver.sendKeyEvent(AndroidKeyCode.BACK);
					driver.sendKeyEvent(AndroidKeyCode.BACK);
					
				}
				Explicit_Wait(SG_POB.Applications_option, 25);		
				SG_POB.Applications_option.click();		
				Explicit_Wait(SG_POB.Input_PIN_Screen, 25);
				SG_POB.Input_PIN_Screen.sendKeys("1234");
				Thread.sleep(5000);
				driver.sendKeyEvent(20);
				driver.sendKeyEvent(23);
				Thread.sleep(5000);
				SG_POB.SG_Cam_option.click();
						Thread.sleep(3000);
						driver.sendKeyEvent(AndroidKeyCode.MENU);
						Thread.sleep(3000);
						driver.sendKeyEvent(23);
						
						System.out.println("Camera app is enabled to restrict the access");
				
				 driver.sendKeyEvent(AndroidKeyCode.HOME);
				 Explicit_Wait(SG_POB.Camera_App, 25);
				 SG_POB.Camera_App.click();
				 Explicit_Wait(SG_POB.Enter_PIN, 25);
				 if(SG_POB.Enter_PIN.isDisplayed())
				 {
					  System.out.println("Camera app is restricted");
					  SG_POB.Enter_PIN.sendKeys("1234");
					  Thread.sleep(5000);
					  driver.sendKeyEvent(23);
				 }
					 
		      else 
				 {
					 System.out.println("Failed to restrict camera app");
				 }
				 
		      Explicit_Wait(SG_POB.Camera_Capture_btn, 25);
				 if(SG_POB.Camera_Capture_btn.isDisplayed())
				 {
					 System.out.println("Successfully unlocked the camera app");
				 }
					 
				 driver.sendKeyEvent(AndroidKeyCode.HOME);
				 Explicit_Wait(SG_POB.Camera_App, 25);
				 SG_POB.Camera_App.click();
				 Explicit_Wait(SG_POB.Enter_PIN, 25);
				 if(SG_POB.Enter_PIN.isDisplayed())
				 {
					  System.out.println("Camera app is restricted, once navigating back to home screen");
					  SG_POB.Enter_PIN.sendKeys("1234");
					driver.sendKeyEvent(23);
				 }
					
		      else 
				 {
					 System.out.println("Failed to restrict camera app once navigating to Home screen");
				 }
				 Explicit_Wait(SG_POB.Camera_Capture_btn, 25);
				 if(SG_POB.Camera_Capture_btn.isDisplayed())
				 {
					 System.out.println("Successfully unlocked the camera app");
				 }
				 driver.sendKeyEvent(AndroidKeyCode.HOME);
				 Stop_Server();
          }catch(InterruptedException e){
  		   e.printStackTrace();
      	  }catch(IOException f){
      	   f.printStackTrace();
      		}
      	  
      	  }
          
          
          //TC_ID-SG_38 - R-3.11.3
          @Test (priority=39)
	      public void testSafeguard38() throws IOException, InterruptedException {
		      try {
		    	 
			   log.info("Executing the TestCase 38");
			   Start_Server();
			   Init_app();
			 
				Page_Object_SG SG_POB = new Page_Object_SG(driver);
				String Activation_Status = SG_POB.Activation_status.get(0).getText();
				
				if(Activation_Status.equals("Off"))
				{
					 SG_POB.Activation_Off.click();
					 SG_POB.Input_PIN_Screen.sendKeys("1234");	
					 Thread.sleep(5000);
					 driver.sendKeyEvent(20);
					 driver.sendKeyEvent(23);
				}
				Explicit_Wait(SG_POB.Applications_option, 25);
				 SG_POB.Applications_option.click();
				 SG_POB.Input_PIN_Screen.sendKeys("1234");	
				 Thread.sleep(3000);
				 driver.sendKeyEvent(20);
				 driver.sendKeyEvent(23);
				 
				 for (int i=1; i<=5; i++)
				 { 
					driver.sendKeyEvent(20);						
				 }
				 
				 Explicit_Wait(SG_POB.SG_apps_Messaging_chkbox, 60);
				 SG_POB.SG_apps_Messaging_chkbox.click();
				
				driver.sendKeyEvent(AndroidKeyCode.MENU);
				Explicit_Wait(SG_POB.SG_apps_Save_option, 60);
				SG_POB.SG_apps_Save_option.click();
				Thread.sleep(4000);
				driver.sendKeyEvent(AndroidKeyCode.HOME);
				Explicit_Wait(SG_POB.settings_option, 25);
				
				SG_POB.settings_option.click();
				
				 for (int i=1; i<=7; i++)
				 { 
					driver.sendKeyEvent(20);						
				 }
             SG_POB.Display_option.click();
             Explicit_Wait(SG_POB.Display_option, 25);
             SG_POB.Display_Sleep_option.click();
             
             for (int i=1; i<=9; i++)
			 { 
				driver.sendKeyEvent(19);			//DPAD_up key		
			 }
             
             SG_POB.Display_Sleep_15_Seconds_option.click();
             driver.sendKeyEvent(AndroidKeyCode.HOME);
             Explicit_Wait(SG_POB.Messaging_App, 25);
             SG_POB.Messaging_App.click();
             Explicit_Wait(SG_POB.Enter_PIN, 25);
             if(SG_POB.Enter_PIN.isDisplayed())
             {
            	 System.out.println("Message app is restricted to access");
            	 Explicit_Wait(SG_POB.Enter_PIN, 25);
            	 SG_POB.Enter_PIN.sendKeys("1234");
            	 driver.sendKeyEvent(23);
             }
             Explicit_Wait(SG_POB.Messaging_bar_title, 60);
             if(SG_POB.Messaging_bar_title.isDisplayed())
             {
            	System.out.println("Message app has been unlocked by entering PIN"); 
             }
             
             Thread.sleep(30000);
             driver.sendKeyEvent(17);
             driver.sendKeyEvent(17);
             
             if(SG_POB.DeviceLock_PressnholdUI_option.isDisplayed())
             {
            	 System.out.println("device is locked");
             }
             driver.sendKeyEvent(17);   //Star Key
             Process process = Runtime.getRuntime().exec("adb shell input keyevent --longpress 17");
             Explicit_Wait(SG_POB.Enter_PIN, 60);
             if(SG_POB.Enter_PIN.isDisplayed()){
            	 System.out.println("PIN entry pop up has been prompted successfully after unlocking the device");
             }
             driver.sendKeyEvent(AndroidKeyCode.HOME);
             Stop_Server();
	      }catch(InterruptedException e){
	    	  e.printStackTrace();
	      }catch(IOException f){
	    	  f.printStackTrace();
	      }
		      
      }
             
             
}
		
		