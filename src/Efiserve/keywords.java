package Efiserve;
import java.awt.RenderingHints.Key;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class keywords 
{	
	static FirefoxDriver driver;
	static Properties prop;
	static FileInputStream file;
	static int rows_count;
	static int row;
	static String data;
	static String data1;
	private String String;
	@Test
	public void openbrowser() throws IOException 
	{
		driver=new 	FirefoxDriver();
		driver.manage().window().maximize();
		ArrayList a=new ArrayList();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		String dir_path=System.getProperty("user.dir");
	   	String str2="\\src\\objectrepository\\objectrepository.properties";
		String str3=dir_path+str2;
		FileInputStream file=new FileInputStream(str3);
		prop=new Properties();
		prop.load(file);
	}
	public void navigate(String data) 
	{
		driver.get(data);
	}
	public void click(String objectname) throws InterruptedException 
	{
		Thread.sleep(10000);
		driver.findElement(By.id(prop.getProperty(objectname))).click();
		Thread.sleep(10000);
	}
	public void input(String data, String objectname) 
	{
	driver.findElement(By.id(prop.getProperty(objectname))).sendKeys(data);
	}
	//ADD OPERATION
	public void addtax(String data,String objectname) throws InterruptedException
		{
		
		WebElement table = driver.findElement(By.id("sortabletable"));
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
		int rows_count=rows_table.size();
		List<String> rows_table_text = new ArrayList<String>();
		for(int row=0;row<rows_count;row++)
		{
			List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
		  	int column=1;
			String celtext = Columns_row.get(column).getText();
			rows_table_text.add( celtext );	
		 }
		System.out.println(rows_table_text);
		if (rows_table_text.contains(data))
		{
			System.out.println("Found the Element");			
		}
		else
		{
			System.out.println("Element Not Found");
 			driver.findElement(By.id(prop.getProperty(objectname))).click();
    		driver.findElement(By.id("input_taxauth")).sendKeys(data);
    		Thread.sleep(5000);
    		driver.findElement(By.id("newtaxauth_add_btn")).click();
    		Thread.sleep(5000);	    
		}
		System.out.println("Total elements present after add operation:"+rows_table_text);		
	}
	//EDIT OPERATION
	public void edittax(String data, String objectname,String data1) throws InterruptedException 
	{
		WebElement table = driver.findElement(By.id("sortabletable"));
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
		int rows_count=rows_table.size();
		List<String> rows_table_text = new ArrayList<String>();
		for(int row=0;row<rows_count;row++)
		{
			System.out.println(row);
			List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
		  	int column=1;
			String celtext = Columns_row.get(column).getText();
			rows_table_text.add(celtext );
			if (celtext.equals(data))
			{
				int row1=row+1;
				String s=Integer.toString(row1);
				String str1="html/body/div[4]/div[4]/div[4]/div[2]/div[1]/div[2]/div[1]/div[5]/div[5]/form/div/table/tbody/tr[";
				String str3="]/td[2]/input";
				String complete_xpath=str1+s+str3;
				driver.findElement(By.id(prop.getProperty(objectname))).click();
				driver.findElement(By.xpath(complete_xpath)).click();
				WebElement OriginalString=driver.findElement(By.xpath(complete_xpath));
				String actualstring=OriginalString.getAttribute("value");
				String replaceString=actualstring.replace(actualstring,data1);
				System.out.println(replaceString);
				driver.switchTo().activeElement().clear();
				driver.switchTo().activeElement().sendKeys(replaceString);			
	 			driver.findElement(By.id("taxauth_save_btn")).click();
	 			Thread.sleep(20000);
	 			break;
			}
			else
			{
				System.out.println("Element not found");
			}
    	 }
	}
	public void deletetax(String data) throws InterruptedException
	{
		WebElement table = driver.findElement(By.id("sortabletable"));
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
		int rows_count=rows_table.size();
		List<String> rows_table_text = new ArrayList<String>();
		for(int row=0;row<rows_count;row++)
		{
			System.out.println(row);
			List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
		  	int column=1;
			String celtext = Columns_row.get(column).getText();
			rows_table_text.add(celtext );
			if (celtext.equals(data))
			{	
			int row1=row+1;
			String s=Integer.toString(row1);
			String str1="html/body/div[4]/div[4]/div[4]/div[2]/div[1]/div[2]/div[1]/div[5]/div[5]/form/div/table/tbody/tr[";
			String str3="]/td[3]/div/ul/li/a/img";
			String complete_xpath=str1+s+str3;
			System.out.println(complete_xpath);
			Thread.sleep(5000);
			driver.findElement(By.xpath(complete_xpath)).click();
			Thread.sleep(5000);
			driver.findElement(By.id("taxauth_delete_yes_btn")).click();
			break;
		}
		else
		{
			System.out.println("No Element found to delete");
		}
		}
	}
	
	public void draganddrop(String data,String datat1,WebElement objectname,WebElement objectname1) throws InterruptedException
	{
		WebElement table = driver.findElement(By.id("sortabletable"));
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
		int rows_count=rows_table.size();
		List<String> rows_table_text = new ArrayList<String>();
		for(int row=0;row<rows_count;row++)
		{
			//System.out.println(rows_count);
			List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
		  	int column=1;
			String celtext = Columns_row.get(column).getText();
			rows_table_text.add(celtext );
			if (celtext.equals(data)) 
			{
			System.out.println("element found to drag");
			Actions builder = new Actions(driver);
			Thread.sleep(5000);
			builder.clickAndHold(objectname).build().perform();
			Thread.sleep(5000);
			builder.moveToElement(objectname1).build().perform();
			Thread.sleep(5000);
			builder.release(objectname1).build().perform();
			Thread.sleep(5000);
			//WebElement To =driver.findElement(By.xpath(complete_xpath));
			break;
			}
			else
				{
					System.out.println("element not present to drag and drop");
				}
			}
		}		
	
     // System.out.println("entering drag and dropppppppppppppppp loop");
//		WebElement To =driver.findElement(By.xpath(complete_xpath));
//		WebElement From =driver.findElement(By.xpath(complete_xpath1));
//		Actions builder = new Actions(driver);
//		Thread.sleep(5000);
//		builder.clickAndHold(From).build().perform();
//		Thread.sleep(5000);
//		builder.moveToElement(To).build().perform();
//		Thread.sleep(5000);
//		builder.release(To).build().perform();
//		Thread.sleep(5000);
//		Actions builder = new Actions(driver);
//		Action dragAndDrop = builder.clickAndHold(driver.findElement(By.xpath(complete_xpath))).moveToElement(driver.findElement(By.xpath(complete_xpath1))).release(driver.findElement(By.xpath(complete_xpath1))).build();
//		dragAndDrop.perform();
//		Action dragAndDrop = builder.clickAndHold(driver.findElement(By.xpath(complete_xpath)))
//		.moveToElement(driver.findElement(By.xpath(complete_xpath1)))
//		.release(driver.findElement(By.xpath(complete_xpath1)))
//		.build();
//		dragAndDrop.perform();
		//Thread.sleep(5000);

	//ADDING PRODUCTS TAX
	public void addproduct() 
	{
		driver.findElement(By.id("sku_name")).sendKeys(String.valueOf(1022));
		Select dropdown = new Select(driver.findElement(By.id("ProductCategoryType")));
		dropdown.selectByIndex(1);
		List<WebElement> checkbox = driver.findElements(By.id("copy_paper_size_chkbox"));
        ((WebElement) checkbox.get(1)).click();
        ((WebElement) checkbox.get(2)).click();
        driver.findElement(By.id("productDescFor11")).sendKeys("abc");
        driver.findElement(By.id("productDescFor6")).sendKeys("xyz");
        driver.findElement(By.id("newsku_add_btn")).click();
        driver.findElement(By.id("newsku_add_btn")).click();
     }
	//EDITING PRODUCTS TAX
	public void editproduct(String data,String data1) throws InterruptedException 
	{
		Thread.sleep(20000);
		List<WebElement> liElements = driver.findElements(By.xpath("//*[@id='productlisttbl']/li"));
		System.out.println(liElements.size());
		int size=liElements.size();
		List<String> rows_table_text = new ArrayList<String>();
		for (int i=1;i<=size;i++)
		{
			String str1="html/body/div[4]/div[4]/div[4]/div[2]/div[1]/div[2]/div[1]/div[6]/form[2]/div/div[3]/fieldset/div[1]/div/div/div[1]/ul/li[";
	    	String str2=Integer.toString(i);
	    	String str3="]";
	    	String complete_xpath=str1+str2+str3;
		    JavascriptExecutor je = (JavascriptExecutor) driver;
	    	WebElement element=driver.findElement(By.xpath(complete_xpath));
	    	je.executeScript("arguments[0].scrollIntoView(true);",element);
	    	String celtext=element.getText();
	 	    rows_table_text.add(celtext);
	    	String splited[] = celtext.split(" ");
   		    String text=splited[0];
		    String text1=splited[2];
		    if(text.equals(data))
		    {
				System.out.println("element found to edit");
				String s1="html/body/div[4]/div[4]/div[4]/div[2]/div[1]/div[2]/div[1]/div[6]/form[2]/div/div[3]/fieldset/div[1]/div/div/div[1]/ul/li[";
		    	String s2=Integer.toString(i);
		    	String s3="]/div/div[2]/a[1]";
		    	String xpath=s1+s2+s3;
		    	driver.findElement(By.xpath(xpath)).click();
		 		driver.findElement(By.id("edit_skuname")).click();
		    	WebElement OriginalString=driver.findElement(By.id("edit_skuname"));
				String actualstring=OriginalString.getAttribute("value");
				String replaceString=actualstring.replace(actualstring,data1);
				driver.switchTo().activeElement().clear();
				driver.switchTo().activeElement().sendKeys(replaceString);
				Select dropdown = new Select(driver.findElement(By.id("ProductCategoryType")));
				dropdown.selectByIndex(1);
//				List<WebElement> checkbox = driver.findElements(By.id("edit_papersize"));
//		        ((WebElement) checkbox.get(1)).click();
//		        ((WebElement) checkbox.get(2)).click();
		        driver.findElement(By.id("productDescFor11")).clear();
		        driver.findElement(By.id("productDescFor11")).sendKeys("abc");
		        driver.findElement(By.id("productDescFor6")).clear();
		        driver.findElement(By.id("productDescFor6")).sendKeys("xyz");
		        driver.findElement(By.id("sku_save_btn")).click();
		        break;
	      	 }
		    else
		    {
		    	System.out.println("Element not found to edit");
		    }
		    }
			}
	//DELETE of PRODUCT TAX
	public void deleteproduct(String data) throws InterruptedException 
	{
	Thread.sleep(20000);
		List<WebElement> liElements = driver.findElements(By.xpath("//*[@id='productlisttbl']/li"));
		System.out.println(liElements.size());
		int size=liElements.size();
		List<String> rows_table_text = new ArrayList<String>();
		for (int i=1;i<=size;i++)
		{
			String str1="html/body/div[4]/div[4]/div[4]/div[2]/div[1]/div[2]/div[1]/div[6]/form[2]/div/div[3]/fieldset/div[1]/div/div/div[1]/ul/li[";
	    	String str2=Integer.toString(i);
	    	String str3="]";
	    	String complete_xpath=str1+str2+str3;
		    JavascriptExecutor je = (JavascriptExecutor) driver;
	    	WebElement element=driver.findElement(By.xpath(complete_xpath));
	    	je.executeScript("arguments[0].scrollIntoView(true);",element);
	    	String celtext=element.getText();
	 	    rows_table_text.add(celtext);
	    	String splited[] = celtext.split(" ");
   		    String text=splited[0];
		    String text1=splited[2];
		    if(text.equals(data))
		    {
				System.out.println("element found to delete");
				String a="html/body/div[4]/div[4]/div[4]/div[2]/div[1]/div[2]/div[1]/div[6]/form[2]/div/div[3]/fieldset/div[1]/div/div/div[1]/ul/li[";
				String b=Integer.toString(i);
				String c="]/div/div[2]/a[2]/input";
				String deletepath=a+b+c;
				driver.findElement(By.xpath(deletepath)).click();
				driver.findElement(By.id("deletesku_yes_btn")).click();
				break;
		    }
		    else
		    {
		    	System.out.println("deletion dint occur");
		    }
		}
		
	}
}



	
	


	
