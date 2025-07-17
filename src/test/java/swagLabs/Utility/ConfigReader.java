package swagLabs.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties props = new Properties();

	static {
		try {
			FileInputStream fis = new FileInputStream("resources/config.properties");
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return props.getProperty(key);
	}
}
