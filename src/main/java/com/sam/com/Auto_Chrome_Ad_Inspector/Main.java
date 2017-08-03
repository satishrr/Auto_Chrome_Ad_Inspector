package com.sam.com.Auto_Chrome_Ad_Inspector;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Driver;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.DesiredCapabilities;
 

public class Main {
	static ChromeDriver driver;
public static void main(String[] args) throws  Exception{
	
	
File file= new File(System.getProperty("user.dir")+"/src/main/java/Resource/xpath.properties");
FileInputStream fis = new FileInputStream(file);
Properties prop= new Properties();
prop.load(fis);
System.out.print(prop.getProperty("sam"));

System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome_driver_path"));
ChromeOptions options = new ChromeOptions();
options.addExtensions(new File(prop.getProperty("ai_file_path")));
DesiredCapabilities capabilities = new DesiredCapabilities();

capabilities.setCapability(ChromeOptions.CAPABILITY, options);
  driver = new ChromeDriver(capabilities);
driver.get(prop.getProperty("ai_extenstion_url"));
Thread.sleep(4000);
driver.findElementById(prop.getProperty("auto_start")).click();
Thread.sleep(4000);
driver.findElementById(prop.getProperty("aiOptionsTxtAuthKey")).sendKeys(prop.getProperty("ai_key"));
Thread.sleep(4000);
driver.findElementById(prop.getProperty("aiOptionsConfirmButton")).click();
Thread.sleep(4000);
driver.findElementById(prop.getProperty("aiOptionsSaveButton")).click();

driver.get("http://wyff4.com");

Thread.sleep(4000);
driver.get("http://wyff4.com");
Thread.sleep(4000);


while(!(driver.getPageSource().contains("pubmatic")))
{
	System.out.println("Waiting for pubmatic Ad.........");
	Thread.sleep(4000);
	
	driver.get("http://wyff4.com");
    
}
getscreenshot();
 
//uninstall_ai();
Thread.sleep(50000);
 
driver.close();
}  


public static void uninstall_ai() throws Exception 
{
	DesiredCapabilities capabilities_to_uninstall = new DesiredCapabilities();
	Thread.sleep(2000);
	driver.get("chrome://extensions/");
	Thread.sleep(2000);
	driver= new ChromeDriver(capabilities_to_uninstall);
	Thread.sleep(2000);
	driver.get("chrome://extensions/");
	Thread.sleep(10000);
	 
	
}
public static void getscreenshot() throws Exception 
{
	Thread.sleep(4000);
    driver.findElementByXPath("//*[@id=\"adinsp_summary_tbl\"]/tr[2]/td[3]").click();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
        
        //code to email
        Thread.sleep(2000);
       driver.findElementByName("pm_client_email").click();
       Thread.sleep(6000);
      //code to email here
       
       String master = driver.getWindowHandle();

       driver.findElementByName("pm_client_email").click();

        
       
       
}


}