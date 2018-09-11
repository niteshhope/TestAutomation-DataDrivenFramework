package com.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.util.SystemOutLogger;

public class TestProperties {
	
 public static void main(String[] args) throws IOException
 {
	 Properties config = new Properties();
	 FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\Config.properties");
	 System.out.println(System.getProperty("user.dir"));
	 config.load(fis);
     System.out.println(config.getProperty("browser"));
   
     Properties OR = new Properties();
     FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\OR.properties");
      OR.load(fis1);
     //driver.findelement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
     System.out.println(OR.getProperty("bmlBtn"));
 }
}
