package com.ariat.Tests.Base;


import org.testng.annotations.Test;
import com.ariat.Utils.KillChrome;


/**
 * Test create account by instantiating the browser, go to Home page, and calls
 * all the methods such as: create account, login, check order status for Austria
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class KillChromeTests {
	@Test(priority = 0)
	public void killChrome() {
		KillChrome kill = new KillChrome();
			kill.killChrome();
		}
	}

