package com.Pages;

import com.BaseClass.Festicket.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    public String actualresult;

    @FindBy(xpath = "//div[@class='styles__c-dtm4dw-0 hgEaOx']")
    private WebElement loginbutton;
    @FindBy(xpath = "//input[@id='emailInput']")
    private WebElement useremail;
    @FindBy(xpath = "//input[@id='passwordInput']")
    private WebElement password;
    @FindBy(xpath = "//button[@id='submitButton']")
   private WebElement submitbutton;
    @FindBy(xpath = "//div[@id='root']/main/nav/ul/li[6]/div/div/div[1]/span")
    WebElement loginprofile;
    @FindBy(xpath = "//div[@id='root']/main/nav/ul/li[6]/div/div/div[2]/a/div/h3")
    WebElement myaccount;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/h1")
    WebElement usertext;
    @FindBy(xpath = "/html/body/header/div[3]/button")
    WebElement userprofile;
    @FindBy(xpath = "//a[@href='/logout/']")
    WebElement logoutbutton;
    public LoginPage(){
    PageFactory.initElements(driver, this);
}

public void setLoginbutton(){
    loginbutton.click();
}
public WebElement loginusername(String user_name) {

        useremail.sendKeys(user_name);
    return useremail;
}
public String loginpassword(String password1) {

password.sendKeys(password1);
    return password1;
}

    public void submit() {
        submitbutton.click();
    }


public void validateuser()
{
loginprofile.click();
myaccount.click();
 actualresult=usertext.getText();

}
public void logoutuser() throws InterruptedException {
    userprofile.click();
    Thread.sleep(1000);
    logoutbutton.click();
}
}

