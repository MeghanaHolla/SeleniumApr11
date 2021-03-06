package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {

	
	@Test
	public void verifyInvalidLogin() throws IOException {
		String[][] data = GenericMethods.getData("D:\\Sel14Mar\\TestData.xlsx", "Sheet2");
		Methods mtd = new Methods();
		for(int i = 1;i<data.length;i++) {
			switch(data[i][3]) {
			case "openBrowser":
				//Making changes after R1.1
				mtd.openBrowser();
				break;
			case "maxBrowser":
				mtd.maximizeBrowserWindow();
				break;
			case "impWait":
				mtd.implementImplicitWait();
				break;
			case "navigateToApp":
				mtd.navigateToApplication(data[i][6]);
				break;
			case "enterInTextbox":
				mtd.enterInTextBox(data[i][5], data[i][6]);
				break;
			case "clickSignIn":
				mtd.clickButton(data[i][4],data[i][5]);
				break;
			case "verifyErrMsg":
				String actualMsg = mtd.getMessage(data[i][4],data[i][5]);
				Assert.assertEquals(actualMsg, data[i][6]);
				break;
			case "closeApp":
				mtd.closeApplication();
				break;
				
			}
		}
	}
}
