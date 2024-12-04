package Organization;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;
import com.crm.POM.CreateOrganizationPom;
import com.crm.POM.HomePagePOM;

public class CreateOrganization extends BaseClass {

	@Test
	public void organization() throws InterruptedException
	{
		HomePagePOM page=new HomePagePOM(driver);
		
		page.organizationsLink();
		
		CreateOrganizationPom createorg =new CreateOrganizationPom(driver);
		
		String name="harshad"+(int)(Math.random()*1000);
		
		createorg.plusbutton();
		createorg.organizationName(name);

		createorg.dropdownMenu();
		
		WebElement industryDropdown;
		Select s=new Select(driver.findElement(By.xpath("//select[@name='industry']")));
		{
			s.selectByValue("Engineering");
		}
		
		createorg.savebutton();
		
		String expectadeName = driver.findElement(By.xpath("//div[@class='small']//span[1]")).getText();
		Thread.sleep(2000);
		System.out.println(expectadeName);
		Thread.sleep(2000);
		assertTrue(expectadeName.contains(name), "Failed to Create Organization");
		Thread.sleep(2000);
		System.out.println("Successfully Organizaton Created ");
				
	}
}
