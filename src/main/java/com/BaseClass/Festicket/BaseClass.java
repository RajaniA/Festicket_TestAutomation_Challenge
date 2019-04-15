package com.BaseClass.Festicket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    //private final String Filepath=System.getProperty("C:\\Users\\rgandra2\\Desktop\\FesTicket_Challenge\\src\\main\\java\\com\\Properties\\config\\config.properties");
    FileInputStream fileInputStream=null;
    public static Properties properties=null;
    String Browsername;
    public static WebDriver driver;


    public WebDriver setup() throws Exception {
        try {
            fileInputStream=new FileInputStream("C:\\Users\\rgandra2\\Desktop\\FesTicket_Challenge\\src\\main\\java\\com\\Properties\\config\\config.properties");
            properties=new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Browsername=properties.getProperty("Browsername");
    if(Browsername.equalsIgnoreCase("chrome")){
    System.setProperty("webdriver.chrome.driver","C:\\Users\\rgandra2\\Drivers\\chromedriver.exe");
    driver=new ChromeDriver();

    }else if(Browsername.equalsIgnoreCase("firefox"))
    {
    System.setProperty("webdriver.gecko.driver","C:\\Users\\rgandra2\\Drivers\\geckodriver.exe");
    driver=new FirefoxDriver();

    }else if(Browsername.equalsIgnoreCase("IE")){
        System.setProperty("webdriver.IEDriverServer.driver","C:\\Users\\rgandra2\\Drivers\\IEDriverServer.exe");
        driver=new InternetExplorerDriver();
    }else {
        throw new Exception("Invalid BrowserName");
    }

    driver.get(properties.getProperty("Testing_url"));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("ImplicitWait")), TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
    return driver;


    }

}
