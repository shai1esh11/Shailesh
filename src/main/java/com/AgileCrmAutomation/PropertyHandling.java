package com.AgileCrmAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandling {
	
	
	 Properties properties;
	 PropertyHandling() throws IOException
	{
		String filePath= System.getProperty("user.dir")+"//config.properties";
		FileInputStream input = new FileInputStream(filePath);
	     properties = new Properties();
	    properties.load(input);

	}
	
    public String getValue(String value) {
    	
    	properties.put("Envoirment","Windows 10");
    	System.out.println(properties.getProperty("Envoirment"));
    	return properties.getProperty(value);
    }
    
    public static void main(String[]args) throws IOException
    {
    	PropertyHandling propertyHandling= new PropertyHandling();
    	String prop=propertyHandling.getValue("browser");
    	System.out.println(prop);
    }
}