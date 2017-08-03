
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class AppTest
{
public static void main(String ar[])
{ 
	try
	{
	//URL urlToHtmlFile= new URL ("http://clients2.google.com/service/update2/crx?response=redirect&x=id%3Dbcoiicjlhhcpobdfooebcghljocaaglm%26uc&prodversion=32");
	 
		URL urlToHtmlFile= new URL	("https://clients2.google.com/service/update2/crx?response=redirect&prodversion=49.0&x=id%3Dbcoiicjlhhcpobdfooebcghljocaaglm%26installsource%3Dondemand%26uc");
		File destination = new File("ai2.crx");
		FileUtils.copyURLToFile(urlToHtmlFile,destination );
		 
		BufferedReader in = new BufferedReader(new FileReader("ai2.crx"));
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
