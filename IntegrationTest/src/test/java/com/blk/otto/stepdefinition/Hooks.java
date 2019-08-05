package com.blk.otto.stepdefinition;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.blk.otto.utilities.Utility;

import io.cucumber.java.Before;

public class Hooks {

	public static InputStream inpStream = null;
	public static Properties prop = new Properties();
	private String url;
	private Utility ulty;

	private static boolean beforeSuit = true;

	@Before
	public void beforeAll() throws IOException {
		if (beforeSuit) {

			readConfigProperty();
			System.out.println("BeforeAll....");
			beforeSuit = false;
		}
	}

	public Hooks() {
		ulty = new Utility();
	}

	public Utility getUtility() {
		
		return ulty;
	}

	/**
	 * parsing the config.properties file
	 * 
	 * @throws IOException
	 */
	public void readConfigProperty() throws IOException {
		try {
			inpStream = getClass().getClassLoader()
					.getResourceAsStream("com//blk//otto//TestData//Config//config.properties");
			if (inpStream != null)
				prop.load(inpStream);
			else
				throw new RuntimeException("Config file cannot found");
		} catch (IOException e) {
			System.out.println("Configuration properties file cannot be found");
		}

	}

	
	/**
	 * @return url from config.properties file
	 * @throws IOException
	 */
	public String getBaseUrl(String key) throws IOException {

		url = prop.getProperty(key);
		if (url != null) {
			return url;
		} else
			throw new RuntimeException("url not specified in property file");
	}

}
