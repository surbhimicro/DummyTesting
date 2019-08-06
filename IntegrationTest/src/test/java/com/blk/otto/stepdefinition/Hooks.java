package com.blk.otto.stepdefinition;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.blk.otto.utilities.Utility;

import io.cucumber.java.Before;

/**
 * @author chbakliw
 *
 */
public class Hooks {

	public static InputStream inpStream = null;
	private Utility utility;
	private Properties prop;

	private static boolean beforeSuit = true;

	@Before
	public void beforeAll() throws IOException {
		if (beforeSuit) {

			readConfigProperty();
			System.out.println("BeforeAll....");
			beforeSuit = false;
			prop = new Properties();
			utility = new Utility();
		}
	}

	/**
	 * return already created object of Utility class.
	 * @return Utility
	 */
	public Utility getUtilityObject() {
		if (utility == null)
			utility = new Utility();
		return utility;
	}

	/**
	 * reads config property file
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

	/** Return value for corresponding property.
	 * @param property
	 * @return String
	 * @throws IOException
	 */
	public String getPropertyValue(String property) throws IOException {

		String value = prop.getProperty(property);
		if (value != null) {
			return value;
		} else
			throw new RuntimeException(property + " not specified in property file");
	}

}
