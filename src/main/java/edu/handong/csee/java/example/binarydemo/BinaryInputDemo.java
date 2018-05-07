package edu.handong.csee.java.example.binarydemo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BinaryInputDemo {

	public static void main(String[] args) {
		BinaryInputDemo demonstrator = new BinaryInputDemo();
		demonstrator.run();
	}

	private void run() {
		String fileName = "numbers.dat";
		
		try {
			ObjectInputStream inputStream = new ObjectInputStream(
								new FileInputStream(fileName));
			System.out.println("Reading the nonnegative integers");
			System.out.println("in the file " + fileName);
			int anInteger = inputStream.readInt();
			while(anInteger >= 0) {
				System.out.println(anInteger);
				anInteger = inputStream.readInt();
			}
			inputStream.close();
			System.out.println("End of reading from file.");
		} catch(FileNotFoundException e) {
			System.out.println("Problem opening the file " + fileName);
		} catch (EOFException e) {
			System.out.println("Problem reading the file " + fileName);
			System.out.println("Reached end of the file.");
		} catch (IOException e) {
			System.out.println("Problem reading the file " + fileName);
		}
	}
}
