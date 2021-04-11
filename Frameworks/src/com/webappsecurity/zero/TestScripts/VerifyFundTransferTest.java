package com.webappsecurity.zero.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webappsecurity.zero.Pages.AccountSummary;
import com.webappsecurity.zero.Pages.Login;
import com.webappsecurity.zero.Pages.TransferFunds;
import com.webappsecurity.zero.Pages.TransferFundsConfirmation;
import com.webappsecurity.zero.Pages.TransferFundsVerify;

import utils.GenericMethods;

public class VerifyFundTransferTest extends Base {
	
	@Test
	public void verifyFundTransfer() throws IOException {
		Login lp = new Login(driver);
		AccountSummary acc = new AccountSummary(driver);
		TransferFunds tf = new TransferFunds(driver);
		TransferFundsVerify tfv = new TransferFundsVerify(driver);
		TransferFundsConfirmation tfc = new TransferFundsConfirmation(driver);
	
		String[][] data = GenericMethods.getData("D:\\Sel14Mar\\TestData.xlsx", "Sheet1");
		
		for(int i = 1;i<data.length;i++) {
			lp.applicationLogin(data[i][0], data[i][1]);
			driver.get("http://zero.webappsecurity.com/index.html");
			acc.clickTrasferFunds();
			tf.fundTransfer(data[i][2], data[i][3]);
			tfv.clickSubmit();
			String actualMsg = tfc.getConfText();
			String expectedMsg = data[i][4];
			Assert.assertEquals(actualMsg, expectedMsg);
			tfc.logoutFromApp();
			driver.get("http://zero.webappsecurity.com/login.html");
		}
	}
	

}
