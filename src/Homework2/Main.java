package Homework2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;

public class Main {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\Zephyrus\\eclipse-workspace\\JavaAdvance");
		Main main = new Main();
		Locale currentLocale = null;
		System.out.println("Hello");
		
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("1-EN 2-DE");
		if(scanner1.hasNextInt()) {
			int loc = scanner1.nextInt();
			switch(loc) {
			case 2:
				currentLocale = new Locale("de", "DE");
				break;
			case 1:
				currentLocale = new Locale("en", "EN");
				break;
				
			}
		}


		ResourceBundle bundel = ResourceBundle.getBundle("Localization", currentLocale);


		boolean exit = false;
		System.out.println(bundel.getString("hello"));
		main.show(file);
		while (!exit) {
			if (scanner1.hasNextLine()) {
				String userInput = scanner1.nextLine();
				String[] splitInput = userInput.split(" ");
				switch (splitInput[0]) {
				case "..":
					file = new File(file.getParent());
					main.show(file);
					break;
				case "cd":
					for (File name : file.listFiles()) {
						if (name.getName().equals(splitInput[1])) {
							file = new File(file.getAbsolutePath() + "\\" + splitInput[1]);
						}
					}
					main.show(file);
					break;
				default:
					for (File name : file.listFiles()) {
						if (name.getName().equals(splitInput[0])) {
							main.readText(file.getAbsolutePath()+ "\\" + splitInput[0]);
						}
					}
					break;
				}
			}

		}
		scanner1.close();
	}

	public void show(File file) {
		for (File name : file.listFiles()) {
			if (name.isDirectory()) {
				System.out.println(name.getName());
			}
		}
		for (File name : file.listFiles()) {
			if (name.isFile()) {
				System.out.println(name.getName());
			}
		}
	}

	public void readText(String str) {
		try (BufferedReader in = new BufferedReader(new FileReader(str));) {
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
