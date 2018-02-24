
package Efiserve;
import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xpath.compiler.Keywords;
import org.junit.Test;
import org.openqa.selenium.WebElement;
public class serve_admin_central 
{
	@Test
	public void test1() throws IOException, AWTException, InterruptedException
	{
		keywords key=new keywords();
		ArrayList a=new ArrayList();
		String x=System.getProperty("user.dir");
		System.out.println("Working Directory = " + x);
	    String str2="\\src\\testcases\\selfserve.xlsx";
		String str3=x+str2;
		FileInputStream file=new FileInputStream(str3);
		XSSFWorkbook wbks=new XSSFWorkbook(file);
		Sheet s= wbks.getSheet("Teststeps");
		Iterator itr = s.iterator();
		while(itr.hasNext())
		{
		Row rowitr=(Row)itr.next();
		Iterator cellitr=rowitr.cellIterator();
		while(cellitr.hasNext())
		{
		Cell Celldata=(Cell)cellitr.next();	
		switch(Celldata.getCellType())
		{
		case Cell.CELL_TYPE_STRING:
			a.add(Celldata.getStringCellValue());
			break;
		case Cell.CELL_TYPE_NUMERIC:
			a.add(Celldata.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			a.add(Celldata.getBooleanCellValue());
			break;
		}
		}
		}
              for (int i=0;i<a.size();i++)
              {
			
			if (a.get(i).equals("openbrowser")) 
			{
				String keyword=(String)a.get(i);
				String data=(String)a.get(i+1);
				String objectname=(String)a.get(i+2);
				String runmode=(String)a.get(i+3);
//				System.out.println(keyword);
//				System.out.println(data);
//				System.out.println(objectname);
//				System.out.println(runmode);
				if(runmode.equals("yes"))
				{
				key.openbrowser();
				System.out.println("---------------------------------");
			    }
			}
			if (a.get(i).equals("navigate")) 
			{
				String keyword=(String)a.get(i);
				String data=(String)a.get(i+1);
				String objectname=(String)a.get(i+2);
				String runmode=(String)a.get(i+3);
//				System.out.println(keyword);
//              System.out.println(data);
//				System.out.println(objectname);
//				System.out.println(runmode);
				if(runmode.equals("yes"))
				{
				key.navigate(data);
				System.out.println("---------------------------------");
			    }
			}
			if (a.get(i).equals("click")) 
			{
				String keyword=(String)a.get(i);
				String data=(String)a.get(i+1);
				String objectname=(String)a.get(i+2);
				String runmode=(String)a.get(i+3);
				System.out.println(keyword);
				System.out.println(data);
				System.out.println(objectname);
				System.out.println(runmode);
				if(runmode.equals("yes"))
				{
				key.click(objectname);
				System.out.println("---------------------------------");
			    }
			}
			if (a.get(i).equals("input")) 
			{
				String keyword=(String)a.get(i);
				String data=(String)a.get(i+1);
				String objectname=(String)a.get(i+2);
				String runmode=(String)a.get(i+3);
//				System.out.println(keyword);
//				System.out.println(data);
//				System.out.println(objectname);
//				System.out.println(runmode);
				if(runmode.equals("yes"))
				{
					key.input(data,objectname);
					System.out.println("---------------------------------");
			    }
			}
			if (a.get(i).equals("addtax")) 
			{
				String keyword=(String)a.get(i);
				String data=(String)a.get(i+1);
				String objectname=(String)a.get(i+2);
				String runmode=(String)a.get(i+3);
				System.out.println(keyword);
				System.out.println(data);
				System.out.println(objectname);
			    System.out.println(runmode);
				if(runmode.equals("yes"))
				{
				 key.addtax(data,objectname);
				 System.out.println("---------------------------------");
			    }
			}
			
			if (a.get(i).equals("edittax")) 
			{
				Thread.sleep(10000);
				String keyword=(String)a.get(i);
				String data=(String)a.get(i+1);
				String data1=(String)a.get(i+2);
				String objectname=(String)a.get(i+3);
				String runmode=(String)a.get(i+4);
//				System.out.println(keyword);
//				System.out.println(data);
//				System.out.println(data1);
//				System.out.println(objectname);
//			    System.out.println(runmode);
				if(runmode.equals("yes"))
				{
				 key.edittax(data,objectname,data1);
				 System.out.println("---------------------------------");
			    }
			}
			
			if (a.get(i).equals("deletetax")) 
			{
				Thread.sleep(10000);
				String keyword=(String)a.get(i);
				String data=(String)a.get(i+1);
				String objectname=(String)a.get(i+2);
				String runmode=(String)a.get(i+3);
//				System.out.println(keyword);
//				System.out.println(data);
//				System.out.println(objectname);
//				System.out.println(runmode);
        		if(runmode.equals("yes"))   
				{
				 key.deletetax(data);
				 System.out.println("---------------------------------");
			    }
			}
//			if (a.get(i).equals("draganddrop")) 
//			{
//				String keyword=(String)a.get(i);
//				String data=(String)a.get(i+1);
//				String data1=(String)a.get(i+2);
//				String objectname =(String)a.get(i+3);
//				String runmode=(String)a.get(i+4);
//				String objectname1=(String)a.get(i+5);
//				System.out.println(keyword);
//				System.out.println(data);
//				System.out.println(data1);
//				System.out.println(objectname);
//				System.out.println(runmode);
//				System.out.println(objectname1);
//			  	if(runmode.equals("yes"))
//				{
//				 key.draganddrop(data,data1,objectname,objectname1);
//			    }
//			}
			if (a.get(i).equals("addproduct")) 
			{
				Thread.sleep(10000);
				String keyword=(String)a.get(i);
				String data=(String)a.get(i+1);
				String data1=(String)a.get(i+2);
				String objectname=(String)a.get(i+3);
				String runmode=(String)a.get(i+4);
//				System.out.println(keyword);
//				System.out.println(data);
//				System.out.println(data1);
//				System.out.println(objectname);
//			    System.out.println(runmode);
				if(runmode.equals("yes"))
				{
				 key.addproduct();
				 System.out.println("---------------------------------");
			    }
			}
			if (a.get(i).equals("editproduct")) 
			{
				String keyword=(String)a.get(i);
				double value=(double)a.get(i+1);
				int b = (int) value;
				String data=Integer.toString(b);
				double value1=(double)a.get(i+2);
				int c = (int) value1;
				String data1=Integer.toString(c);				
				String objectname=(String)a.get(i+3);
				String runmode=(String)a.get(i+4);
//				System.out.println(keyword);
//				System.out.println(data);
//				System.out.println(data1);
//				System.out.println(objectname);
//			    System.out.println(runmode);
				if(runmode.equals("yes"))
				{
				 key.editproduct(data,data1);
				 System.out.println("---------------------------------");
			    }
			}
			if (a.get(i).equals("deleteproduct")) 
			{
				String keyword=(String)a.get(i);
				double value=(double)a.get(i+1);
				int b = (int) value;
				String data=Integer.toString(b);
				String objectname=(String)a.get(i+3);
				String runmode=(String)a.get(i+4);
//				System.out.println(keyword);
//				System.out.println(data);
//				System.out.println(data1);
//				System.out.println(objectname);
//			    System.out.println(runmode);
				if(runmode.equals("yes"))
				{
				 key.deleteproduct(data);
				 System.out.println("---------------------------------");
			    }
			}
		
			
	}
}
}
