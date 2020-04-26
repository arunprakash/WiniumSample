package com.winium.sample;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

/**
 * Hello world Winium Sample!
 *
 */
public class WiniumServiceSample {

	public static void main(String[] args) throws IOException, InterruptedException {
		String apppath = "C:\\Windows\\System32\\notepad.exe";

		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath(apppath);
		URL url = new URL("http://localhost:6050");


		WiniumDriver driver = new WiniumDriver(url, options);

		Thread.sleep(2000);
		getSomeTextToClipBoard();
		driver.findElementByName(String.valueOf("Edit")).click();
		driver.findElementByName(String.valueOf("Paste")).click();
		driver.findElementByName(String.valueOf("File")).click();
		driver.findElementByName(String.valueOf("Exit")).click();
		driver.findElementByName(String.valueOf("Don't Save")).click();

	}

	private static void getSomeTextToClipBoard() {
		String myString = "This text will be copied into clipboard when running this code!";
		StringSelection stringSelection = new StringSelection(myString);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
	}

}
