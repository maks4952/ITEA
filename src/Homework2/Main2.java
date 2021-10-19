package Homework2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main2 {

	public static void main(String[] args) {
		try(BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Zephyrus\\eclipse-workspace\\JavaAdvance\\src\\Homework2\\file.txt"));){
			String line;
			while((line = in.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
