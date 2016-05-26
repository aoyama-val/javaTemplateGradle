package javaTemplateGradle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Config {
	public int debugLevel;
	private static Config instance;
	
	protected Config() {
	}
	
	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}
	
	public void load(String filepath) throws Exception {
		InputStream is = new FileInputStream(filepath);
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader reader = new BufferedReader(isr);

		Properties properties = new Properties();
		properties.load(reader);
		
		this.debugLevel = Integer.parseInt(properties.getProperty("debugLevel", "0"));
	}
}
