package com.sam.com.Auto_Chrome_Ad_Inspector;

import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import net.sourceforge.htmlunit.corejs.javascript.GeneratedClassLoader;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.MouseEvent;

 

public class New_AI {
	static ChromeDriver driver;
	static Properties prop;
	private static Robot robo;
	 static String report_data=null;
	  
	  
public static void main(String[] args) throws  Exception{
	 
	 
//File file= new File("xpath.properties");
	  
	File file = new File("C:/Users/Satish/Desktop/Gc/xpath.properties");
FileInputStream fis = new FileInputStream(file);
  prop= new Properties();
prop.load(fis);
 
//downloading AI extenstion
download_ai_extenstion();
System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome_driver_path"));
ChromeOptions options = new ChromeOptions();
//options.addExtensions(new File(prop.getProperty("new_ai_file_path")));
options.addExtensions(new File("PubMatic_AdInspectior.crx"));
DesiredCapabilities capabilities = new DesiredCapabilities();

capabilities.setCapability(ChromeOptions.CAPABILITY, options);
  driver = new ChromeDriver(capabilities);
  robo= new Robot();
 Thread.sleep(5);
 driver.manage().window().maximize();
 driver.get("http://www.abc11.com/");
 driver.get("http://www.abc11.com/");
 //kclick(1281,40);
   kclick(1316,40);
                                      report_data="[ 'BCD-xxx', 'Installation of chrome', 'PASS', 'Installscreen.png', 'N/A' ],";
 Thread.sleep(5000);
  
  
 Thread.sleep(4000);
 //driver.findElementByXPath(prop.getProperty("user_name")).sendKeys(prop.getProperty("user_name_value"));

 driver.findElement(By.xpath("//*[@data-pm-id='aiLoginUName']")).sendKeys(prop.getProperty("user_name_value"));
 Thread.sleep(2000);
 driver.findElement(By.xpath("//*[@data-pm-id='aiLoginPwd']")).sendKeys(prop.getProperty("user_pass_value"));
 Thread.sleep(4000);
 driver.findElement(By.xpath("//*[@data-pm-id='aiLoginSubmit']")).click();
 Thread.sleep(5000);
 savescreen("afterlogin");
                                       report_data=report_data.concat("[ 'BCD-xxx', 'Login as admin into Ad Inspector', 'PASS', 'login.png', 'N/A' ],");
 
//uninstall_ai();
 //send_ai_support_mail
                                       send_ai_support_mail();
 
 //Generating report start......!
                                       System.out.println(report_data);
 
 report();
 
 
 //Generating report ends......!
Thread.sleep(50000);
 
driver.close();
}  
  
private static void report() {
	try {
		File file_html = new File("report.html");
		FileWriter fileWriter = new FileWriter(file_html);
		fileWriter.write(prop.getProperty("html_content"));
	 
		fileWriter.flush();
		fileWriter.close();
		
		File file_report_data= new File("one.js");
		FileWriter fileWriter2 = new FileWriter(file_report_data);
	String data=prop.getProperty("report_data");
	data=data.replace("arraydump",report_data);
		fileWriter2.write(data);
	 
		fileWriter2.flush();
		fileWriter2.close();
		//opening report file
     File report = new File("report.html");
		Desktop.getDesktop().open(report);
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
}

public static void kclick(int x ,int y)
{ driver.manage().window().maximize();
	robo.mouseMove(x, y);
	robo.delay(5);
	robo.mousePress(MouseEvent.BUTTON1_MASK);
	robo.mouseRelease(MouseEvent.BUTTON1_MASK);
	System.out.println("Clicked..@"+x+","+y);
}


public static void uninstall_ai() throws Exception 
{
	 
	 
	
}
public static void savescreen(String name) throws Exception 
{
	Thread.sleep(4000);
    
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("D:\\"+name+"+.png"));
        //code to email
        Thread.sleep(2000);
       Thread.sleep(6000);
      //code to email here
   
}

public static void send_ai_support_mail( ) throws Exception 
{
	driver.findElement(By.xpath("//*[@data-pm-id='aiPluginIssue']")).click();
	 Thread.sleep(3000);
	 savescreen("report_issue_popup");
	 Thread.sleep(3000);
	 
	 Select dropdown = new Select(driver.findElement(By.xpath("//*[@data-pm-id='aiPlugProb']")));
	 dropdown.selectByIndex(2);
	 
	 
	 driver.findElement(By.xpath("//*[@data-pm-id='aiPlugSendBtn']")).click();
	 report_data=report_data.concat("[ 'BCD-xxx', 'Report Issue with Plugin', 'PASS', 'report_issue_popup.png', 'N/A' ]");
	 Thread.sleep(9000);
	   
}

public static void  ad_overrelay_mail( ) throws Exception 
{
	 
	   
}
public static void download_ai_extenstion( ) throws Exception 
{
	
	try
	{
//	URL urlToHtmlFile= new URL ("http://clients2.google.com/service/update2/crx?response=redirect&x=id%3Dmenkifleemblimdogmoihpfopnplikde%26uc&prodversion=32");
	URL urlToHtmlFile= new URL	("https://clients2.google.com/service/update2/crx?response=redirect&prodversion=49.0&x=id%3Dbcoiicjlhhcpobdfooebcghljocaaglm%26installsource%3Dondemand%26uc");
		File destination = new File("PubMatic_AdInspectior.crx");
		FileUtils.copyURLToFile(urlToHtmlFile,destination );
		 
		BufferedReader in = new BufferedReader(new FileReader("PubMatic_AdInspectior.crx"));
		String line;
		String search ="https://";

		while((line =in.readLine())!=null)
		{
		if(line.toLowerCase().indexOf(search.toLowerCase())!=-1)
		break;
		}
		System.out.println("line with url is:"+line);
		String [] parts=line.split("\"");
		String directUrl=parts[1];
		System.out.println("DirectURL:"+directUrl );
		String appver = directUrl.substring(directUrl.indexOf("extension"),directUrl.length());
		System.out.println("App Name:"+appver );
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
	   
}




