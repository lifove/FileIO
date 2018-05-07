package edu.handong.csee.java.example.binarydemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class BinaryOutputDemo {

	public static void main(String[] args) {
		BinaryOutputDemo demonstrator = new BinaryOutputDemo();
		demonstrator.run();
	}

	private void run() {
		String fileName = "numbers.dat";
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(
					new FileOutputStream(fileName));
			Scanner keyboard = new Scanner(System.in);
			
			System.out.println("Enter nonnegative integers.");
			System.out.println("Place a negative number at the end");
			
			int anInteger;
			do {
				anInteger = keyboard.nextInt();
				outputStream.writeInt(anInteger);
			} while (anInteger >= 0);
			
			System.out.println("Numbers and sentinel value");
			System.out.println("Written to the file " + fileName);
			outputStream.close();
			
			keyboard.close();
		} catch(FileNotFoundException e) {
			System.out.println("Problem opening the file " + fileName);
		} catch (IOException e) {
			System.out.println("Problem with output to file " + fileName);
		}
		
	}

}
