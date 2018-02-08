package com.winium.sample;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

/**
 * Hello world Winium Sample!
 *
 */
public class WiniumSample {

	public static void main(String[] args) throws IOException, InterruptedException {
		String apppath = "C:\\Windows\\System32\\notepad.exe";
		String winiumdriverpath = "src\\main\\resources\\Winium.Desktop.Driver.exe";

		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath(apppath);
		File drivePath = new File(winiumdriverpath);

		WiniumDriverService service = new WiniumDriverService.Builder().usingDriverExecutable(drivePath).usingPort(9999)
				.withVerbose(true).withSilent(false).buildDesktopService();
		service.start();
		WiniumDriver driver = new WiniumDriver(service, options);

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
