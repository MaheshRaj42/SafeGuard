package SG_Generic_Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SG_UtilityClass {
	
	public String Reading_Properties(String Skey) throws IOException {
		
		FileInputStream fis = new FileInputStream("June.properties");
		Properties prop = new Properties();
		
		prop.load(fis);
		return prop.getProperty(Skey);
		
	}

}
