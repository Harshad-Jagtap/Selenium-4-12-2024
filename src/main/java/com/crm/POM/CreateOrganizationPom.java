package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPom {

	public CreateOrganizationPom(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement plusicon;
	
	@FindBy(xpath = "//input[@name='accountname']")
    private WebElement OrganizationName;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDropdown;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
	private WebElement savebtn;
	
	
	public void plusbutton()
	{
		plusicon.click();
	}
	public void organizationName(String name)
	{	
		OrganizationName.sendKeys(name);
	}
	public void savebutton()
	{
		savebtn.click();
	}

	public void dropdownMenu()
	{
		industryDropdown.click();
	}
}
