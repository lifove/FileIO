package edu.handong.csee.java.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileInputWithUserFileDemo {

	public static void main(String[] args) {
		TextFileInputWithUserFileDemo reader = new TextFileInputWithUserFileDemo();
		reader.run(args);

	}

	private void run(String[] args) {
        String fileName = args[0]; // get a file path from CLI arguments
        
        System.out.println("FileName: " + fileName);
		
		Scanner inputStream = null;
		System.out.println ("The file " + fileName + "\ncontains the following lines:\n");
		
		try {
			inputStream = new Scanner(new File(fileName));
		}  catch (FileNotFoundException e) {
			System.out.println ("Error opening the file " + fileName);
			System.exit (0);
		}
		
		while (inputStream.hasNextLine ()) {
			String line = inputStream.nextLine ();
			System.out.println (line);
		}
		inputStream.close ();
	}

}
