package SG_Page_Object_Component;

import java.util.List;

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
	
	@FindBy(xpath="//*[@resource-id='android:id/summary'][@class='android.widget.TextView']")
	public List<WebElement> Activation_status;
	
	@FindBy(xpath="//*[@resource-id='android:id/summary'][@class='android.widget.TextView']")
	public List<WebElement> Activation_status_spanish;
	
	@FindBy(xpath="//*[@resource-id='android:id/summary'][@text='Off']")
	public WebElement Activation_Off;
	
	@FindBy(xpath="//*[@resource-id='android:id/summary'][@text='Apagar']")
	public WebElement Activation_Off_spanish;
	
	@FindBy(xpath="//*[@resource-id='android:id/summary'][@text='On']")
	public WebElement Activation_On;
	
	@FindBy(xpath="//*[@resource-id='android:id/summary'][@text='Encender']")
	public WebElement Activation_On_Spanish;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Activation']")
	public WebElement Activation_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Activación']")
	public WebElement Activation_option_spanish;
	
	@FindBy(xpath="//*[@resource-id='android:id/button1'][@text='OK']")
	public WebElement Activation_OK_btn;
	
	@FindBy(xpath="//*[@resource-id='android:id/message'][@text='Input PIN']")
	public WebElement Input_PIN_Screen;
	
	@FindBy(xpath="//*[@resource-id='android:id/message'][@text='PIN de entrada']")
	public WebElement Input_PIN_Screen_spanish;
	
	@FindBy(xpath="//*[@resource-id='android:id/message'][@text='Input Old PIN']")
	public WebElement Input_OldPIN_Screen;
	
	@FindBy(xpath="//*[@resource-id='android:id/message'][@text='New PIN']")
	public WebElement Input_NewPIN_Screen;
	
	@FindBy(xpath="//*[@resource-id='android:id/message'][@text='Input again']")
	public WebElement Input_Again_Screen;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Applications']")
	public WebElement Applications_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Aplicaciones']")
	public WebElement Applications_option_spanish;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Features']")
	public WebElement Features_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Caracteristicas']")
	public WebElement Features_option_spanish;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Change PIN']")
	public WebElement Change_PIN_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Cambiar el PIN']")
	public WebElement Change_PIN_option_spanish;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Help']")
	public WebElement Help_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Ayuda']")
	public WebElement Help_option_spanish;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/tv_help_description'][@class='android.widget.TextView']")
	public WebElement Help_description;
	
	@FindBy(xpath="//*[contains(@text, 'Settings')]")
	public WebElement settings_option;
	
	@FindBy(xpath="//*[contains(@text, 'Configuración')]")
	public WebElement settings_option_Spanish;
	
	@FindBy(xpath="//*[contains(@text, 'Security')]")
	public WebElement security_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Safe Guard']")
	public WebElement Safe_Guard_option;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='Camera']")
	public WebElement SG_Cam_option;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.borqs.launcher:id/icon_text'][@text='Camera']")
	public WebElement Camera_App; 
	
	@FindBy(xpath="//*[@resource-id='com.sonim.borqs.launcher:id/icon_text'][@text='Messaging']")
	public WebElement Messaging_App; 
	
	@FindBy(xpath="//*[@resource-id='android:id/action_bar_title'][@text='Messaging']")
	public WebElement Messaging_bar_title; 
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/textView'][@text='Enter PIN']")
	public WebElement Enter_PIN;
	
	@FindBy(id="com.borqs.camera:id/photo_capture")
	public WebElement Camera_Capture_btn;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@class='android.widget.TextView']")
	public List<WebElement> SG_Apps_List;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/check_box'][@class='android.widget.CheckBox']")
	public List<WebElement> SG_Apps_List_chkbox;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/check_box'][@class='android.widget.CheckBox'][@checked='true']")
	public WebElement SG_Apps_List_camera_chkbox_checked;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/check_box'][@class='android.widget.CheckBox'][@checked='false']")
	public WebElement SG_Apps_List_camera_chkbox_Unchecked;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='Camera']")
	public WebElement SG_Apps_Camera;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='Contacts']")
	public WebElement SG_Apps_Contacts;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='Browser']")
	public WebElement SG_Apps_Browser;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='Music']")
	public WebElement SG_Apps_Music;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='Downloads']")
	public WebElement SG_Apps_Downloads;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='Messaging']")
	public WebElement SG_Apps_Messaging;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='FM Radio']")
	public WebElement SG_Apps_FMRadio;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='Settings']")
	public WebElement SG_Apps_Settings;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='Gallery']")
	public WebElement SG_Apps_Gallery;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name']][@text='Dialer']")
	public WebElement SG_Apps_Dialer;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='Sound Recorder']")
	public WebElement SG_Apps_SoundRecorder;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='File Explorer']")
	public WebElement SG_Apps_FileExplorer;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='Backup and Restore']")
	public WebElement SG_Apps_BackUpAndRestore;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='SonimSetupwizard]")
	public WebElement SG_Apps_SonimSetupWizard;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/check_box'][@class='android.widget.CheckBox'][@bounds='[203,77][235,109]'][@checked='true']")
	public WebElement SG_apps_Camera_chkbox_checked;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/check_box'][@class='android.widget.CheckBox'][@bounds='[203,77][235,109]'][@checked='false']")
	public WebElement SG_apps_Camera_chkbox_UnChecked;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@text='Messaging']")
	public WebElement SG_apps_Messaging_chkbox;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Save']")
	public WebElement SG_apps_Save_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Cancel']")
	public WebElement SG_apps_Cancel_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Select All']")
	public WebElement SG_apps_SelectAll_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Unselect All']")
	public WebElement SG_apps_UnselectAll_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Features']")
	public WebElement SG_Features_option;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/app_name'][@class='android.widget.TextView']")
	public List <WebElement> SG_Features_list;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/check_box'][@class='android.widget.CheckBox'][@checked='true']")
	public WebElement SG_Features_ModifyPhnbk_Chkbox_enabled;
	
	@FindBy(xpath="//*[@resource-id='com.sonim.safeguard:id/check_box'][@class='android.widget.CheckBox'][@checked='false']")
	public WebElement SG_Features_ModifyPhnbk_Chkbox_disabled;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Change PIN']")
	public WebElement SG_ChangePIN_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Language & input']")
	public WebElement Settings_LanguageNinput_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Teclado e idioma']")
	public WebElement Settings_LanguageNinput_option_Spanish;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Language']")
	public WebElement Settings_Language_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@text='Idioma']")
	public WebElement Settings_Language_option_Spanish;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@class='android.widget.TextView'][@text='Display']")
	public WebElement Display_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/title'][@class='android.widget.TextView'][@text='Sleep']")
	public WebElement Display_Sleep_option;
	
	@FindBy(xpath="//*[@resource-id='android:id/text1'][@text='15 seconds']")
	public WebElement Display_Sleep_15_Seconds_option;
	
	@FindBy(xpath="//*[@resource-id='com.android.keyguard:id/lockscreen_longpress_star_unlock_view'][@text='Press & hold ￼ to unlock.']")
	public WebElement DeviceLock_PressnholdUI_option;
	
	
	
}
