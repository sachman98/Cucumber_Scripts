package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";

	public ConfigFileReader() {
		try (BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {
			properties = new Properties();
			properties.load(reader); // Properly initialize reader and load properties
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public long getImplicitlyWait() {
		String ImplicitlyWait = properties.getProperty("implicitlyWait");
		if (ImplicitlyWait != null) {
			return Long.parseLong(ImplicitlyWait);
		} else {
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
		}
	}

	public String getCSVPath() {
		String CSVfilePath = properties.getProperty("CSVfilePath");
		if (CSVfilePath != null)
			return CSVfilePath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

}
