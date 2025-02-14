package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class Screenshots extends TestBase {
	
	public static String getDateTime() {
		return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
	}
	public static void screenshot(String nameOfMethod) throws IOException {
		
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Users\\Lenovo\\eclipse-workspace\\OctoberbatchMavenProjectsAutomation\\ScreenShots\\"+nameOfMethod+"--"+getDateTime()+".jpeg");
		FileHandler.copy(source, dest);
	}
	

}
