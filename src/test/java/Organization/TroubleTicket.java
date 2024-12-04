package Organization;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;
import com.crm.POM.HomePagePOM;
import com.crm.POM.TroubleTicketPom;


public class TroubleTicket extends BaseClass{

	@Test
	public void TroubTicket() throws InterruptedException
	{
		
		//it goes in home page login
	HomePagePOM page=new HomePagePOM(driver);
		
		page.troubleTicketsLink();
		
		//pom of trouble ticket from main java
		TroubleTicketPom tt=new TroubleTicketPom(driver);
        
		tt.plusbtn();
		tt.Title("issue in server");
		tt.dropdown();
		
		Select s=new Select(driver.findElement(By.xpath("//select[@name='ticketstatus']")));
		
		s.selectByValue("Wait For Response");
		
		tt.SaveBTN();
		
		Thread.sleep(2000);
		
		String expectedresult = driver.findElement(By.xpath("//div[@class=\"small\"]/table/tbody/tr/td/span")).getText();
		Thread.sleep(2000);
		assertTrue(expectedresult.contains("issue in server"));
		
		System.out.println("Successfully Trouble Ticket has been Created ");
		
	}
}
