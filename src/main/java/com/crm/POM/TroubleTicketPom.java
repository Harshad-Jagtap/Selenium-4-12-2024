package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketPom {

	public TroubleTicketPom(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@title='Create Ticket...']")
	private WebElement plusicon;
	
	@FindBy(xpath = "//textarea[@name='ticket_title']")
	private WebElement titlename;
	
	@FindBy(xpath = "//select[@name='assigned_user_id']")
	private WebElement dropdown;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
	private WebElement savebtn;
	
	
	public void plusbtn()
	{
		plusicon.click();
	}
	public void Title(String name)
	{
		titlename.sendKeys(name);
	}
	public void dropdown()
	{
		dropdown.click();
	}
	public void SaveBTN()
	{
		savebtn.click();
	}
}
