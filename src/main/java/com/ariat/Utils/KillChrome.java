package com.ariat.Utils;

import java.io.IOException;

public class KillChrome  
{ 
	public void killChrome() {
				 try {
			     Process process = Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			     } catch (IOException e) {
			       e.printStackTrace();
			     }
		 }
}	 