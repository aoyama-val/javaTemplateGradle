package javaTemplateGradle;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Gradleを使ったJavaプロジェクトのテンプレート.
 */
public class JavaTemplateGradle {
	private static String version = null;
	
	/**
	 * メイン
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		try {
			Config config = Config.getInstance();
			config.load(Paths.get(getJarDirectory(), "config.properties").toString());

			puts("version = " + getVersion());
			puts("debugLevel = " + config.debugLevel);

			// カレントディレクトリ表示
			String currentDirectory = System.getProperty("user.dir");
			puts("    currentDirectory = " + currentDirectory);
			puts("    jarDirectory = " + getJarDirectory());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * JARのあるディレクトリを返す.
	 * Eclipseでデバッグ実行している場合はbinのディレクトリを返す.
	 * @return ディレクトリのパス
	 */
	public static String getJarDirectory() {		
		try {
			// http://stackoverflow.com/questions/320542/how-to-get-the-path-of-a-running-jar-file
			File file = new File(JavaTemplateGradle.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
			String jarPath = file.getAbsolutePath();
			if (jarPath.endsWith(".jar")) {
				return file.getParent();
			} else {
				return jarPath;	// Eclipseでデバッグ実行している場合
			}
		} catch (Exception ex) {
			return "";
		}
	}
	
	/**
	 * コンソールに文字列を表示する.
	 * @param obj 表示するオブジェクト
	 */
	public static void puts(Object obj) {
		System.out.println(obj);
	}

	public static String getVersion() {
		if (version != null) {
			return version;
		}
		try {
			InputStream is = new JavaTemplateGradle().getClass().getClassLoader().getResourceAsStream("version.txt");
			if (is == null) {
				version = "Not Available";
			}
			else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				version = reader.readLine().trim();
			}
		} catch (Exception e) {
		}
		return version;
	}
	
}
