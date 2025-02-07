package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

public class HandleDropDown {
	
	public static void handleDropDown(WebElement ele,String Value) {
		Select s=new Select(ele);
		s.selectByVisibleText(Value);
	}

}
